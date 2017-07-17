package recursion;

import java.util.Arrays;

import org.apache.commons.lang3.StringUtils;

public class RecursiveDrawing {

	public static void draw(int n) {
		if (n < 1) {
			return;
		}
		System.out.println(StringUtils.repeat('*', n));
	
		draw(n - 1);
		
		System.out.println(StringUtils.repeat('#', n));
		
	}
}
