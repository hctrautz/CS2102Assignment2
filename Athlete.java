class Athlete {

	SkiingResult skiires;
	ShootingResult shootres;
	String name;

	Athlete (ShootingResult shootres, SkiingResult skiires, String name){
		this.skiires = skiires;
		this.shootres = shootres;
		this.name = name;
	}

	//consumes an athlete and compares it to the other athlete, producing which athlete has a lower skiing score
	Athlete betterSkiier(Athlete aAth) {
		if(this.skiires.pointsEarned() < aAth.skiires.pointsEarned()) {
			return this;
		} else {
			return aAth;
		}
	}

	//produces true if (this) athlete has either a lower skiing score than the other athlete, or a higher shooting score than the other athlete
	boolean hasBeaten (Athlete anothAth) {
		return (this.skiires.pointsEarned() < anothAth.skiires.pointsEarned() || 
				this.shootres.pointsEarned() > anothAth.shootres.pointsEarned());
	}


}

