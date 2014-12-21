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
import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Imran on 2014-12-14.
 */
public class phase2TestDataPage extends JFrame {

    static JFrame mainScreen;

    static JButton button1;
    static JButton button2;
    static JButton button3;
    static JButton button4;
    static JButton button5;
    static JButton button6;

    static JButton title2;
    static JButton title3;
    static JButton title4;
    static JButton title5;

    static JPanel topPanel;
    static JPanel bottomPanel;
    static JPanel buttonPanel;
    static JPanel leftPanel;

    static JLabel title;

    static JLabel title6;
    static JLabel title7;

    String directory = System.getProperty("user.home") + "/Desktop";


    String filenameer1 = directory + "/priceSet1.csv";
    String filenameer2 = directory + "/priceSet2.csv";
    String filenameer3 = directory + "/priceSet3.csv";
    String filenameer4 = directory + "/priceSet4.csv";
    String filename5 = "priceSet5.csv";


    String filenameRewind1 = directory + "/priceSetRewind1.csv";
    String filenameRewind2 = directory + "/priceSetRewind2.csv";
    String filenameRewind3 = directory + "/priceSetRewind3.csv";
    String filenameRewind4 = directory + "/priceSetRewind4.csv";
    String filenameRewind5 = "priceSetRewind5.csv";


    FileReader Stage2reader;
    FileReader Stage2reader2;
    FileReader Stage2reader3;
    FileReader Stage2reader4;


    FileReader readerRewind;
    FileReader readerRewind2;
    FileReader readerRewind3;
    FileReader readerRewind4;




    static ActionListener changes;
    static ActionListener changes2;
    static ActionListener changes3;
    static ActionListener changes4;

    static JSplitPane split;
    static JSplitPane split2;
    static JTextArea text;
    static JTextArea text2;


    static Border raisedBorder;
    static Border loweredBorder;

    static storageClass store;

    static String prices;
    static String choices;
    private String newline = "\n";
    private String newtab = "\t\t\t\t";

    static List<List<Share>> allocationsReal;

    static double R;
    static int M;



