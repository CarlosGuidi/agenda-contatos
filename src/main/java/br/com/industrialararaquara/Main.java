package br.com.industrialararaquara;

//import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;



public class Main {

	public static void main(String[] args) throws SQLException {
		
		/*Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Agenda?useTimezone=true&serverTimezone=UTC&userSSL=false", "root", "123456");
		
		PreparedStatement ps = con.prepareStatement("insert into contatos(nome,telefone) values(?,?)");
		ps.setString(1,"Gilvan");
		ps.setString(2,"1231231213");
		ps.execute();
		
		ps.setString(1,"Maria");
		ps.setString(2,"123124564");
		ps.execute(); 
		
		//altera os dados
		PreparedStatement ps = con.prepareStatement("update contatos set nome=? where id=?");
		ps.setString(1,"Gilvan Ribeiro");
		ps.setInt(2,1);
		ps.execute(); 
		
		//deleta 
		PreparedStatement ps = con.prepareStatement("delete from contatos where id=?");
		ps.setInt(1,2);
		ps.execute();
		
		PreparedStatement ps = con.prepareStatement("select id,nome,telefone from contatos");
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
			System.out.println("Nome:" + rs.getString(2));
			System.out.println("Telefone: " + rs.getString(3));
		}
		con.close();
		*/
		
		/* Database database = new Database();
		
		//database.inserir("Amanda", "0987654321");
		
		//database.deletar(3);
		
		//database.atualizar("Gilvan", "00000000000", 1);
		
		ResultSet rs = database.selecionar();
		
		while(rs.next()) {
			System.out.println("Nome: " + rs.getString(2));
			System.out.println("Nome: " + rs.getString(3));
		}
		
		database.fecharConexao(); */
		
		Database database = new Database();
		
		int opcao = 0;
		
		while(opcao != 5) {
			
			Scanner menu = new Scanner(System.in); 
		
			System.out.println("1 - Inserir");
			System.out.println("2 - Atualizar");
			System.out.println("3 - Excluir");
			System.out.println("4 - Selecionar");
			System.out.println("5 - Sair");
			
			opcao = menu.nextInt();
			
			if(opcao == 1) {
				Scanner inserir = new Scanner(System.in);
				System.out.println("Digite o nome : ");
				String nome = inserir.nextLine();
				System.out.println("Digite o telefone : ");
				String telefone = inserir.nextLine();
				database.inserir(nome, telefone);
			} else if(opcao == 2) {
				Scanner atualizar = new Scanner(System.in);
				System.out.println("Digite o id : ");
				int idAtualizar = atualizar.nextInt();
				System.out.println("Digite o nome : ");
				String nomeAtualizar = atualizar.next();
				System.out.println("Digite o telefone : ");
				String telefoneAtualizar = atualizar.next();
				database.atualizar(nomeAtualizar, telefoneAtualizar, idAtualizar);
				System.out.println("Usuário atualizado com sucesso");
			} else if(opcao == 5) {
				System.out.println("Saindo do programa...");
			} else if(opcao == 3) {
				Scanner deletar = new Scanner(System.in);
				System.out.println("Digite o id: ");
				int idDeletar = deletar.nextInt();
				database.deletar(idDeletar);
				System.out.println("Usuário excluído com sucesso");
			} else if(opcao == 4) {
				ResultSet rs = database.selecionar();
				while(rs.next()) {
					System.out.println("Nome: " + rs.getString(2));
					System.out.println("Telefone: " + rs.getString(3));
					System.out.println("-------------------------------");
				}
			}
			
			if(opcao < 0 || opcao > 5) {
				System.out.println("Opção inválida \n \n");
			}
		
		}
		
		database.fecharConexao();
		
	}


}
