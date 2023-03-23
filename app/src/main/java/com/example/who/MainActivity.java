package com.example.who;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.who.databinding.ActivityMainBinding;
import com.example.who.ui.dashboard.DashboardFragment;
import com.example.who.ui.navbar.CalendrierFragment;
import com.example.who.ui.navbar.MenuFragment;
import com.example.who.ui.carte.CarteFragment;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        NavigationBarView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.calendrier, R.id.carte, R.id.menu)
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
                    case R.id.calendrier : temp = new CalendrierFragment();
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


}