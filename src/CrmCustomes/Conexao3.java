package CrmCustomes;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.swing.JOptionPane;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Conexao3 {
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
		


public void inserirproduto( String txtnomeproduto2, String txtdescricao2 ,String val, String txtcor2) {
	 try { 
		 String query = "insert into produto_produto (nome_produto_produto, descricao_produto_produto,valor_produto_produto,cor_produto_produto) values ('"+txtnomeproduto2+"','"+txtdescricao2+"', '"+val+"','"+txtcor2+"')";
		 System.out.println("produto inserido com sucesso!");
				 this.statement.executeUpdate(query);
	 }catch(Exception e) {
		System.out.println("Erro:" + e.getMessage()); 
		}
	 }

public void listarproduto_produto() {
	try {
	String query = "select * from produto_produto  order by nome_produto_produto";
	this.resultSet = this.statement.executeQuery(query);
	StringBuilder resultString = new StringBuilder();
	while(this.resultSet.next()) {
		String id = this.resultSet.getString("id_produto_produto");
		String nome = this.resultSet.getString("nome_produto_produto");
		String descricao = this.resultSet.getString("descricao_produto_produto");
		String valor = this.resultSet.getString("valor_produto_produto");
		String cor =this.resultSet.getString("cor_produto_produto");
		resultString.append(id).append(" Nome: ").append(nome).append(" descricao: ").append(descricao).append(" valor: ").append(valor).append(" cor: ").append(cor).append("\n");
   /*System.out.println("ID: "+this.resultSet.getString("id_produto_produto")+
   		"Nome: "+ this.resultSet.getString("nome_produto_produto")+
   		"descricao:"+ this.resultSet.getString("descricao_produto_produto")+
   		"valor: "+ this.resultSet.getString("valor_produto_produto")+
   		"cor: "+ this.resultSet.getString("cor_produto_produto"));*/
   
	}
	JOptionPane.showMessageDialog(null, resultString.toString(),"Dados",JOptionPane.INFORMATION_MESSAGE);
	}
catch(Exception e) {
	System.out.println("Erro:" + e.getMessage());
}
	}


public void editarproduto_produto(String id_produto_produto, String nome_produto_produto, String descricao_produto_produto, String valor_produto_produto, String cor_produto_produto) {
	try {
		String query = "Update produto_produto set nome_produto_produto = '"+nome_produto_produto+"',descricao_produto_produto = '"+descricao_produto_produto+"',valor_produto_produto='"+valor_produto_produto+"',cor_produto_produto='"+cor_produto_produto+"' where id_produto_produto = "+id_produto_produto+" ";
			this.statement.executeUpdate(query);
	}catch(Exception e) {
		System.out.println("Erro" + e.getMessage());
	}
}

public void apagarproduto_produto(String id) {
	 try { 
		 String query = "Delete  from produto_produto where id_produto_produto = '"+id+"'; ";
				 this.statement.executeUpdate(query);
				 JOptionPane.showMessageDialog(null,"Produto apagado com sucesso","Aviso",JOptionPane.INFORMATION_MESSAGE);
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