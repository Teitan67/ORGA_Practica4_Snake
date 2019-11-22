/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package snake;

import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.Timer;

/**
 *
 * @author vanes
 */
public class Juego extends javax.swing.JFrame implements KeyListener {

    /**
     * Creates new form Juego
     */
    String nombre;
    int pos;
    boolean pause = true;
    ArrayList<Serpiente> serpiente = new ArrayList();
    ArrayList<JLabel> obstaculos = new ArrayList();
    ArrayList<Integer> PosObstaculo = new ArrayList();

    JLabel obs3, obs4;
    int puntos, nivel;
    Timer t;
    int x, y, desplazamiento = 55;
    Rectangle serp;
    Rectangle comi;
    int aux;
    int contador;
    Rectangle obst1, obst2, obst3, obst4, obst5, obst6, obst7, obst8, obst9, obst10;
    JLabel obs5;
    JLabel obs6, obs7, obs8, obs9, obs10;
    //comida
    int cx = 0, cy = 0;
    JLabel comida = new JLabel();
    int minutos;
    int segundos;
    //matriz
    int[][] matriz;
    ArrayList<Integer> coordenadas = new ArrayList();

    public void posComida() {

        if ((comida.getX() >= 0 && comida.getX() <= 220 && (comida.getY() == 0 || comida.getY() >= 605))
                || (comida.getX() >= 440 && comida.getX() <= 605 && (comida.getY() == 0 || comida.getY() >= 605))) {
            System.out.println("se intersecto");
            int a = (int) Math.floor(Math.random() * (PosObstaculo.size()));
            int b = (int) Math.floor(Math.random() * (PosObstaculo.size()));
            cx = PosObstaculo.get(a);
            cy = PosObstaculo.get(b);
            comida.setLocation(cx, cy);
            comi.setBounds(comida.getBounds());
            System.out.println("Posición en X:"+ comida.getX()+"Posicion en Y:"+ comida.getY());
            posComida();
        }
    }
    
