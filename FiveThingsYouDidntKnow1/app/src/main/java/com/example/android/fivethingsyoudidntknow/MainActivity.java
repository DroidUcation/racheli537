package com.example.android.fivethingsyoudidntknow;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import services.DailyAlarmService;

public class MainActivity extends AppCompatActivity {
    Button t;
    private String sText;
    private String PROVIDER_NAME = "entity.FactsContentProvider";
    private String URL = "content://" + PROVIDER_NAME ;
    private Uri CONTENT_URI = Uri.parse(URL);
    private  String URL1 = "content://" + PROVIDER_NAME + "/fact";
    private Uri CONTENT_URI1 = Uri.parse(URL1);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fillTheDB();

        loadContent();

        Intent alarmService = new Intent(this,DailyAlarmService.class);
        //alarmService.setAction(this,DailyAlarmService.class);
        startService(alarmService);
    }

    public void openSolution(View view) {
        Intent intent = new Intent(this,SolutionsActivity.class);
        startActivity(intent);

    }

    public void openProduct(View view) {
        Intent intent = new Intent(this,ProductActivity.class);
        startActivity(intent);
    }

    public void openEvents(View view) {
        Intent intent = new Intent(this,EventsProductActivity.class);
        startActivity(intent);
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
    public Cursor cursor;
    public void loadContent(){
        String[] mProjection = {"title"};
        cursor = getContentResolver().query(CONTENT_URI1, mProjection, null, null,null);
        Button btnViewSol;
        Button btnViewEve;
        Button btnViewPro;
        Button btnViewLoc;
        Button btnViewLit;

        if(cursor != null) {
            cursor.moveToFirst();
            btnViewSol =(Button) findViewById(R.id.solutions);
            btnViewSol.setText(cursor.getString(cursor.getColumnIndex("title")));
            cursor.moveToNext();
            btnViewPro =(Button) findViewById(R.id.products);
            btnViewPro.setText(cursor.getString(cursor.getColumnIndex("title")));
            cursor.moveToNext();
            btnViewEve =(Button) findViewById(R.id.events);
            btnViewEve.setText(cursor.getString(cursor.getColumnIndex("title")));
            cursor.moveToNext();
            btnViewLit =(Button) findViewById(R.id.literature);
            btnViewLit.setText(cursor.getString(cursor.getColumnIndex("title")));
            cursor.moveToNext();
            btnViewLoc =(Button) findViewById(R.id.locations);
            btnViewLoc.setText(cursor.getString(cursor.getColumnIndex("title")));

               cursor.close();



        }
    }

    public void openLocation(View view) {
        Intent intent = new Intent(this,LocationProductActivity.class);
        startActivity(intent);




    }

    public void openLiterature(View view) {
        Intent intent = new Intent(this,LiteratureProductActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
