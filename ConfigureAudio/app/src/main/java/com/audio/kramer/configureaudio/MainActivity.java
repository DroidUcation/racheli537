package com.audio.kramer.configureaudio;

import android.content.ContentValues;
import android.net.Uri;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import layout.StartFragment;

public class MainActivity extends AppCompatActivity implements StartFragment.OnFragmentInteractionListener{

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
}
