package br.com.while42.sorteionf;
import java.util.Calendar;

public class NFPCalc {

	public static long calculateForToday(double individualValue, int numberOfPeople) {
		return NFPCalc.calculate(Calendar.getInstance().get(Calendar.DAY_OF_MONTH),
				individualValue, numberOfPeople);
	}
	
	protected static long calculate(int dayOfMonth, double individualValue, int numberOfPeople) {
		// rounds to 2 decimal places
		int relevantPart = (int) (individualValue * 100);
		
		int intPart = relevantPart / 100;
		int centsPart = relevantPart % 100;		
		
		return (intPart + centsPart + dayOfMonth) % numberOfPeople;
	}
}
