package Bean;

import javax.swing.JLabel;
import javax.swing.JPanel;
import java.io.Serializable;
public class LopHocBean {

    private String ngay_dang_ky;
    private int so_luong_sinh_vien;

    public String getNgay_dang_ky() {
        return ngay_dang_ky;
    }

    public void setNgay_dang_ky(String ngay_dang_ky) {
        this.ngay_dang_ky = ngay_dang_ky;
    }

    public int getSo_luong_sinh_vien() {
        return so_luong_sinh_vien;
    }

    public void setSo_luong_sinh_vien(int so_luong_sinh_vien) {
        this.so_luong_sinh_vien = so_luong_sinh_vien;
    }

}