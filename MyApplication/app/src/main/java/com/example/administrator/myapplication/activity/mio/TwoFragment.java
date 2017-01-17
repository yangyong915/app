package com.example.administrator.myapplication.activity.mio;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.myapplication.R;

/**
 * 圈子
 * yy
 */
public class TwoFragment extends Fragment {
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private String[] mTitles = new String[]{"推荐", "最新", "最热", "活动"};
    private int[] tabIcons = {
            R.mipmap.woaide2,
            R.mipmap.woaide2,
            R.mipmap.woaide2,
            R.mipmap.woaide2
    };
    private int[] tabIconsPressed = {
            R.mipmap.woaide1,
            R.mipmap.woaide1,
            R.mipmap.woaide1,
            R.mipmap.woaide1
    };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_two, container, false);

        tabLayout = (TabLayout) v.findViewById(R.id.circle_tab_layout);
        viewPager = (ViewPager) v.findViewById(R.id.circle_viewPager);

        init_viewpager();

        return v;
    }

    private void init_viewpager() {
        viewPager.setAdapter(new FragmentPagerAdapter(getActivity().getSupportFragmentManager()) {

            @Override
            public Fragment getItem(int position) {
                if (position == 1) {
                    return new ThreeFragment();
                } else if (position == 2) {
                    return new ThreeFragment();
                } else if (position == 3) {
                    return new FourFragment();
                }
                return new TabFragment();
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

        LayoutInflater mLayoutInflater = getActivity().getLayoutInflater();
        for (int i = 0; i < 4; i++) {
            TabLayout.Tab tab = tabLayout.getTabAt(i);

            View view = mLayoutInflater.inflate(R.layout.circle_tab, null);
            TextView text = (TextView) view.findViewById(R.id.tv);
            text.setText(mTitles[i]);
            ImageView image = (ImageView) view.findViewById(R.id.iv);
            image.setImageResource(tabIcons[i]);
            tab.setCustomView(view);
        }

        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                View view = tab.getCustomView();
                ImageView img_title = (ImageView) view.findViewById(R.id.iv);
                TextView txt_title = (TextView) view.findViewById(R.id.tv);
                switch (txt_title.getText().toString()) {
                    case "推荐":
                        img_title.setImageResource(tabIconsPressed[0]);
                        viewPager.setCurrentItem(0);
                        break;
                    case "最新":
                        img_title.setImageResource(tabIconsPressed[1]);
                        viewPager.setCurrentItem(1);
                        break;
                    case "最热":
                        img_title.setImageResource(tabIconsPressed[2]);
                        viewPager.setCurrentItem(2);
                        break;
                    case "活动":
                        img_title.setImageResource(tabIconsPressed[3]);
                        viewPager.setCurrentItem(3);
                        break;
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                View view = tab.getCustomView();
                ImageView img_title = (ImageView) view.findViewById(R.id.iv);
                TextView txt_title = (TextView) view.findViewById(R.id.tv);
                switch (txt_title.getText().toString()) {
                    case "推荐":
                        img_title.setImageResource(tabIcons[0]);
                        break;
                    case "最新":
                        img_title.setImageResource(tabIcons[1]);
                        break;
                    case "最热":
                        img_title.setImageResource(tabIcons[2]);
                        break;
                    case "活动":
                        img_title.setImageResource(tabIcons[3]);
                        break;
                }
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

}
