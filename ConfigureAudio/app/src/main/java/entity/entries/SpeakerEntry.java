package entity.entries;

import android.content.ContentUris;
import android.net.Uri;
import android.provider.BaseColumns;
import entity.entries.DatabaseContract;

/**
 * Created by user on 07/07/2016.
 */
public class SpeakerEntry {

    public  static final String TBL_SPEAKERS = "TBL_SPEAKERS";
    public  static final String ID = "id";
    public  static final String NAME = "name";
    public  static final String STEREO = "stereo";
    public  static final String PLENUM = "plenum";
    public  static final String QUALITY = "quality";
    public  static final String INSTALLATION = "installation";
    public  static final String INCHES = "inches";

    //DATA
    public  static final String QUALITY_HP = "hp";
    public  static final String QUALITY_COM = "comercial";
    public  static final String INSTALLATION_IN_WALL = "In-wall";
    public  static final String INSTALLATION_ON_WALL = "On-wall";
    public  static final String INSTALLATION_CEILING = "Ceiling";
    public  static final String INSTALLATION_CEILING_TILE = "Ceiling tile";

    // aliases
//    public static final String FULL_NAME_ALIAS = GCDatabaseContract.STORE_ALIAS + "." + NAME;
//
//    // Content URI represents the base location for the table
    public static final Uri
            CONTENT_URI =
            DatabaseContract.BASE_CONTENT_URI.buildUpon().appendPath(TBL_SPEAKERS).build();//DatabaseContract.PATH_SPEAKER).build();
//
//    // These are special type prefixes that specify if a URI returns a list or a specific item
//    public static final String CONTENT_TYPE =
//            "vnd.android.cursor.dir/" + CONTENT_URI  + "/" + PATH_STORE;
//    public static final String CONTENT_ITEM_TYPE =
//            "vnd.android.cursor.item/" + CONTENT_URI + "/" + PATH_STORE;

    // Define a function to build a URI to find a specific store by it's identifier
//    public static Uri buildStoreUri(long id){
//        return ContentUris.withAppendedId(CONTENT_URI, id);
//    }
}








