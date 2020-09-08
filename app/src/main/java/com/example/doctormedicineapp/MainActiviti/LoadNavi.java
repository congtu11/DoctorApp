package com.example.doctormedicineapp.MainActiviti;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.example.doctormedicineapp.Fragment.HomeFragment;
import com.example.doctormedicineapp.Fragment.NotificationFragment;
import com.example.doctormedicineapp.Fragment.ProfileUserFragment;
import com.example.doctormedicineapp.Interface.OnFragmentManager;
import com.example.doctormedicineapp.Login.IDUerManager;
import com.example.doctormedicineapp.Login.TokenManager;
import com.example.doctormedicineapp.R;
import com.example.doctormedicineapp.model.ItemMainMenu_Model;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.List;

public class LoadNavi extends AppCompatActivity implements OnFragmentManager {
    BottomNavigationView bottomNavigation;
    RecyclerView rvItems;
    List<ItemMainMenu_Model> itemMainMenus;
    private ActionBar toolbar;
    public TokenManager tokenManager;
    IDUerManager doc;
    public static final String TAG ="LoG";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_load_navi);
        toolbar = getSupportActionBar();
        bottomNavigation = findViewById(R.id.bottom_navigation);
        bottomNavigation.setOnNavigationItemSelectedListener(navigationItemSelectedListener);
        toolbar.setTitle("Shop");
        loadFragment(new HomeFragment());

    }

    BottomNavigationView.OnNavigationItemSelectedListener navigationItemSelectedListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    Fragment fragment;
                    switch (item.getItemId()) {
                        case R.id.navigation_home:
                            toolbar.hide();
                            fragment = new HomeFragment();
                            loadFragment(fragment);
                            return true;
                        case R.id.navigation_profile:
                            toolbar.setTitle("Profile");
                            fragment = new ProfileUserFragment();
                            loadFragment(fragment);
                            return true;
                        case R.id.navigation_notification:
                            toolbar.setTitle("Notification");
                            fragment = new NotificationFragment();
                            loadFragment(fragment);
                    }
                    return false;
                }
            };
    private void loadFragment(Fragment fragment) {
        // load fragment
        tokenManager = TokenManager.getInstance(getSharedPreferences("prefss",MODE_PRIVATE));
        doc= IDUerManager.getInstance(getSharedPreferences("prefdoc",MODE_PRIVATE));
        Log.d(TAG, "onCreate: "+   tokenManager.getToken().getAccessToken());

        Log.d(TAG, "onCreate: " + doc.getID().getID_USER());
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_container, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
    @Override
    public void onDataSelected(TokenManager tokenManager) {

    }

}
