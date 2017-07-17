package recursion;

public class Factorial {

	public static Integer calc(int number) {
		
		if (number == 1 || number == 0) {
			return 1;
		}
		
		
		return number * calc(number - 1);
	}
}
