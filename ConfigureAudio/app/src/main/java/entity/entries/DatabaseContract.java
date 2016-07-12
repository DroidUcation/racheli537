package entity.entries;

import android.net.Uri;

/**
 * Created by user on 07/07/2016.
 */
public class DatabaseContract {
//    public static final String PATH_SPEAKER = "TBL_SPEAKERS";
    //public static final String PATH_Amplifier = "amplifier";
    public static final String PATH_SPEAKER_FILTER = "SPEAKERS_FILTER";

//    public static final String PATH_CARD_JOIN_CARD_TYPE_STORE = "cardJoinCardTypeJoinStore";
//    public static final String PATH_CARD_JOIN_CARD_TYPE = "cardJoinCardType";

    // tables aliases
//    public static final String CARD_ALIAS = "c";
//    public static final String CARD_TYPE_ALIAS = "ct";
//    public static final String STORE_ALIAS = "s";
//    public static final String STORE_CARD_TYPE_ALIAS = "sct";

    //private String PROVIDER_NAME = "entity.AudioContentProvider";
    //private String URL = "content://" + PROVIDER_NAME +"/TBL_AMP";
    //private Uri SPEAKERS_CONTENT_URI = Uri.parse(URL);

    // base authority(provider path)
    public static final String CONTENT_AUTHORITY = "entity.AudioContentProvider";

    // base uri
    public static final Uri BASE_CONTENT_URI = Uri.parse("content://" + CONTENT_AUTHORITY);

    // uri of joined tables
//    public static final Uri CONTENT_URI_CARD_JOIN_CARD_TYPE_STORE = BASE_CONTENT_URI.buildUpon().appendPath(PATH_CARD_JOIN_CARD_TYPE_STORE).build();
//    public static final Uri CONTENT_URI_CARD_JOIN_CARD_TYPE = BASE_CONTENT_URI.buildUpon().appendPath(PATH_CARD_JOIN_CARD_TYPE).build();
}
