package geometry.face;

import org.joml.Vector3f;

public class Quad extends Face {
	
	public Quad(Vector3f normal, Vector3f size, Vector3f...vertices) {
		super(normal, size, vertices);
	}

	public Quad(Vector3f size, Vector3f... vertices) {
		super(size, vertices);
		// TODO Auto-generated constructor stub
		this.normal = calculateFaceNormal(vertices);
	}

	/**
	 * use this format :
	 * 
	 *     0     |     1     |     2     |     3
	 *  top-left   bottom-left  top-right   bottom-right
	 */
	@Override
	public Vector3f calculateFaceNormal(Vector3f... vertices) {
		// TODO Auto-generated method stub
		Triangle t0 = new Triangle(new Vector3f(1), vertices[0], vertices[1], vertices[2]);
		Triangle t1 = new Triangle(new Vector3f(1), vertices[0], vertices[2], vertices[3]);
		Vector3f Navg = t0.getNormal().add(t1.getNormal(), new Vector3f()).div(2);
		Navg.normalize();
		return Navg;
	}

}
