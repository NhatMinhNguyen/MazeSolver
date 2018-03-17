package mazesearch.cse.miamioh.edu;

import java.util.Comparator;

public class CompareHeuristics implements Comparator<AStarSquare>{

	public CompareHeuristics() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public int compare(AStarSquare o1, AStarSquare o2) {
		// TODO Auto-generated method stub
		if(o1.getTotalHeuristics() < o2.getTotalHeuristics()){
			return -1;
		}
		if(o1.getTotalHeuristics() > o2.getTotalHeuristics()){
			return 1;
		}
		return 0;
	}


}
