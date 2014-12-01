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

    private static JTextField textField;
    private static JTextField textField2;
    private static JTextField textField3;
    private static JTextField textField4;
    private static JTextField textField5;
    private static ChangeListener changelistener;


    public sliderInterface(List<Share> shares) {
      setLayout(new BorderLayout());
      setTitle("Slider Interface");
      setSize(1000, 500);

      panel2 = new JPanel();


      panel2.setLayout(new BorderLayout());

      panel = new JPanel();
      panel.setLayout(new GridLayout(1, shares.size()));
      label = new JLabel("Securities");
      panel.add(label);


      panel3 = new JPanel();

      panel3.setLayout(new GridLayout(1, shares.size()));
      textField = new JTextField();
      textField2 = new JTextField();
      textField3 = new JTextField();
      textField4 = new JTextField();
      textField5 = new JTextField();

      panel3.add(textField);
      panel3.add(textField2);
      panel3.add(textField3);

      panel3.add(textField4);
      panel3.add(textField5);


      panel2.add(panel, BorderLayout.SOUTH);
      panel2.add(panel3, BorderLayout.CENTER);
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