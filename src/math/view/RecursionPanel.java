package math.view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import math.controller.RecursionController;

public class RecursionPanel extends JPanel
{

	private RecursionController baseController;
	private JButton fibonacciButton;
	private JButton factorialButton;
	private JTextField inputField;
	private JTextArea resultsArea;
	private SpringLayout baseLayout;
	
	public RecursionPanel(RecursionController baseController)
	{
		this.baseController = baseController;
		fibonacciButton = new JButton("Calculate the fibonacci number");
		factorialButton = new JButton("n!");
		baseLayout = new SpringLayout();

		inputField = new JTextField(5);

		resultsArea = new JTextArea(10,15);
	
		setupPanel();
		setupLayout();
		setupListeners();
	}
	
	
	private void setupLayout()
	{
		baseLayout.putConstraint(SpringLayout.NORTH, resultsArea, 52, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.WEST, resultsArea, 133, SpringLayout.WEST, this);
		
		baseLayout.putConstraint(SpringLayout.NORTH, inputField, 16, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.WEST, inputField, 44, SpringLayout.WEST, this);
		
		baseLayout.putConstraint(SpringLayout.NORTH, factorialButton, 43, SpringLayout.SOUTH, fibonacciButton);
		baseLayout.putConstraint(SpringLayout.EAST, factorialButton, 0, SpringLayout.EAST, fibonacciButton);
		baseLayout.putConstraint(SpringLayout.NORTH, fibonacciButton, 10, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.EAST, fibonacciButton, -10, SpringLayout.EAST, this);
		
	}
	
	private void setupPanel()
	{
		this.setLayout(baseLayout);
		this.add(fibonacciButton);
		this.add(factorialButton);
		this.add(inputField);
		this.add(resultsArea);
		resultsArea.setWrapStyleWord(true);
		resultsArea.setLineWrap(true);
		resultsArea.setEditable(false);
		this.setBackground(Color.CYAN);
		
	}
	
	
	private void setupListeners()
	{
		fibonacciButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				String input = inputField.getText();
				if(checkInput(input))
				{
					resultsArea.setText(baseController.doFibonacci(input));
				}
			}
		});
		
		factorialButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				String input = inputField.getText();
				if (checkInput(input))
				{
					resultsArea.append(baseController.doFactorial(input));
				}
			}
		});
		
	}
	
	private boolean checkInput(String input)
	{
		boolean isNumber = false;
		
		try
		{
			Double.parseDouble(input);
			isNumber = true;
		}
		catch(Exception numberException)
		{
			resultsArea.setText("You must type in a number");
		}
		
		return isNumber;
	}
}
