package com.example.bmnseats;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class HomePage extends AppCompatActivity {

    private TextView Welcome_Textview;
    private Button Searchitem_Button;
    private Button Find_Point_Button;
    private Button Reserve_Table_Button;
    private AlertDialog.Builder alertDialogBuilder;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        Welcome_Textview=(TextView)findViewById(R.id.welcomeId);
        Searchitem_Button=(Button)findViewById(R.id.searchItems);
        Find_Point_Button=findViewById(R.id.findNearest);
        Reserve_Table_Button=findViewById(R.id.reserveTable);

        Typeface Type_Face=Typeface.createFromAsset(getAssets(),"fonts/hetilica.ttf");
        Welcome_Textview.setTypeface(Type_Face);

        Searchitem_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Intent_Searchitem=new Intent(HomePage.this, Home.class);
                startActivity(Intent_Searchitem);
            }
        });
        Find_Point_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Intent_Find_Point=new Intent(HomePage.this, FindNearestPoint.class);
                startActivity(Intent_Find_Point);
            }
        });
        Reserve_Table_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Intent_Reserve_Table=new Intent(HomePage.this,ReserveStatus.class);
                startActivity(Intent_Reserve_Table);
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
            Intent Intent_Searchitem=new Intent(HomePage.this, Home.class);
            startActivity(Intent_Searchitem);
            return true;
        }
        if (item.getItemId()== R.id.seeTopuser)
        {
            Intent Intent_Seetopuser=new Intent(HomePage.this,Topuser.class);
            startActivity(Intent_Seetopuser);
            return true;
        }
       if(item.getItemId()== R.id.aboutUs)
       {
           Intent Intent_Aboutus=new Intent(HomePage.this, Aboutus.class);
           startActivity(Intent_Aboutus);
           return true;
       }

       if(item.getItemId()== R.id.singOut)
       {
           alertDialogBuilder=new AlertDialog.Builder(HomePage.this);
           alertDialogBuilder.setTitle(R.string.title);
           alertDialogBuilder.setIcon(R.drawable.exit);
           alertDialogBuilder.setMessage(R.string.message);
           alertDialogBuilder.setCancelable(false);

           alertDialogBuilder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
               @Override
               public void onClick(DialogInterface dialogInterface, int i) {
                   Intent Intent_Signout=new Intent(HomePage.this, MainActivity.class);
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
