package model;

import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;
//regerxr.com
//pattern matcher
public class Polynomial {
	 private Map<Integer, Monomial> polynomial;
	
	public Polynomial() {
		this.setPolynomial(new TreeMap<Integer, Monomial> (Collections.reverseOrder()));
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
