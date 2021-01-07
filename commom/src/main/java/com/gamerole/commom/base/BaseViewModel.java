package com.gamerole.commom.base;


import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import io.reactivex.disposables.Disposable;

public class BaseViewModel extends ViewModel {

    protected final MutableLiveData<Exception> error = new MutableLiveData<>();
    protected final MutableLiveData<Boolean> progress = new MutableLiveData<>();
    protected Disposable disposable;

    @Override
    protected void onCleared() {
        cancel();
    }

    protected void cancel() {
        if (disposable != null && !disposable.isDisposed()) {
            disposable.dispose();
        }
    }

    public LiveData<Exception> error() {
        return error;
    }

    public LiveData<Boolean> progress() {
        return progress;
    }

    protected void onError(Exception throwable) {
        error.postValue(throwable);

    }
}
