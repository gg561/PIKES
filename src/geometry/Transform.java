package geometry;

import org.joml.Vector3f;

import castable.Directable;
import castable.LocalPositionnable;
import castable.LocalRotationnable;
import castable.Positionnable;
import castable.Rotationnable;
import castable.Scalable;

public class Transform implements Positionnable, Rotationnable, Directable, Scalable, LocalPositionnable, LocalRotationnable {
	
	private Vector3f position;
	private Vector3f rotation;
	private Vector3f scale;
	private Vector3f localPosition;
	private Vector3f localRotation;
	
	private Vector3f forward;
	private Vector3f right;
	private Vector3f up;
	
	public Transform() {
		this(new Vector3f(), new Vector3f(), new Vector3f(1), new Vector3f(), new Vector3f(), new Vector3f(0, 0, -1), new Vector3f(1, 0, 0), new Vector3f(0, 1, 0));
	}
	
	public Transform(Vector3f position, Vector3f rotation, Vector3f scale, Vector3f localPosition,
			Vector3f localRotation, Vector3f forward, Vector3f right, Vector3f up) {
		super();
		this.position = position;
		this.rotation = rotation;
		this.scale = scale;
		this.localPosition = localPosition;
		this.localRotation = localRotation;
		this.forward = forward;
		this.right = right;
		this.up = up;
	}

	public Vector3f getPosition() {
		return position;
	}
	
	public void setPosition(Vector3f position) {
		this.position.set(position);
	}
	
	public Vector3f getRotation() {
		return rotation;
	}
	
	public void setRotation(Vector3f rotation) {
		this.rotation.set(rotation);
	}
	
	public Vector3f getScale() {
		return scale;
	}
	
	public void setScale(Vector3f scale) {
		this.scale.set(scale);
	}
	
	public Vector3f getLocalPosition() {
		return localPosition;
	}
	
	public void setLocalPosition(Vector3f localPosition) {
		this.localPosition.set(localPosition);
	}
	
	public Vector3f getLocalRotation() {
		return localRotation;
	}
	
	public void setLocalRotation(Vector3f localRotation) {
		this.localRotation.set(localRotation);
	}
	
	public Vector3f getForward() {
		return forward;
	}
	
	public void setForward(Vector3f forward) {
		this.forward.set(forward);
	}
	
	public Vector3f getRight() {
		return right;
	}
	
	public void setRight(Vector3f right) {
		this.right.set(right);
	}
	
	public Vector3f getUp() {
		return up;
	}
	
	public void setUp(Vector3f up) {
		this.up.set(up);
	}
	
	@Override
	public void resetDirections() {
		// TODO Auto-generated method stub
		Vector3f nil = new Vector3f();
		setForward(nil);
		setRight(nil);
		setUp(nil);
	}
	
	@Override
	public void syncDirections() {
		// TODO Auto-generated method stub
		
	}
	
}
