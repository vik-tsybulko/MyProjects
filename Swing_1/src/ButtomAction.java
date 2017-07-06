import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Icon;

public class ButtomAction extends AbstractAction {
	
	private static final long serialVersionUID = 1L;

	
	public ButtomAction(String arg0, Icon arg1) {
		super(arg0, arg1);
		// TODO Auto-generated constructor stub
	}


	public ButtomAction(String arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		
		System.out.println("action clicked");
		
	}
	
}