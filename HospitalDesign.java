package bb_management;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class HospitalDesign extends JFrame implements ActionListener {
	JButton addBtn, editBtn, searchBtn, deleteBtn;
	JLabel desc;
	JTextField n;
	Color c1 = new Color(230, 51, 51);
	Color c2 = new Color(77, 0, 0);
	Color c3 = new Color(255, 255, 255);
	HospitalDesign(){
		setTitle("Hospital");
		getContentPane().setBackground(c1);
		setBackground(Color.CYAN);
		getContentPane().setForeground(Color.WHITE);
		getContentPane().setLayout(null);
		
		JLabel label = new JLabel("Hospital Details Management");
		label.setFont(new Font("SANS_SERIF", Font.BOLD, 22));
		label.setForeground(Color.white);
		label.setBounds(118, 0, 380, 40);
		getContentPane().add(label);
		setBounds(100, 100, 600, 700);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		desc = new JLabel("Hospital Id: ");
		n = new JTextField("H001", 5);
		addBtn = new JButton("Add new Hospital");
		editBtn = new JButton("Edit details of hospital");
		searchBtn = new JButton("Search");
		deleteBtn = new JButton("Delete Hospital");
		addBtn.setFont(new Font("SANS_SERIF", Font.BOLD, 16));
		editBtn.setFont(new Font("SANS_SERIF", Font.BOLD, 16));
		searchBtn.setFont(new Font("SANS_SERIF", Font.BOLD, 16));
		deleteBtn.setFont(new Font("SANS_SERIF", Font.BOLD, 16));
		addBtn.setBackground(c3);
		addBtn.setForeground(c2);
	    editBtn.setBackground(c3);
	    editBtn.setForeground(c2);
	    searchBtn.setBackground(c3);
	    searchBtn.setForeground(c2);
	    deleteBtn.setBackground(c3);
	    deleteBtn.setForeground(c2);
		addBtn.addActionListener(this);
		editBtn.addActionListener(this);
		searchBtn.addActionListener(this);
		deleteBtn.addActionListener(this);
		addBtn.setBounds(15, 70, 260, 60);
	    editBtn.setBounds(15, 160, 260, 60);
	    searchBtn.setBounds(310, 160, 260, 60);
		deleteBtn.setBounds(310, 70, 260, 60);
		add(addBtn, BorderLayout.WEST);
		add(editBtn, BorderLayout.WEST);
		add(searchBtn, BorderLayout.EAST);
		add(deleteBtn, BorderLayout.EAST);
		desc.setFont(new Font("SANS_SERIF", Font.BOLD, 16));
		n.setFont(new Font("SANS_SERIF", Font.BOLD, 16));
		desc.setBounds(150, 250, 260, 60);
	    n.setBounds(250, 250, 160, 60);
		add(addBtn);
		add(desc);
		add(n);
		add(editBtn);
		add(searchBtn);
		add(deleteBtn);
		setVisible(true);
	}
	public void actionPerformed(ActionEvent ae) {
		Hospital obj = new Hospital();
		if (ae.getSource() == addBtn) {
			try {
				obj.add();
			} catch (Exception e) {
				e.printStackTrace();
			}
	         repaint();
	      } 
		else if (ae.getSource() == editBtn) {
			try {
				obj.edit(n.getText());
			} catch (Exception e) {
				e.printStackTrace();
			}
	         repaint();
	      } 
		else if (ae.getSource() == searchBtn) {
			try {
				obj.search(n.getText());
			} catch (Exception e) {
				e.printStackTrace();
			}
	         repaint();
	      } 
		else if (ae.getSource() == deleteBtn) {
			try {
				obj.delete(n.getText());
			} catch (Exception e) {
				e.printStackTrace();
			}
		     repaint();
		  } 
	}
}
