package com.example.rufus.mathree.signin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.rufus.mathree.drawer.MathreeConductorActivity;
import com.example.rufus.mathree.R;
import com.example.rufus.mathree.signup.ConductorRegistration;



public class ConductorSignIn extends AppCompatActivity {
    EditText mUsername2, mPassword2;
    Button mLogin2;
    TextView  RegText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);


        mUsername2 =  findViewById(R.id.username4);
        mPassword2 =  findViewById(R.id.password2);

        mLogin2 =  findViewById(R.id.login2);

        mLogin2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(ConductorSignIn.this,MathreeConductorActivity.class);
                startActivity(intent);
                onStop();

            }
        });

        RegText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ConductorSignIn.this,ConductorRegistration.class);
                startActivity(intent);
                onStop();

            }
        });




    }
}
