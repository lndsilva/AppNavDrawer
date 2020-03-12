package br.com.etecia.appnavdrawer;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    Toolbar toolbar;
    DrawerLayout drawerLayout;
    NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toolBar);
        setSupportActionBar(toolbar);

        drawerLayout = findViewById(R.id.drawerLayout);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,
                drawerLayout,
                toolbar,
                R.string.open_drawer,
                R.string.close_drawer);
        drawerLayout.addDrawerListener(toggle);

        toggle.syncState();


        navigationView = findViewById(R.id.navView);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

        switch (menuItem.getItemId()) {
            case R.id.mInbox:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new InboxFragment()).commit();
                break;
            case R.id.mFavoritos:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new FavoritosFragment()).commit();
                break;
            case R.id.mEmailEnviados:
                Toast.makeText(getApplicationContext(),
                        "Menu Emails Enviados",
                        Toast.LENGTH_SHORT).show();
                break;
            case R.id.mLixeira:
                Toast.makeText(getApplicationContext(),
                        "Menu Lixeira",
                        Toast.LENGTH_SHORT).show();
                break;
            case R.id.mSpam:
                Toast.makeText(getApplicationContext(),
                        "Menu Spam",
                        Toast.LENGTH_SHORT).show();
                break;

        }

        drawerLayout.closeDrawer(GravityCompat.START);


        return false;
    }
}
