package model;

import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

public class Monomial {
	private double coeff;
	private int power;
	
	public Monomial(double coeficient, int putere) {
		this.coeff = coeficient;
		this.power = putere;
	}
	
	public double getCoeff() {
		return coeff;
	}
	public void setCoeff(double coeff) {
		this.coeff = coeff;
	}
	public int getPower() {
		return power;
	}
	public void setPower(int power) {
		this.power = power;
	}
	
	public String toString() {
		if(coeff == 0)
			return "";
		if(coeff == (int)coeff)
			return ""+ (int)coeff + "x^" + power;
		else
			return ""+ String.format("%.2f",coeff) + "x^" + power;
	}

	//regerxr.com
	//pattern matcher
	public static class Polynomial {
		 private Map<Integer, Monomial> polynomial;

		public Polynomial() {
			this.setPolynomial(new TreeMap<Integer, Monomial>(Collections.reverseOrder()));
		}

		public Map<Integer, Monomial> getPolynomial() {
			return polynomial;
		}

		public void setPolynomial(Map<Integer, Monomial> polynomial) {
			this.polynomial = polynomial;
		}

		public String toString() {
			String result = "";
			for(Map.Entry<Integer, Monomial> entry : this.getPolynomial().entrySet() ) {
				if(entry.getValue().getCoeff()<0)
						result += entry.getValue().toString();
				else if(entry.getValue().getCoeff()>0)
					result += "+" + entry.getValue().toString();

			}
			if(result == "")
				result = "0";
			return result;
		}

	}
}
