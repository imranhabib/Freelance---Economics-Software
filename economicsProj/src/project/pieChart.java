package project;


import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.PieSectionLabelGenerator;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;

import java.text.DecimalFormat;
import java.util.List;


/**
 * Created by Imran on 2014-12-07.
 */
public class pieChart {

    List<Share> shareListFordata;
    DefaultPieDataset data;
    JFreeChart pieChart;


    public pieChart(List<Share> shareList){
        shareListFordata = shareList;
        data = new DefaultPieDataset();

        for(int i = 0; i < shareListFordata.size(); i++){
            double allocation = shareListFordata.get(i).getAllocation();
            String name = Integer.toString(shareListFordata.get(i).getSecurityNumber());
            String build = "Security " + name;
            data.setValue(build, allocation);


        }

        pieChart = ChartFactory.createPieChart("Allocations", data, true, true, false);
        PiePlot plot = (PiePlot) pieChart.getPlot();




        PieSectionLabelGenerator labelGenerator = new StandardPieSectionLabelGenerator(
                "{0}: ({2})");
        plot.setLabelGenerator(labelGenerator);



    }


    public JFreeChart getChart(){
        return pieChart;

    }

}
