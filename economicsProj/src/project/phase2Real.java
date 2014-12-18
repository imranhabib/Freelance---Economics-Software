package project;

import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import project.Share;
import project.pieChart;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;


/**
 * Created by Imran on 2014-12-15.
 */
public class phase2Real {

  private static ActionListener actionListener1;
  private static ActionListener actionListener2;
  private static ActionListener actionListener3;
  private static ActionListener actionListener4;
  private static ActionListener actionListener5;
  private static ActionListener actionListener6;
  private static ActionListener actionListener7;
  private static ActionListener actionListener8;
  private static ActionListener actionListener9;
  private static ActionListener actionListener10;
  private static ActionListener actionListener11;

  static JFrame mainScreen;

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

  static JPanel topPanel;
  static JPanel bottomPanel;
  static JPanel buttonPanel;
  static JPanel leftPanel;


  static JLabel title;
  static JLabel title6;
  static JLabel title7;

  static JLabel empty1;
  static JLabel empty2;
  static JLabel empty3;
  static JLabel empty4;
  static JLabel empty5;
  static JLabel empty6;
  static JLabel empty7;
  static JLabel empty8;
  static JLabel empty9;

  static JSplitPane split;
  static JSplitPane split2;
  static JTextArea text;
  static JTextArea text2;


  static Border raisedBorder;
  static Border loweredBorder;


  private String newline = "\n";
  private String newtab = "\t\t\t\t";

  static String prices;
  static String choices;

  static double r;
  static int minShare;

  allocation alloc;
  parameters param;
  incomeRequired income;
  static int maxMoney;

  static double[] incomeShares;

