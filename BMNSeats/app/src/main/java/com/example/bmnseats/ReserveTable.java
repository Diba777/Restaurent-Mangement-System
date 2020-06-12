package com.example.bmnseats;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ReserveTable extends AppCompatActivity {

    private Button Table_One_Button;
    private Button Table_Two_Button;
    private Button Table_Three_Button;
    private Button Table_Four_Button;
    private Button Table_Five_Button;
    private Button Table_Six_Button;
    private Button Table_Seven_Button;
    private Button Table_Eight_Button;
    private Button Table_Nine_Button;
    private Button Table_Ten_Button;
    private Button Table_Eleven_Button;
    private Button Table_Twelve_Button;

    static int Count_1=0;
    static int Count_2=0;
    static int Count_3=0;
    static int Count_4=0;
    static int Count_5=0;
    static int Count_6=0;
    static int Count_7=0;
    static int Count_8=0;
    static int Count_9=0;
    static int Count_10=0;
    static int Count_11=0;
    static int Count_12=0;
    int Flag_One=-1;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reserve_table);
        Table_One_Button=findViewById(R.id.tableOne);
        Table_Two_Button=findViewById(R.id.tableTwo);
        Table_Three_Button=findViewById(R.id.tableThree);
        Table_Four_Button=findViewById(R.id.tableFour);
        Table_Five_Button=findViewById(R.id.tableFive);
        Table_Six_Button=findViewById(R.id.tableSix);
        Table_Seven_Button=findViewById(R.id.tableSeven);
        Table_Eight_Button=findViewById(R.id.tableEight);
        Table_Nine_Button=findViewById(R.id.tableNine);
        Table_Ten_Button=findViewById(R.id.tableTen);
        Table_Eleven_Button=findViewById(R.id.tableEleven);
        Table_Twelve_Button=findViewById(R.id.tableTwelve);


        Table_One_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Count_1==0)
                {
                    Toast.makeText(ReserveTable.this,"Table is ordered",Toast.LENGTH_LONG).show();
                    Count_1++;
                }
                else
                {
                    Toast.makeText(ReserveTable.this,"Sorry It has been Ordered",Toast.LENGTH_SHORT).show();
                }
            }
        });
        Table_Two_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Count_2==0)
                {
                    Toast.makeText(ReserveTable.this,"Table is ordered",Toast.LENGTH_LONG).show();
                    Count_2++;
                }
                else
                {
                    Toast.makeText(ReserveTable.this,"Sorry It has been Ordered",Toast.LENGTH_SHORT).show();
                }
            }
        });
        Table_Three_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Count_3==0)
                {
                    Toast.makeText(ReserveTable.this,"Table is ordered",Toast.LENGTH_LONG).show();
                    Count_3++;
                }
                else
                {
                    Toast.makeText(ReserveTable.this,"Sorry It has been Ordered",Toast.LENGTH_SHORT).show();
                }
            }
        });
        Table_Four_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Count_4==0)
                {
                    Toast.makeText(ReserveTable.this,"Table is ordered",Toast.LENGTH_LONG).show();
                    Count_4++;
                }
                else
                {
                    Toast.makeText(ReserveTable.this,"Sorry It has been Ordered",Toast.LENGTH_SHORT).show();
                }
            }
        });
        Table_Five_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Count_5==0)
                {
                    Toast.makeText(ReserveTable.this,"Table is ordered",Toast.LENGTH_LONG).show();
                    Count_5++;
                }
                else
                {
                    Toast.makeText(ReserveTable.this,"Sorry It has been Ordered",Toast.LENGTH_SHORT).show();
                }
            }
        });
        Table_Six_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Count_6==0)
                {
                    Toast.makeText(ReserveTable.this,"Table is ordered",Toast.LENGTH_LONG).show();
                    Count_6++;
                }
                else
                {
                    Toast.makeText(ReserveTable.this,"Sorry It has been Ordered",Toast.LENGTH_SHORT).show();
                }
            }
        });
        Table_Seven_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Count_7==0)
                {
                    Toast.makeText(ReserveTable.this,"Table is ordered",Toast.LENGTH_LONG).show();
                    Count_7++;
                }
                else
                {
                    Toast.makeText(ReserveTable.this,"Sorry It has been Ordered",Toast.LENGTH_SHORT).show();
                }
            }
        });
        Table_Eight_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Count_8==0)
                {
                    Toast.makeText(ReserveTable.this,"Table is ordered",Toast.LENGTH_LONG).show();
                    Count_8++;
                }
                else
                {
                    Toast.makeText(ReserveTable.this,"Sorry It has been Ordered",Toast.LENGTH_SHORT).show();
                }
            }
        });
        Table_Nine_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Count_9==0)
                {
                    Toast.makeText(ReserveTable.this,"Table is ordered",Toast.LENGTH_LONG).show();
                    Count_9++;
                }
                else
                {
                    Toast.makeText(ReserveTable.this,"Sorry It has been Ordered",Toast.LENGTH_SHORT).show();
                }
            }
        });
        Table_Ten_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Count_10==0)
                {
                    Toast.makeText(ReserveTable.this,"Table is ordered",Toast.LENGTH_LONG).show();
                    Count_10++;
                }
                else
                {
                    Toast.makeText(ReserveTable.this,"Sorry It has been Ordered",Toast.LENGTH_SHORT).show();
                }
            }
        });
        Table_Eleven_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Count_11==0)
                {
                    Toast.makeText(ReserveTable.this,"Table is ordered",Toast.LENGTH_LONG).show();
                    Count_11++;
                }
                else
                {
                    Toast.makeText(ReserveTable.this,"Sorry It has been Ordered",Toast.LENGTH_SHORT).show();
                }
            }
        });
        Table_Twelve_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Count_12==0)
                {
                    Toast.makeText(ReserveTable.this,"Table is ordered",Toast.LENGTH_LONG).show();
                    Count_12++;
                }
                else
                {
                    Toast.makeText(ReserveTable.this,"Sorry It has been Ordered",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }


}
