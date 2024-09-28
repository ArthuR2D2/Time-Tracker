public abstract class Tiempo{
    public int horai=0;
    public int minutoi=0;
    public int segundoi=0;
    public int horaf=0;
    public int minutof=0;
    public int segundof=0;
    public long duracion=0;

    public Tiempo(){
        horai=0;
        minutoi=0;
        segundoi=0;
        horaf=0;
        minutof=0;
        segundof=0;
        duracion=0;
    }

    public Tiempo(int horas, int minutos, int segundos, int horas2, int minutos2, int segundos2){
        horai=horas;
        minutoi=minutos;
        segundoi=segundos;
        horaf=horas2;
        minutof=minutos2;
        segundof=segundos2;
        duracion=-1;
    }

    public String getTInicio(){
        String texto="";
        if(horai<10) texto+="0"+horai; else texto+=horai;
        if(minutoi<10) texto+="0"+minutoi; else texto+=minutoi;
        if(segundoi<10) texto+="0"+segundoi; else texto+=segundoi;
        return texto;
    }
    public String getTFinal(){
        String texto="";
        if(horaf<10) texto+="0"+horaf; else texto+=horaf;
        if(minutoi<10) texto+="0"+minutoi; else texto+=minutof;
        if(segundof<10) texto+="0"+segundof; else texto+=segundof;
        return texto;
    }
    public long getDuracion(){
        int x=horaf-horai;
        x*=3600;
        int y=minutof-minutoi;
        y*=60;
        int z=segundof-segundoi;
        return (x+y+z);
    }

    public abstract void setTInicio(int horas, int minutos, int segundos);
    public abstract void setTFinal(int horas, int minutos, int segundos);
}