package com.example.productappmzc;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class AddProductActivity extends AppCompatActivity {
    EditText ed1,ed2,ed3;
    AppCompatButton b1,b2;
    String getprdcode,getprdname,getprice;
    DatabaseHelper dbhelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_product);
        dbhelper=new DatabaseHelper(this);
        dbhelper.getWritableDatabase();
        ed1=(EditText) findViewById(R.id.prdcode);
        ed2=(EditText) findViewById(R.id.prdname);
        ed3=(EditText) findViewById(R.id.price);
        b1=(AppCompatButton) findViewById(R.id.subbtn);
        b2=(AppCompatButton) findViewById(R.id.backtomenu);
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
                getprdcode = ed1.getText().toString();
                getprdname = ed2.getText().toString();
                getprice = ed3.getText().toString();

                Toast.makeText(getApplicationContext(),getprdcode,Toast.LENGTH_LONG).show();
                Toast.makeText(getApplicationContext(),getprdname,Toast.LENGTH_LONG).show();
                Toast.makeText(getApplicationContext(),getprice,Toast.LENGTH_LONG).show();
                boolean result = dbhelper.InsertData(getprdcode, getprdname, getprice);
                if (result == true) {
                    ed1.setText("");
                    ed2.setText("");
                    ed3.setText("");
                    Toast.makeText(getApplicationContext(), "Successfully inserted", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(getApplicationContext(),"Failed to inserted",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}