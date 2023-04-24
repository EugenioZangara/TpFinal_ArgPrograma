package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import modelo.Pronostico;

public class PronosticoDao {
	
	private Connection con;

	public PronosticoDao(Connection con) {
		this.con = con;
	}

	public void actualizarPronostico(Pronostico pronostico) {
		String sql = "INSERT INTO pronostico (id_partido, equipo, resultado, usuario, id) VALUES (?, ?, ?, ?, ?) "
				+ "ON DUPLICATE KEY UPDATE "
				+ "id_partido = VALUES(id_partido), equipo = VALUES(equipo), resultado = VALUES(resultado), usuario = VALUES(usuario)";
		Connection conn = this.con;
		try (
				PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setInt(1, pronostico.getIdPartido());
			ps.setString(2, pronostico.getEquipo());
			ps.setString(3, pronostico.getResultado());
			ps.setString(4, pronostico.getUsuario());
			ps.setInt(5, pronostico.getIdPronostico());
			ps.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}
