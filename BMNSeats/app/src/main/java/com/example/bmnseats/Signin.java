package com.example.bmnseats;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.bmnseats.model.user;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Signin extends AppCompatActivity {

    private EditText Email_Edittext, Phonenumber_Edittext, Password_Edittext;
    private Button Signin_Button;
    private Intent Home_Intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);

        Phonenumber_Edittext = (EditText) findViewById(R.id.signinPhonenumber);
        Email_Edittext = (EditText) findViewById(R.id.signinEmail);
        Password_Edittext = (EditText) findViewById(R.id.signinPassword);
        Signin_Button = (Button) findViewById(R.id.signIn);
//init Database
        FirebaseDatabase Database_Firebase = FirebaseDatabase.getInstance();
        final DatabaseReference Table_User = Database_Firebase.getReference("user");

        Signin_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final ProgressDialog Dialog_Progress=new ProgressDialog(Signin.this);
                Dialog_Progress.setMessage("Please Wait......");
                Dialog_Progress.show();

                Table_User.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot)
                    {
                            //Check if user not exists
                        if (dataSnapshot.child(Phonenumber_Edittext.getText().toString()).exists())
                        {
                            //get user info

                            Dialog_Progress.dismiss();
                            user User_database = dataSnapshot.child(Phonenumber_Edittext.getText().toString()).getValue(user.class);
                            if (User_database.getPassword().equals(Password_Edittext.getText().toString()) && User_database.getEmail().equals(Email_Edittext.getText().toString()))
                            {
                                Toast.makeText(Signin.this, "Sign In Successfully", Toast.LENGTH_SHORT).show();
                                Intent Home_Intent=new Intent(Signin.this,HomePage.class);
                                startActivity(Home_Intent);
                            }
                            else
                            {
                                Toast.makeText(Signin.this, "Check Your Password or Email!!!", Toast.LENGTH_SHORT).show();
                            }

                        }
                        else
                        {
                            Dialog_Progress.dismiss();
                            Toast.makeText(Signin.this,"User not exists",Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
            }
        });
    }

}
