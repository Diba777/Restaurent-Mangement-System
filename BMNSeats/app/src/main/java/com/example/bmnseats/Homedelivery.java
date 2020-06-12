package com.example.bmnseats;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Homedelivery extends AppCompatActivity {

    public TextView TextView_One;
    public TextView TextView_Two;
    public TextView TextView_Three;

    public EditText EditText_One;
    public EditText EditText_Two;

    public Button Button_One;
    public Button Button_Two;

    public String Edit_Rcv_One;
    public String Edit_Rcv_Two;

    private AlertDialog.Builder alertDialogBuilder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homedelivery);

        TextView_One=findViewById(R.id.textView1);
        TextView_One.setSelected(true);
        TextView_Two=findViewById(R.id.textView2);
        TextView_Three=findViewById(R.id.textView3);

        EditText_One=findViewById(R.id.editText1);
        EditText_Two=findViewById(R.id.editText2);

        Button_One=findViewById(R.id.button1);
        Button_Two=findViewById(R.id.button2);

        Button_Two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Edit_Rcv_One =EditText_One.getText().toString();
                if(Edit_Rcv_One.equalsIgnoreCase("Mirpur") || Edit_Rcv_One.contains("Mirpur") || Edit_Rcv_One.contains("mirpur"))
                {
                    Toast.makeText(Homedelivery.this,"50 Taka will be your Delivery charge",Toast.LENGTH_LONG).show();
                }
                else if(Edit_Rcv_One.equalsIgnoreCase("Dhanmondi ") || Edit_Rcv_One.contains("Dhanmondi") || Edit_Rcv_One.contains("dhanmondi"))
                {
                    Toast.makeText(Homedelivery.this,"70 Taka will be your Delivery charge",Toast.LENGTH_LONG).show();
                }
                else
                {
                    Toast.makeText(Homedelivery.this,"Route Not found Please try again",Toast.LENGTH_SHORT).show();

                }
            }


        });

        EditText_One.addTextChangedListener(delivery_watcher);
        EditText_Two.addTextChangedListener(delivery_watcher);


    }

    private TextWatcher delivery_watcher=new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            Edit_Rcv_One=EditText_One.getText().toString().trim();
            Edit_Rcv_Two=EditText_Two.getText().toString().trim();

            Button_One.setEnabled(!Edit_Rcv_Two.isEmpty() && !Edit_Rcv_Two.isEmpty() && Edit_Rcv_Two.equalsIgnoreCase("Dhaka"));
            Button_One.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent Intent_Payment=new Intent(Homedelivery.this,payment.class);
                    startActivity(Intent_Payment);
                }
            });
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };

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
            Intent Intent_Searchitem=new Intent(Homedelivery.this, Home.class);
            startActivity(Intent_Searchitem);
            return true;
        }
        if (item.getItemId()== R.id.seeTopuser)
        {
            Intent Intent_Seetopuser=new Intent(Homedelivery.this,Topuser.class);
            startActivity(Intent_Seetopuser);
            return true;
        }
        if(item.getItemId()== R.id.aboutUs)
        {
            Intent Intent_Aboutus=new Intent(Homedelivery.this, Aboutus.class);
            startActivity(Intent_Aboutus);
            return true;
        }

        if(item.getItemId()== R.id.singOut)
        {
            alertDialogBuilder=new AlertDialog.Builder(Homedelivery.this);
            alertDialogBuilder.setTitle(R.string.title);
            alertDialogBuilder.setIcon(R.drawable.exit);
            alertDialogBuilder.setMessage(R.string.message);
            alertDialogBuilder.setCancelable(false);

            alertDialogBuilder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    Intent Intent_Signout=new Intent(Homedelivery.this, MainActivity.class);
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
