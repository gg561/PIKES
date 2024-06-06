package geometry;

import org.joml.Vector3f;

import castable.Mobile;
import castable.Rotatable;

public class Movable extends Transform implements Mobile, Rotatable {
	
	public Movable() {
		super();
	}
	
	public Movable(Vector3f position, Vector3f rotation, Vector3f scale, Vector3f localPosition,
			Vector3f localRotation, Vector3f forward, Vector3f right, Vector3f up) {
		super(position, rotation, scale, localPosition, localRotation, forward, right, up);
	}

}
