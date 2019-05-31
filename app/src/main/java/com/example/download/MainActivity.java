package com.example.download;

import android.app.Activity;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.os.Bundle;

import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import com.example.download.adapter.ListViewAdapter;
import com.example.download.adapter.MyPagerAdapter;
import com.example.download.adapter.PageChange;


import java.util.ArrayList;

public class MainActivity extends Activity implements View.OnClickListener {

    //侧滑栏对象
    private DrawerLayout drawerLayout;
    //侧滑栏属性对象
    private NavigationView  navigationView;
    //menu打开侧滑栏的图标对象，search打开弹窗的图片对象
    ImageView menu,search;
    private ViewPager viewpager;
    private ArrayList<View> contentList;
    private MyPagerAdapter mAdapter;
    private ImageView indicator = null;
    PageChange pageChange;
    private LinearLayout downloading, downloaded;
    View viewone,viewtow,view;
    ListViewAdapter  listViewAdapter;
    TextView text2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Init();
    }
    @Override
    public void onClick(View v) {
        int tempIdx = 0;
        switch (v.getId()){
            case R.id.main_menu://点击侧滑栏的图标，跳出侧滑菜单
                if (drawerLayout.isDrawerOpen(navigationView)){
                    drawerLayout.closeDrawer(navigationView);
                }else{
                    drawerLayout.openDrawer(navigationView);
                }
                break;
            case R.id.search:
                //点击右侧弹窗图标弹出选项弹窗
                bar_showPopuMenu(search);
        }
        if (v == downloading) {
            tempIdx = 0;
        } else if (v == downloaded) {
            tempIdx = 1;
        }
        if (pageChange.currentIndex!= tempIdx) {
            pageChange.initAnimation(tempIdx);
            viewpager.setCurrentItem(pageChange.currentIndex);
        }
        if (v == text2){
            listViewAdapter.additem();
        }
    }
    //弹窗显示函数
    private void bar_showPopuMenu(View view){
        //弹窗对象
        PopupMenu popupMenu = new PopupMenu(this,view);
        //在弹窗对象中打开barmenu.xml界面
        popupMenu.getMenuInflater().inflate(R.menu.barmenu,popupMenu.getMenu());
        //设置弹窗的监听函数
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                String items = item.getTitle().toString();  //获取所选菜单标题
                if (items.equals("视频推荐"))   //对菜单标题进行判断
                {
                    Intent intent = new Intent(MainActivity.this, MovieRecom.class);
                    startActivity(intent);
                }
                else if (items.equals("音乐推荐"))
                {
                    Intent intent = new Intent(MainActivity.this, MusicRecommendation.class);
                    startActivity(intent);
                }

                return false;
            }
        });
        //弹窗显示
        popupMenu.show();
    }

    //初始化页面
    private void Init(){
        //requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        //实例化对象
        drawerLayout = findViewById(R.id.activity_na);
        navigationView = findViewById(R.id.nav);
        menu=  findViewById(R.id.main_menu);
        search = findViewById(R.id.search);
        downloading = findViewById(R.id.downloading);
        downloaded = findViewById(R.id.downloaded);
        text2 = findViewById(R.id.text2);
        //View headerView = navigationView.getHeaderView(0);//获取头布局
        //设置侧滑栏点击事件
        menu.setOnClickListener(this);
        //设置弹窗的点击事件
        search.setOnClickListener(this);
        //设置下载的点击事件
        downloading.setOnClickListener(this);
        //设置已下载的点击事件
        downloaded.setOnClickListener(this);
        //设置侧滑栏监听事件
        text2.setOnClickListener(this);
        LayoutInflater li = getLayoutInflater();
        //获取viewone界面对象
        viewone=li.inflate(R.layout.viewone,null);
        //获取viewtwo界面对象
        viewtow=li.inflate(R.layout.viewtow,null);
        //侧滑栏item的点击事件
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Toast.makeText(MainActivity.this,item.getTitle().toString(),Toast.LENGTH_SHORT).show();
                drawerLayout.closeDrawer(navigationView);
                return true;
            }
        });
        /*获取viewpager对象*/
        viewpager = findViewById(R.id.viewpager);
        /*实例化contentList对象*/
        contentList = new ArrayList<View>();
        /*将listview添加进入contentList对象*/
        contentList.add(viewone);
        contentList.add(viewtow);
        /*实例化适配器*/
        mAdapter = new MyPagerAdapter(contentList);
        /*viewpager设置适配器*/
        viewpager.setAdapter(mAdapter);
        DisplayMetrics dms = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dms);
        indicator = findViewById(R.id.iv_line);
        pageChange= new PageChange(dms,indicator);
        viewpager.setOnPageChangeListener(pageChange);
        //view = li.inflate(R.layout.download_foot, null);
        ListView listView = viewone.findViewById(R.id.jh_list_downing);
        listViewAdapter=new ListViewAdapter(0,MainActivity.this);
        listView.setAdapter(listViewAdapter);
        //listView.addFooterView(view);
    }
}
