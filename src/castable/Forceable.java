package castable;

import java.util.List;

import org.joml.Vector3f;

import geometry.Force;

public interface Forceable {
	
	public Force getForce(Vector3f direction);
	public List<Force> getForces();
	
	public default void addForce(Force force) {
		if(!getForces().contains(force)) {
			getForces().add(force);
		}
	}
	
	public void setForce(int index, Force force);

}
