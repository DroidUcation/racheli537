package com.audio.kramer.configureaudio;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.DragEvent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import entity.ParamsData;
import entity.Speaker;
import entity.entries.DatabaseContract;
import entity.entries.SpeakerEntry;
import github.chenupt.springindicator.SpringIndicator;
import github.chenupt.springindicator.viewpager.ScrollerViewPager;
import layout.AmplifiersFragment;
import layout.InstallationFragment;
import layout.NoiseFloorFragment;
import layout.RoomPurposeFragment;
import layout.RoomSizeFragment;
import layout.ShareFragment;
import layout.SpeakerFragment;
import layout.StartFragment;

public class MainActivity extends AppCompatActivity implements StartFragment.OnFragmentInteractionListener,
        NoiseFloorFragment.OnFragmentInteractionListener, RoomPurposeFragment.OnFragmentInteractionListener
        , ShareFragment.OnFragmentInteractionListener,
        RoomSizeFragment.OnFragmentInteractionListener, SpeakerFragment.OnFragmentInteractionListener
        , InstallationFragment.OnFragmentInteractionListener {


    private static ParamsData paramsData;

    public static class MyPagerAdapter extends FragmentPagerAdapter {
        private static int NUM_ITEMS = 7;

        public MyPagerAdapter(FragmentManager fragmentManager) {
            super(fragmentManager);
        }

        // Returns total number of pages
        @Override
        public int getCount() {
            return NUM_ITEMS;
        }
        StartFragment startFragment;
        NoiseFloorFragment noiseFloorFragment;
        RoomPurposeFragment roomPurposeFragment;
        RoomSizeFragment roomSizeFragment;
        InstallationFragment installationFragment;
        SpeakerFragment speakerFragment;
        ShareFragment shareFragment;
        AmplifiersFragment amplifiersFragment;

        // Returns the fragment to display for that page
        @Override
        public Fragment getItem(int position) {

            switch (position) {
                case 0: // Fragment # 0 - This will show FirstFragment different title
                    if (startFragment == null)
                        startFragment = new StartFragment();
                    return startFragment;
                case 1:
                    if (noiseFloorFragment == null)
                        noiseFloorFragment = new NoiseFloorFragment();
                    return noiseFloorFragment;
                //return NoiseFloorFragment.newInstance("2", "NoiseFloorFragment"); //new NoiseFloorFragment();
                case 2: // Fragment # 1 - This will show SecondFragment
                    if (roomPurposeFragment == null)
                        roomPurposeFragment = new RoomPurposeFragment();
                    return roomPurposeFragment;
                //return new RoomPurposeFragment();//SecondFragment.newInstance(2, "Page # 3");
                case 3: // Fragment # 1 - This will show SecondFragment
                    if (roomSizeFragment == null)
                        roomSizeFragment = new RoomSizeFragment();
                    return roomSizeFragment;
                //return new RoomSizeFragment();//SecondFragment.newInstance(2, "Page # 3");
                case 4: // Fragment # 1 - This will show SecondFragment
                    if (installationFragment == null)
                        installationFragment = new InstallationFragment();
                    return installationFragment;
                //return new InstallationFragment();//SecondFragment.newInstance(2, "Page # 3");
                case 5: // Fragment # 1 - This will show SecondFragment
//                    if (speakerFragment == null)
//                        speakerFragment = new SpeakerFragment();
//                    Bundle args = new Bundle();
//                    args.putAll(args);// SpeakerFragment.paramsData, paramsData);
//                    speakerFragment.setArguments(args);
                    return SpeakerFragment.newInstance(paramsData);
                //return speakerFragment;
                //return new SpeakerOptionFragment();//SecondFragment.newInstance(2, "Page # 3");
                case 6: // Fragment # 1 - This will show SecondFragment
                    //return new AmplifiersFragment();//SecondFragment.newInstance(2, "Page # 3");
                    //if (paramsData.Speaker() > 0)
                    if (shareFragment == null)
                        shareFragment = new ShareFragment();
                    Bundle args = new Bundle();

                    args.putString(shareFragment.ARG_PARAM1,"Yarden 6-ID"); // paramsData.Speaker());
                    args.putString(shareFragment.ARG_PARAM2, "");
                    shareFragment.setArguments(args);
                    return shareFragment;//ShareFragment.newInstance(paramsData.Speaker(), ""); //"Yarden 6-ID","");
                default:
                    return null;
            }
        }


        // Returns the page title for the top indicator
        @Override
        public CharSequence getPageTitle(int position) {
            return "" + (position + 1);//"Page " + position;
        }

    }


//    private String PROVIDER_NAME = "entity.AudioContentProvider";
//    private String URL = "content://" + PROVIDER_NAME +"/TBL_SPEAKERS";
//    private Uri SPEAKERS_CONTENT_URI = Uri.parse(URL);

    ViewPager pager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        paramsData = new ParamsData();

        //fillTheDB();

        pager = (ScrollerViewPager) findViewById(R.id.view_pager);
        pager.setAdapter(new MyPagerAdapter(getSupportFragmentManager()));

        SpringIndicator springIndicator = (SpringIndicator) findViewById(R.id.indicator);
        //pager.fixScrollSpeed();
        springIndicator.setViewPager(pager);


//        pager.setOnDragListener(new View.OnDragListener() {
//        @Override
//        public boolean onDrag(View view, DragEvent dragEvent) {
//            Toast.makeText(MainActivity.this, "on drag", Toast.LENGTH_LONG).show();
//            return true; //we handled the event please don't scroll
//            //return false;//we don't handle the event user can scroll
//        }
//        });

//        // Begin the transaction
//        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
//        // Replace the contents of the container with the new fragment
//        ft.replace(R.id.fragment_placeholder, new StartFragment());
//        // or ft.add(R.id.your_placeholder, new FooFragment());
//        // Complete the changes added above
//        ft.commit();




    }


