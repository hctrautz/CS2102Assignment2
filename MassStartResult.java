class MassStartResult extends AbsResult{

	MassStartResult (double time, int position){
		super(time, position);
	}

	//produces the time (points earned) of MassStartResult
	@Override
	public double pointsEarned() {
		return this.time; 
	}

}
