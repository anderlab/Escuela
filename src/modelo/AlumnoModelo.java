package modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class AlumnoModelo extends Conector {

	public ArrayList<Alumno> selectAll() {

		ArrayList<Alumno> alumnos = new ArrayList();

		try {
			PreparedStatement pst = super.conexion.prepareStatement("select* from alumnos");
			ResultSet rs = pst.executeQuery();

			while (rs.next()) {

				Alumno alumno = new Alumno();
				alumno.setId(rs.getInt("id"));
				alumno.setDni(rs.getString("dni"));
				alumno.setNombre(rs.getString("nombre"));
				alumno.setEmail(rs.getString("email"));

				alumnos.add(alumno);

				return alumnos;

			}

		} catch (SQLException e) {

			e.printStackTrace();
		}
		return null;

	}

	public Alumno selectPorDni(String dni) {

		PreparedStatement pst;
		try {
			pst = super.conexion.prepareStatement("SELECT * from alumnos where dni=?");
			pst.setString(1, dni);

			ResultSet rs = pst.executeQuery();

			while (rs.next()) {

				Alumno alumno = new Alumno();
				alumno.setId(rs.getInt("id"));
				alumno.setDni(rs.getString("dni"));
				alumno.setNombre(rs.getString("nombre"));
				alumno.setEmail(rs.getString("email"));

				return alumno;

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;

	}

	public void insertar(Alumno alumno) {

		try {
			PreparedStatement pst = super.conexion
					.prepareStatement("INSERT INTO alumnos (dni, nombre, email) values (?,?,?)");

			pst.setString(1, alumno.getDni());
			pst.setString(2, alumno.getNombre());
			pst.setString(3, alumno.getEmail());

			pst.execute();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void update(Alumno alumno) {

		try {
			PreparedStatement pst = super.conexion
					.prepareStatement("UPDATE alumnos SET dni=?, nombre=?, email=? where id=?");

			pst.setString(1, alumno.getDni());
			pst.setString(2, alumno.getNombre());
			pst.setString(3, alumno.getEmail());
			pst.setInt(4, alumno.getId());

			pst.execute();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public Alumno selectPorId(int id) {

		PreparedStatement pst;
		try {
			pst = super.conexion.prepareStatement("SELECT * from alumnos where id=?");
			pst.setInt(1, id);

			ResultSet rs = pst.executeQuery();

			while (rs.next()) {

				Alumno alumno = new Alumno();
				alumno.setId(rs.getInt("id"));
				alumno.setDni(rs.getString("dni"));
				alumno.setNombre(rs.getString("nombre"));
				alumno.setEmail(rs.getString("email"));

				return alumno;

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;

	}

	public ArrayList<Alumno> selectAllconMatriculas() {

		ArrayList<Alumno> alumnos = new ArrayList();
		MatriculaModelo matriculaModelo= new MatriculaModelo();

		try {
			PreparedStatement pst = super.conexion.prepareStatement("select* from alumnos");
			ResultSet rs = pst.executeQuery();

			while (rs.next()) {

				Alumno alumno = new Alumno();
				
				alumno.setId(rs.getInt("id"));
				alumno.setDni(rs.getString("dni"));
				alumno.setNombre(rs.getString("nombre"));
				alumno.setEmail(rs.getString("email"));
				
				
				ArrayList<Matricula>matriculas= matriculaModelo.getMatriculasConAsignatura(alumno);
				alumno.setMatriculas(matriculas);
				
				alumnos.add(alumno);

			

			}

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return alumnos;

	}

}
