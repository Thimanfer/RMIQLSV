package Dao;

import java.util.List;

import Model.Lophoc;

public interface LophocDAO {
	public List<Lophoc> getList();
	public int createOrUpdate(Lophoc lopHoc);
	public int delete(int maLopHoc);
}
