package com.ckfcsteam.spaceinvaders;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class SpaceMainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        setContentView(new Game1(getApplicationContext(),1568));
    }
}