    public phase2TestDataPage(final List<Share> shares, final int m, final double r, final boolean rewind){
        prices = "Price Set 1: " + newline +  "Price Set 2: " + newline +  "Price Set 3: " + newline +  "Price Set 4: " + newline + "Price Set 5: " + newline +"Price Set 6: " + newline + "Price Set 7: " + newline + "Price Set 8: " + newline +"Price Set 9: " + newline + "Price Set 10: " + newline ;
        choices = "If you are satisfied with your choice rule, " + newline + "select the proceed button. " + newline + "Your choice rule will be applied to the prices listed automatically. "
                + newline + newline + "If you want to make a change to your choice rule, " + newline + "select the back to test rounds option";

        R = r;
        M = m;






        mainScreen = new JFrame("Stage 2 Test Round Data");
        mainScreen.setLayout(new BorderLayout());
        Dimension screenSize = new Dimension(600, 800);
        mainScreen.setBounds(0,0,1000,600);
        mainScreen.setLocationRelativeTo(null);


        raisedBorder = new SoftBevelBorder(SoftBevelBorder.RAISED);
        loweredBorder = new SoftBevelBorder(SoftBevelBorder.LOWERED);



        split = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
        split.setResizeWeight(.80);
        topPanel = new JPanel(new GridLayout(4, 2, 10 , 10));


        button1 = new JButton("Click to see allocations from price set 1");
        button2 = new JButton("Click to see allocations from price set 2");
        button3 = new JButton("Click to see allocations from price set 3");
        button4 = new JButton("Click to see allocations from price set 4");

        button1.setFont(new Font("Calibri", Font.BOLD, 20));
        button2.setFont(new Font("Calibri", Font.BOLD, 20));
        button3.setFont(new Font("Calibri", Font.BOLD, 20));
        button4.setFont(new Font("Calibri", Font.BOLD, 20));

        title2 = new JButton();
        title3 = new JButton();
        title4 = new JButton();
        title5 = new JButton();

        title2.setFont(new Font("Calibri", Font.BOLD, 20));
        title3.setFont(new Font("Calibri", Font.BOLD, 20));
        title4.setFont(new Font("Calibri", Font.BOLD, 20));
        title5.setFont(new Font("Calibri", Font.BOLD, 20));

        if(rewind){
            title2.setText("Click to see allocations from price set 1");
                    title3.setText("Click to see allocations from price set 2");
            title4.setText("Click to see allocations from price set 3");
                    title5.setText("Click to see allocations from price set 4");
        }



        topPanel.add(button1);
        topPanel.add(title2);
        topPanel.add(button2);
        topPanel.add(title3);
        topPanel.add(button3);
        topPanel.add(title4);
        topPanel.add(button4);
        topPanel.add(title5);

        title = new JLabel("Data Page for Test Round Allocations");
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


        button5 = new JButton("Proceed to Stage 2");
        button6 = new JButton("Back to Stage 2 Test Rounds");

        buttonPanel = new JPanel(new GridLayout(1, 0, 5, 5));
        buttonPanel.add(button6);
        buttonPanel.add(button5);


        changes = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JButton source = (JButton) e.getSource();
                if(source == button1){
                    char[] arr = new char[1000];
                    Stage2reader = createReader(filenameer1);
                    arr = readFile(arr, Stage2reader);
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
                        Share shr = new Share(Integer.parseInt(price), Double.parseDouble(incomeShare), Integer.parseInt(number), Double.parseDouble(allocation));
                        shareList.add(shr);
                    }
                    for(Share shr: shareList) {
                        System.out.println("price = " + shr.getPrice() + " income share = " + shr.getIncomeShare() + " number = " + shr.getPrice() + " allocation = " + shr.getAllocation());
                    }
                    closeFile(Stage2reader);
                    allocationPage(shareList, R, M);
                }
                else if(source == button2){
                    char[] arr = new char[1000];
                    Stage2reader2 = createReader(filenameer2);
                    arr = readFile(arr, Stage2reader2);
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
                        Share shr = new Share(Integer.parseInt(price), Double.parseDouble(incomeShare), Integer.parseInt(number), Double.parseDouble(allocation));
                        shareList.add(shr);
                    }
                    for(Share shr: shareList) {
                        System.out.println("price = " + shr.getPrice() + " income share = " + shr.getIncomeShare() + " number = " + shr.getPrice() + " allocation = " + shr.getAllocation());
                    }

