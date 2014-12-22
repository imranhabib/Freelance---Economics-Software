package project;

import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

/**
 * Created by Imran on 2014-12-20.
 */
public class phase3Switch extends JFrame {


    static JButton buttonFirst;
    static JButton buttonSecond;
    static JButton buttonThird;
    static JButton button4;
    static JButton button5;
    static JButton button6;
    static JButton button7;
    static JButton button8;
    static JButton button9;
    static JButton button10;
    static JButton button11;
    static JButton button12;
    static JButton button13;
    static JButton button14;
    static JButton button15;



    static JPanel buttonPanel;
    static JPanel buttonPanel2;
    static JPanel mainButtonsPanel;
    static JPanel topTitlePanel;



    static JLabel empty1;
    static JLabel empty2;

    static JLabel label1;
    static JLabel label2;
    static JLabel label3;




    static ActionListener actionListener;



    static Border raisedBorder;
    static Border loweredBorder;



    String directory = System.getProperty("user.home") + "/Desktop/output";


    static double R;
    static int M;



    String [] stage1Prices;

    public phase3Switch (final List<List<Share>> stage2ShareListWithSwitch, final List<List<Share>> stage2ShareListWithoutSwitch,final int m, final double r, final double[] incomeShares) {


        setLayout(new BorderLayout());
        setTitle("Preview");
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setBounds(0, 0, screenSize.width, screenSize.height - 45);
        setBackground(Color.orange);


        R = r;
        M = m;



        raisedBorder = new SoftBevelBorder(SoftBevelBorder.RAISED);
        loweredBorder = new SoftBevelBorder(SoftBevelBorder.LOWERED);

        buttonFirst = new JButton("Select to compare allocations: Price Set 1");
        buttonSecond  = new JButton("Select to compare allocations: Price Set 2");
        buttonThird = new JButton("Select to compare allocations: Price Set 3");
        button4 = new JButton("Select to compare allocations: Price Set 4");
        button5 = new JButton("Select to compare allocations: Price Set 5");
        button6 = new JButton("Select to compare allocations: Price Set 6");
        button7 = new JButton("Select to compare allocations: Price Set 7");
        button8 = new JButton("Select to compare allocations: Price Set 8");
        button9 = new JButton("Select to compare allocations: Price Set 9");
        button10 = new JButton("Select to compare allocations: Price Set 10");



        button14 = new JButton("Back to previous screen");




        buttonFirst.setFont(new Font("Calibri",  Font.ROMAN_BASELINE, 15));
        buttonSecond.setFont(new Font("Calibri",  Font.ROMAN_BASELINE, 15));
        buttonThird.setFont(new Font("Calibri",Font.ROMAN_BASELINE, 15));
        button4.setFont(new Font("Calibri", Font.ROMAN_BASELINE,15));
        button5.setFont(new Font("Calibri", Font.ROMAN_BASELINE, 15));
        button6.setFont(new Font("Calibri", Font.ROMAN_BASELINE, 15));
        button7.setFont(new Font("Calibri", Font.ROMAN_BASELINE, 15));
        button8.setFont(new Font("Calibri", Font.ROMAN_BASELINE, 15));
        button9.setFont(new Font("Calibri",Font.ROMAN_BASELINE,15));
        button10.setFont(new Font("Calibri", Font.ROMAN_BASELINE, 15));



        button14.setFont(new Font("Calibri", Font.ROMAN_BASELINE, 15));






        buttonFirst.setBorder(new TitledBorder("Current Allocation vs. Choice Rule applied to Stage 1 Pricing"));
        buttonSecond.setBorder(new TitledBorder("Current Allocation vs. Choice Rule applied to Stage 1 Pricing"));
        buttonThird.setBorder(new TitledBorder("Current Allocation vs. Choice Rule applied to Stage 1 Pricing"));
        button4.setBorder(new TitledBorder("Current Allocation vs. Choice Rule applied to Stage 1 Pricing"));
        button5.setBorder(new TitledBorder("Current Allocation vs. Choice Rule applied to Stage 1 Pricing"));
        button6.setBorder(new TitledBorder("Current Allocation vs. Choice Rule applied to Stage 1 Pricing"));
        button7.setBorder(new TitledBorder("Current Allocation vs. Choice Rule applied to Stage 1 Pricing"));
        button8.setBorder(new TitledBorder("Current Allocation vs. Choice Rule applied to Stage 1 Pricing"));
        button9.setBorder(new TitledBorder("Current Allocation vs. Choice Rule applied to Stage 1 Pricing"));
        button10.setBorder(new TitledBorder("Current Allocation vs. Choice Rule applied to Stage 1 Pricing"));






        mainButtonsPanel = new JPanel(new GridLayout(10, 1, 5, 5));
        mainButtonsPanel.setBorder(new TitledBorder(raisedBorder, "Data Sets"));


        mainButtonsPanel.add(buttonFirst);
        mainButtonsPanel.add(buttonSecond);
        mainButtonsPanel.add(buttonThird);
        mainButtonsPanel.add(button4);
        mainButtonsPanel.add(button5);
        mainButtonsPanel.add(button6);
        mainButtonsPanel.add(button7);
        mainButtonsPanel.add(button8);
        mainButtonsPanel.add(button9);
        mainButtonsPanel.add(button10);



        topTitlePanel = new JPanel(new GridLayout(1, 1));
        label1 = new JLabel("Stage 3 | Preview ");
        label1.setFont(new Font("Calibri", Font.BOLD, 20));
        topTitlePanel.add(label1);

        add(topTitlePanel, BorderLayout.NORTH);
        add(mainButtonsPanel, BorderLayout.CENTER);
        add(button14, BorderLayout.SOUTH);


        setVisible(true);



        actionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JButton source = (JButton) e.getSource();

                if(source == buttonFirst){
                    allocationPage(stage2ShareListWithoutSwitch.get(0), stage2ShareListWithSwitch.get(0), R, M);
                }
                else if(source == buttonSecond){

                    allocationPage(stage2ShareListWithoutSwitch.get(1), stage2ShareListWithSwitch.get(1), R, M);
                }
                else if(source == buttonThird){

                    allocationPage(stage2ShareListWithoutSwitch.get(2), stage2ShareListWithSwitch.get(2), R, M);
                }
                else if(source == button4){

                    allocationPage(stage2ShareListWithoutSwitch.get(3), stage2ShareListWithSwitch.get(3), R, M);
                }

                else if(source == button5){

                    allocationPage(stage2ShareListWithoutSwitch.get(4), stage2ShareListWithSwitch.get(4), R, M);
                }
                else if(source == button6){

                    allocationPage(stage2ShareListWithoutSwitch.get(5), stage2ShareListWithSwitch.get(5), R, M);
                }
                else if(source == button7){

                    allocationPage(stage2ShareListWithoutSwitch.get(6), stage2ShareListWithSwitch.get(6), R, M);
                }
                else if(source == button8){

                    allocationPage(stage2ShareListWithoutSwitch.get(7), stage2ShareListWithSwitch.get(7), R, M);
                }
                else if(source == button9){

                    allocationPage(stage2ShareListWithoutSwitch.get(8), stage2ShareListWithSwitch.get(8), R, M);
                }
                else if(source == button10){

                    allocationPage(stage2ShareListWithoutSwitch.get(9), stage2ShareListWithSwitch.get(9), R, M);
                }
                else if(source == button14){
                    setVisible(false);
                }

            }
        };

        buttonFirst.addActionListener(actionListener);
        buttonSecond.addActionListener(actionListener);
        buttonThird.addActionListener(actionListener);
        button4.addActionListener(actionListener);
        button5.addActionListener(actionListener);
        button6.addActionListener(actionListener);
        button7.addActionListener(actionListener);
        button8.addActionListener(actionListener);
        button9.addActionListener(actionListener);
        button10.addActionListener(actionListener);
        button14.addActionListener(actionListener);


    }




    public void allocationPage(final List<Share> stage1, final List<Share> stage2, final double r, final int m){

        final JFrame frame2 = new JFrame("Allocations");
        frame2.setLayout(new BorderLayout());


        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        frame2.setBounds(0, 0, screenSize.width, screenSize.height - 45);


        final JButton buttonUno = new JButton("View data as a chart");
        buttonUno.setLayout(new GridLayout(0, 3));
        buttonUno.setBorder(new TitledBorder("Chart"));

        final JButton buttonThree = new JButton("View data as a chart");
        buttonThree.setLayout(new GridLayout(0, 3));
        buttonThree.setBorder(new TitledBorder("Chart"));

        final JButton buttonTwo = new JButton("Close");
        buttonTwo.setLayout(new GridLayout(0, 3));
        buttonTwo.setBorder(new TitledBorder("Back to data page"));


        JPanel buttonPanel = new JPanel(new GridLayout(1, 3, 5, 5));

        JSplitPane mainSplit = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
        JPanel leftPanel = new JPanel(new GridLayout(stage1.size(), 1, 5, 5));
        JPanel rightPanel = new JPanel(new GridLayout(stage2.size(), 1, 5, 5));
        mainSplit.setBorder(new TitledBorder(raisedBorder, "Data Points"));
        leftPanel.setBorder(new TitledBorder(raisedBorder, "Stage 2 Allocations With Stage 2 Prices"));
        rightPanel.setBorder(new TitledBorder(raisedBorder, "Stage 2 Allocations With Stage 1 Prices"));


        for(int i = 0; i <stage1.size(); i++){
            JTextField jText = new JTextField(Double.toString(stage1.get(i).getAllocation()));
            jText.setEditable(false);
            jText.setBorder(new TitledBorder("Exact Amount"));
            jText.setSize(100, 50);

            JProgressBar progress = new JProgressBar();
            progress.setBorder(new TitledBorder("Investment"));
            progress.setValue(Math.round(Float.parseFloat(Double.toString(stage1.get(i).getAllocation()))));
            progress.setStringPainted(false);
            progress.setForeground(Color.BLACK);
            progress.setString(Integer.toString(Math.round(Float.parseFloat(Double.toString(stage1.get(i).getAllocation())))));

            JPanel panels = new JPanel();
            panels.setLayout(new GridLayout(0, 2));
            panels.add(progress);
            panels.add(jText);
            panels.setBorder(new TitledBorder("Security " + stage1.get(i).getSecurityNumber()));

            leftPanel.add(panels);
        }


        for(int i = 0; i <stage2.size(); i++){
            JTextField jText = new JTextField(Double.toString(stage2.get(i).getAllocation()));
            jText.setEditable(false);
            jText.setBorder(new TitledBorder("Exact Amount"));
            jText.setSize(100, 50);

            JProgressBar progress = new JProgressBar();
            progress.setBorder(new TitledBorder("Investment"));
            progress.setValue(Math.round(Float.parseFloat(Double.toString(stage2.get(i).getAllocation()))));
            progress.setStringPainted(true);
            progress.setForeground(Color.BLACK);
            progress.setString(Integer.toString(Math.round(Float.parseFloat(Double.toString(stage2.get(i).getAllocation())))));

            JPanel panels = new JPanel();
            panels.setLayout(new GridLayout(0, 2));
            panels.add(progress);
            panels.add(jText);
            panels.setBorder(new TitledBorder("Security " + stage2.get(i).getSecurityNumber()));

            rightPanel.add(panels);
        }


        ActionListener actionChart = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JButton source = (JButton) e.getSource();
                if(source == buttonUno) {
                    chartView(stage1);
                }
                if(source == buttonTwo) {
                    frame2.dispose();

                }
            }
        };

        buttonUno.addActionListener(actionChart);
        buttonTwo.addActionListener(actionChart);

        ActionListener action2 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                chartView(stage2);
            }
        };

        buttonPanel.add(buttonUno);
        buttonPanel.add(buttonTwo);
        buttonPanel.add(buttonThree);

        buttonUno.addActionListener(actionChart);
        buttonThree.addActionListener(action2);

        mainSplit.setLeftComponent(leftPanel);
        mainSplit.setRightComponent(rightPanel);
        mainSplit.setResizeWeight(0.50);

        frame2.add(mainSplit, BorderLayout.CENTER);
        frame2.add(buttonPanel, BorderLayout.SOUTH);
        frame2.setVisible(true);
        JOptionPane.showMessageDialog(frame2.getComponent(0), "This is your allocation based on your inputs");


    }


    public void chartView (List<Share> shareList){

        pieChart pie = new pieChart(shareList);
        JFreeChart pieCharter = pie.getChart();

        ChartFrame frame = new ChartFrame("Data", pieCharter);

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setBounds(0, 0, screenSize.width, screenSize.height);
        frame.setLayout(new BorderLayout());


        frame.pack();
        frame.setVisible(true);



    }































































}


