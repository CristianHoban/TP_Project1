package org.example;

import view.*;
import model.*;
import controller.*;

public class Main {

	public static void main(String[] args) {
		
		
		Operations model = new Operations();
		CalculatorView view = new CalculatorView(model);
		CalculatorController controller = new CalculatorController(model, view);

		view.setVisible(true);

//		String s1 = "+4x^3+3x^2";
//		String s2 = "+4x^3+3x^2";
//		Operations o = new Operations();
//		CalculatorController c = new CalculatorController();
//		Polynomial p1 = c.splitString(s1);
//		Polynomial p2 = c.splitString(s2);
//		System.out.println(p1);
//		System.out.println(p2);
//		Polynomial sub = o.subtraction(p1, p2);
//		System.out.println(sub);
//		System.out.println(sub.getPolynomial());
//		Polynomial[] p3 = o.division(p1,p2);
//		System.out.println(p3[0]+ "   " + p3[1]);
//		Operations op = new Operations();
//		  
//		  
//		  Monomial m1 = new Monomial(1, 2); Monomial m2 = new Monomial(4, 1); Monomial
//		  m3 = new Monomial(3, 0); Monomial m9 = new Monomial(-8.98, 5);
//		  
//		  Polynomial p1 = new Polynomial(); p1.getPolynomial().put(2, m1);
//		  p1.getPolynomial().put(1, m2); p1.getPolynomial().put(0, m3);
//		  p1.getPolynomial().put(5, m9);
//		  
//		  String s = "3x^2+1x^1+4x^0"; p1 = op.splitString(s);
//		  
//		  Monomial m5 = new Monomial(4, 1); Monomial m6 = new Monomial(3, 0); Monomial
//		  m7 = new Monomial(3, 9);
//		  
//		  Polynomial p2 = new Polynomial(); p2.getPolynomial().put(1, m5);
//		  p2.getPolynomial().put(0, m6); p2.getPolynomial().put(9, m7);
//		 
//		System.out.println(p1);
//		System.out.println(p2);
//		Polynomial result = new Polynomial();
//		result = op.addition(p1, p2);
//		System.out.println(result);

	}

}
