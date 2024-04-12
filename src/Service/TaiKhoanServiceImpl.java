package Service;

import Model.TaiKhoan;
import Dao.TaiKhoanDAO;
import Dao.TaiKhoanDAOImpl;

public class TaiKhoanServiceImpl implements TaiKhoanService {

    private TaiKhoanDAO taiKhoanDAO = null;

    public TaiKhoanServiceImpl() {
        taiKhoanDAO = new TaiKhoanDAOImpl();
    }

    @Override
    public TaiKhoan login(String tenDangNhap, String matKhau) {
        return taiKhoanDAO.login(tenDangNhap, matKhau);
    }

    // Triển khai phương thức DangNhapDialog từ interface
    @Override
    public TaiKhoan DangNhapDialog(String tenDangNhap, String matKhau) {
        // Triển khai logic xử lý cho phương thức DangNhapDialog ở đây
        return null;
    }
}