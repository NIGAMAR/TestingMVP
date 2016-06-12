package com.example.appy.testingmvp.presentation;

import com.example.appy.testingmvp.datalayer.User;
import com.example.appy.testingmvp.datalayer.UserInteractor;
import com.example.appy.testingmvp.datalayer.UserInteractorImpl;

import java.util.List;

/**
 * Created by Appy on 13/06/16.
 */

public class UserScreenPresenter implements UserInteractor.OnUsersLoadingFinished {

    private UserScreen userScreen;
    private UserInteractor userInteractor;

    public UserScreenPresenter(UserScreen userScreen) {
        this.userScreen = userScreen;
        userInteractor=new UserInteractorImpl();
    }

    public void onResume(){
        userScreen.showProgress();
        userInteractor.giveAllUsers(this);
    }

    public void onDestroy(){
      userScreen=null;
    }

    @Override
    public void onSuccess(List<User> userList) {
        userScreen.setUsers(userList);
        userScreen.hideProgress();
    }

    @Override
    public void onFailure(String message) {
        userScreen.showMessage(message);
    }
}
