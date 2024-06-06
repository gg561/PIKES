package maths;

import org.joml.Vector3f;

public class Segment {
	
	private Vector3f begin;
	private Vector3f end;
	private Vector3f diff;
	
	public Segment(Vector3f begin, Vector3f end) {
		this.begin = begin;
		this.end = end;
		calculateDiff();
	}
	
	public void setBegin(Vector3f begin) {
		this.begin = begin;
		calculateDiff();
	}
	
	public void setEnd(Vector3f end) {
		this.end = end;
		calculateDiff();
	}
	
	public void calculateDiff() {
		diff = end.sub(begin, new Vector3f());
	}

}
