package com.example.android.fivethingsyoudidntknow;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
