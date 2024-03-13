public class Masajista extends Seleccion {

    private String titulation;
    private int experiencia;

    public Masajista(int id, String nombre, String apellidos, int edad, String titulation){
        super(id, nombre, apellidos, edad);
        this.titulation = titulation;
        this.experiencia = experiencia;
    }

    public String getTitulation(){
        return titulation;
    }

    public void setTitulation(String titulation){
        this.titulation = titulation;
    }

    public int getExperiencia(){
        return experiencia;
    }

    public void setExperiencia(int experiencia){
        this.experiencia = experiencia;
    }

    public void darMasaje(){

    };

}