package modelo;

import java.util.Date;

public class Matricula {
	
	private Alumno alumno;
	private Asignatura asignatura;
	private Date fecha;
	

	
	
	//getters and setters
	

	public Date getFecha() {
		return fecha;
	}
	public Alumno getAlumno() {
		return alumno;
	}
	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;
	}
	public Asignatura getAsignatura() {
		return asignatura;
	}
	public void setAsignatura(Asignatura asignatura) {
		this.asignatura = asignatura;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	

}
