package at.edu.c02.calculator.parser;

import java.io.File;
import java.io.FileNotFoundException;

import at.edu.c02.calculator.logic.CalculatorImpl;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

import at.edu.c02.calculator.Calculator;
import at.edu.c02.calculator.Calculator.Operation;
import at.edu.c02.calculator.parser.Parser;

public class ParserTest {

	@Test(expected = IllegalArgumentException.class)
	public void testNullParser() {
		new Parser(null);
	}

	@Test(expected = FileNotFoundException.class)
	public void testParserInvalidFile() throws Exception {

		Calculator cal = mock(Calculator.class);

		Parser parser = new Parser(cal);
		parser.parse(new File("invalid"));
	}

	@Test
	public void testParserTest01Xml() throws Exception {

		Calculator cal = mock(Calculator.class);

		Parser parser = new Parser(cal);
		parser.parse(new File("src/test/resources/test01.xml"));
		
		verify(cal).push(1.0);
		verify(cal).push(2.0);
		verify(cal).perform(Operation.add);

		verifyNoMoreInteractions(cal);
	}
	@Test
	public void testParserTest02Xml() throws Exception {
		Calculator calc = mock(Calculator.class);

		Parser parser = new Parser(calc);
		parser.parse(new File("src/test/resources/test06.xml"));

		verify(calc).push(3);
		verify(calc).perform(Operation.sin);

		verifyNoMoreInteractions(calc);
	}
	@Test
	public void testParserTest03Xml() throws Exception {
		Calculator calc = mock(Calculator.class);

		Parser parser = new Parser(calc);
		parser.parse(new File("src/test/resources/test07.xml"));

		verify(calc).push(7);
		verify(calc).perform(Operation.cos);

		verifyNoMoreInteractions(calc);
	}
	@Test
	public void testParserTest08Xml() throws Exception {
		Calculator calc = mock(Calculator.class);

		Parser parser = new Parser(calc);
		parser.parse(new File("src/test/resources/test08.xml"));

		verify(calc).push(7);
		verify(calc).push(8);
		verify(calc).push(9);
		verify(calc).push(10);
		verify(calc).push(11);
		verify(calc).push(12);
		verify(calc).push(3);
		verify(calc).perform(Operation.dotproduct);

		verifyNoMoreInteractions(calc);
	}
}