//    private void fillTheDB() {
//        //int cntRowsDel = getContentResolver().delete(SpeakerEntry.CONTENT_URI, null, null);
//        //String[] mProjection = {"title"};
//        //Cursor cursor = getContentResolver().query(SpeakerEntry.CONTENT_URI, null, null, null, null); ////SPEAKERS_CONTENT_URI
//
//        //getSpeakers();
//        //Log.d("a", "after cursor");
//
//
////        ContentValues valuesSpeakers = new ContentValues();
////        valuesSpeakers.put("id", "1");
////        valuesSpeakers.put("name", "psich");
////        valuesSpeakers.put("plenum", "meod");
//
////        valuesSpeakers.put("id", "735");
////        valuesSpeakers.put("name", "Galil 6-I");
////        //valuesSpeakers.put("plenum", "meod");
////        valuesSpeakers.put("line", "Galil");
////        valuesSpeakers.put("quality", "comercial");
////
////        getContentResolver().insert(SPEAKERS_CONTENT_URI, valuesSpeakers);
//
//     /*   ContentValues valuesAmplifiers = new ContentValues();
//        valuesAmplifiers.put("id", "1");
//        valuesAmplifiers.put("name", "psich");
//        valuesAmplifiers.put("plenum", "meod");
//
//        getContentResolver().insert(CONTENT_URI, valuesAmplifiers);
//*/
//        //getContentResolver().create(SPEAKERS_CONTENT_URI);
//
//
//    }


    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    public void gotoNextFragment(View view) {
        //  Spinner spinner = (Spinner) findViewById(R.id.spinner_length);
        // Begin the transaction
        //FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        int viewId = view.getId();
        String name = view.getResources().getResourceEntryName(view.getId());//view.getTag().toString();
        switch (viewId) {
            case R.id.start_btn://If start goto noise floor
                // Replace the contents of the container with the new fragment
                //ft.replace(R.id.fragment_placeholder, adapterViewPager.getItem(2));// new NoiseFloorFragment());//adapterViewPager.getItem(2);
                pager.setCurrentItem(1);
                break;
            case R.id.noise_db45://If noise floor goto purpose
            case R.id.noise_db55:
            case R.id.noise_db60:
            case R.id.noise_db65:
            case R.id.noise_db75:
                //ft.replace(R.id.fragment_placeholder, new RoomPurposeFragment());
                paramsData.NoiseFloor(Integer.parseInt(name.substring(8,10)));
                pager.setCurrentItem(2);
                break;
            case R.id.pur_5://If purpose goto room size
            case R.id.pur_10:
            case R.id.pur_15:
            case R.id.pur_20:
                //ft.replace(R.id.fragment_placeholder, new RoomSizeFragment());
                paramsData.RoomPropose(Integer.parseInt(name.substring(4,6)));

                pager.setCurrentItem(3);
                break;
            case R.id.ins_1://If purpose goto room size
            case R.id.ins_2:
            case R.id.ins_3:
            case R.id.ins_4:
                ImageView btn = (ImageView) findViewById(viewId);
                paramsData.Installation(btn.getTag().toString());
                pager.setCurrentItem(5);
                break;

            case R.id.spk_1://If purpose goto room size
            case R.id.spk_2:
                //ft.replace(R.id.fragment_placeholder, new RoomSizeFragment());
                TextView txt;
                if (viewId == R.id.spk_1)
                    txt = (TextView) findViewById(R.id.spk_txt1);
                else
                    txt = (TextView) findViewById(R.id.spk_txt2);

                paramsData.Speaker(txt.getText().toString());
                pager.setCurrentItem(6);
                break;
        }
        // Complete the changes added above
//        ft.addToBackStack(null);
//        ft.commit();
    }

    public void plusClicked(View view) {

        TextView mytextview = (TextView) findViewById(R.id.height_btn);
        int num = Integer.parseInt(mytextview.toString());
        num += 10;
        mytextview.setText(Integer.toString(num));
    }
}

