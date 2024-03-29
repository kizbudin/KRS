/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package stta.bahrie.krsadmin;

import api.stta.bahrie.inter.DosenInterf;
import api.stta.bahrie.inter.MahasiswaInterf;
import api.stta.bahrie.inter.MkInterf;
import com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import stta.bahrie.admin.gui.InputMhs;
import stta.bahrie.admin.gui.MainAdmin;

/**
 *
 * @author bahrie
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)throws RemoteException, NotBoundException, MalformedURLException {
        // TODO code application logic here
        String host="localhost";
//        Registry registry=LocateRegistry.getRegistry("localhost",4321);
//        final MahasiswaInterf mhsService=(MahasiswaInterf) registry.lookup("mhsServer");
//        final MkInterf mkService=(MkInterf) registry.lookup("mkServer");
//        final DosenInterf dsnService=(DosenInterf) registry.lookup("dosenServer");
        final MahasiswaInterf mhsService=(MahasiswaInterf) Naming.lookup("rmi://"+host+":4321/mhsServer");
        final MkInterf mkService=(MkInterf) Naming.lookup("rmi://"+host+":4321/mkServer");
        final DosenInterf dsnService=(DosenInterf) Naming.lookup("rmi://"+host+":4321/dosenServer");
        System.out.println("Client Admin jalan juga bro");
        try {
            UIManager.setLookAndFeel(new NimbusLookAndFeel());
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        SwingUtilities.invokeLater(new Runnable() {

            public void run() {
                try {
                    MainAdmin mainAd=new MainAdmin(dsnService, mhsService, mkService);
                    mainAd.setExtendedState(JFrame.MAXIMIZED_BOTH);
                    mainAd.setLocationRelativeTo(null);
                    mainAd.setVisible(true);
                } catch (Throwable ex) {
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

}
