package Service;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;
import Bean.LopHocBean;
import Model.Sinhvien;
import Bean.KhoaHocBean;

public interface ThongkeRMIService  extends Remote {

	    
	    List<LopHocBean> getListByLopHoc() throws RemoteException;
	    
	    List<KhoaHocBean> getListByKhoaHoc() throws RemoteException;
	    
	}
