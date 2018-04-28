package com.example.widgettest;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.widgettest.collapse.ScrollActivity;
import com.example.widgettest.navigator.BottomNavActivity;
import com.example.widgettest.recyclerview.RecyclerViewActivity;
import com.example.widgettest.textinput.TextInputActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    @BindView(R.id.btn_rcv)
    Button btnRcv;
    @BindView(R.id.btn_til)
    Button btnTil;
    @BindView(R.id.btn_collapse)
    Button btnCollapse;
    @BindView(R.id.btn_navigator)
    Button btnNavigator;
    private Unbinder unbinder;

    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        unbinder = ButterKnife.bind(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }

    @OnClick({R.id.btn_rcv, R.id.btn_til, R.id.btn_collapse, R.id.btn_navigator})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_rcv:
                intent = new Intent(MainActivity.this, RecyclerViewActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_til:
                intent = new Intent(MainActivity.this, TextInputActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_collapse:
                intent = new Intent(MainActivity.this, ScrollActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_navigator:
                intent = new Intent(MainActivity.this, BottomNavActivity.class);
                startActivity(intent);
                break;
        }
    }
}
