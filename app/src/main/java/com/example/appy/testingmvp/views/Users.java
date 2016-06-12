package com.example.appy.testingmvp.views;

import android.app.ProgressDialog;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import com.example.appy.testingmvp.R;
import com.example.appy.testingmvp.databinding.UserActivityBinding;
import com.example.appy.testingmvp.datalayer.User;
import com.example.appy.testingmvp.presentation.UserScreen;
import com.example.appy.testingmvp.presentation.UserScreenPresenter;
import com.example.appy.testingmvp.views.adapters.UserAdapter;

import java.util.List;

public class Users extends AppCompatActivity implements UserScreen{

    private UserActivityBinding _binding;
    private RecyclerView usersView;
    private ProgressDialog dialog;
    final String DIALOG_TITLE="Loading....";
    private UserScreenPresenter userScreenPresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        _binding= DataBindingUtil.setContentView(this,R.layout.activity_users);
        Toolbar toolbar = _binding.toolbar;
        setSupportActionBar(toolbar);
        usersView=_binding.usersRv;
        usersView.setLayoutManager(new LinearLayoutManager(this));
        /*
           set up the progress dialog
         */
        dialog=new ProgressDialog(this);
        dialog.setIndeterminate(true);
        dialog.setCancelable(false);
        dialog.setTitle(DIALOG_TITLE);
        userScreenPresenter=new UserScreenPresenter(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        userScreenPresenter.onResume();
    }

    @Override
    public void showProgress() {
         dialog.show();
    }

    @Override
    public void hideProgress() {
         dialog.hide();
    }

    @Override
    public void setUsers(List<User> userList) {
        usersView.setAdapter(new UserAdapter(this,userList));
    }

    @Override
    public void showMessage(String message) {
        Toast.makeText(this,message,Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        userScreenPresenter.onDestroy();
    }
}
