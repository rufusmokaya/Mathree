package com.example.rufus.mathree.drawer;

import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.rufus.mathree.R;
import com.example.rufus.mathree.fragments.PreviousTripsFragment;
import com.example.rufus.mathree.fragments.SettingsFragment;
import com.example.rufus.mathree.fragments.WalletFragment;

public class MathreeCustomerActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private DrawerLayout drawer;
    TextView name,phone;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nav_header);

        Bundle bundle = getIntent().getExtras();
        name.setText("Welcome"+bundle.getString("firsname"));
        phone.setText("Phone Number"+bundle.getString("phone"));




        android.support.v7.widget.Toolbar toolbar= findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar,
                R.string.navigation_drawer_open,R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        /*This will take care of rotating the hamburger icon together with the drawer itself*/

    }
    /*this method will take care of the instance where you press the back button but
     you dont not want to go back immediately so instead it closes the navigation drawer*/
    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)){
            drawer.closeDrawer(GravityCompat.START);

        }else {
        super.onBackPressed();
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.nav_wallet1:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new WalletFragment()).commit();
                break;
            case R.id.nav_previoustrips:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new PreviousTripsFragment()).commit();
                break;
            case R.id.nav_settings1:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new SettingsFragment()).commit();
                break;
        }

        drawer.closeDrawer(GravityCompat.START);

        return true;
    }
}
