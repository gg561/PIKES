package forceables;

public enum SpacetimeUnit {
	
	KMPH(1/72),
	MTPH(1/72000),
	MTPS(1/20),
	MTPT(1);
	
	private float ratio;
	
	private SpacetimeUnit(float ratio) {
		this.ratio = ratio;
	}
	
	public float processValue(float value) {
		return value * ratio;
	}
	
	public float[] processValues(float[] values) {
		float[] rvs = new float[values.length];
		for(int i = 0; i < values.length; i++) {
			rvs[i] = processValue(values[i]);
		}
		return rvs;
	}

}
