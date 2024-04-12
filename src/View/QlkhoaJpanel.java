package View;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JTextField;

import Controller.QuanLyKhoaHocController;
import Service.KhoahocRMIService;
import java.awt.Font;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class QlkhoaJpanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField jtfSearch;

	/**
	 * Create the panel.
	 */
	public QlkhoaJpanel() {
		setBackground(new Color(255, 255, 255));
		setLayout(null);
		
		JPanel jpnRoot = new JPanel();
		jpnRoot.setBackground(new Color(240, 240, 240));
		jpnRoot.setBounds(0, 11, 763, 563);
		add(jpnRoot);
		jpnRoot.setLayout(null);
		
		JButton btnAdd = new JButton("Thêm");
		btnAdd.setFocusPainted(false);
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnAdd.setIcon(new ImageIcon(QlkhoaJpanel.class.getResource("/Images/add-icon24x24.png")));
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
        btnPrint.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	}
        });
        btnPrint.setIcon(new ImageIcon(QlkhoaJpanel.class.getResource("/Images/print24x24.png")));
        btnPrint.setBackground(new Color(100, 221, 23));
        btnPrint.setFont(new Font("Times New Roman", Font.BOLD, 16));
        btnPrint.setForeground(new Color(0, 0, 0));
        btnPrint.setBounds(497, 25, 132, 29);
        jpnRoot.add(btnPrint);

        JLabel lblNewLabel = new JLabel("Tìm Kiếm");
        lblNewLabel.setIcon(new ImageIcon(QlkhoaJpanel.class.getResource("/Images/search-icon24x24.jpg")));
        lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 16));
        lblNewLabel.setBounds(10, 25, 100, 29);
        jpnRoot.add(lblNewLabel);
		
		try {
            Registry registry = LocateRegistry.getRegistry("localhost", 1099);
            KhoahocRMIService khoaHocService = (KhoahocRMIService) registry.lookup("KhoahocRMIService");
            QuanLyKhoaHocController controller = new QuanLyKhoaHocController(jpnView, btnAdd, btnPrint, jtfSearch);
            controller.setDataToTable();
            controller.setEvent();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

	}
}
