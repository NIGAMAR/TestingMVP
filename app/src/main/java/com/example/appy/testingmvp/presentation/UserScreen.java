package com.example.appy.testingmvp.presentation;

import com.example.appy.testingmvp.datalayer.User;

import java.util.List;

/**
 * Created by Appy on 13/06/16.
 */

public interface UserScreen {
    void showProgress();
    void hideProgress();
    void setUsers(List<User> userList);
    void showMessage(String message);
}
