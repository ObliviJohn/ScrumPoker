package Model;

public class Statistics {

	public Double[] getStats(int i, int j){

		int x = i;//handv�rde
		int y = j;//dragv�rde
		
		if(x==0 && y == 0) { // Inga kombinationer
			Double[] odds = new Double[] {42.3d, 4.8d, 2.1d, 0.39d, 0.20d, 0.14d, 0.024d, 0.0014d, 0.00015d};
			return odds;
		}
		else if(x==1 && y == 0) {	// Par
			Double[] odds = new Double[] {0d, 15.8, 11.4, 0d, 0d, 1.0, 0.28, 0d, 0d};
			return odds;
		}
		else if(x==2 && y == 0) { // Tv� Par
			Double[] odds = new Double[] {0d, 0d, 0d, 0d, 0d, 8.5, 0d, 0d, 0d};
			return odds;
		}
		else if(x==3 && y == 0) { // Triss
			Double[] odds = new Double[] {0d, 0d, 0d, 0d, 0d, 6.1, 4.3, 0d, 0d};
			return odds;
		}
		else if(x==0 && y==1) { // H�lstege
			Double[] odds = new Double[] {25.5d, 0d, 0d, 8.5d, 0d, 0d, 0d, 0d, 0d};
			return odds;
		}
		else if(x==0 && y==2) { // �ppet stegdrag
			Double[] odds = new Double[] {25.5d, 0d, 0d, 17.0d, 0d, 0d, 0d, 0d, 0d};
			return odds;
		}
		else if(x==0 && y==3) { // F�rgdrag
			Double[] odds = new Double[] {0d, 0d, 0d, 0d, 19.1d, 0d, 0d, 0d, 0d};
			return odds;
		}
		else if(x==0 && y==4) { // Kombinerat drag h�lstegdrag och f�rgdrag
			Double[] odds = new Double[] {25.5d, 0d, 0d, 8.5d, 19.1d, 0d, 0d, 0d, 0d};
			return odds;
		}
		else if(x==0 && y==5) { // Kombinerat �ppet stegdrag och f�rgdrag
			Double[] odds = new Double[] {25.5d, 0d, 0d, 17.0d, 19.1d, 0d, 0d, 0d, 0d};
			return odds;
		}
		else if(x==1 && y==1) {
			Double[] odds = new Double[] {0d, 0d, 0d, 8.5d, 0d, 0d, 0d, 0d, 0d};
			return odds;
		}
		else if(x==1 && y==2) {
			Double[] odds = new Double[] {0d, 0d, 0d, 17.0d, 0d, 0d, 0d, 0d, 0d};
			return odds;
		}		
		else if(x==1 && y==3) {
			Double[] odds = new Double[] {0d, 0d, 0d, 0d, 19.1d, 0d, 0d, 0d, 0d};
			return odds;
		}		
		else if(x==1 && y==4) {
			Double[] odds = new Double[] {0d, 0d, 0d, 8.5d, 19.1d, 0d, 0d, 0d, 0d};
			return odds;
		}		
		else if(x==1 && y==5) {
			Double[] odds = new Double[] {0d, 0d, 0d, 17.0d, 19.1d, 0d, 0d, 0d, 0d};
			return odds;
		}		
		else {
			Double[] odds = new Double[] {0d, 0d, 0d, 0d, 0d, 0d, 0d, 0d, 0d};
			return odds;
		}
	}
}