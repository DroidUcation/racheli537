package com.audio.kramer.configureaudio;

import android.content.ContentValues;
import android.net.Uri;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import layout.NoiseFloorFragment;
import layout.RoomPurposeFragment;
import layout.RoomSizeFragment;
import layout.StartFragment;

public class MainActivity extends AppCompatActivity implements StartFragment.OnFragmentInteractionListener,
        NoiseFloorFragment.OnFragmentInteractionListener , RoomPurposeFragment.OnFragmentInteractionListener,
        RoomSizeFragment.OnFragmentInteractionListener{

    private String PROVIDER_NAME = "entity.AudioContentProvider";
    private String URL = "content://" + PROVIDER_NAME +"/TBL_AMP";
    private Uri SPEAKERS_CONTENT_URI = Uri.parse(URL);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fillTheDB();

        // Begin the transaction
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        // Replace the contents of the container with the new fragment
        ft.replace(R.id.fragment_placeholder, new StartFragment());
        // or ft.add(R.id.your_placeholder, new FooFragment());
        // Complete the changes added above
        ft.commit();




    }
    private void fillTheDB() {
        ContentValues valuesSpeakers = new ContentValues();
        valuesSpeakers.put("id", "1");
        valuesSpeakers.put("name", "psich");
        valuesSpeakers.put("plenum", "meod");

        getContentResolver().insert(SPEAKERS_CONTENT_URI, valuesSpeakers);

     /*   ContentValues valuesAmplifiers = new ContentValues();
        valuesAmplifiers.put("id", "1");
        valuesAmplifiers.put("name", "psich");
        valuesAmplifiers.put("plenum", "meod");

        getContentResolver().insert(CONTENT_URI, valuesAmplifiers);
*/

    }

    @Override
    public void onFragmentInteraction(Uri uri) {
        
    }

    public void gotoNextFragment(View view) {
      //  Spinner spinner = (Spinner) findViewById(R.id.spinner_length);
        // Begin the transaction
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        int viewId = view.getId();
        switch (viewId) {
            case R.id.start_btn://If start goto noise floor
                // Replace the contents of the container with the new fragment
                ft.replace(R.id.fragment_placeholder, new NoiseFloorFragment());
                break;
            case R.id.noise_db45://If noise floor goto purpose
            case R.id.noise_db55:
            case R.id.noise_db60:
            case R.id.noise_db65:
            case R.id.noise_db75:
                ft.replace(R.id.fragment_placeholder, new RoomPurposeFragment());
                break;
            case R.id.pur_5://If purpose goto room size
            case R.id.pur_10:
            case R.id.pur_15:
            case R.id.pur_20:
                ft.replace(R.id.fragment_placeholder, new RoomSizeFragment());

                break;

        }
        // Complete the changes added above
        ft.addToBackStack(null);
        ft.commit();
    }
}
