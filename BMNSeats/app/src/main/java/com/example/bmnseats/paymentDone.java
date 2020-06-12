package com.example.bmnseats;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class paymentDone extends AppCompatActivity {

    private AlertDialog.Builder alertDialogBuilder;
    private Button Button_Back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_done);
        Button_Back=findViewById(R.id.backForMain);
        Button_Back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(paymentDone.this,MainActivity.class));
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
            Intent Intent_Searchitem=new Intent(paymentDone.this, Home.class);
            startActivity(Intent_Searchitem);
            return true;
        }
        if (item.getItemId()== R.id.seeTopuser)
        {
            Intent Intent_Seetopuser=new Intent(paymentDone.this,Topuser.class);
            startActivity(Intent_Seetopuser);
            return true;
        }
        if(item.getItemId()== R.id.aboutUs)
        {
            Intent Intent_Aboutus=new Intent(paymentDone.this, Aboutus.class);
            startActivity(Intent_Aboutus);
            return true;
        }

        if(item.getItemId()== R.id.singOut)
        {
            alertDialogBuilder=new AlertDialog.Builder(paymentDone.this);
            alertDialogBuilder.setTitle(R.string.title);
            alertDialogBuilder.setIcon(R.drawable.exit);
            alertDialogBuilder.setMessage(R.string.message);
            alertDialogBuilder.setCancelable(false);

            alertDialogBuilder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    Intent Intent_Signout=new Intent(paymentDone.this, MainActivity.class);
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
