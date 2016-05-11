package services;

import android.app.IntentService;
import android.content.ContentValues;
import android.content.Intent;
import android.net.Uri;

import com.example.android.fivethingsyoudidntknow.R;

/**
 * Created by ליברמן on 09/05/2016.
 */
public class DBService extends IntentService {
    private String PROVIDER_NAME = "entity.FactsContentProvider";
    private String URL = "content://" + PROVIDER_NAME ;
    private Uri CONTENT_URI = Uri.parse(URL);
    /**
     * Creates an IntentService.  Invoked by your subclass's constructor.
     *
     * @param  //Used to name the worker thread, important only for debugging.
     */
    public DBService() {
        super("DBService");
    }

    public DBService(String name, String PROVIDER_NAME) {
        super(name);
        this.PROVIDER_NAME = PROVIDER_NAME;
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        // Gets data from the incoming Intent
       //String dataString = workIntent.getDataString();

        // Do work here, based on the contents of dataString
        fillTheDB();
    }
    private void fillTheDB() {
        // db.query();
        ContentValues valuesSol = new ContentValues();
        valuesSol.put("title", getString(R.string.solution_header));
        valuesSol.put("content", getString(R.string.solution_content));

        Uri uri = getContentResolver().insert(CONTENT_URI, valuesSol);

        ContentValues valuesProd = new ContentValues();
        valuesProd.put("title", getString(R.string.products_header));
        valuesProd.put("content", getString(R.string.products_content));
        getContentResolver().insert(CONTENT_URI, valuesProd);

        ContentValues valuesEve = new ContentValues();
        valuesEve.put("title", getString(R.string.events_header));
        valuesEve.put("content", getString(R.string.events_content));
        getContentResolver().insert(CONTENT_URI, valuesEve);

        ContentValues valuesLiter = new ContentValues();
        valuesLiter.put("title", getString(R.string.literature_header));
        valuesLiter.put("content", getString(R.string.literature_content));
        getContentResolver().insert(CONTENT_URI, valuesLiter);

        ContentValues valuesLoc = new ContentValues();
        valuesLoc.put("title", getString(R.string.location_header));
        valuesLoc.put("content", getString(R.string.location_content));
        getContentResolver().insert(CONTENT_URI, valuesLoc);


    }
}
