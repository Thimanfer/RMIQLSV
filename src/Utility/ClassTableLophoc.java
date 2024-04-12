package Utility;

import java.util.List;

import javax.swing.table.DefaultTableModel;

import Model.Lophoc;

public class ClassTableLophoc {
    public DefaultTableModel setTableLophoc(List<Lophoc> listItem, String[] listColumn) {
        DefaultTableModel dtm = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
            
            @Override
            public Class<?> getColumnClass(int columnIndex){
            	return columnIndex == 6 ? Boolean.class : String.class;
            }

        };
        dtm.setColumnIdentifiers(listColumn);
        int columns = listColumn.length;
        Object[] obj = null;
        int rows = listItem.size();
        if(rows > 0) {
	        for (int i = 0; i < rows; i++) {
	            Lophoc lopHoc = listItem.get(i);
	            obj = new Object[columns];
	            obj[0] = lopHoc.getMa_lop_hoc();
	            obj[1] = (i + 1);
	            obj[2] = lopHoc.getTen_lop_hoc();
	            obj[3] = lopHoc.getMa_sinh_vien();
	            obj[4] = lopHoc.getMa_khoa_hoc();
	            obj[5] = lopHoc.getNgay_dang_ky();
	            obj[6] = lopHoc.isTinh_trang();
	            dtm.addRow(obj);
	        }
        }
        return dtm;
    }
}
