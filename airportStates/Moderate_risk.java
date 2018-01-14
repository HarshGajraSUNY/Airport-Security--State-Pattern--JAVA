package airportSecurityState.airportStates;

import airportSecurityState.util.MyLogger;
import airportSecurityState.util.MyLogger.DebugLevel;

public class Moderate_risk implements AirportStateI {
	StateChangerContext mstc ;
	//MODERATE STATE CLASS
	public Moderate_risk(StateChangerContext stateChanger) {
		// TODO Auto-generated constructor stub
		this.mstc=stateChanger;
		MyLogger.writeMessage("Constructor called", DebugLevel.CONSTRUCTOR);
	}

	@Override
	public String OperationsPerformed() {
		// TODO Auto-generated method stub
		String lowOps="2 3 5 8 9";
		return lowOps;
	}

	@Override
	public void StateChecker(float averageTrafficPerDay, float averageProhibitedItemsPerDay) {
		// TODO Auto-generated method stub
		
		if  (((averageTrafficPerDay >= 0) && (averageTrafficPerDay < 4))
				&& ((averageProhibitedItemsPerDay >= 0) && (averageProhibitedItemsPerDay < 1))) {
			mstc.setState(mstc.getLowRisk());
			MyLogger.writeMessage("State changed", DebugLevel.IN_RUN);
		}
		
		
		if ((averageTrafficPerDay >= 8) || (averageProhibitedItemsPerDay >= 2)) {
			mstc.setState(mstc.getHighRisk());
			MyLogger.writeMessage("State changed", DebugLevel.IN_RUN);
			
			//lstc.setState(lstc.getModRisk());
		}
		
	}

	

}
