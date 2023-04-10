/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package javaapplication2;

import java.awt.Color;
import java.awt.Font;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JOptionPane;

/**
 *
 * @author shubh
 */
public class LoginPage extends javax.swing.JFrame {
    
    public static File userDBFile = new File(constant.userDBFile);

    public static String retrieveInformationFromUserDB(String enteredEmail, String enteredPassword){
         //System.out.println(enteredEmail);
         // System.out.println(enteredPassword);
        String userEmail, userPassword;
        String userInformationArray[] = null;
        try {
            BufferedReader userDBBufferedReader = new BufferedReader(new FileReader(userDBFile));
            String userInformation;
            while ((userInformation = userDBBufferedReader.readLine()) != null){
                userInformationArray = userInformation.split(constant.REGEX, -1);
                userEmail = userInformationArray[0].trim().substring(1); userEmail = userEmail.substring(0,userEmail.length()-1);
                userPassword = userInformationArray[1].trim().substring(1); userPassword = userPassword.substring(0,userPassword.length()-1);
                //System.out.println(userEmail);
                //System.out.println(userPassword);
                if(userEmail.equals(enteredEmail) && userPassword.equals(enteredPassword)){
                    //System.out.println(RegisteredUser.getRegisteredUser(userInformation).toString());
                   // System.out.println(userInformation);
                    return userInformation;
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Creates new form LoginPage2
     */
    private static String lang;
    public LoginPage(String lang) {
        LoginPage.lang = lang;
        initComponents();
        setSize(1024, 803);
        getContentPane().setBackground(Color.WHITE); 
        username.setText("fr".equals(LoginPage.lang)?"Nom d'util ":"Username ");
        if ("fr".equals(LoginPage.lang)) {
            username.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        }

        password.setText("fr".equals(lang)?"Mot de passe ":"Password ");
        if ("fr".equals(LoginPage.lang)) {
            password.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        }
        jButton3.setText("fr".equals(lang)?"Connexion":"Login");
        jButton2.setText("fr".equals(lang)?"Enregistrer":"Register");
        jButton1.setText("fr".equals(lang)?"invité":"Guest"); 
        jLabel1.setText("fr".equals(lang)?"Bienvenue chez IGo, Cher Commuter":"Welcome to IGo , Dear Commuter");
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        password = new javax.swing.JLabel();
        username = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        jLabel5 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jPasswordField1 = new javax.swing.JPasswordField();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        password.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        password.setForeground(new java.awt.Color(133, 220, 186));
        password.setText("Password :- ");
        getContentPane().add(password);
        password.setBounds(304, 400, 130, 50);

        username.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        username.setForeground(new java.awt.Color(133, 220, 186));
        username.setText("Username :- ");
        getContentPane().add(username);
        username.setBounds(300, 320, 140, 70);

        jTextArea2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTextArea2.setRows(1);
        jTextArea2.setTabSize(0);
        jScrollPane2.setViewportView(jTextArea2);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(440, 340, 330, 40);

        jLabel5.setBackground(new java.awt.Color(133, 220, 186));
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javaapplication2/images/New Project (1) (1).png"))); // NOI18N
        jLabel5.setText("jLabel5");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(10, -20, 1010, 810);

        jButton2.setBackground(new java.awt.Color(133, 220, 186));
        jButton2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jButton2.setText("Register");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(520, 490, 130, 40);

        jButton3.setBackground(new java.awt.Color(133, 220, 186));
        jButton3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jButton3.setText("Login");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3);
        jButton3.setBounds(330, 490, 130, 40);
        getContentPane().add(jPasswordField1);
        jPasswordField1.setBounds(440, 410, 330, 40);

        jButton1.setBackground(new java.awt.Color(133, 220, 186));
        jButton1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jButton1.setText("Guest");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(700, 490, 140, 40);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 22)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 102, 0));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Welcome to IGo , Dear Commuter");
        jLabel1.setToolTipText("");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(360, 260, 490, 60);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
                        SignUpMenu d = new SignUpMenu(lang);
                d.show();
                dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        //System.out.println("login");
            String username = jTextArea2.getText();
            String password = new String(jPasswordField1.getPassword());
            // TODO: authenticate user
            RegisteredUser registeredUserObject = RegisteredUser.retrieveInformationFromUserDB(username.trim(),password.trim());
            if(registeredUserObject==null){
                JOptionPane.showMessageDialog(this, "fr".equals(lang)?"Nom d'utilisateur/mot de passe incorrect !!!":"Username/Password incorrect!!!");
            }else{
                JOptionPane.showMessageDialog(this, "fr".equals(lang)?"Connexion réussie":"Login Successful");
                System.out.println(registeredUserObject);
                 RegisteredUserMenu m=new RegisteredUserMenu(lang,registeredUserObject);
                m.show();
                dispose();
            }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        PurchaseTicket m=new PurchaseTicket(lang,null,"Guest");
                m.show();
                dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(LoginPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new LoginPage(lang).setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JLabel password;
    private javax.swing.JLabel username;
    // End of variables declaration//GEN-END:variables
}
