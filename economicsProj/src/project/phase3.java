package project;

import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/**
 * Created by ihabib on 12/17/2014.
 */
public class phase3 extends JFrame{

//TODO: Plan: phase 3 is going to access the data stored in excel files from stage 1, by using the code we already have.
    //TODO: cont. going to turn that code into one half of the allocation page. The other half will be passed from stage 2
    //TODO: cont. Pressing buttons on the main stage3 phase will launch an allocation page comparing the data sets against
    //TODO: cont. each other. 2 buttons on the bottom asking the user if they want to switch or stay
    //TODO: potentially, show the user what there allocations would be with new prices? (code this option)



    static JFrame frameForPrices;


    static JButton button1;
    static JButton button2;
    static JButton button3;
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

    static JButton previewButton;

    static JPanel buttonPanel;
    static JPanel buttonPanel2;
    static JPanel mainButtonsPanel;
    static JPanel topTitlePanel;



    static JLabel empty1;
    static JLabel empty2;

    static JLabel label1;
    static JLabel label2;
    static JLabel label3;


    static JTextField jtext;

    static ActionListener action;


    static Border raisedBorder;
    static Border loweredBorder;



    FileReader reader1;
    FileReader reader2;
    FileReader reader3;
    FileReader reader4;
    FileReader reader5;
    FileReader reader6;
    FileReader reader7;
    FileReader reader8;
    FileReader reader9;
    FileReader reader10;


    String directory = System.getProperty("user.home") + "/Desktop";


    String filename1 = directory + "/Phase1priceSet1.csv";
    String filename2 = directory + "/Phase1priceSet2.csv";
    String filename3 = directory + "/Phase1priceSet3.csv";
    String filename4 = directory + "/Phase1priceSet4.csv";
    String filename5 = directory + "/Phase1priceSet5.csv";
    String filename6 = directory + "/Phase1priceSet6.csv";
    String filename7 = directory + "/Phase1priceSet7.csv";
    String filename8 = directory + "/Phase1priceSet8.csv";
    String filename9 = directory + "/Phase1priceSet9.csv";
    String filename10 = directory + "/Phase1priceSet10.csv";

    static double R;
    static int M;





