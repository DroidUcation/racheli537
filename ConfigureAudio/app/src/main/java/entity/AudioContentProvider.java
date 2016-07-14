package entity;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteQueryBuilder;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.util.Log;

import entity.entries.DatabaseContract;
import entity.entries.SpeakerEntry;

/**
 * Created by
 */
public class AudioContentProvider extends ContentProvider {

//    private static final String TBL_SPEAKERS = "TBL_SPEAKERS";
//    private static final String SPEAKER_ID = "id";
//    private static final String SPEAKER_NAME = "name";
//    private static final String SPEAKER_STEREO = "stereo";
//    private static final String SPEAKER_PLENUM = "plenum";
//    private static final String TBL_AMP = "TBL_AMP";
//    private static final String AMP_ID = "id";
//    private static final String AMP_NAME = "name";
//    private static final String AMP_PLENUM = "plenum";

    private SQLiteDatabase db;
    private DbHelperAudio DbHelper;

    private static final int speakersCode = 1;
    private static final int ampCode = 2;
    private static final int speakersFilterCode = 3;

    static final UriMatcher uriMatcher;

    static final String content = DatabaseContract.CONTENT_AUTHORITY;
    static {
        uriMatcher = new UriMatcher(UriMatcher.NO_MATCH);
        uriMatcher.addURI(content, SpeakerEntry.TBL_SPEAKERS, speakersCode);
        uriMatcher.addURI(content, "amplifier", ampCode);
        uriMatcher.addURI(content, DatabaseContract.PATH_SPEAKER_FILTER, speakersFilterCode);
    }

    @Override
    public boolean onCreate() {
        Log.d("**********in on create", "********");
        Context context = getContext();
        DbHelper = new DbHelperAudio(context);
        db = DbHelper.getWritableDatabase();
        //DbHelper.onUpgrade(db, 1, 2);

//        DBService db2 = new DBService(context,TBL_AMP,null,1);
//        db = db2.getWritableDatabase();
//        db2.onUpgrade(db,1,2);
        return true;//(db != null);
    }


//    @Override
//    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
//        SQLiteQueryBuilder sqLiteQueryBuilder = new SQLiteQueryBuilder();
//        sqLiteQueryBuilder.setTables(SpeakerEntry.TBL_SPEAKERS);
//        Cursor cursor = sqLiteQueryBuilder.query(db, projection, selection, selectionArgs, null, null, sortOrder);
//        cursor.setNotificationUri(getContext().getContentResolver(),uri);
//        return cursor;
//    }

    @Nullable
    @Override
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
        SQLiteQueryBuilder sqLiteQueryBuilder = new SQLiteQueryBuilder();
        switch (uriMatcher.match(uri)) {
            case speakersCode:
                sqLiteQueryBuilder.setTables(SpeakerEntry.TBL_SPEAKERS);
                break;
            case speakersFilterCode:
                sqLiteQueryBuilder.setTables(SpeakerEntry.TBL_SPEAKERS);
                selection = SpeakerEntry.PLENUM + " = 'N' AND " + SpeakerEntry.INSTALLATION + " = ? AND " + SpeakerEntry.INCHES + " = ?" ;//SpeakerEntry.INCHES + " = ?" ;//
                break;
//            case ampCode:
//                sqLiteQueryBuilder.setTables(StoreEntry.STORE_TBL);
//                _id = ContentUris.parseId(uri);
//                selection = StoreEntry._ID + " = ?";
//                selectionArgs = new String[]{String.valueOf(_id)};
//                        case CARD_STORE_AND_CARD_TYPE: // join card, cardType, store and cardTypeStore tables
//                sqLiteQueryBuilder.setTables(CardEntry.CARD_TBL  + " as c INNER JOIN " + CardTypeEntry.CARD_TYPE_TBL + " as ct"
//                        + " ON c." + CardEntry.CARD_TYPE_ID + " = ct." + CardTypeEntry._ID
//                        + " INNER JOIN " + StoreCardTypeEntry.STORE_CARD_TYPE_TBL + " as sct"
//                        + " ON sct." + StoreCardTypeEntry.CARD_TYPE_ID + " = ct." + CardTypeEntry._ID
//                        + " INNER JOIN " + StoreEntry.STORE_TBL + " as s"
//                        + " ON s." + StoreEntry._ID + " = sct." + StoreCardTypeEntry.STORE_ID);
//                sqLiteQueryBuilder.setProjectionMap(storeNameCardProjectionsMap);
//                break;
            default:
                throw new UnsupportedOperationException("Unknown uri: " + uri);
        }

