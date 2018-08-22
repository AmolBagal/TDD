package com.yash.tdd.TddExample;

import static org.junit.Assert.assertEquals;

import java.util.logging.Logger;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class StringCalculatorTest {

	@InjectMocks
	StringCalculator stringCalculator;

	@Mock
	Logger logger;

	@Test
	public void shouldReturnZeroIfEmptyStringPassed() {

		stringCalculator = new StringCalculator();

		assertEquals(0, stringCalculator.addString(""));
	}

	@Test
	public void shouldReturnSameNumberIfInputIsSingleDigit() {

		stringCalculator = new StringCalculator();

		assertEquals(1, stringCalculator.addString("1"));
	}

	@Test
	public void shouldReturnSumOfNumbersIfInputIsTwoDigit() {

		stringCalculator = new StringCalculator();

		assertEquals(5, stringCalculator.addString("3,2"));
	}

	@Test
	public void shouldReturnSumOfNumbersIfInputIsMoreThanTwoDigit() {

		stringCalculator = new StringCalculator();

		assertEquals(10, stringCalculator.addString("3,2,5"));

	}

	@Test
	public void shouldReturnSumOfNumbersIfInputContainsNextLineChar() {

		stringCalculator = new StringCalculator();

		assertEquals(10, stringCalculator.addString("3,2\n5"));
	}

	@Test
	public void shouldReturnSumOfNumbersContainingDifferentDelimiter() {

		stringCalculator = new StringCalculator();

		assertEquals(5, stringCalculator.addString("//;\n;2;3"));
	}

	@Test
	public void shouldBeIgnoredIfinputIsMoreThanThousand() {

		stringCalculator = new StringCalculator();

		assertEquals(5, stringCalculator.addString("//;\n;2;3;1001"));
	}

	@Test
	public void shouldAddReturnValueToLogger() {

		Mockito.doNothing().when(logger).info("5");

		stringCalculator.addString("//;\n;2;3");

		Mockito.verify(logger).info("5");
	}

}
