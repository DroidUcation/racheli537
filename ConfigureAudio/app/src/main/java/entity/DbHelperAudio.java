package entity;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import entity.entries.SpeakerEntry;

/**
 * Created by user on 09/07/2016.
 */
public class DbHelperAudio extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "audio.db";
    public static final int DATABASE_VERSION = 1;

    public DbHelperAudio(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {

        super(context, name, factory, version);
        Log.d("**********in on create", "********");
    }

    public DbHelperAudio(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        Log.d("**********in db helper", "********");
    }

    @Override
    public void onOpen(SQLiteDatabase db) {
        super.onOpen(db);
        Log.d("a", "in on open SQLiteOpenHelper");
        //remove
        onUpgrade(db, 1, 2);
        onCreate(db);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
//        String select = "SELECT * FROM sqlite_master WHERE name ='" + SpeakerEntry.TBL_SPEAKERS + "' and type='table'; ";
//        Cursor c = db.rawQuery(select, null);
        String CREATE_SPEAKERS_TABLE =
                "CREATE TABLE IF NOT EXISTS " + SpeakerEntry.TBL_SPEAKERS + "("
                        + SpeakerEntry.ID + " INTEGER,"
                        + SpeakerEntry.NAME + " TEXT,"
                        + SpeakerEntry.STEREO + " TEXT,"
                        + SpeakerEntry.PLENUM + " TEXT,"
                        + SpeakerEntry.QUALITY + " TEXT,"
                        + SpeakerEntry.INSTALLATION + " TEXT,"
                        + SpeakerEntry.INCHES + " NUMERIC"
                        + ")";

//        String CREATE_AMP_TABLE = "CREATE TABLE " + TBL_AMP + "("
//                + AMP_ID + " INTEGER," + AMP_NAME + " TEXT,"
//                + AMP_PLENUM + " TEXT" + ")";
        db.execSQL(CREATE_SPEAKERS_TABLE);
        //db.execSQL(CREATE_AMP_TABLE);

        // init data
        if (getCountRowsTable(db, SpeakerEntry.TBL_SPEAKERS) <= 0)
            insertSpeakersData(db);
//            insertAmplifiersData(db);
//        long intCnt = getCountRowsTable(db, SpeakerEntry.TBL_SPEAKERS);

    }

    private long getCountRowsTable(SQLiteDatabase db, String tblName) {
        //SQLiteDatabase db = this.getReadableDatabase();
        long cnt  = DatabaseUtils.queryNumEntries(db, tblName);
        //db.close();
        return cnt;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + SpeakerEntry.TBL_SPEAKERS);
        //db.execSQL("DROP TABLE IF EXISTS " + TBL_AMP);
        // Creating tables again
        //onCreate(db);
    }

    private void insertSpeakersData(SQLiteDatabase db) {
        ContentValues values = new ContentValues();
        values.put(SpeakerEntry.ID, 735);
        values.put(SpeakerEntry.NAME, "Galil 6-I");
        values.put(SpeakerEntry.STEREO, "N");
        values.put(SpeakerEntry.PLENUM, "N");
        values.put(SpeakerEntry.QUALITY, SpeakerEntry.QUALITY_COM);
        values.put(SpeakerEntry.INSTALLATION, SpeakerEntry.INSTALLATION_IN_WALL);
        values.put(SpeakerEntry.INCHES, 6.5);
        // insert row
        db.insert(SpeakerEntry.TBL_SPEAKERS, null, values);

        values.clear();
        values.put(SpeakerEntry.ID, 2861);
        values.put(SpeakerEntry.NAME, "Yarden 6-ID");
        values.put(SpeakerEntry.STEREO, "Y");
        values.put(SpeakerEntry.PLENUM, "N");
        values.put(SpeakerEntry.QUALITY, SpeakerEntry.QUALITY_HP);
        values.put(SpeakerEntry.INSTALLATION, SpeakerEntry.INSTALLATION_IN_WALL);
        values.put(SpeakerEntry.INCHES, 6.5);
        // insert row
        db.insert(SpeakerEntry.TBL_SPEAKERS, null, values);

        values.clear();
        values.put(SpeakerEntry.ID, 2895);
        values.put(SpeakerEntry.NAME, "Galil 4-O");
        values.put(SpeakerEntry.STEREO, "N");
        values.put(SpeakerEntry.PLENUM, "N");
        values.put(SpeakerEntry.QUALITY, SpeakerEntry.QUALITY_COM);
        values.put(SpeakerEntry.INSTALLATION, SpeakerEntry.INSTALLATION_ON_WALL);
        values.put(SpeakerEntry.INCHES, 4);
        // insert row
        db.insert(SpeakerEntry.TBL_SPEAKERS, null, values);

        values.clear();
        values.put(SpeakerEntry.ID, 2896);
        values.put(SpeakerEntry.NAME, "Galil 5-O");
        values.put(SpeakerEntry.STEREO, "N");
        values.put(SpeakerEntry.PLENUM, "N");
        values.put(SpeakerEntry.QUALITY, SpeakerEntry.QUALITY_COM);
        values.put(SpeakerEntry.INSTALLATION, SpeakerEntry.INSTALLATION_ON_WALL);
        values.put(SpeakerEntry.INCHES, 5.25);
        // insert row
        db.insert(SpeakerEntry.TBL_SPEAKERS, null, values);

        values.clear();
        values.put(SpeakerEntry.ID, 2856);
        values.put(SpeakerEntry.NAME, "Galil 6-O");
        values.put(SpeakerEntry.STEREO, "N");
        values.put(SpeakerEntry.PLENUM, "N");
        values.put(SpeakerEntry.QUALITY, SpeakerEntry.QUALITY_COM);
        values.put(SpeakerEntry.INSTALLATION, SpeakerEntry.INSTALLATION_ON_WALL);
        values.put(SpeakerEntry.INCHES, 6.5);
        // insert row
        db.insert(SpeakerEntry.TBL_SPEAKERS, null, values);

        values.clear();
        values.put(SpeakerEntry.ID, 2137);
        values.put(SpeakerEntry.NAME, "Tavor 5-O");
        values.put(SpeakerEntry.STEREO, "N");
        values.put(SpeakerEntry.PLENUM, "N");
        values.put(SpeakerEntry.QUALITY, SpeakerEntry.QUALITY_HP);
        values.put(SpeakerEntry.INSTALLATION, SpeakerEntry.INSTALLATION_ON_WALL);
        values.put(SpeakerEntry.INCHES, 5.25);
        // insert row
        db.insert(SpeakerEntry.TBL_SPEAKERS, null, values);


        values.clear();
        values.put(SpeakerEntry.ID, 2857);
        values.put(SpeakerEntry.NAME, "Yarden 4-O");
        values.put(SpeakerEntry.STEREO, "N");
        values.put(SpeakerEntry.PLENUM, "N");
        values.put(SpeakerEntry.QUALITY, SpeakerEntry.QUALITY_HP);
        values.put(SpeakerEntry.INSTALLATION, SpeakerEntry.INSTALLATION_ON_WALL);
        values.put(SpeakerEntry.INCHES, 4);
        // insert row
        db.insert(SpeakerEntry.TBL_SPEAKERS, null, values);

        values.clear();
        values.put(SpeakerEntry.ID, 2858);
        values.put(SpeakerEntry.NAME, "Yarden 5-O");
        values.put(SpeakerEntry.STEREO, "Y");
        values.put(SpeakerEntry.PLENUM, "N");
        values.put(SpeakerEntry.QUALITY, SpeakerEntry.QUALITY_HP);
        values.put(SpeakerEntry.INSTALLATION, SpeakerEntry.INSTALLATION_ON_WALL);
        values.put(SpeakerEntry.INCHES, 5.25);
        // insert row
        db.insert(SpeakerEntry.TBL_SPEAKERS, null, values);

        values.clear();
        values.put(SpeakerEntry.ID, 2859);
        values.put(SpeakerEntry.NAME, "Yarden 6-O");
        values.put(SpeakerEntry.STEREO, "N");
        values.put(SpeakerEntry.PLENUM, "N");
        values.put(SpeakerEntry.QUALITY, SpeakerEntry.QUALITY_HP);
        values.put(SpeakerEntry.INSTALLATION, SpeakerEntry.INSTALLATION_ON_WALL);
        values.put(SpeakerEntry.INCHES, 6.5);
        // insert row
        db.insert(SpeakerEntry.TBL_SPEAKERS, null, values);

        values.clear();
        values.put(SpeakerEntry.ID, 2860);
        values.put(SpeakerEntry.NAME, "Yarden 6-OD");
        values.put(SpeakerEntry.STEREO, "N");
        values.put(SpeakerEntry.PLENUM, "N");
        values.put(SpeakerEntry.QUALITY, SpeakerEntry.QUALITY_COM);
        values.put(SpeakerEntry.INSTALLATION, SpeakerEntry.INSTALLATION_ON_WALL);
        values.put(SpeakerEntry.INCHES, 6.5);
        // insert row
        db.insert(SpeakerEntry.TBL_SPEAKERS, null, values);

        values.clear();
        values.put(SpeakerEntry.ID, 2847);
        values.put(SpeakerEntry.NAME, "Galil 4-C");
        values.put(SpeakerEntry.STEREO, "N");
        values.put(SpeakerEntry.PLENUM, "N");
        values.put(SpeakerEntry.QUALITY, SpeakerEntry.QUALITY_COM);
        values.put(SpeakerEntry.INSTALLATION, SpeakerEntry.INSTALLATION_CEILING);
        values.put(SpeakerEntry.INCHES, 4);
        // insert row
        db.insert(SpeakerEntry.TBL_SPEAKERS, null, values);

        values.clear();
        values.put(SpeakerEntry.ID, 2864);
        values.put(SpeakerEntry.NAME, "Galil 6-C");
        values.put(SpeakerEntry.STEREO, "N");
        values.put(SpeakerEntry.PLENUM, "N");
        values.put(SpeakerEntry.QUALITY, SpeakerEntry.QUALITY_COM);
        values.put(SpeakerEntry.INSTALLATION, SpeakerEntry.INSTALLATION_CEILING);
        values.put(SpeakerEntry.INCHES, 6.5);
        // insert row
        db.insert(SpeakerEntry.TBL_SPEAKERS, null, values);

        values.clear();
        values.put(SpeakerEntry.ID, 2848);
        values.put(SpeakerEntry.NAME, "Galil 8-C");
        values.put(SpeakerEntry.STEREO, "N");
        values.put(SpeakerEntry.PLENUM, "N");
        values.put(SpeakerEntry.QUALITY, SpeakerEntry.QUALITY_COM);
        values.put(SpeakerEntry.INSTALLATION, SpeakerEntry.INSTALLATION_CEILING);
        values.put(SpeakerEntry.INCHES, 8);
        // insert row
        db.insert(SpeakerEntry.TBL_SPEAKERS, null, values);

        values.clear();
        values.put(SpeakerEntry.ID, 2940);
        values.put(SpeakerEntry.NAME, "Galil 4-CO");
        values.put(SpeakerEntry.STEREO, "N");
        values.put(SpeakerEntry.PLENUM, "N");
        values.put(SpeakerEntry.QUALITY, SpeakerEntry.QUALITY_COM);
        values.put(SpeakerEntry.INSTALLATION, SpeakerEntry.INSTALLATION_CEILING);
        values.put(SpeakerEntry.INCHES, 4);
        // insert row
        db.insert(SpeakerEntry.TBL_SPEAKERS, null, values);

        values.clear();
        values.put(SpeakerEntry.ID, 2544);
        values.put(SpeakerEntry.NAME, "Galil 6-CO");
        values.put(SpeakerEntry.STEREO, "N");
        values.put(SpeakerEntry.PLENUM, "N");
        values.put(SpeakerEntry.QUALITY, SpeakerEntry.QUALITY_COM);
        values.put(SpeakerEntry.INSTALLATION, SpeakerEntry.INSTALLATION_CEILING);
        values.put(SpeakerEntry.INCHES, 6.5);
        // insert row
        db.insert(SpeakerEntry.TBL_SPEAKERS, null, values);

        values.clear();
        values.put(SpeakerEntry.ID, 2985);
        values.put(SpeakerEntry.NAME, "Galil 8-CO");
        values.put(SpeakerEntry.STEREO, "N");
        values.put(SpeakerEntry.PLENUM, "N");
        values.put(SpeakerEntry.QUALITY, SpeakerEntry.QUALITY_COM);
        values.put(SpeakerEntry.INSTALLATION, SpeakerEntry.INSTALLATION_CEILING);
        values.put(SpeakerEntry.INCHES, 8);
        // insert row
        db.insert(SpeakerEntry.TBL_SPEAKERS, null, values);

        values.clear();
        values.put(SpeakerEntry.ID, 2855);
        values.put(SpeakerEntry.NAME, "Tavor 8-T");
        values.put(SpeakerEntry.STEREO, "N");
        values.put(SpeakerEntry.PLENUM, "N");
        values.put(SpeakerEntry.QUALITY, SpeakerEntry.QUALITY_COM);
        values.put(SpeakerEntry.INSTALLATION, SpeakerEntry.INSTALLATION_CEILING_TILE);
        values.put(SpeakerEntry.INCHES, 8);
        // insert row
        db.insert(SpeakerEntry.TBL_SPEAKERS, null, values);

        values.clear();
        values.put(SpeakerEntry.ID, 2849);
        values.put(SpeakerEntry.NAME, "Yarden 4-C");
        values.put(SpeakerEntry.STEREO, "N");
        values.put(SpeakerEntry.PLENUM, "N");
        values.put(SpeakerEntry.QUALITY, SpeakerEntry.QUALITY_HP);
        values.put(SpeakerEntry.INSTALLATION, SpeakerEntry.INSTALLATION_CEILING);
        values.put(SpeakerEntry.INCHES, 4);
        // insert row
        db.insert(SpeakerEntry.TBL_SPEAKERS, null, values);

        values.clear();
        values.put(SpeakerEntry.ID, 2850);
        values.put(SpeakerEntry.NAME, "Yarden 6-C");
        values.put(SpeakerEntry.STEREO, "Y");
        values.put(SpeakerEntry.PLENUM, "N");
        values.put(SpeakerEntry.QUALITY, SpeakerEntry.QUALITY_HP);
        values.put(SpeakerEntry.INSTALLATION, SpeakerEntry.INSTALLATION_CEILING);
        values.put(SpeakerEntry.INCHES, 6.5);
        // insert row
        db.insert(SpeakerEntry.TBL_SPEAKERS, null, values);

        values.clear();
        values.put(SpeakerEntry.ID, 2851);
        values.put(SpeakerEntry.NAME, "Yarden 8-C");
        values.put(SpeakerEntry.STEREO, "N");
        values.put(SpeakerEntry.PLENUM, "N");
        values.put(SpeakerEntry.QUALITY, SpeakerEntry.QUALITY_HP);
        values.put(SpeakerEntry.INSTALLATION, SpeakerEntry.INSTALLATION_CEILING);
        values.put(SpeakerEntry.INCHES, 8);
        // insert row
        db.insert(SpeakerEntry.TBL_SPEAKERS, null, values);

        values.clear();
        values.put(SpeakerEntry.ID, 2852);
        values.put(SpeakerEntry.NAME, "Yarden 6-CH");
        values.put(SpeakerEntry.STEREO, "N");
        values.put(SpeakerEntry.PLENUM, "N");
        values.put(SpeakerEntry.QUALITY, SpeakerEntry.QUALITY_HP);
        values.put(SpeakerEntry.INSTALLATION, SpeakerEntry.INSTALLATION_CEILING);
        values.put(SpeakerEntry.INCHES, 6.5);
        // insert row
        db.insert(SpeakerEntry.TBL_SPEAKERS, null, values);

        values.clear();
        values.put(SpeakerEntry.ID, 2853);
        values.put(SpeakerEntry.NAME, "Yarden 8-CH");
        values.put(SpeakerEntry.STEREO, "N");
        values.put(SpeakerEntry.PLENUM, "N");
        values.put(SpeakerEntry.QUALITY, SpeakerEntry.QUALITY_HP);
        values.put(SpeakerEntry.INSTALLATION, SpeakerEntry.INSTALLATION_CEILING);
        values.put(SpeakerEntry.INCHES, 8);
        // insert row
        db.insert(SpeakerEntry.TBL_SPEAKERS, null, values);

//        2857	Yarden 4-O
//        2858	Yarden 5-O
//        2859	Yarden 6-O
//        2860	Yarden 6-OD
//        2847	Galil 4-C
//        2864	Galil 6-C
//        2848	Galil 8-C
//        2940	Galil 4-CO
//        2544	Galil 6-CO
//        2985	Galil 8-CO
//        2855	Tavor 8-T
//        2849	Yarden 4-C
//        2850	Yarden 6-C
//        2851	Yarden 8-C
//        2852	Yarden 6-CH
//        2853	Yarden 8-CH
    }
}

