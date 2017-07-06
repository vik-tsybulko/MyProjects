package knopki;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.HeadlessException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MainFrame extends JFrame {

	private static final long serialVersionUID = 1L;

	public static void main(String[] args) {
		new MainFrame();
	}
	
	public MainFrame() throws HeadlessException {
		super();
		
		setTitle("Hello");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setBackground(Color.GREEN);
		setSize(500, 400);
		addComponents(getContentPane());
		pack();
		setVisible(true);
	}
	
	private void addComponents(Container contentPanel) {
		contentPanel.add(new JPanel(), BorderLayout.NORTH);
		contentPanel.add(new JButton("HaHa"), BorderLayout.WEST);
		contentPanel.add(new JTextField("Hello"), BorderLayout.SOUTH);
		contentPanel.add(new JTextField("jjj"), BorderLayout.CENTER);
		
		JButton b = new JButton("RURUR", BorderLayout.CENTER);
		b.addActionListener(new ActionListener(){
			public void actionPerforned(ActionEvent e){
				System.out.println("Blablalb");
			}
		});
	}

}
