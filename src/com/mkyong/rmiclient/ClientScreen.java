package com.mkyong.rmiclient;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.mkyong.rmiinterface.RMIInterface;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.awt.event.ActionEvent;

public class ClientScreen extends JFrame {

	private JPanel contentPane;
	private static RMIInterface look_up;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) throws MalformedURLException, RemoteException, NotBoundException {	
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClientScreen frame = new ClientScreen();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ClientScreen() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 445, 419);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblSejaBemvindoAo = new JLabel("Welcome to RMI");
		lblSejaBemvindoAo.setBounds(156, 12, 174, 33);
		contentPane.add(lblSejaBemvindoAo);
		
		JButton addButton = new JButton("+");
		addButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				int x = Integer.parseInt(JOptionPane.showInputDialog("Insira o primeiro valor: "));
				int y = Integer.parseInt(JOptionPane.showInputDialog("Insira o segundo valor: "));
				
				try {
					look_up = (RMIInterface) Naming.lookup("//localhost/MyServer");
				} catch (MalformedURLException | RemoteException | NotBoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				try {
					double response = look_up.add(x, y);
					JOptionPane.showMessageDialog(null, x+" + "+y+" = "+response);
				} catch (RemoteException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		addButton.setBounds(12, 50, 174, 87);
		contentPane.add(addButton);
		
		JButton subButton = new JButton("-");
		subButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int x = Integer.parseInt(JOptionPane.showInputDialog("Insira o primeiro valor: "));
				int y = Integer.parseInt(JOptionPane.showInputDialog("Insira o segundo valor: "));
				
				try {
					look_up = (RMIInterface) Naming.lookup("//localhost/MyServer");
				} catch (MalformedURLException | RemoteException | NotBoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				try {
					double response = look_up.sub(x, y);
					JOptionPane.showMessageDialog(null, x+" - "+y+" = "+response);
				} catch (RemoteException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		subButton.setBounds(248, 50, 174, 87);
		contentPane.add(subButton);
		
		JButton mulButton = new JButton("x");
		mulButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int x = Integer.parseInt(JOptionPane.showInputDialog("Insira o primeiro valor: "));
				int y = Integer.parseInt(JOptionPane.showInputDialog("Insira o segundo valor: "));
				
				try {
					look_up = (RMIInterface) Naming.lookup("//localhost/MyServer");
				} catch (MalformedURLException | RemoteException | NotBoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				try {
					double response = look_up.mul(x, y);
					JOptionPane.showMessageDialog(null, x+" * "+y+" = "+response);
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		mulButton.setBounds(135, 149, 174, 87);
		contentPane.add(mulButton);
		
		JButton divButton = new JButton("/");
		divButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int x = Integer.parseInt(JOptionPane.showInputDialog("Insira o primeiro valor: "));
				int y = Integer.parseInt(JOptionPane.showInputDialog("Insira o segundo valor: "));
				
				try {
					look_up = (RMIInterface) Naming.lookup("//localhost/MyServer");
				} catch (MalformedURLException | RemoteException | NotBoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				try {
					double response = look_up.div(x, y);
					JOptionPane.showMessageDialog(null, x+" / "+y+" = "+response);
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		divButton.setBounds(12, 256, 174, 87);
		contentPane.add(divButton);
		
		JButton expButton = new JButton("e²");
		expButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int x = Integer.parseInt(JOptionPane.showInputDialog("Insira o valor base: "));
				int y = Integer.parseInt(JOptionPane.showInputDialog("Insira o valor do expoente: "));
				
				try {
					look_up = (RMIInterface) Naming.lookup("//localhost/MyServer");
				} catch (MalformedURLException | RemoteException | NotBoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				try {
					double response = look_up.exp(x, y);
					JOptionPane.showMessageDialog(null, x+"e"+y+" = "+response);
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		expButton.setBounds(248, 256, 174, 87);
		contentPane.add(expButton);
	}
}
