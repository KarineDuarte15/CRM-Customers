package CrmCustomes;

import java.awt.EventQueue;
import java.text.ParseException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.text.MaskFormatter;
import javax.swing.JFormattedTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;

public class Cliente {
	Conexao2 conex2 = new Conexao2();

	private JFrame frmCrmCustomers;
	private JFormattedTextField txtcpfcliente;
	private JFormattedTextField txtnomecliente;
	private JFormattedTextField txttelefone;
	//private JFormattedTextField txtvenderesponsavel;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Cliente window = new Cliente();
					window.frmCrmCustomers.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Cliente() {
		initialize();
	}
	public void iniciar() {
		Cliente window = new Cliente();
		window.frmCrmCustomers.setVisible(true);
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmCrmCustomers = new JFrame();
		frmCrmCustomers.setTitle("CRM Customers");
		frmCrmCustomers.getContentPane().setBackground(new Color(255, 255, 255));
		frmCrmCustomers.setBounds(100, 100, 452, 406);
		frmCrmCustomers.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		MaskFormatter mask,mask2,mask3,mask4;
		try {
			mask = new MaskFormatter("###.###.###-##");
			txtcpfcliente = new JFormattedTextField(mask);
			txtcpfcliente.setBounds(199, 74, 117, 20);
			mask2 = new MaskFormatter("(##)#####-####");
			txttelefone = new JFormattedTextField(mask2);
			txttelefone.setBounds(199, 109, 117, 20);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		frmCrmCustomers.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Cadastro de cliente");
		lblNewLabel.setBounds(129, 11, 153, 14);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		frmCrmCustomers.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nome cliente");
		lblNewLabel_1.setBounds(76, 46, 91, 17);
		frmCrmCustomers.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("CPF cliente");
		lblNewLabel_2.setBounds(76, 77, 79, 14);
		frmCrmCustomers.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Telefone");
		lblNewLabel_3.setBounds(76, 112, 59, 14);
		frmCrmCustomers.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Vendedor id");
		lblNewLabel_4.setBounds(76, 143, 117, 14);
		frmCrmCustomers.getContentPane().add(lblNewLabel_4);
		
		JFormattedTextField txtnomecliente = new JFormattedTextField();
		txtnomecliente.setBounds(199, 44, 117, 20);
		frmCrmCustomers.getContentPane().add(txtnomecliente);
		frmCrmCustomers.getContentPane().add(txtcpfcliente);
		frmCrmCustomers.getContentPane().add(txttelefone);
		
		JFormattedTextField txtvenderesponsavel = new JFormattedTextField();
		txtvenderesponsavel.setBounds(199, 140, 117, 20);
		frmCrmCustomers.getContentPane().add(txtvenderesponsavel);
		
		JButton btnNewButton = new JButton("Cadastrar");
		btnNewButton.setBounds(113, 170, 158, 23);
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(51, 102, 255));
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				validaCPF valcpf = new validaCPF();
				String txtNome= txtnomecliente.getText();
				String txtCPF=txtcpfcliente.getText();
				String txtTelefone= txttelefone.getText();
				String txtVendresponsavel= txtvenderesponsavel.getText();
				String cpfsempontos = txtCPF.replaceAll("[^0-9]", "");
				conex2.conectar();
				if(txtNome.matches("[A-Za-z ]+")){
					if(txtVendresponsavel.matches("[0-9]+")){
						if(valcpf.isCPF(cpfsempontos)) {
				//if (txtNome.matches("[A-Za-z ]+")) {
					conex2.inserircliente(txtNome, txtCPF, txtTelefone, txtVendresponsavel);
					
						}else {
							JOptionPane.showMessageDialog(null, "CPF inválido, digite um cpf correto","Aviso",JOptionPane.INFORMATION_MESSAGE);
						}
				}else {
					JOptionPane.showMessageDialog(null, "Digite somente números","Aviso",JOptionPane.INFORMATION_MESSAGE);
				}	
				}else {
					JOptionPane.showMessageDialog(null, "Nome inválido, digite somente letras","Aviso",JOptionPane.INFORMATION_MESSAGE);
				}
			//	}else {
				//	JOptionPane.showMessageDialog(null, "Dado inválido","Aviso",JOptionPane.INFORMATION_MESSAGE);
				//}
			}
		});
		frmCrmCustomers.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Voltar ao Menu Inicial");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Menuicial menu = new Menuicial();
				menu.iniciar();
				frmCrmCustomers.dispose();
			}
		});
		btnNewButton_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1.setBackground(new Color(51, 102, 255));
		btnNewButton_1.setBounds(113, 272, 158, 23);
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		frmCrmCustomers.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Listar Clientes");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				conex2.conectar();
				conex2.listarcliente();
			}
		});
		btnNewButton_2.setBounds(113, 204, 158, 23);
		btnNewButton_2.setBackground(new Color(51, 102, 255));
		btnNewButton_2.setForeground(new Color(255, 255, 255));
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		frmCrmCustomers.getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_2_1 = new JButton("Apagar Cliente");
		btnNewButton_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id =JOptionPane.showInputDialog(null,"Digite o id do cliente ");
				System.out.println(id);
				Conexao2 conex2 = new Conexao2();
				conex2.conectar();
				conex2.apagarcliente(id);
				String mensagemfinal="Cliente apagado com sucesso";
				String aparecer =String.format("id:%s\n ", mensagemfinal);
				//JOptionPane.showConfirmDialog(null, btnApagarcliente,
				   //aparecer,JOptionPane.QUESTION_MESSAGE,JOptionPane.DEFAULT_OPTION);
			}
		});
		btnNewButton_2_1.setBackground(new Color(51, 102, 255));
		btnNewButton_2_1.setForeground(new Color(255, 255, 255));
		btnNewButton_2_1.setBounds(113, 238, 158, 23);
		btnNewButton_2_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		frmCrmCustomers.getContentPane().add(btnNewButton_2_1);
	}

}

