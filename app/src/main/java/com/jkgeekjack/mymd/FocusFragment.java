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
public class FocusFragment extends Fragment {
    private List<String>titleList=new ArrayList<String>();
    private ViewPager viewPager;
    private TabLayout tabLayout;
    private List<Fragment>fragmentList=new ArrayList<Fragment>();

    private static FocusFragment foucusFragment=new FocusFragment();
    public static FocusFragment getFocusFragment(){
        return foucusFragment;
    }
    public FocusFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_focus, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        titleList.add("问题");
        titleList.add("收藏");
        titleList.add("话题");
//        titleList.add("专栏");
//        fragmentList.add(RecommandFragment.getRecommandFragment());
//        fragmentList.add(HotFragment.getHotFragment());
//        fragmentList.add(CollectFragment.getCollectFragment());
        fragmentList.add(new CollectFragment());
        fragmentList.add(new CollectFragment());
        fragmentList.add(new CollectFragment());
//        fragmentList.add(new CollectFragment());

//        fragmentList.add(CollectFragment.getCollectFragment());
//        fragmentList.add(CollectFragment.getCollectFragment());
//        fragmentList.add(CollectFragment.getCollectFragment());
//        fragmentList.add(CollectFragment.getCollectFragment());
        viewPager= (ViewPager) view.findViewById(R.id.viewPager);
        FragmentPagerAdapter adapter=new FragmentPagerAdapter(getFragmentManager()) {
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
        tabLayout= (TabLayout) view.findViewById(R.id.tabLayout);
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
//        viewPager.setAdapter(fragmentPagerAdapter);
//        tabLayout.setupWithViewPager(viewPager);
    }
}
