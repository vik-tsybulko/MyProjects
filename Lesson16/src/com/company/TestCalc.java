package com.company;
import org.junit.*;

import static org.junit.Assert.*;


public class TestCalc {
    private static Calc c;

    @BeforeClass
    public static void setUpBeforeClass() throws Exception{
        System.out.println("Before Class");
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception{
        System.out.println("After Class");
    }

    @Before
    public static void tearUp() throws Exception{
        System.out.println("Before");
        c = new Calc();

    }
    @After
    public static void tearDown() throws Exception{
        System.out.println("After");
    }
@Test
    public void testAdd(){
    assertEquals(7,c.add(5,2));

    }
@Test
    public void testDiv(){
    assertEquals(3, c.div(15, 5));
}

}
