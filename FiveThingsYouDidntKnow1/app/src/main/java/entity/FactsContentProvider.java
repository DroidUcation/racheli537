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

/**
 * Created by ליברמן on 18/04/2016.
 */
public class FactsContentProvider extends ContentProvider {

    private static final String TBL_FACTS = "TBL_FACT";
    private static final String KEY_ID = "id";
    private static final String KEY_TITLE = "title";
    private static final String KEY_CONTENT = "content";
    private SQLiteDatabase db;

  //  static final String PROVIDER_NAME = "com.facts.provider";
   // static final String URL = "content://" + PROVIDER_NAME + "/fact";
    //static final Uri CONTENT_URI = Uri.parse(URL);

    static final int FACT = 1;
    static final int FACT_ID = 2;

    static final UriMatcher uriMatcher;
    static{
        uriMatcher = new UriMatcher(UriMatcher.NO_MATCH);
        uriMatcher.addURI("com.facts.provider", "fact", FACT);
        uriMatcher.addURI("com.facts.provider", "fact/#", FACT_ID);
    }
   // public DBHandler


    private static class DBHandler extends SQLiteOpenHelper {
        public DBHandler(Context context) {
            super(context, TBL_FACTS, null, 1);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            String CREATE_CONTACTS_TABLE = "CREATE TABLE " + TBL_FACTS + "("
                    + KEY_ID + " INTEGER PRIMARY KEY," + KEY_TITLE + " TEXT,"
                    + KEY_CONTENT + " TEXT" + ")";
            db.execSQL(CREATE_CONTACTS_TABLE);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            // Drop older table if existed
            db.execSQL("DROP TABLE IF EXISTS " + TBL_FACTS);
            // Creating tables again
            onCreate(db);
        }
    }


        @Override
        public boolean onCreate() {
            Context context = getContext();
            DBHandler db1 = new DBHandler(context);
            db = db1.getWritableDatabase();
            db1.onUpgrade(db,1,2);
            return (db != null);


        }

        @Nullable
        @Override
        public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
            SQLiteQueryBuilder sqLiteQueryBuilder = new SQLiteQueryBuilder();
            sqLiteQueryBuilder.setTables(TBL_FACTS);
            Cursor cursor = sqLiteQueryBuilder.query(db, projection, selection, selectionArgs, null, null, sortOrder);
            cursor.setNotificationUri(getContext().getContentResolver(),uri);
            return cursor;
        }

        @Nullable
        @Override
        public String getType(Uri uri) {
            return null;
        }

        @Nullable
        @Override
        public Uri insert(Uri uri, ContentValues values) {
            long rowID = db.insert(TBL_FACTS, "", values);
            if (rowID > 0)
            {
                Uri _uri = ContentUris.withAppendedId(uri, rowID);
                getContext().getContentResolver().notifyChange(_uri, null);
                return _uri;
            }
            throw new SQLException("Unable to add a new fact record into " + uri);
        }

        @Override
        public int delete(Uri uri, String selection, String[] selectionArgs) {
            return 0;
        }

        @Override
        public int update(Uri uri, ContentValues values, String selection, String[] selectionArgs) {
            return 0;
        }

    }

