package test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import currencyConverter.Currency;
import currencyConverter.MainWindow;

class TestsBoiteBlanche {
	
	//Tests pour Currency.convert(Double,Double)
	@Test
	void testCritereCouvInstructC1() {
		Double a=50.0;
		Double ev=0.5;
		assertEquals(50*0.5,Currency.convert(a, ev));
	}
	
	@Test
	void testCritereCouvInstructC2() {
		Double a=-50.0;
		Double ev=0.5;
		assertEquals(-50*0.5,Currency.convert(a, ev));
	}
	
	@Test
	void testCritereCouvInstructC3() {
		Double a=-50.0;
		Double ev=-0.5;
		assertEquals(-50*-0.5,Currency.convert(a, ev));
	}
	
	//Tests pour MainWindow.convert(String,String,ArrayList<Currency>,Double)
	@Test
	void testCritereCouvInstructMW1() {
		String c1="US Dollar";
		String c2="Euro";
		ArrayList<Currency> cl=new ArrayList<>();
		Double a=50.0;
		//Liste vide
		assertEquals(0.0,MainWindow.convert(c1, c2, cl, a));
	}
	
	@Test
	void testCritereCouvInstructMW2() {
		String c1="US Dollar";
		String c2="Euro";
		ArrayList<Currency> cl=new ArrayList<>();
		Currency test=new Currency("Swiss Franc","CHF");
		test.setExchangeValues("USD", 0.99);
		test.setExchangeValues("EUR", 0.93);
		test.setExchangeValues("GBP", 0.66);
		test.setExchangeValues("CHF", 1.00);
		test.setExchangeValues("CNY", 6.33);
		test.setExchangeValues("JPY", 122.84);
		cl.add(test);
		Double a=50.0;
		//Liste à 1 element mais 0 currency en commun
		assertEquals(0.0,MainWindow.convert(c1, c2, cl, a));
	}
	
	@Test
	void testCritereCouvInstructMW3() {
		String c1="US Dollar";
		String c2="Euro";
		ArrayList<Currency> cl=new ArrayList<>();
		Currency test=new Currency("Euro","EUR");
		test.setExchangeValues("USD", 1.073);
		test.setExchangeValues("EUR", 1.00);
		test.setExchangeValues("GBP", 0.71);
		test.setExchangeValues("CHF", 1.08);
		test.setExchangeValues("CNY", 6.83);
		test.setExchangeValues("JPY", 132.57);
		cl.add(test);
		Double a=50.0;
		//Liste avec c2 mais pas c1
		assertEquals(0.0,MainWindow.convert(c1, c2, cl, a));
	}
	
	@Test
	void testCritereCouvInstructMW4() {
		String c1="US Dollar";
		String c2="Euro";
		ArrayList<Currency> clist= Currency.init();
		Double a=50.0;
		Double expectedPrice=Math.round((a*0.93) * 100d) / 100d;
		//Liste avec c1 et c2
		assertEquals(expectedPrice,MainWindow.convert(c1, c2, clist, a));
	}
	
	@Test
	void testCritereCouvArcsGFCMW1() {
		String c1="US Dollar";
		String c2="Euro";
		Double a=50.0;
		ArrayList<Currency> cl=new ArrayList<>();
		Currency test1=new Currency("Swiss Franc","CHF");
		test1.setExchangeValues("USD", 0.99);
		test1.setExchangeValues("EUR", 0.93);
		test1.setExchangeValues("GBP", 0.66);
		test1.setExchangeValues("CHF", 1.00);
		test1.setExchangeValues("CNY", 6.33);
		test1.setExchangeValues("JPY", 122.84);
		Currency test2=new Currency("Japanese Yen","JPY");
		test2.setExchangeValues("USD", 0.008);
		test2.setExchangeValues("EUR", 0.007);
		test2.setExchangeValues("GBP", 0.005);
		test2.setExchangeValues("CHF", 0.008);
		test2.setExchangeValues("CNY", 0.051);
		test2.setExchangeValues("JPY", 1.000);
		cl.add(test1);
		cl.add(test2);
		assertEquals(0.0,MainWindow.convert(c1, c2, cl, a));
	}

}
