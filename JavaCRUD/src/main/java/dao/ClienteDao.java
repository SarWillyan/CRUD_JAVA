package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import db.MySqlConnection;
import model.Cliente;

public class ClienteDao implements CRUD {
	
	// cria a conecção
	private static Connection connection = MySqlConnection.createConnection();
	// recebe a linha de comando sql
	private static String sql;
	
	public static void create(Cliente cliente) {
		sql = "INSERT INTO clientes VALUES (null, ?, ?, ?, ?)";
		
		try {
			// Recebe a string/comando SQL para fazela receber os parametros
			PreparedStatement preparedStatement= connection.prepareStatement(sql);
			
			// Preenche os parametros de 'sql'
			preparedStatement.setString(1, cliente.getNome());
			preparedStatement.setString(2, cliente.getCpf());
			preparedStatement.setString(3, cliente.getNascimento());
			preparedStatement.setString(4, cliente.getSituacao());
			
			// Execulta o comando SQL sem ter retorno do BD
			preparedStatement.executeUpdate();
			
			System.out.println("--correct insert on database");
		} catch (SQLException e) {
			System.out.println("--incorrect insert on database. " + e.getMessage());
		}
	}
	
	public static void delete(int clienteId) {
		sql = "DELETE FROM clientes WHERE id = ?";
		
		try {
			PreparedStatement preparedStatement= connection.prepareStatement(sql);
			
			preparedStatement.setInt(1, clienteId);
			preparedStatement.executeUpdate();
			
			System.out.println("--correct delete on cliente.");
		} catch (SQLException e) {
			System.out.println("--incorrect delete on cliente. " + e.getMessage());
		}
	}
	
	public static List<Cliente> find(String pesquisa) {
		sql = String.format("SELECT * FROM clientes WHERE nome LIKE '%s%%' OR cpf LIKE '%s%%'", pesquisa, pesquisa);
		
		List<Cliente> clientes = new ArrayList<Cliente>();
		
		try {
			Statement statement = connection.createStatement();
			// Execulta o comando SQL e recebe o retorno do BD
			ResultSet resultSet = statement.executeQuery(sql);
			
			// Percorre o resultado dado pelo BD 
			while (resultSet.next()) {
				Cliente cliente = new Cliente();
				cliente.setId(resultSet.getInt("id"));
				cliente.setNome(resultSet.getString("nome"));
				cliente.setCpf(resultSet.getString("cpf"));
				cliente.setNascimento(resultSet.getString("nascimento"));
				cliente.setSituacao(resultSet.getString("situacao"));
				
				// Adiciona o cliente na lista de clientes
				clientes.add(cliente);
			}
			
			System.out.println("--correct find clientes");
			return clientes;
		} catch (SQLException e) {
			System.out.println("--incorrect find clientes. " + e.getMessage());
			return null;
		}
		
	}
	
	public static Cliente findByPk(int clienteId) {
		
		sql = String.format("SELECT * FROM clientes WHERE id = %d", clienteId);
		
		try {
			Statement statement = connection.createStatement();
			// Execulta o comando SQL e recebe o retorno do BD
			ResultSet resultSet = statement.executeQuery(sql);
			
			Cliente cliente = new Cliente();
			// Percorre o resultado dado pelo BD 
			while (resultSet.next()) {
				cliente.setId(resultSet.getInt("id"));
				cliente.setNome(resultSet.getString("nome"));
				cliente.setCpf(resultSet.getString("cpf"));
				cliente.setNascimento(resultSet.getString("nascimento"));
				cliente.setSituacao(resultSet.getString("situacao"));	
			}
			
			System.out.println("--correct find by pk clientes");
			return cliente;
		} catch (SQLException e) {
			System.out.println("--incorrect find by pk clientes. " + e.getMessage());
			return null;
		}
	}
	
	public static void update(Cliente cliente) {
		sql = "UPDATE clientes SET nome=?, cpf=?, nascimento=?, situacao=? WHERE id=?";
		
		try {
			// Recebe a string/comando SQL para fazela receber os parametros
			PreparedStatement preparedStatement= connection.prepareStatement(sql);
			
			// Preenche os parametros de 'sql'
			preparedStatement.setString(1, cliente.getNome());
			preparedStatement.setString(2, cliente.getCpf());
			preparedStatement.setString(3, cliente.getNascimento());
			preparedStatement.setString(4, cliente.getSituacao());
			preparedStatement.setInt(5, cliente.getId());
			
			// Execulta o comando SQL sem ter retorno do BD
			preparedStatement.executeUpdate();
			
			System.out.println("--correct update on database");
		} catch (SQLException e) {
			System.out.println("--incorrect update on database. " + e.getMessage());
		}
	}
	
}
