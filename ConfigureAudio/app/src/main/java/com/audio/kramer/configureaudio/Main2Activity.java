package com.audio.kramer.configureaudio;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import github.chenupt.springindicator.SpringIndicator;
import layout.NoiseFloorFragment;
import layout.RoomPurposeFragment;
import layout.RoomSizeFragment;
import layout.StartFragment;

import github.chenupt.multiplemodel.viewpager.ModelPagerAdapter;
import github.chenupt.multiplemodel.viewpager.PagerModelManager;
import github.chenupt.springindicator.SpringIndicator;
import github.chenupt.springindicator.viewpager.ScrollerViewPager;


public class Main2Activity extends AppCompatActivity {

    public static class MyPagerAdapter extends FragmentPagerAdapter {
        private static int NUM_ITEMS = 4;

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
                    return NoiseFloorFragment.newInstance("2", "NoiseFloorFragment"); //new NoiseFloorFragment();
                case 2: // Fragment # 1 - This will show SecondFragment
                    return new RoomPurposeFragment();//SecondFragment.newInstance(2, "Page # 3");
                case 3: // Fragment # 1 - This will show SecondFragment
                    return new RoomSizeFragment();//SecondFragment.newInstance(2, "Page # 3");
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

    //FragmentPagerAdapter adapterViewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Toast.makeText(Main2Activity.this, "on create", Toast.LENGTH_LONG).show();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

//        ViewPager vpPager = (ViewPager) findViewById(R.id.vpPager);
//        adapterViewPager = new MyPagerAdapter(getSupportFragmentManager());
//        vpPager.setAdapter(adapterViewPager);


        ViewPager pager = (ScrollerViewPager) findViewById(R.id.view_pager);
        pager.setAdapter(new MyPagerAdapter(getSupportFragmentManager()));

        SpringIndicator springIndicator = (SpringIndicator) findViewById(R.id.indicator);
        //pager.fixScrollSpeed();
        springIndicator.setViewPager(pager);
///////////////////

//        viewPager = (ScrollerViewPager) findViewById(R.id.view_pager);
//        SpringIndicator springIndicator = (SpringIndicator) findViewById(R.id.indicator);
//        Toolbar toolbar = (Toolbar) findViewById(R.id.tool_bar);
//        setSupportActionBar(toolbar);

//        PagerModelManager manager = new PagerModelManager();
//        manager.addCommonFragment(GuideFragment.class, getBgRes(), getTitles());
//        ModelPagerAdapter adapter = new ModelPagerAdapter(getSupportFragmentManager(), manager);
//        viewPager.setAdapter(adapter);//
//        pager.fixScrollSpeed();

        // just set viewPager
//        springIndicator.setViewPager(viewPager);
    }

//    private class MyPagerAdapter extends FragmentPagerAdapter {
//
//        public MyPagerAdapter(FragmentManager fm) {
//            super(fm);
//        }
//
//        @Override
//        public Fragment getItem(int pos) {
//            switch(pos) {
//
//                case  0: return StartFragment.newInstance("FirstFragment, Instance 1", "0");
//                case 1: return NoiseFloorFragment.newInstance("SecondFragment, Instance 2", "1");
//                case 2: return RoomPurposeFragment.newInstance("ThirdFragment, Instance 3", "3");
//                case 3: return RoomSizeFragment.newInstance("ThirdFragment, Instance 4", "4");
////                case 4: return ThirdFragment.newInstance("ThirdFragment, Instance 3");
//                default: return StartFragment.newInstance("FirstFragment, Instance 1", "0");//return null; //ThirdFragment.newInstance("ThirdFragment, Default");
//            }
//        }
//
//        @Override
//        public int getCount() {
//            return 5;
//        }
//    }
}
