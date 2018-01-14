
package airportSecurityState.util;

public class MyLogger {

	/*
	 * DEBUG_VALUE=4 [Print to stdout everytime a constructor is called]
	 * DEBUG_VALUE=3 [Print to stdout everytime the state is changed]
	 * DEBUG_VALUE=2 [Print when entering Results class] DEBUG_VALUE=1 [Print
	 * when prohibited item is found] DEBUG_VALUE=0 [No output should be printed
	 * from the applicatio to stdout. It is ok to write to the output file
	 * though" ]
	 */

	public static enum DebugLevel {
		RELEASE, FROM_RESULTS, IN_RESULTS, IN_RUN, CONSTRUCTOR
	};

	private static DebugLevel debugLevel;

	public static void setDebugValue(int levelIn) {
		switch (levelIn) {
		// case 4: for calling constructors
		case 4:
			debugLevel = DebugLevel.CONSTRUCTOR;
			break;

		// case 3: for State Changed
		case 3:
			debugLevel = DebugLevel.IN_RUN;
			break;

		// case 2: Entering Results class
		case 2:
			debugLevel = DebugLevel.IN_RESULTS;
			break;

		// case 1: When prohibited item found
		case 1:
			debugLevel = DebugLevel.FROM_RESULTS;
			break;

		// case 0: When program is released
		case 0:
			debugLevel = DebugLevel.RELEASE;
			break;
		}
	}

	public static void setDebugValue(DebugLevel levelIn) {
		debugLevel = levelIn;
	}

	// @return None
	public static void writeMessage(String message, DebugLevel levelIn) {
		if (levelIn == debugLevel)
			System.out.println(message);
	}

	/**
	 * @return String
	 */
	public String toString() {
		return "Debug Level is " + debugLevel;
	}
}
