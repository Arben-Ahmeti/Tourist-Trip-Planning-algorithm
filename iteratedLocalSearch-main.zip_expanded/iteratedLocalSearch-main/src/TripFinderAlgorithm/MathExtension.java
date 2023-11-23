package TripFinderAlgorithm;

public abstract class MathExtension {
	public static double getEuclidianDistanceOfTwoPOIs(POI fromPOI, POI toPOI) {
		long insideSquareRoot = (long)(Math.pow(fromPOI.getXCoordinate() - toPOI.getXCoordinate(), 2) + 
										Math.pow(fromPOI.getYCoordinate() - toPOI.getYCoordinate(), 2));
		return Math.sqrt((double)insideSquareRoot);
	}

	public static int getMaxOfTwo(int number1, int number2) {
		return number1 > number2? number1: number2;
	}

	public static int getMinOfTwo(int number1, int number2) {
		return number1 < number2? number1: number2;
	}
}
