package com.example.rufus.mathree.signin;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.example.rufus.mathree.db.MySingleton;
import com.example.rufus.mathree.drawer.MathreeCustomerActivity;
import com.example.rufus.mathree.R;
import com.example.rufus.mathree.signup.CustomerRegistration;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;


public class CustomerSignIn extends AppCompatActivity {
    EditText mUsername, mPassword;
    Button mLogin;
    TextView RegText2;
    String username,password;
    String login_url = "http://192.168.1.108/login.php";
    AlertDialog.Builder builder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        mUsername =  findViewById(R.id.username3);
        mPassword =  findViewById(R.id.password);

        mLogin =  findViewById(R.id.login);
        RegText2 =  findViewById(R.id.Clickreg2);



        mLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                final String username = mUsername.getText().toString();
                final String password = mPassword.getText().toString();

                if (password.equals("") || username.equals("")) {

                    builder.setTitle("Something went Wrong");
                    displayAlert("Enter a valid username and Password");

                }
                else{
                    StringRequest stringRequest = new StringRequest(Request.Method.POST, login_url, new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            JSONArray jsonArray = null;
                            try {
                                jsonArray = new JSONArray(response);
                                JSONObject jsonObject= jsonArray.getJSONObject(0);
                                String code = jsonObject.getString("code");
                                if(code.equals("login_failed")){
                                    builder.setTitle("Login Error");
                                    displayAlert(jsonObject.getString("message"));
                                }
                                else{
                                    Intent intent = new Intent(CustomerSignIn.this,MathreeCustomerActivity.class);
                                    startActivity(intent);
                                    onStop();
                                    Bundle bundle =new Bundle();
                                     bundle.putString("firstname",jsonObject.getString("firstname"));
                                     bundle.putString("phone",jsonObject.getString("phone"));
                                    intent.putExtras(intent);
                                    startActivity(intent);


                                }
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }


                        }
                    }, new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            Toast.makeText(CustomerSignIn.this,"Error", Toast.LENGTH_LONG).show();
                            error.printStackTrace();



                        }
                    })
                    {
                        @Override
                        protected Map<String, String> getParams() throws AuthFailureError {
                            Map<String,String> params= new HashMap<String, String>();

                            params.put("username",username);
                            params.put("password",password);

                            return params;
                        }
                    };
                    MySingleton.getInstance(CustomerSignIn.this).addToRequestque(stringRequest);
                }




            }
        });


        RegText2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CustomerSignIn.this,CustomerRegistration.class);
                startActivity(intent);
                onStop();

            }
        });
        builder = new AlertDialog.Builder(CustomerSignIn.this);







    }

    public void displayAlert(String message){

        builder.setMessage(message);
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                mUsername.setText("");
                mPassword.setText("");

            }


        });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();


    }



}
