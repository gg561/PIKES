package collision;

import java.util.ArrayList;
import java.util.List;

import org.joml.Vector3f;

import actors.Movable;
import forceables.NewtonianBody;

public abstract class Collider extends Movable {
	
	protected List<Collider> colliders = new ArrayList<Collider>();
	protected NewtonianBody bounded;
	protected final Complexity complexity;
	
	public Collider(NewtonianBody bounded, Complexity complexity) {
		this.bounded = bounded;
		this.complexity = complexity;
	}
	
	public abstract void collide(NewtonianBody other);
	public abstract boolean contains(NewtonianBody other);
	public abstract boolean contains(Collider other);
	public abstract boolean contains(Vector3f vector);

}
