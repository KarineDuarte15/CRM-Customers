package CrmCustomes;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.swing.JOptionPane;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Conexao1 {
	private Connection connection= null;
	private Statement statement = null;
	private ResultSet resultSet = null;
	public void conectar() {
		 String servidor = "jdbc:mysql://10.0.30.186:3306/CRM_VENDAS?useSSL=false";
		 String usuario = "CRM_VENDAS";
		 String senha = "Aluno123";
		 String driver = "com.mysql.cj.jdbc.Driver";
		 try {
			 Class.forName(driver);
			 this.connection = DriverManager.getConnection(servidor,usuario,senha);
			 this.statement = this.connection.createStatement();
    } catch(Exception e){
		 System.out.println("erro:"+ e.getMessage());}
		 
		 
 }public boolean estaConectado() {
		if(this.connection != null) {
			   return true;
		}else {
		    	return false;
		    }}
		
	public void inserirVendedor(String txtEmail, String txtNome, String txtCPF, String txtTelefone, String txtNascimento) {
		 try { 
			 String query = "insert into vendedor(nome_vendedor,cpf_vendedor,nascimento,telefone,email) values "+
		 "('"+txtNome+"','"+txtCPF+"','"+txtNascimento+"', '"+txtTelefone+"','"+txtEmail+"')";
			 System.out.println(" vendedor inserido com sucesso!");
					 this.statement.executeUpdate(query);
		 }catch(Exception e) {
			System.out.println("Erro:" + e.getMessage()); 
			}
		 }
	
	public void listarVendedores() {
		try {
		String query = "select * from vendedor order by nome_vendedor";
		this.resultSet = this.statement.executeQuery(query);
        StringBuilder resultString = new StringBuilder();
		while(this.resultSet.next()) {
			String id = this.resultSet.getString("id_vendedor");
			String nome = this.resultSet.getString("nome_vendedor");
			String cpf = this.resultSet.getString("cpf_vendedor");
			String nascimento = this.resultSet.getString("nascimento");
			String telefone =this.resultSet.getString("telefone");
			String email = this.resultSet.getString("email");
			resultString.append(id).append(" Nome: ").append(nome).append(" CPF: ").append(cpf).append(" Nascimento: ").append(nascimento).append(" Telefone: ").append(telefone).append(" Email: ").append(email).append("\n");
	    /*System.out.println("ID: "+this.resultSet.getString("id_vendedor")+
	    		"Nome: "+ this.resultSet.getString("nome_vendedor")+
	    		"cpf:"+ this.resultSet.getString("cpf_vendedor")+
	    		"nascimento: "+ this.resultSet.getString("nascimento")+
	    		"telefone: "+ this.resultSet.getString("telefone")+
	    		"email: "+ this.resultSet.getString("email"));*/
	    
		}
		JOptionPane.showMessageDialog(null, resultString.toString(),"Dados",JOptionPane.INFORMATION_MESSAGE);
		}
	catch(Exception e) {
		System.out.println("Erro:" + e.getMessage());
	}
		}
	
	
	public void calcularpercentual(){
		
	}
	
	public void apagarVendedor(String id) {
		 try { 
			 JOptionPane.showConfirmDialog(null, "Você tem certeza?", "Confirmation", JOptionPane.YES_NO_OPTION);
			 String query = "Delete from vendedor where id_vendedor = '"+id+"'; ";
					 this.statement.executeUpdate(query);
					 JOptionPane.showMessageDialog(null, "Vendedor apagado com sucesso!","Aviso",JOptionPane.INFORMATION_MESSAGE);
		 }catch(Exception e) {
			System.out.println("Erro:" + e.getMessage()); 
		 }
		 
		 
	}public void desconectar() {
				try {
					this.connection.close();
				}catch(Exception e) {
					System.out.println("Erro"+ e.getMessage());
				}
	}
	
	
	}