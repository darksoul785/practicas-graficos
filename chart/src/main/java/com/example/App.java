package com.example;

import java.awt.Container;

import javax.swing.JPanel;

import org.jfree.chart.*;
import org.jfree.chart.ui.ApplicationFrame;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.ui.RefineryUtilities;

/**
 * Hello world!
 *
 */
public class App extends ApplicationFrame {
    public App(String title) {
        super(title);
        setContentPane(createDemoPanel());
        // TODO Auto-generated constructor stub
    }

    public static PieDataset creaDataset() {
        DefaultPieDataset dataset = new DefaultPieDataset();
        dataset.setValue("BMW", new Double(20));
        dataset.setValue("Volskwagen",new Double(40));
        dataset.setValue("Toyota", new Double(15));
        dataset.setValue("Peugeot", new Double(5));
        dataset.setValue("Ford", new Double(20));
        return dataset;

    }

    private static JFreeChart createChart(PieDataset dataset) {
        JFreeChart chart = ChartFactory.createPieChart(
                "Venta de autos", // chart title
                dataset, // data
                true, // include legend
                true,
                false);

        return chart;
    }

    public static JPanel createDemoPanel() {
        JFreeChart chart = createChart(creaDataset());
        return new ChartPanel(chart);
    }

    public static void main(String[] args) {
        App demo = new App("Venta de autos");
        demo.setSize(560, 367);
        RefineryUtilities.centerFrameOnScreen(demo);
        demo.setVisible(true);
    }
}
