package Service;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import Model.Khoahoc;

import Dao.KhoahocDAO;
import Dao.KhoahocDAOImpl;

public class KhoahocRMIServiceImpl extends UnicastRemoteObject implements KhoahocRMIService {
    private KhoahocDAO khoaHocDAO = null;

    public KhoahocRMIServiceImpl() throws RemoteException {
        this.khoaHocDAO = new KhoahocDAOImpl();
    }

    @Override
    public List<Khoahoc> getList() throws RemoteException {
        return khoaHocDAO.getList();
    }
    
    @Override
    public int createOrUpdate(Khoahoc khoaHoc) throws RemoteException {
        return khoaHocDAO.createOrUpdate(khoaHoc);
    }
    
    @Override
    public int delete(int maKhoaHoc) throws RemoteException {
        return khoaHocDAO.delete(maKhoaHoc);
    }
}
