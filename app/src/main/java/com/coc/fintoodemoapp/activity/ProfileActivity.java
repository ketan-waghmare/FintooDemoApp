package com.coc.fintoodemoapp.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

import com.coc.fintoodemoapp.R;

public class ProfileActivity extends AppCompatActivity {

    private ImageView ivBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        ivBack = findViewById(R.id.iv_back_profile);

        ivBack.setOnClickListener(v -> {
            finish();
        });
    }
}