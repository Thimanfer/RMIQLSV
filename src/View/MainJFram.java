package View;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JSplitPane;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

import Bean.DanhMucBean; 
import Controller.ChuyenManHinhController;
import javax.swing.JButton;
import javax.swing.JDialog;

public class MainJFram extends JFrame {

	 private static final long serialVersionUID = 1L;
	    private JPanel jpnRoot;
	    private static String loggedInUsername;
	    
	    public static void setLoggedInUsername(String username) {
	        loggedInUsername = username;
	    }

	    public static String getLoggedInUsername() {
	        return loggedInUsername;
	    }
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					MainJFram frame = new MainJFram();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public MainJFram() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 624);
		jpnRoot = new JPanel();
		jpnRoot.setBackground(new Color(255, 255, 255));
		jpnRoot.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(jpnRoot);
		jpnRoot.setLayout(null);
		
		JPanel jpnMenu = new JPanel();
		jpnMenu.setBackground(new Color(240, 240, 240));
		jpnMenu.setBounds(10, 0, 201, 585);
		jpnRoot.add(jpnMenu);
		jpnMenu.setLayout(null);
		
		JPanel jpnTitle = new JPanel();
		jpnTitle.setBounds(0, 0, 201, 70);
		jpnTitle.setForeground(new Color(255, 255, 255));
		jpnTitle.setBackground(new Color(255, 128, 0));
		jpnMenu.add(jpnTitle);
		jpnTitle.setLayout(null);
		
		JLabel jlbTitle = new JLabel("Quản lý sinh viên");
		jlbTitle.setIcon(new ImageIcon(MainJFram.class.getResource("/Images/Student24x24.jpg")));
		jlbTitle.setHorizontalAlignment(SwingConstants.CENTER);
		jlbTitle.setBounds(10, 11, 181, 35);
		jpnTitle.add(jlbTitle);
		jlbTitle.setFont(new Font("Times New Roman", Font.BOLD, 20));
		jlbTitle.setForeground(new Color(255, 255, 255));
		
		JPanel jpnTrangchu = new JPanel();
		jpnTrangchu.setBounds(10, 81, 181, 50);
		jpnTrangchu.setBackground(new Color(96, 191, 100));
		jpnMenu.add(jpnTrangchu);
		jpnTrangchu.setLayout(null);
		
		JLabel jlbTrangchu = new JLabel("Trang Chủ");
		jlbTrangchu.setIcon(new ImageIcon(MainJFram.class.getResource("/Images/home-icon24x24.png")));
		jlbTrangchu.setBounds(0, 11, 181, 28);
		jlbTrangchu.setHorizontalAlignment(SwingConstants.CENTER);
		jlbTrangchu.setForeground(new Color(255, 255, 255));
		jlbTrangchu.setFont(new Font("Times New Roman", Font.BOLD, 18));
		jpnTrangchu.add(jlbTrangchu);
		
		JPanel jpnQlsinhvien = new JPanel();
		jpnQlsinhvien.setBounds(10, 142, 181, 50);
		jpnQlsinhvien.setBackground(new Color(96, 191, 100));
		jpnMenu.add(jpnQlsinhvien);
		jpnQlsinhvien.setLayout(null);
		
		JLabel jlbQlsinhvien = new JLabel("Quản lý sinh viên");
		jlbQlsinhvien.setIcon(new ImageIcon(MainJFram.class.getResource("/Images/quanlysinhvien24x24.png")));
		jlbQlsinhvien.setHorizontalAlignment(SwingConstants.CENTER);
		jlbQlsinhvien.setBounds(0, 11, 181, 28);
		jlbQlsinhvien.setForeground(new Color(255, 255, 255));
		jlbQlsinhvien.setFont(new Font("Times New Roman", Font.BOLD, 18));
		jpnQlsinhvien.add(jlbQlsinhvien);
		
		JPanel jpnQlkhoa = new JPanel();
		jpnQlkhoa.setBounds(10, 203, 181, 50);
		jpnQlkhoa.setBackground(new Color(96, 191, 100));
		jpnMenu.add(jpnQlkhoa);
		jpnQlkhoa.setLayout(null);
		
		JLabel jlbQlkhoa = new JLabel("Quản lý khóa học");
		jlbQlkhoa.setIcon(new ImageIcon(MainJFram.class.getResource("/Images/khoahoc24x24.png")));
		jlbQlkhoa.setHorizontalAlignment(SwingConstants.CENTER);
		jlbQlkhoa.setBounds(0, 11, 181, 28);
		jlbQlkhoa.setForeground(new Color(255, 255, 255));
		jlbQlkhoa.setFont(new Font("Times New Roman", Font.BOLD, 18));
		jpnQlkhoa.add(jlbQlkhoa);
		
		JPanel jpnQllop = new JPanel();
		jpnQllop.setBounds(10, 264, 181, 50);
		jpnQllop.setBackground(new Color(96, 191, 100));
		jpnMenu.add(jpnQllop);
		jpnQllop.setLayout(null);
		
		JLabel jlbQllop = new JLabel(" Quản lý lớp học");
		jlbQllop.setIcon(new ImageIcon(MainJFram.class.getResource("/Images/class24x24.png")));
		jlbQllop.setHorizontalAlignment(SwingConstants.CENTER);
		jlbQllop.setBounds(0, 11, 181, 28);
		jlbQllop.setForeground(new Color(255, 255, 255));
		jlbQllop.setFont(new Font("Times New Roman", Font.BOLD, 18));
		jpnQllop.add(jlbQllop);
		
		JPanel jpnThongke = new JPanel();
		jpnThongke.setBounds(10, 325, 181, 50);
		jpnThongke.setBackground(new Color(96, 191, 100));
		jpnMenu.add(jpnThongke);
		jpnThongke.setLayout(null);
		
		JLabel jlbThongke = new JLabel("Thống kê dữ liệu");
		jlbThongke.setIcon(new ImageIcon(MainJFram.class.getResource("/Images/thongke24x24.jpg")));
		jlbThongke.setHorizontalAlignment(SwingConstants.CENTER);
		jlbThongke.setBounds(0, 11, 181, 28);
		jlbThongke.setForeground(new Color(255, 255, 255));
		jlbThongke.setFont(new Font("Times New Roman", Font.BOLD, 18));
		jpnThongke.add(jlbThongke);
		
		//
		
		//
		JPanel jpnView = new JPanel();
		jpnView.setBounds(211, 0, 773, 585);
		jpnRoot.add(jpnView);
		
		//ChuyenManHinhController//
		List<DanhMucBean> listItem = new ArrayList<>();
		listItem.add(new DanhMucBean("Trangchu", jpnTrangchu, jlbTrangchu));
		listItem.add(new DanhMucBean("Sinhvien", jpnQlsinhvien, jlbQlsinhvien));
		listItem.add(new DanhMucBean("Khoahoc", jpnQlkhoa, jlbQlkhoa));
		listItem.add(new DanhMucBean("Lophoc", jpnQllop, jlbQllop));
		listItem.add(new DanhMucBean("Thongke", jpnThongke, jlbThongke));

        ChuyenManHinhController controller = new ChuyenManHinhController(jpnView);
        controller.setView(jpnTrangchu, jlbTrangchu);
        //ChuyenManHinhController//
        JLabel lblTenDangNhap1 = new JLabel("Xin chào: "+loggedInUsername);
        lblTenDangNhap1.setIcon(new ImageIcon(MainJFram.class.getResource("/Images/userlogin20x20.png")));
        lblTenDangNhap1.setHorizontalAlignment(SwingConstants.CENTER);
        lblTenDangNhap1.setFont(new Font("Times New Roman", Font.BOLD, 16));
        lblTenDangNhap1.setBounds(10, 441, 170, 20);
        jpnMenu.add(lblTenDangNhap1);
        
        JButton btnNewButton = new JButton("Đăng Xuất!");
        btnNewButton.setForeground(new Color(255, 255, 255));
        btnNewButton.setFocusPainted(false);
        btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 12));
        btnNewButton.setBackground(new Color(255, 0, 0));
        btnNewButton.setBounds(38, 501, 124, 31);
        jpnMenu.add(btnNewButton);
        controller.setEvent(listItem);
        
        controller.setEvent(listItem);
        
        
    
	btnNewButton.addActionListener(new ActionListener() {
	    @Override
	    public void actionPerformed(ActionEvent e) {
	        // Xử lý khi nút "Đăng Xuất" được bấm
	        // Ví dụ: Quay lại giao diện đăng nhập
	        dispose(); // Đóng cửa sổ MainJFram
	        DangNhapJDialog dialog = new DangNhapJDialog(); // Tạo mới cửa sổ đăng nhập
	        dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE); // Thiết lập hành động khi đóng cửa sổ
	        dialog.setVisible(true); // Hiển thị cửa sổ đăng nhập
	    }
	});
	}

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    MainJFram frame = new MainJFram();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}