package castable;

import org.joml.Vector3f;

public interface Temporal {
	
	public default void advanceThroughTime() {
		advanceThroughTime(getTimeSpeed());
	}
	public void advanceThroughTime(float digits);
	
	public float getTimeSpeed();
	
	public Vector3f getForcefulness();
	public Vector3f getForcefulnessCurrent();
}
