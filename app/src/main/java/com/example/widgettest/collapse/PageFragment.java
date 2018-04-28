package com.example.widgettest.collapse;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.widgettest.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by hesh on 2018/4/24.
 */

public class PageFragment extends Fragment {

    @BindView(R.id.tv_msg)
    TextView tvMsg;
    Unbinder unbinder;
    private int page;

    public PageFragment() {

    }

    public static PageFragment newInstance(int param) {
        PageFragment fragment = new PageFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("param", param);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        page = getArguments().getInt("param");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle
            savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_page, container,false);
        unbinder = ButterKnife.bind(this,view);

        tvMsg.setText(tvMsg.getText().toString()+"--"+page);
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
