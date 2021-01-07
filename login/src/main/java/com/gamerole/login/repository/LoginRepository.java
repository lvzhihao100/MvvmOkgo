package com.gamerole.login.repository;

import com.gamerole.commom.entity.HttpData;
import com.gamerole.login.service.HttpService;

import javax.inject.Inject;

import io.reactivex.Single;

public class LoginRepository {
    private final HttpService httpService;

    @Inject
    public LoginRepository(HttpService httpService) {
        this.httpService = httpService;
    }
    public Single<HttpData<?>> login(String account, String pwd){
         return httpService.login(account, pwd);
    }
}