        Cursor cursor = sqLiteQueryBuilder.query(db, projection, selection,
                selectionArgs, null, null, sortOrder);
        cursor.setNotificationUri(getContext().getContentResolver(), uri);

        return cursor;
    }

//    /**
//     * Builds a UriMatcher that is used to determine witch database request is being made.
//     */
//    public static UriMatcher buildUriMatcher() {
//        String content = DatabaseContract.CONTENT_AUTHORITY;
//        // All paths to the UriMatcher have a corresponding code to return
//        // when a match is found (the ints above).
//        UriMatcher matcher = new UriMatcher(UriMatcher.NO_MATCH);
//        matcher.addURI(content, DatabaseContract.PATH_SPEAKER, SPEAKER);
//        //matcher.addURI(content, DatabaseContract.PATH_SPEAKER, SPEAKER);
//
//        return matcher;
//    }

    @Nullable
    @Override
    public String getType(Uri uri) {
        return null;
    }

    @Nullable
    @Override
    public Uri insert(Uri uri, ContentValues values) {
        long rowID = db.insert(SpeakerEntry.TBL_SPEAKERS, "", values);
        if (rowID > 0) {
            Uri _uri = ContentUris.withAppendedId(uri, rowID);
            getContext().getContentResolver().notifyChange(_uri, null);
            return _uri;
        }
        throw new SQLException("Unable to add a new Speakers record into " + uri);
    }

//    public long insertSpeaker(Uri uri, Speaker speaker) {
//        final SQLiteDatabase dbInsert = gcDbHelper.getWritableDatabase();
//        ContentValues values = new ContentValues();
//        values.put(SPEAKER_ID, speaker.Id());
//        values.put(SPEAKER_NAME, speaker.Name());
//        values.put(SPEAKER_STEREO, speaker.Stereo());
//        getContext().getContentResolver().notifyChange(uri, null);
//        return db.insert(TBL_SPEAKERS, null, values);
//    }

//    @Override
//    public int delete(Uri uri, String selection, String[] selectionArgs) {
//        return 0;
//    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        final SQLiteDatabase db = DbHelper.getWritableDatabase();
        int rows; // Number of rows effected
        String tableName = getTableName(uri);
        rows = db.delete(tableName, selection, selectionArgs);

        // Because null could delete all rows:
        if (selection == null || rows != 0) {
            getContext().getContentResolver().notifyChange(uri, null);
        }

        return rows;
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection, String[] selectionArgs) {
        return 0;
    }

    private String getTableName(Uri uri) {
        String tableName;
        switch (uriMatcher.match(uri)) {
            case speakersCode:
                tableName = SpeakerEntry.TBL_SPEAKERS;
                break;
//            case CARD_TYPE:
//            case CARD_TYPE_ID:
//                tableName = CardTypeEntry.CARD_TYPE_TBL;
//                break;
//            case STORE_CARD_TYPE:
//                tableName = StoreCardTypeEntry.STORE_CARD_TYPE_TBL;
//                break;
//            case USER:
//            case USER_ID:
//                tableName = UserEntry.USER_TBL;
//                break;
//            case CARD:
//            case CARD_ID:
//                tableName = CardEntry.CARD_TBL;
//                break;
            default:
                throw new UnsupportedOperationException("Unknown uri: " + uri);
        }
        return tableName;
    }
}