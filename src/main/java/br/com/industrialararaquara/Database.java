package br.com.industrialararaquara;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Database {
	
	public Connection conexao() throws SQLException {
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Agenda?useTimezone=true&serverTimezone=UTC&userSSL=false", "root", "123456");
		return con;
	}
	
	public void inserir(String nome, String telefone) throws SQLException {
		PreparedStatement ps = this.conexao().prepareStatement("insert into contatos(nome,telefone) values(?,?)");
		ps.setString(1, nome);
		ps.setString(2, telefone);
		ps.execute();
	}
	
	public void deletar(int id) throws SQLException {
		PreparedStatement ps = this.conexao().prepareStatement("delete from Contatos where id = ?");
		ps.setInt(1, id);
		ps.execute();
	}
	
	public void atualizar(String nome, String telefone, int id) throws SQLException {
		PreparedStatement ps = this.conexao().prepareStatement("update Contatos set nome = ?, telefone = ? where id = ?");
		ps.setString(1, nome);
		ps.setString(2, telefone);
		ps.setInt(3, id);
		ps.execute();
	}
	
	public ResultSet selecionar() throws SQLException {
		PreparedStatement ps = this.conexao().prepareStatement("select id, nome, telefone from Contatos");
		ResultSet rs = ps.executeQuery();
		return rs;
	}
	
	public void fecharConexao() throws SQLException {
		this.conexao().close();
	}
	
}
