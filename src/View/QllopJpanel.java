package View;

import javax.swing.JPanel;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import javax.swing.JButton;
import javax.swing.JTextField;

import Controller.QuanLyLopHocController;
import Service.LophocRMIService;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.ImageIcon;

public class QllopJpanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField jtfSearch;

	/**
	 * Create the panel.
	 */
	public QllopJpanel() {
		setBackground(new Color(255, 255, 255));
		setLayout(null);
		
		JPanel jpnRoot = new JPanel();
		jpnRoot.setBounds(0, 11, 763, 563);
		add(jpnRoot);
		jpnRoot.setLayout(null);
		
		JButton btnAdd = new JButton("Thêm");
		btnAdd.setFocusPainted(false);
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnAdd.setIcon(new ImageIcon(QllopJpanel.class.getResource("/Images/add-icon24x24.png")));
		btnAdd.setBackground(new Color(100, 221, 23));
		btnAdd.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnAdd.setBounds(639, 25, 114, 29);
		jpnRoot.add(btnAdd);
		
		jtfSearch = new JTextField();
		jtfSearch.setFont(new Font("Times New Roman", Font.BOLD, 12));
		jtfSearch.setBounds(120, 26, 150, 29);
		jpnRoot.add(jtfSearch);
		jtfSearch.setColumns(10);
		
		JPanel jpnView = new JPanel();
		jpnView.setBounds(10, 76, 743, 476);
		jpnRoot.add(jpnView);
		
		JButton btnPrint = new JButton("Xuất File");
		 btnPrint.setFocusPainted(false);
		btnPrint.setIcon(new ImageIcon(QllopJpanel.class.getResource("/Images/print24x24.png")));
		btnPrint.setBackground(new Color(100, 221, 23));
        btnPrint.setFont(new Font("Times New Roman", Font.BOLD, 16));
        btnPrint.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	}
        });
        btnPrint.setBounds(497, 25, 132, 29);
        jpnRoot.add(btnPrint);

        JLabel lblNewLabel = new JLabel("Tìm Kiếm");
        lblNewLabel.setIcon(new ImageIcon(QllopJpanel.class.getResource("/Images/search-icon24x24.jpg")));
        lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 16));
        lblNewLabel.setBounds(10, 25, 100, 29);
        jpnRoot.add(lblNewLabel);
		
		try {
            Registry registry = LocateRegistry.getRegistry("localhost", 1099);
            LophocRMIService lopHocService = (LophocRMIService) registry.lookup("LophocRMIService");
            QuanLyLopHocController controller = new QuanLyLopHocController(jpnView, btnAdd, btnPrint, jtfSearch);
            controller.setDataToTable();
            controller.setEvent();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
		
	}
}
