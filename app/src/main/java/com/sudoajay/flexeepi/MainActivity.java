package com.sudoajay.flexeepi;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.luseen.spacenavigation.SpaceItem;
import com.luseen.spacenavigation.SpaceNavigationView;
import com.luseen.spacenavigation.SpaceOnClickListener;
import com.luseen.spacenavigation.SpaceOnLongClickListener;
import com.sudoajay.flexeepi.BottomFragments.HomeFragment;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    private SpaceNavigationView spaceNavigationView;
    private Fragment fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_main);

        changeStatusBarColor();
        spaceNavigationView = findViewById(R.id.space);

        // create object
        fragment = new Fragment();
        spaceNavigationView.initWithSaveInstanceState(savedInstanceState);
        spaceNavigationView.addSpaceItem(new SpaceItem("", R.drawable.home_un_icon));
        spaceNavigationView.addSpaceItem(new SpaceItem("", R.drawable.sound_un_icon));
        spaceNavigationView.addSpaceItem(new SpaceItem("", R.drawable.setting_un_icon));
        spaceNavigationView.addSpaceItem(new SpaceItem("", R.drawable.account_un_icon));


//         By default Open Home Screen
        HomeFragment homeFragment = new HomeFragment();
        fragment = homeFragment.createInstance(MainActivity.this);
        Replace_Fragments();

        spaceNavigationView.setSpaceOnClickListener(new SpaceOnClickListener() {
            @Override
            public void onCentreButtonClick() {
            }

            @Override
            public void onItemClick(int itemIndex, String itemName) {

                switch (itemIndex) {
//                     Home
                    case 0:
                        HomeFragment homeFragment = new HomeFragment();
                        fragment = homeFragment.createInstance(MainActivity.this);
                        Replace_Fragments();
                        break;
                }
            }

            @Override
            public void onItemReselected(int itemIndex, String itemName) {

            }
        });


        spaceNavigationView.setSpaceOnLongClickListener(new SpaceOnLongClickListener() {
            @Override
            public void onCentreButtonLongClick() {
            }

            @Override
            public void onItemLongClick(int itemIndex, String itemName) {

            }
        });
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        spaceNavigationView.onSaveInstanceState(outState);
    }

    private void changeStatusBarColor() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.WHITE);
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Objects.requireNonNull(getSupportActionBar()).setElevation(0);
        }


    }

    // Replace Fragments
    public void Replace_Fragments() {

        if (fragment != null) {
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.frame_Layout, fragment);
            ft.commit();
        }
    }

    //     Menu Item
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.helpMenu) {
            // do something
        }
        return super.onOptionsItemSelected(item);
    }
}
