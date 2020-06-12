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
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

public class Home extends AppCompatActivity {

    private ListView Search_Items;
    ArrayAdapter<String> adapter;
    private SearchView Searchview_Id;
    private AlertDialog.Builder alertDialogBuilder;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Search_Items= (ListView)findViewById(R.id.searchItems);

        Searchview_Id = (SearchView) findViewById(R.id.searchviewId);
        final String[] Item_Names= getResources().getStringArray(R.array.itemNames);

        adapter= new ArrayAdapter<String>(Home.this, R.layout.sample_layout1, R.id.Textview_Id, Item_Names ) ;

        Search_Items.setAdapter(adapter);

        Search_Items.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                String value = Item_Names[position];
                Toast.makeText(Home.this, value, Toast.LENGTH_SHORT).show();
                Intent Intent_One= new Intent(Home.this, FoodDetails.class);
                startActivity(Intent_One);
            }
        });

        Searchview_Id.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                adapter.getFilter().filter(newText);
                return false;
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
            Intent Intent_Searchitem=new Intent(Home.this, Home.class);
            startActivity(Intent_Searchitem);
            return true;
        }
        if (item.getItemId()== R.id.seeTopuser)
        {
            Intent Intent_Seetopuser=new Intent(Home.this,Topuser.class);
            startActivity(Intent_Seetopuser);
            return true;
        }
        if(item.getItemId()== R.id.aboutUs)
        {
            Intent Intent_Aboutus=new Intent(Home.this, Aboutus.class);
            startActivity(Intent_Aboutus);
            return true;
        }

        if(item.getItemId()== R.id.singOut)
        {
            alertDialogBuilder=new AlertDialog.Builder(Home.this);
            alertDialogBuilder.setTitle(R.string.title);
            alertDialogBuilder.setIcon(R.drawable.exit);
            alertDialogBuilder.setMessage(R.string.message);
            alertDialogBuilder.setCancelable(false);

            alertDialogBuilder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    Intent Intent_Signout=new Intent(Home.this, MainActivity.class);
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

