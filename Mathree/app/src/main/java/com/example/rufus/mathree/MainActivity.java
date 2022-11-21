package com.example.rufus.mathree;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.rufus.mathree.signin.CustomerSignIn;
import com.example.rufus.mathree.signin.ConductorSignIn;

public class MainActivity extends AppCompatActivity {
    Button mConductor, mCustomer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mConductor = (Button) findViewById(R.id.conductor);
        mCustomer = (Button) findViewById(R.id.customer);

        mCustomer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,CustomerSignIn.class);
                startActivity(intent);
                onStop();
                return;
            }
        });

        mConductor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,ConductorSignIn.class);
                startActivity(intent);
                onStop();
                return;

            }
        });
    }
}
