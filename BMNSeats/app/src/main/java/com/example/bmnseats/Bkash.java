package com.example.bmnseats;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Bkash extends AppCompatActivity {

    private EditText Edit_Text_Bkash_Acc;
    private EditText Edit_Text_Bkash_Mobile;
    private Button Button_Proceed;
    private int Flag_Bool;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bkash);
        Edit_Text_Bkash_Acc=findViewById(R.id.acHolderBkash);
        Edit_Text_Bkash_Mobile=findViewById(R.id.mobileNumBkash);
        Button_Proceed=findViewById(R.id.proceedButtonBkash);
        Button_Proceed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Boolean Check_Bool=checkMoney(Edit_Text_Bkash_Acc.getText().toString(),Edit_Text_Bkash_Mobile.getText().toString());
                if(Check_Bool==true)
                {
                    Toast.makeText(Bkash.this, "Payment Done!! Thank You", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(Bkash.this,MainActivity.class));
                }
                else
                {
                    Toast.makeText(Bkash.this, "Invalid!!!!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    static Boolean checkMoney(String Acc_name,String Mobile_Num)
    {
        if(Acc_name.trim().equals("Tasneem") && Mobile_Num.trim().equals("01779198784"))
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}
