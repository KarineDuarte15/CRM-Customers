package CrmCustomes;

import java.awt.EventQueue;
import java.text.ParseException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;
import javax.swing.JFormattedTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;

public class Vendedor {
	Conexao1 conex1 = new Conexao1();
	
	private JFrame frmCrmCustomers;
	private JFormattedTextField txtcpf;
	private JFormattedTextField txtnome;
	private JFormattedTextField txttelefone;
	private JFormattedTextField txtemail;
	private JFormattedTextField txtnascimento;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Vendedor window = new Vendedor();
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
	public Vendedor() {
		initialize();
	}
	public void iniciar() {
		Vendedor window = new Vendedor();
		window.frmCrmCustomers.setVisible(true);
	}
/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		frmCrmCustomers = new JFrame();
		frmCrmCustomers.setTitle("CRM Customers");
		frmCrmCustomers.getContentPane().setBackground(new Color(255, 255, 255));
		frmCrmCustomers.setBounds(100, 100, 480, 436);
		frmCrmCustomers.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCrmCustomers.getContentPane().setLayout(null);
		MaskFormatter mask,mask2,mask3,mask4;
		try {
			mask = new MaskFormatter("###.###.###-##");
			txtcpf = new JFormattedTextField(mask);
			mask2 = new MaskFormatter("(##)#####-####");
			txttelefone = new JFormattedTextField(mask2);
			mask3 = new MaskFormatter("####-##-##");
			txtnascimento = new JFormattedTextField(mask3);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		JLabel lblNewLabel = new JLabel("Nome");
		lblNewLabel.setBounds(126, 65, 46, 14);
		frmCrmCustomers.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("CPF");
		lblNewLabel_1.setBounds(126, 96, 56, 14);
		frmCrmCustomers.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Telefone");
		lblNewLabel_2.setBounds(126, 127, 58, 14);
		frmCrmCustomers.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Email");
		lblNewLabel_3.setBounds(126, 158, 46, 14);
		frmCrmCustomers.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Cadastro de vendedores");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_4.setBounds(115, 31, 190, 14);
		frmCrmCustomers.getContentPane().add(lblNewLabel_4);
		JLabel lblNewLabel_5 = new JLabel("Nascimento");
		lblNewLabel_5.setBounds(126, 192, 88, 14);
		frmCrmCustomers.getContentPane().add(lblNewLabel_5);
		
		JFormattedTextField txtnome = new JFormattedTextField();
		
		txtnome.setBounds(243, 62, 113, 20);
		frmCrmCustomers.getContentPane().add(txtnome);
	
		//JFormattedTextField txtcpf = new JFormattedTextField();
		txtcpf.setBounds(243, 93, 113, 20);
		frmCrmCustomers.getContentPane().add(txtcpf);
		
		//JFormattedTextField txttelefone = new JFormattedTextField();
		txttelefone.setBounds(243, 124, 113, 20);
		frmCrmCustomers.getContentPane().add(txttelefone);
		JFormattedTextField txtemail = new JFormattedTextField();
		
		txtemail.setBounds(243, 155, 113, 20);
		frmCrmCustomers.getContentPane().add(txtemail);
		//JFormattedTextField txtnascimento = new JFormattedTextField();
		
		txtnascimento.setBounds(243, 189, 113, 20);
		frmCrmCustomers.getContentPane().add(txtnascimento);
		
		JButton btnNewButton = new JButton("Cadastrar");
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(51, 102, 255));
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				validaCPF valcpf = new validaCPF();
				
				String txtNome= txtnome.getText();
				String txtEmail= txtemail.getText();
				String txtCPF=txtcpf.getText();
				String txtTelefone= txttelefone.getText();
				String txtNascimento= txtnascimento.getText();
				String cpfsempontos = txtCPF.replaceAll("[^0-9]", "");
				conex1.conectar();
				if(txtEmail.matches("[a-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}")) {
					if(txtNome.matches("[A-Za-z ]+")){
						if(valcpf.isCPF(cpfsempontos)) {
									
					conex1.inserirVendedor(txtEmail, txtNome, txtCPF, txtTelefone, txtNascimento);
					JOptionPane.showMessageDialog(null, "Vendedor inserido com sucesso!","Aviso",JOptionPane.INFORMATION_MESSAGE);
					}else {
						JOptionPane.showMessageDialog(null, "CPF inválido, digite um cpf correto","Aviso",JOptionPane.INFORMATION_MESSAGE);
					}
				}else {
					JOptionPane.showMessageDialog(null, "Nome inválido, digite somente letras","Aviso",JOptionPane.INFORMATION_MESSAGE);
				}
				}else {
					JOptionPane.showMessageDialog(null, "Email inválido","Aviso",JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		btnNewButton.setBounds(136, 217, 158, 23);
		frmCrmCustomers.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Voltar ao Menu Inicial");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Menuicial menu = new Menuicial();
				menu.iniciar();
				frmCrmCustomers.dispose();
			}
		});
		btnNewButton_1.setBackground(new Color(51, 102, 255));
		btnNewButton_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnNewButton_1.setBounds(136, 319, 158, 23);
		frmCrmCustomers.getContentPane().add(btnNewButton_1);
		
		JButton Listar = new JButton("Listar Vendedores");
		Listar.setBackground(new Color(51, 102, 255));
		Listar.setForeground(new Color(255, 255, 255));
		Listar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				conex1.conectar();
				conex1.listarVendedores();
			}
		});
		Listar.setFont(new Font("Tahoma", Font.PLAIN, 13));
		Listar.setBounds(137, 251, 158, 23);
		frmCrmCustomers.getContentPane().add(Listar);
		
		JButton btnApagarVendedor = new JButton("Apagar Vendedor");
		btnApagarVendedor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id =JOptionPane.showInputDialog(null,"Digite o id do Vendedor(a) ");
				System.out.println(id);
				Conexao1 conex = new Conexao1();
				conex.conectar();
				conex.apagarVendedor(id);
				String mensagemfinal="vendedor apagado com sucesso";
				String aparecer =String.format("id:%s\n ", mensagemfinal);
				//JOptionPane.showConfirmDialog(null, btnApagarVendedor,
						//aparecer,JOptionPane.QUESTION_MESSAGE,JOptionPane.DEFAULT_OPTION);
			}
		});
		btnApagarVendedor.setForeground(new Color(255, 255, 255));
		btnApagarVendedor.setBackground(new Color(51, 102, 255));
		btnApagarVendedor.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnApagarVendedor.setBounds(137, 285, 158, 23);
		frmCrmCustomers.getContentPane().add(btnApagarVendedor);
		
		
		
		
		
	}
}
