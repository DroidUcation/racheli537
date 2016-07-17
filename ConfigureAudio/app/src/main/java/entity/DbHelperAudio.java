package entity;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import entity.entries.AmpEntry;
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
        String CREATE_SPEAKERS_TABLE =
                "CREATE TABLE IF NOT EXISTS " + SpeakerEntry.TBL_SPEAKERS + "("
                        //+ SpeakerEntry.ID + " INTEGER,"
                        + SpeakerEntry.ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                        + SpeakerEntry.NAME + " TEXT,"
                        + SpeakerEntry.STEREO + " TEXT,"
                        + SpeakerEntry.PLENUM + " TEXT,"
                        + SpeakerEntry.QUALITY + " TEXT,"
                        + SpeakerEntry.INSTALLATION + " TEXT,"
                        + SpeakerEntry.INCHES + " NUMERIC,"
                        + SpeakerEntry.DESCRIPTION + " TEXT,"
                        + SpeakerEntry.PORT_NUMBER + " TEXT"
                        + ")";

        String CREATE_AMP_TABLE =
                "CREATE TABLE IF NOT EXISTS " + AmpEntry.TBL_AMP + "("
                //+ SpeakerEntry.ID + " INTEGER,"
                + AmpEntry.ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + AmpEntry.NAME + " TEXT,"
                + AmpEntry.POWER + " TEXT,"
                + AmpEntry.CONTROL + " TEXT,"
                + AmpEntry.MAX_SPEAKERS + " INTEGER,"
                + AmpEntry.INPUT + " INTEGER,"
                + AmpEntry.SPECIAL + " TEXT,"
                + AmpEntry.DESCRIPTION + " TEXT,"
                + AmpEntry.PORT_NUMBER + " TEXT"
                + ")";

        db.execSQL(CREATE_SPEAKERS_TABLE);
        db.execSQL(CREATE_AMP_TABLE);

        // init data
        if (getCountRowsTable(db, SpeakerEntry.TBL_SPEAKERS) <= 0)
            insertSpeakersData(db);
        if (getCountRowsTable(db, AmpEntry.TBL_AMP) <= 0)
            insertAmpData(db);
        long intCnt = getCountRowsTable(db, AmpEntry.TBL_AMP);
        //intCnt = getCountRowsTable(db, SpeakerEntry.TBL_SPEAKERS);
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
        db.execSQL("DROP TABLE IF EXISTS " + AmpEntry.TBL_AMP);
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
        values.put(SpeakerEntry.DESCRIPTION, "6.5−Inch, 2−Way Open−Back Rectangular In−Wall Speakers");
        values.put(SpeakerEntry.PORT_NUMBER, "60-000069");
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
        values.put(SpeakerEntry.DESCRIPTION, "6.5-Inch, High-Performance, In-Wall Stereo Speaker");
        values.put(SpeakerEntry.PORT_NUMBER, "60-000069");
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
        values.put(SpeakerEntry.DESCRIPTION, "4−Inch, 2−Way On−Wall Speakers");
        values.put(SpeakerEntry.PORT_NUMBER, "60-000069");
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
        values.put(SpeakerEntry.DESCRIPTION, "5.25−Inch, 2−Way On−Wall Speakers");
        values.put(SpeakerEntry.PORT_NUMBER, "60-000069");
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
        values.put(SpeakerEntry.DESCRIPTION, "6.5−Inch, 2−Way On−Wall Speakers");
        values.put(SpeakerEntry.PORT_NUMBER, "60-000069");
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
        values.put(SpeakerEntry.DESCRIPTION, "5.25−Inch, On−Wall 2−Way Powered Speakers");
        values.put(SpeakerEntry.PORT_NUMBER, "60-000069");
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
        values.put(SpeakerEntry.DESCRIPTION, "64-Inch, 2-Way On-Wall Speakers");
        values.put(SpeakerEntry.PORT_NUMBER, "60-000069");
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
        values.put(SpeakerEntry.DESCRIPTION, "5.25-Inch, 2-Way On-Wall Speakers");
        values.put(SpeakerEntry.PORT_NUMBER, "60-000069");
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
        values.put(SpeakerEntry.DESCRIPTION, "6.5-Inch, 2-Way On-Wall Speakers");
        values.put(SpeakerEntry.PORT_NUMBER, "60-000069");
        // insert row
        db.insert(SpeakerEntry.TBL_SPEAKERS, null, values);

        values.clear();
        values.put(SpeakerEntry.ID, 2860);
        values.put(SpeakerEntry.NAME, "Yarden 6-OD");
        values.put(SpeakerEntry.STEREO, "N");
        values.put(SpeakerEntry.PLENUM, "N");
        values.put(SpeakerEntry.QUALITY, SpeakerEntry.QUALITY_HP);
        values.put(SpeakerEntry.INSTALLATION, SpeakerEntry.INSTALLATION_ON_WALL);
        values.put(SpeakerEntry.INCHES, 6.5);
        values.put(SpeakerEntry.DESCRIPTION, "6.5−Inch, High−Performance, On−Wall Stereo Speaker");
        values.put(SpeakerEntry.PORT_NUMBER, "60-000069");
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
        values.put(SpeakerEntry.DESCRIPTION, "4−Inch, 2−Way Closed−Back Ceiling Speakers");
        values.put(SpeakerEntry.PORT_NUMBER, "60-000069");
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
        values.put(SpeakerEntry.DESCRIPTION, "6.5−Inch, 2−Way Closed−Back Ceiling Speakers");
        values.put(SpeakerEntry.PORT_NUMBER, "60-000069");
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
        values.put(SpeakerEntry.DESCRIPTION, "8−Inch, 2−Way Closed−Back Ceiling Speakers");
        values.put(SpeakerEntry.PORT_NUMBER, "60-000069");
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
        values.put(SpeakerEntry.DESCRIPTION, "4−Inch, 2−Way Open−Back Ceiling Speakers");
        values.put(SpeakerEntry.PORT_NUMBER, "60-000069");
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
        values.put(SpeakerEntry.DESCRIPTION, "6.5−Inch, 2−Way Open−Back Ceiling Speakers");
        values.put(SpeakerEntry.PORT_NUMBER, "60-000069");
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
        values.put(SpeakerEntry.DESCRIPTION, "8−Inch, 2−Way Open−Back Ceiling Speakers");
        values.put(SpeakerEntry.PORT_NUMBER, "60-000069");
        // insert row
        db.insert(SpeakerEntry.TBL_SPEAKERS, null, values);

        values.clear();
        values.put(SpeakerEntry.ID, 2855);
        values.put(SpeakerEntry.NAME, "Tavor 8-T");
        values.put(SpeakerEntry.STEREO, "N");
        values.put(SpeakerEntry.PLENUM, "N");
        values.put(SpeakerEntry.QUALITY, SpeakerEntry.QUALITY_HP);
        values.put(SpeakerEntry.INSTALLATION, SpeakerEntry.INSTALLATION_CEILING_TILE);
        values.put(SpeakerEntry.INCHES, 8);
        values.put(SpeakerEntry.DESCRIPTION, "8-Inch, High-Performance, Powered Ceiling Tile Speaker");
        values.put(SpeakerEntry.PORT_NUMBER, "60-000069");
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
        values.put(SpeakerEntry.DESCRIPTION, "4−Inch, 2−Way Closed−Back Ceiling Speakers");
        values.put(SpeakerEntry.PORT_NUMBER, "60-000069");
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
        values.put(SpeakerEntry.DESCRIPTION, "6.5−Inch, 2−Way Closed−Back Ceiling Speakers");
        values.put(SpeakerEntry.PORT_NUMBER, "60-000069");
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
        values.put(SpeakerEntry.DESCRIPTION, "8−Inch, 2−Way Closed−Back Ceiling Speakers");
        values.put(SpeakerEntry.PORT_NUMBER, "60-000069");
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
        values.put(SpeakerEntry.DESCRIPTION, "6.5−Inch, 2−Way Open−Back Rectangular In−Wall Speakers");
        values.put(SpeakerEntry.PORT_NUMBER, "60-000069");
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
        values.put(SpeakerEntry.DESCRIPTION, "8−Inch, High−Power, 2−Way Closed−Back Ceiling Speakers");
        values.put(SpeakerEntry.PORT_NUMBER, "60-000069");
        // insert row
        db.insert(SpeakerEntry.TBL_SPEAKERS, null, values);
    }

    private void insertAmpData(SQLiteDatabase db) {
        ContentValues values = new ContentValues();
        values.put(AmpEntry.ID, 1493);
        values.put(AmpEntry.NAME, "900N");
        values.put(AmpEntry.POWER, "2*10");
        values.put(AmpEntry.CONTROL, "N");
        values.put(AmpEntry.MAX_SPEAKERS, 8);
        values.put(AmpEntry.INPUT, 2);
        values.put(AmpEntry.SPECIAL, "");
        values.put(AmpEntry.DESCRIPTION, "Stereo Audio Power Amplifier (8.4 Watts per Channel)");
        values.put(AmpEntry.PORT_NUMBER, "90-7015409X");
        // insert row
        db.insert(AmpEntry.TBL_AMP, null, values);

        values.clear();
        values.put(AmpEntry.ID, 1655);
        values.put(AmpEntry.NAME, "900xl");
        values.put(AmpEntry.POWER, "2*10");
        values.put(AmpEntry.CONTROL, "Y");
        values.put(AmpEntry.MAX_SPEAKERS, 8);
        values.put(AmpEntry.INPUT, 2);
        values.put(AmpEntry.SPECIAL, "");
        values.put(AmpEntry.DESCRIPTION, "Stereo Audio Power Amplifier (10 Watts per Channel)");
        values.put(AmpEntry.PORT_NUMBER, "90-7622090");
        // insert row
        db.insert(AmpEntry.TBL_AMP, null, values);

        values.clear();
        values.put(AmpEntry.ID, 50);
        values.put(AmpEntry.NAME, "903");
        values.put(AmpEntry.POWER, "2*10");
        values.put(AmpEntry.CONTROL, "N");
        values.put(AmpEntry.MAX_SPEAKERS, 8);
        values.put(AmpEntry.INPUT, 4);
        values.put(AmpEntry.SPECIAL, "switcher");
        values.put(AmpEntry.DESCRIPTION, "4x1 Personal Stereo Audio Amplifier & Switcher (10 Watts per Channel)");
        values.put(AmpEntry.PORT_NUMBER, "90-090390");
        // insert row
        db.insert(AmpEntry.TBL_AMP, null, values);

//        ID	Name 	Power	Control	Max speakers	Input#
//        1493	900N	2*10	n	8	2
//        1655	900xl	2*10	y	8	2
//        1492	907	2*40	n	8	1
//        1686	908	2*40	y	8	2
//        2841	914	2*100	n	8	1
//        2647	905xl	2*110	y	8	2
//        50	903	2*10	n	8	4
//        2399	907xl	2*40	n	8	2
//        2842	920	1*200	n	~	4

    }
}
