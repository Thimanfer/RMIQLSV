package Controller;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileOutputStream;
import java.rmi.RemoteException;
import java.util.Date;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.text.TableView.TableRow;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import Model.Khoahoc;
import Model.Sinhvien;
import Service.KhoahocRMIService;
import Service.KhoahocRMIServiceImpl;
import Utility.ClassTableKhoahoc;
import View.QlkhoaJFram;

public class QuanLyKhoaHocController {

    private JPanel jpnView;
    private JButton btnAdd;
    private JButton btnPrint;
    private JTextField jtfSearch;

    private KhoahocRMIService khoaHocRMIService = null;

    private String[] listColumn = {"Mã khóa học", "STT", "Tên khóa học", "Ngày bắt đầu",
        "Ngày kết thúc","Trạng thái"};
    
    private TableRowSorter<TableModel> rowSorter = null;

    public QuanLyKhoaHocController(JPanel jpnView, JButton btnAdd, JButton btnPrint, JTextField jtfSearch) throws RemoteException {
        this.jpnView = jpnView;
        this.btnAdd = btnAdd;
        this.btnPrint = btnPrint;
        this.jtfSearch = jtfSearch;

        this.khoaHocRMIService = new KhoahocRMIServiceImpl();
    }

    public void setDataToTable() throws RemoteException {
        List<Khoahoc> listItem = khoaHocRMIService.getList();
        DefaultTableModel model = new ClassTableKhoahoc().setTableKhoahoc(listItem, listColumn);
        JTable table = new JTable(model);

        rowSorter = new TableRowSorter<>(table.getModel());
        table.setRowSorter(rowSorter);

        jtfSearch.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                String text = jtfSearch.getText();
                if (text.trim().length() == 0) {
                    rowSorter.setRowFilter(null);
                } else {
                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
                }
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                String text = jtfSearch.getText();
                if (text.trim().length() == 0) {
                    rowSorter.setRowFilter(null);
                } else {
                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
                }
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
            }
        });
        
        table.getColumnModel().getColumn(0).setMaxWidth(0);
        table.getColumnModel().getColumn(0).setMinWidth(0);
        table.getColumnModel().getColumn(0).setPreferredWidth(0);
        
        table.getColumnModel().getColumn(1).setMaxWidth(80);
        table.getColumnModel().getColumn(1).setMinWidth(80);
        table.getColumnModel().getColumn(1).setPreferredWidth(80);
        
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                   if (e.getClickCount() == 2 && table.getSelectedRow() != -1) {
                          DefaultTableModel model = (DefaultTableModel) table.getModel();
                          int selectedRowIndex = table.getSelectedRow();
                          
                          selectedRowIndex = table.convertRowIndexToModel(selectedRowIndex);

                          Khoahoc khoaHoc = new Khoahoc();
                          khoaHoc.setMa_khoa_hoc((int) model.getValueAt(selectedRowIndex, 0));
                          khoaHoc.setTen_khoa_hoc(model.getValueAt(selectedRowIndex, 2).toString());
                          khoaHoc.setNgay_bat_dau((Date) model.getValueAt(selectedRowIndex, 3));
                          khoaHoc.setNgay_ket_thuc((Date) model.getValueAt(selectedRowIndex, 4));
                          khoaHoc.setTinh_trang((boolean) model.getValueAt(selectedRowIndex, 5));
                          
                          QlkhoaJFram frame = new QlkhoaJFram(khoaHoc);
                          frame.setLocationRelativeTo(null);
                          frame.setResizable(false);
                          frame.setTitle("Thông tin khóa học");
                          frame.setVisible(true);
                   }
            }
      });

        // design
        table.getTableHeader().setFont(new Font("Arial", Font.BOLD, 14));
        table.getTableHeader().setPreferredSize(new Dimension(100, 50));
        table.setRowHeight(50);
        table.validate();
        table.repaint();
        
        JScrollPane scroll = new JScrollPane();
        scroll.getViewport().add(table);
        scroll.setPreferredSize(new Dimension(1350, 400));
        
        jpnView.removeAll();
        jpnView.setLayout(new CardLayout());
        jpnView.add(scroll);
        jpnView.validate();
        jpnView.repaint();
    }
    
    public void setEvent() {
    	btnAdd.addMouseListener(new MouseAdapter() {
    		@Override
			public void mouseClicked(MouseEvent e) {
    			QlkhoaJFram fram = new QlkhoaJFram(new Khoahoc());
    			fram.setTitle("Thông tin khóa học");
    			fram.setLocationRelativeTo(null);
    			fram.setResizable(false);
    			fram.setVisible(true);
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				btnAdd.setBackground(new Color(0, 200, 83));
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				btnAdd.setBackground(new Color(100, 221, 23));
			}
		});
    	
    	btnPrint.addMouseListener(new MouseAdapter() {
    		@Override
			public void mouseClicked(MouseEvent e) {
                XSSFWorkbook workbook = new XSSFWorkbook();
                XSSFSheet sheet = workbook.createSheet("Khóa học");

                XSSFRow row = null;
                Cell cell = null;
                
                row = sheet.createRow((short) 2);
                row.setHeight((short) 500);
                cell = row.createCell(1, CellType.STRING);
                cell.setCellValue("DANH SÁCH KHÓA HỌC");

                row = sheet.createRow((short) 3);
                row.setHeight((short) 500);
                
                cell = row.createCell(0, CellType.STRING);
                cell.setCellValue("STT");
                
                cell = row.createCell(1, CellType.STRING);
                cell.setCellValue("Tên Khóa học");

                cell = row.createCell(2, CellType.STRING);
                cell.setCellValue("Ngày bắt đầu");
                
                cell = row.createCell(3, CellType.STRING);
                cell.setCellValue("Ngày kết thúc");

                List<Khoahoc> listItem = null;
				try {
					listItem = khoaHocRMIService.getList();
				} catch (RemoteException ex) {
					// TODO Auto-generated catch block
					ex.printStackTrace();
				}
                
                if(listItem != null) {
                	FileOutputStream fis = null;
                	try {
                	int s = listItem.size();
                	for(int i = 0; i<s; i++) {
                		Khoahoc khoaHoc = listItem.get(i);
                		
                		row = sheet.createRow(4+i);
                		
                		cell = row.createCell(0, CellType.NUMERIC);
                		cell.setCellValue(i+1);
                		
                		cell = row.createCell(1, CellType.STRING);
                		cell.setCellValue(khoaHoc.getTen_khoa_hoc());
                		
                		cell = row.createCell(2, CellType.STRING);
                		cell.setCellValue(khoaHoc.getNgay_bat_dau().toString());
                		
                		cell = row.createCell(3, CellType.STRING);
                		cell.setCellValue(khoaHoc.getNgay_ket_thuc().toString());
                		
                	}
                //save file
                File f = new File("C:\\Users\\Admin\\Documents\\HocTap\\laptrinhphantan\\filexuat\\khoa_hoc.xlsx"); 
                fis = new FileOutputStream(f);
                workbook.write(fis);
                fis.close();
                
                JOptionPane.showMessageDialog(null, "Xuất file thành công!");
               }catch (Exception ex) {
            	   ex.printStackTrace();// TODO: handle exception
               }
			 }
		   }
			
			@Override
			public void mouseEntered(MouseEvent e) {
				btnPrint.setBackground(new Color(0, 200, 83));
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				btnPrint.setBackground(new Color(100, 221, 23));
			}
		});
    }

}