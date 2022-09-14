package com.example.cafe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText editName;
    private EditText editPassword;
    private Button btnSign;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);
        initViews();
        btnSign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = editName.getText().toString().trim();
                String password = editPassword.getText().toString().trim();
                if (name.isEmpty()||password.isEmpty()){
                    Toast.makeText(MainActivity.this,getString(R.string.errors),Toast.LENGTH_SHORT).show();
                }else{
                    Intent intent = MakeOrderActivity.newIntent(MainActivity.this, name);
                    startActivity(intent);

                }
            }
        });
    }
    private void initViews(){
        editName = findViewById(R.id.EditName);
        editPassword = findViewById(R.id.EditPassword);
        btnSign = findViewById(R.id.btnSign);
    }
}