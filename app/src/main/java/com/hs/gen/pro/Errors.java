package com.hs.gen.pro;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.TextView;
import flyvpnpro.official.gen.R;

public class Errors extends AppCompatActivity {
	
    TextView error;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
		setContentView(R.layout.errors);
		error = (TextView) findViewById(R.id.errors);
        
        error.setText(getIntent().getStringExtra("error"));
    }
}






