package com.audio.kramer.configureaudio;


import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Color;
import android.media.Image;
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
import android.widget.ListView;
import android.widget.Spinner;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import java.util.Timer;
import java.util.TimerTask;

import java.util.ArrayList;
import java.util.List;

import entity.AudioCursorAdapter;
import entity.ParamsData;
import entity.Speaker;
import entity.entries.AmpEntry;
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


    //public String nameSpeaker ="";
    public ParamsData paramsData;

//    public static class MyPagerAdapter extends FragmentPagerAdapter {
//        private static int NUM_ITEMS = 7;
//
//        public MyPagerAdapter(FragmentManager fragmentManager) {
//            super(fragmentManager);
//        }
//
//        // Returns total number of pages
//        @Override
//        public int getCount() {
//            return NUM_ITEMS;
//        }
//        StartFragment startFragment;
//        NoiseFloorFragment noiseFloorFragment;
//        RoomPurposeFragment roomPurposeFragment;
//        RoomSizeFragment roomSizeFragment;
//        InstallationFragment installationFragment;
//        SpeakerFragment speakerFragment;
//        ShareFragment shareFragment;
//        AmplifiersFragment amplifiersFragment;
//
//        // Returns the fragment to display for that page
//        @Override
//        public Fragment getItem(int position) {
//
//            switch (position) {
//                case 0: // Fragment # 0 - This will show FirstFragment different title
//                    if (startFragment == null)
//                        startFragment = new StartFragment();
//                    return startFragment;
//                case 1:
//                    if (noiseFloorFragment == null)
//                        noiseFloorFragment = new NoiseFloorFragment();
//                    return noiseFloorFragment;
//                //return NoiseFloorFragment.newInstance("2", "NoiseFloorFragment"); //new NoiseFloorFragment();
//                case 2: // Fragment # 1 - This will show SecondFragment
//                    if (roomPurposeFragment == null)
//                        roomPurposeFragment = new RoomPurposeFragment();
//                    return roomPurposeFragment;
//                //return new RoomPurposeFragment();//SecondFragment.newInstance(2, "Page # 3");
//                case 3: // Fragment # 1 - This will show SecondFragment
//                    if (roomSizeFragment == null)
//                        roomSizeFragment = new RoomSizeFragment();
//                    return roomSizeFragment;
//                //return new RoomSizeFragment();//SecondFragment.newInstance(2, "Page # 3");
//                case 4: // Fragment # 1 - This will show SecondFragment
//                    if (installationFragment == null)
//                        installationFragment = new InstallationFragment();
//                    return installationFragment;
//                //return new InstallationFragment();//SecondFragment.newInstance(2, "Page # 3");
//                case 5: // Fragment # 1 - This will show SecondFragment
//                    if (speakerFragment == null)
//                        speakerFragment = new SpeakerFragment();
////                    Bundle args = new Bundle();
////                    args.putAll(args);// SpeakerFragment.paramsData, paramsData);
//                    //speakerFragment.setArguments(args);
//                    return speakerFragment;//SpeakerFragment.newInstance(paramsData);
//                //return speakerFragment;
//                //return new SpeakerOptionFragment();//SecondFragment.newInstance(2, "Page # 3");
//                case 6: // Fragment # 1 - This will show SecondFragment
//                    //return new AmplifiersFragment();//SecondFragment.newInstance(2, "Page # 3");
//                    //if (paramsData.Speaker() > 0)
////                    if (shareFragment == null)
////                        shareFragment = new ShareFragment();
////                    Bundle args = new Bundle();
////
////                    args.putString(shareFragment.ARG_PARAM1,"Yarden 6-ID"); // paramsData.Speaker());
////                    args.putString(shareFragment.ARG_PARAM2, "");
//                    //shareFragment.setArguments(args);
//                    return new ShareFragment();//ShareFragment.newInstance(paramsData.Speaker(), ""); //"Yarden 6-ID","");
//                default:
//                    return null;
//            }
//        }
//
//
//        // Returns the page title for the top indicator
//        @Override
//        public CharSequence getPageTitle(int position) {
//            return "" + (position + 1);//"Page " + position;
//        }
//
//    }

    class MyPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public MyPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFragment(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }

    ViewPager pager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        paramsData = new ParamsData();

        pager = (ScrollerViewPager) findViewById(R.id.view_pager);
