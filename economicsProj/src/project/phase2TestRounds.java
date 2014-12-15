package project;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import test.testClass;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Arc2D;
import java.io.*;
import java.util.*;
import java.util.List;

/**
 * Created by Imran on 2014-12-13.
 */
public class phase2TestRounds extends JFrame{

     static excel workbook;
    static Workbook work;
    static HSSFSheet Newsheet;



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
    static JButton button3;

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


    private static ChangeListener changelistener;
    private static ChangeListener changelistener2;
    private static ChangeListener changelistener3;
    private static ActionListener Actionlistener4;
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

    //file stuffz

    String filename = "output.csv";
    String directory = System.getProperty("user.home") + "/Desktop";
    File file;
    FileWriter filer;


    //backend stuffz


    allocation alloc;
    parameters param;
    incomeRequired income;

    static Integer value;
    static Double value2;
    static Double pBar;
    static Double mBar;
    static Double r;
    static Double nOfr;
    static int minimumShare;

    private static int n;



    //this list of lists holds all the allocation data
   static List<List<Share>> listOfAllocations;


   static  List<Share> shareList;


    public phase2TestRounds(final List<Share> shares, int cur, final int minShare, final double r, storageClass storage)  {

     try{
         work.getSheet("");
        } catch(NullPointerException n){
             work = new HSSFWorkbook();
         workbook = new excel();
         }


        curSysProp = cur;
        test = new testClass();




        System.out.println("called here " + test.getCurrent());

        store = storage;


        if (test.getCurrent() == 2) {
            store.setListers(shares);
            try {
                work.getSheet("PriceSet1");


            } catch (NullPointerException n) {
                Sheet worksheet = work.createSheet("PriceSet1");
                for (Share shr : store.getSharesListers1()) {
                    Map<String, Object[]> data = new TreeMap<String, Object[]>();
                    data.put("Name", new Object[]{Integer.toString(shr.getSecurityNumber())});
                    data.put("Price", new Object[]{Integer.toString(shr.getPrice())});
                    data.put("Income Share", new Object[]{Double.toString(shr.getIncomeShare())});
                    data.put("Allocation", new Object[]{Double.toString(shr.getAllocation())});


                    //Iterate over data and write to sheet
                    Set<String> keyset = data.keySet();
                    int rownum = 0;
                    for (String key : keyset) {
                        Row row = worksheet.createRow(rownum++);
                        Object[] objArr = data.get(key);
                        int cellnum = 0;
                        for (Object obj : objArr) {
                            Cell cell = row.createCell(cellnum++);
                            if (obj instanceof String)
                                cell.setCellValue((String) obj);
                            else if (obj instanceof Integer)
                                cell.setCellValue((Integer) obj);
                        }
                    }
                }
                try {
                    FileOutputStream out = new FileOutputStream(new File("PriceSet1" + ".xls"));
                    work.write(out);
                    out.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }


        } else if (test.getCurrent() == 3) {
            store.setListers2(shares);
            listOfAllocations.add(store.getSharesListers2());
            for(Share shr: store.getSharesListers2()){
                System.out.println("This is the allocation share for set 2= " + shr.allocation);
            }


        } else if (test.getCurrent() == 4) {
            store.setListers3(shares);
            listOfAllocations.add(store.getSharesListers3());
            for(Share shr: store.getSharesListers3()){
                System.out.println("This is the allocation share for set 3= " + shr.allocation);
            }


        } else {
            store.setListers4(shares);
            checkNew = true;
            listOfAllocations.add(store.getSharesListers4());
            for(Share shr: store.getSharesListers4()){
                System.out.println("This is the allocation share for set 4= " + shr.allocation);
            }

        }






        setLayout(new BorderLayout());
        setTitle("Slider Interface");
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


      /*
      textField.setForeground(blue);
      textField2.setForeground(red);
      textField3.setForeground(blue);
      textField4.setForeground(red);
      textField5.setForeground(blue);
      */

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
        textFieldjSpinner2.setText(Integer.toString(minShare));



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



                    allocationPage(shareList, r, minShare, listOfAllocations);

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
            filer.write("\n" + "Round " + test.getCurrent() + "\n");
        } catch (IOException e) {
            System.out.println("new file code failed");
        }


    }



    public void writeToFile(FileWriter filer, Share share) {
        try {
            filer.write("\n" + "Security number = " + share.getSecurityNumber() + " Security price = " + share.getPrice() + " Security Income Share = " + share.getIncomeShare() +
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



    public void allocationPage(final List<Share> shareList, final double r, final int m, final List<List<Share>> alloc){
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
                frame2.setVisible(false);
                frame2.dispose();
                testClass test = new testClass();

                if(checkNew){
                    for(Share shr: store.getSharesListers3()){
                        System.out.println("This is the allocation share for set 3= " + shr.allocation);
                    }

                    System.out.println("HERE");
                    phase2TestDataPage phase = new phase2TestDataPage(alloc, m, r);
                    phase.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    phase.setVisible(true);
                } else {
                    phase2TestRounds slider = new phase2TestRounds(shareList, test.getCurrent(), m, r, store);

                    slider.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    slider.setVisible(true);
                }

            }
        };

        button2.addActionListener(nextRound);

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



























}





























































































