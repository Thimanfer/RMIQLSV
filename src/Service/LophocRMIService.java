package Service;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import Model.Lophoc;

public interface LophocRMIService extends Remote {
	public List<Lophoc> getList() throws RemoteException;
	public int createOrUpdate(Lophoc lopHoc) throws RemoteException;
	public int delete(int maLopHoc) throws RemoteException;
}