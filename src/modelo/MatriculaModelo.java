package modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MatriculaModelo extends Conector {
	
public ArrayList <Matricula> selectAll(){
	
	ArrayList <Matricula> matriculas = new ArrayList();
	try {
		PreparedStatement pst = super.conexion.prepareStatement("select * from matriculas");
		
		ResultSet rs= pst.executeQuery();
		
		while(rs.next()){
			
			Matricula matricula= new Matricula();
			
			matricula.setIdAlumno(rs.getInt("id_alumno"));
			matricula.setIdAsignatura(rs.getInt("id_asignatura"));
			matricula.setFecha(rs.getDate("fecha"));
			matriculas.add(matricula);
			
			
		}
		
		
	} catch (SQLException e) {
		
		e.printStackTrace();
	}
	return matriculas;
	
	
	
	
}
	
	

		
		
		
		
		
	
	

}
