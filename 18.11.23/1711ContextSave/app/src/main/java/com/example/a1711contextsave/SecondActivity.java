package com.example.a1711contextsave;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.a1711contextsave.databinding.SecondlayoutBinding;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        SecondlayoutBinding binding = SecondlayoutBinding.inflate(getLayoutInflater());

        setContentView(binding.getRoot());

        SharedPreferences pref = MainActivity.pref;
        SharedPreferences.Editor editor = pref.edit();


        binding.Clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editor.putString(MainActivity.LOGINSTRING,"-");
                editor.putString(MainActivity.PASSWORDSTRING,"-");
                editor.commit();
                finish();
            }
        });

        binding.truelogin.setText(MainActivity.TRUELOGIN);
        binding.truepassword.setText(MainActivity.TRUEPASSWORD);

        binding.Set.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.TRUELOGIN = binding.truelogin.getText().toString();
                MainActivity.TRUEPASSWORD = binding.truepassword.getText().toString();
                finish();
            }
        });

        binding.ACT3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SecondActivity.this,ThirdActivity.class);
                startActivity(intent);
            }
        });

    }
}
