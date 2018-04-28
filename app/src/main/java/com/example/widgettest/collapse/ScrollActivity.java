package com.example.widgettest.collapse;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

import com.example.widgettest.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ScrollActivity extends AppCompatActivity {


    @BindView(R.id.tv_msg)
    TextView tvMsg;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.toolbar_layout)
    CollapsingToolbarLayout toolbarLayout;
    @BindView(R.id.tl_tab)
    TabLayout tlTab;
    @BindView(R.id.app_bar)
    AppBarLayout appBar;
    @BindView(R.id.viewPager)
    ViewPager viewPager;
    @BindView(R.id.scrollView)
    NestedScrollView scrollView;
    @BindView(R.id.fab)
    FloatingActionButton fab;

    HomePageAdapter pageAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scroll);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);

        toolbarLayout.setCollapsedTitleGravity(Gravity.CENTER);//设置收缩后标题的位置
        toolbarLayout.setExpandedTitleGravity(Gravity.CENTER);////设置展开后标题的位置
        toolbarLayout.setTitle("title");//设置标题的名字
        toolbarLayout.setExpandedTitleColor(Color.WHITE);//设置展开后标题的颜色
        toolbarLayout.setCollapsedTitleTextColor(Color.WHITE);//设置收缩后标题的颜色

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        scrollView.setFillViewport(true);

        pageAdapter=new HomePageAdapter(getSupportFragmentManager(),this);
        viewPager.setAdapter(pageAdapter);
        tlTab.setupWithViewPager(viewPager);
    }
}
