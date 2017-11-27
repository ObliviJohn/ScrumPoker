package poker;

public class Controller {

	private Table table;
	
	public void init() {
		table = new Table(this);
		table.showTable();
	}

}
