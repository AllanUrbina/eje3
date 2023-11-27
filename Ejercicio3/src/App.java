import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner lector = new Scanner(System.in);
        System.out.println("Ingrese datos del profesor:");
        System.out.print("Nombre: ");
        String nombreProfesor = lector.nextLine();

        int edadProfesor;
        while (true) {
            try {
                System.out.print("Edad: ");
                edadProfesor = Integer.parseInt(lector.nextLine());
                if (edadProfesor < 0) {
                    throw new IllegalArgumentException("La edad no puede ser negativa");
                }
                break;
            } catch ( IllegalArgumentException e) {
                System.out.println("Por favor, ingrese una edad válida (número entero positivo).");
            }
        }

        char sexoProfesor;
        while (true) {
            System.out.print("Sexo (M/F): ");
            String inputSexo = lector.nextLine().toUpperCase();
            if (inputSexo.length() == 1 && (inputSexo.charAt(0) == 'M' || inputSexo.charAt(0) == 'F')) {
                sexoProfesor = inputSexo.charAt(0);
                break;
            }
            System.out.println("Por favor, ingrese M o F para el sexo.");
        }
        Profesor profesor = new Profesor(nombreProfesor, edadProfesor, sexoProfesor, "Introducción a la Programación");

        System.out.println("\nIngrese datos de los estudiantes:");
        System.out.print("Cantidad de estudiantes: ");
        int cantidadEstudiantes;
        while (true) {
            try {
                System.out.print("Cantidad de estudiantes: ");
                cantidadEstudiantes = Integer.parseInt(lector.nextLine());
                if (cantidadEstudiantes < 0) {
                    throw new IllegalArgumentException("La cantidad de estudiantes no puede ser negativa");
                }
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("Por favor, ingrese una cantidad válida (número entero positivo).");
            }
        }


        Aula aula = new Aula(1, cantidadEstudiantes, "Introducción a la Programación", profesor);
        for (int i = 0; i < cantidadEstudiantes; i++) {
            System.out.println("\nDatos del estudiante " + (i + 1) + ":");
            System.out.print("Nombre: ");
            String nombreEstudiante = lector.nextLine();
        
            int edadEstudiante = -1;
            while (edadEstudiante <= 0) {
                System.out.print("Edad: ");
                try {
                    edadEstudiante = Integer.parseInt(lector.nextLine());
                    if (edadEstudiante <= 0) {
                        System.out.println("La edad debe ser un número entero positivo mayor que cero.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Por favor, ingrese una edad válida (número entero positivo).");
                }
            }
        
            char sexoEstudiante;
            while (true) {
                System.out.print("Sexo (M/F): ");
                String inputSexo = lector.nextLine().toUpperCase();
                if (inputSexo.length() == 1 && (inputSexo.charAt(0) == 'M' || inputSexo.charAt(0) == 'F')) {
                    sexoEstudiante = inputSexo.charAt(0);
                    break;
                }
                System.out.println("Por favor, ingrese M o F para el sexo.");
            }
        
            double calificacionEstudiante = -1;
            while (calificacionEstudiante <= 0) {
                System.out.print("Calificación: ");
                try {
                    calificacionEstudiante = Double.parseDouble(lector.nextLine());
                    if (calificacionEstudiante <= 0) {
                        System.out.println("La calificación debe ser un número positivo mayor que cero.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Por favor, ingrese una calificación válida (número positivo).");
                }
            }
        
            Estudiante estudiante = new Estudiante(nombreEstudiante, edadEstudiante, sexoEstudiante, calificacionEstudiante);
            aula.estudiantes[i] = estudiante;
        }

        lector.close();

        if (aula.puedeImpartirseClase()) {
            int aprobados = aula.contarAprobados();
            System.out.println("\nSe puede dar clase.");
            System.out.println("Cantidad de aprobados: " + aprobados);
        } else {
            System.out.println("\nNo se puede dar clase en este momento.");
        }
    }
}