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
import android.widget.RadioGroup;

public class MobileBanking extends AppCompatActivity {
private AlertDialog.Builder alertDialogBuilder;
private RadioGroup Radio_Group_For_Mobile;
private Button Button_Confirm;
@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mobile_banking);
        Radio_Group_For_Mobile=findViewById(R.id.radioGroupMb);
        Button_Confirm=findViewById(R.id.buttonConfirm);
        Button_Confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int Sel_ID_Radio=Radio_Group_For_Mobile.getCheckedRadioButtonId();
                if(v.getId()==R.id.buttonConfirm)
                {
                    if(Sel_ID_Radio==R.id.radioButtonBkash || Sel_ID_Radio==R.id.radioButtonRocket)
                    {
                        startActivity(new Intent(MobileBanking.this,Bkash.class));
                    }

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
            Intent Intent_Searchitem=new Intent(MobileBanking.this, Home.class);
            startActivity(Intent_Searchitem);
            return true;
        }
        if (item.getItemId()== R.id.seeTopuser)
        {
            Intent Intent_Seetopuser=new Intent(MobileBanking.this,Topuser.class);
            startActivity(Intent_Seetopuser);
            return true;
        }
        if(item.getItemId()== R.id.aboutUs)
        {
            Intent Intent_Aboutus=new Intent(MobileBanking.this, Aboutus.class);
            startActivity(Intent_Aboutus);
            return true;
        }

        if(item.getItemId()== R.id.singOut)
        {
            alertDialogBuilder=new AlertDialog.Builder(MobileBanking.this);
            alertDialogBuilder.setTitle(R.string.title);
            alertDialogBuilder.setIcon(R.drawable.exit);
            alertDialogBuilder.setMessage(R.string.message);
            alertDialogBuilder.setCancelable(false);

            alertDialogBuilder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    Intent Intent_Signout=new Intent(MobileBanking.this, MainActivity.class);
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
