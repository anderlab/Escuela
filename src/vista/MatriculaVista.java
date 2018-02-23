package vista;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import modelo.Alumno;
import modelo.AlumnoModelo;
import modelo.Asignatura;
import modelo.AsignaturaModelo;
import modelo.Matricula;
import modelo.MatriculaModelo;

public class MatriculaVista {

	public void menuMatricula() {

		final int LISTAR = 1;
		final int SALIR = 0;

		int opcion;

		do {
			System.out.println("-----MENU-----\n");
			System.out.println(LISTAR + " Listar matriculas");

			Scanner lector = new Scanner(System.in);
			opcion = Integer.parseInt(lector.nextLine());

			switch (opcion) {

			case LISTAR:
				listar();

			default:
				break;
			}

		} while (opcion != SALIR);

	}

	private void listar() {
		
		
		
	MatriculaModelo matriculaModelo = new MatriculaModelo();
		
		ArrayList <Matricula> matriculas = matriculaModelo.selectAll();
		
		
		Iterator <Matricula> i = matriculas.iterator();
		
		while(i.hasNext()){
			AlumnoModelo alumnoModelo = new AlumnoModelo();
			AsignaturaModelo asignaturaModelo = new AsignaturaModelo();
			
			Matricula matricula= i.next();
			Alumno alumno= alumnoModelo.selectPorId(matricula.getIdAlumno());
			Asignatura asignatura= asignaturaModelo.selectAsignaturaPorId(matricula.getIdAsignatura());
			
			
		
			mostrarMatriculaAsignaturaAlumno(alumno, asignatura, matricula);
			
		}
		
		
		
	}

	private void mostrarMatriculaAsignaturaAlumno(Alumno alumno, Asignatura asignatura, Matricula matricula) {
		System.out.println("Nombre del alumno: "+alumno.getNombre());
		System.out.println("DNI del alumno: "+alumno.getDni());
		System.out.println( "Nombre de asignatura: "+asignatura.getNombre());
		System.out.println("Horas de la asginatura: "+asignatura.getHoras());
		System.out.println("Fecha matriculacion : "+matricula.getFecha()+"\n");
		
	}
	
	
	
	
//	private static Asignatura getAsignatura(Matricula matricula) {
//
//		AsignaturaModelo asignaturaModelo = new AsignaturaModelo();
//		Asignatura asignatura = asignaturaModelo.selectAsignaturaPorId(matricula.getIdAsignatura());
//
//		return asignatura;
//	}
//
//	private static Alumno getAlumno(Matricula matricula) {
//
//		AlumnoModelo alumnoModelo = new AlumnoModelo();
//		Alumno alumno = alumnoModelo.selectPorId(matricula.getIdAlumno());
//
//		return alumno;
//	}

}
