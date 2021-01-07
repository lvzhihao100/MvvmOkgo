package com.gamerole.login.ui.login;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.gamerole.login.repository.LoginRepository;
import com.gamerole.login.viewmodel.LoginViewModel;

import javax.inject.Inject;

public class LoginViewModelFactory implements ViewModelProvider.Factory {
    private LoginRepository loginRepository;

    @Inject
    public LoginViewModelFactory(LoginRepository loginRepository) {
        this.loginRepository = loginRepository;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass == LoginViewModel.class) {
            return (T) new LoginViewModel(loginRepository);
        }
        throw new IllegalArgumentException("Unknown ViewModel class");

    }
}
