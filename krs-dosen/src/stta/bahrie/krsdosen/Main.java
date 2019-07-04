/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package stta.bahrie.krsdosen;

import api.stta.bahrie.inter.DetailKrsInterf;
import api.stta.bahrie.inter.DosenInterf;
import api.stta.bahrie.inter.MahasiswaInterf;
import api.stta.bahrie.inter.MkInterf;
import api.stta.bahrie.inter.WaktuKrsInterf;
import com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import stta.bahrie.krsdosen.Gui.MenuForDosen;

/**
 *
 * @author bahrie
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws RemoteException, NotBoundException {
        // TODO code application logic here
        Registry registry = LocateRegistry.getRegistry("localhost", 4321);

        final MahasiswaInterf mhsService = (MahasiswaInterf) registry.lookup("mhsServer");
        final MkInterf mkService = (MkInterf) registry.lookup("mkServer");
        final DosenInterf dsnService = (DosenInterf) registry.lookup("dosenServer");
        final DetailKrsInterf detailService = (DetailKrsInterf) registry.lookup("detailServer");
        try {
            UIManager.setLookAndFeel(new NimbusLookAndFeel());
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        MenuForDosen menu = new MenuForDosen(mhsService, mkService, dsnService, detailService);
        menu.setLocationRelativeTo(null);
        menu.setVisible(true);
    }
}
