package com.jkgeekjack.mymd;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerTabStrip;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class DiscoveryFragment extends Fragment {
    private List<String> titleList=new ArrayList<String>();
    private List<Fragment>fragmentList=new ArrayList<Fragment>();
    private ViewPager viewPager;
    private TabLayout tabLayout;
    private static DiscoveryFragment discoveryFragment=new DiscoveryFragment();
    public static DiscoveryFragment getDiscoveryFragment(){
        return discoveryFragment;
    }
    public DiscoveryFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_discovery, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        titleList.add("推荐");
        titleList.add("热门");
        titleList.add("收藏");
        fragmentList.add(RecommandFragment.getRecommandFragment());
        fragmentList.add(HotFragment.getHotFragment());
        fragmentList.add(CollectFragment.getCollectFragment());
        viewPager= (ViewPager) view.findViewById(R.id.viewPager);
        tabLayout= (TabLayout) view.findViewById(R.id.tabLayout);
        FragmentPagerAdapter fragmentPagerAdapter=new FragmentPagerAdapter(getFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return fragmentList.get(position);
            }

            @Override
            public int getCount() {
                return fragmentList.size();
            }

            @Override
            public CharSequence getPageTitle(int position) {
                return titleList.get(position);
            }
        };
        viewPager.setAdapter(fragmentPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);
    }


}
