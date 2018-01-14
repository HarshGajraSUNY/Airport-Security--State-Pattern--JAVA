package airportSecurityState.airportStates;

public interface AirportStateI {
	// interface
	public void StateChecker(float averageTrafficPerDay, float averageProhibitedItemsPerDay);

	public String OperationsPerformed();

}
