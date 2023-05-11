package com.example.foodappordering_uiloverchannel.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.foodappordering_uiloverchannel.MainActivity;
import com.example.foodappordering_uiloverchannel.R;
import com.example.foodappordering_uiloverchannel.databinding.ActivityIntroBinding;

public class IntroActivity extends AppCompatActivity {

    private ActivityIntroBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityIntroBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.btnStart.setOnClickListener(v -> {
            startActivity(new Intent(this, MainActivity.class));
        });
    }
}