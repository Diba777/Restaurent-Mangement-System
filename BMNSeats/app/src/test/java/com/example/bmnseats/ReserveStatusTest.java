package com.example.bmnseats;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ReserveStatusTest {

    @Test
    public void isFree() {
    int Input_Current=5;
    int Input_Console=9;
    int Expected_Output=-1;
    int Real_Output;


    Real_Output=ReserveStatus.isFree(Input_Current,Input_Console);
    assertEquals(Expected_Output,Real_Output);
    }
}