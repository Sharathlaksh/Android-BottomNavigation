package com.example.bottomnavigation.activity;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

import com.example.bottomnavigation.R;
import com.example.bottomnavigation.fragments.JobsFragment;
import com.example.bottomnavigation.fragments.HomeFragment;
import com.example.bottomnavigation.fragments.MessagesFragment;
import com.example.bottomnavigation.fragments.MyNetworkFragment;
import com.example.bottomnavigation.fragments.NotificationFragment;
import com.example.bottomnavigation.utils.Utils;


public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        setupNavigationView();
    }


    private void setupNavigationView() {
        BottomNavigationView mNavigationView = (BottomNavigationView) findViewById(R.id.bottom_navigation);
        if (mNavigationView != null) {

            // By Default : First item is to be selected,displaying item respective fragment
            Menu menu = mNavigationView.getMenu();
            selectFragment(menu.getItem(0));

            // Set action to perform when any menu-item is selected.
            mNavigationView.setOnNavigationItemSelectedListener(
                    new BottomNavigationView.OnNavigationItemSelectedListener() {
                        @Override
                        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                            selectFragment(item);
                            return false;
                        }
                    });
        }
    }


    // Perform action when any item is selected.
    protected void selectFragment(MenuItem item) {

        item.setChecked(true);

        switch (item.getItemId()) {
            case R.id.action_home:
                // ActionEvent to  be performed when Home Menu item is selected.
                displayFragment(HomeFragment.class);
                break;
            case R.id.action_jobs:
                // ActionEvent to  be performed when Jobs Menu item is selected.
                displayFragment(JobsFragment.class);
                break;
            case R.id.action_msg:
                // ActionEvent to  be performed when Messages Menu item is selected.
                displayFragment(MessagesFragment.class);
                break;
            case R.id.action_network:
                // ActionEvent to  be performed when MyNetwork Menu item is selected.
                displayFragment(MyNetworkFragment.class);
                break;
            case R.id.action_notifications:
                // ActionEvent to  be performed when Notifications Menu item is selected.
                displayFragment(NotificationFragment.class);
                break;

        }
    }

    public void displayFragment(Class fragment) {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        Fragment frag = Utils.getFragment(fm, fragment);
        if (!frag.isAdded()) {
            ft.add(R.id.rootLayout, frag, fragment.getSimpleName());
        } else {
            ft.replace(R.id.rootLayout, Utils.getFragment(fm, fragment));
        }
        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        ft.commit();
    }

}
