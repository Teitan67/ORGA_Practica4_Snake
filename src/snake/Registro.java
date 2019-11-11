/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package snake;

import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author vanes
 */
public class Registro extends javax.swing.JFrame {

    public ArrayList<Solicitud> usuarios;
    public ArrayList<Aprobados> aprobados;
      ArrayList<Solicitud> us=new ArrayList<>();
    public Registro(ArrayList<Solicitud> usuarios, ArrayList<Aprobados> aprobados) {
        this.usuarios = usuarios;
        this.aprobados=aprobados;
         initComponents();
       this.setLocationRelativeTo(null);
     
    }
   public Registro() {
        initComponents();
    }

/**
     * Creates new form Registro
     */
        /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtnombre = new javax.swing.JTextField();
        txtpass = new javax.swing.JPasswordField();
        txtpass2 = new javax.swing.JPasswordField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Forte", 0, 36)); // NOI18N
        jLabel1.setText("Registro");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 20, -1, -1));

        jLabel2.setFont(new java.awt.Font("Franklin Gothic Demi Cond", 0, 24)); // NOI18N
        jLabel2.setText("Escribe tu nombre: ");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 110, -1, -1));

        jLabel3.setFont(new java.awt.Font("Franklin Gothic Demi Cond", 0, 24)); // NOI18N
        jLabel3.setText("Ingresa una contraseña:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 160, -1, -1));

        jLabel4.setFont(new java.awt.Font("Franklin Gothic Demi Cond", 0, 24)); // NOI18N
        jLabel4.setText("Vuelve a escribir tu contraseña");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 210, -1, 31));

        txtnombre.setBackground(new java.awt.Color(204, 204, 0));
        txtnombre.setFont(new java.awt.Font("Franklin Gothic Demi Cond", 0, 24)); // NOI18N
        txtnombre.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(txtnombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 110, 330, 31));

        txtpass.setBackground(new java.awt.Color(204, 204, 0));
        txtpass.setFont(new java.awt.Font("Franklin Gothic Demi Cond", 0, 24)); // NOI18N
        txtpass.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(txtpass, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 160, 260, 31));

        txtpass2.setBackground(new java.awt.Color(204, 204, 0));
        txtpass2.setFont(new java.awt.Font("Franklin Gothic Demi Cond", 0, 24)); // NOI18N
        txtpass2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(txtpass2, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 210, 230, 31));

        jButton1.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jButton1.setText("Enviar solicitud de registro");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 270, 280, 47));

        jButton2.setBackground(new java.awt.Color(102, 204, 0));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/icons8_Back_64px.png"))); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 61, 56));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/background-2673867_640.jpg"))); // NOI18N
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(-16, 0, 640, 370));

        jLabel6.setText("jLabel6");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 290, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        if(txtnombre.getText()==null || txtpass.getText()==null || txtpass2.getText()==null){
           JOptionPane.showMessageDialog(null, "¡Ningún campo puede estar vacío!");
               return;
        }
        
        if(VerificarRepetidos()==false && VerificarPass()==false){
            String nombre=txtnombre.getText();
            String pass=txtpass.getText();
         
            us.add(new Solicitud(nombre,pass));
            usuarios=us;          
           JOptionPane.showMessageDialog(null, "¡La solicitud de registro se ha enviado al administrador!");
           txtnombre.setText(""); txtpass.setText(""); txtpass2.setText("");
        }
        
        
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
     Login l=new Login(usuarios,aprobados);
     l.setVisible(true);
     this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private boolean VerificarRepetidos(){
        String nombre= txtnombre.getText();
      
        if(usuarios!=null){
         for(int i=0; i<usuarios.size();i++){
          if(usuarios.get(i)!=null){
           if(usuarios.get(i).getNombre().equalsIgnoreCase(nombre)){
               JOptionPane.showMessageDialog(null, "¡El nombre de usuario ya existe, intenta con otro!");
               return true;
           }
          }
      }
        }
      return false;
    }
    
    private boolean VerificarPass(){
       char[] pass=txtpass.getPassword();
       char[] pass2=txtpass2.getPassword();
       if(pass.length==pass2.length){
     for(int i=0; i<pass.length;i++){
         if(pass[i]!=pass2[i]){
             JOptionPane.showMessageDialog(null, "¡Las contraseñas no coinciden!");
             return true;
         }
     }
       }else{
          JOptionPane.showMessageDialog(null, "¡Las contraseñas no coinciden!");
             return true;  
       }
       return false;
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
            java.util.logging.Logger.getLogger(Registro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Registro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Registro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Registro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Registro().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JTextField txtnombre;
    private javax.swing.JPasswordField txtpass;
    private javax.swing.JPasswordField txtpass2;
    // End of variables declaration//GEN-END:variables
}
