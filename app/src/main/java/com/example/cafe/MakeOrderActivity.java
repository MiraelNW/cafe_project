package com.example.cafe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

public class MakeOrderActivity extends AppCompatActivity {
    private TextView tvGreetings;
    private RadioGroup radioGroup;
    private RadioButton radBtnTea;
    private RadioButton radBtnCoffee;
    private TextView tvAdditives;
    private CheckBox cbLemon;
    private CheckBox cbSugar;
    private CheckBox cbMilk;
    private Button btnMakeOrder;
    private Spinner spinCoffee;
    private Spinner spinTea;
    private String drink;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_make_order);
        getSupportActionBar().hide();
        init();
        setUpName();
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int id) {
                if (id==radBtnTea.getId()){
                    ifChosenTea();
                }else if (id == radBtnCoffee.getId()){
                    ifChosenCoffee();
                }
            }
        });
        radBtnTea.setChecked(true);
        btnMakeOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               ifUserMakeOrder();
            }
        });
    }
    private void ifUserMakeOrder(){
       ArrayList<String> additives = new ArrayList<>();
        if(radBtnTea.isChecked() && cbLemon.isChecked()){
            additives.add(cbLemon.getText().toString());
        }
        if(cbSugar.isChecked()){
            additives.add(cbSugar.getText().toString());
        }
        if (cbMilk.isChecked()){
            additives.add(cbMilk.getText().toString());
        }
        if(additives.isEmpty()){
            additives.add("Don't need");
        }

        String drinkType="";
        if (radBtnTea.isChecked()){
            drinkType=spinTea.getSelectedItem().toString();
        }
        if (radBtnCoffee.isChecked()){
            drinkType=spinCoffee.getSelectedItem().toString();
        }
        Intent intent = reciept.newIntent(this,drink,drinkType,getIntent().getStringExtra("name"),additives.toString());
        startActivity(intent);
    }
    private void ifChosenTea(){
        drink = getString(R.string.tea);
        tvAdditives.setText(getString(R.string.additives,drink));
        cbLemon.setVisibility(View.VISIBLE);
        spinTea.setVisibility(View.VISIBLE);
        spinCoffee.setVisibility(View.INVISIBLE);
    }
    private void ifChosenCoffee(){
        drink = getString(R.string.coffee);
        tvAdditives.setText(getString(R.string.additives,drink));
        cbLemon.setVisibility(View.INVISIBLE);
        spinCoffee.setVisibility(View.VISIBLE);
        spinTea.setVisibility(View.INVISIBLE);
    }
    private void setUpName(){
        String name = getIntent().getStringExtra("name");
        String greetings = getString(R.string.greetings);
        tvGreetings.setText(String.format(greetings,name));
    }
    public static Intent newIntent(Context context,String name){
            Intent intent= new Intent(context, MakeOrderActivity.class);
            intent.putExtra("name",name);
            return intent;
    }
    private void init(){
        tvGreetings= findViewById(R.id.tvGreetings);
        radioGroup = findViewById(R.id.radioGroup);
        radBtnTea = findViewById(R.id.radBtnTea);
        radBtnCoffee = findViewById(R.id.radBtnCoffee);
        tvAdditives = findViewById(R.id.tvAdditives);
        cbLemon = findViewById(R.id.cbLemon);
        cbMilk = findViewById(R.id.cbMilk);
        cbSugar = findViewById(R.id.cbSugar);
        btnMakeOrder = findViewById(R.id.btnMakeOrder);
        spinTea = findViewById(R.id.spinTea);
        spinCoffee = findViewById(R.id.spinCoffee);
    }
}