package Model;

import java.io.Serializable;
import java.util.Date;

public class Lophoc implements Serializable {
    private int ma_lop_hoc;
    private String ten_lop_hoc;
    private int ma_khoa_hoc;
    private int ma_sinh_vien;
    private Date ngay_dang_ky;
    private boolean tinh_trang;
    
	public int getMa_lop_hoc() {
		return ma_lop_hoc;
	}
	public void setMa_lop_hoc(int ma_lop_hoc) {
		this.ma_lop_hoc = ma_lop_hoc;
	}
	public String getTen_lop_hoc() {
		return ten_lop_hoc;
	}
	public void setTen_lop_hoc(String ten_lop_hoc) {
		this.ten_lop_hoc = ten_lop_hoc;
	}
	public int getMa_khoa_hoc() {
		return ma_khoa_hoc;
	}
	public void setMa_khoa_hoc(int ma_khoa_hoc) {
		this.ma_khoa_hoc = ma_khoa_hoc;
	}
	public int getMa_sinh_vien() {
		return ma_sinh_vien;
	}
	public void setMa_sinh_vien(int ma_sinh_vien) {
		this.ma_sinh_vien = ma_sinh_vien;
	}
	public Date getNgay_dang_ky() {
		return ngay_dang_ky;
	}
	public void setNgay_dang_ky(Date ngay_dang_ky) {
		this.ngay_dang_ky = ngay_dang_ky;
	}
	public boolean isTinh_trang() {
		return tinh_trang;
	}
	public void setTinh_trang(boolean tinh_trang) {
		this.tinh_trang = tinh_trang;
	}
        
}