                    closeFile(Stage2reader2);
                    allocationPage(shareList, R, M);
                }
                else if(source == button3){
                    char[] arr = new char[1000];
                    Stage2reader3 = createReader(filenameer3);
                    arr = readFile(arr, Stage2reader3);
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
                        Share shr = new Share(Integer.parseInt(price), Double.parseDouble(incomeShare), Integer.parseInt(number), Double.parseDouble(allocation));
                        shareList.add(shr);
                    }
                    for(Share shr: shareList) {
                        System.out.println("price = " + shr.getPrice() + " income share = " + shr.getIncomeShare() + " number = " + shr.getPrice() + " allocation = " + shr.getAllocation());
                    }
                    closeFile(Stage2reader3);
                    allocationPage(shareList, R, M);
                }
                else if(source == button4){
                    char[] arr = new char[1000];
                    Stage2reader4 = createReader(filenameer4);
                    arr = readFile(arr, Stage2reader4);
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
                        Share shr = new Share(Integer.parseInt(price), Double.parseDouble(incomeShare), Integer.parseInt(number), Double.parseDouble(allocation));
                        shareList.add(shr);
                    }
                    for(Share shr: shareList) {
                        System.out.println("price = " + shr.getPrice() + " income share = " + shr.getIncomeShare() + " number = " + shr.getPrice() + " allocation = " + shr.getAllocation());
                    }

                    closeFile(Stage2reader4);
                    allocationPage(shareList, R, M);
                }

            }
        };




        changes3 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JButton source = (JButton) e.getSource();
                if(source == title2){
                    char[] arr = new char[1000];
                    readerRewind = createReader(filenameRewind1);
                    arr = readFile(arr, readerRewind);
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
                        Share shr = new Share(Integer.parseInt(price), Double.parseDouble(incomeShare), Integer.parseInt(number), Double.parseDouble(allocation));
                        shareList.add(shr);
                    }
                    for(Share shr: shareList) {
                        System.out.println("price = " + shr.getPrice() + " income share = " + shr.getIncomeShare() + " number = " + shr.getPrice() + " allocation = " + shr.getAllocation());
                    }
                    closeFile(readerRewind);
                    allocationPage(shareList, R, M);
                }
                else if(source == title3){
                    char[] arr = new char[1000];
                    readerRewind2 = createReader(filenameRewind2);
                    arr = readFile(arr, readerRewind2);
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
                        Share shr = new Share(Integer.parseInt(price), Double.parseDouble(incomeShare), Integer.parseInt(number), Double.parseDouble(allocation));
                        shareList.add(shr);
                    }
                    for(Share shr: shareList) {
                        System.out.println("price = " + shr.getPrice() + " income share = " + shr.getIncomeShare() + " number = " + shr.getPrice() + " allocation = " + shr.getAllocation());
                    }

                    closeFile(readerRewind2);
                    allocationPage(shareList, R, M);
                }
                else if(source == title4){
                    char[] arr = new char[1000];
                    readerRewind3 = createReader(filenameRewind3);
                    arr = readFile(arr, readerRewind3);
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
                        Share shr = new Share(Integer.parseInt(price), Double.parseDouble(incomeShare), Integer.parseInt(number), Double.parseDouble(allocation));
                        shareList.add(shr);
                    }
                    for(Share shr: shareList) {
                        System.out.println("price = " + shr.getPrice() + " income share = " + shr.getIncomeShare() + " number = " + shr.getPrice() + " allocation = " + shr.getAllocation());
                    }
                    closeFile(readerRewind3);
                    allocationPage(shareList, R, M);
                }
                else if(source == title5){
                    char[] arr = new char[1000];
                    readerRewind4 = createReader(filenameRewind4);
                    arr = readFile(arr, readerRewind4);
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
                        Share shr = new Share(Integer.parseInt(price), Double.parseDouble(incomeShare), Integer.parseInt(number), Double.parseDouble(allocation));
                        shareList.add(shr);
                    }
                    for(Share shr: shareList) {
                        System.out.println("price = " + shr.getPrice() + " income share = " + shr.getIncomeShare() + " number = " + shr.getPrice() + " allocation = " + shr.getAllocation());
                    }

                    closeFile(readerRewind4);

                    allocationPage(shareList, R, M);
                }

            }
        };






        changes4 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                int result = JOptionPane.showConfirmDialog(null,
                        "Continue to stage 2?", "Confirmation", JOptionPane.YES_NO_OPTION);

                if (result != 0) {
                    return;
                }


                double finalRatio = R;
                int finalM = M;
                double[] arr = new double[shares.size()];
                for(int i = 0; i < shares.size(); i ++){
                    arr[i] = shares.get(i).getIncomeShare();
                }


                phase2Real phaseReal = new phase2Real(arr, finalRatio, finalM);
                phaseReal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                phaseReal.setVisible(true);

            }
        };


        button5.addActionListener(changes4);



        changes2 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JButton source = (JButton) e.getSource();
                if(source == button6){
                    parameters params = new parameters();

                    sliderInterface2 slide = new sliderInterface2(params.getSecurityListFromStart(), 1, true,  M, R);
                    slide.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    slide.setVisible(true);
                }

            }
        };


        if(rewind) {
            title2.addActionListener(changes3);
            title3.addActionListener(changes3);
            title4.addActionListener(changes3);
            title5.addActionListener(changes3);
        }

        button1.addActionListener(changes);
        button2.addActionListener(changes);
        button3.addActionListener(changes);
        button4.addActionListener(changes);
        button6.addActionListener(changes2);


        split2.setRightComponent(bottomPanel);
        split2.setLeftComponent(leftPanel);
        split.setBottomComponent(split2);

        mainScreen.add(buttonPanel, BorderLayout.SOUTH);
        mainScreen.add(split);
        mainScreen.setVisible(true);







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

      final  JButton button2 = new JButton("Close");
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
