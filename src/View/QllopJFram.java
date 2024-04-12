package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.border.TitledBorder;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import com.toedter.calendar.JDateChooser;

import Controller.KhoaHocController;
import Controller.LopHocController;
import Model.Lophoc;
import Service.LophocRMIService;

import java.awt.Font;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class QllopJFram extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField jtfMalophoc;
	private JTextField jtfTenlophoc;
	private JTextField jtfMasinhvien;
	private JTextField jtfMakhoahoc;

	/**
	 * Launch the application.
	 */
	/*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QllopJFram frame = new QllopJFram();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	*/
	/**
	 * Create the frame.
	 */
	public QllopJFram(Lophoc lopHoc) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 664, 392);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 644, 354);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnSubmit = new JButton("Lưu");
		btnSubmit.setFocusPainted(false);
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnSubmit.setIcon(new ImageIcon(QllopJFram.class.getResource("/Images/save-icon18x18.png")));
		btnSubmit.setFont(new Font("Times New Roman", Font.BOLD, 12));
		btnSubmit.setBackground(new Color(100, 221, 23));
		btnSubmit.setBounds(534, 22, 89, 23);
		panel.add(btnSubmit);
		
		JLabel jlbMgs = new JLabel("");
		jlbMgs.setForeground(new Color(255, 0, 0));
		jlbMgs.setBackground(new Color(240, 240, 240));
		jlbMgs.setBounds(22, 22, 180, 23);
		panel.add(jlbMgs);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Th\u00F4ng tin l\u1EDBp h\u1ECDc", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(22, 56, 601, 287);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Mã lớp học");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblNewLabel.setBounds(22, 43, 78, 14);
		panel_1.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Tên lớp học");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblNewLabel_1.setBounds(22, 92, 78, 14);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Mã sinh viên");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblNewLabel_2.setBounds(350, 43, 89, 14);
		panel_1.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Mã khóa học");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblNewLabel_3.setBounds(350, 89, 89, 14);
		panel_1.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Ngày đăng ký");
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblNewLabel_4.setBounds(22, 146, 78, 14);
		panel_1.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Tình trạng");
		lblNewLabel_5.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblNewLabel_5.setBounds(350, 146, 89, 14);
		panel_1.add(lblNewLabel_5);
		
		jtfMalophoc = new JTextField();
		jtfMalophoc.setBounds(110, 40, 130, 20);
		panel_1.add(jtfMalophoc);
		jtfMalophoc.setColumns(10);
		
		jtfTenlophoc = new JTextField();
		jtfTenlophoc.setBounds(110, 89, 130, 20);
		panel_1.add(jtfTenlophoc);
		jtfTenlophoc.setColumns(10);
		
		jtfMasinhvien = new JTextField();
		jtfMasinhvien.setBounds(449, 40, 130, 20);
		panel_1.add(jtfMasinhvien);
		jtfMasinhvien.setColumns(10);
		
		jtfMakhoahoc = new JTextField();
		jtfMakhoahoc.setBounds(449, 86, 130, 20);
		panel_1.add(jtfMakhoahoc);
		jtfMakhoahoc.setColumns(10);
		
		JCheckBox jcbKichhoat = new JCheckBox("Kích hoạt");
		jcbKichhoat.setFont(new Font("Times New Roman", Font.BOLD, 12));
		jcbKichhoat.setBounds(449, 142, 97, 23);
		panel_1.add(jcbKichhoat);
		
		JDateChooser jdcNgaydangky = new JDateChooser();
		jdcNgaydangky.setDateFormatString("dd/MM/yyyy");
		jdcNgaydangky.setBounds(110, 146, 130, 20);
		panel_1.add(jdcNgaydangky);
        
        JButton btnDelete = new JButton("Xóa");
        btnDelete.setFocusPainted(false);
        btnDelete.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	}
        });
        btnDelete.setIcon(new ImageIcon(QllopJFram.class.getResource("/Images/delete18x18.png")));
        btnDelete.setBackground(new Color(231, 41, 41));
        btnDelete.setFont(new Font("Times New Roman", Font.BOLD, 12));
        btnDelete.setBounds(419, 22, 89, 23);
        panel.add(btnDelete);
        
        JLabel lblNewLabel_5_1 = new JLabel("*");
        lblNewLabel_5_1.setForeground(Color.RED);
        lblNewLabel_5_1.setFont(new Font("Times New Roman", Font.BOLD, 14));
        lblNewLabel_5_1.setBounds(250, 95, 16, 14);
        panel_1.add(lblNewLabel_5_1);
        
        JLabel lblNewLabel_5_2 = new JLabel("*");
        lblNewLabel_5_2.setForeground(Color.RED);
        lblNewLabel_5_2.setFont(new Font("Times New Roman", Font.BOLD, 14));
        lblNewLabel_5_2.setBounds(250, 151, 16, 14);
        panel_1.add(lblNewLabel_5_2);
        
        JLabel lblNewLabel_5_3 = new JLabel("*");
        lblNewLabel_5_3.setForeground(Color.RED);
        lblNewLabel_5_3.setFont(new Font("Times New Roman", Font.BOLD, 14));
        lblNewLabel_5_3.setBounds(584, 46, 17, 14);
        panel_1.add(lblNewLabel_5_3);
        
        JLabel lblNewLabel_5_4 = new JLabel("*");
        lblNewLabel_5_4.setForeground(Color.RED);
        lblNewLabel_5_4.setFont(new Font("Times New Roman", Font.BOLD, 14));
        lblNewLabel_5_4.setBounds(584, 92, 16, 14);
        panel_1.add(lblNewLabel_5_4);
        
        JLabel lblNewLabel_5_5 = new JLabel("*");
        lblNewLabel_5_5.setForeground(Color.RED);
        lblNewLabel_5_5.setFont(new Font("Times New Roman", Font.BOLD, 14));
        lblNewLabel_5_5.setBounds(250, 47, 16, 14);
        panel_1.add(lblNewLabel_5_5);
		
		try {
            Registry registry = LocateRegistry.getRegistry("localhost", 1099);
            LophocRMIService lopHocService = (LophocRMIService) registry.lookup("LophocRMIService");
            LopHocController controller = new LopHocController(btnSubmit, btnDelete, jtfMalophoc, jtfTenlophoc, jtfMasinhvien, jtfMakhoahoc, jdcNgaydangky, jcbKichhoat, jlbMgs);
    		controller.setView(lopHoc);
    		controller.setEvent();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
	}
}
