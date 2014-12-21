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
import java.util.*;
import java.util.List;

/**
 * Created by livin_4_the_game on 14-12-18.
 */
public class phase4 extends JFrame{

    static JFrame mainScreen;

    static JLabel title;
    static JLabel instructions;
    static JLabel changeAllocations;

    static Border raisedBorder;
    static Border loweredBorder;




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

    static JTextArea text;


    static JSplitPane split;
    static JSplitPane split2;
    static JSplitPane split3;

    static JPanel leftPanel;
    static JPanel rightPanel;
    static JPanel checkboxPanel;
    static JPanel buttonPanel;
    static JPanel bottomPanel;

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

    static JButton button1b;
    static JButton button2b;
    static JButton button3b;
    static JButton button4b;
    static JButton button5b;
    static JButton button6b;
    static JButton button7b;
    static JButton button8b;
    static JButton button9b;
    static JButton button10b;

    static JButton button11;
    static JButton button12;


    static JCheckBox checkBox1;
    static JCheckBox checkBox2;
    static JCheckBox checkBox3;
    static JCheckBox checkBox4;
    static JCheckBox checkBox5;
    static JCheckBox checkBox6;
    static JCheckBox checkBox7;
    static JCheckBox checkBox8;
    static JCheckBox checkBox9;
    static JCheckBox checkBox10;


    List<List<Share>> tempListBeforeChecksCOnfirm;
    static List<List<Share>> results;




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




    String instructions2;




    char[] arr;






    public phase4(final List<List<Share>> allocations, final int m, final double r){
        mainScreen = new JFrame();
        mainScreen.setLayout(new BorderLayout());
        mainScreen.setTitle("Stage 4");
        Dimension screenSize = new Dimension(600, 800);
        mainScreen.setBounds(0,0,1200,700);
        mainScreen.setLocationRelativeTo(null);

        raisedBorder = new SoftBevelBorder(SoftBevelBorder.RAISED);
        loweredBorder = new SoftBevelBorder(SoftBevelBorder.LOWERED);

        checkboxPanel = new JPanel(new GridLayout(10,2,10,10));
        checkboxPanel.setBorder(raisedBorder);
        rightPanel = new JPanel(new GridLayout(10, 2, 10, 10));
        rightPanel.setBorder(raisedBorder);
        split2 = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, checkboxPanel, rightPanel);
        split2.setResizeWeight(0.09);

