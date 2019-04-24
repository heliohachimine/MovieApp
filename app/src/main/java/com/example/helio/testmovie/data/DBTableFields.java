package com.example.helio.testmovie.data;

import android.provider.BaseColumns;

public class DBTableFields {

    public static final class MovieTable implements BaseColumns {
        public static final String TABLE_NAME = "movie";
        public static final String COL_TITLE = "p_title";
        public static final String COL_YEAR = "p_year";
        public static final String COL_RELEASED = "p_released";
        public static final String COL_RUNTIME = "p_runtime";
        public static final String COL_GENRE = "p_genre";
        public static final String COL_DIRECTOR = "p_director";
        public static final String COL_WRITER = "p_writer";
        public static final String COL_ACTORS = "p_actors";
        public static final String COL_PLOT = "p_plot";
        public static final String COL_COUNTRY = "p_country";
        public static final String COL_IMDBRATING = "p_imdb_rating";
        public static final String COL_IMDBID = "p_imdb_id";
        public static final String COL_POSTER = "p_poster";

        public static String createQuery() {
            return "CREATE TABLE " + TABLE_NAME + " (" +
                    _ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    COL_TITLE + " TEXT NOT NULL, " +
                    COL_YEAR + " TEXT, " +
                    COL_RELEASED + " TEXT, " +
                    COL_RUNTIME + " TEXT, " +
                    COL_GENRE + " TEXT, " +
                    COL_DIRECTOR + " TEXT, " +
                    COL_WRITER + " TEXT, " +
                    COL_ACTORS + " TEXT, " +
                    COL_PLOT + " TEXT, " +
                    COL_COUNTRY + " TEXT, " +
                    COL_IMDBRATING + " TEXT, " +
                    COL_IMDBID + " TEXT, " +
                    COL_POSTER + " TEXT" +
                    ");";
        }
    }
}
