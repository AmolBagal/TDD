package com.yash.tdd.TddExample;

import java.util.Arrays;
import java.util.logging.Logger;

public class StringCalculator {

	private Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

	public int addString(String input) {
		String delimiter = null;
		int flag = 0;

		if (input.startsWith("//")) {
			delimiter = input.substring(2, 3);
			input = input.substring(input.indexOf("\n") + 2);
			flag = 1;
		}

		String inputString = input.replaceAll("\n", ",");

		if (flag == 1) {
			inputString = inputString.replaceAll(delimiter, ",");
		}

		String[] stringArray = input.trim().length() < 1 ? new String[0] : inputString.split(",");
		int sum = Arrays.stream(stringArray).mapToInt(Integer::parseInt).filter((x) -> x <= 1000).sum();
		logger.info("" + sum);
		return sum;
	}
}
