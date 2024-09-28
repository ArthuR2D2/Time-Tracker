import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.*;
import java.util.ArrayList;
import java.io.FileWriter;
import java.io.IOException;

public class Informe{
    public boolean principal=true;
    public ArrayList<Tarea> Tareas = new ArrayList<Tarea>();
    public long duraciontotal=0;
    public String iniciototal;
    public String fintotal;
    public int contador=1;

    public Informe(Tarea t, String inicio, String fin, long dura){
        if(principal){
            iniciototal=inicio;
            principal=false;
        }
        Tareas.add(t);
        duraciontotal+=dura;
        if(!(fin.equals("00:00:00"))){
            fintotal=fin;
        }
    }
    public void crearInforme(){
        String last = "";
        last += "Primera tarea a la hora: " + iniciototal + ".\nUltima tarea a la hora: " + fintotal + ".\nDuracion Total : " + duraciontotal + ".\n";
        last += "Tiene un total de " + Tareas.size() + " tareas.\n";
        for(int i=0; i<Tareas.size(); i++){
            String s = "";
            s += "NOMBRE: " + (Tareas.get(i)).getNombre() + ".\nDESCRIPCIÓN: " + (Tareas.get(i)).getDescripcion()+".\n";
            s += ((Tareas.get(i)).esCobrable()==true? "SI ES COBRABLE" : "NO ES COBRABLE") + ".\nGENERÓ $" + (Tareas.get(i)).getDinero() + " PESOS.\n";
            s += ((Tareas.get(i)).esCompletada()==true? "Y FINALMENTE SI FUE COMPLETADA." : "Y FINALMENTE, NO FUE COMPLETADA.") + "\n\n\n";
            last+=s;
        }
        try{
            FileWriter myWriter = new FileWriter("Hello"+contador+".txt");
            contador++;
            myWriter.write(last);
            myWriter.close();
        } catch(IOException e){
            System.out.println("Error404");
        }
        
    }
}
