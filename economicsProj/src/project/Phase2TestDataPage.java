package project;

import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import test.testClass;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

    static JPanel topPanel;
    static JPanel bottomPanel;
    static JPanel buttonPanel;
    static JPanel leftPanel;

    static JLabel title;
    static JLabel title2;
    static JLabel title3;
    static JLabel title4;
    static JLabel title5;
    static JLabel title6;
    static JLabel title7;


    static ActionListener changes;

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



    public phase2TestDataPage(List<List<Share>> shares, final int m, final double r){
        prices = "Price Set 1: " + newline +  "Price Set 2: " + newline +  "Price Set 3: " + newline +  "Price Set 4: " + newline + "Price Set 5: " + newline +"Price Set 6: " + newline + "Price Set 7: " + newline + "Price Set 8: " + newline +"Price Set 9: " + newline + "Price Set 10: " + newline ;
        choices = "If you are satisfied with your choice rule, " + newline + "select the proceed button. " + newline + "Your choice rule will be applied to the prices listed automatically. "
        + newline + newline + "If you want to make a change to your choice rule, " + newline + "select the back to test rounds option";


        allocationsReal = shares;


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

        title2 = new JLabel();
        title3 = new JLabel();
        title4 = new JLabel();
        title5 = new JLabel();

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
                    allocationPage(store.getSharesListers1(), r , m);
                }
                else if(source == button2){
                    allocationPage(allocationsReal.get(1), r , m);
                }
                else if(source == button3){
                    allocationPage(allocationsReal.get(2), r , m);
                }
                else if(source == button4){
                    allocationPage(allocationsReal.get(3), r , m);
                }

            }
        };

        button1.addActionListener(changes);
        button2.addActionListener(changes);
        button3.addActionListener(changes);
        button4.addActionListener(changes);


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






























































































}
