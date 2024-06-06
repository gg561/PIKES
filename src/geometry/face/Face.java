package geometry.face;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import org.joml.Vector3f;

import geometry.Edge;

public abstract class Face {
	
	protected Vector3f normal;
	private Vector3f[] vertices;
	private Edge[] edges;
	private Vector3f size;
	
	public Face(Vector3f size, Vector3f...vertices) {
		this(null, size, vertices);
	}
	
	public Face(Vector3f normal, Vector3f size, Vector3f...vertices) {
		this.normal = normal;
		this.size = size;
		this.vertices = vertices;
		calculateEdges();
	}
	
	public abstract Vector3f calculateFaceNormal(Vector3f...vertices);
	
	public Vector3f getNormal() {
		return normal;
	}
	
	public Vector3f getSize() {
		return size;
	}
	
	public Vector3f[] getVertices() {
		return Arrays.copyOf(vertices, vertices.length);
	}
	
	public Edge[] getEdges() {
		return Arrays.copyOf(edges,  edges.length);
	}
	
	public void calculateEdges() {
		edges = new Edge[vertices.length];
		Vector3f previous = null;
		for(int i = 0; i < vertices.length; i++) {
			Vector3f vertex = vertices[i];
			Vector3f bond = findClosestVertexBond(vertex, previous);
			Vector3f direction = bond.sub(vertex, new Vector3f()).normalize();
			edges[i] = new Edge(direction, vertex.dot(direction), bond.dot(direction));
			previous = vertex;
		}
	}
	
	private Vector3f findClosestVertexBond(Vector3f vertex, Vector3f previous) {
		List<Vector3f> vertices = new ArrayList<Vector3f>(Arrays.asList(this.vertices));
		vertices.remove(vertex);
		vertices.sort(new Comparator<Vector3f>() {

			@Override
			public int compare(Vector3f o1, Vector3f o2) {
				// TODO Auto-generated method stub
				float d0 = o1.distance(vertex);
				float d1 = o2.distance(vertex);
				return d0 == d1 ? 0 : (d0 > d1 ? 1 : -1);
			}});
		return vertices.stream().filter(v ->! v.equals(previous)).findFirst().get();
	}
	
}
