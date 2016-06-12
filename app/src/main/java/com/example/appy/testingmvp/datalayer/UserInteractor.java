package com.example.appy.testingmvp.datalayer;

import java.util.List;

/**
 * Created by Appy on 13/06/16.
 */

public interface UserInteractor {

    interface OnUsersLoadingFinished{
        void onSuccess(List<User> userList);
        void onFailure(String message);
    }
    void giveAllUsers(OnUsersLoadingFinished listener);
}
