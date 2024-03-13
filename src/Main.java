import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static Scanner rc = new Scanner(System.in);
    static ArrayList<Seleccion> seleccionado = new ArrayList<>();

    public static void main(String[] args) {
        int op = 0;
        do {
            System.out.println("---- FUTBOL -----");
            System.out.println("1.- Agregar Futbolista");
            System.out.println("2.- Agregar Masajista");
            System.out.println("3.- Agregar Entrenador");
            System.out.println("4.- Listar Futbolistas ");
            System.out.println("5.- Listar Masajistas ");
            System.out.println("6.- Listar Entrenadores ");
            System.out.println("0.- Salir");
            System.out.print("- Selecciona una opcion ->  ");
            op = rc.nextInt();
            switch (op) {
                case 0:
                    System.out.println("----------------------------------");
                    System.out.println("Programa finalizado con éxito!!...");
                    break;
                case 1:
                    addFutbolista();
                    break;
                case 2:
                    addMasajista();
                    break;
                case 3:
                    addEntrenador();
                    break;
                case 4:
                    System.out.println(showFutbolistas());
                    break;
                case 5:
                    showMasajistas();
                    break;
                case 6:
                    showEntrenadores();
                    break;
                default:
                    System.out.println("Opción no válida. Inténtalo de nuevo.");
                    break;
            }

        } while (op != 0);
    }

    public static Seleccion addFutbolista() {
        int id, edad, dorsal;
        String nombre, apellidos, demarcacion;

        System.out.println("----------------------------------");
        System.out.print("ID: ");
        id = (rc.nextInt());
        System.out.print("Nombre: ");
        nombre = (rc.next());
        System.out.print("Apellidos: ");
        apellidos = (rc.next());
        System.out.print("Edad: ");
        edad = (rc.nextInt());
        System.out.print("Dorsal: ");
        dorsal = (rc.nextInt());
        System.out.print("Demarcación: ");
        demarcacion = (rc.next());

        Futbolista nuevoFutbolista = new Futbolista(id, nombre, apellidos, edad, dorsal, demarcacion);
        seleccionado.add(nuevoFutbolista);
        return nuevoFutbolista;
    }

    public static Seleccion addMasajista() {
        int id, edad;
        String nombre, apellidos, titulacion;

        System.out.println("----------------------------------");
        System.out.print("ID: ");
        id = (rc.nextInt());
        System.out.print("Nombre: ");
        nombre = (rc.next());
        System.out.print("Apellidos: ");
        apellidos = (rc.next());
        System.out.print("Edad: ");
        edad = (rc.nextInt());
        System.out.print("Titulación: ");
        titulacion = (rc.next());

        Masajista nuevoMasajista = new Masajista(id, nombre, apellidos, edad, titulacion);
        seleccionado.add(nuevoMasajista);
        return nuevoMasajista;
    }

    public static Entrenador addEntrenador() {
        int id, edad;
        String nombre, apellidos, idFederacion;

        System.out.println("----------------------------------");
        System.out.print("ID: ");
        id = (rc.nextInt());
        System.out.print("Nombre: ");
        nombre = (rc.next());
        System.out.print("Apellidos: ");
        apellidos = (rc.next());
        System.out.print("Edad: ");
        edad = (rc.nextInt());
        System.out.print("ID Federación: ");
        idFederacion = (rc.next());

        Entrenador nuevoEntrenador = new Entrenador(id, nombre, apellidos, edad, idFederacion);
        seleccionado.add(nuevoEntrenador);
        return nuevoEntrenador;
    }

    public static String showFutbolistas() {
        StringBuilder output = new StringBuilder();
        output.append("----- Listar Futbolistas -----\n");

        if (seleccionado.isEmpty()) {
            output.append("--------------------------------\n");
            output.append(" No hay Futbolistas registrados\n");
            output.append("--------------------------------\n");
        } else {
            output.append("ID\tNombre\tApellidos\tEdad\tDorsal\tDemarcacion\n");
            for (Seleccion seleccion : seleccionado) {
                if (seleccion instanceof Futbolista futbolista) {
                    output.append(futbolista.getId())
                            .append("\t").append(futbolista.getNombre())
                            .append("\t").append(futbolista.getApellidos())
                            .append("\t").append(futbolista.getEdad())
                            .append("\t").append(futbolista.getDorsal())
                            .append("\t").append(futbolista.getDemarcacion())
                            .append("\n");
                }
            }
        }
        return output.toString();
    }

    public static boolean showMasajistas() {
        return true;
    }

    public static boolean showEntrenadores() {
        return true;
    }
}
