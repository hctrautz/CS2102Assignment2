
import java.util.LinkedList;
class ShootingResult implements IEvent {
	LinkedList<ShootingRound> theRounds;

	ShootingResult (LinkedList <ShootingRound> theRounds){
		this.theRounds = theRounds;
	}
//produces the sum of all the targets hit in the list
	@Override
	public double pointsEarned() {
		int counter = 0;
		for (ShootingRound r : theRounds) {
			counter = r.targhit + counter;
		}
		return counter;
	}
	
	//produces the round from the list with the most targets hit
	ShootingRound bestRound() {
		ShootingRound bestRound = new ShootingRound(0);
		
		for(ShootingRound r : theRounds) {
			if(r.targhit > bestRound.targhit) {
				bestRound = r;
			}
		}
		return bestRound;
	}

}
