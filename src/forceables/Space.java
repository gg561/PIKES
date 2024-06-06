package forceables;

import java.util.ArrayList;
import java.util.List;

public class Space {
	
	private List<Dimension> dimensions = new ArrayList<Dimension>();
	
	private void initialize() {
		dimensions.set(0, new Dimension(false, false));
		dimensions.set(1, new Dimension(false, true));
		dimensions.set(2, new Dimension(false, true));
		dimensions.set(3, new Dimension(false, true));
	}
	
	public void move(NewtonianBody object, SpacetimeValue value, SpacetimeUnit unit){
		float[] values = unit.processValues(value.getValues());
		
	}

}
