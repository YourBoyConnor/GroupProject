import java.awt.Polygon;

public class Rail {
	private Polygon hitbox;

	private Position startPoint;
	private Position endPoint;
	private String state = "";
	private boolean doubleRail = false;
	private boolean placedByCPU;
	private boolean debug = false;

	final static float THICKNESS = 1.5f;
	final static String EMPTY = "empty";
	final static String PLACED = "placed";
	final static String HOVERING = "hovering";

	public Rail(Position startPoint, Position endPoint) {
		this(startPoint, endPoint, false, false);
	}

	public Rail(Position startPoint, Position endPoint, boolean doubleRail) {
		this(startPoint, endPoint, doubleRail, false);
	}

	public Rail(Position startPoint, Position endPoint, boolean doubleRail, boolean placedByCPU) {
		this.startPoint = startPoint;
		this.endPoint = endPoint;
		this.doubleRail = doubleRail;
		this.placedByCPU = placedByCPU;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getState() {
		return state;
	}

	public Position startPos() {
		return startPoint;
	}

	public Position endPos() {
		return endPoint;
	}

	public void setDouble() {
		doubleRail = true;
	}

	public boolean isDouble() {
		return doubleRail;
	}

	public String toString() {
		return (startPos() + " --> " + endPos());
	}

	public boolean equals(Object obj) {
		Rail r = (Rail) obj;
		return r.startPos().equals(startPos()) && r.endPos().equals(endPos());
	}

	public boolean isPlacedByCPU() {
		return placedByCPU;
	}

	public Polygon getHitbox() {
		return hitbox;
	}

	public void setHitbox(Polygon hitbox) {
		this.hitbox = hitbox;
	}

	public void setDebug(boolean state) {
		debug = state;
	}

	public boolean debug() {
		return debug;
	}
}
