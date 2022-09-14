package com.example.cafe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class reciept extends AppCompatActivity {
    private TextView tvName;
    private TextView tvDrink;
    private TextView tvDrinkType;
    private TextView tvAdditives;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reciept);
        getSupportActionBar().hide();
        init();
        setTextFromIntent();
    }
    private void setTextFromIntent(){
        tvName.setText(getIntent().getStringExtra("name"));
        tvDrink.setText(getIntent().getStringExtra("drink"));
        tvDrinkType.setText(getIntent().getStringExtra("drinkType"));
        tvAdditives.setText(getIntent().getStringExtra("additives"));
    }
    private void init(){
        tvDrink = findViewById(R.id.tvDrink);
        tvName = findViewById(R.id.tvName);
        tvDrinkType = findViewById(R.id.tvDrinkType);
        tvAdditives = findViewById(R.id.tvAdditives);
    }
    public static Intent newIntent
            (Context context,
             String drink,
             String drinkType,
             String name,
             String additives
            )
    {
        Intent intent = new Intent(context,reciept.class);
        intent.putExtra("name",name);
        intent.putExtra("drink",drink);
        intent.putExtra("drinkType",drinkType);
        intent.putExtra("additives",additives);
        return intent;
    }
}