package com.example.appy.testingmvp.presentation;

/**
 * Created by Appy on 13/06/16.
 */

public class MainScreenPresenter {
    private  MainScreen mainScreen;

    public MainScreenPresenter(MainScreen mainScreen) {
        this.mainScreen = mainScreen;
    }
    public void handleLaunchUserActivity(){
        mainScreen.launchUserActivity();
    }
}
