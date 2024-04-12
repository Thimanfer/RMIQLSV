package Controller;

import javax.swing.*;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import Model.TaiKhoan;
import Service.TaiKhoanService;
import Service.TaiKhoanServiceImpl;
import View.MainJFram;

public class TaiKhoanController {

    private JDialog dialog;
    private JButton btnSubmit;
    private JTextField jtfTenDangNhap;
    private JPasswordField jtfMatKhau;
    private JLabel jlbMag;

    private TaiKhoanService taiKhoanService = null;

    public TaiKhoanController(JDialog dialog, JButton btnSubmit, JTextField jtfTenDangNhap, JPasswordField jtfMatKhau, JLabel jlbMag) {
        this.dialog = dialog;
        this.btnSubmit = btnSubmit;
        this.jtfTenDangNhap = jtfTenDangNhap;
        this.jtfMatKhau = jtfMatKhau;
        this.jlbMag = jlbMag;

        taiKhoanService = new TaiKhoanServiceImpl();
    }

    public void setEvent() {
        btnSubmit.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                dangNhap();
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                btnSubmit.setBackground(new Color(135,206,235));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                btnSubmit.setBackground(new Color(0, 128, 192));
            }
        });
    }

    public void dangNhap() {
        String tenDangNhap = jtfTenDangNhap.getText();
        String matKhau = String.valueOf(jtfMatKhau.getPassword());

        if (tenDangNhap.isEmpty() || matKhau.isEmpty()) {
            jlbMag.setText("Vui lòng nhập đầy đủ thông tin!");
        } else {
            TaiKhoan taiKhoan = taiKhoanService.login(tenDangNhap, matKhau);
            if (taiKhoan == null) {
                jlbMag.setText("Tên đăng nhập hoặc mật khẩu không chính xác!");
            } else {
                dialog.dispose(); // Đóng cửa sổ đăng nhập
                MainJFram.setLoggedInUsername(tenDangNhap); // Gửi tên đăng nhập đến MainJFram
                MainJFram mainJFram = new MainJFram();
                mainJFram.setVisible(true); // Hiển thị MainJFram
            }
        }
    }
}

//package Controller;
//
//import javax.swing.*;
//import java.awt.Color;
//import java.awt.event.MouseAdapter;
//import java.awt.event.MouseEvent;
//
//import Model.TaiKhoan;
//import Service.TaiKhoanService;
//import Service.TaiKhoanServiceImpl;
//import View.MainJFram;
//
//public class TaiKhoanController {
//
//    private JDialog dialog;
//    private JButton btnSubmit;
//    private JTextField jtfTenDangNhap;
//    private JPasswordField jtfMatKhau;
//    private JLabel jlbMag;
//
//    private TaiKhoanService taiKhoanService = null;
//
//    public TaiKhoanController(JDialog dialog, JButton btnSubmit, JTextField jtfTenDangNhap, JPasswordField jtfMatKhau, JLabel jlbMag) {
//        this.dialog = dialog;
//        this.btnSubmit = btnSubmit;
//        this.jtfTenDangNhap = jtfTenDangNhap;
//        this.jtfMatKhau = jtfMatKhau;
//        this.jlbMag = jlbMag;
//
//        taiKhoanService = new TaiKhoanServiceImpl();
//    }
//
//    public void setEvent() {
//        btnSubmit.addMouseListener(new MouseAdapter() {
//            @Override
//            public void mouseClicked(MouseEvent e) {
//                dangNhap();
//            }
//
//            @Override
//            public void mouseEntered(MouseEvent e) {
//                btnSubmit.setBackground(new Color(135,206,235));
//            }
//
//            @Override
//            public void mouseExited(MouseEvent e) {
//                btnSubmit.setBackground(new Color(0, 128, 192));
//            }
//        });
//    }
//
//    public void dangNhap() {
//        String tenDangNhap = jtfTenDangNhap.getText();
//        String matKhau = String.valueOf(jtfMatKhau.getPassword());
//
//        if (tenDangNhap.isEmpty() || matKhau.isEmpty()) {
//            jlbMag.setText("Vui lòng nhập đầy đủ thông tin!");
//        } else {
//            TaiKhoan taiKhoan = taiKhoanService.login(tenDangNhap, matKhau);
//            if (taiKhoan == null) {
//                jlbMag.setText("Tên đăng nhập hoặc mật khẩu không chính xác!");
//            } else {
//                dialog.dispose(); // Đóng cửa sổ đăng nhập
//                MainJFram mainJFram = new MainJFram();
//                mainJFram.setVisible(true); // Hiển thị MainJFram
//            }
//        }
//    }
//}