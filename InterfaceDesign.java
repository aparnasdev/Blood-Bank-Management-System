package bb_management;

import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.swing.*;

public class InterfaceDesign extends JFrame implements ActionListener{
	JButton donorBtn, hospitalBtn, patientBtn, bbmanagerBtn, ordersBtn, storesBtn;
	Color c1 = new Color(230, 51, 51);
	Color c2 = new Color(77, 0, 0);
	Color c3 = new Color(255, 255, 255);
	ImageIcon img = new ImageIcon("C:\\Users\\AMMA\\Downloads//image.jpg");
	InterfaceDesign() throws Exception{
		setTitle("BBMS");
		getContentPane().setBackground(c1);
		getContentPane().setForeground(Color.white);
		JLabel Background=new JLabel("",img,JLabel.CENTER);
		Background.setBounds(0, 350, 600, 300);
		getContentPane().add(Background);
		getContentPane().setLayout(null);

		JLabel label = new JLabel("Blood Bank Management System");
		label.setFont(new Font("SANS_SERIF", Font.BOLD, 22));
		label.setForeground(Color.white);
		label.setBounds(118, 0, 380, 40);
		getContentPane().add(label);
		setBounds(100, 100, 600, 700);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		donorBtn = new JButton("Donor Details");
		hospitalBtn = new JButton("Hospital");
		patientBtn = new JButton("Patient");
		bbmanagerBtn = new JButton("BloodBank Manager");
		ordersBtn = new JButton("Orders");
		storesBtn = new JButton("Stores");
		donorBtn.setFont(new Font("SANS_SERIF", Font.BOLD, 16));
		patientBtn.setFont(new Font("SANS_SERIF", Font.BOLD, 16));
		hospitalBtn.setFont(new Font("SANS_SERIF", Font.BOLD, 16));
		patientBtn.setFont(new Font("SANS_SERIF", Font.BOLD, 16));
		bbmanagerBtn.setFont(new Font("SANS_SERIF", Font.BOLD, 16));
		ordersBtn.setFont(new Font("SANS_SERIF", Font.BOLD, 16));
		storesBtn.setFont(new Font("SANS_SERIF", Font.BOLD, 16));
		donorBtn.setBackground(c3);
	    donorBtn.setForeground(c2);
	    hospitalBtn.setBackground(c3);
	    hospitalBtn.setForeground(c2);
	    patientBtn.setBackground(c3);
	    patientBtn.setForeground(c2);
	    ordersBtn.setBackground(c3);
	    ordersBtn.setForeground(c2);
	    bbmanagerBtn.setBackground(c3);
	    bbmanagerBtn.setForeground(c2);
	    storesBtn.setBackground(c3);
	    storesBtn.setForeground(c2);
		donorBtn.addActionListener(this);
		hospitalBtn.addActionListener(this);
		patientBtn.addActionListener(this);
		bbmanagerBtn.addActionListener(this);
		ordersBtn.addActionListener(this);
		storesBtn.addActionListener(this);
		donorBtn.setBounds(15, 70, 260, 60);
		hospitalBtn.setBounds(15, 160, 260, 60);
		patientBtn.setBounds(15, 250, 260, 60);
		bbmanagerBtn.setBounds(310, 70, 260, 60);
		ordersBtn.setBounds(310, 160, 260, 60);
		storesBtn.setBounds(310, 250, 260, 60);
		add(donorBtn, BorderLayout.WEST);
		add(hospitalBtn, BorderLayout.WEST);
		add(patientBtn, BorderLayout.WEST);
		add(bbmanagerBtn, BorderLayout.EAST);
		add(ordersBtn, BorderLayout.EAST);
		add(storesBtn, BorderLayout.EAST);
		setVisible(true);
	}
	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == donorBtn) {
			 try {
				new DonorDesign();
			} catch (Exception e) {
				e.printStackTrace();
			}
	         repaint();
	      } 
		else if (ae.getSource() == hospitalBtn) {
			new HospitalDesign();
	         repaint();
	      } 
		else if (ae.getSource() == patientBtn) {
			new PatientDesign();
	         repaint();
	      }
		else if (ae.getSource() == bbmanagerBtn) {
			new BBmanagerDesign();
	         repaint();
	      }
		else if (ae.getSource() == ordersBtn) {
			new OrdersDesign();
	         repaint();
	      } 
		else if (ae.getSource() == storesBtn) {
			new StoresDesign();
	         repaint();
	      }
	}
}
