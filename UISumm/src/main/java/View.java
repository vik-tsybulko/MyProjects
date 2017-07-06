import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 * Created by Viktor on 21.12.2016.
 */
public class View extends JFrame {
    JButton buttonSummm = new JButton("+");
    JButton buttonRazn = new JButton("-");
    JButton buttonUmn = new JButton("*");
    JButton buttonPod = new JButton("/");
    JButton buttonClear = new JButton("Clear");
    JLabel labelNumber1 = new JLabel("Input number 1:");
    JLabel labelNumber2 = new JLabel("Input number 2:");
    JTextField textField = new JTextField(10);
    JTextField textField2 = new JTextField(10);
    JLabel labelResult = new JLabel("Result:  ");
    JLabel result = new JLabel();
    JLabel plus = new JLabel("+");

    public View (){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Summ");
        setBounds(100, 100, 500, 200);

        Box textFieldBox = Box.createHorizontalBox();
        textFieldBox.add(labelNumber1);
        textFieldBox.add(Box.createHorizontalStrut(6));
        textFieldBox.add(textField);
        textFieldBox.add(Box.createHorizontalStrut(12));
        textFieldBox.add(labelNumber2);
        textFieldBox.add(Box.createHorizontalStrut(6));
        textFieldBox.add(textField2);


        Box resultBox = Box.createHorizontalBox();
        result.setEnabled(false);
        resultBox.add(Box.createVerticalStrut(50));
        resultBox.add(labelResult);
        resultBox.add(result);
        resultBox.add(Box.createVerticalStrut(50));


        Box buttonBoxPlusMinus = Box.createHorizontalBox();
        buttonBoxPlusMinus.add(Box.createHorizontalGlue());//прижимает елементы к правому краю(пружина)

        buttonSummm.addActionListener(new ActionButtonSumm());
        buttonSummm.setPreferredSize(new Dimension(50, 25));
        buttonSummm.setMinimumSize(new Dimension(50, 25));
        buttonBoxPlusMinus.add(buttonSummm);
        buttonBoxPlusMinus.add(Box.createHorizontalStrut(12));//делает отступ

        buttonRazn.addActionListener(new ActionButtonRazn());
        buttonRazn.setPreferredSize(new Dimension(50, 25));
        buttonRazn.setMinimumSize(new Dimension(50, 25));
        buttonBoxPlusMinus.add(buttonRazn);
        buttonBoxPlusMinus.add(Box.createHorizontalStrut(12));

        Box buttonBoxUmnPod = Box.createHorizontalBox();
        buttonBoxUmnPod.add(Box.createHorizontalGlue());

        buttonPod.addActionListener(new ActionButtonPod());
        buttonPod.setPreferredSize(new Dimension(50, 25));
        buttonPod.setMinimumSize(new Dimension(50, 25));
        buttonBoxUmnPod.add(buttonPod);
        buttonBoxUmnPod.add(Box.createHorizontalStrut(12));

        buttonUmn.addActionListener(new ActionButtonUmn());
        buttonUmn.setPreferredSize(new Dimension(50, 25));
        buttonUmn.setMinimumSize(new Dimension(50, 25));
        buttonBoxUmnPod.add(buttonUmn);
        buttonBoxUmnPod.add(Box.createHorizontalStrut(12));

        Box buttonBoxClear = Box.createHorizontalBox();
        buttonBoxClear.add(Box.createHorizontalGlue());
        buttonClear.addActionListener(new ActionButtonClear());
        buttonClear.setPreferredSize(new Dimension(112, 25));
        buttonClear.setMinimumSize(new Dimension(112, 25));
        buttonBoxClear.add(buttonClear);
        buttonBoxClear.add(Box.createHorizontalStrut(12));

        Box mainBox = Box.createVerticalBox();
        mainBox.setBorder(new EmptyBorder(12, 12, 12, 12));
        mainBox.add(textFieldBox);
        mainBox.add(resultBox);
        mainBox.add(Box.createVerticalStrut(12));
        mainBox.add(buttonBoxUmnPod);
        mainBox.add(Box.createVerticalStrut(12));
        mainBox.add(buttonBoxPlusMinus);
        mainBox.add(Box.createVerticalStrut(12));
        mainBox.add(buttonBoxClear);

        setContentPane(mainBox);
        pack();
        setVisible(true);


    }
    Logic logic = new Logic();
    private class ActionButtonSumm implements ActionListener{

        public void actionPerformed(ActionEvent e) {
            int summ = logic.summ(Integer.parseInt(textField.getText()), Integer.parseInt(textField2.getText()));
            result.setText(textField.getText() + " + " + textField2.getText() + " = " + String.valueOf(summ));
        }
    }
    private class ActionButtonClear implements ActionListener{

        public void actionPerformed(ActionEvent e) {
            result.setText("");
            textField.setText("");
            textField2.setText("");
        }
    }


    private class ActionButtonRazn implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            int razn = logic.razn(Integer.parseInt(textField.getText()), Integer.parseInt(textField2.getText()));
            result.setText(textField.getText() + " - " + textField2.getText() + " = " + String.valueOf(razn));
        }
    }

    private class ActionButtonPod implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            int pod = logic.pod(Integer.parseInt(textField.getText()), Integer.parseInt(textField2.getText()));
            result.setText(textField.getText() + " / " + textField2.getText() + " = " + String.valueOf(pod));
        }
    }

    private class ActionButtonUmn implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            int umn = logic.umn(Integer.parseInt(textField.getText()), Integer.parseInt(textField2.getText()));
            result.setText(textField.getText() + " * " + textField2.getText() + " = " + String.valueOf(umn));
        }
    }
}
