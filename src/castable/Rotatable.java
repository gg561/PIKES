package castable;

import org.joml.AxisAngle4d;
import org.joml.Quaternionf;
import org.joml.Vector3f;

public interface Rotatable extends Rotationnable, Directable {
	
	public default void rotate(Vector3f rotation) {
		rotate(rotation, getForward(), getRight(), getUp());
	}
	
	public default void rotate(Vector3f rotation, Vector3f forward, Vector3f right, Vector3f up) {
		Vector3f rotationalValue = 
				right.mul(rotation.x, new Vector3f())
				.add(
						up.mul(rotation.y, new Vector3f())
					)
				.add(
						forward.mul(rotation.z, new Vector3f())
					);
		getRotation().add(rotationalValue);
		getForward()
		.rotate(new Quaternionf(new AxisAngle4d(rotation.x, 1, 0, 0)))
		.rotate(new Quaternionf(new AxisAngle4d(rotation.y, 0, 1, 0)))
		.rotate(new Quaternionf(new AxisAngle4d(rotation.z, 0, 0, 1)));
		getUp()
		.rotate(new Quaternionf(new AxisAngle4d(rotation.x, 1, 0, 0)))
		.rotate(new Quaternionf(new AxisAngle4d(rotation.y, 0, 1, 0)))
		.rotate(new Quaternionf(new AxisAngle4d(rotation.z, 0, 0, 1)));
		getRight()
		.rotate(new Quaternionf(new AxisAngle4d(rotation.x, 1, 0, 0)))
		.rotate(new Quaternionf(new AxisAngle4d(rotation.y, 0, 1, 0)))
		.rotate(new Quaternionf(new AxisAngle4d(rotation.z, 0, 0, 1)));
	}

}
