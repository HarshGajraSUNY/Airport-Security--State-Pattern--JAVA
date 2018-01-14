package airportSecurityState.airportStates;

import airportSecurityState.util.MyLogger;
import airportSecurityState.util.MyLogger.DebugLevel;

public class Low_risk implements AirportStateI {
	StateChangerContext lstc;

	// LOW RISK CLASS
	public Low_risk(StateChangerContext lstc2) {
		// TODO Auto-generated constructor stub
		this.lstc = lstc2;
		MyLogger.writeMessage("Constructor called", DebugLevel.CONSTRUCTOR);
	}

	@Override
	public void StateChecker(float averageTrafficPerDay, float averageProhibitedItemsPerDay) {
		// TODO Auto-generated method stub
		if (((averageTrafficPerDay >= 4) && (averageTrafficPerDay < 8))
				|| ((averageProhibitedItemsPerDay >= 1) && (averageProhibitedItemsPerDay < 2))) {

			lstc.setState(lstc.getModRisk());
			MyLogger.writeMessage("State changed", DebugLevel.IN_RUN);
			// return null;
		}
		// return null;

	}

	@Override
	public String OperationsPerformed() {
		// TODO Auto-generated method stub
		String lowOps = "1 3 5 7 9";
		return lowOps;
	}

}