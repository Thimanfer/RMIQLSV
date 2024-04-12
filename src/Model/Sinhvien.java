package Model;

import java.io.Serializable;
import java.util.Date;

public class Sinhvien implements Serializable {
    private int ma_sinh_vien;
    private String ho_ten;
    private String so_dien_thoai;
    private String dia_chi;
    private Date ngay_sinh;
    private boolean gioi_tinh;
    private boolean tinh_trang;
    
	public int getMa_sinh_vien() {
		return ma_sinh_vien;
	}
	public void setMa_sinh_vien(int ma_sinh_vien) {
		this.ma_sinh_vien = ma_sinh_vien;
	}
	public String getHo_ten() {
		return ho_ten;
	}
	public void setHo_ten(String ho_ten) {
		this.ho_ten = ho_ten;
	}
	public String getSo_dien_thoai() {
		return so_dien_thoai;
	}
	public void setSo_dien_thoai(String so_dien_thoai) {
		this.so_dien_thoai = so_dien_thoai;
	}
	public String getDia_chi() {
		return dia_chi;
	}
	public void setDia_chi(String dia_chi) {
		this.dia_chi = dia_chi;
	}
	public Date getNgay_sinh() {
		return ngay_sinh;
	}
	public void setNgay_sinh(Date ngay_sinh) {
		this.ngay_sinh = ngay_sinh;
	}
	public boolean isGioi_tinh() {
		return gioi_tinh;
	}
	public void setGioi_tinh(boolean gioi_tinh) {
		this.gioi_tinh = gioi_tinh;
	}
	public boolean isTinh_trang() {
		return tinh_trang;
	}
	public void setTinh_trang(boolean tinh_trang) {
		this.tinh_trang = tinh_trang;
	}
	
	@Override
	public String toString() {
		return "Sinhvien [ma_sinh_vien=" + ma_sinh_vien + ", ho_ten=" + ho_ten + "]";
	}
}
