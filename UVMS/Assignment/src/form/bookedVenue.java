/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package form;

import java.util.ArrayList;
import model.Booking;
import model.TextFileRW;

/**
 *
 * @author User
 */
public class bookedVenue extends javax.swing.JDialog {

    /**
     * Creates new form bookedVenue
     */
    public bookedVenue(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        
        TextFileRW t = new TextFileRW();
        
        String lecturer = menuLecturer.lecturerID;
        
        if(lecturer.equals("default"))
            lecturer = null;
        
        ArrayList<Booking> bookings = t.readAllBooking(lecturer);
        
        String[][] data = new String[bookings.size()][3];
        String[] header = {"Date", "Time", "Lecturer"};
        
        for(int i=0; i<bookings.size();i++){
            Booking b = bookings.get(i);
            
            data[i][0] = b.getDate();
            data[i][1] = convertTime(b.getTime());
            data[i][2] = b.getLecturerID();
        }
        
        
        tbSchedule.setModel(
                new javax.swing.table.DefaultTableModel(data, header)
        );
    }
    
    private String convertTime(int i){
        if(i == 0)
            return "09.00 am";
        if(i == 1)
            return "10.00 am";
        if(i == 2)
            return "11.00 am";
        if(i == 3)
            return "12.00 pm";
        if(i == 4)
            return "01.00 pm";
        if(i == 5)
            return "02.00 pm";
        if(i == 6)
            return "03.00 pm";
        if(i == 7)
            return "04.00 pm";
        return null;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tbSchedule = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(526, 501));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tbSchedule.setBackground(new java.awt.Color(43, 199, 236));
        tbSchedule.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        tbSchedule.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"24-10-2021", "9 am", "S0001 - A"},
                {"24-10-2021", "10 am", "S0001 - A"},
                {"24-10-2021", "11 am", "S0001 - A"},
                {"25-10-2021", "9 am", "S0001 - A"}
            },
            new String [] {
                "Date", "Time", "Lecturer"
            }
        ));
        tbSchedule.setRowHeight(20);
        jScrollPane1.setViewportView(tbSchedule);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, -1, -1));

        jPanel1.setBackground(new java.awt.Color(43, 199, 236));
        jPanel1.setForeground(new java.awt.Color(73, 88, 120));
        jPanel1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 520, 480));

        pack();
        setLocationRelativeTo(null);
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
            java.util.logging.Logger.getLogger(bookedVenue.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(bookedVenue.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(bookedVenue.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(bookedVenue.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                bookedVenue dialog = new bookedVenue(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbSchedule;
    // End of variables declaration//GEN-END:variables
}
