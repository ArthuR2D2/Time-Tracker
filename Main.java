import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.time.LocalTime;
import javax.swing.UIManager;

public class Main extends JFrame implements Runnable, ActionListener{
    Informe UP;
    static boolean bcobrable=false;
    static boolean bcompletada=false;
    boolean iniciado=true;
    boolean pausa=true;
    int horainicial=0, horafinal=0, minutoinicial=0, minutofinal=0, segundoinicial=0, segundofinal=0;
    public Main(){
        JFrame framet = new JFrame("Task");
        framet.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        framet.setSize(1020, 380);

        JPanel panelArriba = new JPanel();
        JPanel panelGeneral = new JPanel();
        JPanel panelCentral1 = new JPanel();
        JPanel panelCentral2 = new JPanel();
        framet.add(panelArriba, BorderLayout.NORTH);
        framet.add(panelGeneral, BorderLayout.CENTER);
        panelGeneral.setLayout(new FlowLayout(FlowLayout.CENTER));
        panelGeneral.add(panelCentral1);
        panelGeneral.add(panelCentral2);

        panelArriba.setLayout(new GridLayout(2, 3, 90, 10));
        panelArriba.setBackground(new Color(20, 141, 141));
        panelGeneral.setBackground(new Color(20, 141, 141));
        panelCentral1.setBackground(new Color(20, 141, 141));
        panelCentral2.setBackground(new Color(20, 141, 141));

        JButton tareasbot = new JButton("TAREAS");
        JButton informebot = new JButton("INFORME");
        JLabel trash1 = new JLabel();
        JLabel trash2 = new JLabel();
        JLabel trash3 = new JLabel();
        JLabel trash4 = new JLabel();
        panelArriba.add(trash1);
        panelArriba.add(tareasbot);
        panelArriba.add(trash2);
        panelArriba.add(trash3);
        panelArriba.add(informebot);
        panelArriba.add(trash4);
        tareasbot.setBackground(new Color(26, 74, 90));
        informebot.setBackground(new Color(26, 74, 90));
        tareasbot.setForeground(new Color(160, 225, 167));
        informebot.setForeground(new Color(160, 225, 167));

        panelCentral1.setLayout(new GridLayout(6, 4, 90, 0));
        panelCentral2.setLayout(new GridLayout(1, 2));

        JLabel a1 = new JLabel("NOMBRE DE LA TAREA");
        JLabel a2 = new JLabel("DESCRIPCION DE LA TAREA");
        JLabel a3 = new JLabel("CRONOMETRO");
        JLabel a4 = new JLabel("AGREGAR TAREA");
        JLabel a5 = new JLabel("COMENZAR TIEMPO");
        JLabel a6 = new JLabel("REINICIAR TIEMPO");
        JLabel a7 = new JLabel("DETENER TIEMPO");
        JLabel a8 = new JLabel("DINERO TOTAL GANADO");
        JLabel a9 = new JLabel("INICIO DEL TIEMPO");
        JLabel a10 = new JLabel("FINAL DEL TIEMPO");
        JLabel a11 = new JLabel("TIEMPO COBRABLE");
        JLabel a12 = new JLabel("COMPLETADA");

        b1 = new JTextField(".");
        b2 = new JTextField("");
        b3 = new JLabel("00:00:00:000");
        JButton b4 = new JButton("+");
        JButton b5 = new JButton("PLAY");
        JButton b6 = new JButton("RESET");
        JButton b7 = new JButton("STOP");
        b8 = new JTextField("");
        b9 = new JLabel("00:00:00");
        b10 = new JLabel("00:00:00");
        b11 = new JButton("NO COBRABLE");
        b12 = new JButton("NO COMPLETADA");
        panelCentral1.add(a1);
        panelCentral1.add(a2);
        panelCentral1.add(a3);
        panelCentral1.add(a4);
        panelCentral1.add(b1);
        panelCentral1.add(b2);
        panelCentral1.add(b3);
        panelCentral1.add(b4);
        panelCentral1.add(a5);
        panelCentral1.add(a6);
        panelCentral1.add(a7);
        panelCentral1.add(a8);
        panelCentral1.add(b5);
        panelCentral1.add(b6);
        panelCentral1.add(b7);
        panelCentral1.add(b8);
        panelCentral1.add(a9);
        panelCentral1.add(a10);
        panelCentral1.add(a11);
        panelCentral1.add(a12);
        panelCentral1.add(b9);
        panelCentral1.add(b10);
        panelCentral1.add(b11);
        panelCentral1.add(b12);
        b11.setBackground(Color.RED);
        b12.setBackground(Color.RED);
        b1.setBackground(new Color(160, 225, 167));
        b2.setBackground(new Color(160, 225, 167));
        b4.setBackground(new Color(239, 188, 117));
        b5.setBackground(new Color(239, 188, 117));
        b6.setBackground(new Color(239, 188, 117));
        b7.setBackground(new Color(239, 188, 117));
        b8.setBackground(new Color(160, 225, 167));

        JButton botonfinall = new JButton("CREAR INFORME");
        botonfinall.setBackground(new Color(239, 188, 117));
        panelCentral2.add(botonfinall);

        framet.setVisible(true);
        panelArriba.setVisible(true);
        panelCentral1.setVisible(true);
        panelCentral2.setVisible(false);

        ActionListener btareasbot = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                panelCentral2.setVisible(false);
                panelCentral1.setVisible(true);
            }
        };
        tareasbot.addActionListener(btareasbot);
        ActionListener binformebot = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                panelCentral1.setVisible(false);
                panelCentral2.setVisible(true);
            }
        };
        informebot.addActionListener(binformebot);

        ActionListener bb11 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                if(bcobrable){
                    bcobrable=false;
                    b11.setBackground(Color.RED);
                    b11.setText("NO COBRABLE");
                } else{
                    bcobrable=true;
                    b11.setBackground(Color.GREEN);
                    b11.setText("COBRABLE");
                }
            }
        };
        b11.addActionListener(bb11);

        ActionListener bb12 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                if(bcompletada){
                    bcompletada=false;
                    b12.setBackground(Color.RED);
                    b12.setText("NO COMPLETADA");
                } else{
                    bcompletada=true;
                    b12.setBackground(Color.GREEN);
                    b12.setText("COMPLETADA");
                }
            }
        };
        b12.addActionListener(bb12);

        ActionListener lamentable = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                UP.crearInforme();
            }
        };
        botonfinall.addActionListener(lamentable);

        ActionListener bb4 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                Tarea t = new Tarea(0, 0, 0, 0, 0, 0, b1.getText(), b2.getText(), bcobrable, b8.getText(), bcompletada);
                UP = new Informe(t, b9.getText(), b10.getText(), t.getDuracion());
                b1.setText("."); b2.setText("");
                b3.setText("00:00:00:000");
                b8.setText("");
                b9.setText("00:00:00");
                b10.setText("00:00:00");
                bcobrable=false;
                bcompletada=false;
                b11.setBackground(Color.RED);
                b12.setBackground(Color.RED);
                b12.setText("NO COMPLETADA");
            }
        };
        b4.addActionListener(bb4);

        b5.addActionListener(this);
        b6.addActionListener(this);
        b7.addActionListener(this);
    }
    public void run(){
        int hora=0, minuto=0, segundo=0, milesima=0;
        String ho="", mi="", se="", mili="";
        try{
            if(pausar==false){
                while(cronometroActivo){
                    Thread.sleep(4);
                    milesima+=4;
                    if(milesima==1000){
                        milesima=0;
                        segundo+=1;
                        if(segundo==60){
                            segundo=0;
                            minuto+=1;
                            if(minuto==60){
                                minuto=0;
                                hora+=1;
                            }
                        }
                    }
                    if(hora<10) ho = "0" + hora;
                    else ho = "" + hora;
                    if(minuto<10) mi = "0" + minuto;
                    else mi = "" + minuto;
                    if(segundo<10) se = "0" + segundo;
                    else se = "" + segundo;
                    if(milesima<10) mi = "00" + milesima;
                    else if(milesima<100) mili = "0" + milesima;
                    else mili = "" + milesima;
                    b3.setText(ho + ":" + mi + ":" + se + ":" + mili);
                }
            }
            b3.setText(ho + ":" + mi + ":" + se + ":" + mili);
        } catch(Exception ev){}
        if(pausar==false){ b3.setText("00:00:00:000"); }
    }
    public void actionPerformed(ActionEvent evt){
        Object o = evt.getSource();
        if(o instanceof JButton){
            JButton btn = (JButton)o;
            if(btn.getText().equals("PLAY")){
                iniciarCronometro();
            }
            if(btn.getText().equals("RESET")){
                reiniciarCronometro();
            }
            if(btn.getText().equals("STOP")){
                pararCronometro();
            }
        }
    }
    public void iniciarCronometro(){
        if(iniciado){
            LocalTime hora_ = LocalTime.now();
            horainicial=hora_.getHour();
            minutoinicial=hora_.getMinute();
            segundoinicial=hora_.getSecond();
            b9.setText((horainicial<10?"0":"") + horainicial + ":" + (minutoinicial<10?"0":"") + minutoinicial + ":" + (segundoinicial<10?"0":"") + segundoinicial);
            cronometroActivo=true;
            pausar=false;
            hilo = new Thread(this);
            hilo.start();
            iniciado=false;
        }
    }
    public void pararCronometro(){
        LocalTime hora_ = LocalTime.now();
        horafinal=hora_.getHour();
        minutofinal=hora_.getMinute();
        segundofinal=hora_.getSecond();
        b10.setText((horafinal<10?"0":"") + horafinal + ":" + (minutofinal<10?"0":"") + minutofinal + ":" + (segundofinal<10?"0":"") + segundofinal);
        if(pausa){
            iniciado=true;
            cronometroActivo=false;
            pausar=true;
            pausa=false;
        } else if(pausa==false){
            iniciado=false;
            cronometroActivo=true;
            pausar=false;
            pausa=true;
        }
        
    }
    public void reiniciarCronometro(){
        b3.setText("00:00:00:000");
        cronometroActivo=false;
        iniciado=true;
        pausar=false;
        LocalTime hora_ = LocalTime.now();
        horafinal=hora_.getHour();
        minutofinal=hora_.getMinute();
        segundofinal=hora_.getSecond();
        b10.setText((horafinal<10?"0":"") + horafinal + ":" + (minutofinal<10?"0":"") + minutofinal + ":" + (segundofinal<10?"0":"") + segundofinal);
        Tarea t = new Tarea(horainicial, minutoinicial, segundoinicial, horafinal, minutofinal, segundofinal, 
        b1.getText(), b2.getText(), bcobrable, b8.getText(), bcompletada);
        UP = new Informe(t, b9.getText(), b10.getText(), t.getDuracion());
        b1.setText("."); b2.setText("");
        b3.setText("00:00:00:000");
        b8.setText("");
        b9.setText("00:00:00");
        b10.setText("00:00:00");
        bcobrable=false;
        bcompletada=false;
        b11.setBackground(Color.RED);
        b12.setBackground(Color.RED);
        b12.setText("NO COMPLETADA");
    }

    public static void main(String[] args){
        new Main();
    }
    JTextField b1, b2, b8;
    JLabel b3, b9, b10;
    JButton b11, b12;
    boolean cronometroActivo;
    Thread hilo;
    boolean pausar;
}
