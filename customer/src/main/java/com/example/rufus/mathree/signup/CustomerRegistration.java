package com.example.rufus.mathree.signup;

import android.app.AlertDialog;

import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.example.rufus.mathree.R;
import com.example.rufus.mathree.db.MySingleton;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;


public class CustomerRegistration extends AppCompatActivity {
    EditText Fname,Sname,Rgender,Nphone,Username,Password,Confpassword;
    Button mRegister;
    AlertDialog.Builder builder;
    String reg_url = "http://192.168.1.108/register.php";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_registration);

        Fname =  findViewById(R.id.firstname);
        Sname =  findViewById(R.id.secondname);
        Rgender =  findViewById(R.id.gender);
        Nphone =  findViewById(R.id.phone);
        Username =  findViewById(R.id.username);
        Password =  findViewById(R.id.password3);
        Confpassword =  findViewById(R.id.password4);
        mRegister =  findViewById(R.id.button1);

        builder = new AlertDialog.Builder(CustomerRegistration.this);


        mRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String firstname = Fname.getText().toString();
                final String secondname = Sname.getText().toString();
                final String gender = Rgender.getText().toString();
                final String phone = Nphone.getText().toString();
                final String username = Username.getText().toString();
                final String password = Password.getText().toString();
                String password4= Confpassword.getText().toString();



            if(firstname.equals("")||secondname.equals("")||gender.equals("")||phone.equals("")||username.equals("")||password.equals("")||password4.equals("")) {
                builder.setTitle("Something went Wrong!");
                    builder.setMessage("You Need To Fill In All Details!");
                    displayAlert("input_error");
            }
            else{
                if(!(password.equals(""))){
                    builder.setTitle("Something went Wrong!");
                    builder.setMessage("Please Make Sure Your Passwords Are Matching!");
                    displayAlert("input_error");

                }
                else{
                    StringRequest stringRequest = new StringRequest(Request.Method.POST, reg_url, new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            try {
                                JSONArray jsonArray = new JSONArray(response);
                                JSONObject jsonObject= jsonArray.getJSONObject(0);
                                String code = jsonObject.getString("code");
                                String message = jsonObject.getString("message");
                                builder.setTitle("Server Response");
                                builder.setMessage(message);
                                displayAlert(code);
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }


                        }
                    }, new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {

                        }

                    }){
                        @Override
                        protected Map<String, String> getParams() throws AuthFailureError {
                            Map<String,String> params = new HashMap<String,String>();
                            params.put("firstname",firstname);
                            params.put("secondname",secondname);
                            params.put("username",username);
                            params.put("gender",gender);
                            params.put("phone",phone);
                            params.put("password",password);
                            return params;
                        }
                    };
                    MySingleton.getInstance(CustomerRegistration.this).addToRequestque(stringRequest);
                }
            }
            }
        });
    }
    public void displayAlert(final String code){
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                if(code.equals("input_error")){
                    Password.setText("");
                    Confpassword.setText("");
                }
                else if(code.equals("reg_success")){
                    finish();
                }
                else if(code.equals("reg_failed")){
                    Fname.setText("");
                    Sname.setText("");
                    Rgender.setText("");
                    Nphone.setText("");
                    Username.setText("");
                    Password.setText("");
                    Confpassword.setText("");
                }
            }
        });
        AlertDialog alertDialog =builder.create();
         alertDialog.show();

    }



}
