package view;

import model.*;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class CalculatorView extends JFrame{
	private JTextField inputPolynomial1 = new JTextField(30);
	private JTextField inputPolynomial2 = new JTextField(30);
	private JTextField resultPolynomial = new JTextField(30);
	private JButton multiplicationBtn = new JButton("Multiply");
	private JButton subtractionBtn = new JButton("Subtraction");
	private JButton additionBtn = new JButton("Addition");
	private JButton derivationBtn = new JButton("Derivation");
	private JButton integrationBtn = new JButton("Integration");
	private JButton divisionBtn = new JButton("Division");
	private JLabel p1 = new JLabel("Polynomial 1:");
	private JLabel p2 = new JLabel("Polynomial 2:");
	private JLabel r = new JLabel("Result:");
	private JLabel format = new JLabel("*Polynomial format: +ax^3-bx^2+cx^1+dx^0");
	
	
	private Operations operations;
	
	public CalculatorView(Operations op){
		operations = op;
		resultPolynomial.setEditable(false);
		
		JPanel content = new JPanel();
		content.setLayout(new BoxLayout(content, BoxLayout.Y_AXIS));
		
		
		JPanel operations = new JPanel(new GridLayout(3, 2));
		operations.add(additionBtn);
		operations.add(subtractionBtn);
		operations.add(multiplicationBtn);
		operations.add(divisionBtn);
		operations.add(derivationBtn);
		operations.add(integrationBtn);
		
		JPanel textsContent = new JPanel();
		textsContent.setLayout(new BoxLayout(textsContent, BoxLayout.Y_AXIS));
		textsContent.add(p1);
		textsContent.add(Box.createRigidArea(new Dimension(0, 5)));
		textsContent.add(p2);
		textsContent.add(Box.createRigidArea(new Dimension(0, 5)));
		textsContent.add(r);
		
		JPanel tFieldContent = new JPanel();
		tFieldContent.setLayout(new BoxLayout(tFieldContent, BoxLayout.Y_AXIS));
		tFieldContent.add(inputPolynomial1);
		tFieldContent.add(inputPolynomial2);
		tFieldContent.add(resultPolynomial);
		
		JPanel firstContent = new JPanel(new GridLayout(3,2));
		firstContent.setLayout(new FlowLayout());
		
		firstContent.add(textsContent);
		firstContent.add(tFieldContent);
		
		content.add(firstContent);
		content.add(format);
		content.add(Box.createRigidArea(new Dimension(0, 5)));
		content.add(operations);
		
		
		this.setTitle("Calculator");
		
		this.setContentPane(content);
		this.pack();
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public String getInput1() {
		return inputPolynomial1.getText();
	}
	public String getInput2() {
		return inputPolynomial2.getText();
	}
	
	public void setResult(String result) {
		resultPolynomial.setText(result);
	}
	
	public void addAdditionListener(ActionListener mal) {
		additionBtn.addActionListener(mal);
	}
	public void addSubtractionListener(ActionListener mal) {
		subtractionBtn.addActionListener(mal);
	}
	public void addDerivationListener(ActionListener mal) {
		derivationBtn.addActionListener(mal);
	}
	public void addIntegrationListener(ActionListener mal) {
		integrationBtn.addActionListener(mal);
	}
	public void addMultiplicationListener(ActionListener mal) {
		multiplicationBtn.addActionListener(mal);
	}
	public void addDivisionListener(ActionListener mal) {
		divisionBtn.addActionListener(mal);
	}
	public void showError(String errorMessage) {
		JOptionPane.showMessageDialog(this, errorMessage);
	}

}
