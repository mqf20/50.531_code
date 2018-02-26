package week6;
import java.util.Map;

//the class maintains the locations of a set of taxis. 
public class Tracker {
	private final Map<String, MutablePoint> locations;
	
	public Tracker(Map<String, MutablePoint> locations) {
		this.locations = locations;
	}
	
	public Map<String, MutablePoint> getLocations () {
		return locations;
	}
	
	public MutablePoint getLocation (String id) {
		MutablePoint loc = locations.get(id);
		return loc;
	}
	
	public void setLocation (String id, int x, int y) {
		MutablePoint loc = locations.get(id);
		
		if (loc == null) {
			throw new IllegalArgumentException ("No such ID: " + id);			
		}
		
		loc.x = x;
		loc.y = y;
	}
	
	class MutablePoint {
		public int x, y;

		public MutablePoint (int x, int y) {
			this.x = x;
			this.y = y;
		}
		
		public MutablePoint (MutablePoint p) {
			this.x = p.x;
			this.y = p.y;
		}
	}
}
