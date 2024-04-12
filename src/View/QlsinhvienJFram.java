package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import java.awt.Font;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ButtonGroup;
import com.toedter.calendar.JDayChooser;

import Controller.QuanLySinhVienController;
import Controller.SinhVienController;
import Model.Sinhvien;
import Service.SinhvienRMIService;

import javax.swing.LayoutStyle.ComponentPlacement;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class QlsinhvienJFram extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField jtfMasinhvien;
	private JTextField jtfHoten;
	private JTextField jtfSodienthoai;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	/*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QlsinhvienJFram frame = new QlsinhvienJFram();
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
	public QlsinhvienJFram(Sinhvien sinhVien) {/*sua doi*/
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);/*sua doi*/
		setBounds(100, 100, 660, 385);
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
		btnSubmit.setIcon(new ImageIcon(QlsinhvienJFram.class.getResource("/Images/save-icon18x18.png")));
		btnSubmit.setFont(new Font("Times New Roman", Font.BOLD, 12));
		btnSubmit.setBackground(new Color(100, 221, 23));
		btnSubmit.setBounds(534, 11, 89, 23);
		panel.add(btnSubmit);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Th\u00F4ng tin sinh vi\u00EAn", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(22, 45, 601, 290);
		panel.add(panel_1);
		
		JLabel lblNewLabel = new JLabel("Mã sinh viên");
		lblNewLabel.setBounds(20, 32, 90, 14);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 12));
		
		JLabel lblNewLabel_1 = new JLabel("Họ và tên");
		lblNewLabel_1.setBounds(20, 70, 90, 14);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 12));
		
		JLabel lblNewLabel_2 = new JLabel("Ngày sinh");
		lblNewLabel_2.setBounds(20, 114, 90, 14);
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 12));
		
		JLabel lblNewLabel_3 = new JLabel("Giới tính");
		lblNewLabel_3.setBounds(20, 158, 90, 14);
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 12));
		
		JLabel lblNewLabel_4 = new JLabel("Số điện thoại");
		lblNewLabel_4.setBounds(325, 32, 96, 14);
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.BOLD, 12));
		
		JLabel lblNewLabel_5 = new JLabel("Tình trạng");
		lblNewLabel_5.setBounds(325, 70, 96, 14);
		lblNewLabel_5.setFont(new Font("Times New Roman", Font.BOLD, 12));
		
		JLabel lblNewLabel_6 = new JLabel("Địa chỉ");
		lblNewLabel_6.setBounds(325, 109, 96, 14);
		lblNewLabel_6.setFont(new Font("Times New Roman", Font.BOLD, 12));
		
		jtfMasinhvien = new JTextField();
		jtfMasinhvien.setBounds(120, 29, 150, 20);
		jtfMasinhvien.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		jtfMasinhvien.setColumns(10);
		
		jtfHoten = new JTextField();
		jtfHoten.setBounds(120, 67, 150, 20);
		jtfHoten.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		jtfHoten.setColumns(10);
		
		jtfSodienthoai = new JTextField();
		jtfSodienthoai.setBounds(431, 29, 150, 20);
		jtfSodienthoai.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		jtfSodienthoai.setColumns(10);
		
		JRadioButton jtfNam = new JRadioButton("Nam");
		jtfNam.setBounds(123, 154, 65, 23);
		buttonGroup.add(jtfNam);
		jtfNam.setFont(new Font("Times New Roman", Font.BOLD, 12));
		
		JRadioButton jtfNu = new JRadioButton("Nữ");
		jtfNu.setBounds(190, 154, 65, 23);
		buttonGroup.add(jtfNu);
		jtfNu.setFont(new Font("Times New Roman", Font.BOLD, 12));
		
		JCheckBox jcbKichhoat = new JCheckBox("Kích hoạt");
		jcbKichhoat.setBounds(431, 66, 97, 23);
		jcbKichhoat.setBackground(new Color(240, 240, 240));
		jcbKichhoat.setForeground(new Color(0, 0, 0));
		jcbKichhoat.setFont(new Font("Times New Roman", Font.BOLD, 12));
		
		JTextArea jtaDiachi = new JTextArea();
		jtaDiachi.setBounds(431, 107, 150, 58);
		jtaDiachi.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		
		JDateChooser jdcNgaysinh = new JDateChooser();
		jdcNgaysinh.setBounds(120, 114, 150, 20);
		jdcNgaysinh.setDateFormatString("dd/MM/yyyy");
		
		JLabel lblNewLabel_5_1 = new JLabel("*");
		lblNewLabel_5_1.setBounds(280, 30, 16, 17);
		lblNewLabel_5_1.setForeground(Color.RED);
		lblNewLabel_5_1.setFont(new Font("Times New Roman", Font.BOLD, 14));
		
		JLabel lblNewLabel_5_2 = new JLabel("*");
		lblNewLabel_5_2.setBounds(280, 68, 16, 17);
		lblNewLabel_5_2.setForeground(Color.RED);
		lblNewLabel_5_2.setFont(new Font("Times New Roman", Font.BOLD, 14));
		
		JLabel lblNewLabel_5_3 = new JLabel("*");
		lblNewLabel_5_3.setBounds(280, 117, 16, 17);
		lblNewLabel_5_3.setForeground(Color.RED);
		lblNewLabel_5_3.setFont(new Font("Times New Roman", Font.BOLD, 14));
		
		JLabel jlbMsg = new JLabel("");
		jlbMsg.setForeground(new Color(255, 0, 0));
		jlbMsg.setBounds(22, 11, 176, 23);
		panel.add(jlbMsg);
		
		JButton btnDelete = new JButton("Xóa");
		btnDelete.setFocusPainted(false);
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnDelete.setIcon(new ImageIcon(QlsinhvienJFram.class.getResource("/Images/delete18x18.png")));
		btnDelete.setFont(new Font("Times New Roman", Font.BOLD, 12));
		btnDelete.setBackground(new Color(231, 41, 41));
        btnDelete.setBounds(406, 11, 89, 23);
        panel.add(btnDelete);
        
        panel_1.setLayout(null);
        panel_1.add(lblNewLabel);
        panel_1.add(jtfMasinhvien);
        panel_1.add(lblNewLabel_5_1);
        panel_1.add(lblNewLabel_4);
        panel_1.add(jtfSodienthoai);
        panel_1.add(lblNewLabel_2);
        panel_1.add(lblNewLabel_3);
        panel_1.add(jdcNgaysinh);
        panel_1.add(lblNewLabel_5_3);
        panel_1.add(lblNewLabel_6);
        panel_1.add(jtfNam);
        panel_1.add(jtfNu);
        panel_1.add(lblNewLabel_1);
        panel_1.add(jtfHoten);
        panel_1.add(lblNewLabel_5_2);
        panel_1.add(lblNewLabel_5);
        panel_1.add(jtaDiachi);
        panel_1.add(jcbKichhoat);
		
		/**/
		try {
            Registry registry = LocateRegistry.getRegistry("localhost", 1099);
            SinhvienRMIService sinhVienService = (SinhvienRMIService) registry.lookup("SinhvienRMIService");
            SinhVienController controller = new SinhVienController(btnSubmit, btnDelete, jtfMasinhvien, jtfHoten, jdcNgaysinh, jtfSodienthoai, jtfNam, jtfNu, jtaDiachi, jcbKichhoat,jlbMsg);
    		controller.setView(sinhVien);
    		controller.setEvent();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
	}
}
