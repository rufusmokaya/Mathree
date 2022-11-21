package com.example.rufus.mathree.signup;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.rufus.mathree.R;

public class ConductorRegistration extends AppCompatActivity {
    EditText Fname,Sname,Rgender, Nphone, Username,Password,Confpassword,route,buscompany;
    Button mRegister;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conductor_registration);

        Fname = (EditText) findViewById(R.id.firstname);
        Sname = (EditText) findViewById(R.id.secondname);
        Rgender = (EditText) findViewById(R.id.gender);
        Nphone = (EditText) findViewById(R.id.phone);
        Username = (EditText) findViewById(R.id.username1);
        Password = (EditText) findViewById(R.id.password3);
        Confpassword = (EditText) findViewById(R.id.password4);
        route = (EditText) findViewById(R.id.route);
        buscompany = (EditText) findViewById(R.id.buscompany);

        mRegister = (Button) findViewById(R.id.button1);

        mRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"CustomerRegistration Successful ",
                        Toast.LENGTH_SHORT).show();
            }
        });




    }


}
