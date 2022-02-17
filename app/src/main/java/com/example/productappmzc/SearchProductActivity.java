package com.example.productappmzc;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class SearchProductActivity extends AppCompatActivity {
    EditText ed1,ed2,ed3;
    AppCompatButton b1,b2;
    String getprodcode,getprodname,getpric;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_product);
        ed1=(EditText) findViewById(R.id.prodcode);
        ed2=(EditText) findViewById(R.id.prdname);
        ed3=(EditText) findViewById(R.id.pric);
        b1=(AppCompatButton) findViewById(R.id.searbtn);
        b2=(AppCompatButton) findViewById(R.id.backtomen);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(),MainActivity.class);
                startActivity(i);
            }
        });
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getprodcode = ed1.getText().toString();
                Toast.makeText(getApplicationContext(),getprodcode, Toast.LENGTH_LONG).show();
            }
        });

    }
}