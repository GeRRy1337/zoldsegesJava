
import java.sql.*;
import java.util.concurrent.TimeUnit;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
/**
 *
 * @author Molnár Gergő
 */
public class Zoldseges extends javax.swing.JFrame {

    private Connection db;

    /**
     * Creates new form Zoldseges
     */
    public Zoldseges() {
        initComponents();
        try {
            db = DriverManager.getConnection("jdbc:mysql://localhost:3306/zoldseges", "root", "");
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        tablaFeltolt();
    }

    private void tablaFeltolt() {
        tablaTorol();
        DefaultTableModel model = (DefaultTableModel) termekekTabla.getModel();
        Object tomb[] = new Object[5];
        try {
            Statement stmt = db.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM `keszlet` right outer JOIN termek on termek.id=keszlet.termek_id order by valid desc");
            while (rs.next()) {
                tomb[0] = rs.getInt("id");
                tomb[1] = rs.getString("nev");
                tomb[2] = rs.getInt("mennyiseg");
                tomb[3] = rs.getInt("ar");
                tomb[4] = rs.getString("egyseg");
                model.addRow(tomb);
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    private void tablaTorol() {
        DefaultTableModel model = (DefaultTableModel) termekekTabla.getModel();
        int size = model.getRowCount();
        for (int i = 0; i < size; i++) {
            model.removeRow(0);
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

        jScrollPane1 = new javax.swing.JScrollPane();
        termekekTabla = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        termekekTabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Azonosító", "Név", "Mennyiség", "Ár", "Egység"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(termekekTabla);

        jButton1.setText("Termék hozzáadása");
        jButton1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jButton1FocusLost(evt);
            }
        });
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Termék törlés");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Készlet hozzáadása");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Eladás");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("Ár megváltoztatása");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setText("Bevétel/Kiadás");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 801, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 163, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(49, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton6))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 493, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        termekAdd ta = new termekAdd();
        ta.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jButton1FocusLost
        tablaFeltolt();
    }//GEN-LAST:event_jButton1FocusLost

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        int row = termekekTabla.getSelectedRow();
        if (row > -1) {
            try {
                Statement stmt = db.createStatement();
                int id = Integer.parseInt(String.valueOf(termekekTabla.getValueAt(row, 0)));
                if (stmt.executeUpdate("Update termek set valid=0 where id=" + id) > 0) {
                    JOptionPane.showMessageDialog(rootPane, "Sikeres törlés", "Törlés", JOptionPane.INFORMATION_MESSAGE);
                }
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Nincs kiválasztva termék", "Törlés", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        int row = termekekTabla.getSelectedRow();
        if (row > -1) {
            try {
                Statement stmt = db.createStatement();
                int id = Integer.parseInt(String.valueOf(termekekTabla.getValueAt(row, 0)));
                int ar = -1;
                ResultSet rs = stmt.executeQuery("Select id from termek where valid=1 and id=" + id);
                if (rs.next()) {
                    rs = stmt.executeQuery("Select * from keszlet where termek_id=" + id);
                    String mes = JOptionPane.showInputDialog("Add meg a termék mennyiségét");
                    if (mes == null) {
                        return;
                    }
                    int me = Integer.parseInt(mes);
                    if (rs.next()) {
                        ar = rs.getInt("ar");
                        int rsme = rs.getInt("mennyiseg");
                        stmt.executeUpdate("Update keszlet set mennyiseg=" + (rsme + me) + ", ar=" + ar + " where termek_id=" + id);
                        stmt.executeUpdate("Insert into bevetelezes(termek_id,mennyiseg,ar,be_ki) Values(" + id + ", " + (me - rsme) + ", " + ar + ", 1 )"); // 1 : be
                    } else {
                        String ars = JOptionPane.showInputDialog("Add meg a termék árát");
                        if (ars == null) {
                            return;
                        }
                        ar = Integer.parseInt(ars);
                        stmt.executeUpdate("Insert into keszlet(termek_id,mennyiseg,ar) Values(" + id + ", " + me + ", " + ar + " )");
                        tablaFeltolt();
                        stmt.executeUpdate("Insert into bevetelezes(termek_id,mennyiseg,ar,be_ki) Values(" + id + ", " + me + ", " + ar + ", 1 )"); // 1 : be
                    }
                    tablaFeltolt();
                } else {
                    JOptionPane.showMessageDialog(rootPane, "Ez a termék törölve van", "Készlet", JOptionPane.ERROR_MESSAGE);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Nincs kiválasztva termék", "Készlet", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        int row = termekekTabla.getSelectedRow();
        if (row > -1) {
            try {
                Statement stmt = db.createStatement();
                int id = Integer.parseInt(String.valueOf(termekekTabla.getValueAt(row, 0)));
                int ar = -1;
                ResultSet rs = stmt.executeQuery("Select * from keszlet where termek_id=" + id);
                if (rs.next()) {
                    String mes = JOptionPane.showInputDialog("Add meg a termék mennyiségét");
                    if (mes == null) {
                        return;
                    }
                    int me = Integer.parseInt(mes);
                    ar = rs.getInt("ar");
                    int rsme = rs.getInt("mennyiseg");
                    if (rsme - me > 0) {
                        stmt.executeUpdate("Update keszlet set mennyiseg=" + (rsme - me) + " where termek_id=" + id);
                        stmt.executeUpdate("Insert into bevetelezes(termek_id,mennyiseg,ar,be_ki) Values(" + id + ", " + (me - rsme) + ", " + ar + ", 0 )"); // 1 : be
                    } else {
                        JOptionPane.showMessageDialog(rootPane, "A termékből nincs ennyi mennyiség készleten", "Eladás", JOptionPane.ERROR_MESSAGE);
                    }
                }
                tablaFeltolt();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Nincs kiválasztva termék", "Eladás", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        int row = termekekTabla.getSelectedRow();
        if (row > -1) {
            try {
                Statement stmt = db.createStatement();
                int id = Integer.parseInt(String.valueOf(termekekTabla.getValueAt(row, 0)));
                ResultSet rs = stmt.executeQuery("Select * from keszlet where termek_id=" + id);
                if (rs.next()) {
                    String ar = JOptionPane.showInputDialog("Add meg a termék új árát");
                    stmt.executeUpdate("Update keszlet set ar=" + ar + " where termek_id=" + id);
                }
                tablaFeltolt();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Nincs kiválasztva termék", "Eladás", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        bevetelKiadas ablak = new bevetelKiadas();
        ablak.getAdatok();
        ablak.setVisible(true);
    }//GEN-LAST:event_jButton6ActionPerformed

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
            java.util.logging.Logger.getLogger(Zoldseges.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Zoldseges.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Zoldseges.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Zoldseges.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Zoldseges().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable termekekTabla;
    // End of variables declaration//GEN-END:variables
}