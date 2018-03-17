package mazesearch.cse.miamioh.edu;

import java.util.List;

public class SearchMain {

	public static void main(String args[]) {
		  Maze m = new Maze("sample-input/maze3.txt");
		  SearchStrategy breadhFirstSearch  = new BreadthFirstSearch(m);
		  
		  System.out.println(m.toString());
		  
		  System.out.println("BFS Search");
		  printActions(breadhFirstSearch.path);
		  System.out.println("path cost: "+ breadhFirstSearch.path.size());
		  System.out.println("explored: "+ breadhFirstSearch.explored.size());

		  System.out.println();
		  	
		  System.out.println("Depth First Search");
		  SearchStrategy depthFirstSearch  = new DepthFirstSearch(m);
		  printActions(depthFirstSearch.path);
		  System.out.println("path cost: "+ depthFirstSearch.path.size());
		  System.out.println("explored: "+ depthFirstSearch.explored.size());
		  
		  
		  System.out.println();
		  
		  System.out.println("A* Search");
		  SearchStrategy aStar = new AStar(m);
		  printActions(aStar.path);
		  System.out.println("path cost: "+ aStar.path.size());
		  System.out.println("explored: "+ aStar.explored.size());

	  }

	public static void printActions(List<Square> path) {
		  for(int i = 0; i < path.size(); i++){
			  if(i == 0){
				  System.out.print("START " + path.get(i) + " ,");
			  }else{
				  if( path.get(i).getRow() < path.get(i-1).getRow()){
					  System.out.print("UP " + path.get(i)+ " ,");
				  }else if( path.get(i).getRow() > path.get(i-1).getRow()){
					  System.out.print("DOWN " + path.get(i));
				  }
				  
				  if( path.get(i).getColumn() > path.get(i-1).getColumn()){
					  System.out.print("RIGHT " + path.get(i)+ " ,");
				  }else if( path.get(i).getColumn() < path.get(i-1).getColumn()){
					  System.out.print("LEFT " + path.get(i)+ " ,");
				  }
			  }
		  }
		  System.out.println();
	}
}
