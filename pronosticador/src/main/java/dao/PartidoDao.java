package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import factory.ConnectionFactory;
import modelo.Partido;


public class PartidoDao {
	private Connection con;

    public PartidoDao(Connection con) {
        this.con = con;
    }

	
	public void actualizarPartido(Partido partido) {
	    String sql = "UPDATE partido SET id_partido = ?, equipoA = ?, equipoB=?, golesA = ?, golesB = ?, id_ronda=? WHERE id_partido = ?";
	    Connection conn = this.con;
	    try (
	         PreparedStatement ps = conn.prepareStatement(sql)) {
	        ps.setInt(1, partido.getId_partido());
	        ps.setString(2,partido.getEquipoA());
	        ps.setString(3,partido.getEquipoB());
	        ps.setInt(4,partido.getGolesA());
	        ps.setInt(5,partido.getGolesB());
	        ps.setInt(6,partido.getId_ronda());
	        ps.setInt(7, partido.getId_partido());
	        
	        ps.executeUpdate();
	    } catch (SQLException e) {
	        throw new RuntimeException(e);
	    }
	}
}
