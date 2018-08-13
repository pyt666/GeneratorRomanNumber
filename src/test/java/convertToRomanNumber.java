import static org.junit.Assert.*;

import org.junit.Test;

import conversion.utils;

public class convertToRomanNumber {

	@Test
	public void test() {
		String s = "1992.11.24";
		System.out.println(utils.getRomanNumberString(s));
		
	}

}
