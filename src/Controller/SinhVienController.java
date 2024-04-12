package Controller;

import java.awt.Color;
import java.awt.Component;
import java.awt.Window;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import com.toedter.calendar.JDateChooser;

import Model.Sinhvien;
import Service.SinhvienRMIService;
import Service.SinhvienRMIServiceImpl;
import View.QlsinhvienJFram;

public class SinhVienController {
	private JButton btnSubmit;
	private JButton btnDelete;
	private JTextField jtfMasinhvien;
	private JTextField jtfHoten;
	private JDateChooser jdcNgaysinh;
    private JTextField jtfSodienthoai;
    private JRadioButton jtfNam;
    private JRadioButton jtfNu;
    private JTextArea jtaDiachi;
    private JCheckBox jcbKichhoat;
    private JLabel jlbMsg;
    
    private Sinhvien sinhVien = null;
    private SinhvienRMIService sinhVienRMIService = null;
	
	public SinhVienController(JButton btnSubmit,JButton btnDelete, JTextField jtfMasinhvien, JTextField jtfHoten,
			JDateChooser jdcNgaysinh, JTextField jtfSodienthoai, JRadioButton jtfNam, JRadioButton jtfNu,
			JTextArea jtaDiachi, JCheckBox jcbKichhoat, JLabel jlbMsg) throws RemoteException {
		this.btnSubmit = btnSubmit;
		this.btnDelete = btnDelete;
		this.jtfMasinhvien = jtfMasinhvien;
		this.jtfHoten = jtfHoten;
		this.jdcNgaysinh = jdcNgaysinh;
		this.jtfSodienthoai = jtfSodienthoai;
		this.jtfNam = jtfNam;
		this.jtfNu = jtfNu;
		this.jtaDiachi = jtaDiachi;
		this.jcbKichhoat = jcbKichhoat;
		this.jlbMsg = jlbMsg;
		this.sinhVienRMIService = new SinhvienRMIServiceImpl();
	}

	public void setView(Sinhvien sinhVien) {
		this.sinhVien = sinhVien;
		jtfMasinhvien.setText("#" + sinhVien.getMa_sinh_vien());
		jtfHoten.setText(sinhVien.getHo_ten());
		jdcNgaysinh.setDate(sinhVien.getNgay_sinh());
        if (sinhVien.isGioi_tinh()) {
            jtfNam.setSelected(true);/**/
        } else {
            jtfNu.setSelected(true);/**/
        }
        jtfSodienthoai.setText(sinhVien.getSo_dien_thoai());
        jtaDiachi.setText(sinhVien.getDia_chi());
        jcbKichhoat.setSelected(sinhVien.isTinh_trang());
        // set event
        setEvent();
	}
	
	public void setEvent() {
		btnSubmit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(jtfHoten.getText().length() == 0 || jdcNgaysinh.getDate() == null) {
					jlbMsg.setText("Vui lòng nhập dữ liệu");
				}
				else {
					sinhVien.setHo_ten(jtfHoten.getText());
					sinhVien.setNgay_sinh(jdcNgaysinh.getDate());
					sinhVien.setSo_dien_thoai(jtfSodienthoai.getText());
					sinhVien.setDia_chi(jtaDiachi.getText());
					sinhVien.setGioi_tinh(jtfNam.isSelected());
					sinhVien.setTinh_trang(jcbKichhoat.isSelected());
					int lastId = 0;
					try {
						lastId = sinhVienRMIService.createOrUpdate(sinhVien);
					} catch (RemoteException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					if (lastId > 0) {
						sinhVien.setMa_sinh_vien(lastId);
						jtfMasinhvien.setText("#"+lastId);
						jlbMsg.setText("Cập nhật dữ liệu thành công");
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
		        int maSinhVien = sinhVien.getMa_sinh_vien();
		        try {
		            int deletedRows = sinhVienRMIService.delete(maSinhVien);
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
