package mazesearch.cse.miamioh.edu;

public class AStarSquare {

	private double heuristics;
	private int cost = 0;
	private AStarSquare parent;
	private Square current;
	private double totalheuristics;
	public AStarSquare(Maze maze, AStarSquare aStar, Square square, int cost) {
		// TODO Auto-generated constructor stub
		this.cost = cost;
		parent = aStar;
		current = square;
		heuristics = Math.hypot(maze.getGoal().getRow() - current.getRow(), maze.getGoal().getColumn() - current.getColumn());
		totalheuristics = cost + heuristics;
	}
	public AStarSquare getParent(){
		return this.parent;
	}

	public Square getCurrent(){
		return this.current;
	}
	public void setCost(int x){
		cost = x;
	}
	public int getCost(){
		return cost;
	}
	public double getTotalHeuristics(){
		return totalheuristics;
	}

}
