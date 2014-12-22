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
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.util.List;

/**
 * Created by Imran on 2014-12-21.
 */
public class finalPage extends JFrame {

    static JFrame mainScreen;




    String filename = "output.csv";

    File file;
    FileWriter filer1;
    FileWriter filer2;
    FileWriter filer3;
    FileWriter filer4;
    FileWriter filer5;
    FileWriter filer6;
    FileWriter filer7;
    FileWriter filer8;
    FileWriter filer9;
    FileWriter filer10;
    FileWriter filer11;
    FileWriter filer12;



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

    static int M;
    static double R;

    private String newline = "\n";
    private String newtab = "\t\t\t\t";

    String instruc;

    String directory = System.getProperty("user.home") + "/Desktop";


    public finalPage(final List<List<Share>> shares, final int m, final double r){


        mainScreen = new JFrame("Final Allocations from Stage 4");
        mainScreen.setLayout(new BorderLayout());
        Dimension screenSize = new Dimension(600, 800);
        mainScreen.setBounds(0,0,1200,700);
        mainScreen.setLocationRelativeTo(null);


        instruc = "You are finished with the experiment!" + newline + "A random portfolio allocation will now be chosen," + newline + "Please click 'end experiment'" + newline + "Thanks!";

        file = new File(directory, filename);

        raisedBorder = new SoftBevelBorder(SoftBevelBorder.RAISED);
        loweredBorder = new SoftBevelBorder(SoftBevelBorder.LOWERED);

        M = m;
        R = r;

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

        title = new JLabel("Allocations After Stage 4");
        title.setFont(new Font("Calibri", Font.BOLD, 20));

        mainScreen.add(title, BorderLayout.NORTH);
        split.setTopComponent(topPanel);

        split2 = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
        split2.setResizeWeight(.50);

        bottomPanel = new JPanel(new BorderLayout());





        leftPanel = new JPanel(new BorderLayout());

        title7 = new JLabel("Instructions");
        leftPanel.add(title7, BorderLayout.NORTH);


        text = new JTextArea(instruc);
        text.setFont(new Font("Calibri",Font.ROMAN_BASELINE, 16));
        text.setLineWrap(true);
        text.setWrapStyleWord(true);


        bottomPanel.add(text, BorderLayout.CENTER);

        leftPanel.add(text, BorderLayout.CENTER);


        button12= new JButton("End Experiment");

        split2.setLeftComponent(leftPanel);
        split.setBottomComponent(split2);

        mainScreen.add(button12, BorderLayout.SOUTH);
        mainScreen.add(split);
        mainScreen.setVisible(true);


        actionListener1 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                allocationPage(shares.get(0));

            }
        };

        actionListener2 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                allocationPage(shares.get(1));

            }
        };

        actionListener3 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                allocationPage(shares.get(2));
            }
        };

        actionListener4 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                allocationPage(shares.get(3));

            }
        };

        actionListener5 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                allocationPage(shares.get(4));

            }
        };

        actionListener6 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                allocationPage(shares.get(5));

            }
        };

        actionListener7 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                allocationPage(shares.get(6));

            }
        };

        actionListener8 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                allocationPage(shares.get(7));

            }
        };

        actionListener9 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                allocationPage(shares.get(8));

            }
        };

        actionListener10 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                allocationPage(shares.get(9));

            }
        };



        actionListener11 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                int result = JOptionPane.showConfirmDialog(null,
                        "End Experiment?", "Confirmation", JOptionPane.YES_NO_OPTION);

                if (result != 0) {
                    return;
                }



                if (!file.exists()) {
                    file = new File(directory, filename);
                    fileCreator(file);
                }

                filer1 = createFileWriter(file);
                formatFile(filer1, 1);
                for (Share shr : shares.get(0)) {
                    writeToFile(filer1, shr);

                }
                closeFile2(filer1);



                if (!file.exists()) {
                    file = new File(directory, filename);
                    fileCreator(file);
                }

                filer2 = createFileWriter(file);
                formatFile(filer2, 2);
                for (Share shr : shares.get(1)) {
                    writeToFile(filer2, shr);

                }
                closeFile2(filer2);



                if (!file.exists()) {
                    file = new File(directory, filename);
                    fileCreator(file);
                }

                filer3 = createFileWriter(file);
                formatFile(filer3, 3);
                for (Share shr : shares.get(2)) {
                    writeToFile(filer3, shr);

                }
                closeFile2(filer3);

                if (!file.exists()) {
                    file = new File(directory, filename);
                    fileCreator(file);
                }

                filer4 = createFileWriter(file);
                formatFile(filer4, 4);
                for (Share shr : shares.get(3)) {
                    writeToFile(filer4, shr);

                }
                closeFile2(filer4);



                if (!file.exists()) {
                    file = new File(directory, filename);
                    fileCreator(file);
                }

                filer5 = createFileWriter(file);
                formatFile(filer5, 5);
                for (Share shr : shares.get(4)) {
                    writeToFile(filer5, shr);

                }
                closeFile2(filer5);

                if (!file.exists()) {
                    file = new File(directory, filename);
                    fileCreator(file);
                }

                filer6 = createFileWriter(file);
                formatFile(filer6, 6);
                for (Share shr : shares.get(5)) {
                    writeToFile(filer6, shr);

                }
                closeFile2(filer6);

                if (!file.exists()) {
                    file = new File(directory, filename);
                    fileCreator(file);
                }

                filer7 = createFileWriter(file);
                formatFile(filer7, 7);
                for (Share shr : shares.get(6)) {
                    writeToFile(filer7, shr);

                }
                closeFile2(filer7);

                if (!file.exists()) {
                    file = new File(directory, filename);
                    fileCreator(file);
                }

                filer8 = createFileWriter(file);
                formatFile(filer8, 8);
                for (Share shr : shares.get(7)) {
                    writeToFile(filer8, shr);

                }
                closeFile2(filer8);

                if (!file.exists()) {
                    file = new File(directory, filename);
                    fileCreator(file);
                }

                filer9 = createFileWriter(file);
                formatFile(filer9, 9);
                for (Share shr : shares.get(8)) {
                    writeToFile(filer9, shr);

                }
                closeFile2(filer9);

                if (!file.exists()) {
                    file = new File(directory, filename);
                    fileCreator(file);
                }

                filer10 = createFileWriter(file);
                formatFile(filer10, 10);
                for (Share shr : shares.get(9)) {
                    writeToFile(filer10, shr);

                }
                closeFile2(filer10);



                mainScreen.setVisible(false);

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









    }



    public void allocationPage(final List<Share> shareList){

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



    public void formatFile(FileWriter filer, int count) {

        try {
            filer.write("\n\n" + "Final Allocations with Stage 4 swaps (if any)" + "\n\n" + "Round " + count);
        } catch (IOException e) {
            System.out.println("new file code failed");
        }


    }






    public void writeToFile(FileWriter filer, Share share) {
        try {
            filer.write("\n"+ "Reservation Ratio = " + R + " Minimum Share = " + M + " Security number = " + share.getSecurityNumber() + " Security price = " + share.getPrice() + " Security Income Share = " + share.getIncomeShare() +
                    " Security Allocation = " + share.getAllocation());

        } catch (IOException e) {
            System.out.println("failed hurr");
        }

    }



    public void closeFile2(FileWriter filer){
        try {
            filer.flush();
            filer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }







}
