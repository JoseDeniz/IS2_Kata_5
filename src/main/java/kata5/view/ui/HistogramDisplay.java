package kata5.view.ui;

import kata5.model.Histogram;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;

import javax.swing.*;
import java.awt.*;

import static org.jfree.chart.ChartFactory.createBarChart;

public class HistogramDisplay<T> extends ApplicationFrame {

    private final String xAxisTag;
    private Histogram<T> histogram;

    public HistogramDisplay(Histogram<T> histogram, String xAxisTag) {
        super("Histogram");
        this.histogram = histogram;
        this.setContentPane(createPanel());
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.xAxisTag = xAxisTag;
    }

    private JPanel createPanel() {
        ChartPanel chartPanel = new ChartPanel(createChart(createDataset()));
        chartPanel.setMinimumSize(new Dimension(700,700));
        return chartPanel;
    }

    private JFreeChart createChart(DefaultCategoryDataset dataset){
        return createBarChart("Histogram", xAxisTag, "Frequency", dataset);
    }

    private DefaultCategoryDataset createDataset(){
        DefaultCategoryDataset categoryDataset = new DefaultCategoryDataset();
        histogram.keySet().forEach(key -> categoryDataset.addValue(histogram.get(key), "", (Comparable) key));
        return categoryDataset;
    }
}