package com.example.bmnseats;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
private Button Signup_Button,Signin_Button;
private TextView Slogan_Textview;
Intent Intent_Intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Signin_Button=(Button)findViewById(R.id.signIn);
        Signup_Button=(Button)findViewById(R.id.signUp);
        Slogan_Textview=(TextView)findViewById(R.id.txtSlogan);
        Typeface Type_Face=Typeface.createFromAsset(getAssets(),"fonts/hetilica.ttf");
        Slogan_Textview.setTypeface(Type_Face);
        Signup_Button.setOnClickListener(this);
        Signin_Button.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.signUp)
        {
            Intent Intent_Intent=new Intent(MainActivity.this,Signup.class);
            startActivity(Intent_Intent);
        }
        else if(v.getId()==R.id.signIn)
        {
            Intent Intent_Intent=new Intent(MainActivity.this,Signin.class);
            startActivity(Intent_Intent);
        }
    }
}
