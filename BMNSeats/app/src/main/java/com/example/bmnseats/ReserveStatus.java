package com.example.bmnseats;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ReserveStatus extends AppCompatActivity {

    private Button Button_For_Status;
    private EditText EditText_For_Date_Input;
    int Flag_One=-1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reserve_status);
        EditText_For_Date_Input=findViewById(R.id.editTextForDate);
        Button_For_Status=findViewById(R.id.buttonForStatus);

        Button_For_Status.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Flag_One=isFree(5,Integer.parseInt(EditText_For_Date_Input.getText().toString()));
                if(Flag_One==-1)
                {
                    Toast.makeText(ReserveStatus.this, "Not Available!!! Try again", Toast.LENGTH_SHORT).show();
                }
                else if(Flag_One==1)
                {
                    startActivity(new Intent(ReserveStatus.this,ReserveTable.class));
                }
            }
        });
    }
    static int isFree(int Current_Date,int Input_Date)
    {
        if(Input_Date==Current_Date || Input_Date==(Current_Date+1))
        {
            return 1;
        }
        else
        {
            return -1;
        }
    }
}
