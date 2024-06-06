package geometry;

import java.util.List;
import java.util.function.DoubleSupplier;

import org.joml.Vector3f;

public class Force {
	
	private Vector3f direction;
	private List<DoubleSupplier> forceAlgorithm;
	
	public Force(Vector3f direction, List<DoubleSupplier> forceAlgorithm) {
		this.direction = direction;
		this.forceAlgorithm = forceAlgorithm;
	}
	
	public Vector3f getDirection() {
		return direction;
	}
	
	public Vector3f getForce() {
		return direction.mul((float) getFactor());
	}
	
	private double getFactor() {
		double factor = 0;
		for(DoubleSupplier d : forceAlgorithm) {
			factor += d.getAsDouble();
		}
		return factor;
	}

}
