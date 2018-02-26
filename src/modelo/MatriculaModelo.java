package modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MatriculaModelo extends Conector {
	
public ArrayList <Matricula> selectAll(){
	
	ArrayList <Matricula> matriculas = new ArrayList();
	AlumnoModelo alumnoModelo= new AlumnoModelo();
	AsignaturaModelo asignaturaModelo= new AsignaturaModelo();
	try {
		PreparedStatement pst = super.conexion.prepareStatement("select * from matriculas");
		
		ResultSet rs= pst.executeQuery();
		
		while(rs.next()){
			
			Matricula matricula= new Matricula();
			matricula.setAlumno(alumnoModelo.selectPorId(rs.getInt("id_alumno")));
			matricula.setAsignatura(asignaturaModelo.selectAsignaturaPorId(rs.getInt("id_asignatura")));
//			matricula.setIdAlumno(rs.getInt("id_alumno"));
//			matricula.setIdAsignatura(rs.getInt("id_asignatura"));
			matricula.setFecha(rs.getDate("fecha"));
			matriculas.add(matricula);
			
			
		}
		
		
	} catch (SQLException e) {
		
		e.printStackTrace();
	}
	return matriculas;
	
	
	
	
}

public ArrayList<Matricula> getMatriculasConAsignatura(Alumno alumno) {
	
	AsignaturaModelo asignaturaModelo= new AsignaturaModelo();
	ArrayList <Matricula> matriculas = new ArrayList <Matricula>();
	
	PreparedStatement pst;
	try {
		pst = super.conexion.prepareStatement("select * from matriculas where id_alumno=?");
		pst.setInt(1, alumno.getId());
		ResultSet rs= pst.executeQuery();
		
		while(rs.next()){
			Matricula matricula = new Matricula();
			matricula.setAsignatura(asignaturaModelo.getAsignatura(rs.getInt("id_asignatura")));
			matricula.setFecha(rs.getDate("fecha"));;
			matriculas.add(matricula);
			
		
			
		}
	} catch (SQLException e) {
		
		e.printStackTrace();
	}

 	return matriculas;
	
}

	

		
		
		
		
		
	
	

}