    public phase3 (final List<List<Share>> stage2ShareList, final int m, final double r) {


        setLayout(new BorderLayout());
        setTitle("Stage 3");
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setBounds(0, 0, screenSize.width, screenSize.height - 45);


        R = r;
        M = m;


        raisedBorder = new SoftBevelBorder(SoftBevelBorder.RAISED);
        loweredBorder = new SoftBevelBorder(SoftBevelBorder.LOWERED);

        button1 = new JButton("Select to view allocations");
        button2  = new JButton("Select to view allocations");
        button3 = new JButton("Select to view allocations");
        button4 = new JButton("Select to view allocations");
        button5 = new JButton("Select to view allocations");
        button6 = new JButton("Select to view allocations");
        button7 = new JButton("Select to view allocations");
        button8 = new JButton("Select to view allocations");
        button9 = new JButton("Select to view allocations");
        button10 = new JButton("Select to view allocations");
        button11 = new JButton("Select to view prices");
        button12 = new JButton("Maintain Stage 2 Allocations");
        button13 = new JButton("Apply choice rule to stage 1 prices");
        button14 = new JButton("Continue");
        button15 = new JButton("View potential allocations if you choose to switch");



        button1.setFont(new Font("Calibri",  Font.ROMAN_BASELINE, 15));
        button2.setFont(new Font("Calibri",  Font.ROMAN_BASELINE, 15));
        button3.setFont(new Font("Calibri",Font.ROMAN_BASELINE, 15));
        button4.setFont(new Font("Calibri", Font.ROMAN_BASELINE,15));
        button5.setFont(new Font("Calibri", Font.ROMAN_BASELINE, 15));
        button6.setFont(new Font("Calibri", Font.ROMAN_BASELINE, 15));
        button7.setFont(new Font("Calibri", Font.ROMAN_BASELINE, 15));
        button8.setFont(new Font("Calibri", Font.ROMAN_BASELINE, 15));
        button9.setFont(new Font("Calibri",Font.ROMAN_BASELINE,15));
        button10.setFont(new Font("Calibri", Font.ROMAN_BASELINE, 15));
        button11.setFont(new Font("Calibri", Font.ROMAN_BASELINE, 15));
        button12.setFont(new Font("Calibri", Font.ROMAN_BASELINE, 15));
        button13.setFont(new Font("Calibri", Font.ROMAN_BASELINE, 15));
        button14.setFont(new Font("Calibri", Font.ROMAN_BASELINE, 15));
        button15.setFont(new Font("Calibri", Font.ROMAN_BASELINE, 15));





        button1.setBorder(new TitledBorder("Stage 1: Price Set 1 vs. Stage 2: Price Set 1"));
        button2.setBorder(new TitledBorder("Stage 1: Price Set 2 vs. Stage 2: Price Set 2"));
        button3.setBorder(new TitledBorder("Stage 1: Price Set 3 vs. Stage 2: Price Set 3"));
        button4.setBorder(new TitledBorder("Stage 1: Price Set 4 vs. Stage 2: Price Set 4"));
        button5.setBorder(new TitledBorder("Stage 1: Price Set 5 vs. Stage 2: Price Set 5"));
        button6.setBorder(new TitledBorder("Stage 1: Price Set 6 vs. Stage 2: Price Set 6"));
        button7.setBorder(new TitledBorder("Stage 1: Price Set 7 vs. Stage 2: Price Set 7"));
        button8.setBorder(new TitledBorder("Stage 1: Price Set 8 vs. Stage 2: Price Set 8"));
        button9.setBorder(new TitledBorder("Stage 1: Price Set 9 vs. Stage 2: Price Set 9"));
        button10.setBorder(new TitledBorder("Stage 1: Price Set 10 vs. Stage 2: Price Set 10"));
        button11.setBorder(new TitledBorder("Prices used in Stage 1 & Stage 2"));
        button15.setBorder(new TitledBorder("Stage 2 choice rule with Stage 1 prices"));




        mainButtonsPanel = new JPanel(new GridLayout(12, 1, 5, 5));
        mainButtonsPanel.setBorder(new TitledBorder(raisedBorder, "Data Sets"));

        buttonPanel = new JPanel(new GridLayout(1, 2, 5, 5));
        buttonPanel.add(button12);
        buttonPanel.add(button13);

        buttonPanel2 = new JPanel(new GridLayout(1,2, 5, 5));
        buttonPanel2.add(button11);
        buttonPanel2.add(button15);


        mainButtonsPanel.add(button1);
        mainButtonsPanel.add(button2);
        mainButtonsPanel.add(button3);
        mainButtonsPanel.add(button4);
        mainButtonsPanel.add(button5);
        mainButtonsPanel.add(button6);
        mainButtonsPanel.add(button7);
        mainButtonsPanel.add(button8);
        mainButtonsPanel.add(button9);
        mainButtonsPanel.add(button10);
        mainButtonsPanel.add(buttonPanel2);
        mainButtonsPanel.add(buttonPanel);


        topTitlePanel = new JPanel(new GridLayout(1, 1));
        label1 = new JLabel("Stage 3 | Price Allocations");
        label1.setFont(new Font("Calibri", Font.BOLD, 20));
        topTitlePanel.add(label1);

        add(topTitlePanel, BorderLayout.NORTH);
        add(mainButtonsPanel, BorderLayout.CENTER);
        add(button14, BorderLayout.SOUTH);


        setVisible(true);







        action = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JButton source = (JButton) e.getSource();
                if(source == button1){
                    char[] arr = new char[1000];
                    reader1 = createReader(filename1);
                    arr = readFile(arr, reader1);
                    String line = "";
                    for(char c: arr) {
                        line = line + c;
                    }
                    String[] secondLine = line.split("@");

                    List<Share> shareList = new ArrayList<Share>();
                    //the loop has to be -5 b/c the csv file doubles up on errythang
                    for(int i = 1; i < secondLine.length -5; i ++){
                        String number = secondLine[i].substring(secondLine[i].indexOf("%") + 1, secondLine[i].lastIndexOf("%"));
                        String price = secondLine[i].substring(secondLine[i].indexOf("$") + 1, secondLine[i].lastIndexOf("$"));
                        String incomeShare = secondLine[i].substring(secondLine[i].indexOf("^") + 1, secondLine[i].lastIndexOf("^"));
                        String allocation = secondLine[i].substring(secondLine[i].indexOf("#") + 1, secondLine[i].lastIndexOf("#"));
                        Share shr = new Share(Integer.parseInt(price), Integer.parseInt(number), Double.parseDouble(allocation));
                        shareList.add(shr);
                    }
                    for(Share shr: shareList) {
                        System.out.println("price = " + shr.getPrice() + " number = " + shr.getPrice() + " allocation = " + shr.getAllocation());
                    }
                    closeFile(reader1);
                    allocationPage(shareList, stage2ShareList.get(0), R, M);
                }
                else if(source == button2){
                    char[] arr = new char[1000];
                    reader2 = createReader(filename2);
                    arr = readFile(arr, reader2);
                    String line = "";
                    for(char c: arr) {
                        line = line + c;
                    }
                    String[] secondLine = line.split("@");

                    List<Share> shareList = new ArrayList<Share>();
                    //the loop has to be -5 b/c the csv file doubles up on errythang
                    for(int i = 1; i < secondLine.length -5; i ++){
                        String number = secondLine[i].substring(secondLine[i].indexOf("%") + 1, secondLine[i].lastIndexOf("%"));
                        String price = secondLine[i].substring(secondLine[i].indexOf("$") + 1, secondLine[i].lastIndexOf("$"));
                        String incomeShare = secondLine[i].substring(secondLine[i].indexOf("^") + 1, secondLine[i].lastIndexOf("^"));
                        String allocation = secondLine[i].substring(secondLine[i].indexOf("#") + 1, secondLine[i].lastIndexOf("#"));
                        Share shr = new Share(Integer.parseInt(price), Integer.parseInt(number), Double.parseDouble(allocation));
                        shareList.add(shr);
                    }
                    for(Share shr: shareList) {
                        System.out.println("price = " + shr.getPrice() + " number = " + shr.getPrice() + " allocation = " + shr.getAllocation());
                    }

                    closeFile(reader2);
                    allocationPage(shareList,stage2ShareList.get(1), R, M);
                }
                else if(source == button3){
                    char[] arr = new char[1000];
                    reader3 = createReader(filename3);
                    arr = readFile(arr, reader3);
                    String line = "";
                    for(char c: arr) {
                        line = line + c;
                    }
                    String[] secondLine = line.split("@");

                   List<Share> shareList = new ArrayList<Share>();
                    //the loop has to be -5 b/c the csv file doubles up on errythang
                    for(int i = 1; i < secondLine.length -5; i ++){
                        String number = secondLine[i].substring(secondLine[i].indexOf("%") + 1, secondLine[i].lastIndexOf("%"));
                        String price = secondLine[i].substring(secondLine[i].indexOf("$") + 1, secondLine[i].lastIndexOf("$"));
                        String incomeShare = secondLine[i].substring(secondLine[i].indexOf("^") + 1, secondLine[i].lastIndexOf("^"));
                        String allocation = secondLine[i].substring(secondLine[i].indexOf("#") + 1, secondLine[i].lastIndexOf("#"));
                        Share shr = new Share(Integer.parseInt(price), Integer.parseInt(number), Double.parseDouble(allocation));
                        shareList.add(shr);
                    }
                    for(Share shr: shareList) {
                        System.out.println("price = " + shr.getPrice() + " number = " + shr.getPrice() + " allocation = " + shr.getAllocation());
                    }
                    closeFile(reader3);
                    allocationPage(shareList,stage2ShareList.get(2), R, M);
                }
                else if(source == button4){
                    char[] arr = new char[1000];
                    reader4 = createReader(filename4);
                    arr = readFile(arr, reader4);
                    String line = "";
                    for(char c: arr) {
                        line = line + c;
                    }
                    String[] secondLine = line.split("@");

                    List<Share> shareList = new ArrayList<Share>();
                    //the loop DOESNT have to be -5  b/c the csv file DOESNT double up on the last run
                    for(int i = 1; i < secondLine.length; i ++){
                        String number = secondLine[i].substring(secondLine[i].indexOf("%") + 1, secondLine[i].lastIndexOf("%"));
                        String price = secondLine[i].substring(secondLine[i].indexOf("$") + 1, secondLine[i].lastIndexOf("$"));
                        String incomeShare = secondLine[i].substring(secondLine[i].indexOf("^") + 1, secondLine[i].lastIndexOf("^"));
                        String allocation = secondLine[i].substring(secondLine[i].indexOf("#") + 1, secondLine[i].lastIndexOf("#"));
                        Share shr = new Share(Integer.parseInt(price), Integer.parseInt(number), Double.parseDouble(allocation));
                        shareList.add(shr);
                    }
                    for(Share shr: shareList) {
                        System.out.println("price = " + shr.getPrice() + " number = " + shr.getPrice() + " allocation = " + shr.getAllocation());
                    }

                    closeFile(reader4);
                    allocationPage(shareList, stage2ShareList.get(3),R, M);
                }



                else if(source == button5){
                    char[] arr = new char[1000];
                    reader5 = createReader(filename5);
                    arr = readFile(arr, reader5);
                    String line = "";
                    for(char c: arr) {
                        line = line + c;
                    }
                    String[] secondLine = line.split("@");

                    List<Share> shareList = new ArrayList<Share>();
                    //the loop DOESNT have to be -5  b/c the csv file DOESNT double up on the last run
                    for(int i = 1; i < secondLine.length; i ++){
                        String number = secondLine[i].substring(secondLine[i].indexOf("%") + 1, secondLine[i].lastIndexOf("%"));
                        String price = secondLine[i].substring(secondLine[i].indexOf("$") + 1, secondLine[i].lastIndexOf("$"));
                        String incomeShare = secondLine[i].substring(secondLine[i].indexOf("^") + 1, secondLine[i].lastIndexOf("^"));
                        String allocation = secondLine[i].substring(secondLine[i].indexOf("#") + 1, secondLine[i].lastIndexOf("#"));
                        Share shr = new Share(Integer.parseInt(price), Integer.parseInt(number), Double.parseDouble(allocation));
                        shareList.add(shr);
                    }
                    for(Share shr: shareList) {
                        System.out.println("price = " + shr.getPrice() + " number = " + shr.getPrice() + " allocation = " + shr.getAllocation());
                    }

                    closeFile(reader5);
                    allocationPage(shareList,stage2ShareList.get(4), R, M);
                }
                else if(source == button6){
                    char[] arr = new char[1000];
                    reader6 = createReader(filename6);
                    arr = readFile(arr, reader6);
                    String line = "";
                    for(char c: arr) {
                        line = line + c;
                    }
                    String[] secondLine = line.split("@");

                    List<Share> shareList = new ArrayList<Share>();
                    //the loop DOESNT have to be -5  b/c the csv file DOESNT double up on the last run
                    for(int i = 1; i < secondLine.length; i ++){
                        String number = secondLine[i].substring(secondLine[i].indexOf("%") + 1, secondLine[i].lastIndexOf("%"));
                        String price = secondLine[i].substring(secondLine[i].indexOf("$") + 1, secondLine[i].lastIndexOf("$"));
                        String incomeShare = secondLine[i].substring(secondLine[i].indexOf("^") + 1, secondLine[i].lastIndexOf("^"));
                        String allocation = secondLine[i].substring(secondLine[i].indexOf("#") + 1, secondLine[i].lastIndexOf("#"));
                        Share shr = new Share(Integer.parseInt(price), Integer.parseInt(number), Double.parseDouble(allocation));
                        shareList.add(shr);
                    }
                    for(Share shr: shareList) {
                        System.out.println("price = " + shr.getPrice() + " number = " + shr.getPrice() + " allocation = " + shr.getAllocation());
                    }

                    closeFile(reader6);
                    allocationPage(shareList, stage2ShareList.get(5),R, M);
                }
                else if(source == button7){
                    char[] arr = new char[1000];
                    reader7 = createReader(filename7);
                    arr = readFile(arr, reader7);
                    String line = "";
                    for(char c: arr) {
                        line = line + c;
                    }
                    String[] secondLine = line.split("@");

                    List<Share> shareList = new ArrayList<Share>();
                    //the loop DOESNT have to be -5  b/c the csv file DOESNT double up on the last run
                    for(int i = 1; i < secondLine.length; i ++){
                        String number = secondLine[i].substring(secondLine[i].indexOf("%") + 1, secondLine[i].lastIndexOf("%"));
                        String price = secondLine[i].substring(secondLine[i].indexOf("$") + 1, secondLine[i].lastIndexOf("$"));
                        String incomeShare = secondLine[i].substring(secondLine[i].indexOf("^") + 1, secondLine[i].lastIndexOf("^"));
                        String allocation = secondLine[i].substring(secondLine[i].indexOf("#") + 1, secondLine[i].lastIndexOf("#"));
                        Share shr = new Share(Integer.parseInt(price), Integer.parseInt(number), Double.parseDouble(allocation));
                        shareList.add(shr);
                    }
                    for(Share shr: shareList) {
                        System.out.println("price = " + shr.getPrice() + " number = " + shr.getPrice() + " allocation = " + shr.getAllocation());
                    }

                    closeFile(reader7);
                    allocationPage(shareList, stage2ShareList.get(6),R, M);
                }
                else if(source == button8){
                    char[] arr = new char[1000];
                    reader8 = createReader(filename8);
                    arr = readFile(arr, reader8);
                    String line = "";
                    for(char c: arr) {
                        line = line + c;
                    }
                    String[] secondLine = line.split("@");

                    List<Share> shareList = new ArrayList<Share>();
                    //the loop DOESNT have to be -5  b/c the csv file DOESNT double up on the last run
                    for(int i = 1; i < secondLine.length; i ++){
                        String number = secondLine[i].substring(secondLine[i].indexOf("%") + 1, secondLine[i].lastIndexOf("%"));
                        String price = secondLine[i].substring(secondLine[i].indexOf("$") + 1, secondLine[i].lastIndexOf("$"));
                        String incomeShare = secondLine[i].substring(secondLine[i].indexOf("^") + 1, secondLine[i].lastIndexOf("^"));
                        String allocation = secondLine[i].substring(secondLine[i].indexOf("#") + 1, secondLine[i].lastIndexOf("#"));
                        Share shr = new Share(Integer.parseInt(price), Integer.parseInt(number), Double.parseDouble(allocation));
                        shareList.add(shr);
                    }
                    for(Share shr: shareList) {
                        System.out.println("price = " + shr.getPrice() + " number = " + shr.getPrice() + " allocation = " + shr.getAllocation());
                    }

                    closeFile(reader8);
                    allocationPage(shareList,stage2ShareList.get(7), R, M);
                }
                else if(source == button9){
                    char[] arr = new char[1000];
                    reader9 = createReader(filename9);
                    arr = readFile(arr, reader9);
                    String line = "";
                    for(char c: arr) {
                        line = line + c;
                    }
                    String[] secondLine = line.split("@");

                    List<Share> shareList = new ArrayList<Share>();
                    //the loop DOESNT have to be -5  b/c the csv file DOESNT double up on the last run
                    for(int i = 1; i < secondLine.length; i ++){
                        String number = secondLine[i].substring(secondLine[i].indexOf("%") + 1, secondLine[i].lastIndexOf("%"));
                        String price = secondLine[i].substring(secondLine[i].indexOf("$") + 1, secondLine[i].lastIndexOf("$"));
                        String incomeShare = secondLine[i].substring(secondLine[i].indexOf("^") + 1, secondLine[i].lastIndexOf("^"));
                        String allocation = secondLine[i].substring(secondLine[i].indexOf("#") + 1, secondLine[i].lastIndexOf("#"));
                        Share shr = new Share(Integer.parseInt(price), Integer.parseInt(number), Double.parseDouble(allocation));
                        shareList.add(shr);
                    }
                    for(Share shr: shareList) {
                        System.out.println("price = " + shr.getPrice() + " number = " + shr.getPrice() + " allocation = " + shr.getAllocation());
                    }

                    closeFile(reader9);
                    allocationPage(shareList, stage2ShareList.get(8),R, M);
                }
                else if(source == button10){
                    char[] arr = new char[1000];
                    reader10 = createReader(filename10);
                    arr = readFile(arr, reader10);
                    String line = "";
                    for(char c: arr) {
                        line = line + c;
                    }
                    String[] secondLine = line.split("@");

                    List<Share> shareList = new ArrayList<Share>();
                    //the loop DOESNT have to be -5  b/c the csv file DOESNT double up on the last run
                    for(int i = 1; i < secondLine.length; i ++){
                        String number = secondLine[i].substring(secondLine[i].indexOf("%") + 1, secondLine[i].lastIndexOf("%"));
                        String price = secondLine[i].substring(secondLine[i].indexOf("$") + 1, secondLine[i].lastIndexOf("$"));
                        String incomeShare = secondLine[i].substring(secondLine[i].indexOf("^") + 1, secondLine[i].lastIndexOf("^"));
                        String allocation = secondLine[i].substring(secondLine[i].indexOf("#") + 1, secondLine[i].lastIndexOf("#"));
                        Share shr = new Share(Integer.parseInt(price), Integer.parseInt(number), Double.parseDouble(allocation));
                        shareList.add(shr);
                    }
                    for(Share shr: shareList) {
                        System.out.println("price = " + shr.getPrice() + " number = " + shr.getPrice() + " allocation = " + shr.getAllocation());
                    }

                    closeFile(reader10);
                    allocationPage(shareList,stage2ShareList.get(9), R, M);
                }

            }
        };

        button1.addActionListener(action);
        button2.addActionListener(action);
        button3.addActionListener(action);
        button4.addActionListener(action);
        button5.addActionListener(action);
        button6.addActionListener(action);
        button7.addActionListener(action);
        button8.addActionListener(action);
        button9.addActionListener(action);
        button10.addActionListener(action);













    }










    public void allocationPage(final List<Share> stage1, final List<Share> stage2, final double r, final int m){

        final JFrame frame2 = new JFrame("Allocations");
        frame2.setLayout(new BorderLayout());


        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        frame2.setBounds(0, 0, screenSize.width, screenSize.height - 45);
        frame2.setLayout(new BorderLayout());

        JButton button1 = new JButton("View data as a chart");
        button1.setLayout(new GridLayout(0, 3));
        button1.setBorder(new TitledBorder("Chart"));

        JButton button3 = new JButton("View data as a chart");
        button1.setLayout(new GridLayout(0, 3));
        button1.setBorder(new TitledBorder("Chart"));

        JButton button2 = new JButton("Continue");
        button2.setLayout(new GridLayout(0, 3));
        button2.setBorder(new TitledBorder("Next Round"));


        JPanel buttonPanel = new JPanel(new GridLayout(1, 2, 5, 5));

        JPanel panelNew = new JPanel();
        JPanel panelNewer = new JPanel();
        JPanel mainPanel = new JPanel(new GridLayout(stage1.size(), 4));
        panelNew.setLayout(new GridLayout(stage1.size(), 2));
        panelNewer.setLayout(new GridLayout(stage2.size(), 2));
        panelNew.setBorder(new TitledBorder("Data"));

        for(int i = 0; i <stage1.size(); i++){
            JTextField jText = new JTextField(Double.toString(stage1.get(i).getAllocation()));
            jText.setEditable(false);
            jText.setBorder(new TitledBorder("Exact Amount"));
            jText.setSize(100, 50);

            JProgressBar progress = new JProgressBar();
            progress.setBorder(new TitledBorder("Investment"));
            progress.setValue(Math.round(Float.parseFloat(Double.toString(stage1.get(i).getAllocation()))));
            progress.setStringPainted(true);
            progress.setForeground(Color.BLACK);
            progress.setString(Integer.toString(Math.round(Float.parseFloat(Double.toString(stage1.get(i).getAllocation())))));

            JPanel panels = new JPanel();
            panels.setLayout(new GridLayout(0, 2));
            panels.add(progress);
            panels.add(jText);
            panels.setBorder(new TitledBorder("Security " + stage1.get(i).getSecurityNumber()));

            panelNew.add(panels);
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

            panelNewer.add(panels);
        }


        ActionListener action = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                chartView(stage1);
            }
        };

        ActionListener action2 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                chartView(stage2);
            }
        };

        buttonPanel.add(button1);
        buttonPanel.add(button2);

        button1.addActionListener(action);
        button3.addActionListener(action2);

        mainPanel.add(panelNew);
        mainPanel.add(panelNewer);

        JSplitPane splitPanel1 = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
        splitPanel1.setTopComponent(mainPanel);
        splitPanel1.setBottomComponent(buttonPanel);
        splitPanel1.setResizeWeight(0.75);

        frame2.add(splitPanel1, BorderLayout.CENTER);
        frame2.add(button2, BorderLayout.SOUTH);
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

    public FileReader createReader (String filename){
        try {
            FileReader readMe = new FileReader(filename);
            return readMe;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;

    }


    public void closeFile(FileReader filer){
        try {
            filer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public char[] readFile(char [] arr, FileReader reader){
        char [] details = new char[arr.length];
        try {
            reader.read(details);
            return details;
        } catch (IOException e){
            e.printStackTrace();
        }
        return null;

    }



















































































}