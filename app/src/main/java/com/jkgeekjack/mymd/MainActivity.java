package com.jkgeekjack.mymd;

import android.content.Intent;
import android.os.Handler;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private DrawerLayout mDrawerLayout;
    //左上角的标志
    private ActionBarDrawerToggle mDrawerToggle;
//    //菜单列表
    private NavigationView navigationView;


    private DiscoveryFragment discoveryFragment;
    private MainFragment mainFragment;
    private List<Fragment> fragmentList=new ArrayList<Fragment>();
    private FragmentManager fragmentManager;

    private Fragment currentFragment;
//    之前选中NavigationVIew的Item
    private MenuItem preMenuItem;

//    NavigationView头部的头像
    private ImageView ivProtrait;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initVar();
        initView();
        initDefaultFragment();
    }

    private void initDefaultFragment() {
        currentFragment=MainFragment.getMainFragment();
        fragmentManager.beginTransaction().add(R.id.content,currentFragment).commit();
        setTitle("首页");
        preMenuItem=navigationView.getMenu().getItem(0);
        preMenuItem.setChecked(true);
        navigationView.getMenu().getItem(1).setChecked(false);
    }

    private void initVar() {
        fragmentManager=getSupportFragmentManager();
        fragmentList.add(MainFragment.getMainFragment());
        fragmentList.add(DiscoveryFragment.getDiscoveryFragment());
        fragmentList.add(FocusFragment.getFocusFragment());

//        fragmentList.add(new FocusFragment());
//        fragmentList.add(new FocusFragment());
//        fragmentList.add(new FocusFragment());
    }

    private void initView() {

        toolbar= (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        mDrawerLayout= (DrawerLayout) findViewById(R.id.drawerLayout);
        navigationView= (NavigationView) findViewById(R.id.nav_view);
        //设置NavigationView的选项监听
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                //如果之前有选项就把它设为没有选中
                if (preMenuItem!=null){
                    preMenuItem.setChecked(false);
                }
                switch (item.getItemId()){
                    case R.id.navigation_item_home:switchFragment(0);setTitle("首页");break;
                    case R.id.navigation_item_discovery:switchFragment(1);setTitle("发现");break;
                    case R.id.navigation_item_focus:switchFragment(2);setTitle("关注");break;
                    case R.id.navigation_item_collect:switchFragment(3);setTitle("收藏");break;
                    case R.id.navigation_item_round:switchFragment(4);setTitle("圆桌");break;
                    case R.id.navigation_item_message:startActivity(new Intent(MainActivity.this,RecyclerActivity.class));break;
//                        switchFragment(5);setTitle("私信");break;
                }
                preMenuItem=item;
                //将当前选项设为选中
                item.setChecked(true);
                return false;
            }
        });
        //后面的R.string.close,R.string.open好像没什么用，但一定要设
        mDrawerToggle=new ActionBarDrawerToggle(this,mDrawerLayout,toolbar,R.string.close,R.string.open);
        mDrawerToggle.syncState();
        mDrawerLayout.setDrawerListener(mDrawerToggle);
        //获得NavigationView的头部view,从而绑定里面的控件
        View view=navigationView.getHeaderView(0);
        ivProtrait= (ImageView)view.findViewById(R.id.ivProtrait);
        ivProtrait.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e("click","click");
//                Toast.makeText(MainActivity.this,"click",Toast.LENGTH_SHORT).show();
                startActivity(new Intent(MainActivity.this,PersonalActivity.class));
            }
        });
    }
    //切换Fragment
    private void switchFragment(int position) {
        Fragment to=fragmentList.get(position);
        if (to.isAdded()) {
            Log.i("fragment", "Added");
            fragmentManager.beginTransaction().hide(currentFragment).show(to).commitAllowingStateLoss();
        } else {
            Log.i("fragment", "Not Added");
            fragmentManager.beginTransaction().hide(currentFragment).add(R.id.content, to).commitAllowingStateLoss();
        }

        currentFragment = to;
        mDrawerLayout.closeDrawers();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_toolbar,menu);
        return  true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
//        Toast.makeText(this,item.getItemId()+"",Toast.LENGTH_SHORT).show();
        switch (item.getItemId()){
            case R.id.action_settings:break;
            case R.id.action_about:break;
        }
        return true;
    }
}
