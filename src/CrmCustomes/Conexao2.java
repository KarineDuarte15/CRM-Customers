package CrmCustomes;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.swing.JOptionPane;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Conexao2 {
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


public void inserircliente(String txtNome,String txtCPF,String txtTelefone,String txtVendresponsavel) {
	 try { 
		 String query = "insert into cliente(nome_cliente,cpf_cliente,telefone,vendedorid) values ('"+txtNome+"','"+txtCPF+"', '"+txtTelefone+"','"+txtVendresponsavel+"')";
		 
				 this.statement.executeUpdate(query);
				 JOptionPane.showMessageDialog(null, "Cliente inserido com sucesso!","Aviso",JOptionPane.INFORMATION_MESSAGE);
	 }catch(Exception e) {
		System.out.println("Erro:" + e.getMessage()); 
		 JOptionPane.showMessageDialog(null, "Vendedor não existe","Aviso",JOptionPane.INFORMATION_MESSAGE);
		}
	 }

public void listarcliente() {
	try {
	String query = "select * from cliente order by nome_cliente";
	this.resultSet = this.statement.executeQuery(query);
	StringBuilder resultString = new StringBuilder();
	while(this.resultSet.next()) {
		String id = this.resultSet.getString("id_cliente");
		String nome = this.resultSet.getString("nome_cliente");
		String cpf = this.resultSet.getString("cpf_cliente");
		String telefone =this.resultSet.getString("telefone");
		String vendedorid = this.resultSet.getString("vendedorid");
		resultString.append(id).append(" Nome: ").append(nome).append(" CPF: ").append(cpf).append(" telefone: ").append(telefone).append(" vendedorid: ").append(vendedorid).append("\n");
   /*System.out.println("ID: "+this.resultSet.getString("id_cliente")+
   		"Nome: "+ this.resultSet.getString("nome_cliente")+
   		"cpf:"+ this.resultSet.getString("cpf_cliente")+
   		"telefone: "+ this.resultSet.getString("telefone")+
   		"nome_vendedor_responsavel: "+ this.resultSet.getString("nome_vendedor_responsavel"));*/
	}
	JOptionPane.showMessageDialog(null, resultString.toString(),"Dados",JOptionPane.INFORMATION_MESSAGE);
	}
catch(Exception e) {
	System.out.println("Erro:" + e.getMessage());
}
	}
public void editarcliente(String id_cliente, String nome_cliente, String cpf_cliente, String telefone, String nome_vendedor_responsavel) {
	try {
		String query = "Update cliente set nome_cliente = '"+nome_cliente+"',cpf_cliente = '"+cpf_cliente+"',telefone='"+telefone+"',nome_vendedor_responsavel='"+nome_vendedor_responsavel+"' where id_cliente = "+id_cliente+" ";
			this.statement.executeUpdate(query);
	}catch(Exception e) {
		System.out.println("Erro" + e.getMessage());
	}
}
public void apagarcliente(String id_cliente1) {
	 try { 
		 String query = "Delete from cliente where id_cliente = '"+id_cliente1+"'; ";
				 this.statement.executeUpdate(query);
				 JOptionPane.showMessageDialog(null, "Vendedor apagado com sucesso!","Aviso",JOptionPane.INFORMATION_MESSAGE);
	 }catch(Exception e) {
		System.out.println("Erro:" + e.getMessage()); 
	 }
	 
	 
}
public void desconectar() {
			try {
				this.connection.close();
			}catch(Exception e) {
				System.out.println("Erro"+ e.getMessage());
			}
}
}