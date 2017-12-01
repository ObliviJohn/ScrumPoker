package videopoker;


public class Statistics {
	
	Double[] getStats(){
		Hand h = new Hand();
		int x = h.getVal();
		
		
		if(x==0) {
			Double[] odds = new Double[] {42.3d, 4.8d, 2.1d, 0.39d, 0.20d, 0.14d, 0.024d, 0.0014d, 0.00015d};
			return odds;
		}
		else if(x==1) {
			Double[] odds = new Double[] {0d, 3.26, 6.4, 0d, 0d, 0.3, 0.072, 0d, 0d};
			return odds;
		}
		else if(x==2) {
			Double[] odds = new Double[] {0d, 0d, 0d, 0d, 0d, 8.5, 0d, 0d, 0d};
			return odds;
		}
		else if(x==3) {
			Double[] odds = new Double[] {0d, 0d, 0d, 0d, 0d, 6.7, 4.3, 0d, 0d};
			return odds;
		}
		else{
			Double[] odds = new Double[] {0d, 0d, 0d, 0d, 0d, 0d, 0d, 0d, 0d};
			return odds;
		}
		
		
	}
}
