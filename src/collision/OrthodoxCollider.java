package collision;

import org.joml.Matrix3f;
import org.joml.Vector3f;

import actors.Movable;
import forceables.NewtonianBody;
import geometry.Box;
import geometry.Volume;

public abstract class OrthodoxCollider extends Collider {
	
	protected Vector3f bounds;
	protected Volume boundingVolume;

	public OrthodoxCollider(NewtonianBody bounded, Complexity complexity, Vector3f bounds) {
		super(bounded, complexity);
		this.bounds = bounds;
		this.boundingVolume = new Box(bounds);
		// TODO Auto-generated constructor stub
	}
	
	public OrthodoxCollider(NewtonianBody bounded, Complexity complexity, Volume boundingVolume) {
		super(bounded, complexity);
		this.boundingVolume = boundingVolume;
		this.bounds = boundingVolume.getHalves();
	}

	@Override
	public void collide(NewtonianBody other) {
		// TODO Auto-generated method stub
		
	}

}
