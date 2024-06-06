package geometry;

import org.joml.Vector3f;

public class Edge {
	
	private Vector3f direction;
	private Vector3f localDirection;
	private float min, max;
	
	public Edge(Edge edge) {
		this(edge.direction, edge.localDirection, edge.min, edge.max);
	}
	
	public Edge(Vector3f localDirection, float min, float max) {
		this(new Vector3f(localDirection), localDirection, min, max);
	}
	
	public Edge(Vector3f direction, Vector3f localDirection, float min, float max) {
		this.direction = direction;
		this.localDirection = localDirection;
		this.min = min;
		this.max = max;
	}

	public Vector3f getDirection() {
		return direction;
	}
	
	public void setDirection(Vector3f direction) {
		this.direction.set(direction);
	}
	
	public Vector3f getLocalDirection() {
		return localDirection;
	}
	
	public void setLocalDirection(Vector3f localDirection) {
		this.localDirection.set(localDirection);
	}
	
	public float getMin() {
		return min;
	}
	
	public float getMax() {
		return max;
	}
	
	public boolean equals(Object other) {
		if(other instanceof Edge) {
			Edge edge = (Edge) other;
			if(edge.direction.equals(direction)) {
				if(edge.min == min && edge.max == max)
					return true;
			}else if (edge.direction.equals(direction.reflect(direction, new Vector3f()))) {
				if((edge.min == -min && edge.max == -max) || (edge.min == min && edge.max == max))
					return true;
			}
		}
		return false;
	}
	
	public String toString() {
		return "geometry.Edge : { direction : " + direction + ", localDirection : " + localDirection + ", extents : { min :" + min + ", max : " + max +"}}";
	}

}
