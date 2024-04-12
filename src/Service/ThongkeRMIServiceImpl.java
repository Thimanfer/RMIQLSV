package Service;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;
import Bean.KhoaHocBean;
import Bean.LopHocBean;
import Dao.ThongkeDAO;
import Dao.ThongkeDAOImpl;
import Service.ThongkeRMIService;
public class ThongkeRMIServiceImpl  implements ThongkeRMIService {

    private ThongkeDAO thongKeDAO = null;

    public ThongkeRMIServiceImpl() throws RemoteException {
        super();
        this.thongKeDAO = new ThongkeDAOImpl();
    }

    @Override
    public List<LopHocBean> getListByLopHoc() throws RemoteException {
        return thongKeDAO.getListByLopHoc();
    }

    @Override
    public List<KhoaHocBean> getListByKhoaHoc() throws RemoteException {
        return thongKeDAO.getListByKhoaHoc();
    }
}