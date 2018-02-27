package modelo;

import java.util.ArrayList;

public class Alumno {

	private int id;
	private String dni;
	private String nombre;
	private String email;
	private Provincia provincia;

	private ArrayList<Matricula> matriculas;

	// getters and setters

	public Provincia getProvincia() {
		return provincia;
	}

	public void setProvincia(Provincia provincia) {
		this.provincia = provincia;
	}

	public ArrayList<Matricula> getMatriculas() {
		return matriculas;
	}

	public void setMatriculas(ArrayList<Matricula> matriculas) {
		this.matriculas = matriculas;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
