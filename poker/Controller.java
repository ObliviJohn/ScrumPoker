package poker;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller {

	private Table table;
	
	public void init() {
		table = new Table(this);
		table.showTable();
		table.account(new accountListener());
	}
}

	class accountListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			Account acc = new Account();
			acc.start();
		}
	}