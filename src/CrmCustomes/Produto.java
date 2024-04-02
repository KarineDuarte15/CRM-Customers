package CrmCustomes;

import java.awt.EventQueue;
import java.text.ParseException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.text.MaskFormatter;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;

public class Produto {
	Conexao3 conex3 = new Conexao3();
	String txtnomeproduto2=null;
	String txtdescricao2=null;
	String txtcor2=null;
	String val = null;
	private JFrame frmCrmCustomers;
	private JFormattedTextField txtnomeproduto;
	private JFormattedTextField txtdescricao;
	private JFormattedTextField txtvalor;
	private JFormattedTextField txtcor;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Produto window = new Produto();
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
	public Produto() {
		initialize();
	}
   public void iniciar() {
	   Produto window = new Produto();
		window.frmCrmCustomers.setVisible(true);
   }
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		frmCrmCustomers = new JFrame();
		frmCrmCustomers.setTitle("CRM Customers");
		frmCrmCustomers.getContentPane().setBackground(new Color(255, 255, 255));
		frmCrmCustomers.setBounds(100, 100, 535, 474);
		frmCrmCustomers.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCrmCustomers.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Produtos cadastrados");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(147, 24, 180, 14);
		frmCrmCustomers.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nome do produto");
		lblNewLabel_1.setBounds(125, 65, 101, 14);
		frmCrmCustomers.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Descrição do produto");
		lblNewLabel_2.setBounds(125, 92, 133, 14);
		frmCrmCustomers.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Valor do produto");
		lblNewLabel_3.setBounds(125, 117, 101, 14);
		frmCrmCustomers.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Cor do produto");
		lblNewLabel_4.setBounds(125, 142, 89, 14);
		frmCrmCustomers.getContentPane().add(lblNewLabel_4);
		JFormattedTextField txtvalor = new JFormattedTextField();
		
		txtvalor.setToolTipText("");
		txtvalor.setBounds(287, 114, 132, 20);
		frmCrmCustomers.getContentPane().add(txtvalor);
		
		
		
		JFormattedTextField txtnomeproduto = new JFormattedTextField();
		txtnomeproduto.setBounds(287, 62, 132, 20);
		frmCrmCustomers.getContentPane().add(txtnomeproduto);
		
		JFormattedTextField txtdescricao = new JFormattedTextField();
		txtdescricao.setBounds(286, 89, 133, 20);
		frmCrmCustomers.getContentPane().add(txtdescricao);
		
		JFormattedTextField txtcor = new JFormattedTextField();
		txtcor.setBounds(287, 139, 132, 20);
		frmCrmCustomers.getContentPane().add(txtcor);
		
		JButton btnCadastrarP = new JButton("Cadastrar");
		btnCadastrarP.setForeground(new Color(255, 255, 255));
		btnCadastrarP.setBackground(new Color(51, 102, 255));
		btnCadastrarP.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtdescricao2 = txtdescricao.getText();
				txtcor2 =txtcor.getText();
				txtnomeproduto2 = txtnomeproduto.getText();
				
				try {
					val = txtvalor.getText();
					Long teste = Long.parseLong(val);
					
					}catch(NumberFormatException ex) {
					JOptionPane.showMessageDialog(null,"Valor inválido. Digite somente números","aviso",JOptionPane.INFORMATION_MESSAGE);
					}
				conex3.conectar();
				if(txtnomeproduto2.matches("[A-Za-z0-9 ]+")){
					if(txtdescricao2.matches("[A-Za-z0-9 ]+")){
						if(txtcor2.matches("[A-Za-z ]+")){
							
				//if (txtnomeproduto2.matches("[A-Za-z ]+")&& txtdescricao2.matches("[A-Za-z ]+")&& txtcor2.matches("[A-Za-z ]+")) {
				conex3.inserirproduto(txtnomeproduto2, txtdescricao2, val, txtcor2);
				JOptionPane.showMessageDialog(null, "Produto inserido com sucesso!","Aviso",JOptionPane.INFORMATION_MESSAGE);
				
						
						}
			}else {
				JOptionPane.showMessageDialog(null, "Nome inválido, digite somente letras","Aviso",JOptionPane.INFORMATION_MESSAGE);
			}
			}else {
					JOptionPane.showMessageDialog(null, "Descrição inválido, digite somente letras","Aviso",JOptionPane.INFORMATION_MESSAGE);
				}
			
		//	}else {
			//	JOptionPane.showMessageDialog(null, "Dado inválido","Aviso",JOptionPane.INFORMATION_MESSAGE);
			//}
			}
		}								
				);
		
		btnCadastrarP.setBounds(159, 167, 158, 23);
		frmCrmCustomers.getContentPane().add(btnCadastrarP);
		
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
		btnNewButton_1.setBounds(159, 249, 158, 23);
		frmCrmCustomers.getContentPane().add(btnNewButton_1);
		
		JButton btnListaProduto = new JButton("Lista Produto");
		btnListaProduto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				conex3.conectar();
				conex3.listarproduto_produto();
			}
		});
		btnListaProduto.setBackground(new Color(51, 102, 255));
		btnListaProduto.setForeground(new Color(255, 255, 255));
		btnListaProduto.setBounds(159, 194, 158, 23);
		frmCrmCustomers.getContentPane().add(btnListaProduto);
		
		JButton btnApagarProduto = new JButton("Apagar Produto");
		btnApagarProduto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id =JOptionPane.showInputDialog(null,"Digite o id do produto ");
				System.out.println(id);	
				Conexao3 conex3 = new Conexao3();
				conex3.conectar();
				conex3.apagarproduto_produto(id);
				String mensagemfinal="Produto apagado com sucesso";
				String aparecer =String.format("id:%s\n ", mensagemfinal);
				//JOptionPane.showConfirmDialog(null, btnApagarproduto_produto,
						//aparecer,JOptionPane.QUESTION_MESSAGE,JOptionPane.DEFAULT_OPTION);
			}
		});
		btnApagarProduto.setForeground(new Color(255, 255, 255));
		btnApagarProduto.setBackground(new Color(51, 102, 255));
		btnApagarProduto.setBounds(159, 221, 158, 23);
		frmCrmCustomers.getContentPane().add(btnApagarProduto);
	}
}
