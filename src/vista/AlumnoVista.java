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
		final int LISTAR_CONPROVINCIAS = 2;
		final int SALIR = 0;
		AlumnoModelo alumnoModelo = new AlumnoModelo();
		int opcion;

		do {
			System.out.println("-----MENU-----\n");
			System.out.println(LISTAR + " Listar alumnos con asignaturas");
			System.out.println(LISTAR_CONPROVINCIAS + " Listar alumnos con provincias");

			Scanner lector = new Scanner(System.in);
			opcion = Integer.parseInt(lector.nextLine());

			switch (opcion) {

			case LISTAR:
				alumnoModelo = new AlumnoModelo();
				ArrayList<Alumno> alumnos = alumnoModelo.selectAllconMatriculas();
				this.mostrarAlumnosConAsignaturas(alumnos);

			case LISTAR_CONPROVINCIAS:

				alumnoModelo = new AlumnoModelo();
				// alumnos= alumnoModelo.selectAll();
				alumnos = alumnoModelo.selectAll2();
				this.mostrarAlumnos(alumnos);

			default:
				break;
			}

		} while (opcion != SALIR);

	}

	private void mostrarAlumnos(ArrayList<Alumno> alumnos) {
		Iterator<Alumno> i = alumnos.iterator();
		while (i.hasNext()) {
			Alumno alumno = i.next();
			this.mostrarAlumnoConProvincia(alumno);
		}

	}

	private void mostrarAlumnoConProvincia(Alumno alumno) {
		System.out.println("Nombre: " + alumno.getNombre());
		System.out.println("Provincia: " + alumno.getProvincia().getNombre());

	}

	private void mostrarAlumnosConAsignaturas(ArrayList<Alumno> alumnos) {
		Iterator<Alumno> i = alumnos.iterator();
		while (i.hasNext()) {
			Alumno alumno = i.next();
			this.mostrarAlumnoConAsignatura(alumno);
		}

	}

	private void mostrarAlumnoConAsignatura(Alumno alumno) {
		// Muestra los datos del alumno
		System.out.println("Nombre alumno: " + alumno.getNombre() + " Dni alumno: " + alumno.getDni());
		System.out.println("Asignaturas: ");
		// Muestra todas sus asignaturas
		ArrayList<Matricula> matriculas = alumno.getMatriculas();
		Iterator<Matricula> i = matriculas.iterator();

		while (i.hasNext()) {
			Matricula matricula = i.next();
			System.out.println(matricula.getFecha() + " " + matricula.getAsignatura().getNombre() + " "
					+ matricula.getAsignatura().getHoras());

		}

		System.out.println(".............");

	}

}
