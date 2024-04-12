package Dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Model.Lophoc;

public class LophocDAOImpl implements LophocDAO {
    @Override
    public List<Lophoc> getList() {
        Connection cons = DBConnect.getConnection();
        String sql = "SELECT * FROM lop_hoc";
        List<Lophoc> list = new ArrayList<>();
        try {
            PreparedStatement ps = (PreparedStatement) cons.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
            	Lophoc lopHoc = new Lophoc();
            	lopHoc.setMa_lop_hoc(rs.getInt("ma_lop_hoc"));
            	lopHoc.setTen_lop_hoc(rs.getString("ten_lop_hoc"));
            	lopHoc.setMa_sinh_vien(rs.getInt("ma_sinh_vien"));
            	lopHoc.setMa_khoa_hoc(rs.getInt("ma_khoa_hoc"));
            	lopHoc.setNgay_dang_ky(rs.getDate("ngay_dang_ky"));
            	lopHoc.setTinh_trang(rs.getBoolean("tinh_trang"));
                list.add(lopHoc);
            }
            ps.close();
            rs.close();
            cons.close();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    @Override
    public int createOrUpdate(Lophoc lopHoc) {
        try {
            Connection cons = DBConnect.getConnection();
            String sql = "INSERT INTO lop_hoc(ma_lop_hoc, ten_lop_hoc, ma_sinh_vien, ma_khoa_hoc, ngay_dang_ky, tinh_trang) VALUES(?, ?, ?, ?, ?, ?) ON DUPLICATE KEY UPDATE ten_lop_hoc = VALUES(ten_lop_hoc), ma_sinh_vien = VALUES(ma_sinh_vien), ma_khoa_hoc = VALUES(ma_khoa_hoc), ngay_dang_ky = VALUES(ngay_dang_ky), tinh_trang = VALUES(tinh_trang);";
            PreparedStatement ps = cons.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setInt(1, lopHoc.getMa_lop_hoc());
            ps.setString(2, lopHoc.getTen_lop_hoc());
            ps.setInt(3, lopHoc.getMa_sinh_vien());
            ps.setInt(4, lopHoc.getMa_khoa_hoc());
            ps.setDate(5, new Date(lopHoc.getNgay_dang_ky().getTime()));
            ps.setBoolean(6, lopHoc.isTinh_trang());
            ps.execute();
            ResultSet rs = ps.getGeneratedKeys();
            int generatedKey = 0;
            if (rs.next()) {
                generatedKey = rs.getInt(1);
            }
            ps.close();
            cons.close();
            return generatedKey;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return 0;
    }
    
    @Override
    public int delete(int maLopHoc) {
        try {
            Connection cons = DBConnect.getConnection();
            String sql = "DELETE FROM lop_hoc WHERE ma_lop_hoc = ?";
            PreparedStatement ps = cons.prepareStatement(sql);
            ps.setInt(1, maLopHoc);
            return ps.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return 0;
    }
    
    public static void main(String[] args) {
		LophocDAO lopHocDAO = new LophocDAOImpl();
		System.out.println(lopHocDAO.getList());
	}
}
