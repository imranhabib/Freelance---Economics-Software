package project;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.SoftBevelBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by ihabib on 2/19/2015.
 */
public class instructions2 extends JFrame{
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



    public instructions2(){


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
        stager2 = "Psrt 2: " +newline + newline +  "In this part you are asked to design a rule that will determine the allocation of your income among the different accounts in 10 rounds that are similar to Part 1 (but the prices are different). The rule you design will be applied to various scenarios BEFORE you know exactly the cost of buying tokens in the different accounts. \n" +
                newline +  "You have three degrees of freedom in designing your best rule, and once you decide on it, the rule will be applied to 10 different scenarios (in which the token prices of different account vary) and will automatically generate allocations.\n" +
                newline + "1.\tSet a minimum number of tokens to be purchased in every account. On the one hand, this allows you to guarantee that in the round that is selected for payment you will receive a minimum income for sure (independently of which account is selected for payment). On the other hand, if the cost of buying tokens in one of the accounts is high then the cost of achieving this minimal number of tokens could be high. If the cost of purchasing the minimal number of tokens you specified in each account is higher than the income in the round, the rule will be applied by buying an equal number of token in each account.\n" +
                newline +   "2.\tAfter you have bought the minimum number tokens in each account on which you decided in step (1), you should decide what proportion (between 0% and 100%) of your residual income you would like to allocate to buy tokens in each account. For example, you can decide to allocate equal proportions of your residual income to each account; or you may want to allocate a higher proportion of your residual income to accounts where the cost of tokens is low than to accounts where the tokens' price is high; or you may want to follow an opposite strategy. Note that the allocation rule here depends only on the order of tokens' prices (cost of tokens) in the accounts, not on whether the prices are close to each other or not. Remember that in order for the rule to be valid you must allocate 100% of your income to the various accounts. For your convenience, at the bottom of the screen the accumulated percentage of income is continuously calculated. Once you drop a slider the share of the residual income that will be spent in this account is displayed above the slider. You are free to determine the order in which you decide on the share of income you would like to hold in each account, but once you arrive to the rightmost slider (that corresponds to the account with the highest token price) the program checks that you indeed allocated 100% of your income. If you did not, the program will give you a warning message. Similarly, if you allocated more than 100% of your income, you will receive a warning message. You can always reset the sliders by clicking " + "\"Reset Sliders\"" + ".\n" +
                newline +   "3.\tYou may want to design your allocation rule such that if the cost of tokens in an account is not much higher than the cost of tokens in Account 1 (where the price of tokens is lowest) the rule will buy an equal number of tokens in the two accounts. You can achieve that by setting a " + "\"minimal ratio\"" + "such that if the ratio of tokens' prices in the two accounts is not higher than this ratio then the allocation rule will buy an equal number of tokens in the two accounts. For example, suppose that the price of tokens in Account 1 equals 5 and the price of tokens in another account equals 7. If you set the " + "\"minimal ratio\"" + " to 1.5, the allocation rule will buy an equal number of tokens in the two accounts (since 7/5=1.4<1.5). However, if you set the minimal ratio to be equal to 1.25, the allocation rule will buy tokens in the two accounts according to steps (1) and (2) above. Obviously, as the " + "\"minimal ratio\"" + " increases, the allocation rule will pool more accounts together and the rule will become less " + "\"price sensitive\"" + ".\n" +
                newline + "After you have decided on these 3 parameters, submitted and confirmed your choices, you will see what allocations are generated in 4 samples scenarios (that do not count for payment). Then you will be given an opportunity to adjust the allocation rule you designed, and if you choose to do so - see how the new rule performs. Altogether you are given at most 4 opportunities to adjust the allocation rule. You can compare how the different rules perform on the sample scenarios, and then you should choose one of the allocation rules to apply to 10 new scenarios you have not encountered before. You do so by clicking " + "\"select this allocation rule\"" + ". Note that if you make the fourth adjustment, it will become the " + "\"final rule\"" + " and you will not be able to choose previous allocation rules.\n" +
                newline + "Following the application of the rule, you could view the different allocations generated for the various scenarios of token prices in the different accounts.";
      //  stager3 = "Instructions for the third stage will go here";
        //stager4 = "Instructions for the fourth stage will go here";



        initString_part1 =  "Welcome" + newline + newline+  //bold
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

                "As in all experiments in Economics, the procedures are described fully and all payments are real." + newline + newline +

                "Study Procedures: " + //bold
                newline+ newline + newline + "This is an experiment in individual decision making. The study has four parts and the instructions for the later parts will follow the completion of Part 1. Before making decisions that may affect your payment, you will be given an opportunity to practice. The practice rounds will allow you to familiarize yourself with the experimental interface and ask any questions you may have." + newline +
                newline +
                " You will be presented with 20 independent decision problems that share a common form. In each round you will be decide how to allocate your income of 100 (denominated in " + "\"lab currency\"" + ") between 6 accounts. In each account you can buy tokens, which will be exchanged for money at the end of the experiment.  The price of buying tokens may vary in different account." + newline + newline +


                "One round will be selected for payment at the conclusion of the experiment. Each round is equally likely to be chosen. Your payment is determined by the number of tokens you hold in a randomly selected account in that round. At the end of the experiment, you will roll a fair die to randomly select one of the 6 accounts. Each account is equally likely to be chosen. That is, there is a 1/6 (1/3 or 1/2) chance that each one of the accounts will be chosen. " +

                newline + newline +

                "You will be paid only according to the amount of tokens you hold in the account that is randomly chosen in the round that is randomly selected for payment. Therefore you should treat each round as if this round completely determines your payment." +


                newline + newline +

                "Please note: Only a single round (from all parts combined) will be selected for payment and your payment will be determined only after completion of all 4 parts of the experiment. " + newline + newline + "Tokens are valued at the following conversion rate: 2 tokens = $1 (except in the 6 accounts treatment where 1 token = $1)." + newline +

                newline + newline + "Part 1:" + newline + newline +  newline + //bold

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




                "Before making allocation decisions that may affect your payment from this experiment, you will be given an opportunity to practice in 4 practice rounds. You can play with all the options in the interface and your allocation will not be recorded and cannot affect your payment." + newline + newline + newline + "Part 2: " + newline + newline + newline+   "In this part you are asked to design a rule that will determine the allocation of your income among the different accounts in 10 rounds that are similar to Part 1 (but the prices are different). The rule you design will be applied to various scenarios BEFORE you know exactly the cost of buying tokens in the different accounts. \n" +
                newline +  "You have three degrees of freedom in designing your best rule, and once you decide on it, the rule will be applied to 10 different scenarios (in which the token prices of different account vary) and will automatically generate allocations.\n" +
                newline + "1.\tSet a minimum number of tokens to be purchased in every account. On the one hand, this allows you to guarantee that in the round that is selected for payment you will receive a minimum income for sure (independently of which account is selected for payment). On the other hand, if the cost of buying tokens in one of the accounts is high then the cost of achieving this minimal number of tokens could be high. If the cost of purchasing the minimal number of tokens you specified in each account is higher than the income in the round, the rule will be applied by buying an equal number of token in each account.\n" +
                newline +   "2.\tAfter you have bought the minimum number tokens in each account on which you decided in step (1), you should decide what proportion (between 0% and 100%) of your residual income you would like to allocate to buy tokens in each account. For example, you can decide to allocate equal proportions of your residual income to each account; or you may want to allocate a higher proportion of your residual income to accounts where the cost of tokens is low than to accounts where the tokens' price is high; or you may want to follow an opposite strategy. Note that the allocation rule here depends only on the order of tokens' prices (cost of tokens) in the accounts, not on whether the prices are close to each other or not. Remember that in order for the rule to be valid you must allocate 100% of your income to the various accounts. For your convenience, at the bottom of the screen the accumulated percentage of income is continuously calculated. Once you drop a slider the share of the residual income that will be spent in this account is displayed above the slider. You are free to determine the order in which you decide on the share of income you would like to hold in each account, but once you arrive to the rightmost slider (that corresponds to the account with the highest token price) the program checks that you indeed allocated 100% of your income. If you did not, the program will give you a warning message. Similarly, if you allocated more than 100% of your income, you will receive a warning message. You can always reset the sliders by clicking " + "\"Reset Sliders\"" + ".\n" +
                newline +   "3.\tYou may want to design your allocation rule such that if the cost of tokens in an account is not much higher than the cost of tokens in Account 1 (where the price of tokens is lowest) the rule will buy an equal number of tokens in the two accounts. You can achieve that by setting a " + "\"minimal ratio\"" + "such that if the ratio of tokens' prices in the two accounts is not higher than this ratio then the allocation rule will buy an equal number of tokens in the two accounts. For example, suppose that the price of tokens in Account 1 equals 5 and the price of tokens in another account equals 7. If you set the " + "\"minimal ratio\"" + " to 1.5, the allocation rule will buy an equal number of tokens in the two accounts (since 7/5=1.4<1.5). However, if you set the minimal ratio to be equal to 1.25, the allocation rule will buy tokens in the two accounts according to steps (1) and (2) above. Obviously, as the " + "\"minimal ratio\"" + " increases, the allocation rule will pool more accounts together and the rule will become less " + "\"price sensitive\"" + ".\n" +
                newline + "After you have decided on these 3 parameters, submitted and confirmed your choices, you will see what allocations are generated in 4 samples scenarios (that do not count for payment). Then you will be given an opportunity to adjust the allocation rule you designed, and if you choose to do so - see how the new rule performs. Altogether you are given at most 4 opportunities to adjust the allocation rule. You can compare how the different rules perform on the sample scenarios, and then you should choose one of the allocation rules to apply to 10 new scenarios you have not encountered before. You do so by clicking " + "\"select this allocation rule\"" + ". Note that if you make the fourth adjustment, it will become the " + "\"final rule\"" + " and you will not be able to choose previous allocation rules.\n" +
                newline + "Following the application of the rule, you could view the different allocations generated for the various scenarios of token prices in the different accounts."

         + newline + newline + "Calculation of Payment " + newline + newline +
                "Once you completed Stage 4 you will be able to view all 20 allocations by clicking each allocation. Click " + "\"End Experiment\"" + "  and raise your hand. An experiment coordinator will approach you and assist you in determining the round that counts for payment and the account that is selected for payment. Enter the round number and account number in the appropriate boxes and click confirm. You total payment from the experiment (in tokens and excluding the show-up payment) will be calculated."
                + newline + newline +
                "Fill in your details and payment in the receipt that the experiment coordinator gave you and click " + " \"Exit\"" + " to finish the experiment.";




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
        texter.setForeground(Color.BLACK);
        texter.setWrapStyleWord(true);




        scroller = new JScrollPane(texter);
        texter.setText(initString_part1);
        texter.setCaretPosition(0);
        scroller.setVerticalScrollBarPolicy(
                ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);


        next = new JButton("Continue");
        next.setBorder(raisedBorder);
        next.setVisible(false);


        legend = new JTextField();
        legend.setBorder(raisedBorder);
        legend.setFont(new Font("Calibri", Font.BOLD, 16));
        legend.setEditable(false);
        legend.setText("Instructions window will remain open during the experiment");

        stage = new JButton("Click to view full instructions");
        stage1 = new JButton("Click to view Stage 1 instructions");
        stage2 = new JButton("Click to view Stage 2 instructions");
        stage3 = new JButton();
        stage4 = new JButton();


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
                if(source == stage2){
                    texter.setText(stager2);
                    texter.setCaretPosition(0);
                }

//        if(source == stage3) {
//          texter.setText(stager3);
//          texter.setCaretPosition(0);
//        }
//
//        if(source == stage4){
//          texter.setText(stager4);
//          texter.setCaretPosition(0);
//        }


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
        instructions2 inst = new instructions2();

    }



















































}
