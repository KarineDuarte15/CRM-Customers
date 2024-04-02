package CrmCustomes;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JFormattedTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class Menuicial {

	private JFrame frmCrmCustomers;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menuicial window = new Menuicial();
					window.frmCrmCustomers.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * 
	 * Create the application.
	 */
	public Menuicial() {
		initialize();
	}
	public void iniciar() {
		Menuicial window = new Menuicial();
		window.frmCrmCustomers.setVisible(true);
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmCrmCustomers = new JFrame();
		frmCrmCustomers.setTitle("CRM Customers");
		frmCrmCustomers.setBackground(new Color(0, 102, 255));
		frmCrmCustomers.getContentPane().setBackground(new Color(255, 255, 255));
		frmCrmCustomers.setBounds(100, 100, 355, 350);
		frmCrmCustomers.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCrmCustomers.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("CRM Customers");
		lblNewLabel.setForeground(new Color(51, 102, 255));
		lblNewLabel.setBackground(new Color(51, 102, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(94, 44, 139, 18);
		frmCrmCustomers.getContentPane().add(lblNewLabel);
		
		JButton btnvendedor = new JButton("Cadastrar Vendedor");
		btnvendedor.setForeground(new Color(255, 255, 255));
		btnvendedor.setBackground(new Color(51, 102, 255));
		btnvendedor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			 Vendedor vende = new Vendedor();
			 Menuicial window = new Menuicial();
			 vende.iniciar();
			 frmCrmCustomers.dispose();
			}
		});
		btnvendedor.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnvendedor.setBounds(85, 85, 166, 29);
		frmCrmCustomers.getContentPane().add(btnvendedor);
		
		JButton btncliente = new JButton("Cadastrar Cliente");
		btncliente.setBackground(new Color(51, 102, 255));
		btncliente.setForeground(new Color(255, 255, 255));
		btncliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Cliente cli = new Cliente();
				 Menuicial window = new Menuicial();
				 cli.iniciar();
				 frmCrmCustomers.dispose();
			}
		});
		btncliente.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btncliente.setBounds(85, 135, 166, 29);
		frmCrmCustomers.getContentPane().add(btncliente);
		
		JButton btnproduto = new JButton("Cadastrar Produto");
		btnproduto.setBackground(new Color(51, 102, 255));
		btnproduto.setForeground(new Color(255, 255, 255));
		btnproduto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Produto pro = new Produto();
				 Menuicial window = new Menuicial();
				 pro.iniciar();
				 frmCrmCustomers.dispose();
			}
		});
		btnproduto.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnproduto.setBounds(85, 187, 166, 29);
		frmCrmCustomers.getContentPane().add(btnproduto);
	}
}
