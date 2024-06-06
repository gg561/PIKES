package collision;

import org.joml.Vector3f;
import org.joml.Vector2f;

import actors.Movable;
import forceables.NewtonianBody;
import geometry.Edge;
import geometry.Volume;

public abstract class SATCollider extends OrthodoxCollider {
	
	protected Volume collisionVolume;

	public SATCollider(NewtonianBody bounded, Complexity complexity, Vector3f bounds) {
		super(bounded, complexity, bounds);
		// TODO Auto-generated constructor stub
	}
	
	public boolean contain(Vector3f vector) {
		return false;
	}
	
	public static boolean intersects(Volume left, Volume right) {
		int i = 0;
		for(Edge collisionEdge : left.getEdges()) {
			if(!overlaps(collisionEdge.getDirection(), left.getVertices(), right.getVertices())) {
				System.out.println("left : " + i + " " + collisionEdge.getDirection());
				return false;
			}
			i++;
		}
		for(Edge collisionEdge : right.getEdges()) {
			if(!overlaps(collisionEdge.getDirection(), left.getVertices(), right.getVertices())) {
				System.out.println("right : " + i);
				return false;
			}
			i++;
		}
		for(Edge leftEdge : left.getEdges()) {
			System.out.println("l");
			for(Edge rightEdge : right.getEdges()) {
				System.out.println("r");
				Vector3f cross = leftEdge.getDirection().cross(rightEdge.getDirection(), new Vector3f());
				if(cross.x != 0 || cross.y != 0 || cross.z != 0) {
					System.out.println(cross);
					if(!overlaps(cross, left.getVertices(), right.getVertices())) {
						return false;
					}
				}
			}
		}
		return true;
	}
	
	public static Vector2f SAT(Vector3f normal, Vector3f[] pts) {
		Vector2f projected = new Vector2f(Float.POSITIVE_INFINITY, Float.NEGATIVE_INFINITY);
		for(Vector3f point : pts) {
			float dotVal = point.dot(normal);
			if(dotVal < projected.x) projected.x = dotVal;
			if(dotVal > projected.y) projected.y = dotVal;
		}
		return projected;
	}
	
	public static boolean overlaps(Vector3f normal, Vector3f[] left, Vector3f[] right) {
		Vector2f leftProjected = SAT(normal, left);
		Vector2f rightProjected = SAT(normal, right);
		System.out.println(normal + " " + leftProjected + " " + rightProjected);
		return isBetweenOrdered(leftProjected.x, rightProjected) || isBetweenOrdered(rightProjected.x, leftProjected) || isBetweenOrdered(leftProjected.y, rightProjected) || isBetweenOrdered(rightProjected.y, leftProjected);
	}
	
	private static boolean isBetweenOrdered(float val, Vector2f range) {
		return range.x <= val && val <= range.y;
	}

}
