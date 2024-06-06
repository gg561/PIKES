package geometry.face;

import org.joml.Matrix4f;
import org.joml.Vector2f;
import org.joml.Vector3f;
import org.joml.Vector4f;

public class Rectangle extends Quad {
	
	public Rectangle(Vector3f normal, Vector3f size, Vector2f dimensions, float normalOffset) {
		super(normal, size, Rectangle.transformVertices(calculateVertices(dimensions, normal, normalOffset), new Matrix4f().lookAlong(normal, Rectangle.findUp(normal, new Vector3f(0, 1, 0)))));
	}

	public Rectangle(Vector3f size, Vector2f dimensions) {
		super(new Vector3f(0, 0, 1), size, calculateVertices(dimensions, new Vector3f(0, 0, 1), 0));
		// TODO Auto-generated constructor stub
	}
	
	public static Vector3f[] calculateVertices(Vector2f dimensions, Vector3f normal, float normalOffset) {
		Vector3f[] vertices = new Vector3f[4];
		//left-top
		vertices[0] = new Vector3f(-dimensions.x, dimensions.y, normalOffset);
		//left-bottom
		vertices[1] = new Vector3f(-dimensions.x, -dimensions.y, normalOffset);
		//right-bottom
		vertices[2] = new Vector3f(dimensions.x, -dimensions.y, normalOffset);
		//right-top
		vertices[3] = new Vector3f(dimensions.x, dimensions.y, normalOffset);
		return vertices;
	}
	
	public static Vector3f[] transformVertices(Vector3f[] vertices, Matrix4f transformationMatrix) {
		for(Vector3f vec : vertices) {
			Vector4f result = new Vector4f(vec, 0).mul(transformationMatrix);
			vec.set(result.x, result.y, result.z);
		}
		return vertices;
	}
	
	public static Vector3f findUp(Vector3f direction, Vector3f defaultUp) {
			if(direction.sub(direction.mul(defaultUp, new Vector3f()), new Vector3f()).equals(0, 0, 0)) {
				return defaultUp.rotateX((float) (Math.PI / 2));
			}
			return defaultUp;
	}

}
