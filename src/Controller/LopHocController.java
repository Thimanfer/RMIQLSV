package Controller;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.rmi.RemoteException;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.toedter.calendar.JDateChooser;

import Dao.KhoahocDAO;
import Dao.KhoahocDAOImpl;
import Dao.SinhvienDAO;
import Dao.SinhvienDAOImpl;
import Model.Lophoc;
import Service.LophocRMIService;
import Service.LophocRMIServiceImpl;
import View.QllopJFram;

public class LopHocController {
	private JButton btnSubmit;
	private JButton btnDelete;
	private JTextField jtfMalophoc;
	private JTextField jtfTenlophoc;
	private JTextField jtfMasinhvien;
	private JTextField jtfMakhoahoc;
	private JDateChooser jdcNgaydangky;
    private JCheckBox jcbKichhoat;
    private JLabel jlbMsg;
    
    private Lophoc lopHoc = null;
    private LophocRMIService lopHocRMIService = null;
	
	public LopHocController(JButton btnSubmit, JButton btnDelete, JTextField jtfMalophoc, JTextField jtfTenlophoc, JTextField jtfMasinhvien,
			JTextField jtfMakhoahoc, JDateChooser jdcNgaydangky,  JCheckBox jcbKichhoat, JLabel jlbMsg) throws RemoteException {
		this.btnSubmit = btnSubmit;
		this.btnDelete = btnDelete;
		this.jtfMalophoc = jtfMalophoc;
		this.jtfTenlophoc = jtfTenlophoc;
		this.jtfMasinhvien = jtfMasinhvien;
		this.jtfMakhoahoc = jtfMakhoahoc;
		this.jdcNgaydangky = jdcNgaydangky;
		this.jcbKichhoat = jcbKichhoat;
		this.jlbMsg = jlbMsg;
		this.lopHocRMIService = new LophocRMIServiceImpl();
	}

	public void setView(Lophoc lopHoc) {
		this.lopHoc = lopHoc;
		jtfMalophoc.setText("#" + lopHoc.getMa_lop_hoc());
		jtfTenlophoc.setText(lopHoc.getTen_lop_hoc());
		jtfMasinhvien.setText("#" + lopHoc.getMa_sinh_vien());
		jtfMakhoahoc.setText("#" + lopHoc.getMa_khoa_hoc());
		jdcNgaydangky.setDate(lopHoc.getNgay_dang_ky());
        jcbKichhoat.setSelected(lopHoc.isTinh_trang());
        // set event
        setEvent();
	}

	public void setEvent() {
		btnSubmit.addMouseListener(new MouseAdapter() {
	        @Override
	        public void mouseClicked(MouseEvent e) {
	            if (jtfTenlophoc.getText().length() == 0 || jdcNgaydangky.getDate() == null || !isPositiveInteger(jtfMasinhvien.getText()) || !isPositiveInteger(jtfMakhoahoc.getText())) {
	                jlbMsg.setText("Vui lòng nhập dữ liệu");
	            } else {
	                // Get the values of maSinhVien and maKhoaHoc
	                String maSinhVienText = jtfMasinhvien.getText().replace("#", "");
	                int maSinhVien = Integer.parseInt(maSinhVienText);

	                String maKhoaHocText = jtfMakhoahoc.getText().replace("#", "");
	                int maKhoaHoc = Integer.parseInt(maKhoaHocText);

	                // Check if maSinhVien exists in the database
	                SinhvienDAO sinhVienDAO = new SinhvienDAOImpl();
	                boolean sinhVienExists = sinhVienDAO.exists(maSinhVien);
	                // Check if maKhoaHoc exists in the database
	                KhoahocDAO khoahocDAO = new KhoahocDAOImpl();
	                boolean khoaHocExists = khoahocDAO.exists(maKhoaHoc);

	                if (!sinhVienExists) {
	                    jlbMsg.setText("Mã sinh viên không tồn tại");
	                } else if (!khoaHocExists) {
	                    jlbMsg.setText("Mã khóa học không tồn tại");
	                } else {
	                    // All conditions met, proceed with setting the values
	                    lopHoc.setTen_lop_hoc(jtfTenlophoc.getText());
	                    lopHoc.setNgay_dang_ky(jdcNgaydangky.getDate());
	                    lopHoc.setTinh_trang(jcbKichhoat.isSelected());
	                    lopHoc.setMa_sinh_vien(maSinhVien);
	                    lopHoc.setMa_khoa_hoc(maKhoaHoc);
	                    
	                    int lastId = 0;
	                    try {
	                        lastId = lopHocRMIService.createOrUpdate(lopHoc);
	                    } catch (RemoteException e1) {
	                        e1.printStackTrace();
	                    }
	                    if (lastId > 0) {
	                        lopHoc.setMa_lop_hoc(lastId);
	                        jtfMalophoc.setText("#" + lastId);
	                        jlbMsg.setText("Cập nhật dữ liệu thành công");
	                    }
	                }
	            }
	        }
			
			private boolean isPositiveInteger(String str) {
			    if (str == null || str.isEmpty()) {
			        return false;
			    }
			    // Loại bỏ ký tự '#' từ chuỗi
			    str = str.replace("#", "");
			    try {
			        int number = Integer.parseInt(str);
			        return number > 0;
			    } catch (NumberFormatException e) {
			        return false;
			    }
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				btnSubmit.setBackground(new Color(0, 200, 83));
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				btnSubmit.setBackground(new Color(100, 221, 23));
			}
			
		});
		
		btnDelete.addMouseListener(new MouseAdapter() {
		    @Override
		    public void mouseClicked(MouseEvent e) {
		        int maLopHoc = lopHoc.getMa_lop_hoc();
		        try {
		            int deletedRows = lopHocRMIService.delete(maLopHoc);
		            jlbMsg.setText("Xóa dữ liệu thành công");
		        } catch (RemoteException ex) {
		            ex.printStackTrace();
		        }
		    }
		     
		     @Override
		     public void mouseEntered(MouseEvent e) {
		         btnDelete.setBackground(new Color(255, 32, 78)); // Màu đỏ mờ (80% độ mờ)
		     }

		     @Override
		     public void mouseExited(MouseEvent e) {
		         btnDelete.setBackground(new Color(231, 41, 41)); // Màu đỏ ban đầu
		     }
		     
		 });
	}

}
