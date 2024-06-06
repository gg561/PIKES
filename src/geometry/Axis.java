package geometry;

import org.joml.Vector3f;

public class Axis {
	
	private Vector3f direction;
	
	public Vector3f getDirection() {
		return direction;
	}
	
	public void setDirection(Vector3f direction) {
		this.direction.set(direction).normalize();
	}
	
	public void rotate(Vector3f rotation) {
		direction.rotateX(rotation.x);
		direction.rotateY(rotation.y);
		direction.rotateZ(rotation.z);
	}

}
