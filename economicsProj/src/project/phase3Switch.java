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

/**
 * Created by Imran on 2014-12-20.
 */
public class phase3Switch extends JFrame {



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



  String directory = System.getProperty("user.home") + "/Desktop/output";

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






  static double R;
  static int M;



  public phase3Switch (final int m, final double r) {


    setLayout(new BorderLayout());
    setTitle("Stage 1 | Allocations");
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    setBounds(0, 0, screenSize.width, screenSize.height - 45);
    setBackground(Color.orange);


    R = r;
    M = m;



    raisedBorder = new SoftBevelBorder(SoftBevelBorder.RAISED);
    loweredBorder = new SoftBevelBorder(SoftBevelBorder.LOWERED);

    buttonFirst = new JButton("Select to view stage 1 allocation: Price Set 1");
    buttonSecond  = new JButton("Select to view stage 1 allocation: Price Set 2");
    buttonThird = new JButton("Select to view stage 1 allocation: Price Set 3");
    button4 = new JButton("Select to view stage 1 allocation: Price Set 4");
    button5 = new JButton("Select to view stage 1 allocation: Price Set 5");
    button6 = new JButton("Select to view stage 1 allocation: Price Set 6");
    button7 = new JButton("Select to view stage 1 allocation: Price Set 7");
    button8 = new JButton("Select to view stage 1 allocation: Price Set 8");
    button9 = new JButton("Select to view stage 1 allocation: Price Set 9");
    button10 = new JButton("Select to view stage 1 allocation: Price Set 10");



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






    buttonFirst.setBorder(new TitledBorder("Stage 1 Allocation"));
    buttonSecond.setBorder(new TitledBorder("Current Choice Rule Allocation vs. Choice Rule applied to Stage 1 Pricing"));
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

              for(int i = 1; i < secondLine.length; i ++){
                String number = secondLine[i].substring(secondLine[i].indexOf("%") + 1, secondLine[i].lastIndexOf("%"));
                String price = secondLine[i].substring(secondLine[i].indexOf("$") + 1, secondLine[i].lastIndexOf("$"));
                String allocation = secondLine[i].substring(secondLine[i].indexOf("#") + 1, secondLine[i].lastIndexOf("#"));
                Share shr = new Share(Integer.parseInt(price), Integer.parseInt(number), Double.parseDouble(allocation));
                shareList.add(shr);
              }

              closeFile(reader1);
              allocationPage(shareList, R, M);
            }
            else if(source == buttonSecond){
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
              for(int i = 1; i < secondLine.length; i ++){
                String number = secondLine[i].substring(secondLine[i].indexOf("%") + 1, secondLine[i].lastIndexOf("%"));
                String price = secondLine[i].substring(secondLine[i].indexOf("$") + 1, secondLine[i].lastIndexOf("$"));
                //       String incomeShare = secondLine[i].substring(secondLine[i].indexOf("^") + 1, secondLine[i].lastIndexOf("^"));
                String allocation = secondLine[i].substring(secondLine[i].indexOf("#") + 1, secondLine[i].lastIndexOf("#"));
                Share shr = new Share(Integer.parseInt(price), Integer.parseInt(number), Double.parseDouble(allocation));
                shareList.add(shr);
              }

              closeFile(reader2);
              allocationPage(shareList, R, M);
            }
            else if(source == buttonThird){
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
              for(int i = 1; i < secondLine.length; i ++){
                String number = secondLine[i].substring(secondLine[i].indexOf("%") + 1, secondLine[i].lastIndexOf("%"));
                String price = secondLine[i].substring(secondLine[i].indexOf("$") + 1, secondLine[i].lastIndexOf("$"));
                //       String incomeShare = secondLine[i].substring(secondLine[i].indexOf("^") + 1, secondLine[i].lastIndexOf("^"));
                String allocation = secondLine[i].substring(secondLine[i].indexOf("#") + 1, secondLine[i].lastIndexOf("#"));
                Share shr = new Share(Integer.parseInt(price), Integer.parseInt(number), Double.parseDouble(allocation));
                shareList.add(shr);
              }

              closeFile(reader3);
              allocationPage(shareList, R, M);
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
                String allocation = secondLine[i].substring(secondLine[i].indexOf("#") + 1, secondLine[i].lastIndexOf("#"));
                Share shr = new Share(Integer.parseInt(price), Integer.parseInt(number), Double.parseDouble(allocation));
                shareList.add(shr);
              }

