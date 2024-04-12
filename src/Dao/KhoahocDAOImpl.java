package Dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Model.Khoahoc;

public class KhoahocDAOImpl implements KhoahocDAO {
    @Override
    public List<Khoahoc> getList() {
        Connection cons = DBConnect.getConnection();
        String sql = "SELECT * FROM khoa_hoc";
        List<Khoahoc> list = new ArrayList<>();
        try {
            PreparedStatement ps = (PreparedStatement) cons.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
            	Khoahoc khoaHoc = new Khoahoc();
            	khoaHoc.setMa_khoa_hoc(rs.getInt("ma_khoa_hoc"));
            	khoaHoc.setTen_khoa_hoc(rs.getString("ten_khoa_hoc"));
            	khoaHoc.setNgay_bat_dau(rs.getDate("ngay_bat_dau"));
            	khoaHoc.setNgay_ket_thuc(rs.getDate("ngay_ket_thuc"));
            	khoaHoc.setTinh_trang(rs.getBoolean("tinh_trang"));
                list.add(khoaHoc);
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
    public int createOrUpdate(Khoahoc khoaHoc) {
        try {
            Connection cons = DBConnect.getConnection();
            String sql = "INSERT INTO khoa_hoc(ma_khoa_hoc, ten_khoa_hoc, ngay_bat_dau, ngay_ket_thuc, tinh_trang) VALUES(?, ?, ?, ?, ?) ON DUPLICATE KEY UPDATE ten_khoa_hoc = VALUES(ten_khoa_hoc), ngay_bat_dau = VALUES(ngay_bat_dau), ngay_ket_thuc = VALUES(ngay_ket_thuc), tinh_trang = VALUES(tinh_trang);";
            PreparedStatement ps = cons.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setInt(1, khoaHoc.getMa_khoa_hoc());
            ps.setString(2, khoaHoc.getTen_khoa_hoc());
            ps.setDate(3, new Date(khoaHoc.getNgay_bat_dau().getTime()));
            ps.setDate(4, new Date(khoaHoc.getNgay_ket_thuc().getTime()));
            ps.setBoolean(5, khoaHoc.isTinh_trang());
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
    public int delete(int maKhoaHoc) {
        try {
            Connection cons = DBConnect.getConnection();
            String sql = "DELETE FROM khoa_hoc WHERE ma_khoa_hoc = ?";
            PreparedStatement ps = cons.prepareStatement(sql);
            ps.setInt(1, maKhoaHoc);
            return ps.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return 0;
    }
    
    @Override
    public boolean exists(int maKhoaHoc) {
        try {
            Connection cons = DBConnect.getConnection();
            String sql = "SELECT COUNT(*) FROM khoa_hoc WHERE ma_khoa_hoc = ?";
            PreparedStatement ps = cons.prepareStatement(sql);
            ps.setInt(1, maKhoaHoc);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                int count = rs.getInt(1);
                return count > 0;
            }
            ps.close();
            rs.close();
            cons.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return false;
    }
    
    public static void main(String[] args) {
		KhoahocDAO khoaHocDAO = new KhoahocDAOImpl();
		System.out.println(khoaHocDAO.getList());
	}
}
