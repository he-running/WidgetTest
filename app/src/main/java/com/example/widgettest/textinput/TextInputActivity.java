package com.example.widgettest.textinput;

import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.Toast;

import com.example.widgettest.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class TextInputActivity extends AppCompatActivity {


    @BindView(R.id.et_account)
    TextInputEditText etAccount;
    @BindView(R.id.til_account)
    TextInputLayout tilAccount;
    @BindView(R.id.et_pwd)
    TextInputEditText etPwd;
    @BindView(R.id.til_pwd)
    TextInputLayout tilPwd;
    @BindView(R.id.btn_login)
    Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_input);
        ButterKnife.bind(this);
    }


    private void showError(TextInputLayout inputLayout, String error) {
        inputLayout.setError(error);
        inputLayout.getEditText().setFocusable(true);
        inputLayout.getEditText().setFocusableInTouchMode(true);
        inputLayout.getEditText().requestFocus();
    }

    private boolean validateAccount(){
        if (TextUtils.isEmpty(etAccount.getText().toString())){
            showError(tilAccount,"用户名为空！");
            return false;
        }
        return true;
    }

    private boolean validatePwd(){
        if (TextUtils.isEmpty(etPwd.getText().toString())){
            showError(tilPwd,"密码为空！");
            return false;
        }

        if (etPwd.getText().toString()!=null&&etPwd.getText().toString().length()<6){
            showError(tilPwd,"密码长度为6位以上！");
            return false;
        }
        return true;
    }

    @OnClick(R.id.btn_login)
    public void onViewClicked() {
        tilAccount.setErrorEnabled(false);
        tilPwd.setErrorEnabled(false);

        if (validateAccount()&&validatePwd()){
            Toast.makeText(TextInputActivity.this,"验证成功",Toast.LENGTH_SHORT).show();
        }
    }
}