//SQLiteOpenHelper mali
/**
 //     * Created by user on 31/05/2016.
 //     */
//    public class GCDatabaseHelper extends SQLiteOpenHelper {
//
//        public static final String DATABASE_NAME = "giftCard.db";
//        public static final int DATABASE_VERSION = 1;
//
//        /**
//         * Sql create tables
//         */
//        private static final String SQL_CREATE_STORE_TBL = "CREATE TABLE " + StoreEntry.STORE_TBL + " ( " +
//                StoreEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
//                StoreEntry.NAME + " TEXT," +
//                StoreEntry.IS_CHAIN_STORE + " SMALLINT )";
//
//        private static final String SQL_CREATE_CARD_TYPE_TBL = "CREATE TABLE " + CardTypeEntry.CARD_TYPE_TBL + " ( " +
//                CardTypeEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
//                CardTypeEntry.NAME + " TEXT," +
//                CardTypeEntry.IMAGE + " INTEGER," +
//                CardTypeEntry.FOR_SPECIFIC_STORE + " SMALLINT )";
//
//        private static final String SQL_CREATE_STORE_CARD_TYPE_TBL = "CREATE TABLE " + StoreCardTypeEntry.STORE_CARD_TYPE_TBL + " ( " +
//                StoreCardTypeEntry.STORE_ID + " INTEGER , " +
//                StoreCardTypeEntry.CARD_TYPE_ID + " INTEGER )";
//
//        private static final String SQL_CREATE_USER_TBL = "CREATE TABLE " + UserEntry.USER_TBL + " ( " +
//                UserEntry._ID + " INTEGER , " +
//                UserEntry.FIRST_NAME + " TEXT , " +
//                UserEntry.LAST_NAME + " TEXT , " +
//                UserEntry.EMAIL + " TEXT , " +
//                UserEntry.PASSWORD + " TEXT )";
//
//        private static final String SQL_CREATE_CARD_TBL = "CREATE TABLE " + CardEntry.CARD_TBL + " ( " +
//                CardEntry._ID + " INTEGER , " +
//                CardEntry.CARD_TYPE_ID + " INTEGER , " +
//                CardEntry.IS_FOR_UNIQUE_STORE + " SMALLINT , " +
//                CardEntry.UNIQUE_STORE_NAME + " TEXT , " +
//                CardEntry.BALANCE + " DOUBLE , " +//TODO: check type
//                CardEntry.EXPIRATION_DATE + " DATETIME , " +
//                CardEntry.USER_ID + " INTEGER )";
//
//        /**
//         * Sql drop tables
//         */
//        private static final String SQL_DROP_STORE_TABLE =
//                "DROP TABLE IF EXISTS " + StoreEntry.STORE_TBL;
//
//        private static final String SQL_DROP_CARD_TYPE_TABLE =
//                "DROP TABLE IF EXISTS " + CardTypeEntry.CARD_TYPE_TBL;
//
//        private static final String SQL_DROP_STORE_CARD_TYPE_TABLE =
//                "DROP TABLE IF EXISTS " + StoreCardTypeEntry.STORE_CARD_TYPE_TBL;
//
//        private static final String SQL_DROP_USER_TABLE =
//                "DROP TABLE IF EXISTS " + UserEntry.USER_TBL;
//
//        private static final String SQL_DROP_CARD_TABLE =
//                "DROP TABLE IF EXISTS " + CardEntry.CARD_TBL;
//
//        public GCDatabaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
//            super(context, name, factory, version);
//        }
//
//        /**
//         * Constructor that init fixed db name and version
//         *
//         * @param context
//         */
//        public GCDatabaseHelper(Context context) {
//            super(context, DATABASE_NAME, null, DATABASE_VERSION);
//            Log.d("**********in db helper", "********");
//        }
//
//        @Override
//        public void onCreate(SQLiteDatabase db) {
//            // create tables
//            db.execSQL(SQL_CREATE_STORE_TBL);
//            db.execSQL(SQL_CREATE_CARD_TYPE_TBL);
//            db.execSQL(SQL_CREATE_STORE_CARD_TYPE_TBL);
//            db.execSQL(SQL_CREATE_USER_TBL);
//            db.execSQL(SQL_CREATE_CARD_TBL);
//            // init data
//            insertStoresData(db);
//            insertCardTypesData(db);
//            insertStoresCardTypesData(db);
//            insertUsersData(db);
//            insertCardsData(db);
//        }
//
//        @Override
//        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
//            db.execSQL(SQL_DROP_STORE_TABLE);
//            db.execSQL(SQL_DROP_CARD_TYPE_TABLE);
//            db.execSQL(SQL_DROP_STORE_CARD_TYPE_TABLE);
//            db.execSQL(SQL_DROP_USER_TABLE);
//            db.execSQL(SQL_DROP_CARD_TABLE);
//            onCreate(db);
//        }
//
//        private void insertStoresData(SQLiteDatabase db) {
//            ContentValues values = new ContentValues();
//            values.put(StoreEntry.NAME, "ZARA");
//            values.put(StoreEntry.IS_CHAIN_STORE, 1);
//            // insert row
//            db.insert(StoreEntry.STORE_TBL, null, values);
//
//            values.clear();
//            values.put(StoreEntry.NAME, "FOX");
//            values.put(StoreEntry.IS_CHAIN_STORE, 1);
//            // insert row
//            db.insert(StoreEntry.STORE_TBL, null, values);
//        }
//
//        private void insertCardTypesData(SQLiteDatabase db) {
//            ContentValues values = new ContentValues();
//            values.put(CardTypeEntry.NAME, "Dream Card");
//            values.put(CardTypeEntry.FOR_SPECIFIC_STORE, 0);
//            values.put(CardTypeEntry.IMAGE, R.drawable.dream_card);
//            db.insert(CardTypeEntry.CARD_TYPE_TBL, null, values);
//
//            // another row
//            values.clear();
//            values.put(CardTypeEntry.NAME, "Gift Card- Isracard");
//            values.put(CardTypeEntry.FOR_SPECIFIC_STORE, 1);
//            values.put(CardTypeEntry.FOR_SPECIFIC_STORE, 1);
//            values.put(CardTypeEntry.IMAGE, R.drawable.giftcard1);
//            db.insert(CardTypeEntry.CARD_TYPE_TBL, null, values);
//
//            // another row
//            values.clear();
//            values.put(CardTypeEntry.NAME, "Tav Hazav");
//            values.put(CardTypeEntry.FOR_SPECIFIC_STORE, 1);
//            values.put(CardTypeEntry.IMAGE, R.drawable.tavhazav);
//            db.insert(CardTypeEntry.CARD_TYPE_TBL, null, values);
//        }
//
//        private void insertStoresCardTypesData(SQLiteDatabase db) {
//            ContentValues values = new ContentValues();
//            values.put(StoreCardTypeEntry.STORE_ID, 1);
//            values.put(StoreCardTypeEntry.CARD_TYPE_ID, 1);
//            // insert row
//            db.insert(StoreCardTypeEntry.STORE_CARD_TYPE_TBL, null, values);
//
//            values.clear();
//            values.put(StoreCardTypeEntry.STORE_ID, 2);
//            values.put(StoreCardTypeEntry.CARD_TYPE_ID, 3);
//            // insert row
//            db.insert(StoreCardTypeEntry.STORE_CARD_TYPE_TBL, null, values);
//        }
//
//        private void insertUsersData(SQLiteDatabase db) {
//            ContentValues values = new ContentValues();
//            values.put(UserEntry.FIRST_NAME, "user");
//            values.put(UserEntry.LAST_NAME, "test");
//            values.put(UserEntry.EMAIL, "usertest@gmail.com");
//            values.put(UserEntry.PASSWORD, "Aa123456");
//
//            // insert row
//            db.insert(UserEntry.USER_TBL, null, values);
//        }
//
//        private void insertCardsData(SQLiteDatabase db) {
//            ContentValues values = new ContentValues();
//            values.put(CardEntry.CARD_TYPE_ID, 1);
//            values.put(CardEntry.IS_FOR_UNIQUE_STORE, 1);
//            values.put(CardEntry.UNIQUE_STORE_NAME, "ZERZ");
//            values.put(CardEntry.BALANCE, 320);
//            values.put(CardEntry.EXPIRATION_DATE, DateUtil.DATE_FORMAT_YYYYMMDDHHMMSS.format(new Date()));
//            values.put(CardEntry.USER_ID, 1);
//
//            // insert row
//            db.insert(CardEntry.CARD_TBL, null, values);
//        }
//    }


