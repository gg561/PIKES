package geometry.face;

import org.joml.Matrix3f;
import org.joml.Vector3f;

public class Triangle extends Face {
	
	public Triangle(Vector3f size, Vector3f...vertices) {
		super(size, vertices);
		this.normal = calculateFaceNormal(vertices);
	}

	@Override
	public Vector3f calculateFaceNormal(Vector3f... vertices) {
		// TODO Auto-generated method stub
		Matrix3f mat = new Matrix3f(vertices[0], vertices[1], vertices[2]);
		//determine whether the vertices are counter-clockwise or clockwise
		Vector3f U = vertices[1].sub(vertices[0], new Vector3f());
		Vector3f V = vertices[2].sub(vertices[0], new Vector3f());
		if(Math.signum(mat.determinant()) == 1) {
			Vector3f placeholder = new Vector3f(U);
			U.set(V);
			V.set(placeholder);
		}
		Vector3f N = U.cross(V, new Vector3f());
		return N.normalize();
	}

}
