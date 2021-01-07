package com.gamerole.login.ui.login;

import android.widget.Button;
import android.widget.EditText;

import androidx.lifecycle.ViewModelProvider;

import com.gamerole.commom.base.BaseActivity;
import com.gamerole.commom.base.BaseViewModel;
import com.gamerole.commom.entity.HttpData;
import com.gamerole.login.R;
import com.gamerole.login.viewmodel.LoginViewModel;

import org.jetbrains.annotations.NotNull;

import javax.inject.Inject;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class LoginActivity extends BaseActivity {
    @Inject
    LoginViewModelFactory loginViewModelFactory;
    LoginViewModel loginViewModel;

    @NotNull
    @Override
    public BaseViewModel getViewModel() {
        loginViewModel = new ViewModelProvider(getViewModelStore(), loginViewModelFactory)
                .get(LoginViewModel.class);
        return loginViewModel;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    public void initView() {
        EditText etAccount = findViewById(R.id.etAccount);
        EditText etPwd = findViewById(R.id.etPwd);
        Button btLogin = findViewById(R.id.btLogin);
        btLogin.setOnClickListener(v -> loginViewModel.login(etAccount.getText().toString(), etPwd.getText().toString()));
    }

    @Override
    public void initData() {
        loginViewModel.getLoginResult()
                .observe(this, this::loginSuccess);
    }

    private void loginSuccess(HttpData httpData) {
        System.out.println("登录成功");
    }

}
