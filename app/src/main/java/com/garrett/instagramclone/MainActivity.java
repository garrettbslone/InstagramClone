package com.garrett.instagramclone;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.FileProvider;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.garrett.instagramclone.fragments.ComposeFragment;
import com.garrett.instagramclone.fragments.PostsFragment;
import com.garrett.instagramclone.fragments.ProfileFragment;
import com.google.android.material.bottomnavigation.BottomNavigationMenu;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.parse.FindCallback;
import com.parse.GetCallback;
import com.parse.LogOutCallback;
import com.parse.ParseException;
import com.parse.ParseFile;
import com.parse.ParseQuery;
import com.parse.ParseUser;
import com.parse.SaveCallback;

import java.io.File;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    final FragmentManager fragmentManager = getSupportFragmentManager();
    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.bottom_navigation);

        bottomNavigationView.setOnNavigationItemSelectedListener(item -> {
            Fragment fragment;
            switch (item.getItemId()) {
                case R.id.action_home:
                    fragment = new PostsFragment();
                    break;
                case R.id.action_compose:
                    fragment = new ComposeFragment();
                    break;
                case R.id.action_profile:
                default:
                    fragment = new ProfileFragment();
                    break;
            }

            fragmentManager.beginTransaction().replace(R.id.flContainer, fragment).commit();
            return true;
        });

        // Set default selection
        bottomNavigationView.setSelectedItemId(R.id.action_home);
    }
}