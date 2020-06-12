package com.example.bmnseats;

import org.junit.Test;

import static org.junit.Assert.*;

public class BkashTest {

    @Test
    public void checkMoney() {
        String Input_Acc="  Tasneem ";
        String Input_Mobile_Num="  01779198784";
        boolean Expected_Output=true;
        boolean Real_Output;

        Real_Output=Bkash.checkMoney(Input_Acc,Input_Mobile_Num);
        assertEquals(Expected_Output,Real_Output);
    }
}