package mazesearch.cse.miamioh.edu;

import java.util.*;


public class BreadthFirstSearch extends SearchStrategy {

	public BreadthFirstSearch(Maze maze) {
		super(maze);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void solve() {
		explored.add(maze.getStart());
		Queue<ParentSquare> frontier = new LinkedList<ParentSquare>();

		frontier.add(new ParentSquare(maze.getStart(), null));
		Square currentSquare;
		ParentSquare currentParent;
		
		while (frontier.peek() != null) {
			// goal found
			if (frontier.peek().getCurrent().equals(maze.getGoal()) ) {
				ParentSquare s = frontier.remove();	
				
				//add all of the parent to path, then reverse it
				while(s.getParent() != null){
					path.add(s.getCurrent());
					s = s.getParent();	
				}
				Collections.reverse(path);
				return;
			}
			
			currentParent = frontier.remove();
			currentSquare = currentParent.getCurrent();
			explored.add(currentSquare);

			// check square one row up
			Square next = new Square(currentSquare.getRow() + 1, currentSquare.getColumn());
			if (!maze.isBlocked(next) && !explored.contains(next)) {
				frontier.add(new ParentSquare(next, currentParent));
				explored.add(next);
			}

			// check square one row down
			next = new Square(currentSquare.getRow() - 1, currentSquare.getColumn());
			if (!maze.isBlocked(next)&& !explored.contains(next)) {
				frontier.add(new ParentSquare(next, currentParent));
				explored.add(next);
			}

			// check square one col up
			next = new Square(currentSquare.getRow(), currentSquare.getColumn()+1);
			if (!maze.isBlocked(next)&& !explored.contains(next)) {
				frontier.add(new ParentSquare(next, currentParent));
				explored.add(next);
			}

			// check square one col down
			next = new Square(currentSquare.getRow(), currentSquare.getColumn()-1);
			if (!maze.isBlocked(next)&& !explored.contains(next)) {
				frontier.add(new ParentSquare(next, currentParent));
				explored.add(next);
			}
		}

	}
	
	

}
