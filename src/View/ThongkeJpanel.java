package View;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import javax.swing.JPanel;

import Controller.QuanLySinhVienController;
import Controller.QuanLyThongKeController;
import Service.SinhvienRMIService;
import java.awt.Color;
import Service.ThongkeRMIService;

public class ThongkeJpanel extends JPanel {

    private static final long serialVersionUID = 1L;
    
    /**
     * Create the panel.
     */
    public ThongkeJpanel() {
    	setBackground(new Color(255, 255, 255));
        setLayout(null);
    
        JPanel Jpnview1 = new JPanel();
        Jpnview1.setBounds(0, 11, 759, 235);
        Jpnview1.setBackground(new Color(255, 255, 255));
        add(Jpnview1);
        
        JPanel Jpnview2 = new JPanel();
        Jpnview2.setBounds(0, 257, 759, 235);
        Jpnview2.setBackground(new Color(255, 255, 255));
        add(Jpnview2);
        
        try {
            Registry registry = LocateRegistry.getRegistry("localhost", 1099);
            QuanLyThongKeController controller = new QuanLyThongKeController();
            controller.setDataToChart1(Jpnview1);
            controller.setDataToChart2(Jpnview2);
        } catch (RemoteException ex) {
            ex.printStackTrace();
        }
    }
}