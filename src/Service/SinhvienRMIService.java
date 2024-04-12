package Service;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import Model.Sinhvien;

public interface SinhvienRMIService extends Remote {
	public List<Sinhvien> getList() throws RemoteException;
	public int createOrUpdate(Sinhvien sinhVien) throws RemoteException;
	public int delete(int maSinhVien) throws RemoteException;
}
