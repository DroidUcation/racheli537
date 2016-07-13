package com.audio.kramer.configureaudio;

import android.content.ContentValues;
import android.content.Context;
import android.net.Uri;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.textservice.SpellCheckerSession;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;


import github.chenupt.springindicator.SpringIndicator;
import github.chenupt.springindicator.viewpager.ScrollerViewPager;
import layout.AmplifiersFragment;
import layout.InstallationFragment;
import layout.NoiseFloorFragment;
import layout.RoomPurposeFragment;
import layout.RoomSizeFragment;
import layout.SpeakerOptionFragment;
import layout.StartFragment;

public class MainActivity extends FragmentActivity implements StartFragment.OnFragmentInteractionListener ,
        NoiseFloorFragment.OnFragmentInteractionListener , RoomPurposeFragment.OnFragmentInteractionListener ,
        RoomSizeFragment.OnFragmentInteractionListener , InstallationFragment.OnFragmentInteractionListener ,
        SpeakerOptionFragment.OnFragmentInteractionListener, AmplifiersFragment.OnFragmentInteractionListener{

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

        // Returns the fragment to display for that page
        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0: // Fragment # 0 - This will show FirstFragment
                    return StartFragment.newInstance("1", "start");
                case 1: // Fragment # 0 - This will show FirstFragment different title
                    //Toast.makeText(co, "before move page", Toast.LENGTH_LONG).show();
                    Log.d("pa", "before move page");
                    return NoiseFloorFragment.newInstance("2", "NoiseFloorFragment"); //new NoiseFloorFragment();
                case 2: // Fragment # 1 - This will show SecondFragment
                    return new RoomPurposeFragment();//SecondFragment.newInstance(2, "Page # 3");
                case 3: // Fragment # 1 - This will show SecondFragment
                    return new RoomSizeFragment();//SecondFragment.newInstance(2, "Page # 3");
                case 4: // Fragment # 1 - This will show SecondFragment
                    return new InstallationFragment();//SecondFragment.newInstance(2, "Page # 3");
                case 5: // Fragment # 1 - This will show SecondFragment
                    return new SpeakerOptionFragment();//SecondFragment.newInstance(2, "Page # 3");
                case 6: // Fragment # 1 - This will show SecondFragment
                    return new AmplifiersFragment();//SecondFragment.newInstance(2, "Page # 3");
                default:
                    return null;
            }
        }

        // Returns the page title for the top indicator
        @Override
        public CharSequence getPageTitle(int position) {
            return ""+ (position + 1);//"Page " + position;
        }

    }

    private String PROVIDER_NAME = "entity.AudioContentProvider";
    private String URL = "content://" + PROVIDER_NAME +"/TBL_AMP";
    private Uri SPEAKERS_CONTENT_URI = Uri.parse(URL);

    ViewPager pager;
    //FragmentPagerAdapter adapterViewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fillTheDB();

        pager = (ScrollerViewPager) findViewById(R.id.view_pager);
        pager.setAdapter(new MyPagerAdapter(getSupportFragmentManager()));

        SpringIndicator springIndicator = (SpringIndicator) findViewById(R.id.indicator);
        springIndicator.setViewPager(pager);

    }
    private void fillTheDB() {
        ContentValues valuesSpeakers = new ContentValues();
        valuesSpeakers.put("id", "1");
        valuesSpeakers.put("name", "psich");
        valuesSpeakers.put("plenum", "meod");

        getContentResolver().insert(SPEAKERS_CONTENT_URI, valuesSpeakers);
        getContentResolver().query(SPEAKERS_CONTENT_URI, null,null,null,null);



    }

    @Override
    public void onFragmentInteraction(Uri uri) {
        
    }

    public void gotoNextFragment(View view) {
         int viewId = view.getId();
        switch (viewId) {
            case R.id.start_btn://If start goto noise floor
                pager.setCurrentItem(1);
                break;

            case R.id.noise_db45://If noise floor goto purpose
            case R.id.noise_db55:
            case R.id.noise_db60:
            case R.id.noise_db65:
            case R.id.noise_db75:
                pager.setCurrentItem(2);
                break;
            case R.id.pur_5://If purpose goto room size
            case R.id.pur_10:
            case R.id.pur_15:
            case R.id.pur_20:
                pager.setCurrentItem(3);
                break;
            case R.id.next1:
                pager.setCurrentItem(4);
                break;
            case R.id.ins_1:
            case R.id.ins_2:
            case R.id.ins_3:
            case R.id.ins_4:
              //  pager.setCurrentItem(5);
                break;
        }
        // Complete the changes added above
//        ft.addToBackStack(null);
//        ft.commit();
    }
    public void plusClicked(View view)
    {
        TextView mytextview = (TextView) findViewById(R.id.height_btn);
        int num = Integer.parseInt(mytextview.toString());
        num += 10;
        mytextview.setText(Integer.toString(num));
    }
}
