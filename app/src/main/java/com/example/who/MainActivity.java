package com.example.who;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.example.who.databinding.ActivityMainBinding;
import com.example.who.ui.home.HomeFragment;
import com.example.who.ui.navbar.MenuFragment;
import com.example.who.ui.carte.CarteFragment;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.who.ui.planning.HourEvent;
import com.google.android.material.navigation.NavigationBarView;


public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        getSupportActionBar().setHomeButtonEnabled(false);      // Disable the button
        getSupportActionBar().setDisplayHomeAsUpEnabled(false); // Remove the left caret
        getSupportActionBar().setDisplayShowHomeEnabled(false); // Remove the ico

        NavigationBarView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.carte, R.id.menu)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_main);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(binding.navView, navController);
        navView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener(){

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment temp = null;
                switch (item.getItemId())
                {
                    case R.id.navigation_home : temp = new HomeFragment();

                        break;
                    case R.id.carte : temp = new CarteFragment();
                        break;
                    case R.id.menu : temp = new MenuFragment();
                }
                getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment_activity_main,temp).commit();
                return true;
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setHomeButtonEnabled(false);      // Disable the button
            actionBar.setDisplayHomeAsUpEnabled(false); // Remove the left caret
            actionBar.setDisplayShowHomeEnabled(false); // Remove the icon
        }
        return super.onCreateOptionsMenu(menu);
    }
}