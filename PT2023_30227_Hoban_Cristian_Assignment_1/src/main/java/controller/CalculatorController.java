package controller;


import model.*;
import view.*;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CalculatorController {
	private Operations operations;
	private CalculatorView calcView;

	public CalculatorController() {
		
	}
	public CalculatorController(Operations op, CalculatorView view) {
		operations = op;
		calcView = view;
		calcView.addAdditionListener(new AddListener());
		calcView.addSubtractionListener(new SubtractListener());
		calcView.addDerivationListener(new DeriveListener());
		calcView.addIntegrationListener(new IntegrateListener());
		calcView.addMultiplicationListener(new MultiplyListener());
		calcView.addDivisionListener(new DivideListener());
	}

	public Polynomial splitString(String s) {
		Polynomial result = new Polynomial();
		if(s.equals("0")) {
			Monomial mon = new Monomial(0, 0);
			result.getPolynomial().put(0, mon);
			return result;
		}
		Pattern pattern = Pattern.compile("[+-]\\d*x\\^\\d+");
		Matcher matcher = pattern.matcher(s);
		String verify = "";
		while (matcher.find()) {
			String m = matcher.group();
			String[] v = m.split("x\\^");
			double coeff = Double.parseDouble(v[0]);
			int power = Integer.parseInt(v[1]);
			Monomial mon = new Monomial(coeff, power);
			if (mon.getCoeff() < 0)
				verify += mon.toString();
			else if (mon.getCoeff() >= 0)
				verify += "+" + mon.toString();

			if(result.getPolynomial().get(mon.getPower()) == null ) {
				result.getPolynomial().put(mon.getPower(), mon);
			}
			else {
				coeff = coeff + (result.getPolynomial().get(mon.getPower()).getCoeff());
				mon.setCoeff(coeff);
				result.getPolynomial().put(mon.getPower(), mon);
			}
		}
		if (result.toString().equals("0"))
			verify = "0";
		try {
			if (!s.equals(verify)) {
				throw new InvalidInputException();
			} else {
				return result;
			}
		} catch (InvalidInputException ex) {
			calcView.showError("At least one of the polynomials is invalid");
		}
		return null;
	}

	class AddListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String userInput1 = "";
			String userInput2 = "";
			Polynomial p = new Polynomial();
			Polynomial p1 = new Polynomial();
			Polynomial p2 = new Polynomial();
			userInput1 = calcView.getInput1();
			userInput2 = calcView.getInput2();
			p1 = splitString(userInput1);
			p2 = splitString(userInput2);
			if (p1 != null && p2 != null) {
				p = operations.addition(p1, p2);
				calcView.setResult(p.toString());
			}
		}
	}

	class SubtractListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String userInput1 = "";
			String userInput2 = "";
			Polynomial p = new Polynomial();
			userInput1 = calcView.getInput1();
			userInput2 = calcView.getInput2();
			Polynomial p1 = new Polynomial();
			Polynomial p2 = new Polynomial();
			p1 = splitString(userInput1);
			p2 = splitString(userInput2);
			if (p1 != null && p2 != null) {
				p = operations.subtraction(p1, p2);
				calcView.setResult(p.toString());
			}

		}
	}

	class DeriveListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String userInput = "";
			Polynomial pol = new Polynomial();
			userInput = calcView.getInput1();
			Polynomial p = new Polynomial();
			p = splitString(userInput);
			if (p != null) {
				pol = operations.derivation(p);
				calcView.setResult(pol.toString());
			}
		}
	}

	class IntegrateListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String userInput = "";
			Polynomial pol = new Polynomial();
			userInput = calcView.getInput1();
			Polynomial p = new Polynomial();
			p = splitString(userInput);
			if (p != null) {
				pol = operations.integration(p);
				calcView.setResult(pol.toString()+"+C");
			}
		}
	}

	class MultiplyListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String userInput1 = "";
			String userInput2 = "";
			Polynomial p = new Polynomial();
			userInput1 = calcView.getInput1();
			userInput2 = calcView.getInput2();
			Polynomial p1 = new Polynomial();
			Polynomial p2 = new Polynomial();
			p1 = splitString(userInput1);
			p2 = splitString(userInput2);
			if (p1 != null && p2 != null) {
				p = operations.multiplication(p1, p2);
				calcView.setResult(p.toString());
			}

		}
	}
	
	class DivideListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String userInput1 = "";
			String userInput2 = "";
			Polynomial[] p = new Polynomial[2];
			userInput1 = calcView.getInput1();
			userInput2 = calcView.getInput2();
			Polynomial p1 = new Polynomial();
			Polynomial p2 = new Polynomial();
			if(userInput2.equals("0")) {
				calcView.showError("You cannot divide by 0!");
			}
			else {
			p1 = splitString(userInput1);
			p2 = splitString(userInput2);
			if (p1 != null && p2 != null) {
				p = operations.division(p1, p2);
				String s = "Q: " + p[0] + "; R: " + p[1];
				calcView.setResult(s);
			}
			}

		}
	}
	
}
