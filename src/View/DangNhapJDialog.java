package View;

import javax.swing.*;
import java.awt.*;
import Controller.TaiKhoanController;
import javax.swing.ImageIcon;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DangNhapJDialog extends JDialog {

    private static final long serialVersionUID = 1L;
    private JTextField jtfTenDangNhap;
    private JPasswordField jtfMatKhau;
    private JLabel jlbMag;
    private JButton btnSubmit;

    public DangNhapJDialog() {
        setUndecorated(true);
        setTitle("Đăng Nhập");
        getContentPane().setBackground(new Color(240, 240, 240));
        getContentPane().setLayout(null);

        // Label Đăng nhập hệ thống
        JTextField txtngNhpH = new JTextField();
        txtngNhpH.setHorizontalAlignment(SwingConstants.CENTER);
        txtngNhpH.setFont(new Font("Times New Roman", Font.BOLD, 18));
        txtngNhpH.setEditable(false);
        txtngNhpH.setBounds(0, 0, 747, 34);
        txtngNhpH.setBackground(new Color(240, 240, 240));
        txtngNhpH.setToolTipText("");
        txtngNhpH.setText("Đăng nhập hệ thống");
        getContentPane().add(txtngNhpH);
        txtngNhpH.setColumns(10);

        // Label Tên đăng nhập
        JLabel lblTenDangNhap = new JLabel("Tên Đăng Nhập");
        lblTenDangNhap.setFont(new Font("Times New Roman", Font.BOLD, 16));
        lblTenDangNhap.setBounds(509, 69, 200, 36);
        getContentPane().add(lblTenDangNhap);

        // TextField Tên đăng nhập
        jtfTenDangNhap = new JTextField();
        jtfTenDangNhap.setBounds(509, 116, 252, 28);
        getContentPane().add(jtfTenDangNhap);

        // Label Mật khẩu
        JLabel lblMatKhau = new JLabel("Mật khẩu");
        lblMatKhau.setFont(new Font("Times New Roman", Font.BOLD, 16));
        lblMatKhau.setBounds(509, 155, 200, 37);
        getContentPane().add(lblMatKhau);

        // TextField Mật khẩu
        jtfMatKhau = new JPasswordField();
        jtfMatKhau.setBounds(509, 203, 252, 28);
        getContentPane().add(jtfMatKhau);

        // Button Đăng nhập
        btnSubmit = new JButton("Đăng nhập");
        btnSubmit.setFocusPainted(false);
        btnSubmit.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	}
        });
        btnSubmit.setFont(new Font("Times New Roman", Font.BOLD, 14));
        btnSubmit.setBounds(580, 276, 139, 43);
        btnSubmit.setBackground(new Color(0, 128, 192));
        getContentPane().add(btnSubmit);

        // Label Thông báo
        jlbMag = new JLabel("");
        jlbMag.setHorizontalAlignment(SwingConstants.CENTER);
        jlbMag.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        jlbMag.setBounds(511, 348, 279, 34);
        jlbMag.setForeground(Color.RED);
        getContentPane().add(jlbMag);

        // Button Thoát
        JButton btnThoat = new JButton("X");
        btnThoat.setBackground(new Color(240, 240, 240));
        btnThoat.setForeground(new Color(255, 0, 0));
        btnThoat.setFont(new Font("Times New Roman", Font.BOLD, 12));
        btnThoat.setMnemonic('X');
        btnThoat.setBounds(747, 0, 53, 34);
        getContentPane().add(btnThoat);
        btnThoat.setPreferredSize(new Dimension(40, 40));
        btnThoat.addActionListener(e -> dispose());

        // Panel chứa hình ảnh
        JPanel panel = new JPanel();
        panel.setBackground(new Color(240, 240, 240));
        panel.setBounds(10, 79, 489, 369);
        getContentPane().add(panel);

        // Thêm hình ảnh vào panel
        ImageIcon imageIcon = new ImageIcon(getClass().getResource("/Images/R.png"));
        panel.setLayout(null);
        JLabel lblImage = new JLabel();
        lblImage.setBackground(new Color(240, 240, 240));
        lblImage.setBounds(0, -19, 489, 388);
        lblImage.setIcon(new ImageIcon(DangNhapJDialog.class.getResource("/Images/login.jpg")));
        panel.add(lblImage);

        setSize(800, 500);
        setLocationRelativeTo(null);

        // Khởi tạo và gán sự kiện cho controller
        TaiKhoanController controller = new TaiKhoanController(this, btnSubmit, jtfTenDangNhap, jtfMatKhau, jlbMag);
        controller.setEvent();
    }
    

    public static void main(String[] args) {
        DangNhapJDialog dialog = new DangNhapJDialog();
        dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        dialog.setVisible(true);
    }
}