              closeFile(reader4);
              allocationPage(shareList,R, M);
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
                //        String incomeShare = secondLine[i].substring(secondLine[i].indexOf("^") + 1, secondLine[i].lastIndexOf("^"));
                String allocation = secondLine[i].substring(secondLine[i].indexOf("#") + 1, secondLine[i].lastIndexOf("#"));
                Share shr = new Share(Integer.parseInt(price), Integer.parseInt(number), Double.parseDouble(allocation));
                shareList.add(shr);
              }


              closeFile(reader5);
              allocationPage(shareList,R, M);
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
                //          String incomeShare = secondLine[i].substring(secondLine[i].indexOf("^") + 1, secondLine[i].lastIndexOf("^"));
                String allocation = secondLine[i].substring(secondLine[i].indexOf("#") + 1, secondLine[i].lastIndexOf("#"));
                Share shr = new Share(Integer.parseInt(price), Integer.parseInt(number), Double.parseDouble(allocation));
                shareList.add(shr);
              }


              closeFile(reader6);
              allocationPage(shareList, R, M);
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
                //          String incomeShare = secondLine[i].substring(secondLine[i].indexOf("^") + 1, secondLine[i].lastIndexOf("^"));
                String allocation = secondLine[i].substring(secondLine[i].indexOf("#") + 1, secondLine[i].lastIndexOf("#"));
                Share shr = new Share(Integer.parseInt(price), Integer.parseInt(number), Double.parseDouble(allocation));
                shareList.add(shr);
              }


              closeFile(reader7);
              allocationPage(shareList,R, M);
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
                //          String incomeShare = secondLine[i].substring(secondLine[i].indexOf("^") + 1, secondLine[i].lastIndexOf("^"));
                String allocation = secondLine[i].substring(secondLine[i].indexOf("#") + 1, secondLine[i].lastIndexOf("#"));
                Share shr = new Share(Integer.parseInt(price), Integer.parseInt(number), Double.parseDouble(allocation));
                shareList.add(shr);
              }


              closeFile(reader8);
              allocationPage(shareList, R, M);
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
                String allocation = secondLine[i].substring(secondLine[i].indexOf("#") + 1, secondLine[i].lastIndexOf("#"));
                Share shr = new Share(Integer.parseInt(price), Integer.parseInt(number), Double.parseDouble(allocation));
                shareList.add(shr);
              }


              closeFile(reader9);
              allocationPage(shareList, R, M);
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
                String allocation = secondLine[i].substring(secondLine[i].indexOf("#") + 1, secondLine[i].lastIndexOf("#"));
                Share shr = new Share(Integer.parseInt(price), Integer.parseInt(number), Double.parseDouble(allocation));
                shareList.add(shr);
              }

              closeFile(reader10);
              allocationPage(shareList, R, M);
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



  public void allocationPage(final List<Share> shareList, final double r, final int m){

    final JFrame frame2 = new JFrame("Allocations");
    frame2.setLayout(new BorderLayout());


    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    frame2.setBounds(0, 0, screenSize.width, screenSize.height - 45);
    frame2.setLayout(new BorderLayout());

    final JButton button1 = new JButton("View data as a chart");
    button1.setLayout(new GridLayout(0, 3));
    button1.setBorder(new TitledBorder("Chart"));

    final JButton button2 = new JButton("Close");
    button2.setLayout(new GridLayout(0, 3));
    button2.setBorder(new TitledBorder("Back to data page"));



    JPanel panelNew = new JPanel();
    panelNew.setLayout(new GridLayout(shareList.size(), 2));
    panelNew.setBorder(new TitledBorder("Data"));

    for(int i = 0; i <shareList.size(); i++){
      JTextField jText = new JTextField(Double.toString(shareList.get(i).getAllocation()));
      jText.setEditable(false);
      jText.setBorder(new TitledBorder("Exact Amount"));
      jText.setSize(100, 50);

      JProgressBar progress = new JProgressBar();
      progress.setBorder(new TitledBorder("Investment"));
      progress.setValue(Math.round(Float.parseFloat(Double.toString(shareList.get(i).getAllocation()))));
      progress.setStringPainted(false);
      progress.setForeground(Color.BLACK);
      progress.setString(Integer.toString(Math.round(Float.parseFloat(Double.toString(shareList.get(i).getAllocation())))));

      JPanel panels = new JPanel();
      panels.setLayout(new GridLayout(0, 2));
      panels.add(progress);
      panels.add(jText);
      panels.setBorder(new TitledBorder("Security " + shareList.get(i).getSecurityNumber()));

      panelNew.add(panels);
    }


    ActionListener action = new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        JButton source = (JButton) e.getSource();
        if(source == button1) {
          chartView(shareList);
        }
        if(source == button2) {
          frame2.dispose();

        }
      }
    };

    button1.addActionListener(action);
    button2.addActionListener(action);


    JSplitPane splitPanel1 = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
    splitPanel1.setTopComponent(panelNew);
    splitPanel1.setBottomComponent(button1);
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
    System.out.println("Here for some reason");
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
    System.out.println("Here for some other reaspn");
    return null;

  }
























































}


