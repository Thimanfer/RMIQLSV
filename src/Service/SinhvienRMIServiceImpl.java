package Service;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import Model.Sinhvien;

import Dao.SinhvienDAO;
import Dao.SinhvienDAOImpl;

public class SinhvienRMIServiceImpl extends UnicastRemoteObject implements SinhvienRMIService {
    private SinhvienDAO sinhVienDAO = null;

    public SinhvienRMIServiceImpl() throws RemoteException {
        this.sinhVienDAO = new SinhvienDAOImpl();
    }

    @Override
    public List<Sinhvien> getList() throws RemoteException {
        return sinhVienDAO.getList();
    }
    
    @Override
    public int createOrUpdate(Sinhvien sinhVien) throws RemoteException {
        return sinhVienDAO.createOrUpdate(sinhVien);
    }
    
    @Override
    public int delete(int maSinhVien) throws RemoteException {
        return sinhVienDAO.delete(maSinhVien);
    }
}
