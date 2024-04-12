package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import com.toedter.calendar.JDateChooser;

import Controller.KhoaHocController;
import Model.Khoahoc;
import Service.KhoahocRMIService;

import java.awt.Font;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class QlkhoaJFram extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField jtfMakhoahoc;
	private JTextField jtfTenkhoahoc;

	/**
	 * Launch the application.
	 */
	/*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QlkhoaJFram frame = new QlkhoaJFram();
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
	public QlkhoaJFram(Khoahoc khoaHoc) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 664, 384);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 644, 346);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnSubmit = new JButton("Lưu");
		btnSubmit.setFocusPainted(false);
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnSubmit.setIcon(new ImageIcon(QlkhoaJFram.class.getResource("/Images/save-icon18x18.png")));
		btnSubmit.setFont(new Font("Times New Roman", Font.BOLD, 12));
		btnSubmit.setBackground(new Color(100, 221, 23));
		btnSubmit.setBounds(530, 11, 89, 23);
		panel.add(btnSubmit);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Th\u00F4ng tin kh\u00F3a h\u1ECDc", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(27, 50, 592, 285);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Mã khóa học");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblNewLabel.setBounds(22, 39, 82, 14);
		panel_1.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Tên khóa học");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblNewLabel_1.setBounds(22, 101, 82, 14);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Ngày bắt đầu");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblNewLabel_2.setBounds(346, 39, 85, 14);
		panel_1.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Ngày kết thúc");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblNewLabel_3.setBounds(346, 101, 85, 14);
		panel_1.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Tình trạng");
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblNewLabel_4.setBounds(22, 168, 82, 14);
		panel_1.add(lblNewLabel_4);
		
		jtfMakhoahoc = new JTextField();
		jtfMakhoahoc.setBounds(132, 36, 120, 20);
		panel_1.add(jtfMakhoahoc);
		jtfMakhoahoc.setColumns(10);
		
		jtfTenkhoahoc = new JTextField();
		jtfTenkhoahoc.setBounds(132, 98, 120, 20);
		panel_1.add(jtfTenkhoahoc);
		jtfTenkhoahoc.setColumns(10);
		
		JCheckBox jcbKichhoat = new JCheckBox("Kích hoạt");
		jcbKichhoat.setFont(new Font("Times New Roman", Font.BOLD, 12));
		jcbKichhoat.setBounds(132, 164, 97, 23);
		panel_1.add(jcbKichhoat);
		
		JDateChooser jdcNgaybatdau = new JDateChooser();
		jdcNgaybatdau.setDateFormatString("dd/MM/yyyy");
		jdcNgaybatdau.setBounds(441, 36, 120, 20);
		panel_1.add(jdcNgaybatdau);
		
		JDateChooser jdcNgayketthuc = new JDateChooser();
		jdcNgayketthuc.setDateFormatString("dd/MM/yyyy");
		jdcNgayketthuc.setBounds(441, 101, 120, 20);
		panel_1.add(jdcNgayketthuc);
		
		JLabel jlbMsg = new JLabel("");
		jlbMsg.setForeground(new Color(255, 0, 0));
		jlbMsg.setBounds(27, 11, 168, 23);
		panel.add(jlbMsg);
		
        JButton btnDelete = new JButton("Xóa");
        btnDelete.setFocusPainted(false);
        btnDelete.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	}
        });
        btnDelete.setIcon(new ImageIcon(QlkhoaJFram.class.getResource("/Images/delete18x18.png")));
        btnDelete.setFont(new Font("Times New Roman", Font.BOLD, 12));
        btnDelete.setBackground(new Color(231, 41, 41));
        btnDelete.setBounds(419, 11, 89, 23);
        panel.add(btnDelete);

        JLabel lblNewLabel_5 = new JLabel("*");
        lblNewLabel_5.setFont(new Font("Times New Roman", Font.BOLD, 14));
        lblNewLabel_5.setForeground(new Color(255, 0, 0));
        lblNewLabel_5.setBounds(261, 39, 16, 14);
        panel_1.add(lblNewLabel_5);
        
        JLabel lblNewLabel_5_1 = new JLabel("*");
        lblNewLabel_5_1.setForeground(Color.RED);
        lblNewLabel_5_1.setFont(new Font("Times New Roman", Font.BOLD, 14));
        lblNewLabel_5_1.setBounds(566, 38, 16, 14);
        panel_1.add(lblNewLabel_5_1);
        
        JLabel lblNewLabel_5_2 = new JLabel("*");
        lblNewLabel_5_2.setForeground(Color.RED);
        lblNewLabel_5_2.setFont(new Font("Times New Roman", Font.BOLD, 14));
        lblNewLabel_5_2.setBounds(566, 104, 16, 14);
        panel_1.add(lblNewLabel_5_2);
        
        JLabel lblNewLabel_5_3 = new JLabel("*");
        lblNewLabel_5_3.setForeground(Color.RED);
        lblNewLabel_5_3.setFont(new Font("Times New Roman", Font.BOLD, 14));
        lblNewLabel_5_3.setBounds(262, 104, 16, 14);
        panel_1.add(lblNewLabel_5_3);
        
		try {
            Registry registry = LocateRegistry.getRegistry("localhost", 1099);
            KhoahocRMIService khoaHocService = (KhoahocRMIService) registry.lookup("KhoahocRMIService");
            KhoaHocController controller = new KhoaHocController(btnSubmit, btnDelete, jtfMakhoahoc, jtfTenkhoahoc, jdcNgaybatdau, jdcNgayketthuc, jcbKichhoat, jlbMsg);           
    		controller.setView(khoaHoc);
    		controller.setEvent();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
	}
}
