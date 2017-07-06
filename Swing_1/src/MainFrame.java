import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class MainFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JTextArea area;

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
		//pack();
		setVisible(true);
	}
	
	private void addComponents(Container contentPane) {
		
		contentPane.setLayout(new BorderLayout());
		
		//panelka
		contentPane.add(new JPanel(), BorderLayout.NORTH);
		
		final ButtomAction action = new ButtomAction("click me!!!");
		
		//knopka
		JButton b = new JButton(action);
		contentPane.add(b, BorderLayout.WEST);
		b.addActionListener(new ActionListener() {
		
			//deistviia knopki
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("SUKA");
				area.setText(textField.getText());
				area.setBackground(Color.YELLOW);
				System.out.println(e.getSource());
				action.setEnabled(false);

			}
		});
		
		
		//text
		textField = new JTextField("Hello");
		contentPane.add(textField, BorderLayout.SOUTH);
		
		//okno s textom
		area = new JTextArea("jjj");
		contentPane.add(area, BorderLayout.CENTER);
		area.addPropertyChangeListener("baclground", new PropertyChangeListener() {
			
			//hernia kotorraia ne rabotaet
			@Override
			public void propertyChange(PropertyChangeEvent evt) {
				System.out.println(String.format("Old: %s, New: %s",
				evt.getOldValue(), evt.getNewValue()));

			}
		});
		
		contentPane.add(new JButton(action), BorderLayout.EAST);
		JList<Object> list = new JList<Object>();
		contentPane.add(list, BorderLayout.CENTER);
		
		DefaultListModel<Object> model = new DefaultListModel<Object>();
		list.setModel(model);
		model.addElement("AA");
		model.addElement("BB");
		JComboBox<Object> box = new JComboBox<Object>();
		contentPane.add(new JComboBox<Object>(), BorderLayout.NORTH);
		box.addItem("sdsd");
	}

}