//        pager.setAdapter(new MyPagerAdapter(getSupportFragmentManager()));
        setupViewPager(pager);

        SpringIndicator springIndicator = (SpringIndicator) findViewById(R.id.indicator);
        //pager.fixScrollSpeed();
        springIndicator.setViewPager(pager);


//        // Begin the transaction
//        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
//        // Replace the contents of the container with the new fragment
//        ft.replace(R.id.fragment_placeholder, new StartFragment());
//        // or ft.add(R.id.your_placeholder, new FooFragment());
//        // Complete the changes added above
//        ft.commit();

        pager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position) {
                    case 3:
                        setDataSize();
                        break;
                    case 5:
                        getSpeakersData();
                        break;
                    case 6:
                        getAmpData();
                        break;
                    case 7:
                        getDataShare();
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });

//        pager.setOnDragListener(new View.OnDragListener() {
//            @Override
//            public boolean onDrag(View view, DragEvent dragEvent) {
//                Toast.makeText(MainActivity.this, "on drag", Toast.LENGTH_LONG).show();
//                return true; //we handled the event please don't scroll
//                //return false;//we don't handle the event user can scroll
//            }
//        });
    }

    private void setupViewPager(ViewPager viewPager) {
        MyPagerAdapter adapter = new MyPagerAdapter(getSupportFragmentManager());

//        bundle = new Bundle();
//        bundle.putIntArray("dogruYanlis", dogruYanlis);

        StartFragment startFragment = new StartFragment();
        NoiseFloorFragment noiseFloorFragment = new NoiseFloorFragment();
        RoomPurposeFragment roomPurposeFragment = new RoomPurposeFragment();
        RoomSizeFragment roomSizeFragment = new RoomSizeFragment();
        InstallationFragment installationFragment = new InstallationFragment();
        SpeakerFragment speakerFragment = new SpeakerFragment();
        ShareFragment shareFragment = new ShareFragment();
        AmplifiersFragment amplifiersFragment = new AmplifiersFragment();
        //ShareFragment.setArguments(bundle);

        adapter.addFragment(startFragment, "1");//"start");
        adapter.addFragment(noiseFloorFragment, "2");//"Noise Floor");
        adapter.addFragment(roomPurposeFragment, "3");//"Purpose");
        adapter.addFragment(roomSizeFragment,"4");//"start");
        adapter.addFragment(installationFragment, "5");// "installatio");
        adapter.addFragment(speakerFragment, "6");//"Speakers");
        adapter.addFragment(amplifiersFragment, "7");//"Speakers");
        adapter.addFragment(shareFragment, "8");//"Share");
        viewPager.setAdapter(adapter);
    }

    private void setDataSize()
    {
        TextView txtSize;
        if (paramsData.High() > 0) {
            txtSize = (TextView) findViewById(R.id.height_btn) ;
            txtSize.setText(String.valueOf(paramsData.High()));
        }
        if (paramsData.Length() > 0) {
            txtSize = (TextView) findViewById(R.id.length_btn);
            txtSize.setText(String.valueOf(paramsData.Length()));
        }
        if (paramsData.Width() > 0){
            txtSize = (TextView) findViewById(R.id.width_btn);
            txtSize.setText(String.valueOf(paramsData.Width()));
        }
    }

    private void getDataShare() {
        Cursor cursor;
        try {
            String[] projection =  {SpeakerEntry.ID, SpeakerEntry.PORT_NUMBER, SpeakerEntry.NAME, SpeakerEntry.DESCRIPTION}; //"aaa description", "123 port_number"};
            String selection = SpeakerEntry.NAME + " = ? ";
            String[] strArgs = {paramsData.Speaker()};
            Uri uri = DatabaseContract.BASE_CONTENT_URI.buildUpon().appendPath(DatabaseContract.PATH_SPEAKER_FILTER).build();
            cursor = getContentResolver().query(SpeakerEntry.CONTENT_URI, projection, selection, strArgs, null);
            if (cursor.getCount() > 0) {
                AudioCursorAdapter customAdapter = new AudioCursorAdapter(this, cursor);
                ListView listView = (ListView) findViewById(R.id.list_speaker);
                listView.setAdapter(customAdapter);
                //cursor.close();
            }

            //projection =  {SpeakerEntry.ID, SpeakerEntry.PORT_NUMBER, SpeakerEntry.NAME, SpeakerEntry.DESCRIPTION}; //"aaa description", "123 port_number"};
            //selection = SpeakerEntry.NAME + " = ? ";
            String[] strArgs2 = {paramsData.Amplifier()};
            uri = DatabaseContract.BASE_CONTENT_URI.buildUpon().appendPath(DatabaseContract.PATH_SPEAKER_FILTER).build();
            cursor = getContentResolver().query(AmpEntry.CONTENT_URI, projection, selection, strArgs2, null);
            if (cursor.getCount() > 0) {
                AudioCursorAdapter customAdapter = new AudioCursorAdapter(this, cursor);
                ListView listView = (ListView) findViewById(R.id.list_amp);
                listView.setAdapter(customAdapter);
                //cursor.close();
            }
        }
        catch (Exception e) {
            e.getStackTrace();
            Log.e("Message err", e.getMessage());
        }
    }

    private void getAmpData() {
        try {
//            String strFilterInches = "";
//            if (paramsData.Installation() == SpeakerEntry.INSTALLATION_CEILING || paramsData.Installation() == SpeakerEntry.INSTALLATION_CEILING_TILE) {
//                if (paramsData.High() <= 3)
//                    strFilterInches = "4";
//                else if (paramsData.High() > 3 && paramsData.High() <= 5)
//                    strFilterInches = "6.5";
//                else if (paramsData.High() > 5)// && paramsData.High() <= 8)
//                    strFilterInches = "8";
//            } else {
//                if (paramsData.Width() <= 3)
//                    strFilterInches = "4";
//                else if (paramsData.Width() > 3 && paramsData.Width() <= 5)
//                    strFilterInches = "5.25";
//                else if (paramsData.Width() > 5)
//                    strFilterInches = "6.5";
//            }

            //String[] strArgs = {paramsData.Installation(), strFilterInches};
            Uri uri = DatabaseContract.BASE_CONTENT_URI.buildUpon().appendPath(AmpEntry.TBL_AMP).build();
            Cursor cursor = getContentResolver().query(uri, null, null, null, null); ////SPEAKERS_CONTENT_URI

            int flag = 0;
            //if (cursor.getCount() > 0)
            if (cursor.moveToFirst()) {
                while (!cursor.isAfterLast() && flag < 3) { // If you use c.moveToNext() here, you will bypass the first row, which is WRONG
                    flag++;
                    //String strDescription = cursor.getString(cursor.getColumnIndexOrThrow(AmpEntry.INCHES)) + "-Inch, " + cursor.getString(cursor.getColumnIndexOrThrow(AmpEntry.INSTALLATION)) + " Speakers";
                    if (flag == 1) {
                        TextView txt1 = (TextView) findViewById(R.id.amp_txt1);
                        txt1.setText(cursor.getString(cursor.getColumnIndexOrThrow(AmpEntry.NAME)));
                        txt1.setVisibility(View.VISIBLE);
                        TextView txt11 = (TextView) findViewById(R.id.amp_txt11);
                        txt11.setText(cursor.getString(cursor.getColumnIndexOrThrow(AmpEntry.DESCRIPTION)));
                        txt11.setVisibility(View.VISIBLE);
                        TextView txt111 = (TextView) findViewById(R.id.amp_txt111);
                        txt111.setText(cursor.getString(cursor.getColumnIndexOrThrow(AmpEntry.INPUT)));
                        txt111.setVisibility(View.VISIBLE);
                        Button btn1 = (Button) findViewById(R.id.amp_1);
                        btn1.setText(getTextBtn(cursor.getString(cursor.getColumnIndexOrThrow(AmpEntry.CONTROL)), cursor.getString(cursor.getColumnIndexOrThrow(AmpEntry.SPECIAL))));
                        btn1.setVisibility(View.VISIBLE);
                    } else if (flag == 2) {
                    TextView txt1 = (TextView) findViewById(R.id.amp_txt2);
                    txt1.setText(cursor.getString(cursor.getColumnIndexOrThrow(AmpEntry.NAME)));
                    txt1.setVisibility(View.VISIBLE);
                    TextView txt11 = (TextView) findViewById(R.id.amp_txt22);
                    txt11.setText(cursor.getString(cursor.getColumnIndexOrThrow(AmpEntry.DESCRIPTION)));
                    txt11.setVisibility(View.VISIBLE);
                    TextView txt111 = (TextView) findViewById(R.id.amp_txt222);
                    txt111.setText(cursor.getString(cursor.getColumnIndexOrThrow(AmpEntry.INPUT)));
                    txt111.setVisibility(View.VISIBLE);
                    Button btn2 = (Button) findViewById(R.id.amp_2);
                    btn2.setText(getTextBtn(cursor.getString(cursor.getColumnIndexOrThrow(AmpEntry.CONTROL)), cursor.getString(cursor.getColumnIndexOrThrow(AmpEntry.SPECIAL))));
                    btn2.setVisibility(View.VISIBLE);
                } else if (flag == 3) {
                    TextView txt1 = (TextView) findViewById(R.id.amp_txt3);
                    txt1.setText(cursor.getString(cursor.getColumnIndexOrThrow(AmpEntry.NAME)));
                    txt1.setVisibility(View.VISIBLE);
                    TextView txt11 = (TextView) findViewById(R.id.amp_txt33);
                    txt11.setText(cursor.getString(cursor.getColumnIndexOrThrow(AmpEntry.DESCRIPTION)));
                    txt11.setVisibility(View.VISIBLE);
                    TextView txt111 = (TextView) findViewById(R.id.amp_txt333);
                    txt111.setText(cursor.getString(cursor.getColumnIndexOrThrow(AmpEntry.INPUT)));
                    txt111.setVisibility(View.VISIBLE);
                    Button btn2 = (Button) findViewById(R.id.amp_3);
                    btn2.setText(getTextBtn(cursor.getString(cursor.getColumnIndexOrThrow(AmpEntry.CONTROL)), cursor.getString(cursor.getColumnIndexOrThrow(AmpEntry.SPECIAL))));
                    btn2.setVisibility(View.VISIBLE);
                    }
                    cursor.moveToNext();
                }

//                if (flag < 2) { //paramsData.Installation() == AmpEntry.INSTALLATION_CEILING_TILE) {
//                    Button btn2 = (Button) findViewById(R.id.amp_2);
//                    btn2.setVisibility(View.GONE);
//                    TextView txt2 = (TextView) findViewById(R.id.amp_txt2);
//                    txt2.setVisibility(View.GONE);
//                    TextView txt22 = (TextView) findViewById(R.id.amp_txt22);
//                    txt22.setVisibility(View.GONE);
//                    //Toast.makeText(getActivity(),"Text!",Toast.LENGTH_SHORT).show();
//                }
                cursor.close();
            }
            else
            {//no found speakers
                TextView txt1 = (TextView) findViewById(R.id.spk_txt1);
                txt1.setVisibility(View.GONE);
                txt1.setText("");
                TextView txt11 = (TextView) findViewById(R.id.spk_txt11);
                txt11.setVisibility(View.GONE);
                Button btn1 = (Button) findViewById(R.id.spk_1);
                btn1.setVisibility(View.GONE);
                Button btn2 = (Button) findViewById(R.id.spk_2);
                btn2.setVisibility(View.GONE);
                TextView txt2 = (TextView) findViewById(R.id.spk_txt2);
                txt2.setVisibility(View.GONE);
                txt2.setText("");
                TextView txt22 = (TextView) findViewById(R.id.spk_txt22);
                txt22.setVisibility(View.GONE);

            }

        }

        catch (Exception e) {
            e.getStackTrace();
            Log.e("Message err", e.getMessage());
        }
//        finally{
//            if(cursor != null && !cursor.isClosed()){
//                cursor.close();
//            }
    }

    private String getTextBtn(String strControl, String strSpecial)
    {
        String strTxtBtn = "";
        if (strControl == "Y")
            strTxtBtn = "with control";
        else if (strSpecial != "")
            strTxtBtn = strSpecial;
        return strTxtBtn;
    }
    private void getSpeakersData() {
        try {
            String strFilterInches = "";
            if (paramsData.Installation().equals(SpeakerEntry.INSTALLATION_CEILING ) || paramsData.Installation().equals(SpeakerEntry.INSTALLATION_CEILING_TILE )){//SpeakerEntry.INSTALLATION_CEILING_TILE) {
                if (paramsData.High() <= 3)
                    strFilterInches = "4";
                else if (paramsData.High() > 3 && paramsData.High() <= 5)
                    strFilterInches = "6.5";
                else if (paramsData.High() > 5)// && paramsData.High() <= 8)
                    strFilterInches = "8";
            } else {
                if (paramsData.Width() <= 3)
                    strFilterInches = "4";
                else if (paramsData.Width() > 3 && paramsData.Width() <= 5)
                    strFilterInches = "5.25";
                else if (paramsData.Width() > 5)
                    strFilterInches = "6.5";
            }

            String[] strArgs = {paramsData.Installation(), strFilterInches};
            Uri uri = DatabaseContract.BASE_CONTENT_URI.buildUpon().appendPath(DatabaseContract.PATH_SPEAKER_FILTER).build();
            Cursor cursor = getContentResolver().query(uri, null, null, strArgs, SpeakerEntry.QUALITY); ////SPEAKERS_CONTENT_URI

            int flag = 0;
            //if (cursor.getCount() > 0)
            if (cursor.moveToFirst()) {
                while (!cursor.isAfterLast() && flag < 2) { // If you use c.moveToNext() here, you will bypass the first row, which is WRONG
                    flag++;
                    //String strDescription = cursor.getString(cursor.getColumnIndexOrThrow(SpeakerEntry.INCHES)) + "-Inch, " + cursor.getString(cursor.getColumnIndexOrThrow(SpeakerEntry.INSTALLATION)) + " Speakers";
                    if (flag == 1) {
                        TextView txt1 = (TextView) findViewById(R.id.spk_txt1);
                        txt1.setText(cursor.getString(cursor.getColumnIndexOrThrow(SpeakerEntry.NAME)));
                        txt1.setVisibility(View.VISIBLE);
                        TextView txt11 = (TextView) findViewById(R.id.spk_txt11);
                        txt11.setText(cursor.getString(cursor.getColumnIndexOrThrow(SpeakerEntry.DESCRIPTION)));
                        txt11.setVisibility(View.VISIBLE);
                        Button btn1 = (Button) findViewById(R.id.spk_1);
                        btn1.setText("Comercial");
                        btn1.setVisibility(View.VISIBLE);
                        switch (paramsData.Installation()) {
                            case SpeakerEntry.INSTALLATION_CEILING_TILE:
                                btn1.setBackground(getResources().getDrawable(R.drawable.ceiling_tile_hp));
                                btn1.setText("High Performance");
                                break;
                            case SpeakerEntry.INSTALLATION_CEILING:
                                btn1.setBackground(getResources().getDrawable(R.drawable.ceiling_com));
                                break;
                            case SpeakerEntry.INSTALLATION_ON_WALL:
                                btn1.setBackground(getResources().getDrawable(R.drawable.on_wall_com));
                                break;
                            case SpeakerEntry.INSTALLATION_IN_WALL:
                                btn1.setBackground(getResources().getDrawable(R.drawable.in_wall_com));
                                break;
                            default:
                                break;
                        }
                    } else if (flag == 2) {
                        TextView txt1 = (TextView) findViewById(R.id.spk_txt2);
                        txt1.setText(cursor.getString(cursor.getColumnIndexOrThrow(SpeakerEntry.NAME)));
                        txt1.setVisibility(View.VISIBLE);
                        TextView txt11 = (TextView) findViewById(R.id.spk_txt22);
                        txt11.setText(cursor.getString(cursor.getColumnIndexOrThrow(SpeakerEntry.DESCRIPTION)));
                        txt11.setVisibility(View.VISIBLE);
                        Button btn2 = (Button) findViewById(R.id.spk_2);
                        btn2.setText("High Performance");
                        btn2.setVisibility(View.VISIBLE);
                        switch (paramsData.Installation()) {
//                        case SpeakerEntry.INSTALLATION_CEILING_TILE:
//                            btn2.setBackground(getResources().getDrawable(R.drawable.ceiling_tile_hp));
//                            break;
                            case SpeakerEntry.INSTALLATION_CEILING:
                                btn2.setBackground(getResources().getDrawable(R.drawable.ceiling_hp));
                                break;
                            case SpeakerEntry.INSTALLATION_ON_WALL:
                                btn2.setBackground(getResources().getDrawable(R.drawable.on_wall_hp));
                                break;
                            case SpeakerEntry.INSTALLATION_IN_WALL:
                                btn2.setBackground(getResources().getDrawable(R.drawable.in_wall_hp));
                                break;
                            default:
                                break;
                        }

                    }
                    cursor.moveToNext();
                }

                if (flag < 2) { //paramsData.Installation() == SpeakerEntry.INSTALLATION_CEILING_TILE) {
                    Button btn2 = (Button) findViewById(R.id.spk_2);
                    btn2.setVisibility(View.GONE);
                    TextView txt2 = (TextView) findViewById(R.id.spk_txt2);
                    txt2.setVisibility(View.GONE);
                    TextView txt22 = (TextView) findViewById(R.id.spk_txt22);
                    txt22.setVisibility(View.GONE);
                    //Toast.makeText(getActivity(),"Text!",Toast.LENGTH_SHORT).show();
                }
                cursor.close();
            }
            else
            {//no found speakers
                TextView txt1 = (TextView) findViewById(R.id.spk_txt1);
                txt1.setVisibility(View.GONE);
                txt1.setText("");
                TextView txt11 = (TextView) findViewById(R.id.spk_txt11);
                txt11.setVisibility(View.GONE);
                Button btn1 = (Button) findViewById(R.id.spk_1);
                btn1.setVisibility(View.GONE);
                Button btn2 = (Button) findViewById(R.id.spk_2);
                btn2.setVisibility(View.GONE);
                TextView txt2 = (TextView) findViewById(R.id.spk_txt2);
                txt2.setVisibility(View.GONE);
                txt2.setText("");
                TextView txt22 = (TextView) findViewById(R.id.spk_txt22);
                txt22.setVisibility(View.GONE);

            }

        }

        catch (Exception e) {
            e.getStackTrace();
            Log.e("Message err", e.getMessage());
        }
//        finally{
//            if(cursor != null && !cursor.isClosed()){
//                cursor.close();
//            }
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
    Button myButton;
    public void gotoNextFragment(View view) {
        //  Spinner spinner = (Spinner) findViewById(R.id.spinner_length);
        // Begin the transaction
        //FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        int viewId = view.getId();
        String name = view.getResources().getResourceEntryName(view.getId());//view.getTag().toString();
        switch (viewId) {
            case R.id.start_btn://If start goto noise floor
                Timer t = new Timer();
                t.schedule(new TimerTask() {

                    @Override
                    public void run() {
                        runOnUiThread(new Runnable() {

                            @Override
                            public void run() {
                                pager.setCurrentItem(1);
                            }
                        });
                    }
                }, 200);


                // Replace the contents of the container with the new fragment
                //ft.replace(R.id.fragment_placeholder, adapterViewPager.getItem(2));// new NoiseFloorFragment());//adapterViewPager.getItem(2);
                break;
            case R.id.noise_db45://If noise floor goto purpose
            case R.id.noise_db55:
            case R.id.noise_db60:
            case R.id.noise_db65:
            case R.id.noise_db75:
                //ft.replace(R.id.fragment_placeholder, new RoomPurposeFragment());
                paramsData.NoiseFloor(Integer.parseInt(name.substring(8,10)));
              //  pager.postDelayed(pager.setCurrentItem(2),5000);
                pager.setCurrentItem(2, true);
                break;
            case R.id.pur_5://If purpose goto room size
            case R.id.pur_10:
            case R.id.pur_15:
            case R.id.pur_20:
                //ft.replace(R.id.fragment_placeholder, new RoomSizeFragment());
                if (viewId == R.id.pur_5)
                    paramsData.RoomPropose(Integer.parseInt(name.substring(4,5)));
                else
                    paramsData.RoomPropose(Integer.parseInt(name.substring(4,6)));

                pager.setCurrentItem(3,true);
                break;
            case R.id.next1:
                TextView txtSize = (TextView) findViewById(R.id.height_btn) ;
                paramsData.High(Integer.parseInt(txtSize.getText().toString()));
                txtSize = (TextView) findViewById(R.id.length_btn) ;
                paramsData.Length(Integer.parseInt(txtSize.getText().toString()));
                txtSize = (TextView) findViewById(R.id.width_btn) ;
                paramsData.Width(Integer.parseInt(txtSize.getText().toString()));
                pager.setCurrentItem(4, true);
                break;
            case R.id.ins_1://If purpose goto room size
            case R.id.ins_2:
            case R.id.ins_3:
            case R.id.ins_4:
                ImageView btn = (ImageView) findViewById(viewId);
                paramsData.Installation(btn.getTag().toString());
                //getSpeakersData();
                pager.setCurrentItem(5, true);
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
                //getDataShare();
                pager.setCurrentItem(6, true);
                break;

            case R.id.amp_1://If purpose goto room size
            case R.id.amp_2:
            case R.id.amp_3:
                //ft.replace(R.id.fragment_placeholder, new RoomSizeFragment());
                TextView txtAmp;
                if (viewId == R.id.amp_1)
                    txtAmp = (TextView) findViewById(R.id.amp_txt1);
                else if (viewId == R.id.amp_2)
                    txtAmp = (TextView) findViewById(R.id.amp_txt2);
                else
                    txtAmp = (TextView) findViewById(R.id.amp_txt3);

                paramsData.Amplifier(txtAmp.getText().toString());
                //getDataShare();
                pager.setCurrentItem(7, true);
                break;

//            Bundle bundle = new Bundle();
//            String myMessage = "Stackoverflow is cool!";
//            bundle.putString("message", myMessage );
//            RoomPurposeFragment fragInfo = new RoomPurposeFragment();
//            fragInfo.setArguments(bundle);‏

        }
        // Complete the changes added above
//        ft.addToBackStack(null);
//        ft.commit();
    }

    public void ShareBtnClick(View view)
    {
        Intent sendIntent = new Intent();
        sendIntent.setAction(Intent.ACTION_SEND);
        sendIntent.putExtra(Intent.EXTRA_TEXT, "This is my text to send.");
        sendIntent.setType("text/plain");
        startActivity(sendIntent);
    }

    public void plusClicked(View view)
    {
        int id = view.getId();
        TextView currentText  = (TextView) findViewById(R.id.height_btn);;
        switch (id) {
            case R.id.height_plus:
                currentText = (TextView) findViewById(R.id.height_btn);
                break;
            case R.id.width_plus:
                currentText = (TextView) findViewById(R.id.width_btn);
                break;
            case R.id.length_plus:
                currentText = (TextView) findViewById(R.id.length_btn);
                break;

        }
        String numText = currentText.getText().toString();
        int num = Integer.parseInt(numText);
        num += 1;
        currentText.setText(Integer.toString(num));
    }

    public void minusClicked(View view)
    {
        int id = view.getId();
        TextView currentText  = (TextView) findViewById(R.id.height_btn);;
        switch (id) {
            case R.id.height_minus:
                currentText = (TextView) findViewById(R.id.height_btn);
                break;
            case R.id.width_minus:
                currentText = (TextView) findViewById(R.id.width_btn);
                break;
            case R.id.length_minus:
                currentText = (TextView) findViewById(R.id.length_btn);
                break;

        }

        String numText = currentText.getText().toString();
        int num = Integer.parseInt(numText);
        if(num > 0)
            num -= 1;
        currentText.setText(Integer.toString(num));
    }
}


