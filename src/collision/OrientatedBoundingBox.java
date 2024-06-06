package collision;

import org.joml.Vector3f;

import actors.Movable;
import forceables.NewtonianBody;

public class OrientatedBoundingBox extends SATCollider {

	public OrientatedBoundingBox(NewtonianBody bounded, Vector3f bounds) {
		super(bounded, Complexity.OBB, bounds);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean contains(NewtonianBody other) {
		// TODO Auto-generated method stub
		return contains(other);
	}
	
	@Override
	public boolean contains(Collider other) {
		if(other.complexity.compareTo(complexity) > 0) {
			
		}else {
			
		}
		return false;
	}

	@Override
	public boolean contains(Vector3f vector) {
		// TODO Auto-generated method stub
		return false;
	}

}
