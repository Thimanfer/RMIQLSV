package Main;

import View.DangNhapJDialog;

import View.MainJFram;

public class Main {
	public static void Main(String[] args) {
		
DangNhapJDialog dialog = new DangNhapJDialog();
dialog.setTitle("Đăng nhập hệ thống");
dialog.setResizable(false);
dialog.setLocationRelativeTo(null);
dialog.setVisible(true);
	}

}