public class Tarea extends Tiempo{
    private String nombre;
    private String descripcion;
    private boolean cobrar;
    private String dinerogenerado;
    private boolean completada;
    
    public Tarea(){
        nombre="";
        descripcion="";
        cobrar=false;
        dinerogenerado="0.0";
        completada=false;
    }
    public Tarea(int horas, int minutos, int segundos, int horas2, int minutos2, int segundos2,
    String nombre, String descripcion, boolean cobrar, String dinerogenerado, boolean completada){
        super(horas, minutos, segundos, horas2, minutos2, segundos2);
        this.nombre=nombre;
        this.descripcion=descripcion;
        this.dinerogenerado=dinerogenerado;
        this.completada=completada;
    }
    public String getNombre(){
        return this.nombre;
    }
    public String getDescripcion(){
        return this.descripcion;
    }
    public boolean esCobrable(){
        if(this.cobrar){
            return true;
        } else return false;
    }
    public String getDinero(){
        return this.dinerogenerado;
    }
    public boolean esCompletada(){
        if(this.completada){
            return true;
        } else return false;
    }
    public void setNombre(String nombre){
        this.nombre=nombre;
        return;
    }
    public void setDescripcion(String descripcion){
        this.descripcion=descripcion;
        return;
    }
    public void cambiarCobro(){
        if(this.cobrar){
            this.cobrar=false;
        } else {
            this.cobrar=true;
        }
        return;
    }
    public void setDinero(String dinerogenerado){
        this.dinerogenerado= dinerogenerado;
        return;
    }
    public void cambiarCompleta(){
        if(this.completada){
            this.completada=false;
        } else {
            this.completada=true;
        }
        return;
    }
    @Override
    public void setTInicio(int horas, int minutos, int segundos){
        this.horai=horas;
        this.minutoi=minutos;
        this.segundoi=segundos;
        return;
    }
    @Override
    public void setTFinal(int horas, int minutos, int segundos){
        this.horaf=horas;
        this.minutof=minutos;
        this.segundof=segundos;
        return;
    }
}