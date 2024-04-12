package Service;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import Model.Lophoc;

import Dao.LophocDAO;
import Dao.LophocDAOImpl;

public class LophocRMIServiceImpl extends UnicastRemoteObject implements LophocRMIService {
    private LophocDAO lopHocDAO = null;

    public LophocRMIServiceImpl() throws RemoteException {
        this.lopHocDAO = new LophocDAOImpl();
    }

    @Override
    public List<Lophoc> getList() throws RemoteException {
        return lopHocDAO.getList();
    }
     
    @Override
    public int createOrUpdate(Lophoc lopHoc) throws RemoteException {
        return lopHocDAO.createOrUpdate(lopHoc);
    }
    
    @Override
    public int delete(int maLopHoc) throws RemoteException {
        return lopHocDAO.delete(maLopHoc);
    }
}