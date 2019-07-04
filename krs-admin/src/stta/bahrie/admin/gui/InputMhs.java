/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * InputMhs.java
 *
 * Created on Oct 19, 2010, 7:43:53 PM
 */
package stta.bahrie.admin.gui;

import api.stta.bahrie.entiy.Dosen;
import api.stta.bahrie.entiy.Mahasiswa;
import api.stta.bahrie.inter.DosenInterf;
import api.stta.bahrie.inter.MahasiswaInterf;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author bahrie
 */
public class InputMhs extends javax.swing.JInternalFrame {

    List<Mahasiswa> records = new ArrayList<Mahasiswa>();
    List<Dosen> listDosen = new ArrayList<Dosen>();
    MahasiswaInterf mhsService;
    DosenInterf dsnService;
    int row;

    /** Creates new form InputMhs */
    public InputMhs(MahasiswaInterf mhsService, DosenInterf dsnService) {
        try {
            this.mhsService = mhsService;
            this.dsnService = dsnService;
            initComponents();
            this.statusAwal();
            tableMhs.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

                public void valueChanged(ListSelectionEvent e) {
                    row = tableMhs.getSelectedRow();
                    if (row != -1) {
                        isitext();
                    }
                }
            });
        } catch (RemoteException ex) {
            Logger.getLogger(InputMhs.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    void loadDosen() throws RemoteException {
        listDosen = dsnService.getAll();
    }

    void isiListDosen() {
        comboDosen.removeAllItems();
        for (Dosen dsn : listDosen) {
            comboDosen.addItem(dsn.getDosen());
        }
    }

    void loadRecords() throws RemoteException {
        
        records = mhsService.getAll();
        this.setIsitabel();
        
    }

    void setIsitabel() {
        try {
            Object data[][] = new Object[records.size()][5];
            int x = 0;
            for (Mahasiswa mhs : records) {
                data[x][0] = mhs.getNim();
                data[x][1] = mhs.getNama();
                data[x][2] = mhs.getProdi();
                data[x][3] = mhs.getKd_dosen();
                data[x][4] = mhs.getJumlah_krs();
                x++;
            }
            String[] judul = {"NPM", "Nama", "Jurusan", "Kode Pembimbing", "SKS"};
            tableMhs.setModel(new DefaultTableModel(data, judul));
            jScrollPane1.setViewportView(tableMhs);
        } catch (Throwable ex) {
            ex.printStackTrace();
        }
    }

    void kosongkanText() {
        txtNama.setText("");
        txtNim.setText("");
        txtJurusan.setText("");
        for (Dosen dsn : listDosen) {
            comboDosen.addItem(dsn.getDosen());
        }
        txtPwd.setText("");
    }

    void isitext() {
        Mahasiswa mhs = records.get(row);
        txtNama.setText(mhs.getNama());
        txtNim.setText(mhs.getNim());
        txtJurusan.setText(mhs.getProdi());
        comboDosen.removeAllItems();
        for (Dosen dsn : listDosen) {
            comboDosen.addItem(dsn.getDosen());
        }
        txtPwd.setText(mhs.getPwd());
    }

    void statusAwal() throws RemoteException {
        this.loadRecords();
        this.kosongkanText();
        this.loadDosen();
        this.isiListDosen();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        inputButton = new javax.swing.JButton();
        hapusButton = new javax.swing.JButton();
        updateBotton = new javax.swing.JButton();
        resetBotton = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtNim = new javax.swing.JTextField();
        txtNama = new javax.swing.JTextField();
        txtPwd = new javax.swing.JPasswordField();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtJurusan = new javax.swing.JTextField();
        comboDosen = new javax.swing.JComboBox();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableMhs = new javax.swing.JTable();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Input Mahasiswa");

        inputButton.setText(" Input ");
        inputButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputButtonActionPerformed(evt);
            }
        });
        jPanel3.add(inputButton);

        hapusButton.setText("Hapus");
        hapusButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hapusButtonActionPerformed(evt);
            }
        });
        jPanel3.add(hapusButton);

        updateBotton.setText("Update");
        updateBotton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateBottonActionPerformed(evt);
            }
        });
        jPanel3.add(updateBotton);

        resetBotton.setText(" Reset ");
        resetBotton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetBottonActionPerformed(evt);
            }
        });
        jPanel3.add(resetBotton);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Input Mahasiswa"));

        jLabel1.setText("NPM :");

        jLabel2.setText("Nama :");

        jLabel5.setText("Password :");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtNim, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE)
                    .addComponent(txtNama, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE)
                    .addComponent(txtPwd, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtNim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtNama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtPwd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Input Lanjutan"));

        jLabel3.setText("Jurusan :");

        jLabel4.setText("Dosen :");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(comboDosen, 0, 173, Short.MAX_VALUE)
                    .addComponent(txtJurusan, javax.swing.GroupLayout.DEFAULT_SIZE, 173, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtJurusan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(comboDosen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(55, Short.MAX_VALUE))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Tabel Mahasiswa"));

        tableMhs.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tableMhs);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 569, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 605, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void inputButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputButtonActionPerformed
        // TODO add your handling code here:
        try {
            Mahasiswa mhs = new Mahasiswa();
            mhs.setNim(txtNim.getText());
            mhs.setNama(txtNama.getText());
            mhs.setProdi(txtJurusan.getText().toUpperCase());
            mhs.setKd_dosen(listDosen.get(comboDosen.getSelectedIndex()).getKd_dosen());
            mhs.setPwd(txtPwd.getText());
            mhsService.insert(mhs);
            this.statusAwal();
        } catch (RemoteException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());

        }
}//GEN-LAST:event_inputButtonActionPerformed

    private void hapusButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hapusButtonActionPerformed
        // TODO add your handling code here:
        String nim = records.get(tableMhs.getSelectedRow()).getNim();
        try {
            mhsService.delete(nim);
            this.statusAwal();
        } catch (RemoteException ex) {
            Logger.getLogger(InputMhs.class.getName()).log(Level.SEVERE, null, ex);
        }
}//GEN-LAST:event_hapusButtonActionPerformed

    private void updateBottonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateBottonActionPerformed
        // TODO add your handling code here:
        try {

            Mahasiswa mhs = records.get(tableMhs.getSelectedRow());
            mhs.setNim(txtNim.getText());
            mhs.setNama(txtNama.getText());
            mhs.setProdi(txtJurusan.getText());
            mhs.setKd_dosen(listDosen.get(comboDosen.getSelectedIndex()).getKd_dosen());
            mhs.setPwd(txtPwd.getText());
            System.out.println(mhs.getNama());
            System.out.println(mhs.getProdi());
            mhsService.update(mhs);
            this.statusAwal();
        } catch (RemoteException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());

        }
}//GEN-LAST:event_updateBottonActionPerformed

    private void resetBottonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetBottonActionPerformed
        try {
            // TODO add your handling code here:
            this.statusAwal();
        } catch (RemoteException ex) {
            Logger.getLogger(InputMhs.class.getName()).log(Level.SEVERE, null, ex);
        }
}//GEN-LAST:event_resetBottonActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox comboDosen;
    private javax.swing.JButton hapusButton;
    private javax.swing.JButton inputButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton resetBotton;
    private javax.swing.JTable tableMhs;
    private javax.swing.JTextField txtJurusan;
    private javax.swing.JTextField txtNama;
    private javax.swing.JTextField txtNim;
    private javax.swing.JPasswordField txtPwd;
    private javax.swing.JButton updateBotton;
    // End of variables declaration//GEN-END:variables
}
