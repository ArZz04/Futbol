public class Futbolista extends Seleccion {

    private int dorsal;
    private String demarcacion;

    public Futbolista(int id, String nombre, String apellidos, int edad, int dorsal, String demarcacion) {
        super(id, nombre, apellidos, edad);
        this.dorsal = dorsal;
        this.demarcacion = demarcacion;
    }

    public int getDorsal() {
        return dorsal;
    }

    public void setDorsal(int dorsal) {
        this.dorsal = dorsal;
    }

    public String getDemarcacion() {
        return demarcacion;
    }

    public void setDemarcacion(String demarcacion) {
        this.demarcacion = demarcacion;
    }

    public void JugarPartido(){
        System.out.println("----------| Futbolista / Partido |----------");
        System.out.println("Nombre(s): " + getNombre() + " | Apellidos: " + getApellidos());
        System.out.println("- Estoy jugando un partido");
    }
    public void Entrenar(){
        System.out.println("-----------| Futbolista / Entrenamiento |----------");
        System.out.println("Nombre(s): " + getNombre() + " | Apellidos: " + getApellidos());
        System.out.println("- Estoy entrenando");
    }
}
