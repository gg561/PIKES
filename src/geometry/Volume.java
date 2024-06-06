package geometry;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.joml.AxisAngle4f;
import org.joml.Matrix4f;
import org.joml.Quaternionf;
import org.joml.Vector3f;
import org.joml.Vector4f;

import geometry.face.Face;

public class Volume extends Movable {
	
	private Face[] faces;
	
	private Edge[] edges;
	
	private Vector3f[] vertices;
	
	private Vector3f halves;
	
	public Volume(Face[] faces, Vector3f position, Vector3f rotation, Vector3f scale, Vector3f localPosition,
			Vector3f localRotation, Vector3f forward, Vector3f right, Vector3f up, Vector3f halves) {
		super(position, rotation, scale, localPosition, localRotation, forward, right, up);
		this.faces = faces;
		this.halves = halves;
		calculateEdges();
		calculateVertices();
	}
	
	public Volume(Face[] faces, Vector3f halves) {
		super();
		this.faces = faces;
		this.halves = halves;
		calculateEdges();
		calculateVertices();
	}

	public Face[] getFaces() {
		return Arrays.copyOf(faces, faces.length);
	}
	
	public Edge[] getEdges() {
		return Arrays.copyOf(edges, edges.length);
	}

	public Vector3f[] getVertices() {
		return Arrays.copyOf(vertices, vertices.length);
	}
	
	public Vector3f getHalves() {
		return halves;
	}
	
	public void setHalves(Vector3f halves) {
		this.halves.set(halves);
	}
	
	public void calculateEdges() {
		List<Edge> tmpEdges = new ArrayList<Edge>();
		for(Face face : faces) {
			for(Edge edge : face.getEdges()) {
				if(!tmpEdges.contains(edge))
					tmpEdges.add(edge);
			}
		}
		edges = new Edge[tmpEdges.size()];
		for(int i = 0; i < edges.length; i++) {
			edges[i] = new Edge(tmpEdges.get(i));
		}
	}
	
	protected void calculateVertices() {
		List<Vector3f> tmpVertices = new ArrayList<Vector3f>();
		for(Face face : faces) {
			for(Vector3f vertex : face.getVertices()) {
				if(!tmpVertices.stream().anyMatch(v -> v.x == vertex.x && v.y == vertex.y && v.z == vertex.z)) {
					tmpVertices.add(vertex);
				}
			}
		}
		vertices = new Vector3f[tmpVertices.size()];
		for(int i = 0; i < vertices.length; i++) {
			vertices[i] = new Vector3f(tmpVertices.get(i));
		}
	}
	
	public void recalculateVertices() {
		for(int i = 0; i < vertices.length; i++) {
			Vector3f vert = vertices[i];
			Matrix4f mat = new Matrix4f();
			mat.rotateAround(new Quaternionf(new AxisAngle4f(this.getRotation().x, this.getRight())), getPosition().x, getPosition().y, getPosition().z);
			mat.rotateAround(new Quaternionf(new AxisAngle4f(this.getRotation().y, this.getUp())), getPosition().x, getPosition().y, getPosition().z);
			mat.rotateAround(new Quaternionf(new AxisAngle4f(this.getRotation().z, this.getForward())), getPosition().x, getPosition().y, getPosition().z);
			Vector4f res = new Vector4f(vert, 0).mul(mat);
			res.add(this.getPosition().x, this.getPosition().y, this.getPosition().z, 0);
			vertices[i] = new Vector3f(res.x, res.y, res.z);
		}
	}
	
	public void rotateVertices() {
		for(int i = 0; i < vertices.length; i++) {
			Vector3f vert = vertices[i];
			vert.sub(getPosition());
			vert.rotateX(getRotation().x);
			vert.rotateY(getRotation().y);
			vert.rotateZ(getRotation().z);
			vertices[i] = vert.add(getPosition());
		}
	}
	
	public void rotateEdges() {
		for(Edge edge : edges) {
			System.out.println(edge.getDirection());
			edge.getDirection().rotateX(getRotation().x);
			System.out.println(edge.getDirection());
			edge.getDirection().rotateY(getRotation().y);
			System.out.println(edge.getDirection());
			edge.getDirection().rotateZ(getRotation().z);
			System.out.println(edge.getDirection());
		}
	}
	
	public void moveVertices() {
		for(int i = 0; i < vertices.length; i++) {
			Vector3f vert = vertices[i];
			vertices[i] = vert.add(this.getPosition(), new Vector3f());
		}
	}
	
	public void move(Vector3f translation, Vector3f forward, Vector3f right, Vector3f up) {
		super.move(translation, forward, right, up);
		moveVertices();
	}
	
	public void rotate(Vector3f rotation, Vector3f forward, Vector3f right, Vector3f up) {
		super.rotate(rotation, forward, right, up);
		rotateVertices();
		rotateEdges();
	}

}