        leftPanel = new JPanel(new GridLayout(10, 2, 10 , 10));
        leftPanel.setBorder(raisedBorder);
        split = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, leftPanel, split2);
        split.setResizeWeight(.5);

        tempListBeforeChecksCOnfirm = new ArrayList<List<Share>>();
        results = allocations;


        instructions2 = "You must review the allocations before selecting them";

        text = new JTextArea(instructions2);
        text.setFont(new Font("Calibri", Font.BOLD, 16));
        text.setLineWrap(true);
        text.setWrapStyleWord(true);





        checkBox1 = new JCheckBox();
        checkBox2 = new JCheckBox();
        checkBox3 = new JCheckBox();
        checkBox4 = new JCheckBox();
        checkBox5 = new JCheckBox();
        checkBox6 = new JCheckBox();
        checkBox7 = new JCheckBox();
        checkBox8 = new JCheckBox();
        checkBox9 = new JCheckBox();
        checkBox10 = new JCheckBox();


        checkBox1.setEnabled(false);
        checkBox2.setEnabled(false);
        checkBox3.setEnabled(false);
        checkBox4.setEnabled(false);
        checkBox5.setEnabled(false);
        checkBox6.setEnabled(false);
        checkBox7.setEnabled(false);
        checkBox8.setEnabled(false);
        checkBox9.setEnabled(false);
        checkBox10.setEnabled(false);



        button1 = new JButton("Click to see current allocations for price set 1");
        button2 = new JButton("Click to see current allocations for price set 2");
        button3 = new JButton("Click to see current allocations for price set 3");
        button4 = new JButton("Click to see current allocations for price set 4");
        button5 = new JButton("Click to see current allocations for price set 5");
        button6 = new JButton("Click to see current allocations for price set 6");
        button7 = new JButton("Click to see current allocations for price set 7");
        button8 = new JButton("Click to see current allocations for price set 8");
        button9 = new JButton("Click to see current allocations for price set 9");
        button10 = new JButton("Click to see current allocations for price set 10");

        button1b = new JButton("Click to see allocations for new price set 1");
        button2b = new JButton("Click to see allocations for new price set 2");
        button3b = new JButton("Click to see allocations for new price set 3");
        button4b = new JButton("Click to see allocations for new price set 4");
        button5b = new JButton("Click to see allocations for new price set 5");
        button6b = new JButton("Click to see allocations for new price set 6");
        button7b = new JButton("Click to see allocations for new price set 7");
        button8b = new JButton("Click to see allocations for new price set 8");
        button9b = new JButton("Click to see allocations for new price set 9");
        button10b = new JButton("Click to see allocations for new price set 10");

        leftPanel.add(button1);
        leftPanel.add(button2);
        leftPanel.add(button3);
        leftPanel.add(button4);
        leftPanel.add(button5);
        leftPanel.add(button6);
        leftPanel.add(button7);
        leftPanel.add(button8);
        leftPanel.add(button9);
        leftPanel.add(button10);

        rightPanel.add(button1b);
        rightPanel.add(button2b);
        rightPanel.add(button3b);
        rightPanel.add(button4b);
        rightPanel.add(button5b);
        rightPanel.add(button6b);
        rightPanel.add(button7b);
        rightPanel.add(button8b);
        rightPanel.add(button9b);
        rightPanel.add(button10b);

        checkboxPanel.add(checkBox1);
        checkboxPanel.add(checkBox2);
        checkboxPanel.add(checkBox3);
        checkboxPanel.add(checkBox4);
        checkboxPanel.add(checkBox5);
        checkboxPanel.add(checkBox6);
        checkboxPanel.add(checkBox7);
        checkboxPanel.add(checkBox8);
        checkboxPanel.add(checkBox9);
        checkboxPanel.add(checkBox10);

        button11 = new JButton("Confirm Choices");
        button12= new JButton("Submit");
        button12.setEnabled(false);

        buttonPanel = new JPanel(new GridLayout(1, 0, 5, 5));
        buttonPanel.add(button11);
        buttonPanel.add(button12);

        instructions = new JLabel("Instructions");
        instructions.add(text);
        bottomPanel = new JPanel(new BorderLayout());
        bottomPanel.add(instructions, BorderLayout.NORTH);

        split3 = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, bottomPanel, split);
        split3.setResizeWeight(0.6);


        title = new JLabel("Stage 4");
        title.setFont(new Font("Calibri", Font.BOLD, 20));
        mainScreen.add(title, BorderLayout.NORTH);


        mainScreen.add(split3);
        mainScreen.add(buttonPanel, BorderLayout.SOUTH);

        mainScreen.setVisible(true);



        tempListBeforeChecksCOnfirm.add(0, makeAShareList(reader1, filename1, arr));
        tempListBeforeChecksCOnfirm.add(1, makeAShareList(reader2, filename2, arr));
        tempListBeforeChecksCOnfirm.add(2, makeAShareList(reader3, filename3, arr));
        tempListBeforeChecksCOnfirm.add(3, makeAShareList(reader4, filename4, arr));
        tempListBeforeChecksCOnfirm.add(4, makeAShareList(reader5, filename5, arr));
        tempListBeforeChecksCOnfirm.add(5, makeAShareList(reader6, filename6, arr));
        tempListBeforeChecksCOnfirm.add(6, makeAShareList(reader7, filename7, arr));
        tempListBeforeChecksCOnfirm.add(7, makeAShareList(reader8, filename8, arr));
        tempListBeforeChecksCOnfirm.add(8, makeAShareList(reader9, filename9, arr));
        tempListBeforeChecksCOnfirm.add(9, makeAShareList(reader10, filename10, arr));




        actionListener1 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JButton source = (JButton) e.getSource();

                if (source == button1) {
                    allocationPage(allocations.get(0), r, m);
                }

                if (source == button1b) {
                    checkBox1.setEnabled(true);
                    allocationPage(tempListBeforeChecksCOnfirm.get(0), r, m);

                }
            }
        };

        actionListener2 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JButton source = (JButton) e.getSource();

                if (source == button2) {
                    allocationPage(allocations.get(1), r, m);
                }

                if (source == button2b) {

                    checkBox2.setEnabled(true);
                    allocationPage(tempListBeforeChecksCOnfirm.get(1), r, m);
                }
            }
        };
        actionListener3 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JButton source = (JButton) e.getSource();

                if (source == button3) {
                    allocationPage(allocations.get(2), r, m);

                }

                if (source == button3b) {
                    checkBox3.setEnabled(true);
                    allocationPage(tempListBeforeChecksCOnfirm.get(2), r, m);

                }
            }
        };
        actionListener4 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JButton source = (JButton) e.getSource();

                if (source == button4) {
                    allocationPage(allocations.get(3), r, m);
                }

                if (source == button4b) {

                    checkBox4.setEnabled(true);
                    allocationPage(tempListBeforeChecksCOnfirm.get(3), r, m);

                }
            }
        };
        actionListener5 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JButton source = (JButton) e.getSource();

                if (source == button5) {
                    allocationPage(allocations.get(4), r, m);

                }

                if (source == button5b) {

                    checkBox5.setEnabled(true);
                    allocationPage(tempListBeforeChecksCOnfirm.get(4), r, m);

                }
            }
        };
        actionListener6 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JButton source = (JButton) e.getSource();

                if (source == button6) {
                    allocationPage(allocations.get(5), r, m);

                }

                if (source == button6b) {

                    checkBox6.setEnabled(true);
                    allocationPage(tempListBeforeChecksCOnfirm.get(5), r, m);

                }
            }
        };
        actionListener7 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JButton source = (JButton) e.getSource();

                if (source == button7) {
                    allocationPage(allocations.get(6), r, m);

                }

                if (source == button7b) {

                    checkBox7.setEnabled(true);
                    allocationPage(tempListBeforeChecksCOnfirm.get(6), r, m);

                }
            }
        };
        actionListener8 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JButton source = (JButton) e.getSource();

                if (source == button8) {
                    allocationPage(allocations.get(7), r, m);

                }

                if (source == button8b) {

                    checkBox8.setEnabled(true);
                    allocationPage(tempListBeforeChecksCOnfirm.get(7), r, m);

                }
            }
        };

        actionListener9 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JButton source = (JButton) e.getSource();

                if (source == button9) {
                    allocationPage(allocations.get(8), r, m);

                }

                if (source == button9b) {

                    checkBox9.setEnabled(true);
                    allocationPage(tempListBeforeChecksCOnfirm.get(8), r, m);

                }
            }
        };
        actionListener10 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JButton source = (JButton) e.getSource();

                if (source == button10) {
                    allocationPage(allocations.get(9), r, m);

                }

                if (source == button10b) {

                    checkBox10.setEnabled(true);
                    allocationPage(tempListBeforeChecksCOnfirm.get(9), r, m);

                }
            }
        };



        actionListener11 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int result = JOptionPane.showConfirmDialog(null,
                        "Are you sure you want to make these choices?", "Confirmation", JOptionPane.YES_NO_OPTION);

                if (result != 0) {
                    return;
                }


                if(checkBox1.isSelected()) {
                    List<Share> temp = tempListBeforeChecksCOnfirm.get(0);
                    results.remove(0);
                    results.add(0, temp);
                }
                if(checkBox2.isSelected()) {
                    List<Share> temp = tempListBeforeChecksCOnfirm.get(1);
                    results.remove(1);
                    results.add(1, temp);
                }
                if(checkBox3.isSelected()) {
                    List<Share> temp = tempListBeforeChecksCOnfirm.get(2);
                    results.remove(2);
                    results.add(2, temp);
                }
                if(checkBox4.isSelected()) {
                    List<Share> temp = tempListBeforeChecksCOnfirm.get(3);
                    results.remove(3);
                    results.add(3, temp);
                }
                if(checkBox5.isSelected()) {
                    List<Share> temp = tempListBeforeChecksCOnfirm.get(4);
                    results.remove(4);
                    results.add(4, temp);
                }
                if(checkBox6.isSelected()) {
                    List<Share> temp = tempListBeforeChecksCOnfirm.get(5);
                    results.remove(5);
                    results.add(5, temp);
                }
                if(checkBox7.isSelected()) {
                    List<Share> temp = tempListBeforeChecksCOnfirm.get(6);
                    results.remove(6);
                    results.add(6, temp);
                }
                if(checkBox8.isSelected()) {
                    List<Share> temp = tempListBeforeChecksCOnfirm.get(7);
                    results.remove(7);
                    results.add(7, temp);
                }
                if(checkBox9.isSelected()) {
                    List<Share> temp = tempListBeforeChecksCOnfirm.get(8);
                    results.remove(8);
                    results.add(8, temp);
                }
                if(checkBox10.isSelected()) {
                    List<Share> temp = tempListBeforeChecksCOnfirm.get(9);
                    results.remove(9);
                    results.add(9, temp);
                }




                button1.setEnabled(false);
                button2.setEnabled(false);
                button3.setEnabled(false);
                button4.setEnabled(false);
                button5.setEnabled(false);
                button6.setEnabled(false);
                button7.setEnabled(false);
                button8.setEnabled(false);
                button9.setEnabled(false);
                button10.setEnabled(false);

                button1b.setEnabled(false);
                button2b.setEnabled(false);
                button3b.setEnabled(false);
                button4b.setEnabled(false);
                button5b.setEnabled(false);
                button6b.setEnabled(false);
                button7b.setEnabled(false);
                button8b.setEnabled(false);
                button9b.setEnabled(false);
                button10b.setEnabled(false);

                checkBox1.setEnabled(false);
                checkBox2.setEnabled(false);
                checkBox3.setEnabled(false);
                checkBox4.setEnabled(false);
                checkBox5.setEnabled(false);
                checkBox6.setEnabled(false);
                checkBox7.setEnabled(false);
                checkBox8.setEnabled(false);
                checkBox9.setEnabled(false);
                checkBox10.setEnabled(false);

                button11.setEnabled(false);
                button12.setEnabled(true);





            }

        };



        actionListener12 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int result = JOptionPane.showConfirmDialog(null,
                        "You are finisihed the experiment!, You can view your final allocations in the next window", "Confirmation", JOptionPane.YES_NO_OPTION);

                if (result != 0) {
                    return;
                }



                finalPage fini = new finalPage(results);
                fini.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

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

        button1b.addActionListener(actionListener1);
        button2b.addActionListener(actionListener2);
        button3b.addActionListener(actionListener3);
        button4b.addActionListener(actionListener4);
        button5b.addActionListener(actionListener5);
        button6b.addActionListener(actionListener6);
        button7b.addActionListener(actionListener7);
        button8b.addActionListener(actionListener8);
        button9b.addActionListener(actionListener9);
        button10b.addActionListener(actionListener10);

        button11.addActionListener(actionListener11);
        button12.addActionListener(actionListener12);












    }





    public void allocationPage(final java.util.List<Share> shareList, final double r, final int m){

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



    public void chartView (java.util.List<Share> shareList){

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






    public ArrayList<Share> makeAShareList(FileReader reader, String filename, char[] arr){
        arr = new char[1000];
        reader = createReader(filename);
        arr = readFile(arr, reader);
        String line = "";
        for(char c: arr) {
            line = line + c;
        }
        String[] secondLine = line.split("@");
        ArrayList<Share> shareList = new ArrayList<Share>();

        for(int i = 1; i < secondLine.length; i ++){
            String number = secondLine[i].substring(secondLine[i].indexOf("%") + 1, secondLine[i].lastIndexOf("%"));
            String price = secondLine[i].substring(secondLine[i].indexOf("$") + 1, secondLine[i].lastIndexOf("$"));
            String allocation = secondLine[i].substring(secondLine[i].indexOf("#") + 1, secondLine[i].lastIndexOf("#"));
            Share shr = new Share(Integer.parseInt(price), Integer.parseInt(number), Double.parseDouble(allocation));
            shareList.add(shr);
        }

        closeFile(reader);

        return shareList;


    }
}





















