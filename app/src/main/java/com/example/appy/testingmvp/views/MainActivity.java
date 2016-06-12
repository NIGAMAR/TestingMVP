package com.example.appy.testingmvp.views;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.ButtonBarLayout;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

import com.example.appy.testingmvp.R;
import com.example.appy.testingmvp.databinding.MainActivityBinding;
import com.example.appy.testingmvp.presentation.MainScreen;
import com.example.appy.testingmvp.presentation.MainScreenPresenter;

public class MainActivity extends AppCompatActivity implements MainScreen, View.OnClickListener {

    private Button loadUsers;
    private MainActivityBinding _binding;
    private MainScreenPresenter mainScreenPresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        _binding= DataBindingUtil.setContentView(this,R.layout.activity_main);
        mainScreenPresenter=new MainScreenPresenter(this);
        Toolbar toolbar = _binding.toolbar;
        loadUsers=_binding.btnLoadUsers;
        setSupportActionBar(toolbar);
        loadUsers.setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void launchUserActivity() {
        Intent intent=new Intent(this,Users.class);
        startActivity(intent);
    }

    @Override
    public void onClick(View v) {
        mainScreenPresenter.handleLaunchUserActivity();
    }
}
