package com.example.administrator.myapplication.activity.mio;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.myapplication.R;

public class MioActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, MyDrawerListener {
    private ViewPager viewPager;
    private TabLayout tabLayout;
    private DrawerLayout drawer;
    private String[] mTitles = new String[]{"首页", "圈子", "约星", "我的"};
    private TabLayout.Tab one;
    private TabLayout.Tab two;
    private TabLayout.Tab three;
    private TabLayout.Tab four;
    private OneFragment oneFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mio);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        oneFragment = new OneFragment();
        oneFragment.setOnDrawListener(this);

        init_viewpager();
        initEvents();
    }

    private void init_viewpager() {
        viewPager = (ViewPager) findViewById(R.id.my_viewPager);
        tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        viewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {

            @Override
            public Fragment getItem(int position) {
                if (position == 1) {
                    return new TwoFragment();
                } else if (position == 2) {
                    return new ThreeFragment();
                } else if (position == 3) {
                    return new FourFragment();
                }
                return oneFragment;
            }

            @Override
            public int getCount() {
                return mTitles.length;
            }

            @Override
            public CharSequence getPageTitle(int position) {
                return mTitles[position];
            }

        });
        tabLayout.setupWithViewPager(viewPager);
//        LayoutInflater mLayoutInflater = this.getLayoutInflater();
//        for (int i = 0; i < 4; i++) {
//            TabLayout.Tab tab = tabLayout.newTab();
//
//            View view = mLayoutInflater.inflate(R.layout.main_tab, null);
//            tab.setCustomView(view);
//
//            TextView text = (TextView) view.findViewById(R.id.tab_text);
//            text.setText(mTitles[i]);
//            ImageView image = (ImageView) view.findViewById(R.id.tab_img);
//            tabLayout.addTab(tab);
//        }
        one = tabLayout.getTabAt(0);
        two = tabLayout.getTabAt(1);
        three = tabLayout.getTabAt(2);
        four = tabLayout.getTabAt(3);
        one.setIcon(getResources().getDrawable(R.mipmap.damenkou1));
        one.setText(mTitles[0]);
        two.setIcon(getResources().getDrawable(R.mipmap.damenkou1));
        two.setText(mTitles[1]);
        three.setIcon(getResources().getDrawable(R.mipmap.damenkou1));
        three.setText(mTitles[2]);
        four.setIcon(getResources().getDrawable(R.mipmap.damenkou1));
        four.setText(mTitles[3]);

    }

    private void initEvents() {

        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                if (tab == tabLayout.getTabAt(0)) {
                    one.setIcon(getResources().getDrawable(R.mipmap.damenkou2));
                    viewPager.setCurrentItem(0);
                } else if (tab == tabLayout.getTabAt(1)) {
                    two.setIcon(getResources().getDrawable(R.mipmap.damenkou2));
                    viewPager.setCurrentItem(1);
                } else if (tab == tabLayout.getTabAt(2)) {
                    three.setIcon(getResources().getDrawable(R.mipmap.damenkou2));
                    viewPager.setCurrentItem(2);
                } else if (tab == tabLayout.getTabAt(3)) {
                    four.setIcon(getResources().getDrawable(R.mipmap.damenkou2));
                    viewPager.setCurrentItem(3);
                }

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                if (tab == tabLayout.getTabAt(0)) {
                    one.setIcon(getResources().getDrawable(R.mipmap.damenkou1));
                } else if (tab == tabLayout.getTabAt(1)) {
                    two.setIcon(getResources().getDrawable(R.mipmap.damenkou1));
                } else if (tab == tabLayout.getTabAt(2)) {
                    three.setIcon(getResources().getDrawable(R.mipmap.damenkou1));
                } else if (tab == tabLayout.getTabAt(3)) {
                    four.setIcon(getResources().getDrawable(R.mipmap.damenkou1));
                }
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.mio, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void openDrawer() {
        drawer.openDrawer(GravityCompat.START);
    }
}
