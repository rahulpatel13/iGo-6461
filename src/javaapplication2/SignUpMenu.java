/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package javaapplication2;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JOptionPane;
import java.io.*;

/**
 *
 * @author rahul
 */
public class SignUpMenu extends javax.swing.JFrame {
    
    
    public static File userDBFile = new File(constant.userDBFile);
    public static boolean writeInToUserDB(RegisteredUser registeredUser){
        try {
            if(!userDBFile.exists()) {
                userDBFile.createNewFile();
            }
            String userEmail, userPassword;
            String userInformationArray[] = null;

            try {
                BufferedReader userDBBufferedReader = new BufferedReader(new FileReader(userDBFile));
                String userInformation;
                while ((userInformation = userDBBufferedReader.readLine()) != null){
                    userInformationArray = userInformation.split(constant.REGEX, -1);
                    userEmail = userInformationArray[0].trim().substring(1); userEmail = userEmail.substring(0,userEmail.length()-1);
                    userPassword = userInformationArray[1].trim().substring(1); userPassword = userPassword.substring(0,userPassword.length()-1);
                    //System.out.println(userEmail+" : "+userPassword);
                    if(userEmail.equals(registeredUser.getEmail()) && userPassword.equals(registeredUser.getPassword())){
                        System.out.println("User Already Present!");
                        return false;
                    }
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                return false;
            } catch (IOException e) {
                e.printStackTrace();
                return false;
            }
            FileWriter userDBBfileWriter = new FileWriter(userDBFile.getName(),true);
            BufferedWriter bw = new BufferedWriter(userDBBfileWriter);
            bw.write(registeredUser.toString()+"\n");
            bw.close();
        } catch(IOException e){
            e.printStackTrace();
            return false;
        }

        return true;
    }

    /**
     * Creates new form SignUpMenu
     */
    static String lang;
    public SignUpMenu(String lang) {
        SignUpMenu.lang = lang;
        initComponents();
        setSize(1024, 803);
        getContentPane().setBackground(Color.WHITE);
        jLabel1.setText("fr".equals(lang)?"Nom ":"Name ");
        jLabel2.setText("fr".equals(lang)?"E-mail ":"Email ");
        jLabel3.setText("fr".equals(lang)?"Adresse ":"Address ");
        jLabel4.setText("fr".equals(lang)?"Photo d'identité ":"Photo Id ");
        jLabel5.setText("fr".equals(lang)?"Type d'utilisateur ":"User Type ");
        jLabel6.setText("fr".equals(lang)?"Mot de passe ":"Password ");
        jLabel7.setText("fr".equals(lang)?"Confirmez le mot de passe ":"Confirm Password ");
        jLabel8.setText("fr".equals(lang)?"Numéro de téléphone ":"Phone Number ");
        jButton1.setText("fr".equals(lang)?"S'inscrire":"Sign Up"); 
        jButton2.setText("fr".equals(lang)?"Connexion":"Login");
        
        jRadioButton1.setText("fr".equals(lang)?"Passepor":"Passport");
        jRadioButton2.setText("fr".equals(lang)?"Permis d'études":"Study Permit");
        jRadioButton3.setText("fr".equals(lang)?"Réguli(ère) / (er)":"Regular"); 
        jRadioButton4.setText("fr".equals(lang)?"Étudiant / Sénior":"Student / Senior");  
        
        jLabel10.setText("");
        jLabel11.setText("");
        jLabel12.setText("");
//         pId = "Passport"; type = "Regular";pId = "Study Permit";type = "Student/Senior";
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jRadioButton3 = new javax.swing.JRadioButton();
        jRadioButton4 = new javax.swing.JRadioButton();
        jPasswordField1 = new javax.swing.JPasswordField();
        jPasswordField2 = new javax.swing.JPasswordField();
        jButton1 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1024, 768));
        getContentPane().setLayout(null);

