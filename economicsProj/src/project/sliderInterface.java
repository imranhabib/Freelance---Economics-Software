package project;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.util.*;
import java.util.ArrayList;
import java.util.List;




/**
 * Created by Imran on 2014-11-29.
 */
public class sliderInterface extends JFrame {

    static JSlider slider;
    static JPanel panel;
    static JPanel panel2;
    static JLabel label;
    static JPanel panel3;
    static JPanel panel4;

    static JButton button1;

    private static JTextField textField;
    private static JTextField textField2;
    private static JTextField textField3;
    private static JTextField textField4;
    private static JTextField textField5;
    private static ChangeListener changelistener;

  private final Color blue = Color.BLUE;
  private final Color red = Color.RED;


    public sliderInterface(List<Share> shares) {
      setLayout(new BorderLayout());
      setTitle("Slider Interface");
      setSize(1000, 500);

      int size = shares.size();
      panel2 = new JPanel();


      panel2.setLayout(new BorderLayout());

      panel = new JPanel();
      panel.setLayout(new GridLayout(1, shares.size()));
      panel.setPreferredSize(new Dimension(50, 200));
    // label = new JLabel("Securities");
     // panel.add(label);


      panel3 = new JPanel();

      panel3.setLayout(new GridLayout(1, shares.size()));
      panel3.setPreferredSize(new Dimension(50, 100));

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

      textField.setForeground(blue);
      textField2.setForeground(red);
      textField3.setForeground(blue);
      textField4.setForeground(red);
      textField5.setForeground(blue);




      if(size >= 1) {
        panel3.add(textField);
      }
      if(size >= 2) {
        panel3.add(textField2);
      }
      if(size >= 3) {
        panel3.add(textField3);
      }
      if(size >= 4) {
        panel3.add(textField4);
      }
      if(size >= 5) {
        panel3.add(textField5);
      }


      panel4 = new JPanel();
      button1 = new JButton("Submit");
      button1.setToolTipText("Click to submit allocations");

      panel4.add(button1);


 //you can change the first SOUTH -> NORTH && the first CENTER -> SOUTH to get a different spacing/sizing

      panel2.add(panel, BorderLayout.CENTER);
      panel2.add(panel3, BorderLayout.NORTH);
      panel2.add(button1, BorderLayout.SOUTH);
      add(panel2, BorderLayout.CENTER);
      //add(panel3, BorderLayout.PAGE_START);



        changelistener = new ChangeListener()
        {
            public void stateChanged(ChangeEvent event)
            {
                JSlider source = (JSlider) event.getSource();
               if (!source.getValueIsAdjusting()) {
                 int value = source.getValue();
                 String name = source.getName();
                 if(name.equals("1")){
                   textField.setText("Security # " + source.getName() + " = " + value);
                 }
                 if(name.equals("2")){
                   textField2.setText("Security # " + source.getName() + " = " + value);
                 }
                 if(name.equals("3")){
                   textField3.setText("Security # " + source.getName() + " = " + value);
                 }
                 if (name.equals("4")){
                   textField4.setText("Security # " + source.getName() + " = " + value);
                 }
                 if (name.equals("5")){
                   textField5.setText("Security # " + source.getName() + " = " + value);
                 }
               }

            }
        };

            //create as many slider instances of the size of 'shares'
            //call the addSlider method with the correct param taken from the share object
            for(int i = 0; i < shares.size(); i++){
                addShare(formatSlider(shares.get(i).getPrice(), shares.get(i).getSecurityNumber()), shares.get(i).getIncomeShare(), shares.get(i).getSecurityNumber());
            }

    }


    public void addShare (JSlider slider, float incomeShare, int securityNumber){
        slider.addChangeListener(changelistener);
        JPanel pan = new JPanel();
        pan.add(slider);
        pan.setToolTipText(Float.toString(incomeShare));
        pan.add(new JLabel("Security Number = " + Integer.toString(securityNumber)));
        panel.add(pan);

    }


    public JSlider formatSlider(int price, int number){
        JSlider slider = new JSlider(JSlider.VERTICAL);
        slider.setName(Integer.toString(number));
        slider.setPaintTicks(true);
        slider.setMajorTickSpacing(10);
        slider.setMinorTickSpacing(5);
       // slider.setValue();
        slider.setPaintLabels(true);



        slider.add(new JLabel(Integer.toString(price)));
        return slider;



    }

}