package airportSecurityState.airportStates;

import airportSecurityState.util.MyLogger;
import airportSecurityState.util.MyLogger.DebugLevel;

//context class
public class StateChangerContext {

	private AirportStateI currentState;
	private AirportStateI lowRisk;
	private AirportStateI modRisk;
	private AirportStateI highRisk;

	public StateChangerContext() {
		MyLogger.writeMessage("Constructor called", DebugLevel.CONSTRUCTOR);
		lowRisk = new Low_risk(this);
		modRisk = new Moderate_risk(this);
		highRisk = new High_risk(this);
		currentState = lowRisk;

	}

	public AirportStateI getLowRisk() {
		return lowRisk;
	}

	public AirportStateI getModRisk() {
		return modRisk;
	}

	public AirportStateI getHighRisk() {
		return highRisk;
	}

	public String tightenOrLoosenSecurity(float averageTrafficPerDay, float averageProhibitedItemsPerDay) {

		currentState.StateChecker(averageTrafficPerDay, averageProhibitedItemsPerDay);
		return currentState.OperationsPerformed();
	}

	public void setState(AirportStateI currentState) {
		this.currentState = currentState;

	}

}
