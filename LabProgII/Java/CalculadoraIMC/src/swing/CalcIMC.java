package swing;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class CalcIMC extends JFrame{
	public CalcIMC() {		
		setTitle("Calculadora IMC");
		setSize(250,250);
		setLayout(null);
		
		JLabel altLabel = new JLabel();
		altLabel.setText("Altura (m)");
		altLabel.setBounds(20,20,80,30);
		add(altLabel);
		
		JTextField altField = new JTextField(5);
		altField.setBounds(120,20,100,30);
		add(altField);
		
		JLabel pesLabel = new JLabel();
		pesLabel.setText("Peso (kg)");
		pesLabel.setBounds(20,60,100,30);
		add(pesLabel);
		
		JTextField pesField = new JTextField(5);
		pesField.setBounds(120,60,100,30);
		add(pesField);
		
		JLabel imcLabel = new JLabel();
		imcLabel.setText("IMC");
		imcLabel.setBounds(20,100,100,30);
		add(imcLabel);
				
		JTextField imcField = new JTextField(5);
		imcField.setBounds(120,100,100,30);
		add(imcField);
		
		JButton bt = new JButton("Calcular");
		bt.setBounds(20,140,100,30);
		bt.addActionListener(new ActionListener() {
			//@Override
			public void actionPerformed(ActionEvent ev) {
				float altura = Float.parseFloat(altField.getText());
				float peso = Float.parseFloat(pesField.getText());
				float imc = peso/(altura*altura);
				String imcText = Float.toString(imc);
				imcField.setText(imcText);
			}
		});
		add(bt);
		
		JButton btFechar = new JButton("Clear");
		btFechar.setBounds(120,140,100,30);
		btFechar.addActionListener(new ActionListener() {
			//@Override
			public void actionPerformed(ActionEvent ev) {
				altField.setText("");
				pesField.setText("");
				imcField.setText("");
			}
		});
		add(btFechar);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
}
