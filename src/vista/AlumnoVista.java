package vista;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import modelo.Alumno;
import modelo.AlumnoModelo;
import modelo.Matricula;

public class AlumnoVista {
	
	public void menuAlumno() {

		final int LISTAR = 1;
		final int SALIR = 0;

		int opcion;

		do {
			System.out.println("-----MENU-----\n");
			System.out.println(LISTAR + " Listar alumnos con asignaturas");

			Scanner lector = new Scanner(System.in);
			opcion = Integer.parseInt(lector.nextLine());

			switch (opcion) {

			case LISTAR:
				AlumnoModelo alumnoModelo= new AlumnoModelo();
				ArrayList <Alumno> alumnos= alumnoModelo.selectAllconMatriculas();
				this.mostrarAlumnosConAsignaturas(alumnos);

			default:
				break;
			}

		} while (opcion != SALIR);

	}

private void mostrarAlumnosConAsignaturas(ArrayList<Alumno> alumnos) {
		Iterator<Alumno> i= alumnos.iterator();
		while(i.hasNext()){
			Alumno alumno= i.next();
			this.mostrarAlumnoConAsignatura(alumno);
		}
		
	}

private void mostrarAlumnoConAsignatura(Alumno alumno) {
	//Muestra los datos del alumno
	System.out.println("Nombre alumno: "+ alumno.getNombre()+" Dni alumno: "+alumno.getDni());
	System.out.println("Asignaturas: ");
	//Muestra todas sus asignaturas
	ArrayList <Matricula> matriculas= alumno.getMatriculas();
	Iterator <Matricula> i= matriculas.iterator();
	
	while(i.hasNext()){
		Matricula matricula= i.next();
		System.out.println(
				matricula.getFecha()+" "+
				matricula.getAsignatura().getNombre()+" "+
						matricula.getAsignatura().getHoras());
		
	}
	
	System.out.println(".............");
	
	
}









}
