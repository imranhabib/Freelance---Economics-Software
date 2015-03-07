package project;

import test.testClass;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.SoftBevelBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by ihabib on 12/12/2014.
 */
public class instructions extends JFrame {

    private String newline = "\n";
    private String newtab = "\t\t\t\t";
    static parameters params;

    static JScrollPane scroller;
    static JTextArea texter;
    static JButton next;
    static Border raisedBorder;
    static Border loweredBorder;
    static JTextField legend;

    static JButton stage;
    static JButton stage1;
    static JButton stage2;
    static JButton stage3;
    static JButton stage4;

    static JPanel buttonPanel;

    static ActionListener stg1;



    String initString_part1;
    String stager1;
    String stager2;
    String stager3;
    String stager4;



    public instructions(){

        stager1 = "Part 1:" + newline + newline +  //bold

                "In Part 1 of the experiment you will be presented with 10 independent allocation problems. In each problem you have to decide how to allocate your income (denominated in "+ "\"lab currency\"" + ") between the different accounts. Generally, the cost of buying 1 token from different accounts will vary. The accounts will always be ordered such that the cost of buying a token (token's price) in Account 1 will be smaller (or equal) to the cost of buying a token in Account 2, and so forth. So buying a token in Account 6 is always the most expensive, while buying a token in Account 1 is always the least expensive. " +
                newline + newline
                +  "To choose an allocation in each round you will use 6 sliders. The leftmost slider controls the number of tokens bought in Account 1, and the rightmost slider controls the number of tokens bought in Account 6. As you move to the right the cost of buying tokens (the tokens' price) increases. The total income available in the round is displayed in the box " + "\"Total Income\"" + ", and the price of buying a token in each account is displayed above the slider. " + newline + newline +


                  "To choose how many tokens you want to hold in each account you must drag each slider to the desired level in order: from leftmost (Account 1) to the rightmost (Account 6) slider. Note that when you determine the amount of tokens you would like to hold in a specific account (by dragging the slider), the number of tokens, the total cost of the tokens allocated to this account and the remaining income if this allocation is chosen are displayed at the bottom of the screen. After you " + "\"drop\"" + " the slider to its desired location, the number of tokens you bought in that account is displayed above the slider and the slider to its right is immediately adjusted to reflect the maximum amount of tokens you can buy in the next account. The interface also does not allow you to buy more tokens in an account in which the price of tokens is higher (to the right). You must drag and drop the slider in order to record the number of tokens you would like to hold in the next account." + newline + newline +


                "If the "+ "\"Remaining Income\"" + " equals 0 (or very close to 0) you have two options:  " + newline + newline +

                "1.\tYou can click " + "\"Reset Allocation\"" + " to start again (note that the sliders are temporarily parked at the same location as before, but this is only for your convenience and to remind you what was the previous allocation you considered)." + newline + newline +

                "2.\tYou can click " + "\"Submit\"" + ", confirm and move on to the next round. If you decide not to confirm your allocation, you can reset it at and re-allocate your income. " +


                //icon2

                newline + newline +  "If the " + "\"Remaining Income\"" + " is positive after you purchased tokens in all the accounts then you will not be able to submit (if you try you will get an error message). You will have to reset the allocation and choose a different allocation." + newline + newline +

                //image	3
                //icon3

              "Note that for your convenience, if you click " + "\"Equal holdings\"" + " the computer automatically buys an equal number of tokens in all the accounts. This allocation guarantees that if this round is selected for payment, which account is selected will not affect your payment. However, it does not allow you the flexibility to buy more tokens in accounts in which the tokens are cheaper, so you may end up with a small and equal number of tokens in all accounts. You can then click " + "\"Reset Allocation\"" + " and adjust the " + "\"equal holdings\"" + " allocation from that point (again, start from the leftmost and move to the right) or just " + "\"submit\"" + " it. " + newline + newline +




                 "There is no limit how many times you can click the " +"\"Reset Allocation\"" + ", and you do not face a time limit to complete each or all allocations." + newline + newline +





              "After you submitted your allocation and confirmed your decision you will face another allocation decision. In each decision problem the token prices in the 6 accounts will be generally different." + newline + newline +




              "Before making allocation decisions that may affect your payment from this experiment, you will be given an opportunity to practice in 4 practice rounds. You can play with all the options in the interface and your allocation will not be recorded and cannot affect your payment.";



        initString_part1 = "Welcome" + newline + newline+  //bold
                "Welcome to the experiment. " //regular
                + "Please silence your cell phone and put it away for the duration of the experiment. "
                + "Additionally, please avoid any discussions with other participants. "
                + "At any time, if you have any questions please raise your hand and an experiment coordinator "
                + "will approach you." + newline + newline +

                "Please note: " +  //bold
                "If you want to review the instructions at any point during the experiment, "  //regular
                + "simply click on this window (the instructions window). To return to the experiment, "
                + "please click on the experiment icon on the taskbar. Please make sure you thoroughly understand the instructions prior to making decisions." + newline + newline +


                "Please remember that there are no right or wrong choices in this experiment. Your preferences may be different from other participants, and as a result your choices can be different." + newline + newline +

                "As in all experiments in Economics, the procedures are described fully and all payments are real." + newline + newline + newline +

                "Study Procedures: " + //bold
                newline+ newline +   "This is an experiment in individual decision making. The study has four parts and the instructions for the later parts will follow the completion of Part 1. Before making decisions that may affect your payment, you will be given an opportunity to practice. The practice rounds will allow you to familiarize yourself with the experimental interface and ask any questions you may have." + newline +
                newline +
                " You will be presented with 20 independent decision problems that share a common form. In each round you will be decide how to allocate your income of 100 (denominated in " + "\"lab currency\"" + ") between 6 accounts. In each account you can buy tokens, which will be exchanged for money at the end of the experiment.  The price of buying tokens may vary in different account." + newline + newline +


                "One round will be selected for payment at the conclusion of the experiment. Each round is equally likely to be chosen. Your payment is determined by the number of tokens you hold in a randomly selected account in that round. At the end of the experiment, you will roll a fair die to randomly select one of the 6 accounts. Each account is equally likely to be chosen. That is, there is a 1/6 chance that each one of the accounts will be chosen. " +

                newline + newline +

                "You will be paid only according to the amount of tokens you hold in the account that is randomly chosen in the round that is randomly selected for payment. Therefore you should treat each round as if this round completely determines your payment." +


                newline + newline +

                "Please note: Only a single round (from all parts combined) will be selected for payment and your payment will be determined only after completion of all 4 parts of the experiment. " + newline + newline + "Tokens are valued at the following conversion rate: 2 tokens = $1 (except in the 6 accounts treatment where 1 token = $1)." + newline +

                newline + newline + "Part 1:" + newline + newline + newline +  //bold

                "In Part 1 of the experiment you will be presented with 10 independent allocation problems. In each problem you have to decide how to allocate your income (denominated in "+ "\"lab currency\"" + ") between the different accounts. Generally, the cost of buying 1 token from different accounts will vary. The accounts will always be ordered such that the cost of buying a token (token's price) in Account 1 will be smaller (or equal) to the cost of buying a token in Account 2, and so forth. So buying a token in Account 6 is always the most expensive, while buying a token in Account 1 is always the least expensive. " +
                newline + newline
                +  "To choose an allocation in each round you will use 6 sliders. The leftmost slider controls the number of tokens bought in Account 1, and the rightmost slider controls the number of tokens bought in Account 6. As you move to the right the cost of buying tokens (the tokens' price) increases. The total income available in the round is displayed in the box " + "\"Total Income\"" + ", and the price of buying a token in each account is displayed above the slider. " + newline + newline +


                "To choose how many tokens you want to hold in each account you must drag each slider to the desired level in order: from leftmost (Account 1) to the rightmost (Account 6) slider. Note that when you determine the amount of tokens you would like to hold in a specific account (by dragging the slider), the number of tokens, the total cost of the tokens allocated to this account and the remaining income if this allocation is chosen are displayed at the bottom of the screen. After you " + "\"drop\"" + " the slider to its desired location, the number of tokens you bought in that account is displayed above the slider and the slider to its right is immediately adjusted to reflect the maximum amount of tokens you can buy in the next account. The interface also does not allow you to buy more tokens in an account in which the price of tokens is higher (to the right). You must drag and drop the slider in order to record the number of tokens you would like to hold in the next account." + newline + newline +


                "If the "+ "\"Remaining Income\"" + " equals 0 (or very close to 0) you have two options:  " + newline + newline +

                "1.\tYou can click " + "\"Reset Allocation\"" + " to start again (note that the sliders are temporarily parked at the same location as before, but this is only for your convenience and to remind you what was the previous allocation you considered)." + newline + newline +

                "2.\tYou can click " + "\"Submit\"" + ", confirm and move on to the next round. If you decide not to confirm your allocation, you can reset it at and re-allocate your income. " +


                //icon2

                "If the " + "\"Remaining Income\"" + " is positive after you purchased tokens in all the accounts then you will not be able to submit (if you try you will get an error message). You will have to reset the allocation and choose a different allocation." + newline + newline +

                //image	3
                //icon3

               "Note that for your convenience, if you click " + "\"Equal holdings\"" + " the computer automatically buys an equal number of tokens in all the accounts. This allocation guarantees that if this round is selected for payment, which account is selected will not affect your payment. However, it does not allow you the flexibility to buy more tokens in accounts in which the tokens are cheaper, so you may end up with a small and equal number of tokens in all accounts. You can then click " + "\"Reset Allocation\"" + " and adjust the " + "\"equal holdings\"" + " allocation from that point (again, start from the leftmost and move to the right) or just " + "\"submit\"" + " it. " + newline + newline +




                "There is no limit how many times you can click the " +"\"Reset Allocation\"" + ", and you do not face a time limit to complete each or all allocations." + newline + newline +





                "After you submitted your allocation and confirmed your decision you will face another allocation decision. In each decision problem the token prices in the 6 accounts will be generally different." + newline + newline +




               "Before making allocation decisions that may affect your payment from this experiment, you will be given an opportunity to practice in 4 practice rounds. You can play with all the options in the interface and your allocation will not be recorded and cannot affect your payment."
                + newline + newline +
                "Calculation of Payment " + newline + newline +
                "Once you completed Stage 4 you will be able to view all 20 allocations by clicking each allocation. Click " + "\"End Experiment\"" + "  and raise your hand. An experiment coordinator will approach you and assist you in determining the round that counts for payment and the account that is selected for payment. Enter the round number and account number in the appropriate boxes and click confirm. You total payment from the experiment (in tokens and excluding the show-up payment) will be calculated."
                + newline + newline +
                "Fill in your details and payment in the receipt that the experiment coordinator gave you and click " + " \"Exit\"" + " to finish the experiment.";




                //put this into part two







        setLayout(new BorderLayout());
        setTitle("Instructions Window");

        setUndecorated(true);
        getRootPane().setWindowDecorationStyle(JRootPane.NONE);

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setBounds(0, 0, screenSize.width, screenSize.height - 45);

        raisedBorder = new SoftBevelBorder(SoftBevelBorder.RAISED);
        loweredBorder = new SoftBevelBorder(SoftBevelBorder.LOWERED);

        texter = new JTextArea();
        texter.setFont(new Font("Calibri", Font.BOLD, 20));
        texter.setLineWrap(true);
        texter.setBackground(Color.WHITE);
        texter.setForeground(Color.black);
        texter.setWrapStyleWord(true);




        scroller = new JScrollPane(texter);
        texter.setText(initString_part1);
        texter.setCaretPosition(0);
        scroller.setVerticalScrollBarPolicy(
                ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);


        next = new JButton("Continue");
        next.setBorder(raisedBorder);


        legend = new JTextField();
        legend.setBorder(raisedBorder);
        legend.setFont(new Font("Calibri", Font.BOLD, 16));
        legend.setEditable(false);
        legend.setText("Instructions window will remain open during the experiment");

        stage = new JButton("Click to view full instructions");
        stage1 = new JButton("Click to view Stage 1 instructions");
        stage2 = new JButton("");
        stage3 = new JButton("");
        stage4 = new JButton("");


        stg1 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JButton source = (JButton) e.getSource();

                if (source == stage){
                    texter.setText(initString_part1);
                    texter.setCaretPosition(0);
                }

                if(source == stage1){
                    texter.setText(stager1);
                    texter.setCaretPosition(0);
                }
//        if(source == stage2){
//          texter.setText(stager2);
//          texter.setCaretPosition(0);
//        }
//
//        if(source == stage3) {
//          texter.setText(stager3);
//          texter.setCaretPosition(0);
//        }
//
//        if(source == stage4){
//          texter.setText(stager4);
//          texter.setCaretPosition(0);
//        }

                if(source == next){
                    //lauch this at the end of test rounds and here launch some test stuff

                    params = new parameters();
                    testClass test = new testClass(1);
                    //uncomment slider to run from stage2 and uncomment phase1 to run from phase1
                    // sliderInterface frame = new sliderInterface(params.getSecurityList(), test.getCurrent(), false, false, false, false, 0, 0.0);
                    phase1TestRounds frame = new phase1TestRounds(params.getSecurityList(), test.getCurrent());
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    frame.setVisible(true);
                    next.setVisible(false);
                }

            }
        };

        buttonPanel = new JPanel(new GridLayout(5, 1, 5, 5));
        buttonPanel.add(stage);
        buttonPanel.add(stage1);
        buttonPanel.add(stage2);
        buttonPanel.add(stage3);
        buttonPanel.add(stage4);

        stage.addActionListener(stg1);
        stage1.addActionListener(stg1);
        stage2.addActionListener(stg1);
        stage3.addActionListener(stg1);
        stage4.addActionListener(stg1);
        next.addActionListener(stg1);


        add(scroller, BorderLayout.CENTER);
        add(next, BorderLayout.SOUTH);
        add(buttonPanel, BorderLayout.WEST);
        add(legend, BorderLayout.NORTH);

        setVisible(true);






    }







    public static void main (String[] args){
        instructions inst = new instructions();

    }



















































}
