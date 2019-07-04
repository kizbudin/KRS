/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * MainAdmin.java
 *
 * Created on Oct 16, 2010, 6:50:27 PM
 */
package stta.bahrie.admin.gui;

import api.stta.bahrie.entiy.Dosen;
import api.stta.bahrie.inter.DosenInterf;
import api.stta.bahrie.inter.MahasiswaInterf;
import api.stta.bahrie.inter.MkInterf;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author bahrie
 */
public class MainAdmin extends javax.swing.JFrame {

    MkInterf mkService;
    DosenInterf dsnService;
    MahasiswaInterf mhsService;

    /** Creates new form MainAdmin */
    public MainAdmin(DosenInterf dsnSevice, MahasiswaInterf mhsService, MkInterf mkService) {
        this.dsnService = dsnSevice;
        this.mkService = mkService;
        this.mhsService = mhsService;

        initComponents();
        this.setMenu(false);
    }

    void setMenu(boolean status) {
        menuMhs.setVisible(status);
        menuMk.setVisible(status);
        menuDosen.setVisible(status);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dialogLogin = new javax.swing.JDialog();
        txtLoginAdmin = new javax.swing.JTextField();
        loginButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();
        txtPwd = new javax.swing.JPasswordField();
        jLabel8 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        desktopPane = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        menuLogin = new javax.swing.JMenuItem();
        menuLogout = new javax.swing.JMenuItem();
        menuExit = new javax.swing.JMenuItem();
        menuMhs = new javax.swing.JMenu();
        inputmhs = new javax.swing.JMenuItem();
        menuMk = new javax.swing.JMenu();
        inputMk = new javax.swing.JMenuItem();
        menuDosen = new javax.swing.JMenu();
        inputDosen = new javax.swing.JMenuItem();

        txtLoginAdmin.setText("admin");

        loginButton.setText("Login");
        loginButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginButtonActionPerformed(evt);
            }
        });

        cancelButton.setText("Cancel");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        txtPwd.setText("adminadmin");

        jLabel8.setText("Password");

        jLabel7.setText("Admin");

        javax.swing.GroupLayout dialogLoginLayout = new javax.swing.GroupLayout(dialogLogin.getContentPane());
        dialogLogin.getContentPane().setLayout(dialogLoginLayout);
        dialogLoginLayout.setHorizontalGroup(
            dialogLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 307, Short.MAX_VALUE)
            .addGap(0, 307, Short.MAX_VALUE)
            .addGroup(dialogLoginLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(dialogLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(dialogLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(dialogLoginLayout.createSequentialGroup()
                        .addComponent(cancelButton, javax.swing.GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(loginButton, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtPwd, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                    .addComponent(txtLoginAdmin, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE))
                .addContainerGap())
        );
        dialogLoginLayout.setVerticalGroup(
            dialogLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 122, Short.MAX_VALUE)
            .addGap(0, 122, Short.MAX_VALUE)
            .addGroup(dialogLoginLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(dialogLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtLoginAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(dialogLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtPwd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(dialogLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(loginButton)
                    .addComponent(cancelButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jMenu1.setText("Menu");

        menuLogin.setText("Login");
        menuLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuLoginActionPerformed(evt);
            }
        });
        jMenu1.add(menuLogin);

        menuLogout.setText("Logout");
        menuLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuLogoutActionPerformed(evt);
            }
        });
        jMenu1.add(menuLogout);

        menuExit.setText("Exit");
        menuExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuExitActionPerformed(evt);
            }
        });
        jMenu1.add(menuExit);

        jMenuBar1.add(jMenu1);

        menuMhs.setText("Mahasiswa");
        menuMhs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuMhsActionPerformed(evt);
            }
        });

        inputmhs.setText("Input Mahasiswa");
        inputmhs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputmhsActionPerformed(evt);
            }
        });
        menuMhs.add(inputmhs);

        jMenuBar1.add(menuMhs);

        menuMk.setText("Mata Kuliah");
        menuMk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuMkActionPerformed(evt);
            }
        });

        inputMk.setText("Input Mata Kuliah");
        inputMk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputMkActionPerformed(evt);
            }
        });
        menuMk.add(inputMk);

        jMenuBar1.add(menuMk);

        menuDosen.setText("Dosen");

        inputDosen.setText("input Dosen");
        inputDosen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputDosenActionPerformed(evt);
            }
        });
        menuDosen.add(inputDosen);

        jMenuBar1.add(menuDosen);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktopPane, javax.swing.GroupLayout.DEFAULT_SIZE, 479, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktopPane, javax.swing.GroupLayout.DEFAULT_SIZE, 367, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void menuLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuLoginActionPerformed
        // TODO add your handling code here:
        dialogLogin.setSize(330, 140);
        dialogLogin.setLocationRelativeTo(null);
        dialogLogin.setVisible(true);
    }//GEN-LAST:event_menuLoginActionPerformed

    private void menuExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuExitActionPerformed
        // TODO add your handling code here:
        System.exit(1);
    }//GEN-LAST:event_menuExitActionPerformed

    private void menuMhsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuMhsActionPerformed
    }//GEN-LAST:event_menuMhsActionPerformed

    private void loginButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginButtonActionPerformed
        // TODO add your handling code here:

        if (txtLoginAdmin.getText().equals("admin") && txtPwd.getText().equals("adminadmin")) {

            this.setMenu(true);
            txtLoginAdmin.setText("");
            txtPwd.setText("");
            dialogLogin.setVisible(false);
        }
    }//GEN-LAST:event_loginButtonActionPerformed

    private void menuLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuLogoutActionPerformed
        // TODO add your handling code here:
        this.setMenu(false);
    }//GEN-LAST:event_menuLogoutActionPerformed

    private void menuMkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuMkActionPerformed
//        
    }//GEN-LAST:event_menuMkActionPerformed

    private void inputmhsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputmhsActionPerformed
        
            // TODO add your handling code here:
            InputMhs mhsForm = new InputMhs(mhsService, dsnService);
            desktopPane.add(mhsForm);   
            mhsForm.setVisible(true);
        
    }//GEN-LAST:event_inputmhsActionPerformed

    private void inputMkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputMkActionPerformed
        // TODO add your handling code here:
        InputMk mkForm = new InputMk(mkService,dsnService);
        desktopPane.add(mkForm);
        mkForm.setVisible(true);
    }//GEN-LAST:event_inputMkActionPerformed

    private void inputDosenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputDosenActionPerformed
        // TODO add your handling code here:
        InputDosen dsnForm=new InputDosen(dsnService);
        desktopPane.add(dsnForm);
        dsnForm.setVisible(true);
    }//GEN-LAST:event_inputDosenActionPerformed

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        // TODO add your handling code here:
        dialogLogin.setVisible(false);
    }//GEN-LAST:event_cancelButtonActionPerformed
    /**
     * @param args the command line arguments
     */
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelButton;
    private javax.swing.JDesktopPane desktopPane;
    private javax.swing.JDialog dialogLogin;
    private javax.swing.JMenuItem inputDosen;
    private javax.swing.JMenuItem inputMk;
    private javax.swing.JMenuItem inputmhs;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JButton loginButton;
    private javax.swing.JMenu menuDosen;
    private javax.swing.JMenuItem menuExit;
    private javax.swing.JMenuItem menuLogin;
    private javax.swing.JMenuItem menuLogout;
    private javax.swing.JMenu menuMhs;
    private javax.swing.JMenu menuMk;
    private javax.swing.JTextField txtLoginAdmin;
    private javax.swing.JPasswordField txtPwd;
    // End of variables declaration//GEN-END:variables
}
