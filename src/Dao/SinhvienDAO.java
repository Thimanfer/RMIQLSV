package Dao;

import java.util.List;

import Model.Sinhvien;

public interface SinhvienDAO {
	public List<Sinhvien> getList();
	public int createOrUpdate(Sinhvien  sinhVien);
	public int delete(int maSinhVien);
	public boolean exists(int maSinhVien);
}
