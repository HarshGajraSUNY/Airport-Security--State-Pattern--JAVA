package airportSecurityState.airportStates;

import airportSecurityState.util.MyLogger;
import airportSecurityState.util.MyLogger.DebugLevel;

public class High_risk implements AirportStateI {
	StateChangerContext hstc;

	// HIGH RISK STATE
	public High_risk(StateChangerContext stateChanger) {
		// TODO Auto-generated constructor stub
		this.hstc = stateChanger;
		MyLogger.writeMessage("Constructor called", DebugLevel.CONSTRUCTOR);
	}

	@Override
	public String OperationsPerformed() {
		// TODO Auto-generated method stub
		String lowOps = "2 4 6 8 10";
		return lowOps;
	}

	@Override
	public void StateChecker(float averageTrafficPerDay, float averageProhibitedItemsPerDay) {
		// TODO Auto-generated method stub
		if (((averageTrafficPerDay >= 4) && (averageTrafficPerDay < 8))
				&& ((averageProhibitedItemsPerDay >= 1) && (averageProhibitedItemsPerDay < 2))) {
			hstc.setState(hstc.getModRisk());
			MyLogger.writeMessage("State changed", DebugLevel.IN_RUN);
		}
	}

}
