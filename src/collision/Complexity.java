package collision;

public enum Complexity {
	
	AABB(0),
	OBB(1),
	CONVEX_HULL(2),
	SPECIAL(10);
	
	private int complexity;
	
	private Complexity(int complexity) {
		this.complexity = complexity;
	}
	
	public int getComplexity() {
		return complexity;
	}
	
	public Complexity compare(Complexity left, Complexity right) {
		if(left.complexity > right.complexity) return left;
		return right;
	}

}
