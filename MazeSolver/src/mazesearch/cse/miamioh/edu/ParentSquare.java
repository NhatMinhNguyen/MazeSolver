package mazesearch.cse.miamioh.edu;

public class ParentSquare {

	private Square current;
	private ParentSquare parent;
	public ParentSquare(Square current, ParentSquare parent) {
		// TODO Auto-generated constructor stub
		this.current = current;
		this.parent = parent;
	}
	public ParentSquare getParent(){
		return this.parent;
	}

	public Square getCurrent(){
		return this.current;
	}
}
