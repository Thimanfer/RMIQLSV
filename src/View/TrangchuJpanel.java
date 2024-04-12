package View;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Canvas;
import java.awt.Panel;
import java.awt.ScrollPane;
import javax.swing.ImageIcon;
import javax.swing.JTextArea;
import javax.swing.JTextPane;

public class TrangchuJpanel extends JPanel {

	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public TrangchuJpanel() {
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(0, 0, 773, 585);
		add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBounds(0, 11, 763, 83);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("HỆ THỐNG QUẢN LÝ SINH VIÊN CHO TRUNG TÂM");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblNewLabel.setBounds(10, 27, 743, 35);
		panel_1.add(lblNewLabel);
		
		Panel panel_2 = new Panel();
		panel_2.setBackground(new Color(255, 255, 255));
		panel_2.setBounds(10, 100, 753, 475);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(TrangchuJpanel.class.getResource("/Images/trangchu3.jpg")));
		lblNewLabel_1.setBounds(38, 45, 275, 191);
		panel_2.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(TrangchuJpanel.class.getResource("/Images/trangchu1.jpg")));
		lblNewLabel_2.setBounds(440, 244, 275, 191);
		panel_2.add(lblNewLabel_2);
		
		JTextPane txtpnTrungTmo = new JTextPane();
		txtpnTrungTmo.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		txtpnTrungTmo.setText("Về chúng tôi:\r\n\r\nHệ thống Quản lý Sinh viên cho Trung Tâm là một công cụ mạnh mẽ được xây dựng dành riêng cho các tổ chức giáo dục và đào tạo. Chúng tôi cung cấp các giải pháp thông minh để quản lý thông tin sinh viên, khóa học và lớp học, giúp bạn tối ưu hóa quản lý và tăng cường trải nghiệm của sinh viên.");
		txtpnTrungTmo.setBounds(360, 45, 355, 182);
		panel_2.add(txtpnTrungTmo);
		
		JTextPane txtpnLinH = new JTextPane();
		txtpnLinH.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		txtpnLinH.setText("Liên hệ:\r\n\r\nĐể biết thêm thông tin, vui lòng liên hệ:\r\n\r\nĐịa chỉ: 123 Đường ABC, Thành phố XYZ\r\nSố điện thoại: 0123 456 789\r\nEmail: info@ittrainingcenter.com");
		txtpnLinH.setBounds(38, 272, 308, 163);
		panel_2.add(txtpnLinH);

	}
}
