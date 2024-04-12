package Dao;

import Bean.KhoaHocBean;
import Bean.LopHocBean;
import Bean.DanhMucBean;
import java.util.List;

public interface ThongkeDAO {
    
    List<LopHocBean> getListByLopHoc();
    
    List<KhoaHocBean> getListByKhoaHoc();
    
 
}