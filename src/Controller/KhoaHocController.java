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

import Model.Khoahoc;
import Service.KhoahocRMIService;
import Service.KhoahocRMIServiceImpl;
import View.QlkhoaJFram;

public class KhoaHocController {
	private JButton btnSubmit;
	private JButton btnDelete;
	private JTextField jtfMakhoahoc;
	private JTextField jtfTenkhoahoc;
	private JDateChooser jdcNgaybatdau;
	private JDateChooser jdcNgayketthuc;
    private JCheckBox jcbKichhoat;
    private JLabel jlbMsg;
    
    private Khoahoc khoaHoc = null;
    private KhoahocRMIService khoaHocRMIService = null;
	
	public KhoaHocController(JButton btnSubmit, JButton btnDelete, JTextField jtfMakhoahoc, JTextField jtfTenkhoahoc,
			JDateChooser jdcNgaybatdau, JDateChooser jdcNgayketthuc, JCheckBox jcbKichhoat, JLabel jlbMsg) throws RemoteException {
		this.btnSubmit = btnSubmit;
		this.btnDelete = btnDelete;
		this.jtfMakhoahoc = jtfMakhoahoc;
		this.jtfTenkhoahoc = jtfTenkhoahoc;
		this.jdcNgaybatdau = jdcNgaybatdau;
		this.jdcNgayketthuc = jdcNgayketthuc;
		this.jcbKichhoat = jcbKichhoat;
		this.jlbMsg = jlbMsg;
		this.khoaHocRMIService = new KhoahocRMIServiceImpl();
	}

	public void setView(Khoahoc khoaHoc) {
		this.khoaHoc = khoaHoc;
		jtfMakhoahoc.setText("#" + khoaHoc.getMa_khoa_hoc());
		jtfTenkhoahoc.setText(khoaHoc.getTen_khoa_hoc());
		jdcNgaybatdau.setDate(khoaHoc.getNgay_bat_dau());
		jdcNgayketthuc.setDate(khoaHoc.getNgay_ket_thuc());
        jcbKichhoat.setSelected(khoaHoc.isTinh_trang());
        // set event
        setEvent();
	}
	
	public void setEvent() {
		btnSubmit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(jtfTenkhoahoc.getText().length() == 0 || jdcNgaybatdau.getDate() == null || jdcNgayketthuc.getDate() == null) {
					jlbMsg.setText("Vui lòng nhập dữ liệu");
				}
				else {
					khoaHoc.setTen_khoa_hoc(jtfTenkhoahoc.getText());
					Date startDate = jdcNgaybatdau.getDate();
					Date endDate = jdcNgayketthuc.getDate();
					if (startDate == null || endDate == null || endDate.before(startDate)) {
					    jlbMsg.setText("Nhập ngày kết thúc hợp lệ");
					} else {
					    khoaHoc.setNgay_bat_dau(startDate);
					    khoaHoc.setNgay_ket_thuc(endDate);
					    khoaHoc.setTinh_trang(jcbKichhoat.isSelected());
					    int lastId = 0;
					    try {
					        lastId = khoaHocRMIService.createOrUpdate(khoaHoc);
					    } catch (RemoteException e1) {
					        e1.printStackTrace();
					    }
					    if (lastId > 0) {
					        khoaHoc.setMa_khoa_hoc(lastId);
					        jtfMakhoahoc.setText("#" + lastId);
					        jlbMsg.setText("Cập nhật dữ liệu thành công");
					    }
					}

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
		        int maKhoaHoc = khoaHoc.getMa_khoa_hoc();
		        try {
		            int deletedRows = khoaHocRMIService.delete(maKhoaHoc);
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
