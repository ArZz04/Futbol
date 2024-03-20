import javax.swing.plaf.FontUIResource;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.FutureTask;

public class Main {
    static Scanner rc = new Scanner(System.in);
    static ArrayList<Seleccion> seleccionado = new ArrayList<>();

    public static void main(String[] args) {

        Entrenador Ent1 = new Entrenador(1, "Juan", "Arvizu", 45, "Chivas");
        Entrenador Ent2 = new Entrenador(2, "Pedro", "Pantera", 50, "America");

        Futbolista Fut1 = new Futbolista(1, "Karlita", "Torres", 25, 22, "DEF");
        Futbolista Fut2 = new Futbolista(2, "Diego", "Maradona", 30, 10, "ATT");

        Masajista Mas1 = new Masajista(1, "Pablo", "Arvizu", 40, "Licenciatura en Militar", 15);
        Masajista Mas2 = new Masajista(2, "Maria", "Lopez", 35, "Título en Masaje Deportivo", 10);

        seleccionado.add(Ent1);
        seleccionado.add(Ent2);
        seleccionado.add(Fut1);
        seleccionado.add(Fut2);
        seleccionado.add(Mas1);
        seleccionado.add(Mas2);

        int op = 0;
        do {
            System.out.println("---- FUTBOL -----");
            System.out.println("1.- Agregar Futbolista");
            System.out.println("2.- Agregar Masajista");
            System.out.println("3.- Agregar Entrenador");
            System.out.println("4.- Listar Futbolistas ");
            System.out.println("5.- Listar Masajistas ");
            System.out.println("6.- Listar Entrenadores ");
            System.out.println("7.- Editar Futbolista ");
            System.out.println("8.- Editar Masajista ");
            System.out.println("9.- Editar Entrenador ");
            System.out.println("10.- Buscar en Seleccion ");
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
                    System.out.println(showMasajistas());
                    break;
                case 6:
                    System.out.println(showEntrenadores());
                    break;
                case 7:
                    editFutbolista();
                    break;
                case 8:
                    editMasajista();
                    break;
                case 9:
                    editEntrenador();
                    break;
                case 10:
                    find();
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
        int id, edad, experiencia;
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
        System.out.print("Experiencia: ");
        experiencia = (rc.nextInt());

        Masajista nuevoMasajista = new Masajista(id, nombre, apellidos, edad, titulacion, experiencia);
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

        boolean futbolistaEncontrado = false;

        for (Seleccion seleccion : seleccionado) {
            if (seleccion instanceof Futbolista) {
                futbolistaEncontrado = true;
                output.append(seleccion.getId())
                        .append("\t").append(seleccion.getNombre())
                        .append("\t").append(seleccion.getApellidos())
                        .append("\t").append(seleccion.getEdad())
                        .append("\t").append(((Futbolista) seleccion).getDorsal())
                        .append("\t").append(((Futbolista) seleccion).getDemarcacion())
                        .append("\n");
            }
        }

        if (!futbolistaEncontrado) {
            output.append("--------------------------------\n");
            output.append(" No hay Futbolistas registrados\n");
            output.append("--------------------------------\n");
        }
        return output.toString();
    }

    public static String showMasajistas() {
        StringBuilder output = new StringBuilder();
        output.append("----- Listar Masajistas -----\n");

        boolean masajistasEncontrados = false;

        for (Seleccion seleccion : seleccionado) {
            if (seleccion instanceof Masajista) {
                masajistasEncontrados = true;
                output.append(seleccion.getId())
                        .append("\t").append(seleccion.getNombre())
                        .append("\t").append(seleccion.getApellidos())
                        .append("\t").append(seleccion.getEdad())
                        .append("\t").append(((Masajista) seleccion).getTitulation())
                        .append("\t").append(((Masajista) seleccion).getExperiencia())
                        .append("\n");
            }
        }

        if (!masajistasEncontrados) {
            output.append("--------------------------------\n");
            output.append(" No hay Masajistas registrados\n");
            output.append("--------------------------------\n");
        }
        return output.toString();
    }

    public static String showEntrenadores() {
        StringBuilder output = new StringBuilder();
        output.append("----- Listar Entrenadores -----\n");

        boolean entrenadoresEncontrados = false;

        for (Seleccion seleccion : seleccionado) {
            if (seleccion instanceof Entrenador) {
                entrenadoresEncontrados = true;
                output.append(seleccion.getId())
                        .append("\t").append(seleccion.getNombre())
                        .append("\t").append(seleccion.getApellidos())
                        .append("\t").append(seleccion.getEdad())
                        .append("\t").append(((Entrenador) seleccion).getIdFederacion())
                        .append("\n");
            }
        }

        if (!entrenadoresEncontrados) {
            output.append("--------------------------------\n");
            output.append(" No hay Entrenadores registrados\n");
            output.append("--------------------------------\n");
        }
        return output.toString();
    }

    public static Futbolista editFutbolista(){
        System.out.println("----------------------------------");
        System.out.println("       Editar Futbolista");
        System.out.println("----------------------------------");
        System.out.print("Ingrese el ID del Futbolista que desea editar: ");
        int id = rc.nextInt();

        Futbolista futbolistaEncontrado = null;
        for (Seleccion seleccion : seleccionado) {
            if (seleccion instanceof Futbolista && seleccion.getId() == id) {
                futbolistaEncontrado = (Futbolista) seleccion;
                break;
            }
        }

        if (futbolistaEncontrado == null) {
            System.out.println("--------------------------------------------------------");
            System.out.println("No se encontró ningún Futbolista con el ID especificado.");
            System.out.println("--------------------------------------------------------");
            return null;
        }

        // Solicitar y aplicar cambios
        System.out.print("Nombre(s): ");
        futbolistaEncontrado.setNombre(rc.next());
        System.out.print("Apellidos: ");
        futbolistaEncontrado.setApellidos(rc.next());
        System.out.print("Edad: ");
        futbolistaEncontrado.setEdad(rc.nextInt());
        System.out.print("Dorsal: ");
        futbolistaEncontrado.setDorsal(rc.nextInt());
        System.out.print("Demarcacion: ");
        futbolistaEncontrado.setDemarcacion(rc.next());

        System.out.println("--------------------------------------------------------");
        System.out.println("           Futbolista editado correctamente.");
        System.out.println("--------------------------------------------------------");
        return futbolistaEncontrado;
    }
    public static Masajista editMasajista() {
        System.out.println("----------------------------------");
        System.out.println("       Editar Masajista");
        System.out.println("----------------------------------");
        System.out.print("Ingrese el ID del Masajista que desea editar: ");
        int id = rc.nextInt();

        Masajista masajistaEncontrado = null;
        for (Seleccion seleccion : seleccionado) {
            if (seleccion instanceof Masajista && seleccion.getId() == id) {
                masajistaEncontrado = (Masajista) seleccion;
                break;
            }
        }

        if (masajistaEncontrado == null) {
            System.out.println("--------------------------------------------------------");
            System.out.println("No se encontró ningún Masajista con el ID especificado.");
            System.out.println("--------------------------------------------------------");
            return null;
        }

        // Solicitar y aplicar cambios
        System.out.print("Nombre(s): ");
        masajistaEncontrado.setNombre(rc.next());
        System.out.print("Apellidos: ");
        masajistaEncontrado.setApellidos(rc.next());
        System.out.print("Edad: ");
        masajistaEncontrado.setEdad(rc.nextInt());
        System.out.print("Titulación: ");
        masajistaEncontrado.setTitulation(rc.next());
        System.out.print("Experiencia: ");
        masajistaEncontrado.setExperiencia(rc.nextInt());

        System.out.println("--------------------------------------------------------");
        System.out.println("           Masajista editado correctamente.");
        System.out.println("--------------------------------------------------------");
        return masajistaEncontrado;
    }
    public static Entrenador editEntrenador() {
        System.out.println("----------------------------------");
        System.out.println("       Editar Entrenador");
        System.out.println("----------------------------------");
        System.out.print("Ingrese el ID del Entrenador que desea editar: ");
        int id = rc.nextInt();

        Entrenador entrenadorEncontrado = null;
        for (Seleccion seleccion : seleccionado) {
            if (seleccion instanceof Entrenador && seleccion.getId() == id) {
                entrenadorEncontrado = (Entrenador) seleccion;
                break;
            }
        }

        if (entrenadorEncontrado == null) {
            System.out.println("--------------------------------------------------------");
            System.out.println("No se encontró ningún Entrenador con el ID especificado.");
            System.out.println("--------------------------------------------------------");
            return null;
        }

        // Solicitar y aplicar cambios
        System.out.print("Nombre(s): ");
        entrenadorEncontrado.setNombre(rc.next());
        System.out.print("Apellidos: ");
        entrenadorEncontrado.setApellidos(rc.next());
        System.out.print("Edad: ");
        entrenadorEncontrado.setEdad(rc.nextInt());
        System.out.print("ID de Federación: ");
        entrenadorEncontrado.setIdFederacion(rc.next());

        System.out.println("--------------------------------------------------------");
        System.out.println("           Entrenador editado correctamente.");
        System.out.println("--------------------------------------------------------");
        return entrenadorEncontrado;
    }

    public static void find() {
        boolean encontrado = false;
        System.out.println("-----------------------------------");
        System.out.println("Ingrese el ID que desea buscar: ");
        int id = rc.nextInt();
        for (Seleccion integrante : seleccionado) {
            if (id == integrante.getId()) {
                encontrado = true;
                (integrante).Concentrarse();
                (integrante).Viajar();
                if (integrante instanceof Entrenador) {
                    ((Entrenador) integrante).DirigirPartido();
                    ((Entrenador) integrante).DirigirEntrenamiento();
                    System.out.println("--------------------------------------------------------");
                } else if (integrante instanceof Futbolista) {
                    ((Futbolista) integrante).JugarPartido();
                    ((Futbolista) integrante).Entrenar();
                    System.out.println("--------------------------------------------------------");
                } else if (integrante instanceof Masajista) {
                    ((Masajista) integrante).darMasaje();
                    System.out.println("--------------------------------------------------------");
                }
                System.out.println("=================================================");
            }
        }
        if (!encontrado) {
            System.out.println("--------------------------------------------------------");
            System.out.println("                    El id no existe.             ");
            System.out.println("--------------------------------------------------------");
            }
        }
    }
