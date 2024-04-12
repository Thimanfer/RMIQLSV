package Controller;

import java.awt.CardLayout;
import java.awt.Dimension;
import java.rmi.RemoteException;
import java.util.List;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.gantt.Task;
import org.jfree.data.gantt.TaskSeries;
import org.jfree.data.gantt.TaskSeriesCollection;
import org.jfree.data.general.PieDataset;
import org.jfree.data.time.SimpleTimePeriod;

import Bean.LopHocBean;
import Bean.KhoaHocBean;
import Service.ThongkeRMIService;
import Service.ThongkeRMIServiceImpl;

public class QuanLyThongKeController {

    private ThongkeRMIService thongkeRMIService = null;

    public QuanLyThongKeController() throws RemoteException {
        thongkeRMIService = new ThongkeRMIServiceImpl();
    }

    public void setDataToChart1(JPanel jpnItem) {
        try {
            List<LopHocBean> listItem = thongkeRMIService.getListByLopHoc();

            DefaultCategoryDataset dataset = new DefaultCategoryDataset();
            if (listItem != null) {
                for (LopHocBean item : listItem) {
                    dataset.addValue(item.getSo_luong_sinh_vien(), "Sinh viên", item.getNgay_dang_ky());
                }
            }

            JFreeChart barChart = ChartFactory.createBarChart(
                    "Biểu đồ thống kê số lượng sinh viên đăng ký".toUpperCase(),
                    "Thời gian", "Số lượng",
                    dataset, PlotOrientation.VERTICAL, false, true, false);

            ChartPanel chartPanel = new ChartPanel(barChart);
            chartPanel.setPreferredSize(new Dimension(jpnItem.getWidth(), 321));

            jpnItem.removeAll();
            jpnItem.setLayout(new CardLayout());
            jpnItem.add(chartPanel);
            jpnItem.validate();
            jpnItem.repaint();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
    public void setDataToChart2(JPanel jpnItem) throws RemoteException {
        List<KhoaHocBean> listItem = thongkeRMIService.getListByKhoaHoc();
      
        TaskSeriesCollection ds = new TaskSeriesCollection();
        JFreeChart ganttChart = ChartFactory.createGanttChart(
                "BIỂU ĐỒ THEO DÕI TÌNH TRẠNG KHÓA HỌC",
                "Khóa học", "Thời gian", ds, true, false, false
        );

        TaskSeries taskSeries;
        Task task;

        if (listItem != null) {
            for (KhoaHocBean item : listItem) {
                taskSeries = new TaskSeries(item.getTen_khoa_hoc());
                task = new Task(item.getTen_khoa_hoc(), new SimpleTimePeriod(item.getNgay_bat_dau(), item.getNgay_ket_thuc()));
                taskSeries.add(task);
                ds.add(taskSeries);
            }
        }

        ChartPanel chartPanel = new ChartPanel(ganttChart);
        chartPanel.setPreferredSize(new Dimension(jpnItem.getWidth(), 321));

        jpnItem.removeAll();
        jpnItem.setLayout(new CardLayout());
        jpnItem.add(chartPanel);
        jpnItem.validate();
        jpnItem.repaint();
    }

}