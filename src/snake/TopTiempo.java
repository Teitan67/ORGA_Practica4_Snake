/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package snake;

import java.awt.Desktop;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author vanes
 */
public class TopTiempo extends javax.swing.JFrame {

    /**
     * Creates new form TopTiempo
     */
    ArrayList<Solicitud> solicitud;
    ArrayList<Aprobados> aprobados;

    public TopTiempo() {
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        initComponents();
        Titulos();
        Llenar();
    }

    public TopTiempo(ArrayList<Solicitud> solicitud, ArrayList<Aprobados> aprobados) {
        this.solicitud = solicitud;
        this.aprobados = aprobados;
        initComponents();
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        Titulos();
        Llenar();
        abrirarchivo("Tiempo.rep");
    }

    public void Titulos() {
        String[] titulos = {"Nombre", "Tiempo"};
        modelo.setColumnIdentifiers(titulos);
        tabla.setModel(modelo);
    }

    public void Llenar() {

        ArrayList<Mejores> mejor = new ArrayList();
        int top = 0;
        Object[] datos = new Object[3];
        for (int i = 0; i < aprobados.size(); i++) {
            if (!aprobados.get(i).getNombre().equalsIgnoreCase("admin_orga")) {
                String tiempo = aprobados.get(i).getEstado().getTiempo().replace(":", "");
                int t = Integer.parseInt(tiempo);
                mejor.add(new Mejores(aprobados.get(i).getNombre(), t, 0));
            }
        }
   //     Collections.sort(mejor, (Mejores p1, Mejores p2) -> {
     //       return new Integer(p2.getTiempo()).compareTo(p1.getTiempo());
    //    });
    Collections.sort(mejor,Collections.reverseOrder());
        int b;
        if (mejor.size() <= 10) {
            b = mejor.size();
        } else {
            b = 10;
        }
        System.out.println("tamaño: " + mejor.size());
        for (int i = 0; i < b; i++) {

            datos[0] = mejor.get(i).getNombre();
            if (mejor.get(i).getTiempo() < 59 && mejor.get(i).getTiempo() > 10) {
                datos[1] = "00:" + mejor.get(i).getTiempo();
            } else if (mejor.get(i).getTiempo() < 10) {
                datos[1] = "00:0" + mejor.get(i).getTiempo();
            } else if (mejor.get(i).getTiempo() > 100 && mejor.get(i).getTiempo() < 1000) {
                String v = String.valueOf(mejor.get(i).getTiempo());
                datos[1] = "0" + v.charAt(0) + ":" + v.charAt(1) + v.charAt(2);
            } else {
                String v = String.valueOf(mejor.get(i).getTiempo());
                datos[1] = v.charAt(0) + v.charAt(1) + ":" + v.charAt(2) + v.charAt(3);
            }

            modelo.addRow(datos);

        }
        tabla.setModel(modelo);

        FileWriter fichero = null;
        PrintWriter pw = null;
        try {
            fichero = new FileWriter("Tiempo.rep");
            pw = new PrintWriter(fichero);
            pw.println("Top 10 de los mejores tiempos");
            pw.println("");
            if (mejor.size() <= 10) {
                b = mejor.size();
            } else {
                b = 10;
            }
            for (int i = 0; i < b; i++) {
                String a;
                if (mejor.get(i).getTiempo() < 59 && mejor.get(i).getTiempo() > 10) {
                    a = "00:" + mejor.get(i).getTiempo();
                } else if (mejor.get(i).getTiempo() < 10) {
                    a = "00:0" + mejor.get(i).getTiempo();
                } else if (mejor.get(i).getTiempo() > 100 && mejor.get(i).getTiempo() < 1000) {
                    String v = String.valueOf(mejor.get(i).getTiempo());
                    a = "0" + v.charAt(0) + ":" + v.charAt(1) + v.charAt(2);
                } else {
                    String v = String.valueOf(mejor.get(i).getTiempo());
                    a = v.charAt(0) + v.charAt(1) + ":" + v.charAt(2) + v.charAt(3);
                }
                if (mejor.get(i) != null) {
                    pw.println((i + 1) + ". Nombre:" + mejor.get(i).getNombre() + "------ Tiempo:" + a);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (fichero != null) {
                    fichero.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }

    }

    public void abrirarchivo(String archivo) {

        try {

            File objetofile = new File(archivo);
            Desktop.getDesktop().open(objetofile);

        } catch (IOException ex) {

            System.out.println(ex);

        }

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
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 51, 0));
        jLabel1.setText("Top 10 de mejor tiempo");

        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tabla);

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/icons8_Back_64px.png"))); // NOI18N
        jButton1.setBorder(null);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(25, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 453, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(105, 105, 105))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1))
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.dispose();
        Administrador ad = new Administrador(solicitud, aprobados);
        ad.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    DefaultTableModel modelo = new DefaultTableModel();

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
            java.util.logging.Logger.getLogger(TopTiempo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TopTiempo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TopTiempo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TopTiempo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TopTiempo().setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabla;
    // End of variables declaration//GEN-END:variables
}
