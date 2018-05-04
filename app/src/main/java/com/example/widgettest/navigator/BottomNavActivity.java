package com.example.widgettest.navigator;

import android.content.res.ColorStateList;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.example.widgettest.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class BottomNavActivity extends AppCompatActivity {

    @BindView(R.id.message)
    TextView tvMessage;
    @BindView(R.id.navigation)
    BottomNavigationView navigation;
    @BindView(R.id.fab)
    FloatingActionButton fab;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener;

    private boolean isAntiTrack = false;//更改标志位

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_nav);
        ButterKnife.bind(this);

        //取消超过3个item后，bottomNav的切换动画
        BottomNavigationViewHelper.disableShiftMode(navigation);

        //修改bottomNav的图标和title颜色
        int[][] states = new int[][]{
                new int[]{-android.R.attr.state_checked},
                new int[]{android.R.attr.state_checked}
        };

        int[] colors = new int[]{getResources().getColor(R.color.c_nav_unchecked),
                getResources().getColor(R.color.c_nav_checked)
        };
        ColorStateList csl = new ColorStateList(states, colors);
        navigation.setItemTextColor(csl);
        navigation.setItemIconTintList(csl);

        //监听点击
        mOnNavigationItemSelectedListener = new BottomNavigationView.OnNavigationItemSelectedListener() {

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.navigation_home:
                        tvMessage.setText(R.string.title_home);
                        return true;
                    case R.id.navigation_dashboard:
                        String title = item.getTitle().toString();
                        Log.w("更改menu", "title: " + title);
                        if (title.equals("跟踪")) {
                            tvMessage.setText(R.string.title_dashboard);
                        } else {
                            tvMessage.setText(R.string.title_anti_track);
                        }
                        return true;
                    case R.id.navigation_notifications:
                        tvMessage.setText(R.string.title_notifications);
                        return true;
                    case R.id.navigation_info:
                        tvMessage.setText(R.string.title_notifications);
                        return true;
                }
                return false;
            }
        };
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

    @Override
    protected void onResume() {
        super.onResume();
        changeNavMenu();
    }


    @OnClick(R.id.fab)
    public void onViewClicked() {
        isAntiTrack=!isAntiTrack;
        changeNavMenu();
        //center-button
        Toast.makeText(BottomNavActivity.this,"center-button",Toast.LENGTH_SHORT).show();
    }

    /**
     * 更改menu
     */
    private void changeNavMenu() {
        Log.w("更改menu", "isAntiTrack: " + isAntiTrack);
        if (isAntiTrack) {
            navigation.getMenu().getItem(1)
                    .setIcon(R.drawable.ic_info_black_24dp).setTitle("反跟踪");
        } else {
            navigation.getMenu().getItem(1)
                    .setIcon(R.drawable.ic_dashboard_black_24dp).setTitle("跟踪");
        }
    }

}
