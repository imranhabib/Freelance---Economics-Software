package project;


import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import test.testClass;

import javax.swing.*;
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
 * Created by Imran on 2014-12-13.
 */
public class phase2TestRounds extends JFrame{



  static JSlider slider;
  static JPanel panel;
  static JPanel panel2;
  static JLabel label;
  static JPanel panel3;
  static JPanel panel4;
  static JPanel panel5;
  static JPanel panel6;
  static JPanel panel7;
  static JPanel panel8;
  static JButton button1;
  static JTextField remainingAlloc;


  static testClass test;

  private static List<JSlider> sliders;

  private static JTextField textField;
  private static JTextField textField2;
  private static JTextField textField3;
  private static JTextField textField4;
  private static JTextField textField5;

  private static JTextField textField6;
  private static JTextField textField7;
  private static JTextField textField8;

  private static JTextField textFieldjSpinner;
  private static JTextField textFieldjSpinner2;


  private static ActionListener action;


  private final Color blue = Color.BLUE;
  private final Color red = Color.RED;

  private static boolean check;
  private static boolean check2;
  private static boolean check3;
  private static boolean check4;
  private static boolean check5;
  private static boolean check6;

  private int v1;
  private int v2;
  private int v3;
  private int v4;
  private int v5;

  static int curSysProp;
  static storageClass store;

  static int total;

  static int allocation = 0;

  static JSlider s1;
  static int s1Price;
  static JSlider s2;
  static int s2Price;
  static JSlider s3;
  static int s3Price;
  static JSlider s4;
  static int s4Price;
  static JSlider s5;
  static int s5Price;


  static boolean checkNew;
  static boolean checkNew2;
  static boolean checkNew3;
  static boolean checkNew4;
  static boolean checkNew5;



  //file stuffz


  String directory;
  String adminDirectory;

  String filename = "output.csv";
  String filename1 = "priceSet1.csv";
  String filename2 = "priceSet2.csv";
  String filename3 = "priceSet3.csv";
  String filename4 = "priceSet4.csv";




  String filenameRewind1 = "priceSetRewind1.csv";
  String filenameRewind2 = "priceSetRewind2.csv";
  String filenameRewind3 = "priceSetRewind3.csv";
  String filenameRewind4 = "priceSetRewind4.csv";
  String filenameRewind5 = "priceSetRewind5.csv";

  String secondfilenameRewind1 = "secondpriceSetRewind1.csv";
  String secondfilenameRewind2 = "secondpriceSetRewind2.csv";
  String secondfilenameRewind3 =  "secondpriceSetRewind3.csv";
  String secondfilenameRewind4 = "secondpriceSetRewind4.csv";

  String thirdfilenameRewind1 = "thirdpriceSetRewind1.csv";
  String thirdfilenameRewind2 =  "thirdpriceSetRewind2.csv";
  String thirdfilenameRewind3 =  "thirdpriceSetRewind3.csv";
  String thirdfilenameRewind4 = "thirdpriceSetRewind4.csv";

  String forthfilenameRewind1 = "forthpriceSetRewind1.csv";
  String forthfilenameRewind2 =  "forthpriceSetRewind2.csv";
  String forthfilenameRewind3 = "forthpriceSetRewind3.csv";
  String forthfilenameRewind4 = "forthpriceSetRewind4.csv";


  File file;
  File file1;
  File file2;
  File file3;
  File file4;

  FileWriter filer;
  FileWriter filer1;
  FileWriter filer2;
  FileWriter filer3;
  FileWriter filer4;



  File fileRewind1;
  File fileRewind2;
  File fileRewind3;
  File fileRewind4;


  File secondfileRewind1;
  File secondfileRewind2;
  File secondfileRewind3;
  File secondfileRewind4;


  File thirdfileRewind1;
  File thirdfileRewind2;
  File thirdfileRewind3;
  File thirdfileRewind4;

  File forthfileRewind1;
  File forthfileRewind2;
  File forthfileRewind3;
  File forthfileRewind4;



  FileWriter filerRewind1;
  FileWriter filerRewind2;
  FileWriter filerRewind3;
  FileWriter filerRewind4;


  FileWriter secondfilerRewind1;
  FileWriter secondfilerRewind2;
  FileWriter secondfilerRewind3;
  FileWriter secondfilerRewind4;


