import java.util.LinkedList;
class Competition {
	int numOfShootingRounds;
	LinkedList<Athlete> theAthletes;

	Competition(int numOfShootingRounds, LinkedList<Athlete> theAthletes){
		this.numOfShootingRounds = numOfShootingRounds;
		this.theAthletes = theAthletes;
	}
	
	LinkedList<String> shootingDNF(){
		LinkedList<String> listOfNames = new LinkedList <String>();
		for(Athlete a : theAthletes) {
			if (a.shootres.theRounds.size() < numOfShootingRounds) {
				listOfNames.add(a.name);
			}
		}
		return listOfNames;
	}
	//displays the skiingScore for the desired athlete
	double skiingScoreForAthlete(String name){
		Athlete desiredName = null;
		for (Athlete a : theAthletes){
			if (a.name.equals(name)) {
				desiredName = a;
			}
		}
		return desiredName.skiires.pointsEarned();
	}
	//produces true if a athlete had any improvement in their skiing results after two competitions
	boolean anySkiingImprovement(Competition anothComp) {
		for (Athlete a : theAthletes) {
			for (Athlete a2 : anothComp.theAthletes) {
				if (a.name.equals(a2.name) && a.skiires.pointsEarned() > a2.skiires.pointsEarned()) {
					return true;
				}
			}
		}
		return false;
	}
}
//There could be a helper method for looking up a name from one of the competitors
//The nested for loop could be replaced and simplified by a helper function.
