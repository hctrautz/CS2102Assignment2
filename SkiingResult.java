class SkiingResult extends AbsResult{
	 ShootingResult aResult;
	
	SkiingResult(double time, int position, ShootingResult aResult){
		super(time, position);
		this.aResult = aResult;
	}
	
	//takes a ShootingResult as an input and adds 20 seconds for each target (out of five) missed in each round. 
	public double addShootingPenalties(ShootingResult aResult){
		return (this.time + (20 * (20 - aResult.pointsEarned())));
	}
	
	@Override
	// sets the time equal to a new time which takes into account penalties, and then edits the time based on which position the athlete came in for skiing
	public double pointsEarned() {
		double time = this.addShootingPenalties(this.aResult);
		if(this.position == 1) {
			time = time-10;
		}
		if(this.position == 2) {
			time = time-7;
		}
		if(this.position == 3) {
			time = time-3;
		}
		
		return time;
	}

}
