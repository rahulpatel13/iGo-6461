package javaapplication2;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */



import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
/**
 *
 * @author rahul
 */
public class TranscationHistory extends javax.swing.JFrame {

    /** Creates new form TranscationHistory */
    public static ArrayList<RechargeIGoCardInformation> rechargeHistory = null;
    public static ArrayList<PurchaseTicketInformation> purchaseHistory = null;
    public static RegisteredUser userTmp;
 private static String lang;
    public TranscationHistory(String lang,RegisteredUser R,ArrayList<RechargeIGoCardInformation> rechargeIGoCardTransactionHistory, ArrayList<PurchaseTicketInformation> PurchaseTicketdTransactionHistory) {
        userTmp=R;
        setSize(1024, 803);
        getContentPane().setBackground(Color.WHITE); 
        rechargeHistory = rechargeIGoCardTransactionHistory;
        purchaseHistory = PurchaseTicketdTransactionHistory;
       lang=lang;
        initComponents();
        String value=null;
        if("fr".equals(lang)){
            value=userTmp.getName()+" Historique des transactions";
            jLabel1.setText(value);
            jLabel1.setFont(new Font("Segoe UI", Font.PLAIN, 19));
        }
        else
        {
            value=userTmp.getName()+" Transcation History";
            jLabel1.setText(value);
        }
        
        
        for(RechargeIGoCardInformation rechargeInfo : rechargeHistory){
            jTextArea1.append(rechargeInfo.getInfo()+"\n"+"\n");
           
       
        }
        for(PurchaseTicketInformation purchaseInfo : purchaseHistory){
            jTextArea1.append(purchaseInfo.getInfo()+"\n"+"\n");
            
        }
       
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        jButton1.setText("jButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(300, 320, 420, 351);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("User Transcation History");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(280, 270, 470, 50);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javaapplication2/images/New Project (1) (1).png"))); // NOI18N
        getContentPane().add(jLabel2);
        jLabel2.setBounds(0, 0, 1024, 768);

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(TranscationHistory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TranscationHistory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TranscationHistory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TranscationHistory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TranscationHistory(lang,userTmp,rechargeHistory, purchaseHistory).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables

}