package modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class AsignaturaModelo extends Conector {

	public ArrayList<Asignatura> selectAll() {

		ArrayList<Asignatura> asignaturas = new ArrayList<Asignatura>();

		try {
			PreparedStatement pst = super.conexion.prepareStatement("Select * from asignaturas");

			ResultSet rs = pst.executeQuery();

			Asignatura asignatura = new Asignatura();

			asignatura.setId(rs.getInt("id"));
			asignatura.setNombre(rs.getString("nombre"));
			asignatura.setHoras(rs.getInt("horas"));

			asignaturas.add(asignatura);

			return asignaturas;

		} catch (SQLException e) {

			e.printStackTrace();
		}
		return null;

	}

	public Asignatura selectAsignaturaPorId(int id) {

		try {
			PreparedStatement pst = super.conexion.prepareStatement("Select * from asignaturas where id=?");
			pst.setInt(1, id);

			ResultSet rs = pst.executeQuery();

			while (rs.next()) {

				Asignatura asignatura = new Asignatura();

				asignatura.setId(rs.getInt("id"));
				asignatura.setNombre(rs.getString("nombre"));
				asignatura.setHoras(rs.getInt("horas"));

				return asignatura;

			}

		} catch (SQLException e) {

			e.printStackTrace();
		}
		return null;

	}
	
	public Asignatura selectAsignaturaPorNombre(String nombre) {

		try {
			PreparedStatement pst = super.conexion.prepareStatement("Select * from asignaturas where nombre=?");
			pst.setString(1, nombre);

			ResultSet rs = pst.executeQuery();

			while (rs.next()) {

				Asignatura asignatura = new Asignatura();

				asignatura.setId(rs.getInt("id"));
				asignatura.setNombre(rs.getString("nombre"));
				asignatura.setHoras(rs.getInt("horas"));

				return asignatura;

			}

		} catch (SQLException e) {

			e.printStackTrace();
		}
		return null;

	}
	public void insert(Asignatura asignatura) {
		try {
			PreparedStatement pst = super.conexion
					.prepareStatement("INSERT INTO asignaturas (nombre, horas) values (?,?)");

			pst.setString(1, asignatura.getNombre());
			pst.setInt(2, asignatura.getHoras());

			pst.execute();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	
	
	public void update (Asignatura asignatura){
		
		try {
			PreparedStatement pst= super.conexion.prepareStatement("UPDATE asignaturas SET nombre=? , horas=? where id=? ");
			
			pst.setString(1, asignatura.getNombre());
			pst.setInt(2, asignatura.getHoras());
			pst.setInt(3, asignatura.getId());
			
			pst.execute();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