  FileWriter thirdfilerRewind1;
  FileWriter thirdfilerRewind2;
  FileWriter thirdfilerRewind3;
  FileWriter thirdfilerRewind4;


  FileWriter forthfilerRewind1;
  FileWriter forthfilerRewind2;
  FileWriter forthfilerRewind3;
  FileWriter forthfilerRewind4;






  //backend stuffz


  allocation alloc;
  parameters param;
  incomeRequired income;

  static Integer value;
  static Double value2;
  static Double pBar;
  static Double mBar;
  static Double r;
  private static Double rForExcel;
  static Double nOfr;
  static int minimumShare;

  private static int n;



  //this list of lists holds all the allocation data
  static List<List<Share>> listOfAllocations;


  static  List<Share> shareList;


  public phase2TestRounds(final List<Share> shares, int cur, final int minShare, final double r, storageClass storage, final boolean rewind, final boolean rewind2, final boolean rewind3, final boolean rewind4)  {

    System.out.println("Counting times im in here");
    curSysProp = cur;

    test = new testClass();


    rForExcel = r;

    minimumShare = minShare;


    directoryStore dirStore = new directoryStore();
    directory = dirStore.getDirectory();
    adminDirectory = dirStore.getAdminDirectory();
    System.out.println("THIS IS DIR AND ADMIN DIR: " + directory + " " + adminDirectory);

    store = storage;


    if(!rewind) {
      if (test.getCurrent() == 2) {

        store.setListers(shares);
        file1 = new File(adminDirectory, filename1);
        fileCreator(file1);

        if (!file1.exists()) {
          file1 = new File(adminDirectory, filename1);
          fileCreator(file1);
        }

        filer1 = createFileWriter(file1);

        for (Share share : store.getSharesListers1()) {
          writeToFile2(filer1, share);
        }
        closeFile(filer1);


      } else if (test.getCurrent() == 3) {
        store.setListers2(shares);

        file2 = new File(adminDirectory, filename2);
        fileCreator(file2);

        if (!file2.exists()) {
          file2 = new File(adminDirectory, filename2);
          fileCreator(file2);
        }

        filer2 = createFileWriter(file2);

        for (Share share : store.getSharesListers2()) {
          writeToFile2(filer2, share);
        }
        closeFile(filer2);


      } else if (test.getCurrent() == 4) {
        store.setListers3(shares);


        file3 = new File(adminDirectory, filename3);
        fileCreator(file3);

        if (!file3.exists()) {
          file3 = new File(adminDirectory, filename3);
          fileCreator(file2);
        }

        filer3 = createFileWriter(file3);

        for (Share share : store.getSharesListers3()) {
          writeToFile2(filer3, share);
        }
        closeFile(filer3);


      } else {
        store.setListers4(shares);
        checkNew = true;


        file4 = new File(adminDirectory, filename4);
        fileCreator(file4);

        if (!file4.exists()) {
          file4 = new File(adminDirectory, filename4);
          fileCreator(file4);
        }

        filer4 = createFileWriter(file4);

        for (Share share : store.getSharesListers4()) {
          writeToFile2(filer4, share);
        }
        closeFile(filer4);

      }
    } else if(rewind) {
      if (test.getCurrent() == 2) {

        store.setListers(shares);
        fileRewind1 = new File(adminDirectory, filenameRewind1);
        fileCreator(fileRewind1);

        if (!fileRewind1.exists()) {
          fileRewind1 = new File(adminDirectory, filenameRewind1);
          fileCreator(fileRewind1);
        }

        filerRewind1 = createFileWriter(fileRewind1);

        for (Share share : store.getSharesListers1()) {
          writeToFile2(filerRewind1, share);
        }
        closeFile(filerRewind1);


      } else if (test.getCurrent() == 3) {
        store.setListers2(shares);

        fileRewind2 = new File(adminDirectory, filenameRewind2);
        fileCreator(fileRewind2);

        if (!fileRewind2.exists()) {
          fileRewind2 = new File(adminDirectory, filenameRewind2);
          fileCreator(fileRewind2);
        }

        filerRewind2 = createFileWriter(fileRewind2);

        for (Share share : store.getSharesListers2()) {
          writeToFile2(filerRewind2, share);
        }
        closeFile(filerRewind2);


      } else if (test.getCurrent() == 4) {
        store.setListers3(shares);


        fileRewind3 = new File(adminDirectory, filenameRewind3);
        fileCreator(fileRewind3);

        if (!fileRewind3.exists()) {
          fileRewind3 = new File(adminDirectory, filenameRewind3);
          fileCreator(fileRewind3);
        }

        filerRewind3 = createFileWriter(fileRewind3);

        for (Share share : store.getSharesListers3()) {
          writeToFile2(filerRewind3, share);
        }
        closeFile(filerRewind3);


      } else {
        store.setListers4(shares);
        checkNew2 = true;


        fileRewind4 = new File(adminDirectory, filenameRewind4);
        fileCreator(fileRewind4);

        if (!fileRewind4.exists()) {
          fileRewind4 = new File(adminDirectory, filenameRewind4);
          fileCreator(fileRewind4);
        }

        filerRewind4 = createFileWriter(fileRewind4);

        for (Share share : store.getSharesListers4()) {
          writeToFile2(filerRewind4, share);
        }
        closeFile(filerRewind4);
      }
    }  if(rewind2) {
      if (test.getCurrent() == 2) {

        store.setListers(shares);
        secondfileRewind1 = new File(adminDirectory, secondfilenameRewind1);
        fileCreator(secondfileRewind1);

        if (!fileRewind1.exists()) {
          secondfileRewind1 = new File(adminDirectory, secondfilenameRewind1);
          fileCreator(secondfileRewind1);
        }

        secondfilerRewind1 = createFileWriter(secondfileRewind1);

        for (Share share : store.getSharesListers1()) {
          writeToFile2(secondfilerRewind1, share);
        }
        closeFile(secondfilerRewind1);


      } else if (test.getCurrent() == 3) {
        store.setListers2(shares);

        secondfileRewind2 = new File(adminDirectory, secondfilenameRewind2);
        fileCreator(fileRewind2);

        if (!secondfileRewind2.exists()) {
          secondfileRewind2 = new File(adminDirectory, secondfilenameRewind2);
          fileCreator(secondfileRewind2);
        }

        secondfilerRewind2 = createFileWriter(secondfileRewind2);

        for (Share share : store.getSharesListers2()) {
          writeToFile2(secondfilerRewind2, share);
        }
        closeFile(secondfilerRewind2);


      } else if (test.getCurrent() == 4) {
        store.setListers3(shares);


        secondfileRewind3 = new File(adminDirectory, secondfilenameRewind3);
        fileCreator(secondfileRewind3);

        if (!secondfileRewind3.exists()) {
          secondfileRewind3 = new File(adminDirectory, secondfilenameRewind3);
          fileCreator(secondfileRewind3);
        }

        secondfilerRewind3 = createFileWriter(secondfileRewind3);

        for (Share share : store.getSharesListers3()) {
          writeToFile2(secondfilerRewind3, share);
        }
        closeFile(secondfilerRewind3);


      } else {
        store.setListers4(shares);
        checkNew3 = true;


        secondfileRewind4 = new File(adminDirectory, secondfilenameRewind4);
        fileCreator(secondfileRewind4);

        if (!secondfileRewind4.exists()) {
          secondfileRewind4 = new File(adminDirectory, secondfilenameRewind4);
          fileCreator(secondfileRewind4);
        }

        secondfilerRewind4 = createFileWriter(secondfileRewind4);

        for (Share share : store.getSharesListers4()) {
          writeToFile2(secondfilerRewind4, share);
        }
        closeFile(secondfilerRewind4);
      }
    }  if(rewind3) {
      if (test.getCurrent() == 2) {

        store.setListers(shares);
        thirdfileRewind1 = new File(adminDirectory,  thirdfilenameRewind1);
        fileCreator(thirdfileRewind1);

        if (!thirdfileRewind1.exists()) {
          thirdfileRewind1 = new File(adminDirectory, thirdfilenameRewind1);
          fileCreator(thirdfileRewind1);
        }

        thirdfilerRewind1 = createFileWriter(thirdfileRewind1);

        for (Share share : store.getSharesListers1()) {
          writeToFile2(thirdfilerRewind1, share);
        }
        closeFile(thirdfilerRewind1);


      } else if (test.getCurrent() == 3) {
        store.setListers2(shares);

        thirdfileRewind2 = new File(adminDirectory, thirdfilenameRewind2);
        fileCreator(thirdfileRewind2);

        if (!thirdfileRewind2.exists()) {
          thirdfileRewind2 = new File(adminDirectory, thirdfilenameRewind2);
          fileCreator(thirdfileRewind2);
        }

        thirdfilerRewind2 = createFileWriter(thirdfileRewind2);

        for (Share share : store.getSharesListers2()) {
          writeToFile2(thirdfilerRewind2, share);
        }
        closeFile(thirdfilerRewind2);


      } else if (test.getCurrent() == 4) {
        store.setListers3(shares);


        thirdfileRewind3 = new File(adminDirectory, thirdfilenameRewind3);
        fileCreator(thirdfileRewind3);

        if (!thirdfileRewind3.exists()) {
          thirdfileRewind3 = new File(adminDirectory, thirdfilenameRewind3);
          fileCreator(thirdfileRewind3);
        }

        thirdfilerRewind3 = createFileWriter(thirdfileRewind3);

        for (Share share : store.getSharesListers3()) {
          writeToFile2(thirdfilerRewind3, share);
        }
        closeFile(thirdfilerRewind3);


      } else {
        store.setListers4(shares);
        checkNew4 = true;


        thirdfileRewind4 = new File(adminDirectory, thirdfilenameRewind4);
        fileCreator(thirdfileRewind4);

        if (!thirdfileRewind4.exists()) {
          thirdfileRewind4 = new File(adminDirectory, thirdfilenameRewind4);
          fileCreator(thirdfileRewind4);
        }

        thirdfilerRewind4 = createFileWriter(thirdfileRewind4);

        for (Share share : store.getSharesListers4()) {
          writeToFile2(thirdfilerRewind4, share);
        }
        closeFile(thirdfilerRewind4);
      }
    } if (rewind4){
      if (test.getCurrent() == 2) {

        store.setListers(shares);
        forthfileRewind1 = new File(adminDirectory, forthfilenameRewind1);
        fileCreator(forthfileRewind1);

        if (!forthfileRewind1.exists()) {
          forthfileRewind1 = new File(adminDirectory, forthfilenameRewind1);
          fileCreator(forthfileRewind1);
        }

        forthfilerRewind1 = createFileWriter(forthfileRewind1);

        for (Share share : store.getSharesListers1()) {
          writeToFile2(forthfilerRewind1, share);
        }
        closeFile(forthfilerRewind1);


      } else if (test.getCurrent() == 3) {
        store.setListers2(shares);

        forthfileRewind2 = new File(adminDirectory, forthfilenameRewind2);
        fileCreator(forthfileRewind2);

        if (!forthfileRewind2.exists()) {
          forthfileRewind2 = new File(adminDirectory, forthfilenameRewind2);
          fileCreator(forthfileRewind2);
        }

        forthfilerRewind2 = createFileWriter(forthfileRewind2);

        for (Share share : store.getSharesListers2()) {
          writeToFile2(forthfilerRewind2, share);
        }
        closeFile(forthfilerRewind2);


      } else if (test.getCurrent() == 4) {
        store.setListers3(shares);


        forthfileRewind3 = new File(adminDirectory, forthfilenameRewind3);
        fileCreator(forthfileRewind3);

        if (!forthfileRewind3.exists()) {
          forthfileRewind3 = new File(adminDirectory, forthfilenameRewind3);
          fileCreator(forthfileRewind3);
        }

        forthfilerRewind3 = createFileWriter(forthfileRewind3);

        for (Share share : store.getSharesListers3()) {
          writeToFile2(forthfilerRewind3, share);
        }
        closeFile(forthfilerRewind3);


      } else {
        store.setListers4(shares);
        checkNew5 = true;


        forthfileRewind4 = new File(adminDirectory, forthfilenameRewind4);
        fileCreator(forthfileRewind4);

        if (!forthfileRewind4.exists()) {
          forthfileRewind4 = new File(adminDirectory, forthfilenameRewind4);
          fileCreator(forthfileRewind4);
        }

        forthfilerRewind4 = createFileWriter(forthfileRewind4);

        for (Share share : store.getSharesListers4()) {
          writeToFile2(forthfilerRewind4, share);
        }
        closeFile(forthfilerRewind4);
      }
    }


    setLayout(new BorderLayout());
    setTitle("Stage 2 Practice round " + test.getCurrent());
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    setBounds(0, 0, screenSize.width, screenSize.height - 45);

    total = Integer.parseInt(ResourceBundle.getBundle("resources/systemdata").getString("incomeHave" + test.getCurrent()));
    n = Integer.parseInt(ResourceBundle.getBundle("resources/systemdata").getString("securityAmount" + test.getCurrent()));

    int size = shares.size();
    panel2 = new JPanel();

    allocation = Integer.parseInt(ResourceBundle.getBundle("resources/systemdata").getString("incomeHave" + test.getCurrent()));

    panel2.setLayout(new BorderLayout(5, 10));

    panel = new JPanel();
    panel.setLayout(new GridLayout(0, shares.size()));
    panel.setPreferredSize(new Dimension(500, 500));
    panel.setBorder(new TitledBorder("Income Share %'s"));
    // label = new JLabel("Securities");
    // panel.add(label);

    panel3 = new JPanel();

    panel3.setLayout(new GridLayout(0, shares.size()));
    //panel3.setPreferredSize(new Dimension(50, 100));
    panel3.setBorder(new TitledBorder("Total"));

    textField = new JTextField();

    textField2 = new JTextField();

    textField3 = new JTextField();

    textField4 = new JTextField();

    textField5 = new JTextField();


    textField.setEditable(false);
    textField2.setEditable(false);
    textField3.setEditable(false);
    textField4.setEditable(false);
    textField5.setEditable(false);



    //backend stuffz


    param = new parameters();
    List<Integer> prices = param.getSecurityPriceList();
    alloc = new allocation(param, new incomeRequired(2));

    shareList = param.getSecurityListWithEmptyIncomeShares();


    shareList = shares;
    for(int i = 0; i < shareList.size(); i++){
      shareList.get(i).setPrice(prices.get(i));
    }



    textFieldjSpinner = new JTextField();
    textFieldjSpinner.setText(Double.toString(r));
    textFieldjSpinner.setEditable(false);
    textFieldjSpinner2 = new JTextField();
    textFieldjSpinner2.setEditable(false);
    textFieldjSpinner2.setText(Integer.toString(minimumShare));


    panel5 = new JPanel();

    panel5.setLayout(new GridLayout(0, shares.size()));
    panel5.setBorder(new TitledBorder("Reservation Ratio"));
    panel5.add(textFieldjSpinner);


    panel6 = new JPanel();
    panel6.setLayout(new GridLayout(0, 3));
    panel6.setBorder(new TitledBorder("Minimum Share"));
    panel6.add(textFieldjSpinner2);


    panel7 = new JPanel();
    panel7.setLayout(new GridLayout(0, shares.size()));
    panel7.setBorder(new TitledBorder("Data"));


    panel4 = new JPanel();
    panel4.setLayout(new GridLayout(0, 2));
    panel4.setBorder(new TitledBorder("Inputs"));
    panel4.add(panel6);
    panel4.add(panel5);


    if (size >= 1) {
      panel3.add(textField);
      textField.setText("Security #1 = " + shares.get(0).getIncomeShare());
    }
    if (size >= 2) {
      panel3.add(textField2);
      textField2.setText("Security #2 = " + shares.get(1).getIncomeShare());
    }
    if (size >= 3) {
      panel3.add(textField3);
      textField3.setText("Security #3 = " + shares.get(2).getIncomeShare());
    }
    if (size >= 4) {
      panel3.add(textField4);
      textField4.setText("Security #4 = " + shares.get(3).getIncomeShare());

    }
    if (size >= 5) {
      panel3.add(textField5);
      textField5.setText("Security #5 = " + shares.get(4).getIncomeShare());
    }


    JSplitPane splitPane = new JSplitPane(
        JSplitPane.VERTICAL_SPLIT
    );

    splitPane.setTopComponent(panel);
    splitPane.setBottomComponent(panel4);
    splitPane.setResizeWeight(.99);


    button1 = new JButton("Submit");
    button1.setToolTipText("Click to submit input selection");
    button1.setBorder(new TitledBorder("Move on"));


    sliders = new ArrayList<JSlider>();


    //you can change the first SOUTH -> NORTH && the first CENTER -> SOUTH to get a different spacing/sizing

    panel2.add(splitPane, BorderLayout.CENTER);
    panel2.add(panel3, BorderLayout.NORTH);
    panel2.add(button1, BorderLayout.SOUTH);
    add(panel2, BorderLayout.CENTER);


    check = true;
    check2 = false;
    check3 = false;
    check4 = false;
    check5 = false;
    check6 = false;


    //File stuffz

    file = new File(directory, filename);


    action = new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {


        int result = JOptionPane.showConfirmDialog(null,
            "Move to Allocation Data?", "Confirmation", JOptionPane.YES_NO_OPTION);

        if (result != 0) {
          return;
        }


        if (shareList.size() == 1) {
          for (int i = 0; i < shareList.size(); i++) {
            double allocationVal = alloc.allocationForShare(i + 1, r, shareList, minShare);
            Share share = new Share(shareList.get(i).getPrice(), shareList.get(i).getIncomeShare(), shareList.get(i).getSecurityNumber(), allocationVal);
            shareList.remove(i);
            shareList.add(i, share);

          }

        }


        if (shareList.size() == 2) {
          for (int i = 0; i < shareList.size(); i++) {
            double allocationVal = alloc.allocationForShare(i + 1, r, shareList, minShare);
            Share share = new Share(shareList.get(i).getPrice(), shareList.get(i).getIncomeShare(), shareList.get(i).getSecurityNumber(), allocationVal);
            shareList.remove(i);
            shareList.add(i, share);

          }

        }

        if (shareList.size() == 3) {
          for (int i = 0; i < shareList.size(); i++) {
            double allocationVal = alloc.allocationForShare(i + 1, r, shareList, minShare);
            Share share = new Share(shareList.get(i).getPrice(), shareList.get(i).getIncomeShare(), shareList.get(i).getSecurityNumber(), allocationVal);
            shareList.remove(i);
            shareList.add(i, share);

          }

        }

        if (shareList.size() == 4) {
          for (int i = 0; i < shareList.size(); i++) {
            double allocationVal = alloc.allocationForShare(i + 1, r, shareList, minShare);
            Share share = new Share(shareList.get(i).getPrice(), shareList.get(i).getIncomeShare(), shareList.get(i).getSecurityNumber(), allocationVal);
            shareList.remove(i);
            shareList.add(i, share);

          }

        }

        if (shareList.size() == 5) {
          for (int i = 0; i < shareList.size(); i++) {
            double allocationVal = alloc.allocationForShare(i + 1, r, shareList, minShare);
            Share share = new Share(shareList.get(i).getPrice(), shareList.get(i).getIncomeShare(), shareList.get(i).getSecurityNumber(), allocationVal);
            shareList.remove(i);
            shareList.add(i, share);

          }

        }


        if (!file.exists()) {
          file = new File(directory, filename);
          fileCreator(file);
        }
        if (check) {
          filer = createFileWriter(file);
          formatFile(filer);
          for (Share share : shareList) {
            writeToFile(filer, share);
          }
          closeFile(filer);

          allocationPage(shareList, r, minShare, listOfAllocations, rewind, rewind2, rewind3, rewind4);

          setVisible(false);
          dispose();

        } else {
          error(e);
        }

      }
    };


