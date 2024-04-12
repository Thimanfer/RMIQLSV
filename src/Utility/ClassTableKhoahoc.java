package Utility;

import java.util.List;

import javax.swing.table.DefaultTableModel;

import Model.Khoahoc;

public class ClassTableKhoahoc {
    public DefaultTableModel setTableKhoahoc(List<Khoahoc> listItem, String[] listColumn) {
        DefaultTableModel dtm = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
            
            @Override
            public Class<?> getColumnClass(int columnIndex){
            	return columnIndex == 5 ? Boolean.class : String.class;
            }

        };
        dtm.setColumnIdentifiers(listColumn);
        int columns = listColumn.length;
        Object[] obj = null;
        int rows = listItem.size();
        if(rows > 0) {
	        for (int i = 0; i < rows; i++) {
	            Khoahoc khoaHoc = listItem.get(i);
	            obj = new Object[columns];
	            obj[0] = khoaHoc.getMa_khoa_hoc();
	            obj[1] = (i + 1);
	            obj[2] = khoaHoc.getTen_khoa_hoc();
	            obj[3] = khoaHoc.getNgay_bat_dau();
	            obj[4] = khoaHoc.getNgay_ket_thuc();
	            obj[5] = khoaHoc.isTinh_trang();
	            dtm.addRow(obj);
	        }
        }
        return dtm;
    }
}