  phase2Real (double[] incomes, double ratio, int m, int max) {

    param = new parameters();
    alloc = new allocation(param, new incomeRequired(2));
    incomeShares = incomes;
    maxMoney = max;

    r = ratio;
    minShare = m;

    String pric = (ResourceBundle.getBundle("resources/systemdata").getString("priceSet" + Integer.toString(1)));
    String[] price = pric.split(",");

    prices = "Allocation 1: " + (ResourceBundle.getBundle("resources/systemdata").getString("priceSet" + Integer.toString(1))) + newline
        +  "Allocation 2: " +(ResourceBundle.getBundle("resources/systemdata").getString("priceSet" + Integer.toString(2))) + newline
        +  "Allocation 3: " +(ResourceBundle.getBundle("resources/systemdata").getString("priceSet" + Integer.toString(3))) + newline
        +  "Allocation 4: " +(ResourceBundle.getBundle("resources/systemdata").getString("priceSet" + Integer.toString(4))) + newline
        + "Allocation 5: " +(ResourceBundle.getBundle("resources/systemdata").getString("priceSet" + Integer.toString(5))) + newline
        +"Allocation 6: " +(ResourceBundle.getBundle("resources/systemdata").getString("priceSet" + Integer.toString(6))) + newline
        + "Allocation 7: " +(ResourceBundle.getBundle("resources/systemdata").getString("priceSet" + Integer.toString(7))) + newline
        + "Allocation 8: " +(ResourceBundle.getBundle("resources/systemdata").getString("priceSet" + Integer.toString(8)))+ newline
        +"Allocation 9: " +(ResourceBundle.getBundle("resources/systemdata").getString("priceSet" + Integer.toString(9))) + newline +
        "Allocation 10: " +(ResourceBundle.getBundle("resources/systemdata").getString("priceSet" + Integer.toString(10))) + newline ;

    choices = "We can put anything here or get rid of it";



    mainScreen = new JFrame("Stage 2 Test Round Data");
    mainScreen.setLayout(new BorderLayout());
    Dimension screenSize = new Dimension(600, 800);
    mainScreen.setBounds(0,0,1200,700);
    mainScreen.setLocationRelativeTo(null);


    raisedBorder = new SoftBevelBorder(SoftBevelBorder.RAISED);
    loweredBorder = new SoftBevelBorder(SoftBevelBorder.LOWERED);



    split = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
    split.setResizeWeight(.80);
    topPanel = new JPanel(new GridLayout(10, 2, 10 , 10));


    button1 = new JButton("Click to see allocations from price set 1");
    button2 = new JButton("Click to see allocations from price set 2");
    button3 = new JButton("Click to see allocations from price set 3");
    button4 = new JButton("Click to see allocations from price set 4");
    button5 = new JButton("Click to see allocations from price set 5");
    button6 = new JButton("Click to see allocations from price set 6");
    button7 = new JButton("Click to see allocations from price set 7");
    button8 = new JButton("Click to see allocations from price set 8");

    button9 = new JButton("Click to see allocations from price set 9");
    button10 = new JButton("Click to see allocations from price set 10");

    button1.setFont(new Font("Calibri", Font.BOLD, 20));
    button2.setFont(new Font("Calibri", Font.BOLD, 20));
    button3.setFont(new Font("Calibri", Font.BOLD, 20));
    button4.setFont(new Font("Calibri", Font.BOLD, 20));
    button5.setFont(new Font("Calibri", Font.BOLD, 20));
    button6.setFont(new Font("Calibri", Font.BOLD, 20));
    button7.setFont(new Font("Calibri", Font.BOLD, 20));
    button8.setFont(new Font("Calibri", Font.BOLD, 20));
    button9.setFont(new Font("Calibri", Font.BOLD, 20));
    button10.setFont(new Font("Calibri", Font.BOLD, 20));

    empty1 = new JLabel();
    empty2 = new JLabel();
    empty3 = new JLabel();
    empty4 = new JLabel();
    empty5 = new JLabel();
    empty6 = new JLabel();
    empty7 = new JLabel();
    empty8 = new JLabel();
    empty9 = new JLabel();



    topPanel.add(button1);
    topPanel.add(empty1);
    topPanel.add(button2);
    topPanel.add(empty2);
    topPanel.add(button3);
    topPanel.add(empty3);
    topPanel.add(button4);
    topPanel.add(empty4);
    topPanel.add(button5);
    topPanel.add(empty5);
    topPanel.add(button6);
    topPanel.add(empty6);
    topPanel.add(button7);
    topPanel.add(empty7);
    topPanel.add(button8);
    topPanel.add(empty8);
    topPanel.add(button9);
    topPanel.add(empty9);
    topPanel.add(button10);


    title = new JLabel();

    title = new JLabel("Data Page for Stage 2 Allocations");
    title.setFont(new Font("Calibri", Font.BOLD, 20));

    mainScreen.add(title, BorderLayout.NORTH);
    split.setTopComponent(topPanel);

    split2 = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
    split2.setResizeWeight(.50);

    bottomPanel = new JPanel(new BorderLayout());
    leftPanel = new JPanel(new BorderLayout());

    title7 = new JLabel("Instructions");
    leftPanel.add(title7, BorderLayout.NORTH);


    title6 = new JLabel("Prices in Stage 2");
    bottomPanel.add(title6, BorderLayout.NORTH);

    text = new JTextArea(prices);
    text.setFont(new Font("Calibri", Font.BOLD, 16));
    text.setLineWrap(true);
    text.setWrapStyleWord(true);

    text2 = new JTextArea(choices);
    text2.setFont(new Font("Calibri", Font.BOLD, 16));
    text2.setLineWrap(true);
    text2.setWrapStyleWord(true);

    bottomPanel.add(text, BorderLayout.CENTER);
    leftPanel.add(text2, BorderLayout.CENTER);


    button11 = new JButton("extra button");
    button12= new JButton("Proceed to Stage 3");

    buttonPanel = new JPanel(new GridLayout(1, 0, 5, 5));
    buttonPanel.add(button11);
    buttonPanel.add(button12);

    final List<List<Share>> allTen = new ArrayList<List<Share>>();

    actionListener1 = new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        String price = (ResourceBundle.getBundle("resources/systemdata").getString("priceSet1"));
        String[] prices = price.split(",");
        ArrayList<Share> shares = convertPriceSets(prices, r, minShare, incomeShares, maxMoney);
        //make it pop up the allocation page
        allTen.add(shares);
        allocationPage(shares, r, minShare);

      }
    };

    actionListener2 = new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        String price = (ResourceBundle.getBundle("resources/systemdata").getString("priceSet2"));
        String[] prices = price.split(",");
        ArrayList<Share> shares = convertPriceSets(prices, r, minShare, incomeShares, maxMoney);
        //make it pop up the allocation page
        allTen.add(shares);
        allocationPage(shares, r, minShare);

      }
    };

    actionListener3 = new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        String price = (ResourceBundle.getBundle("resources/systemdata").getString("priceSet3"));
        String[] prices = price.split(",");
        ArrayList<Share> shares = convertPriceSets(prices, r, minShare, incomeShares, maxMoney);
        //make it pop up the allocation page
        allTen.add(shares);
        allocationPage(shares, r, minShare);

      }
    };

    actionListener4 = new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        String price = (ResourceBundle.getBundle("resources/systemdata").getString("priceSet4"));
        String[] prices = price.split(",");
        ArrayList<Share> shares = convertPriceSets(prices, r, minShare, incomeShares, maxMoney);
        //make it pop up the allocation page
        allTen.add(shares);
        allocationPage(shares, r, minShare);

      }
    };

    actionListener5 = new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        String price = (ResourceBundle.getBundle("resources/systemdata").getString("priceSet5"));
        String[] prices = price.split(",");
        ArrayList<Share> shares = convertPriceSets(prices, r, minShare, incomeShares, maxMoney);
        //make it pop up the allocation page
        allTen.add(shares);
        allocationPage(shares, r, minShare);

      }
    };

    actionListener6 = new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        String price = (ResourceBundle.getBundle("resources/systemdata").getString("priceSet6"));
        String[] prices = price.split(",");
        ArrayList<Share> shares = convertPriceSets(prices, r, minShare, incomeShares, maxMoney);
        //make it pop up the allocation page
        allTen.add(shares);
        allocationPage(shares, r, minShare);

      }
    };

    actionListener7 = new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        String price = (ResourceBundle.getBundle("resources/systemdata").getString("priceSet7"));
        String[] prices = price.split(",");
        ArrayList<Share> shares = convertPriceSets(prices, r, minShare, incomeShares, maxMoney);
        //make it pop up the allocation page
        allTen.add(shares);
        allocationPage(shares, r, minShare);

      }
    };

    actionListener8 = new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        String price = (ResourceBundle.getBundle("resources/systemdata").getString("priceSet8"));
        String[] prices = price.split(",");
        ArrayList<Share> shares = convertPriceSets(prices, r, minShare, incomeShares, maxMoney);
        //make it pop up the allocation page
        allTen.add(shares);
        allocationPage(shares, r, minShare);

      }
    };

    actionListener9 = new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        String price = (ResourceBundle.getBundle("resources/systemdata").getString("priceSet9"));
        String[] prices = price.split(",");
        ArrayList<Share> shares = convertPriceSets(prices, r, minShare, incomeShares, maxMoney);
        //make it pop up the allocation page
        allTen.add(shares);
        allocationPage(shares, r, minShare);

      }
    };

    actionListener10 = new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        String price = (ResourceBundle.getBundle("resources/systemdata").getString("priceSet10"));
        String[] prices = price.split(",");
        ArrayList<Share> shares = convertPriceSets(prices, r, minShare, incomeShares, maxMoney);
        //make it pop up the allocation page
        allTen.add(shares);
        allocationPage(shares, r, minShare);

      }
    };


    actionListener11 = new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        //phase3(allTen,minShare, r);
      }
    };





    button1.addActionListener(actionListener1);
    button2.addActionListener(actionListener2);
    button3.addActionListener(actionListener3);
    button4.addActionListener(actionListener4);
    button5.addActionListener(actionListener5);
    button6.addActionListener(actionListener6);
    button7.addActionListener(actionListener7);
    button8.addActionListener(actionListener8);
    button9.addActionListener(actionListener9);
    button10.addActionListener(actionListener10);
    button11.addActionListener(actionListener11);












    split2.setRightComponent(bottomPanel);
    split2.setLeftComponent(leftPanel);
    split.setBottomComponent(split2);

    mainScreen.add(buttonPanel, BorderLayout.SOUTH);
    mainScreen.add(split);
    mainScreen.setVisible(true);











  }

  public ArrayList<Share> convertPriceSets(String[] prices, double r, int minShare, double[] incomes, int max){
    int maxMoney = max;
    ArrayList<Share> shareList = new ArrayList<Share>();
    for(int i=0; i<prices.length; i++){
      int temp = Integer.parseInt(prices[i]);
      shareList.add(new Share(temp,incomes[i],i+1));
    }

    if (shareList.size() == 1) {
      for (int i = 0; i < shareList.size(); i++) {
        double allocationVal = allocForShare(i + 1, r, shareList, minShare, maxMoney);
        Share share = new Share(shareList.get(i).getPrice(), shareList.get(i).getIncomeShare(), shareList.get(i).getSecurityNumber(), allocationVal);
        shareList.remove(i);
        shareList.add(i, share);

      }

    }


    if (shareList.size() == 2) {
      for (int i = 0; i < shareList.size(); i++) {
        double allocationVal = allocForShare(i + 1, r, shareList, minShare, maxMoney);
        Share share = new Share(shareList.get(i).getPrice(), shareList.get(i).getIncomeShare(), shareList.get(i).getSecurityNumber(), allocationVal);
        shareList.remove(i);
        shareList.add(i, share);

      }

    }

    if (shareList.size() == 3) {
      for (int i = 0; i < shareList.size(); i++) {
        double allocationVal = allocForShare(i + 1, r, shareList, minShare, maxMoney);
        Share share = new Share(shareList.get(i).getPrice(), shareList.get(i).getIncomeShare(), shareList.get(i).getSecurityNumber(), allocationVal);
        shareList.remove(i);
        shareList.add(i, share);
      }

    }

    if (shareList.size() == 4) {
      for (int i = 0; i < shareList.size(); i++) {
        double allocationVal = allocForShare(i + 1, r, shareList, minShare, maxMoney);
        Share share = new Share(shareList.get(i).getPrice(), shareList.get(i).getIncomeShare(), shareList.get(i).getSecurityNumber(), allocationVal);
        shareList.remove(i);
        shareList.add(i, share);
      }

    }

    if (shareList.size() == 5) {
      for (int i = 0; i < shareList.size(); i++) {
        double allocationVal = allocForShare(i + 1, r, shareList, minShare, maxMoney);
        Share share = new Share(shareList.get(i).getPrice(), shareList.get(i).getIncomeShare(), shareList.get(i).getSecurityNumber(), allocationVal);
        shareList.remove(i);
        shareList.add(i, share);
      }

    }
    return shareList;
  }



  //caller here
  public static void main (String[] args) throws Exception {
    double[] t = {50,40,10,0,0};
    phase2Real phase = new phase2Real(t, 3.0, 2, 100);

  }

  public void allocationPage(final java.util.List<Share> shareList, final double r, final int m){

    final JFrame frame2 = new JFrame("Allocations");
    frame2.setLayout(new BorderLayout());


    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    frame2.setBounds(0, 0, screenSize.width, screenSize.height - 45);
    frame2.setLayout(new BorderLayout());

    JButton button1 = new JButton("View data as a chart");
    button1.setLayout(new GridLayout(0, 3));
    button1.setBorder(new TitledBorder("Chart"));

    JButton button2 = new JButton("Continue");
    button2.setLayout(new GridLayout(0, 3));
    button2.setBorder(new TitledBorder("Next Round"));



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
      progress.setStringPainted(true);
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
        chartView(shareList);
      }
    };

    button1.addActionListener(action);


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


  public Double allocForShare(int shareNumber, double r, List<Share> shares, int x, int max) {
    int m = max;
    double meanPrice = 0;
    for(int i=0; i< shares.size(); i++){
      meanPrice = meanPrice + shares.get(i).getPrice();
    }
    meanPrice = meanPrice/shares.size();

    Double mXBar = getMbar(meanPrice, shares.size(), x);
    if (m < mXBar) {
      return allocationMethodOne(shares, m, meanPrice);
    }
    double nR = getArgMax(r, shares);
    if (shareNumber <= nR) {
      return allocationMethodTwo(r, shares, x, m, meanPrice, mXBar);
    } else
      return allocationMethodThree(shareNumber, shares, x, m, meanPrice, mXBar);
  }

  public Double getArgMax(double r, List<Share> securities){
    double argMax = 0;
    int p1 = securities.get(0).getPrice();
    double pi = 0;
    double ratio = 0;
    for(int i = 0; i < securities.size(); i++){
      pi = securities.get(i).getPrice();
      ratio = pi/p1;
      if(ratio > r){
        break;
      }
      argMax = (securities.get(i).getSecurityNumber());
    }
    return argMax;
  }

  public Double allocationMethodOne(List<Share> shares, int maxMoney, double meanPrice) {
    int m = maxMoney;
    Double p = meanPrice;
    int n = shares.size();
    System.out.println("allocationmethod one = " + m/ (n*p));
    return m / (n * p);
  }


  public Double allocationMethodTwo(double r, List<Share> shares, int x, int maxMoney, double meanPrice, double mbar) {
    int m = maxMoney;
    double p = meanPrice;
    double mXBar = mbar;
    double aR = getA(r, shares);
    double pR = getP(r, shares);
    System.out.println("allocationmethod two = " + "x Bar = " + "aR = " + aR + "m = " + m + "mxBar = " + mXBar+ "pR = "  +  pR);
    System.out.println("allocationmethod two = " + ((aR * (m - mXBar)) / pR));
    return x + ((aR * (m - mXBar)) / pR);
  }

  public Double allocationMethodThree(int shareNumber, List<Share> shares, int x, int maxMoney, double meanPrice, double mbar) {
    System.out.println("shareNumber = " + shareNumber);
    int m = maxMoney;
    double p = meanPrice;
    Double mXBar = mbar;
    Double aI = (shares.get(shareNumber - 1).getIncomeShare()) / 100;
    int pI = shares.get(shareNumber - 1).getPrice();

    System.out.println(x + ((aI * (m - mXBar)) / pI));


    return x + ((aI * (m - mXBar)) / pI);


  }
  public Double getA(double r, List<Share> shares){
    double nR = getArgMax(r, shares);
    double sum = 0;
    for(int i=1; i < nR+1; i++){
      sum = sum + shares.get(i - 1).getIncomeShare();
    }
    double mult = (1/nR);
    return (mult * sum) / 100;
  }

  //this calculates p(r)
  public Double getP(double r, List<Share> shares){
    double nR = getArgMax(r, shares);
    double sum = 0;
    for(int i=1; i < nR+1; i++){
      sum = sum + shares.get(i-1).getPrice();
    }
    return ((1/nR)* sum);
  }


  public Double getMbar (double pBar, int n, int x){
    return ((n*pBar)*x);

  }












}
