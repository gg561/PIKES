package castable;

import org.joml.Vector3f;

public interface Mobile extends Positionnable, Directable {
	
	public default void move(Vector3f translation) {
		move(translation, getForward(), getRight(), getUp());
	}
	
	public default void move(Vector3f translation, Vector3f forward, Vector3f right, Vector3f up) {
		getPosition().add(
				right.mul(translation.x, new Vector3f())
				.add(
						up.mul(translation.y, new Vector3f())
					)
				.add(
						forward.mul(translation.z, new Vector3f())
					)
				);
	}

}
