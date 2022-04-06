package test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;
import org.junit.jupiter.params.shadow.com.univocity.parsers.annotations.Convert;

import currencyConverter.Currency;
import currencyConverter.MainWindow;

public class testsboitenoire {
    
    //tests pour currencyConverter.Currency.convert(Double, Double)
    @Test
    public void test1(){
        Currency test=new Currency("US Dollar","USD");
        Double output= test.convert(500.0,0.66);
        Double expected= 330.0;
        assertEquals( expected, output);
    }

    @Test
    public void test2(){
        Currency test=new Currency("US Dollar","USD");
        Double output= test.convert(0.0,0.66);
        Double expected= 0.0;
        assertEquals( expected, output);
    }

    @Test
    public void test3(){
        Currency test=new Currency("US Dollar","USD");
        Double output= test.convert(-0.1,0.66);
        String expected= "Error: amount not in specified range";
        assertEquals( expected, output);
    }

    @Test
    public void test4(){
        Currency test=new Currency("US Dollar","USD");
        Double output= test.convert(10000.0,0.66);
        Double expected= 6600.0;
        assertEquals( expected, output);
    }

    @Test
    public void test5(){
        Currency test=new Currency("US Dollar","USD");
        Double output= test.convert(10000.1,0.66);
        String expected= "Error: amount not in specified range";
        assertEquals( expected, output);
    }

    @Test
    public void test6(){
        Currency test=new Currency("US Dollar","USD");
        Double output= test.convert(90000.0,0.66);
        String expected= "Error: amount not in specified range";
        assertEquals( expected, output);
    }


    @Test
    public void test7(){
        Currency test=new Currency("US Dollar","USD");
        Double output= test.convert(-90000.0,0.66);
        String expected= "Error: amount not in specified range";
        assertEquals( expected, output);
    }

    @Test
    public void test8(){
        Currency test=new Currency("Japanese Yen", "JPY");
        Double output= test.convert(500.0,0.051);
        String expected= "Error: currency not in specified range";
        assertEquals( expected, output);
    }

    //tests pour currencyConverter.MainWindow.convert(String, String, ArrayList<Currency>, Double)
    @Test
    public void test9(){
        MainWindow test=new MainWindow();
        ArrayList<Currency> currencies = Currency.init();

        Double output= test.convert("US Dollar","British Pound",currencies,500.0);
        Double expected= 330.0;
        assertEquals( expected, output);
    }

    @Test
    public void test10(){
        MainWindow test=new MainWindow();
        ArrayList<Currency> currencies = Currency.init();

        Double output= test.convert("US Dollar","British Pound",currencies,0.0);
        Double expected= 0.0;
        assertEquals( expected, output);
    }

    @Test
    public void test11(){
        MainWindow test=new MainWindow();
        ArrayList<Currency> currencies = Currency.init();

        Double output= test.convert("US Dollar","British Pound",currencies,10000.0);
        Double expected= 6600.0;
        assertEquals( expected, output);
    }

    @Test
    public void test12(){
        MainWindow test=new MainWindow();
        ArrayList<Currency> currencies = Currency.init();

        Double output= test.convert("US Dollar","British Pound",currencies,-0.1);
        String expected= "Error: amount not in range";
        assertEquals( expected, output);
    }

    @Test
    public void test13(){
        MainWindow test=new MainWindow();
        ArrayList<Currency> currencies = Currency.init();

        Double output= test.convert("US Dollar","British Pound",currencies,10000.1);
        String expected= "Error: amount not in range";
        assertEquals( expected, output);
    }

    @Test
    public void test14(){
        MainWindow test=new MainWindow();
        ArrayList<Currency> currencies = Currency.init();

        Double output= test.convert("US Dollar","British Pound",currencies,90000.0);
        String expected= "Error: amount not in range";
        assertEquals( expected, output);
    }

    @Test
    public void test15(){
        MainWindow test=new MainWindow();
        ArrayList<Currency> currencies = Currency.init();

        Double output= test.convert("US Dollar","British Pound",currencies,-90000.0);
        String expected= "Error: amount not in range";
        assertEquals( expected, output);
    }

    @Test
    public void test16(){
        MainWindow test=new MainWindow();
        ArrayList<Currency> currencies = Currency.init();

        Double output= test.convert("Japanese Yen","Chinese Yuan Renminbi",currencies,500.0);
        String expected= "Error: currency(s) not in range";
        assertEquals( expected, output);
    }


}
