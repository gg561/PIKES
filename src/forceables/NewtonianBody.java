package forceables;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.joml.Vector3f;

import castable.Forceable;
import castable.Temporal;
import collision.Collider;
import geometry.Force;
import geometry.Movable;
import maths.Constants;

public class NewtonianBody extends Movable implements Forceable, Temporal {
	
	private Collider collider;
	private List<Force> forces = new ArrayList<Force>();
	private Vector3f forcefulness;

	@Override
	public Force getForce(Vector3f direction) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Force> getForces() {
		// TODO Auto-generated method stub
		return forces;
	}

	@Override
	public void setForce(int index, Force force) {
		// TODO Auto-generated method stub
		forces.set(index, force);
	}

	@Override
	public void advanceThroughTime(float digits) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public float getTimeSpeed() {
		return (float) Math.sqrt(1 - getForcefulness().length() / Constants.LIGHT_SPEED_SQUARED);
	}

	@Override
	public Vector3f getForcefulnessCurrent() {
		// TODO Auto-generated method stub
		Vector3f E = new Vector3f();
		for(Force force : forces) {
			E.add(Math.abs(force.getForce().x), Math.abs(force.getForce().y), Math.abs(force.getForce().z));
		}
		return E;
	}
	
	@Override
	public Vector3f getForcefulness() {
		return forcefulness;
	}

}
