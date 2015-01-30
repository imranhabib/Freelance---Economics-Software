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
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;


/**
 * Created by Imran on 2014-12-15.
 */
public class phase2Real extends JFrame {

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
  private static ActionListener actionListener12;



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
  private String newtab = "\t\t";

  static String prices;
  static String choices;

  static double tempR;
  static double r;
  static int minShare;

  allocation alloc;
  parameters param;
  incomeRequired income;
  static int maxMoney;

  double[] incomeShares;

  static List<List<Share>> passingToStage3;



  static int maxMoney1;
  static int maxMoney2;
  static int maxMoney3;
  static int maxMoney4;
  static int maxMoney5;
  static int maxMoney6;
  static int maxMoney7;
  static int maxMoney8;
  static int maxMoney9;
  static int maxMoney10;




  String filename = "binarychoices-output.csv";
  String directory;
  File file;
  FileWriter filer;
  FileWriter filer2;
  FileWriter filer3;
  FileWriter filer4;
  FileWriter filer5;
  FileWriter filer6;
  FileWriter filer7;
  FileWriter filer8;
  FileWriter filer9;
  FileWriter filer10;



  public phase2Real (double[] incomes, double ratio, int m) {

    param = new parameters();
    alloc = new allocation(param, new incomeRequired(2));
    incomeShares = incomes;

    directoryStore dirStore = new directoryStore();
    directory = dirStore.getDirectory();



    r = ratio;
    tempR = ratio;
    minShare = m;

    String data = Double.toString(tempR);
    String splitter = data.substring(data.indexOf("."));
    if(splitter.length() > 2){
      splitter = splitter.substring(0, 3);
    }
    data = data.substring(0, data.indexOf(".")) + splitter;


    maxMoney1 = Integer.parseInt(ResourceBundle.getBundle("resources/systemdata").getString("maxMoney1"));
    maxMoney2 = Integer.parseInt(ResourceBundle.getBundle("resources/systemdata").getString("maxMoney2"));
    maxMoney3 = Integer.parseInt(ResourceBundle.getBundle("resources/systemdata").getString("maxMoney3"));
    maxMoney4 = Integer.parseInt(ResourceBundle.getBundle("resources/systemdata").getString("maxMoney4"));
    maxMoney5 = Integer.parseInt(ResourceBundle.getBundle("resources/systemdata").getString("maxMoney5"));
    maxMoney6 = Integer.parseInt(ResourceBundle.getBundle("resources/systemdata").getString("maxMoney6"));
    maxMoney7 = Integer.parseInt(ResourceBundle.getBundle("resources/systemdata").getString("maxMoney7"));
    maxMoney8 = Integer.parseInt(ResourceBundle.getBundle("resources/systemdata").getString("maxMoney8"));
    maxMoney9 = Integer.parseInt(ResourceBundle.getBundle("resources/systemdata").getString("maxMoney9"));
    maxMoney10 = Integer.parseInt(ResourceBundle.getBundle("resources/systemdata").getString("maxMoney10"));





    passingToStage3 = new ArrayList<List<Share>>();

    String pric = (ResourceBundle.getBundle("resources/systemdata").getString("priceSet" + Integer.toString(1)));
    String[] price = pric.split(",");

    prices = "Prices used for allocation 1: " + (ResourceBundle.getBundle("resources/systemdata").getString("priceSet" + Integer.toString(1)))  + newtab + "Income amount used for round 1: "
        + (ResourceBundle.getBundle("resources/systemdata").getString("incomeHave" + Integer.toString(1)))  + newline
        +  "Prices used for allocation 2: " +(ResourceBundle.getBundle("resources/systemdata").getString("priceSet" + Integer.toString(2)))  + newtab + "Income amount used for round 2: "
        + (ResourceBundle.getBundle("resources/systemdata").getString("incomeHave" + Integer.toString(2))) + newline
        +  "Prices used for allocation 3: " +(ResourceBundle.getBundle("resources/systemdata").getString("priceSet" + Integer.toString(3)))  + newtab + "Income amount used for round 3: "
        + (ResourceBundle.getBundle("resources/systemdata").getString("incomeHave" + Integer.toString(3))) + newline
        +  "Prices used for allocation 4: " +(ResourceBundle.getBundle("resources/systemdata").getString("priceSet" + Integer.toString(4)))  + newtab + "Income amount used for round 4: "
        + (ResourceBundle.getBundle("resources/systemdata").getString("incomeHave" + Integer.toString(4))) + newline
        + "Prices used for allocation 5: " +(ResourceBundle.getBundle("resources/systemdata").getString("priceSet" + Integer.toString(5)))  + newtab + "Income amount used for round 5: "
        + (ResourceBundle.getBundle("resources/systemdata").getString("incomeHave" + Integer.toString(5))) + newline
        +"Prices used for allocation 6: " +(ResourceBundle.getBundle("resources/systemdata").getString("priceSet" + Integer.toString(6)))  + newtab + "Income amount used for round 6: "
        + (ResourceBundle.getBundle("resources/systemdata").getString("incomeHave" + Integer.toString(6))) + newline
        + "Prices used for allocation 7: " +(ResourceBundle.getBundle("resources/systemdata").getString("priceSet" + Integer.toString(7)))  + newtab + "Income amount used for round 7: "
        + (ResourceBundle.getBundle("resources/systemdata").getString("incomeHave" + Integer.toString(7))) + newline
        + "Prices used for allocation 8: " +(ResourceBundle.getBundle("resources/systemdata").getString("priceSet" + Integer.toString(8)))  + newtab + "Income amount used for round 8: "
        + (ResourceBundle.getBundle("resources/systemdata").getString("incomeHave" + Integer.toString(8)))+ newline
        +"Prices used for allocation 9: " +(ResourceBundle.getBundle("resources/systemdata").getString("priceSet" + Integer.toString(9)))  + newtab + "Income amount used for round 9: "
        + (ResourceBundle.getBundle("resources/systemdata").getString("incomeHave" + Integer.toString(9))) + newline +
        "Prices used for allocation 10: " +(ResourceBundle.getBundle("resources/systemdata").getString("priceSet" + Integer.toString(10)))  + newtab + "Income amount used for round 10: "
        + (ResourceBundle.getBundle("resources/systemdata").getString("incomeHave" + Integer.toString(10))) + newline ;

    choices = "Income Share Allocation" + newline + "Security 1: " + incomes[0] + newline + "Security 2: " + incomes[1]
        + newline + "Security 3: " + incomes[2] + newline + "Security 4: " + incomes[3] + newline + "Security 5: " + incomes[4]
        + newline + newline + "Reservation Ratio: " + data + newline + "Minimum Share: " + m;



    setTitle("Stage 2 Choice Rule Data");
    setLayout(new BorderLayout());
    Dimension screenSize = new Dimension(600, 800);
    setBounds(0,0,1200,700);
    setLocationRelativeTo(null);


    raisedBorder = new SoftBevelBorder(SoftBevelBorder.RAISED);
    loweredBorder = new SoftBevelBorder(SoftBevelBorder.LOWERED);



    split = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
    split.setResizeWeight(.80);
    topPanel = new JPanel(new GridLayout(10, 2, 10 , 10));
    topPanel.setBorder(raisedBorder);


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

    button1.setFont(new Font("Calibri", Font.ROMAN_BASELINE, 15));
    button2.setFont(new Font("Calibri", Font.ROMAN_BASELINE, 15));
    button3.setFont(new Font("Calibri", Font.ROMAN_BASELINE, 15));
    button4.setFont(new Font("Calibri", Font.ROMAN_BASELINE, 15));
    button5.setFont(new Font("Calibri", Font.ROMAN_BASELINE, 15));
    button6.setFont(new Font("Calibri",Font.ROMAN_BASELINE, 15));
    button7.setFont(new Font("Calibri", Font.ROMAN_BASELINE, 15));
    button8.setFont(new Font("Calibri", Font.ROMAN_BASELINE,15));
    button9.setFont(new Font("Calibri", Font.ROMAN_BASELINE, 15));
    button10.setFont(new Font("Calibri", Font.ROMAN_BASELINE, 15));

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

    add(title, BorderLayout.NORTH);
    split.setTopComponent(topPanel);

    split2 = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
    split2.setResizeWeight(.50);

    bottomPanel = new JPanel(new BorderLayout());
    leftPanel = new JPanel(new BorderLayout());

    title7 = new JLabel("Your custom choice rule");
    leftPanel.add(title7, BorderLayout.NORTH);


    title6 = new JLabel("Price and income vectors the allocations above are based upon");
    bottomPanel.add(title6, BorderLayout.NORTH);

    text = new JTextArea(prices);
    text.setFont(new Font("Calibri",Font.ROMAN_BASELINE, 16));
    text.setLineWrap(true);
    text.setWrapStyleWord(true);

    text2 = new JTextArea(choices);
    text2.setFont(new Font("Calibri", Font.ROMAN_BASELINE, 16));
    text2.setLineWrap(true);
    text2.setWrapStyleWord(true);

    bottomPanel.add(text, BorderLayout.CENTER);
    leftPanel.add(text2, BorderLayout.CENTER);


    button11 = new JButton();
    button11.setEnabled(false);
    button12= new JButton("Proceed to Stage 3");

    buttonPanel = new JPanel(new GridLayout(1, 0, 5, 5));
    buttonPanel.add(button11);
    buttonPanel.add(button12);

    actionListener1 = new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        String price = (ResourceBundle.getBundle("resources/systemdata").getString("priceSet1"));
        String[] prices = price.split(",");

        ArrayList<Share> shares = convertPriceSets(prices, r, minShare, incomeShares, maxMoney1);
        //make it pop up the allocation page
        allocationPage(shares, r, minShare);

      }
    };

    actionListener2 = new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        String price = (ResourceBundle.getBundle("resources/systemdata").getString("priceSet2"));
        String[] prices = price.split(",");

        ArrayList<Share> shares = convertPriceSets(prices, r, minShare, incomeShares, maxMoney2);
        //make it pop up the allocation page
        allocationPage(shares, r, minShare);

      }
    };

    actionListener3 = new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        String price = (ResourceBundle.getBundle("resources/systemdata").getString("priceSet3"));
        String[] prices = price.split(",");

        ArrayList<Share> shares = convertPriceSets(prices, r, minShare, incomeShares, maxMoney3);
        //make it pop up the allocation page
        allocationPage(shares, r, minShare);

      }
    };

    actionListener4 = new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        String price = (ResourceBundle.getBundle("resources/systemdata").getString("priceSet4"));
        String[] prices = price.split(",");

        ArrayList<Share> shares = convertPriceSets(prices, r, minShare, incomeShares, maxMoney4);
        //make it pop up the allocation page
        allocationPage(shares, r, minShare);

      }
    };

    actionListener5 = new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        String price = (ResourceBundle.getBundle("resources/systemdata").getString("priceSet5"));
        String[] prices = price.split(",");
        ArrayList<Share> shares = convertPriceSets(prices, r, minShare, incomeShares, maxMoney5);
        //make it pop up the allocation page
        allocationPage(shares, r, minShare);

      }
    };

    actionListener6 = new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        String price = (ResourceBundle.getBundle("resources/systemdata").getString("priceSet6"));
        String[] prices = price.split(",");
        ArrayList<Share> shares = convertPriceSets(prices, r, minShare, incomeShares, maxMoney6);
        //make it pop up the allocation page
        allocationPage(shares, r, minShare);

      }
    };

    actionListener7 = new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        String price = (ResourceBundle.getBundle("resources/systemdata").getString("priceSet7"));
        String[] prices = price.split(",");
        ArrayList<Share> shares = convertPriceSets(prices, r, minShare, incomeShares, maxMoney7);
        //make it pop up the allocation page
        allocationPage(shares, r, minShare);

      }
    };

    actionListener8 = new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        String price = (ResourceBundle.getBundle("resources/systemdata").getString("priceSet8"));
        String[] prices = price.split(",");
        ArrayList<Share> shares = convertPriceSets(prices, r, minShare, incomeShares, maxMoney8);
        //make it pop up the allocation page
        allocationPage(shares, r, minShare);

      }
    };

    actionListener9 = new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        String price = (ResourceBundle.getBundle("resources/systemdata").getString("priceSet9"));
        String[] prices = price.split(",");
        ArrayList<Share> shares = convertPriceSets(prices, r, minShare, incomeShares, maxMoney9);
        //make it pop up the allocation page
        allocationPage(shares, r, minShare);

      }
    };

    actionListener10 = new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        String price = (ResourceBundle.getBundle("resources/systemdata").getString("priceSet10"));
        String[] prices = price.split(",");
        ArrayList<Share> shares = convertPriceSets(prices, r, minShare, incomeShares, maxMoney10);
        //make it pop up the allocation page
        allocationPage(shares, r, minShare);

      }
    };

    actionListener12 = new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        //add pop up window here
      }
    };

    button11.addActionListener(actionListener12);

    file = new File(directory, filename);
    actionListener11 = new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        String price = (ResourceBundle.getBundle("resources/systemdata").getString("priceSet1"));
        String[] prices = price.split(",");
        List<Share> temp = convertPriceSets(prices, r, minShare, incomeShares, maxMoney1);
        passingToStage3.add(temp);

        if (!file.exists()) {
          file = new File(directory, filename);
          fileCreator(file);
        }

        filer = createFileWriter(file);
        formatFile(filer, 1);
        for (Share shr : temp) {
          writeToFile(filer, shr);

        }
        closeFile(filer);



        String price2 = (ResourceBundle.getBundle("resources/systemdata").getString("priceSet2"));
        String[] prices2 = price2.split(",");
        List<Share> temp2 = convertPriceSets(prices2, r, minShare, incomeShares, maxMoney2);
        passingToStage3.add(temp2);


        if (!file.exists()) {
          file = new File(directory, filename);
          fileCreator(file);
        }

        filer2 = createFileWriter(file);
        formatFile(filer2, 2);
        for (Share shr : temp2) {
          writeToFile(filer2, shr);

        }
        closeFile(filer2);


        String price3 = (ResourceBundle.getBundle("resources/systemdata").getString("priceSet3"));
        String[] prices3 = price3.split(",");
        List<Share> temp3 = convertPriceSets(prices3, r, minShare, incomeShares, maxMoney3);
        passingToStage3.add(temp);




        if (!file.exists()) {
          file = new File(directory, filename);
          fileCreator(file);
        }

        filer3 = createFileWriter(file);
        formatFile(filer3, 3);
        for (Share shr : temp3) {
          writeToFile(filer3, shr);

        }
        closeFile(filer3);









        String price4 = (ResourceBundle.getBundle("resources/systemdata").getString("priceSet4"));
        String[] prices4 = price4.split(",");
        List<Share> temp4 = convertPriceSets(prices4, r, minShare, incomeShares, maxMoney4);
        passingToStage3.add(temp4);







        if (!file.exists()) {
          file = new File(directory, filename);
          fileCreator(file);
        }

        filer4 = createFileWriter(file);
        formatFile(filer4, 4);
        for (Share shr : temp4) {
          writeToFile(filer4, shr);

        }
        closeFile(filer4);




        String price5 = (ResourceBundle.getBundle("resources/systemdata").getString("priceSet5"));
        String[] prices5 = price5.split(",");
        List<Share> temp5 = convertPriceSets(prices5, r, minShare, incomeShares, maxMoney5);
        passingToStage3.add(temp5);



        if (!file.exists()) {
          file = new File(directory, filename);
          fileCreator(file);
        }

        filer5 = createFileWriter(file);
        formatFile(filer5, 5);
        for (Share shr : temp5) {
          writeToFile(filer5, shr);

        }
        closeFile(filer5);




        String price6 = (ResourceBundle.getBundle("resources/systemdata").getString("priceSet6"));
        String[] prices6 = price6.split(",");
        List<Share> temp6 = convertPriceSets(prices6, r, minShare, incomeShares, maxMoney6);
        passingToStage3.add(temp6);



        if (!file.exists()) {
          file = new File(directory, filename);
          fileCreator(file);
        }

        filer6 = createFileWriter(file);
        formatFile(filer6, 6);
        for (Share shr : temp6) {
          writeToFile(filer6, shr);

        }
        closeFile(filer6);



        String price7 = (ResourceBundle.getBundle("resources/systemdata").getString("priceSet7"));
        String[] prices7 = price7.split(",");
        List<Share> temp7 = convertPriceSets(prices7, r, minShare, incomeShares, maxMoney7);
        passingToStage3.add(temp7);




        if (!file.exists()) {
          file = new File(directory, filename);
          fileCreator(file);
        }

        filer7 = createFileWriter(file);
        formatFile(filer7, 7);
        for (Share shr : temp7) {
          writeToFile(filer7, shr);

        }
        closeFile(filer7);




        String price8 = (ResourceBundle.getBundle("resources/systemdata").getString("priceSet8"));
        String[] prices8 = price8.split(",");
        List<Share> temp8 = convertPriceSets(prices8, r, minShare, incomeShares, maxMoney7);
        passingToStage3.add(temp8);



        if (!file.exists()) {
          file = new File(directory, filename);
          fileCreator(file);
        }

        filer8 = createFileWriter(file);
        formatFile(filer8, 8);
        for (Share shr : temp8) {
          writeToFile(filer8, shr);

        }
        closeFile(filer8);




        String price9 = (ResourceBundle.getBundle("resources/systemdata").getString("priceSet9"));
        String[] prices9 = price9.split(",");
        List<Share> temp9 = convertPriceSets(prices9, r, minShare, incomeShares, maxMoney9);
        passingToStage3.add(temp9);


        if (!file.exists()) {
          file = new File(directory, filename);
          fileCreator(file);
        }

        filer9 = createFileWriter(file);
        formatFile(filer9, 9);
        for (Share shr : temp9) {
          writeToFile(filer9, shr);

        }
        closeFile(filer9);



        String price10 = (ResourceBundle.getBundle("resources/systemdata").getString("priceSet10"));
        String[] prices10 = price10.split(",");
        List<Share> temp10 = convertPriceSets(prices10, r, minShare, incomeShares, maxMoney10);
        passingToStage3.add(temp10);

        if (!file.exists()) {
          file = new File(directory, filename);
          fileCreator(file);
        }

        filer10 = createFileWriter(file);
        formatFile(filer10, 10);
        for (Share shr : temp10) {
          writeToFile(filer10, shr);

        }
        closeFile(filer10);

        phase3 phases = new phase3(passingToStage3, minShare, r, incomeShares);
        phases.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        phases.setVisible(true);


        setVisible(false);
        dispose();
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

    button12.addActionListener(actionListener11);





    split2.setRightComponent(bottomPanel);
    split2.setLeftComponent(leftPanel);
    split.setBottomComponent(split2);

    add(buttonPanel, BorderLayout.SOUTH);
    add(split);
    setVisible(true);











  }

  public ArrayList<Share> convertPriceSets(String[] prices, double r, int minShare, double[] incomes, int max){
    int maxMoney = max;
    ArrayList<Share> shareLister = new ArrayList<Share>();
    for(int i=0; i< prices.length; i++){
      int temp = Integer.parseInt(prices[i]);
      shareLister.add(new Share(temp,incomes[i],i+1));
    }

    if (shareLister.size() == 1) {
      for (int i = 0; i < shareLister.size(); i++) {
        double allocationVal = allocForShare(i + 1, r, shareLister, minShare, maxMoney);
        Share share = new Share(shareLister.get(i).getPrice(), shareLister.get(i).getIncomeShare(), shareLister.get(i).getSecurityNumber(), allocationVal);
        shareLister.remove(i);
        shareLister.add(i, share);

      }

    }


    if (shareLister.size() == 2) {
      for (int i = 0; i < shareLister.size(); i++) {
        double allocationVal = allocForShare(i + 1, r, shareLister, minShare, maxMoney);
        Share share = new Share(shareLister.get(i).getPrice(), shareLister.get(i).getIncomeShare(), shareLister.get(i).getSecurityNumber(), allocationVal);
        shareLister.remove(i);
        shareLister.add(i, share);

      }

    }

    if (shareLister.size() == 3) {
      for (int i = 0; i < shareLister.size(); i++) {
        double allocationVal = allocForShare(i + 1, r, shareLister, minShare, maxMoney);
        Share share = new Share(shareLister.get(i).getPrice(), shareLister.get(i).getIncomeShare(), shareLister.get(i).getSecurityNumber(), allocationVal);
        shareLister.remove(i);
        shareLister.add(i, share);
      }

    }

    if (shareLister.size() == 4) {
      for (int i = 0; i < shareLister.size(); i++) {
        double allocationVal = allocForShare(i + 1, r, shareLister, minShare, maxMoney);
        Share share = new Share(shareLister.get(i).getPrice(), shareLister.get(i).getIncomeShare(), shareLister.get(i).getSecurityNumber(), allocationVal);
        shareLister.remove(i);
        shareLister.add(i, share);
      }

    }

    if (shareLister.size() == 5) {
      for (int i = 0; i < shareLister.size(); i++) {
        double allocationVal = allocForShare(i + 1, r, shareLister, minShare, maxMoney);
        Share share = new Share(shareLister.get(i).getPrice(), shareLister.get(i).getIncomeShare(), shareLister.get(i).getSecurityNumber(), allocationVal);
        shareLister.remove(i);
        shareLister.add(i, share);
      }

    }
    return shareLister;
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
      String data = Double.toString(shareList.get(i).getAllocation());
      String splitter = data.substring(data.indexOf("."));
      if(splitter.length() > 2){
        splitter = splitter.substring(0, 3);
      }
      data = data.substring(0, data.indexOf(".")) + splitter;
      JTextField jText = new JTextField(data);
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



  public void fileCreator(File file) {
    try {
      if (file.createNewFile()) {
        System.out.println("check your desktop thats where dat file be");
      } else {
        System.out.println("you already have this file playa");
      }
    } catch (IOException e) {
      e.printStackTrace();
    }


  }


  public FileWriter createFileWriter(File file) {
    try {
      FileWriter fileWrite = new FileWriter(file, true);
      //    System.out.println("here so this is good");
      return fileWrite;
    } catch (IOException e) {
      // System.out.println("here so were screwed");
      return null;
    }


  }


  public void formatFile(FileWriter filer,int count) {

    try {
      filer.write("\n\n" + "Stage 2 Real Rounds" + "\n\n" + "Round " + count);
    } catch (IOException e) {
      System.out.println("new file code failed");
    }


  }



  public void writeToFile(FileWriter filer, Share share) {
    try {
      filer.write("\n"+ "Reservation Ratio = " + r + " Minimum Share = " + minShare + " Security number = " + share.getSecurityNumber() + " Security price = " + share.getPrice() + " Security Income Share = " + share.getIncomeShare() +
          " Security Allocation = " + share.getAllocation());

    } catch (IOException e) {
      System.out.println("failed hurr");
    }

  }






  public void closeFile(FileWriter filer){
    try {
      filer.flush();
      filer.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
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
