package com.gamerole.login.viewmodel;

import androidx.lifecycle.MutableLiveData;

import com.gamerole.commom.base.BaseViewModel;
import com.gamerole.commom.entity.HttpData;
import com.gamerole.login.repository.LoginRepository;

/**
 * 登录页
 */
public class LoginViewModel extends BaseViewModel {
    private final LoginRepository loginRepository;
    private final MutableLiveData<HttpData> loginResult = new MutableLiveData();


    public LoginViewModel(LoginRepository loginRepository) {
        this.loginRepository = loginRepository;
    }

    public MutableLiveData<HttpData> getLoginResult() {
        return loginResult;
    }

    public void login(String account, String pwd) {
        progress.postValue(true);
        disposable = loginRepository.login(account, pwd)
                .subscribe(value -> {
                    progress.postValue(false);
                    loginResult.postValue(value);
                }, e -> {
                    progress.postValue(false);
                });
    }
}
