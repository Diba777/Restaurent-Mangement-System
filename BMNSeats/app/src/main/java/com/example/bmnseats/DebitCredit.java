package com.example.bmnseats;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class DebitCredit extends AppCompatActivity {

    private EditText Acname_Edittext,Cardno_Edittext;
    private Button Proceed_Button,Refresh_Button;
    private AlertDialog.Builder alertDialogBuilder;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_debit_credit);

        Acname_Edittext=findViewById(R.id.acHolderName);
        Cardno_Edittext=findViewById(R.id.cardNo);
        Proceed_Button=findViewById(R.id.proceedButton);


        FirebaseDatabase Database_Firebase = FirebaseDatabase.getInstance();
        final DatabaseReference Table_Payment = Database_Firebase.getReference("payment");

        Proceed_Button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

              if(Acname_Edittext.getText().toString().contains("Tanzim") || Cardno_Edittext.getText().toString().contains("1234567890") )
              {
                  Intent Intent_Payment =new Intent(DebitCredit.this,paymentDone.class);
                  startActivity(Intent_Payment);
              } else if (Acname_Edittext.getText().toString().contains("Bony") && Cardno_Edittext.getText().toString().contains("0987654321")) {
                  Toast.makeText(DebitCredit.this, "Insufficient Balance!!!", Toast.LENGTH_SHORT).show();
              }
              else
              {
                  Toast.makeText(DebitCredit.this, "Invalid User!!", Toast.LENGTH_SHORT).show();
              }

            }
        });



    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater Inflater_Menu = getMenuInflater();
        Inflater_Menu.inflate(R.menu.menu_layout,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if(item.getItemId()== R.id.searchItems)
        {
            Intent Intent_Searchitem=new Intent(DebitCredit.this,Home.class);
            startActivity(Intent_Searchitem);
            return true;
        }
        if (item.getItemId()== R.id.seeTopuser)
        {
            Intent Intent_Seetopuser=new Intent(DebitCredit.this,Topuser.class);
            startActivity(Intent_Seetopuser);
            return true;
        }
        if(item.getItemId()== R.id.aboutUs)
        {
            Intent Intent_Aboutus=new Intent(DebitCredit.this, Aboutus.class);
            startActivity(Intent_Aboutus);
            return true;
        }

        if(item.getItemId()== R.id.singOut)
        {
            alertDialogBuilder=new AlertDialog.Builder(DebitCredit.this);
            alertDialogBuilder.setTitle(R.string.title);
            alertDialogBuilder.setIcon(R.drawable.exit);
            alertDialogBuilder.setMessage(R.string.message);
            alertDialogBuilder.setCancelable(false);

            alertDialogBuilder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    Intent Intent_Signout=new Intent(DebitCredit.this, MainActivity.class);
                    startActivity(Intent_Signout);
                    finish();

                }
            });
            alertDialogBuilder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.cancel();
                }
            });
            alertDialogBuilder.setNeutralButton("Cancel", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {

                }
            });

            AlertDialog alertDialog=alertDialogBuilder.create();
            alertDialog.show();
            return  true;
        }

        return super.onOptionsItemSelected(item);
    }
}
