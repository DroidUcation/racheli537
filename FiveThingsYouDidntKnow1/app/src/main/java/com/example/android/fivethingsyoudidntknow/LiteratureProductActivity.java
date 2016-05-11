package com.example.android.fivethingsyoudidntknow;

import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.TextView;

import entity.FactsContentProvider;

/**
 * Created by ליברמן on 07/04/2016.
 */
public class LiteratureProductActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.literature);

        FactsContentProvider db = new FactsContentProvider();
        TextView titleLiter = new Button(this);
        TextView contentLiter = new TextView(this);

        String PROVIDER_NAME = "entity.FactsContentProvider";
        String URL = "content://" + PROVIDER_NAME ;
        Uri CONTENT_URI = Uri.parse(URL);

        String[] mProjection = {"content"};
        String selection = "title = ?";
        String[] selectionArgs = new String[]{getString(R.string.literature_header)};
        Cursor cursor = getContentResolver().query(CONTENT_URI, mProjection, selection, selectionArgs, null);
        cursor.moveToFirst();
        contentLiter = (TextView) findViewById(R.id.tv_literContent) ;
        contentLiter.setText(cursor.getString(cursor.getColumnIndex("content")));

        //mProjection = null;//{""};
        String[] mProjection1 = {"title"};
        selection = "content = ?";
        selectionArgs = new String[]{getString(R.string.literature_content)};
        cursor = getContentResolver().query(CONTENT_URI, mProjection1, selection, selectionArgs, null);
        cursor.moveToFirst();
        titleLiter = (TextView) findViewById(R.id.tv_literTitle) ;
        titleLiter.setText(cursor.getString(cursor.getColumnIndex("title")));

      /*  if (titleLiter != null) {
            titleLiter.setText(db.getFact(3).getTitle());
        }
        contentLiter.setText(db.getFact(3).getContentText());*/
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