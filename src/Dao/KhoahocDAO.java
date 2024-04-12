package Dao;

import java.util.List;

import Model.Khoahoc;

public interface KhoahocDAO {
	public List<Khoahoc> getList();
	public int createOrUpdate(Khoahoc khoaHoc);
	public int delete(int maKhoaHoc);
	public boolean exists(int maKhoaHoc);
}