    public void posComida2(){
        if((comida.getY()>=0 && comida.getY()<=165 &&(comida.getX()==0 || comida.getX()>=605)) || (comida.getY()>=440 &&
                comida.getY()<=550 && (comida.getX()==0 || comida.getX()>=605))){
             System.out.println("se intersecto");
            int a = (int) Math.floor(Math.random() * (PosObstaculo.size()));
            int b = (int) Math.floor(Math.random() * (PosObstaculo.size()));
            cx = PosObstaculo.get(a);
            cy = PosObstaculo.get(b);
            comida.setLocation(cx, cy);
            comi.setBounds(comida.getBounds());
               System.out.println("Posición en X:"+ comida.getX()+"Posicion en Y:"+ comida.getY());
            posComida2();
        }
        
      
            }
      public void posComida3(){
            if((comida.getX()>=220 && comida.getX()<=385 && (comida.getY()==220 || comida.getY()==385))){
                  System.out.println("se intersecto");
            int a = (int) Math.floor(Math.random() * (PosObstaculo.size()));
            int b = (int) Math.floor(Math.random() * (PosObstaculo.size()));
            cx = PosObstaculo.get(a);
            cy = PosObstaculo.get(b);
            comida.setLocation(cx, cy);
            comi.setBounds(comida.getBounds());
               System.out.println("Posición en X:"+ comida.getX()+"Posicion en Y:"+ comida.getY());
            posComida3();
            }
        }
    public ActionListener acciones = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            ++segundos;
            if (segundos > 59) {
                segundos = 0;
                ++minutos;
            }
            Actualizar();
        }
    };

    public Juego() {
        initComponents();
        componentesNivel1();
        this.setSize(937, 685);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.addKeyListener(this);
        aux = 0;
        puntos = 0;
        nivel = 1;
        contador = 0;
        t = new Timer(1000, acciones);
    }
    ArrayList<Solicitud> usuarios;
    ArrayList<Aprobados> aprobados;

    public Juego(ArrayList<Solicitud> usuarios, ArrayList<Aprobados> aprobados, int pos) {
        this.usuarios = usuarios;
        this.aprobados = aprobados;
        this.pos = pos;
        initComponents();
        componentesNivel1();
        this.setSize(937, 685);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.addKeyListener(this);
        aux = 0;
        puntos = 0;
        nivel = 1;
        contador = 0;
        t = new Timer(1000, acciones);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lblpuntos = new javax.swing.JLabel();
        lbltiempo = new javax.swing.JLabel();
        lblnivel = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        panelJuego = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(204, 204, 0));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/snake22(1)_1.png"))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Ravie", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Puntuación:");

        jLabel3.setFont(new java.awt.Font("Ravie", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Tiempo:");

        jLabel4.setFont(new java.awt.Font("Ravie", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Nivel:");

        lblpuntos.setFont(new java.awt.Font("Ravie", 0, 18)); // NOI18N
        lblpuntos.setForeground(new java.awt.Color(0, 0, 0));
        lblpuntos.setText("0");

        lbltiempo.setFont(new java.awt.Font("Ravie", 0, 18)); // NOI18N
        lbltiempo.setForeground(new java.awt.Color(0, 0, 0));
        lbltiempo.setText("00:00");

        lblnivel.setFont(new java.awt.Font("Ravie", 0, 18)); // NOI18N
        lblnivel.setForeground(new java.awt.Color(0, 0, 0));
        lblnivel.setText("1");

        jLabel5.setBackground(new java.awt.Color(204, 204, 0));
        jLabel5.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 0, 0));
        jLabel5.setText("Iniciar de nuevo");
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
        });

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/icons8_Back_64px.png"))); // NOI18N
        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel6MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addGap(18, 18, 18)
                                        .addComponent(lbltiempo, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lblnivel, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblpuntos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jLabel5)
                .addGap(29, 29, 29)
                .addComponent(jLabel6)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(lblpuntos, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(49, 49, 49)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(lbltiempo, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(60, 60, 60)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(lblnivel, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addContainerGap())
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 0, 270, 660));

        javax.swing.GroupLayout panelJuegoLayout = new javax.swing.GroupLayout(panelJuego);
        panelJuego.setLayout(panelJuegoLayout);
        panelJuegoLayout.setHorizontalGroup(
            panelJuegoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 660, Short.MAX_VALUE)
        );
        panelJuegoLayout.setVerticalGroup(
            panelJuegoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 660, Short.MAX_VALUE)
        );

        getContentPane().add(panelJuego, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 660, 660));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked

        Juego juego = new Juego(usuarios, aprobados, pos);
        juego.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel5MouseClicked

    private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseClicked
        t.stop();
        switch (nivel) {
            case 1:
                tiempo.stop();
                break;
            case 2:
                tiempo2.stop();
                break;
            case 3:
                tiempo3.stop();
                break;
            default:

                break;

        }
        Snake s = new Snake(usuarios, aprobados, pos);
        s.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel6MouseClicked

    public void ActualizarInfo() {
        int puntos = Integer.parseInt(aprobados.get(pos).getEstado().getPuntos());
        int nivel = Integer.parseInt(aprobados.get(pos).getEstado().getNivel());
        String[] tiempo = aprobados.get(pos).getEstado().getTiempo().split(":");
        int min = 0, seg = 0;
        char tt = tiempo[0].charAt(0);
        if (tiempo[0].charAt(0) == '0') {

            min = Integer.parseInt(String.valueOf(tiempo[0].charAt(1)));
        }
        if (tiempo[1].charAt(0) == '0') {

            seg = Integer.parseInt(String.valueOf(tiempo[1].charAt(1)));
        }

        if (Integer.parseInt(lblpuntos.getText()) > puntos) {
            aprobados.get(pos).getEstado().setPuntos(lblpuntos.getText());
        }
        if (Integer.parseInt(lblnivel.getText()) > nivel) {
            aprobados.get(pos).getEstado().setNivel(lblnivel.getText());
        }
        String[] tiempoA = lbltiempo.getText().split(":");
        int minA = 0, segA = 0;

        if (tiempoA[0].charAt(0) == '0') {

            minA = Integer.parseInt(String.valueOf(tiempoA[0].charAt(1)));
        } else {
            minA = Integer.parseInt(String.valueOf(tiempoA[0]));
        }
        if (tiempoA[1].charAt(0) == '0') {

            segA = Integer.parseInt(String.valueOf(tiempoA[1].charAt(1)));
        } else {
            segA = Integer.parseInt(String.valueOf(tiempoA[1]));
        }
        if (minA > min) {
            aprobados.get(pos).getEstado().setTiempo(lbltiempo.getText());
        } else if (minA == min) {
            if (segA > seg) {
                aprobados.get(pos).getEstado().setTiempo(lbltiempo.getText());
            }
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Juego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Juego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Juego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Juego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Juego().setVisible(true);
            }
        });
    }

    public void UbicacionSerpiente(int x, int y, int comidaX, int comidaY) {

        for (int i = 0; i < coordenadas.size(); i++) {
            for (int j = 0; j < coordenadas.size(); j++) {
                if (x == coordenadas.get(i) && y == coordenadas.get(j)) {
                    matriz[j][i] = 1;
                }
                if (comidaX == coordenadas.get(i) && comidaY == coordenadas.get(j)) {
                    matriz[j][i] = 1;
                }
            }
        }

    }

    public void UbicacionComida(int x, int y) {
        for (int i = 0; i < coordenadas.size(); i++) {
            for (int j = 0; j < coordenadas.size(); j++) {
                if (x == coordenadas.get(i) && y == coordenadas.get(j)) {
                    matriz[j][i] = 1;
                }

            }
        }
    }

    public void componentesNivel1() {
        coordenadas.add(0);
        coordenadas.add(55);
        coordenadas.add(110);
        coordenadas.add(165);
        coordenadas.add(220);
        coordenadas.add(275);
        coordenadas.add(330);
        coordenadas.add(385);
        coordenadas.add(440);
        coordenadas.add(495);
        coordenadas.add(550);
        coordenadas.add(605);

        JLabel fondo;
        fondo = new JLabel();
        fondo.setSize(panelJuego.getSize());
        fondo.setVisible(true);
        fondo.setIcon(new ImageIcon("src\\Recursos\\fondo2.png"));

        JLabel obs1 = new JLabel();
        obs1.setVisible(true);
        obs1.setBounds(0, 0, 220, 55);
        obs1.setIcon(new ImageIcon("src\\Recursos\\obs3.png"));

        JLabel obs2 = new JLabel();
        obs2.setVisible(true);
        obs2.setBounds(0, 605, 220, 55);
        obs2.setIcon(new ImageIcon("src\\Recursos\\obs3.png"));

        obs3 = new JLabel();
        obs3.setVisible(true);
        obs3.setBounds(440, 0, 220, 55);
        obs3.setIcon(new ImageIcon("src\\Recursos\\obs3.png"));

        obs4 = new JLabel();
        obs4.setVisible(true);
        obs4.setBounds(440, 605, 220, 55);
        obs4.setIcon(new ImageIcon("src\\Recursos\\obs3.png"));

        obs5 = new JLabel();
        obs5.setVisible(false);
        obs5.setBounds(0, 55, 55, 165);
        obs5.setIcon(new ImageIcon("src\\Recursos\\obs5.png"));

        obs6 = new JLabel();
        obs6.setVisible(false);
        obs6.setBounds(0, 440, 55, 165);
        obs6.setIcon(new ImageIcon("src\\Recursos\\obs5.png"));

        obs7 = new JLabel();
        obs7.setVisible(false);
        obs7.setBounds(605, 55, 55, 165);
        obs7.setIcon(new ImageIcon("src\\Recursos\\obs5.png"));

        obs8 = new JLabel();
        obs8.setVisible(false);
        obs8.setBounds(605, 440, 55, 165);
        obs8.setIcon(new ImageIcon("src\\Recursos\\obs5.png"));

        obs9 = new JLabel();
        obs9.setVisible(false);
        obs9.setBounds(220, 220, 220, 55);
        obs9.setIcon(new ImageIcon("src\\Recursos\\obs3.png"));

        obs10 = new JLabel();
        obs10.setVisible(false);
        obs10.setBounds(220, 385, 220, 55);
        obs10.setIcon(new ImageIcon("src\\Recursos\\obs3.png"));

        obstaculos.add(obs1);
        obstaculos.add(obs2);
        obstaculos.add(obs3);
        obstaculos.add(obs4);
        obstaculos.add(obs5);
        obstaculos.add(obs6);
        obstaculos.add(obs7);
        obstaculos.add(obs8);
        obstaculos.add(obs9);
        obstaculos.add(obs10);
        panelJuego.add(obstaculos.get(0), 0);
        panelJuego.add(obstaculos.get(1), 0);
        panelJuego.add(obstaculos.get(2), 0);
        panelJuego.add(obstaculos.get(3), 0);
        panelJuego.add(obstaculos.get(4), 0);
        panelJuego.add(obstaculos.get(5), 0);
        panelJuego.add(obstaculos.get(6), 0);
        panelJuego.add(obstaculos.get(7), 0);
        panelJuego.add(obstaculos.get(8), 0);
        panelJuego.add(obstaculos.get(9), 0);

        ObstaculosRectangulos();

        JLabel cuerpis = new JLabel();
        cuerpis.setSize(55, 55);
        cuerpis.setLocation(110, 330);
        cuerpis.setIcon(new ImageIcon("src\\Recursos\\cuerpo.png"));
        cuerpis.setVisible(true);

        JLabel cuerpis2 = new JLabel();
        cuerpis2.setSize(55, 55);
        cuerpis2.setLocation(55, 330);
        cuerpis2.setIcon(new ImageIcon("src\\Recursos\\cuerpo.png"));
        cuerpis2.setVisible(true);

        JLabel cuerpis3 = new JLabel();
        cuerpis3.setSize(55, 55);
        cuerpis3.setLocation(0, 330);
        cuerpis3.setIcon(new ImageIcon("src\\Recursos\\cuerpo.png"));
        cuerpis3.setVisible(true);

        comida.setIcon(new ImageIcon("src\\Recursos\\comida.png"));
        PosObstaculo.add(0);
        PosObstaculo.add(55);
        PosObstaculo.add(110);
        PosObstaculo.add(165);
        PosObstaculo.add(220);
        PosObstaculo.add(275);
        PosObstaculo.add(330);
        PosObstaculo.add(385);
        PosObstaculo.add(440);
        PosObstaculo.add(495);
        PosObstaculo.add(550);
        PosObstaculo.add(605);

        serpiente.add(new Serpiente(cuerpis, new Rectangle(cuerpis.getBounds())));
        serpiente.add(new Serpiente(cuerpis2, new Rectangle(cuerpis2.getBounds())));
        serpiente.add(new Serpiente(cuerpis3, new Rectangle(cuerpis3.getBounds())));

        panelJuego.add(serpiente.get(0).getCuerpo(), 0);
        panelJuego.add(serpiente.get(1).getCuerpo(), 0);
        panelJuego.add(serpiente.get(2).getCuerpo(), 0);
        int a = (int) Math.floor(Math.random() * (PosObstaculo.size()));
        int b = (int) Math.floor(Math.random() * (PosObstaculo.size()));

        cx = Integer.parseInt(PosObstaculo.get(a).toString());
        cy = Integer.parseInt(PosObstaculo.get(b).toString());
        comida.setBounds(cx, cy,55,55);
        comi=new Rectangle(comida.getBounds());
      
        System.out.println("Posición en X actual:"+ comida.getX()+"Posicion en Y actual:"+ comida.getY());
        posComida();
        matriz = new int[12][12];
        UbicacionComida(cx, cy);
        matriz[6][0] = 1;
        matriz[6][1] = 1;
        matriz[6][2] = 1;
        UbicacionObstaculos1();
        imprimir();
        serp = new Rectangle(serpiente.get(0).getCuerpo().getBounds());
        comi = new Rectangle(comida.getBounds());

        comida.setVisible(true);

        panelJuego.add(comida, 0);
        panelJuego.add(fondo);

    }

    public void ObstaculosRectangulos() {
        obst1 = new Rectangle(obstaculos.get(0).getBounds());
        obst2 = new Rectangle(obstaculos.get(1).getBounds());
        obst3 = new Rectangle(obstaculos.get(2).getBounds());
        obst4 = new Rectangle(obstaculos.get(3).getBounds());
        obst5 = new Rectangle(obstaculos.get(4).getBounds());
        obst6 = new Rectangle(obstaculos.get(5).getBounds());
        obst7 = new Rectangle(obstaculos.get(6).getBounds());
        obst8 = new Rectangle(obstaculos.get(7).getBounds());
        obst9 = new Rectangle(obstaculos.get(8).getBounds());
        obst10 = new Rectangle(obstaculos.get(9).getBounds());
    }

    public void UbicacionObstaculos1() {
        matriz[0][0] = 1;
        matriz[0][1] = 1;
        matriz[0][2] = 1;
        matriz[0][3] = 1;

        matriz[0][8] = 1;
        matriz[0][9] = 1;
        matriz[0][10] = 1;
        matriz[0][11] = 1;

        matriz[11][0] = 1;
        matriz[11][1] = 1;
        matriz[11][2] = 1;
        matriz[11][3] = 1;

        matriz[11][8] = 1;
        matriz[11][9] = 1;
        matriz[11][10] = 1;
        matriz[11][11] = 1;
        //

    }

    public void UbicacionObstaculos2() {
        matriz[1][0] = 1;
        matriz[2][0] = 1;
        matriz[3][0] = 1;

        matriz[1][11] = 1;
        matriz[2][11] = 1;
        matriz[3][11] = 1;

        matriz[8][11] = 1;
        matriz[9][11] = 1;
        matriz[10][11] = 1;
    }

    public void UbicacionObstaculos3() {
        matriz[4][4] = 1;
        matriz[4][5] = 1;
        matriz[4][6] = 1;
        matriz[4][7] = 1;

        matriz[7][5] = 1;
        matriz[7][6] = 1;
        matriz[7][7] = 1;
        matriz[7][4] = 1;

    }
    Timer tiempo = new Timer(500, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {

            comi.setBounds(comida.getBounds());
            serp.setBounds(serpiente.get(0).getCuerpo().getBounds());

            if (comi.intersects(serp)) {
                puntos += 5;
                lblpuntos.setText(String.valueOf(puntos));
                contador++;
                if (contador == 10) {

                    nivel++;
                    contador = 0;
                    tiempo.stop();
                    tiempo2.start();
                    lblnivel.setText(String.valueOf(nivel));
                    obstaculos.get(4).setVisible(true);
                    obstaculos.get(5).setVisible(true);
                    obstaculos.get(6).setVisible(true);
                    obstaculos.get(7).setVisible(true);
                }

                int a = (int) Math.floor(Math.random() * (PosObstaculo.size()));
                int b = (int) Math.floor(Math.random() * (PosObstaculo.size()));

                cx = Integer.parseInt(PosObstaculo.get(a).toString());
                cy = Integer.parseInt(PosObstaculo.get(b).toString());
                comida.setBounds(cx, cy,55,55);
                comi.setBounds(comida.getBounds());
                   System.out.println("Posición en X actual:"+ comida.getX()+"Posicion en Y actual:"+ comida.getY());
                posComida();
                
                comida.repaint();

                System.out.println("Comió");
                JLabel cuerpo = new JLabel();
                cuerpo.setSize(55, 55);
                cuerpo.setIcon(new ImageIcon("src\\Recursos\\cuerpo.png"));
                cuerpo.setVisible(true);
                serpiente.add(new Serpiente(cuerpo, new Rectangle(cuerpo.getBounds())));
                panelJuego.add(serpiente.get(serpiente.size() - 1).getCuerpo(), 0);

            }
            if (obst1.intersects(serp) || obst2.intersects(serp) || obst3.intersects(serp) || obst4.intersects(serp)) {
                tiempo.stop();
                t.stop();
                System.out.println("Perdió");
                JOptionPane.showMessageDialog(null, "¡Has perdido!");
                ActualizarInfo();
            } else {
                matriz = new int[12][12];
                UbicacionSerpiente(serpiente.get(0).getCuerpo().getX(), serpiente.get(0).getCuerpo().getY(), cx, cy);
                 UbicacionSerpiente(serpiente.get(1).getCuerpo().getX(), serpiente.get(1).getCuerpo().getY(), cx, cy);
                  UbicacionSerpiente(serpiente.get(2).getCuerpo().getX(), serpiente.get(2).getCuerpo().getY(), cx, cy);
                if (serpiente.get(0).getCuerpo().getX() < 650 && serpiente.get(0).getCuerpo().getX() >= 0
                        && serpiente.get(0).getCuerpo().getY() > -10 && serpiente.get(0).getCuerpo().getY() < 650) {

                    for (int i = serpiente.size() - 1; i > 0; i--) {
                        UbicacionSerpiente(serpiente.get(i).getCuerpo().getX(), serpiente.get(i).getCuerpo().getY(), cx, cy);
                        UbicacionObstaculos1();
                        imprimir();
                        serpiente.get(i).getCuerpo().setLocation(serpiente.get(i - 1).getCuerpo().getLocation());
                        serpiente.get(i).getInterseccion().setBounds(serpiente.get(i - 1).getCuerpo().getBounds());
                        serpiente.get(i).getCuerpo().repaint();

                       
                        System.out.println();
                        System.out.println("movimiento");
                        System.out.println();
                    }
                    serpiente.get(0).getCuerpo().setLocation(serpiente.get(0).getCuerpo().getX() + x, serpiente.get(0).getCuerpo().getY() + y);
                    serpiente.get(0).getInterseccion().setLocation(serpiente.get(0).getCuerpo().getLocation());

                    if (ver()) {
                        tiempo.stop();
                        t.stop();
                        System.out.println("Perdió");
                        JOptionPane.showMessageDialog(null, "¡Has perdido!");
                        ActualizarInfo();
                    }
                } else {

                    if (serpiente.get(0).getCuerpo().getX() < 0) {
                        serpiente.get(0).getCuerpo().setLocation(605, serpiente.get(0).getCuerpo().getY());
                    } else if (serpiente.get(0).getCuerpo().getX() > 605) {
                        serpiente.get(0).getCuerpo().setLocation(0, serpiente.get(0).getCuerpo().getY());
                    } else if (serpiente.get(0).getCuerpo().getY() < 0) {
                        serpiente.get(0).getCuerpo().setLocation(serpiente.get(0).getCuerpo().getX(), 605);
                    } else if (serpiente.get(0).getCuerpo().getY() > 605) {
                        serpiente.get(0).getCuerpo().setLocation(serpiente.get(0).getCuerpo().getX(), 0);
                    }
                    for (int i = serpiente.size() - 1; i > 0; i--) {
                        UbicacionSerpiente(serpiente.get(i).getCuerpo().getX(), serpiente.get(i).getCuerpo().getY(), cx, cy);
                        serpiente.get(i).getCuerpo().setLocation(serpiente.get(i - 1).getCuerpo().getLocation());
                        serpiente.get(i).getInterseccion().setBounds(serpiente.get(i - 1).getCuerpo().getBounds());
                        serpiente.get(i).getCuerpo().repaint();

                        UbicacionObstaculos1();

                        imprimir();
                        System.out.println();
                        System.out.println("movimiento");
                        System.out.println();
                    }
                    serpiente.get(0).getCuerpo().setLocation(serpiente.get(0).getCuerpo().getX() + x, serpiente.get(0).getCuerpo().getY() + y);

                }

            }
        }

    });
    public boolean ver() {
        for (int i = 0; i < serpiente.size(); i++) {
            for (int j = 0; j < serpiente.size(); j++) {
                if (i != j) {
                    if (serpiente.get(i).getCuerpo().getX() == serpiente.get(j).getCuerpo().getX()
                            && serpiente.get(i).getCuerpo().getY() == serpiente.get(j).getCuerpo().getY()) {
                        System.out.println("se topo");
                        return true;
                    }
                }
            }
        }
        return false;
    }
    Timer tiempo2 = new Timer(250, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {

            comi.setBounds(comida.getBounds());
            serp.setBounds(serpiente.get(0).getCuerpo().getBounds());

            if (comi.intersects(serp)) {
                puntos += 7;
                lblpuntos.setText(String.valueOf(puntos));
                contador++;
                if (contador == 10 && nivel != 3) {
                    nivel++;
                    contador = 0;
                    lblnivel.setText(String.valueOf(nivel));
                } else if (nivel == 3) {
                    tiempo2.stop();
                    tiempo3.start();
                    obstaculos.get(8).setVisible(true);
                    obstaculos.get(9).setVisible(true);

                }
                
                int a = (int) Math.floor(Math.random() * (PosObstaculo.size()));
                int b = (int) Math.floor(Math.random() * (PosObstaculo.size()));

                cx = Integer.parseInt(PosObstaculo.get(a).toString());
                cy = Integer.parseInt(PosObstaculo.get(b).toString());
                comida.setBounds(cx, cy,55,55);
                comi.setBounds(cx,cy,55,55);
               System.out.println("Posición en X actual:"+ comida.getX()+", Posicion en Y actual:"+ comida.getY());
                posComida();
                posComida2();
                comida.setVisible(true);
                comida.repaint();

                System.out.println("Comió");
                JLabel cuerpo = new JLabel();
                cuerpo.setSize(55, 55);
                cuerpo.setIcon(new ImageIcon("src\\Recursos\\cuerpo.png"));
                cuerpo.setVisible(true);
                serpiente.add(new Serpiente(cuerpo, new Rectangle(cuerpo.getBounds())));
                panelJuego.add(serpiente.get(serpiente.size() - 1).getCuerpo(), 0);
                System.out.println(serpiente.size());
            }
            if (obst1.intersects(serp) || obst2.intersects(serp) || obst3.intersects(serp)
                    || obst4.intersects(serp) || obst5.intersects(serp) || obst6.intersects(serp)
                    || obst7.intersects(serp) || obst8.intersects(serp)) {
                tiempo2.stop();
                t.stop();
                System.out.println("Perdió");
                JOptionPane.showMessageDialog(null, "¡Has perdido!");
                ActualizarInfo();
            } else {
                matriz = new int[12][12];
                UbicacionSerpiente(serpiente.get(0).getCuerpo().getX(), serpiente.get(0).getCuerpo().getY(), cx, cy);
                if (serpiente.get(0).getCuerpo().getX() < 650 && serpiente.get(0).getCuerpo().getX() >= 0
                        && serpiente.get(0).getCuerpo().getY() > -10 && serpiente.get(0).getCuerpo().getY() < 650) {
                    for (int i = serpiente.size() - 1; i > 0; i--) {
                        UbicacionSerpiente(serpiente.get(i).getCuerpo().getX(), serpiente.get(i).getCuerpo().getY(), cx, cy);
                        serpiente.get(i).getCuerpo().setLocation(serpiente.get(i - 1).getCuerpo().getLocation());
                        serpiente.get(i).getInterseccion().setBounds(serpiente.get(i - 1).getCuerpo().getBounds());
                        serpiente.get(i).getCuerpo().repaint();

                        UbicacionObstaculos1();
                        UbicacionObstaculos2();

                        imprimir();
                        System.out.println();
                        System.out.println("movimiento");
                        System.out.println();

                    }
                    serpiente.get(0).getCuerpo().setLocation(serpiente.get(0).getCuerpo().getX() + x, serpiente.get(0).getCuerpo().getY() + y);
                    serpiente.get(0).getInterseccion().setLocation(serpiente.get(0).getCuerpo().getLocation());
                    if (ver()) {
                        tiempo2.stop();
                        t.stop();
                        System.out.println("Perdió");
                        JOptionPane.showMessageDialog(null, "¡Has perdido!");
                        ActualizarInfo();
                    }
                } else {
                    if (serpiente.get(0).getCuerpo().getX() < 0) {
                        serpiente.get(0).getCuerpo().setLocation(605, serpiente.get(0).getCuerpo().getY());
                    } else if (serpiente.get(0).getCuerpo().getX() > 605) {
                        serpiente.get(0).getCuerpo().setLocation(0, serpiente.get(0).getCuerpo().getY());
                    } else if (serpiente.get(0).getCuerpo().getY() < 0) {
                        serpiente.get(0).getCuerpo().setLocation(serpiente.get(0).getCuerpo().getX(), 605);
                    } else if (serpiente.get(0).getCuerpo().getY() > 605) {
                        serpiente.get(0).getCuerpo().setLocation(serpiente.get(0).getCuerpo().getX(), 0);
                    }
                    for (int i = serpiente.size() - 1; i > 0; i--) {
                        UbicacionSerpiente(serpiente.get(i).getCuerpo().getX(), serpiente.get(i).getCuerpo().getY(), cx, cy);
                        serpiente.get(i).getCuerpo().setLocation(serpiente.get(i - 1).getCuerpo().getLocation());
                        serpiente.get(i).getInterseccion().setBounds(serpiente.get(i - 1).getCuerpo().getBounds());
                        serpiente.get(i).getCuerpo().repaint();

                        UbicacionObstaculos1();
                        UbicacionObstaculos2();

                        imprimir();
                        System.out.println();
                        System.out.println("movimiento");
                        System.out.println();
                    }
                    serpiente.get(0).getCuerpo().setLocation(serpiente.get(0).getCuerpo().getX() + x, serpiente.get(0).getCuerpo().getY() + y);

                }
            }
        }

    });

    Timer tiempo3 = new Timer(150, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {

            comi.setBounds(comida.getBounds());
            serp.setBounds(serpiente.get(0).getCuerpo().getBounds());

            if (comi.intersects(serp)) {

                puntos += 10;
                lblpuntos.setText(String.valueOf(puntos));
                contador++;
                if (contador == 10) {
                    nivel++;
                    contador = 0;
                    tiempo3.stop();
                    JOptionPane.showMessageDialog(null, "¡Felicitaciones, ha ganado!");
                }
                int a = (int) Math.floor(Math.random() * (PosObstaculo.size()));
                int b = (int) Math.floor(Math.random() * (PosObstaculo.size()));

                cx = Integer.parseInt(PosObstaculo.get(a).toString());
                cy = Integer.parseInt(PosObstaculo.get(b).toString());
                comida.setBounds(cx, cy,55,55);
                comi.setBounds(comida.getBounds());
               System.out.println("Posición en X actual:"+ comida.getX()+"Posicion en Y actual:"+ comida.getY());
                posComida();
                posComida2();
                posComida3();
                comida.setVisible(true);
                comida.repaint();

                System.out.println("Comió");
                JLabel cuerpo = new JLabel();
                cuerpo.setSize(55, 55);
                cuerpo.setIcon(new ImageIcon("src\\Recursos\\cuerpo.png"));
                cuerpo.setVisible(true);
                serpiente.add(new Serpiente(cuerpo, new Rectangle(cuerpo.getBounds())));
                panelJuego.add(serpiente.get(serpiente.size() - 1).getCuerpo(), 0);
                System.out.println(serpiente.size());
            }
            if (obst1.intersects(serp) || obst2.intersects(serp) || obst3.intersects(serp)
                    || obst4.intersects(serp) || obst5.intersects(serp) || obst6.intersects(serp)
                    || obst7.intersects(serp) || obst8.intersects(serp) || obst9.intersects(serp) || obst10.intersects(serp)) {
                tiempo3.stop();
                t.stop();
                System.out.println("Perdió");
                JOptionPane.showMessageDialog(null, "¡Has perdido!");
                ActualizarInfo();
            } else {
                matriz = new int[12][12];
                UbicacionSerpiente(serpiente.get(0).getCuerpo().getX(), serpiente.get(0).getCuerpo().getY(), cx, cy);
                if (serpiente.get(0).getCuerpo().getX() < 605 && serpiente.get(0).getCuerpo().getX() >= 0
                        && serpiente.get(0).getCuerpo().getY() > -10 && serpiente.get(0).getCuerpo().getY() < 605) {
                    for (int i = serpiente.size() - 1; i > 0; i--) {
                        UbicacionSerpiente(serpiente.get(i).getCuerpo().getX(), serpiente.get(i).getCuerpo().getY(), cx, cy);
                        serpiente.get(i).getCuerpo().setLocation(serpiente.get(i - 1).getCuerpo().getLocation());
                        serpiente.get(i).getInterseccion().setBounds(serpiente.get(i - 1).getCuerpo().getBounds());
                        serpiente.get(i).getCuerpo().repaint();

                        UbicacionObstaculos1();
                        UbicacionObstaculos2();
                        UbicacionObstaculos3();

                        imprimir();
                        System.out.println();
                        System.out.println("movimiento");
                        System.out.println();
                    }
                    serpiente.get(0).getCuerpo().setLocation(serpiente.get(0).getCuerpo().getX() + x, serpiente.get(0).getCuerpo().getY() + y);
                    serpiente.get(0).getInterseccion().setLocation(serpiente.get(0).getCuerpo().getLocation());
                    UbicacionSerpiente(serpiente.get(0).getCuerpo().getX(), serpiente.get(0).getCuerpo().getY(), cx, cy);
                    UbicacionSerpiente(serpiente.get(1).getCuerpo().getX(), serpiente.get(1).getCuerpo().getY(), cx, cy);
                    UbicacionSerpiente(serpiente.get(2).getCuerpo().getX(), serpiente.get(2).getCuerpo().getY(), cx, cy);
                    if (ver()) {
                        tiempo3.stop();
                        t.stop();
                        System.out.println("Perdió");
                        JOptionPane.showMessageDialog(null, "¡Has perdido!");
                        ActualizarInfo();
                    }
                } else {
                    if (serpiente.get(0).getCuerpo().getX() < 0) {
                        serpiente.get(0).getCuerpo().setLocation(605, serpiente.get(0).getCuerpo().getY());
                    } else if (serpiente.get(0).getCuerpo().getX() > 605) {
                        serpiente.get(0).getCuerpo().setLocation(0, serpiente.get(0).getCuerpo().getY());
                    } else if (serpiente.get(0).getCuerpo().getY() < 0) {
                        serpiente.get(0).getCuerpo().setLocation(serpiente.get(0).getCuerpo().getX(), 605);
                    } else if (serpiente.get(0).getCuerpo().getY() > 605) {
                        serpiente.get(0).getCuerpo().setLocation(serpiente.get(0).getCuerpo().getX(), 0);
                    }
                    for (int i = serpiente.size() - 1; i > 0; i--) {
                        UbicacionSerpiente(serpiente.get(i).getCuerpo().getX(), serpiente.get(i).getCuerpo().getY(), cx, cy);
                        serpiente.get(i).getCuerpo().setLocation(serpiente.get(i - 1).getCuerpo().getLocation());
                        serpiente.get(i).getInterseccion().setBounds(serpiente.get(i - 1).getCuerpo().getBounds());
                        serpiente.get(i).getCuerpo().repaint();

                        UbicacionObstaculos1();
                        UbicacionObstaculos2();
                        UbicacionObstaculos3();
                        imprimir();
                        System.out.println();
                        System.out.println("movimiento");
                        System.out.println();
                    }
                    serpiente.get(0).getCuerpo().setLocation(serpiente.get(0).getCuerpo().getX() + x, serpiente.get(0).getCuerpo().getY() + y);

                }
            }
        }

    });

    public void Actualizar() {

        if (minutos < 10) {
            if (segundos < 10) {
                lbltiempo.setText("0" + minutos + ":0" + segundos);

            } else {
                lbltiempo.setText("0" + minutos + ":" + segundos);
            }
        } else {
            if (segundos < 10) {
                lbltiempo.setText(minutos + ":0" + segundos);
            } else {
                lbltiempo.setText(minutos + ":" + segundos);
            }
        }

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblnivel;
    private javax.swing.JLabel lblpuntos;
    private javax.swing.JLabel lbltiempo;
    private javax.swing.JPanel panelJuego;
    // End of variables declaration//GEN-END:variables

    public void imprimir() {
        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 12; j++) {
                System.out.print(" " + matriz[i][j] + " ");
            }
            System.out.println();
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            //System.out.println("arriba");
            if (serpiente.get(0).getCuerpo().getY() > 0) {
                y = -desplazamiento;
                x = 0;

            }
            if (aux == 0) {
                tiempo.start();
                t.start();
                aux = 1;
            }

        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            //  System.out.println("abajo");
            if (serpiente.get(0).getCuerpo().getY() < 660) {
                y = desplazamiento;
                x = 0;

            }
            if (aux == 0) {
                tiempo.start();
                t.start();
                aux = 1;
            }
        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            // System.out.println("izquierda");
            if (serpiente.get(0).getCuerpo().getX() > 0) {
                y = 0;
                x = -desplazamiento;

            }
            if (aux == 0) {
                tiempo.start();
                t.start();
                aux = 1;
            }
        }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            //   System.out.println("Derecha");
            if (serpiente.get(0).getCuerpo().getX() < 930) {
                y = 0;
                x = desplazamiento;

            }
            if (aux == 0) {
                tiempo.start();
                t.start();
                aux = 1;
            }
        }
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {

            switch (nivel) {
                case 1:
                    if (pause == true) {
                        pause = false;
                        tiempo.stop();
                        t.stop();

                    } else {
                        pause = true;
                        tiempo.start();
                        t.start();
                    }
                    break;
                case 2:
                    if (pause == true) {
                        pause = false;
                        tiempo2.stop();
                        t.stop();

                    } else {
                        pause = true;
                        tiempo2.start();
                        t.start();
                    }
                    break;

                case 3:
                    if (pause == true) {

                        pause = false;
                        tiempo3.stop();
                        t.stop();

                    } else {
                        pause = true;
                        tiempo3.start();
                        t.start();
                    }
                    break;
            }

        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        //To change body of generated methods, choose Tools | Templates.
    }
}