        jLabel1.setBackground(new java.awt.Color(133, 220, 186));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(133, 220, 186));
        jLabel1.setText("Name");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(360, 250, 180, 30);

        jLabel2.setBackground(new java.awt.Color(133, 220, 186));
        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(133, 220, 186));
        jLabel2.setText("Email Id");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(360, 290, 180, 30);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(133, 220, 186));
        jLabel3.setText("Address");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(360, 330, 180, 30);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(133, 220, 186));
        jLabel4.setText("Photo Id");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(360, 370, 180, 20);

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(133, 220, 186));
        jLabel5.setText("User Type");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(360, 390, 180, 40);

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(133, 220, 186));
        jLabel6.setText("Password");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(360, 440, 180, 30);

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(133, 220, 186));
        jLabel7.setText("Confirm Password");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(360, 480, 180, 30);
        getContentPane().add(jTextField1);
        jTextField1.setBounds(540, 250, 130, 30);

        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });
        jTextField2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField2KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField2KeyTyped(evt);
            }
        });
        getContentPane().add(jTextField2);
        jTextField2.setBounds(540, 290, 130, 30);
        getContentPane().add(jTextField3);
        jTextField3.setBounds(540, 330, 130, 30);

        buttonGroup1.add(jRadioButton1);
        jRadioButton1.setText("Passport");
        jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jRadioButton1);
        jRadioButton1.setBounds(540, 370, 130, 21);

        buttonGroup1.add(jRadioButton2);
        jRadioButton2.setText("Study Permit");
        jRadioButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jRadioButton2);
        jRadioButton2.setBounds(670, 370, 110, 21);

        buttonGroup2.add(jRadioButton3);
        jRadioButton3.setText("Regular");
        jRadioButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jRadioButton3);
        jRadioButton3.setBounds(540, 400, 130, 30);

        buttonGroup2.add(jRadioButton4);
        jRadioButton4.setText("Student/Senior");
        jRadioButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jRadioButton4);
        jRadioButton4.setBounds(670, 400, 150, 30);

        jPasswordField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPasswordField1ActionPerformed(evt);
            }
        });
        jPasswordField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jPasswordField1KeyReleased(evt);
            }
        });
        getContentPane().add(jPasswordField1);
        jPasswordField1.setBounds(540, 440, 130, 30);

        jPasswordField2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jPasswordField2KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jPasswordField2KeyTyped(evt);
            }
        });
        getContentPane().add(jPasswordField2);
        jPasswordField2.setBounds(540, 480, 130, 30);

        jButton1.setBackground(new java.awt.Color(133, 220, 186));
        jButton1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Sign Up");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(340, 580, 190, 50);

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(133, 220, 186));
        jLabel8.setText("Phone Number");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(360, 510, 180, 50);

        jTextField4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField4KeyReleased(evt);
            }
        });
        getContentPane().add(jTextField4);
        jTextField4.setBounds(540, 530, 130, 30);

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javaapplication2/images/New Project (1) (1).png"))); // NOI18N
        getContentPane().add(jLabel9);
        jLabel9.setBounds(0, 0, 1020, 770);

        jButton2.setBackground(new java.awt.Color(133, 220, 186));
        jButton2.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Login");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(550, 580, 190, 50);

        jLabel10.setForeground(new java.awt.Color(255, 0, 0));
        jLabel10.setText("jLabel10");
        getContentPane().add(jLabel10);
        jLabel10.setBounds(750, 286, 270, 40);

        jLabel11.setForeground(new java.awt.Color(255, 51, 51));
        jLabel11.setText("jLabel11");
        getContentPane().add(jLabel11);
        jLabel11.setBounds(760, 480, 250, 40);

        jLabel12.setForeground(new java.awt.Color(255, 0, 0));
        jLabel12.setText("jLabel12");
        getContentPane().add(jLabel12);
        jLabel12.setBounds(760, 530, 250, 30);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jRadioButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton3ActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jRadioButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        String email = jTextField2.getText().trim();
            String password = new String(jPasswordField1.getPassword());
//            String cpassword = new String(jPasswordField2.getPassword());
            String name = jTextField1.getText();
            String address = jTextField3.getText();
            String phoneNumber = jTextField4.getText();
            String photoId = jRadioButton1.isSelected()==true?"Passport":"Study Permit";
            String userType = jRadioButton3.isSelected()==true?"Regular":"Student/Senior";
            

            // Do something with the user input, such as create a new user account in a database
            // ...
             
            RegisteredUser r = new RegisteredUser(email, password, name, address,photoId, userType,phoneNumber);
            writeInToUserDB(r);
            // Display a confirmation message
            JOptionPane.showMessageDialog(this, "fr".equals(lang) ? "L'utilisateur s'est enregistré avec succès." : "User registered successfully.");
            LoginPage l = new LoginPage(lang);
            l.show();
            dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jRadioButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton4ActionPerformed
        // TODO add your handling code here:
       
    }//GEN-LAST:event_jRadioButton4ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        LoginPage l = new LoginPage(lang);
            l.show();
            dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jRadioButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton2ActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_jRadioButton2ActionPerformed

    private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton1ActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_jRadioButton1ActionPerformed

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jTextField2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField2KeyTyped
        // TODO add your handling code here:
       
    }//GEN-LAST:event_jTextField2KeyTyped

    private void jPasswordField2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPasswordField2KeyTyped
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jPasswordField2KeyTyped

    private void jPasswordField1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPasswordField1KeyReleased
        // TODO add your handling code here:
        String password = new String(jPasswordField1.getPassword()).trim();
        String cpassword = new String(jPasswordField2.getPassword()).trim();
        
        if(password.equals(cpassword) == false){
            jLabel11.setText("fr".equals(lang)?"Les mots de passe ne correspondent pas!":"Passwords do not match!");
        }else{
            jLabel11.setText("");
        }
    }//GEN-LAST:event_jPasswordField1KeyReleased

    private void jPasswordField2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPasswordField2KeyReleased
        // TODO add your handling code here:
        String password = new String(jPasswordField1.getPassword()).trim();
        String cpassword = new String(jPasswordField2.getPassword()).trim();
        
        if(password.equals(cpassword) == false){
            jLabel11.setText("fr".equals(lang)?"Les mots de passe ne correspondent pas!":"Passwords do not match!");
        }else{
            jLabel11.setText("");
        }
    }//GEN-LAST:event_jPasswordField2KeyReleased

    private void jTextField2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField2KeyReleased
        // TODO add your handling code here:
         String email = jTextField2.getText().trim();
        
        if(constant.isValidEmail(email) == false){
            jLabel10.setText("fr".equals(lang)?"Email invalide!":"Invalid Email!");
        }else{
            jLabel10.setText("");
        }
    }//GEN-LAST:event_jTextField2KeyReleased

    private void jTextField4KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField4KeyReleased
        // TODO add your handling code here:
        String phoneNumber = jTextField4.getText().trim();
        
        if(constant.isValidPhoneNumber(phoneNumber) == false){
            jLabel12.setText("fr".equals(lang)?"Numéro de téléphone invalide!":"Invalid phone number!");
        }else{
            jLabel12.setText("");
        } 
    }//GEN-LAST:event_jTextField4KeyReleased

    private void jPasswordField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jPasswordField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jPasswordField1ActionPerformed

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
            java.util.logging.Logger.getLogger(SignUpMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SignUpMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SignUpMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SignUpMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new SignUpMenu(lang).setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JPasswordField jPasswordField2;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JRadioButton jRadioButton4;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    // End of variables declaration//GEN-END:variables
}
