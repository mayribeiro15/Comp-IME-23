package interfacegrafica;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class BMICalculator extends JFrame {
	BMICalculator() {
		JFrame frame = new JFrame();
		frame.setTitle("BMI CALCULATOR");
		frame.getContentPane().setBackground(Color.CYAN);
		
		JLabel title = new JLabel("BMI Calculator");
	    title.setBounds(150,0,100,10);
		frame.add(title);
		
		JLabel heightLabel = new JLabel("Height in m: ");
		heightLabel.setBounds(20,20,100,40);
		frame.add(heightLabel);
		
		JLabel weightLabel = new JLabel("Weight in kg");
		weightLabel.setBounds(20,60,100,40);
		frame.add(weightLabel);
		
		JLabel bmiLabel = new JLabel("BMI Value: ");
		bmiLabel.setBounds(20,90,300,40);
		frame.add(bmiLabel);
		
		JTextField heightText = new JTextField("");
		heightText.setBounds(120, 20, 200, 40);
		frame.add(heightText);
		
		JTextField weightText = new JTextField("");
		weightText.setBounds(120, 60, 200, 40);
		frame.add(weightText);
		
		JTextField bmiText = new JTextField("");
		bmiText.setBounds(120,100,200,40);
		frame.add(bmiText);
		
		JButton calculateButton = new JButton("Calculate BMI: ");
		calculateButton.setBounds(20, 150, 150, 40);
		
		JButton cleanButton = new JButton("Clean: ");
		cleanButton.setBounds(180, 150, 150, 40);
		
		calculateButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ae) {
				double weight = Double.parseDouble(weightText.getText());
				double height = Double.parseDouble(heightText.getText());
				double bmi = weight / Math.pow(height, 2);
				
				if(bmi < 18.5) {
					bmiText.setText("Thin - BMI: " + bmi);
				} else if (bmi < 24.9) {
					bmiText.setText("Healthy - BMI: " + bmi);
				} else if (bmi < 29.9) {
					bmiText.setText("Overweight - BMI: " + bmi);
				} else {
					bmiText.setText("Obese - BMI: " + bmi);
				}
			}
		});
		
		cleanButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ae) {
				heightText.setText("");
				weightText.setText("");
				bmiText.setText("");
			}
		});
		
		frame.add(calculateButton);
		frame.add(cleanButton);
		
		frame.setSize(400,300);
		frame.setLayout(null);
		frame.setVisible(true);
	}
	
	public static void main(String[] args) {
		new BMICalculator();
	}
}