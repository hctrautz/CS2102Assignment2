abstract public class AbsResult implements IEvent{
	double time;
	int position;
	
	AbsResult (double time, int position){
		this.time = time;
		this.position = position;
	}
}
