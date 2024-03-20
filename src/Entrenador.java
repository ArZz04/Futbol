public class Entrenador extends Seleccion {

    private String idFederacion;

    public Entrenador(int id, String nombre, String apellidos, int edad, String idFederacion) {
        super(id, nombre, apellidos, edad);
        this.idFederacion = idFederacion;
    }

    public String getIdFederacion() {
        return idFederacion;
    }

    public void setIdFederacion(String idFederacion) {
        this.idFederacion = idFederacion;
    }

    public void DirigirPartido(){
        System.out.println("----------| Entrenador / Partido |----------");
        System.out.println("Nombre(s): " + getNombre() + " | Apellidos: " + getApellidos());
        System.out.println("- Estoy dirigiendo un partido");
    }
    public void DirigirEntrenamiento(){
        System.out.println("----------| Entrenador / Entrenamiento |----------");
        System.out.println("Nombre(s): " + getNombre() + " | Apellidos: " + getApellidos());
        System.out.println("- Estoy dirigiendo un entrenamiento");
    }
}
