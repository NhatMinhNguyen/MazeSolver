package mazesearch.cse.miamioh.edu;

import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class AStar extends SearchStrategy {

	public AStar(Maze maze) {
		super(maze);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void solve() {
		// TODO Auto-generated method stub

		Comparator<AStarSquare> heuristicsCompare = new CompareHeuristics();
		PriorityQueue<AStarSquare> queue = new PriorityQueue<AStarSquare>(heuristicsCompare);
		
		
		explored.add(maze.getStart());
		
		queue.add(new AStarSquare(maze,null, maze.getStart(), 0 ));
		
		while(!queue.isEmpty()){
			AStarSquare current = queue.remove();
			
			if(current.getCurrent().equals(maze.getGoal())){
				AStarSquare s = current;
				while(s.getParent() != null){
					path.add(s.getCurrent());
					s = s.getParent();	
				}
				Collections.reverse(path);
				return;
			}
			
			Square next = new Square(current.getCurrent().getRow() + 1,current.getCurrent().getColumn());
			if (!maze.isBlocked(next) && !explored.contains(next)) {
				queue.add(new AStarSquare(maze,current, next, current.getCost()+1));
				explored.add(next);
			}
			next = new Square(current.getCurrent().getRow() - 1,current.getCurrent().getColumn());
			if (!maze.isBlocked(next) && !explored.contains(next)) {
				queue.add(new AStarSquare(maze,current, next, current.getCost()+1));
				explored.add(next);
			}
			next = new Square(current.getCurrent().getRow(),current.getCurrent().getColumn()+1);
			if (!maze.isBlocked(next) && !explored.contains(next)) {
				queue.add(new AStarSquare(maze,current, next, current.getCost()+1));
				explored.add(next);
			}
			next = new Square(current.getCurrent().getRow(),current.getCurrent().getColumn()-1);
			if (!maze.isBlocked(next) && !explored.contains(next)) {
				queue.add(new AStarSquare(maze,current, next, current.getCost()+1));
				explored.add(next);
			}
			
			
		}
		

	}

}
