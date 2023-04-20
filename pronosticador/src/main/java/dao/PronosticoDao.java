package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import factory.ConnectionFactory;
import modelo.Pronostico;

public class PronosticoDao {

	public void actualizarPronostico(Pronostico pronostico) {
	    String sql = "UPDATE pronostico SET idPartido = ?, equipo = ?, resultado = ?, usuario = ? WHERE idPronostico = ?";
	    ConnectionFactory connectionFactory = new ConnectionFactory();
	    try (Connection conn = connectionFactory.recuperaConexion();
	         PreparedStatement ps = conn.prepareStatement(sql)) {
	        ps.setInt(1, pronostico.getIdPartido());
	        ps.setString(2,pronostico.getEquipo());
	        ps.setString(3,pronostico.getResultado());
	        ps.setString(4,pronostico.getUsuario());
	        ps.setInt(5,pronostico.getIdPronostico());
	        ps.executeUpdate();
	    } catch (SQLException e) {
	        throw new RuntimeException(e);
	    }
	}
	
}
