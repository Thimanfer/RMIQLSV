package Dao;

import Model.TaiKhoan;

public interface TaiKhoanDAO {
    
    public TaiKhoan login(String tenDangNhap, String matKhau);
    
}