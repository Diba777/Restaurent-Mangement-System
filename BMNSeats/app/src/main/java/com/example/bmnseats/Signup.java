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

public class Signup extends AppCompatActivity {

    private EditText Firstname_Edittext,Lastname_Edittext,Phonenumber_Edittext,Email_Edittext,Password_Edittext;
    private Button Signup_Button;
    private Intent Home_Intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        Firstname_Edittext=(EditText)findViewById(R.id.signupFname);
        Lastname_Edittext=(EditText)findViewById(R.id.signupLname);
        Phonenumber_Edittext=(EditText)findViewById(R.id.signupPhonenumber);
        Email_Edittext=(EditText)findViewById(R.id.signupEmail);
        Password_Edittext=(EditText)findViewById(R.id.signupPassword);

        Signup_Button=(Button)findViewById(R.id.signUp);
        //init firebase database
        FirebaseDatabase Database_Firebase = FirebaseDatabase.getInstance();
        final DatabaseReference Table_User = Database_Firebase.getReference("user");

        Signup_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final ProgressDialog Dialog_Progress=new ProgressDialog(Signup.this);
                Dialog_Progress.setMessage("Please Waiting......");
                Dialog_Progress.show();

                Table_User.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    //check if already exists
                        if(dataSnapshot.child(Phonenumber_Edittext.getText().toString()).exists())
                        {
                            Dialog_Progress.dismiss();
                            Toast.makeText(Signup.this,"Phone Number is already registered",Toast.LENGTH_SHORT).show();
                            Intent Home_Intent=new Intent(Signup.this, HomePage.class);
                            startActivity(Home_Intent);
                        }
                        else
                        {
                            Dialog_Progress.dismiss();
                            user User_Database=new user(Firstname_Edittext.getText().toString(),Lastname_Edittext.getText().toString(),Email_Edittext.getText().toString(),Password_Edittext.getText().toString());
                            Table_User.child(Phonenumber_Edittext.getText().toString()).setValue(User_Database);
                            Toast.makeText(Signup.this, "Sign Up successfully !", Toast.LENGTH_SHORT).show();
                            finish();

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
