package test;

import java.util.Arrays;
import java.util.HashMap;

import org.joml.Matrix4f;
import org.joml.Vector3d;
import org.joml.Vector3f;

import collision.SATCollider;
import geometry.Box;
import geometry.Edge;

public class Test {
	
	public static void main(String[] args) {
		Box box = new Box(new Vector3f(5));
		Box xob = new Box(new Vector3f(3, 5, 3));
		xob.move(new Vector3f(-11.4f, 0, 0));
		System.out.println(Arrays.toString(xob.getVertices()));
		box.rotate(new Vector3f(0, 0, (float) (Math.PI / 4)));
		xob.rotate(new Vector3f(0, (float) (Math.PI / 4), 0));
		System.out.println(Arrays.toString(xob.getVertices()));
		System.out.println(SATCollider.intersects(xob, box));
		System.out.println(xob.getPosition());
		System.out.println(Arrays.toString(xob.getVertices()));
		System.out.println(Arrays.toString(box.getVertices()));
		System.out.println(Arrays.toString(box.getEdges()));
		System.out.println(Arrays.toString(box.getFaces()));
		Arrays.stream(box.getFaces()).forEach(f -> {System.out.println(Arrays.toString(f.getVertices()));});
	}

}
