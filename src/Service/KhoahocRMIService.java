package Service;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import Model.Khoahoc;

public interface KhoahocRMIService extends Remote {
	public List<Khoahoc> getList() throws RemoteException;
	public int createOrUpdate(Khoahoc khoaHoc) throws RemoteException;
	public int delete(int maKhoaHoc) throws RemoteException;
}