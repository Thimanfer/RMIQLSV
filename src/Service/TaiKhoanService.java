package Service;

import Model.TaiKhoan;

public interface TaiKhoanService {
    
    public TaiKhoan login(String tenDangNhap, String matKhau);

    // Thêm phương thức DangNhapDialog vào interface
    public TaiKhoan DangNhapDialog(String tenDangNhap, String matKhau);
    
}