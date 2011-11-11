package br.com.while42.sorteioNF;
import java.text.DecimalFormat;
import java.util.Calendar;

public class NFPCalc {

	public static long calculateForToday(double individualValue, long numberOfPeople) {
		return NFPCalc.calculate(Calendar.getInstance().get(Calendar.DAY_OF_MONTH),
				individualValue, numberOfPeople);
	}
	
	protected static long calculate(int dayOfMonth, double individualValue, long numberOfPeople) {
		// rounds to 2 decimal places
		long relevantPart =
				(long)(Double.valueOf(new DecimalFormat("#.##").format(individualValue)) * 100);
		
		long intPart = relevantPart / 100;
		long centsPart = relevantPart % 100;		
		
		return (intPart + centsPart + dayOfMonth) % numberOfPeople;
	}
}
