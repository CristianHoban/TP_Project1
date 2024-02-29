package model;

import model.*;
import view.*;

import java.util.Map;

public class Operations {
	CalculatorView calcView;

	public Operations() {

	}
	
	
	public int highestPower(Polynomial p) {
		int result = 0;
		for (Map.Entry<Integer, Monomial> entry : p.getPolynomial().entrySet()) {
			if(entry.getKey() > result && entry.getValue().getCoeff() != 0)
				result = entry.getKey();
		}
		return result;
	}


	public Polynomial addition(Polynomial p1, Polynomial p2) {
		Polynomial result = new Polynomial();
		result = p2;
		for (Map.Entry<Integer, Monomial> entry1 : p1.getPolynomial().entrySet()) {
			boolean ok = false;
			for (Map.Entry<Integer, Monomial> entry2 : p2.getPolynomial().entrySet()) {
				if (entry1.getKey() == entry2.getKey() && ok == false) {
					double c = entry1.getValue().getCoeff() + entry2.getValue().getCoeff();
					int p = entry1.getKey();
					Monomial m = new Monomial(c, p);
					result.getPolynomial().put(entry1.getKey(), m);
					ok = true;
				}
			}
			if (!ok) {
				double c = entry1.getValue().getCoeff();
				int p = entry1.getKey();
				Monomial m = new Monomial(c, p);
				result.getPolynomial().put(entry1.getKey(), m);
			}
		}
		return result;
	}

	public Polynomial subtraction(Polynomial p1, Polynomial p2) {
		Polynomial result = new Polynomial();
		result = p1;
		for (Map.Entry<Integer, Monomial> entry1 : p1.getPolynomial().entrySet()) {
			boolean ok = false;
			for (Map.Entry<Integer, Monomial> entry2 : p2.getPolynomial().entrySet()) {
				if (entry1.getKey() == entry2.getKey() && ok == false) {
					double c = entry1.getValue().getCoeff() - entry2.getValue().getCoeff();
					int p = entry1.getKey();
					Monomial m = new Monomial(c, p);
					result.getPolynomial().put(entry1.getKey(), m);
					ok = true;
				}
			}
		}
		for (Map.Entry<Integer, Monomial> entry1 : p2.getPolynomial().entrySet()) {
			boolean ok = false;
			for (Map.Entry<Integer, Monomial> entry2 : p1.getPolynomial().entrySet()) {
				if (entry1.getKey() == entry2.getKey() && ok == false)
					ok = true;
			}
			if (!ok) {
				double c = -entry1.getValue().getCoeff();
				int p = entry1.getKey();
				Monomial m = new Monomial(c, p);
				result.getPolynomial().put(entry1.getKey(), m);
			}
		}
			
		return result;
	}

	public Polynomial derivation(Polynomial p) {
		Polynomial result = new Polynomial();
		for (Map.Entry<Integer, Monomial> entry : p.getPolynomial().entrySet()) {
			double co = entry.getValue().getCoeff() * entry.getKey();
			int pow = entry.getKey()-1;
			if(pow >=0) {
			Monomial m = new Monomial(co, pow);
			result.getPolynomial().put(entry.getKey(), m);
			}
			
		}
		return result;
	}
	public Polynomial integration(Polynomial p) {
		Polynomial result = new Polynomial();
		for (Map.Entry<Integer, Monomial> entry : p.getPolynomial().entrySet()) {
			double co = entry.getValue().getCoeff() /(entry.getKey()+1);
			int pow = entry.getKey()+1;
			Monomial m = new Monomial(co, pow);
			result.getPolynomial().put(entry.getKey(), m);
			
			
		}
		return result;
	}
	
	public Polynomial multiplication(Polynomial p1, Polynomial p2) {
		Polynomial result = new Polynomial();
		for (Map.Entry<Integer, Monomial> entry1 : p1.getPolynomial().entrySet()) {
			for (Map.Entry<Integer, Monomial> entry2 : p2.getPolynomial().entrySet()) {
				int pow = entry1.getValue().getPower() + entry2.getValue().getPower();
				double co = entry1.getValue().getCoeff() * entry2.getValue().getCoeff();
				Monomial m = new Monomial(co, pow);
				if(result.getPolynomial().get(m.getPower()) == null ) {
					result.getPolynomial().put(m.getPower(), m);
				}
				else {
					co = co + (result.getPolynomial().get(m.getPower()).getCoeff());
					m.setCoeff(co);
					result.getPolynomial().put(m.getPower(), m);
				}
			}
		}
		return result;
	}
	
	public Polynomial[] division(Polynomial p1, Polynomial p2) {
		Polynomial[] result = new Polynomial[2];
		Polynomial quotient = new Polynomial();
		Polynomial remainder = new Polynomial();
		int hP1 = highestPower(p1);
		int hP2 = highestPower(p2);
		while(hP1 >= hP2) {
			double coeff = p1.getPolynomial().get(hP1).getCoeff() / p2.getPolynomial().get(hP2).getCoeff();
			int power = p1.getPolynomial().get(hP1).getPower() - p2.getPolynomial().get(hP2).getPower();
			
			Monomial m = new Monomial(coeff, power);
			Polynomial aux = new Polynomial();
			aux.getPolynomial().put(power, m);
			quotient.getPolynomial().put(power, m);
			//System.out.println(multiplication(p2, aux));
			p1 = subtraction(p1, multiplication(p2, aux));
			//System.out.println(p1);
			hP1 = highestPower(p1);
			aux.getPolynomial().clear();
		}
		remainder = p1;
		result[0] = quotient;
		result[1] = remainder;
		
		
		return result;
	}
	

}
