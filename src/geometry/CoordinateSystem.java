package geometry;

import org.joml.AxisAngle4d;
import org.joml.Quaternionf;
import org.joml.Vector3f;

public class CoordinateSystem {
	
	public static final CoordinateSystem WORLD = new CoordinateSystem(new Vector3f(0, 0, 1), new Vector3f(0, 1, 0), new Vector3f(1, 0, 0));
	
	private Vector3f f, u, r;
	
	public CoordinateSystem() {
		this(WORLD);
	}
	
	public CoordinateSystem(CoordinateSystem system) {
		this(new Vector3f(system.f), new Vector3f(system.u), new Vector3f(system.r));
	}
	
	public CoordinateSystem(Vector3f f, Vector3f u, Vector3f r) {
		this.f = f;
		this.u = u;
		this.r = r;
	}
	
	public Vector3f f() {
		return f;
	}
	
	public Vector3f u() {
		return u;
	}
	
	public Vector3f r() {
		return r;
	}
	
	public void rotate(Vector3f rotation) {
		rotate(rotation, this);
	}
	
	public void rotate(Vector3f rotation, CoordinateSystem dest) {

		f()
		.rotate(new Quaternionf(new AxisAngle4d(rotation.x, 1, 0, 0)))
		.rotate(new Quaternionf(new AxisAngle4d(rotation.y, 0, 1, 0)))
		.rotate(new Quaternionf(new AxisAngle4d(rotation.z, 0, 0, 1)));
		u()
		.rotate(new Quaternionf(new AxisAngle4d(rotation.x, 1, 0, 0)))
		.rotate(new Quaternionf(new AxisAngle4d(rotation.y, 0, 1, 0)))
		.rotate(new Quaternionf(new AxisAngle4d(rotation.z, 0, 0, 1)));
		r()
		.rotate(new Quaternionf(new AxisAngle4d(rotation.x, 1, 0, 0)))
		.rotate(new Quaternionf(new AxisAngle4d(rotation.y, 0, 1, 0)))
		.rotate(new Quaternionf(new AxisAngle4d(rotation.z, 0, 0, 1)));
	}

}
