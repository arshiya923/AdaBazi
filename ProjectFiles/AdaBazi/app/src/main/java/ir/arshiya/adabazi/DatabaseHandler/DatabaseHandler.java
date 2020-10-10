package ir.arshiya.adabazi.DatabaseHandler;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHandler extends SQLiteOpenHelper
{

    //Database Version
    private static final int DATABASE_VERSION = 1;
// Tables Start
    //Database Name
    private static final String DATABASE_NAME = "AdaBazi";

    // Category Table Name
    private static final String TABLE_CATEGORY =  "Category";

    // Category Table Columns Name
    private static final String TABLE_CATEGORY_KEY_ID =  "id";
    private static final String TABLE_CATEGORY_KEY_NAME =  "name";

    // Game Table Name
    private static final String TABLE_GAME =  "Game";

    // Game Table Columns Name
    private static final String TABLE_GAME_KEY_ID =  "id";
    private static final String TABLE_GAME_KEY_GAMEROUND_ID =  "gameround_id";
    private static final String TABLE_GAME_KEY_TEAM_ID =  "team_id";
    private static final String TABLE_GAME_KEY_RESULT =  "result";

    // GameRound Table Name
    private static final String TABLE_GAMEROUND =  "GameRound";

    // GameRound Table Columns Name
    private static final String TABLE_GAMEROUND_KEY_ID =  "id";
    private static final String TABLE_GAMEROUND_KEY_TIME_ID =  "time_id";
    private static final String TABLE_GAMEROUND_KEY_GAMETYPE_ID =  "gametype_id";
    private static final String TABLE_GAMEROUND_KEY_WORD_ID =  "word_id";

    // GameType Table Name
    private static final String TABLE_GAMETYPE =  "GameType";

    // GameType Table Columns Name
    private static final String TABLE_GAMETYPE_KEY_ID =  "id";
    private static final String TABLE_GAMETYPE_KEY_NAME =  "name";

    // TeamName Table Name
    private static final String TABLE_TEAMNAME =  "TeamName";

    // TeamName Table Columns Name
    private static final String TABLE_TEAMNAME_KEY_ID =  "id";
    private static final String TABLE_TEAMNAME_KEY_NAME =  "name";

    // Time Table Name
    private static final String TABLE_TIME =  "Time";

    // Time Table Columns Name
    private static final String TABLE_TIME_KEY_ID =  "id";
    private static final String TABLE_TIME_KEY_NAME =  "name";
    private static final String TABLE_TIME_KEY_DURATION =  "duration";

    // Word Table Name
    private static final String TABLE_WORD =  "Word";

    // Word Table Columns Name
    private static final String TABLE_WORD_KEY_ID =  "id";
    private static final String TABLE_WORD_KEY_NAME =  "name";
    private static final String TABLE_WORD_KEY_CATEGORY_ID =  "category_id";

// Table End

    public DatabaseHandler(Context context)
    {
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_CATEGORY_TABLE = "CREATE TABLE " +
                TABLE_CATEGORY + '(' +
                    TABLE_CATEGORY_KEY_ID + " INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT UNIQUE,\n" +
                    TABLE_CATEGORY_KEY_NAME + " TEXT NOT NULL UNIQUE)";

        String CREATE_GAME_TABLE = "CREATE TABLE " +
                TABLE_GAME + '(' +
                TABLE_GAME_KEY_ID + " INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT UNIQUE,\n" +
                TABLE_GAME_KEY_GAMEROUND_ID + " INTEGER NOT NULL,\n" +
                TABLE_GAME_KEY_TEAM_ID + " INTEGER,\n" +
                TABLE_GAME_KEY_RESULT + " TEXT,\n" +
                "FOREIGN KEY(\"gameround_id\") REFERENCES \"GameRound\"(\"id\")," +
                "FOREIGN KEY(\"team_id\") REFERENCES \"TeamName\"(\"id\"))";

        String CREATE_GAMEROUND_TABLE = "CREATE TABLE " +
                TABLE_GAMEROUND + '(' +
                TABLE_GAMEROUND_KEY_ID + " INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT UNIQUE,\n" +
                TABLE_GAMEROUND_KEY_TIME_ID + " INTEGER NOT NULL,\n" +
                TABLE_GAMEROUND_KEY_GAMETYPE_ID + " INTEGER NOT NULL,\n" +
                TABLE_GAMEROUND_KEY_WORD_ID + " INTEGER NOT NULL,\n" +
                "FOREIGN KEY(\"time_id\") REFERENCES \"Time\"(\"id\")," +
                "FOREIGN KEY(\"gametype_id\") REFERENCES \"GameType\"(\"id\")," +
                "FOREIGN KEY(\"word_id\") REFERENCES \"Word\"(\"id\"))";

        String CREATE_GAMETYPE_TABLE = "CREATE TABLE " +
                TABLE_GAMETYPE + '(' +
                TABLE_GAMETYPE_KEY_ID + " INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT UNIQUE,\n" +
                TABLE_GAMETYPE_KEY_NAME + " TEXT NOT NULL UNIQUE)";

        String CREATE_TEAMNAME_TABLE = "CREATE TABLE " +
                TABLE_TEAMNAME + '(' +
                TABLE_TEAMNAME_KEY_ID + " INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT UNIQUE,\n" +
                TABLE_TEAMNAME_KEY_NAME + " TEXT NOT NULL UNIQUE)";

        String CREATE_TIME_TABLE = "CREATE TABLE " +
                TABLE_TIME + '(' +
                TABLE_TIME_KEY_ID + " INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT UNIQUE,\n" +
                TABLE_TIME_KEY_NAME + " TEXT NOT NULL UNIQUE,\n" +
                TABLE_TIME_KEY_DURATION + " INTEGER NOT NULL)";

        String CREATE_WORD_TABLE = "CREATE TABLE " +
                TABLE_WORD + '(' +
                TABLE_WORD_KEY_ID + " INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT UNIQUE,\n" +
                TABLE_WORD_KEY_NAME + " TEXT NOT NULL UNIQUE,\n" +
                TABLE_WORD_KEY_CATEGORY_ID + " INTEGER NOT NULL,\n" +
                "FOREIGN KEY(\"catagory_id\") REFERENCES \"Category\"(\"id\")";

        db.execSQL(CREATE_CATEGORY_TABLE);
        db.execSQL(CREATE_GAME_TABLE);
        db.execSQL(CREATE_GAMEROUND_TABLE);
        db.execSQL(CREATE_GAMETYPE_TABLE);
        db.execSQL(CREATE_TEAMNAME_TABLE);
        db.execSQL(CREATE_TIME_TABLE);
        db.execSQL(CREATE_WORD_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        String DROP_CATEGORY_TABLE = "DROP TABLE IF EXISTS " + TABLE_CATEGORY;
        String DROP_GAME_TABLE = "DROP TABLE IF EXISTS " + TABLE_GAME;
        String DROP_GAMEROUND_TABLE = "DROP TABLE IF EXISTS " + TABLE_GAMEROUND;
        String DROP_GAMETYPE_TABLE = "DROP TABLE IF EXISTS " + TABLE_GAMETYPE;
        String DROP_TEAMNAME_TABLE = "DROP TABLE IF EXISTS " + TABLE_TEAMNAME;
        String DROP_TIME_TABLE = "DROP TABLE IF EXISTS " + TABLE_TIME;
        String DROP_WORD_TABLE = "DROP TABLE IF EXISTS " + TABLE_WORD;

        db.execSQL(DROP_CATEGORY_TABLE);
        db.execSQL(DROP_GAME_TABLE);
        db.execSQL(DROP_GAMEROUND_TABLE);
        db.execSQL(DROP_GAMETYPE_TABLE);
        db.execSQL(DROP_TEAMNAME_TABLE);
        db.execSQL(DROP_TIME_TABLE);
        db.execSQL(DROP_WORD_TABLE);

        onCreate(db);
    }
}
