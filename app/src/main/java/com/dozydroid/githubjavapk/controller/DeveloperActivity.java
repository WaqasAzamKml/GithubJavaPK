package com.dozydroid.githubjavapk.controller;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.dozydroid.githubjavapk.R;

public class DeveloperActivity extends AppCompatActivity {
    ImageView userAvatar;
    TextView tvUserName;
    Button btnVisitProfile;
    Toolbar actionToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_developer);

        setTitle("Developer Details");

        userAvatar = (ImageView) findViewById(R.id.imgUserAvatar);
        tvUserName = (TextView) findViewById(R.id.tvUserName);
        btnVisitProfile = (Button) findViewById(R.id.btnVisitProfile);

        Bundle bundle = getIntent().getExtras();
        String username = bundle.getString("login");
        String avatarURL = bundle.getString("avatar_url");
        String gitHubLink = bundle.getString("html_url");

        tvUserName.setText(username);

        Glide.with(this).load(avatarURL).fitCenter().placeholder(R.drawable.cat).into(userAvatar);
    }
}

