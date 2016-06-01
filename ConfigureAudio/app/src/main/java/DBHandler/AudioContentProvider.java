package DBHandler;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.Uri;
import android.support.annotation.Nullable;

/**
 * Created by ליברמן on 01/06/2016.
 */
public class AudioContentProvider extends ContentProvider {
    private  static final String TBL_SPEAKERS = "TBL_SPEAKERS";
    private  static final String SPEAKER_ID = "id";
    private  static final String SPEAKER_NAME = "name";
    private  static final String SPEAKER_PLENUM = "plenum";
    private  static final String TBL_AMP = "TBL_AMP";
    private  static final String AMP_ID = "id";
    private  static final String AMP_NAME = "name";
    private  static final String AMP_PLENUM = "plenum";
    private SQLiteDatabase db;

    @Override
    public boolean onCreate() {
        Context context = getContext();
        DBService db1 = new DBService(context,TBL_SPEAKERS,null,1);
        db = db1.getWritableDatabase();
        db1.onUpgrade(db,1,2);
        return (db != null);

    }

    @Nullable
    @Override
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
        return null;
    }

    @Nullable
    @Override
    public String getType(Uri uri) {
        return null;
    }

    @Nullable
    @Override
    public Uri insert(Uri uri, ContentValues values) {
        return null;
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        return 0;
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection, String[] selectionArgs) {
        return 0;
    }

    private  static class DBService extends SQLiteOpenHelper {

        public DBService(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
            super(context, name, factory, version);
        }



        @Override
        public void onCreate(SQLiteDatabase db) {
            String CREATE_SPEAKERS_TABLE = "CREATE TABLE " + TBL_SPEAKERS + "("
                    + SPEAKER_ID + " INTEGER," + SPEAKER_NAME + " TEXT,"
                    + SPEAKER_PLENUM + " TEXT" + ")";
            String CREATE_AMP_TABLE = "CREATE TABLE " + TBL_AMP + "("
                    + SPEAKER_ID + " INTEGER," + AMP_NAME + " TEXT,"
                    + AMP_PLENUM + " TEXT" + ")";
            db.execSQL(CREATE_SPEAKERS_TABLE);
            db.execSQL(CREATE_AMP_TABLE);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            // Drop older table if existed
            db.execSQL("DROP TABLE IF EXISTS " + TBL_SPEAKERS);
            db.execSQL("DROP TABLE IF EXISTS " + TBL_AMP);
            // Creating tables again
            onCreate(db);
        }
    }
}
