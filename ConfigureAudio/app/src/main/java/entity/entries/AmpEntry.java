package entity.entries;

import android.net.Uri;

/**
 * Created by user on 07/07/2016.
 */
public class AmpEntry {

    public  static final String TBL_AMP = "TBL_AMP";
    public  static final String ID = "_id";
    public  static final String NAME = "name";
    public  static final String POWER = "power";
    public  static final String CONTROL = "control";
    public  static final String MAX_SPEAKERS = "max_speakers";
    public  static final String INPUT = "input";
    public  static final String SPECIAL = "special";
    public  static final String DESCRIPTION = "description";
    public  static final String PORT_NUMBER = "port_number";
    //DATA
//    public  static final String QUALITY_HP = "hp";
//    public  static final String QUALITY_COM = "comercial";
//    public  static final String INSTALLATION_IN_WALL = "In-wall";
//    public  static final String INSTALLATION_ON_WALL = "On-wall";
//    public  static final String INSTALLATION_CEILING = "Ceiling";
//    public  static final String INSTALLATION_CEILING_TILE = "Ceiling tile";

    // aliases
//    public static final String FULL_NAME_ALIAS = GCDatabaseContract.STORE_ALIAS + "." + NAME;
//
//    // Content URI represents the base location for the table
    public static final Uri
            CONTENT_URI =
            DatabaseContract.BASE_CONTENT_URI.buildUpon().appendPath(TBL_AMP).build();//DatabaseContract.PATH_SPEAKER).build();
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








