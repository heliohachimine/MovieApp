package com.example.helio.testmovie.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import com.example.helio.testmovie.ui.model.MovieDetailModel;

import java.util.ArrayList;


public class DBMovie {

    private static DBHelper dbHelper;

    public static void dbInit(Context context){ dbHelper = new DBHelper(context);}


    public static boolean isThereMovies() throws DBMovieException
    {
        if(dbHelper == null){
            throw new DBMovieException("DBMovie was not initialized");
        }
        SQLiteDatabase movieDB = dbHelper.getReadableDatabase();
        String query = "SELECT COUNT(*) FROM "+DBTableFields.MovieTable.TABLE_NAME+";";
        Cursor cursor = movieDB.rawQuery(query, null);
        cursor.moveToFirst();
        boolean test = (cursor.getInt(0)>0);
        cursor.close();
        movieDB.close();
        return test;
    }

    public static void insertMovie(MovieDetailModel movie) throws DBMovieException {
        if(dbHelper == null){
            throw new DBMovieException("DBMovie was not initialiazed!");
        }

        SQLiteDatabase movieDB = dbHelper.getWritableDatabase();

        try{
            movieDB.beginTransaction();

            // Movie para ContentValues
            ContentValues cv = new ContentValues();
            cv.put(DBTableFields.MovieTable.COL_TITLE, movie.getTitle());
            cv.put(DBTableFields.MovieTable.COL_YEAR, movie.getYear());
            cv.put(DBTableFields.MovieTable.COL_RELEASED, movie.getReleased());
            cv.put(DBTableFields.MovieTable.COL_RUNTIME, movie.getRuntime());
            cv.put(DBTableFields.MovieTable.COL_GENRE, movie.getGenre());
            cv.put(DBTableFields.MovieTable.COL_DIRECTOR, movie.getDirector());
            cv.put(DBTableFields.MovieTable.COL_WRITER, movie.getWriter());
            cv.put(DBTableFields.MovieTable.COL_ACTORS, movie.getActors());
            cv.put(DBTableFields.MovieTable.COL_PLOT, movie.getPlot());
            cv.put(DBTableFields.MovieTable.COL_COUNTRY, movie.getCountry());
            cv.put(DBTableFields.MovieTable.COL_IMDBRATING, movie.getImdbRating());
            cv.put(DBTableFields.MovieTable.COL_IMDBID, movie.getImdbID());

            // INSERT INTO movie (...);
            movieDB.insert(DBTableFields.MovieTable.TABLE_NAME,null, cv);

            movieDB.setTransactionSuccessful();
        } catch (SQLException e){
            throw new DBMovieException("SQLError during insertion: " + e.getMessage());
        } finally {
            movieDB.endTransaction();
            movieDB.close();
        }
    }
    //Pega o Array de Movies
    public static ArrayList<MovieDetailModel> getMovieInfo() throws DBMovieException{
        if(dbHelper == null){
            throw new DBMovieException("DBStalker was not initialiazed!");
        }

        ArrayList<MovieDetailModel> movies = new ArrayList<MovieDetailModel>();
        SQLiteDatabase movieDB = dbHelper.getReadableDatabase();

        String[] columns = new String[]{
                DBTableFields.MovieTable._ID,
                DBTableFields.MovieTable.COL_TITLE,
                DBTableFields.MovieTable.COL_RELEASED,
                DBTableFields.MovieTable.COL_YEAR,
                DBTableFields.MovieTable.COL_IMDBID,
                DBTableFields.MovieTable.COL_IMDBRATING,
                DBTableFields.MovieTable.COL_COUNTRY,
                DBTableFields.MovieTable.COL_PLOT,
                DBTableFields.MovieTable.COL_ACTORS,
                DBTableFields.MovieTable.COL_WRITER,
                DBTableFields.MovieTable.COL_DIRECTOR,
                DBTableFields.MovieTable.COL_GENRE,
                DBTableFields.MovieTable.COL_RUNTIME,
                DBTableFields.MovieTable.COL_POSTER,


        };

        Cursor cursor = movieDB.query(
                DBTableFields.MovieTable.TABLE_NAME,
                columns,
                null,
                null,
                null,
                null,
                null);

        while(cursor.moveToNext()){
            long id = cursor.getLong(cursor.getColumnIndex(DBTableFields.MovieTable._ID));
            String title = cursor.getString(cursor.getColumnIndex(DBTableFields.MovieTable.COL_TITLE));
            String released = cursor.getString(cursor.getColumnIndex(DBTableFields.MovieTable.COL_RELEASED));
            String year = cursor.getString(cursor.getColumnIndex(DBTableFields.MovieTable.COL_YEAR));
            String imdbid = cursor.getString(cursor.getColumnIndex(DBTableFields.MovieTable.COL_IMDBID));
            String imdbrating = cursor.getString(cursor.getColumnIndex(DBTableFields.MovieTable.COL_IMDBRATING));
            String country = cursor.getString(cursor.getColumnIndex(DBTableFields.MovieTable.COL_COUNTRY));
            String plot = cursor.getString(cursor.getColumnIndex(DBTableFields.MovieTable.COL_PLOT));
            String actors = cursor.getString(cursor.getColumnIndex(DBTableFields.MovieTable.COL_ACTORS));
            String writer = cursor.getString(cursor.getColumnIndex(DBTableFields.MovieTable.COL_WRITER));
            String director = cursor.getString(cursor.getColumnIndex(DBTableFields.MovieTable.COL_DIRECTOR));
            String genre = cursor.getString(cursor.getColumnIndex(DBTableFields.MovieTable.COL_GENRE));
            String runtime = cursor.getString(cursor.getColumnIndex(DBTableFields.MovieTable.COL_RUNTIME));
            String poster = cursor.getString(cursor.getColumnIndex(DBTableFields.MovieTable.COL_POSTER));

            MovieDetailModel movie = new MovieDetailModel(title, year, released, runtime, genre,
                    director, writer, actors, plot, country, poster, imdbrating, imdbid);
            movies.add(movie);
        }

        cursor.close();

        movieDB.close();

        return movies;
    }
}
