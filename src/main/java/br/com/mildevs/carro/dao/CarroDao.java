package br.com.mildevs.carro.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.mildevs.carro.connectionfactory.ConnectionFactory;
import br.com.mildevs.carro.pojo.Carro;

public class CarroDao {

	private Connection conn;

	public CarroDao() {
		this.conn = ConnectionFactory.getConnection();
	}

	public boolean insereCarro(Carro carro) {
		String sql = "INSERT INTO carros.carro(placa, cor, marca, modelo) VALUES (?, ?, ?, ?)";

		try {
			PreparedStatement stmt = this.conn.prepareStatement(sql);
			stmt.setString(1, carro.getPlaca());
			stmt.setString(2, carro.getCor());
			stmt.setString(3, carro.getMarca());
			stmt.setString(4, carro.getModelo());
			stmt.execute();
			stmt.close();
			return true;
		} catch (SQLException e) {
			System.err.println("Erro ao inserir carro!");
		}
		return false;

	}

	public List<Carro> listaCarros() {

			List<Carro> carros = new ArrayList<Carro>();
		
			String sql = "SELECT * FROM carros.carro";
		
			try {
				PreparedStatement stmt = this.conn.prepareStatement(sql);
				ResultSet rs = stmt.executeQuery();
		
				while (rs.next()) {
					Carro carroRetornado = new Carro();
		
					carroRetornado.setPlaca(rs.getString("placa"));
					carroRetornado.setCor(rs.getString("cor"));
					carroRetornado.setMarca(rs.getString("marca"));
					carroRetornado.setModelo(rs.getString("modelo"));
		
					carros.add(carroRetornado);
				}
		
			} catch (SQLException e) {
				System.err.println("Erro ao listar carros!");
			}
		
			return carros;
		
	}

	public Carro consultaCarro(String placa) {

			String sql = "SELECT * FROM carros.carro where placa = ?";
		
			try {
				PreparedStatement stmt = this.conn.prepareStatement(sql);
				stmt.setString(1, placa);
				ResultSet rs = stmt.executeQuery();
		
				if (rs.next()) {
					Carro carroRetornado = new Carro();
		
					carroRetornado.setPlaca(rs.getString("placa"));
					carroRetornado.setCor(rs.getString("cor"));
					carroRetornado.setMarca(rs.getString("marca"));
					carroRetornado.setModelo(rs.getString("modelo"));
		
					return carroRetornado;
				}
		
			} catch (SQLException e) {
				System.err.println("Erro ao consultar carro.");
			}
		
			return null;

	}

	public boolean removeCarro(String placa) {
			String sql = "DELETE FROM carros.carro WHERE placa = ?";
		
			try {
				PreparedStatement stmt = this.conn.prepareStatement(sql);
				stmt.setString(1, placa);
				stmt.execute();
				stmt.close();
				return true;
			} catch (SQLException e) {
				System.err.println("Erro ao remover carro!");
			}
		
			return false;

	}


}
