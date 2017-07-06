import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import javax.swing.text.BadLocationException;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleContext;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static java.awt.Color.red;


/**
 * Created by Viktor on 21.12.2016.
 */
public class View extends JFrame {
    JButton buttonFind;
    JButton buttonNext;
    JButton buttonPrevious;
    JLabel labelInputFindText;
    JLabel labelMatchesFound;
    JTextField textInputFindText;
    JTextField textField2;
    JTextPane textPane = new JTextPane();
    JScrollPane scrollPane = new JScrollPane(textPane);
    String newline = "\n";
    String matches = "Matches Found: ";

    public View (){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Finder");
        setBounds(10, 10, 600, 400);

        Box findBox = Box.createHorizontalBox();

        labelInputFindText = new JLabel("Input Find Word");
        findBox.add(labelInputFindText);
        findBox.add(Box.createHorizontalStrut(6));

        textInputFindText = new JTextField("Enter your word", 20);
        textInputFindText.setPreferredSize(new Dimension(200, 20));
        textInputFindText.setMaximumSize(new Dimension(200, 20));
        findBox.add(textInputFindText);
        findBox.add(Box.createHorizontalStrut(12));

        buttonFind = new JButton("Find");
        buttonFind.setPreferredSize(new Dimension(80, 25));
        buttonFind.setMinimumSize(new Dimension(80, 25));
        buttonFind.addActionListener(new ButtonFind());
        findBox.add(buttonFind);


        Box nextPrevBox = Box.createHorizontalBox();
        nextPrevBox.add(Box.createVerticalStrut(12));

        buttonNext = new JButton("Next");
        buttonNext.setPreferredSize(new Dimension(80, 25));
        buttonNext.setMinimumSize(new Dimension(80, 25));
        nextPrevBox.add(buttonNext);
        nextPrevBox.add(Box.createHorizontalStrut(12));

        buttonPrevious = new JButton("Previous");
        buttonPrevious.setPreferredSize(new Dimension(100, 25));
        buttonPrevious.setMinimumSize(new Dimension(100, 25));
        nextPrevBox.add(buttonPrevious);

        Box matchesFound = Box.createHorizontalBox();
        matchesFound.add(Box.createVerticalStrut(12));

        labelMatchesFound = new JLabel(matches);
        matchesFound.add(labelMatchesFound);
        matchesFound.add(Box.createHorizontalStrut(6));

        Box textPaneBox = Box.createHorizontalBox();
        textPaneBox.add(Box.createVerticalStrut(12));
        textPane.setText("How to use my planet\ni go to the sea\nhow many");
        textPane.setPreferredSize(new Dimension(600, 400));
        textPane.setMaximumSize(new Dimension(600, 400));
        textPaneBox.add(textPane);
        scrollPane.setPreferredSize(new Dimension(20, 400));
        scrollPane.setMaximumSize(new Dimension(20, 400));
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        textPaneBox.add(scrollPane);


        Box mainBox = Box.createVerticalBox();
        mainBox.setBorder(new EmptyBorder(12, 12, 12, 12));
        mainBox.add(findBox);
        mainBox.add(Box.createVerticalStrut(12));
        mainBox.add(nextPrevBox);
        mainBox.add(Box.createVerticalStrut(12));
        mainBox.add(matchesFound);
        mainBox.add(textPaneBox);


        setContentPane(mainBox);
        pack();
        setVisible(true);

        String initDoc = "How to use my planet\ni go to the sea\nhow many";
    }
    public class ButtonFind implements ActionListener{

        public void actionPerformed(ActionEvent e) {


            String textFind = textInputFindText.getText();
            String textOrigin = textPane.getText();
            String textNew = " ";
            String[] lines = textOrigin.split("\n");
            int i1 = 1;
            int povtor = 0;
            for (String line : lines){
                String[] words = line.split(" ");
                int j = 1;
                for (String word : words){
                    if (word.equalsIgnoreCase(textFind)){
                        textNew += word + " № строки " + i1 + " № слова " + j;
                        povtor++;
                    }
                    j++;
                }
                i1++;
            }

            textPane.setCaretPosition(textOrigin.length());

            textPane.replaceSelection("\n");
            textPane.replaceSelection(textNew);
            matches += Integer.toString(povtor);



        }

    }

}
