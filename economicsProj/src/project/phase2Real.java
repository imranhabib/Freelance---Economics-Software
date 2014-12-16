package project;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.SoftBevelBorder;
import java.awt.*;

/**
 * Created by Imran on 2014-12-15.
 */
public class phase2Real {

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


    phase2Real () {


        prices = "Allocation 1: " + newline +  "Allocation 2: " + newline +  "Allocation 3: " + newline +  "Allocation 4: " + newline + "Allocation 5: " + newline +"Allocation 6: " + newline + "Allocation 7: " + newline + "Allocation 8: " + newline +"Allocation 9: " + newline + "Allocation 10: " + newline ;
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












        split2.setRightComponent(bottomPanel);
        split2.setLeftComponent(leftPanel);
        split.setBottomComponent(split2);

        mainScreen.add(buttonPanel, BorderLayout.SOUTH);
        mainScreen.add(split);
        mainScreen.setVisible(true);











    }




        public static void main (String[] args) throws Exception {
            phase2Real phase = new phase2Real();

        }




















}
