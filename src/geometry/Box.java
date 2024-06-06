package geometry;

import org.joml.Vector2f;
import org.joml.Vector3f;

import geometry.face.Rectangle;
import geometry.face.Face;

public class Box extends Volume {

	public Box(Vector3f bounds) {
		super(generateBoxFaces(bounds), bounds);
		// TODO Auto-generated constructor stub
	}
	
	public static Face[] generateBoxFaces(Vector3f halves) {
		Face[] faces = new Face[6];
		Vector3f scale = new Vector3f(1);
		Vector2f halvesFB = new Vector2f(halves.x, halves.y);
		//front
		faces[0] = new Rectangle(new Vector3f(0, 0, -1), scale, halvesFB, halves.z);
		//back
		faces[1] = new Rectangle(new Vector3f(0, 0, 1), scale, halvesFB, halves.z);
		Vector2f halvesLR = new Vector2f(halves.z, halves.y);
		//right
		faces[2] = new Rectangle(new Vector3f(-1, 0, 0), scale, halvesLR, halves.x);
		//left
		faces[3] = new Rectangle(new Vector3f(1, 0, 0), scale, halvesLR, halves.x);
		Vector2f halvesTB = new Vector2f(halves.x, halves.z);
		//top
		faces[4] = new Rectangle(new Vector3f(0, 1, 0), scale, halvesTB, halves.y);
		//bottom
		faces[5] = new Rectangle(new Vector3f(0, -1, 0), scale, halvesTB, halves.y);
		return faces;
	}

}