    button1.addActionListener(action);


    //create as many slider instances of the size of 'shares'
    //call the addSlider method with the correct param taken from the share object
    for (int i = 0; i < shares.size(); i++) {
      addShare(formatSlider(shares.get(i).getPrice(), shares.get(i).getIncomeShare(), shares.get(i).getSecurityNumber()), shares.get(i).getPrice());
    }


  }

  public void addShare(JSlider slider, int price) {
    JPanel pan = new JPanel();
    pan.add(slider);
    //pan.setToolTipText(Float.toString(incomeShare));
    pan.add(new JLabel("Price of security = " + price));

    panel.add(pan);

  }

  public JSlider formatSlider(int price, double incomeShare, int number) {
    JSlider slider = new JSlider(JSlider.VERTICAL);
    BoundedRangeModel model = slider.getModel();
    model.setRangeProperties(0,0,0,100,false);
    slider.setName(Integer.toString(number));
    slider.setPaintTicks(true);
    slider.setMajorTickSpacing(25);
    slider.setMinorTickSpacing(5);
    slider.setPreferredSize(new Dimension(100, 400));
    slider.setBorder(new TitledBorder("Security " + Integer.toString(number)));
    slider.setPaintLabels(true);
    slider.setEnabled(false);
    java.util.Hashtable<Integer, JLabel> labelTable = new java.util.Hashtable<Integer, JLabel>();
    labelTable.put(new Integer(100), new JLabel("1.0"));
    labelTable.put(new Integer(75), new JLabel("0.75"));
    labelTable.put(new Integer(50), new JLabel("0.50"));
    labelTable.put(new Integer(25), new JLabel("0.25"));
    labelTable.put(new Integer(0), new JLabel("0.0"));
    slider.setLabelTable(labelTable);
    String temp = Double.toString(incomeShare);
    temp = temp.substring(0,temp.indexOf("."));
    slider.setValue(Integer.parseInt(temp));


    //slider.add(new JLabel(Integer.toString(price)));
    return slider;

  }

  public int remainingIncome(int allocation, int value, int price) {
    float v = (float) value / 100;
    setTotal(allocation - v * price);
    return allocation - value * price;
  }


  public void setTotal(float remains) {
    float temp = Math.round(remains);
    int r = (int) temp;
    total = r;
  }

  public int getTotal() {
    return total;
  }


  public void error(ActionEvent e) {
    JOptionPane.showMessageDialog(null, "Please complete allocations", "Error", JOptionPane.ERROR_MESSAGE);
  }



  //make a file, make a directory to place the file
  //write the output to the file passed to it by the slider info

  public void fileCreator(File file) {
    try {
      if (file.createNewFile()) {
        System.out.println("check your desktop thats where dat file be");
      } else {
        System.out.println("you already have this file playa");
        return;
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



  public void formatFile(FileWriter filer) {
    test = new testClass(curSysProp);
    try {
      filer.write("\n\n" + "(Stage2 Test) Round " + test.getCurrent() + "\n");
    } catch (IOException e) {
      System.out.println("new file code failed");
    }


  }




  public void formatFile2(FileWriter filer) {
    test = new testClass(curSysProp);
    try {
      filer.write("\n" + "Round " + (test.getCurrent()-1) + "\n");
    } catch (IOException e) {
      System.out.println("new file code failed");
    }


  }


  public void writeToFile(FileWriter filer, Share share) {
    try {
      filer.write("\n" + "Reservation Ratio = " + rForExcel + " Minimum Share = " + minimumShare + " Security number = " + share.getSecurityNumber() + " Security price = " + share.getPrice() + " Security Income Share = " + share.getIncomeShare() +
          " Security Allocation = " + share.getAllocation());

    } catch (IOException e) {
      System.out.println("failed hurr");
    }

  }






  public void writeToFile2(FileWriter filer, Share share) {
    try {
      filer.write("\n" + "@" + "%" + share.getSecurityNumber() + "%" + "$" + share.getPrice() + "$" + "^" + share.getIncomeShare() + "^" +
          "#" + share.getAllocation() + "#" + "*");

    } catch (IOException e) {
      System.out.println("failed");
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



  public void allocationPage(final List<Share> shareList, final double r, final int m, final List<List<Share>> alloc, final boolean rewind, final boolean rewind2, final boolean rewind3, final boolean rewind4){
    test = new testClass(curSysProp+1);
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


    ActionListener nextRound = new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        //testClass test = new testClass();
        System.out.println("Clicked the button");

        if(((checkNew) && (!rewind)) || ((checkNew2) && (rewind) && (!rewind2) && (!rewind3) && (!rewind4)) || ((checkNew2) && (rewind) && (rewind2) && (checkNew3) && (!rewind3) && (!rewind4))
            || ((checkNew2) && (rewind) && (rewind2) && (checkNew3) && (rewind3) && (checkNew4) && (!rewind4)) || ((checkNew2) && (rewind) && (rewind2) && (checkNew3) && (rewind3) && (checkNew4) && (rewind4) && (checkNew5))) {


          System.out.println("Im not coming in");
          phase2TestDataPage phase = new phase2TestDataPage(shareList, m, r, rewind, rewind2, rewind3, rewind4);
          phase.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
          phase.setVisible(true);


          frame2.setVisible(false);
          frame2.dispose();
        } else {

          System.out.println("I'm coming in");
          phase2TestRounds slider = new phase2TestRounds(shareList, test.getCurrent(), m, r, store, rewind, rewind2, rewind3, rewind4);

          slider.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
          slider.setVisible(true);

          frame2.setVisible(false);
          frame2.dispose();
        }

      }
    };

    button2.addActionListener(nextRound);





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



























}






























































































