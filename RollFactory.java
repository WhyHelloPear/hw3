// Class used to interact with roll objects through factory pattern

public class RollFactory{

	//creates a roll based on given roll type
	public Roll createRoll(String rollType){
		Roll roll = null;
		if(rollType == "egg"){
			roll = new EggRoll();
		}
		else if(rollType == "jelly"){
			roll = new JellyRoll();
		}
		else if(rollType == "pastry"){
			roll = new PastryRoll();
		}
		else if(rollType == "sausage"){
			roll = new SausageRoll();
		}
		else if(rollType == "spring"){
			roll = new SpringRoll();
		}
		return roll;
	}

}