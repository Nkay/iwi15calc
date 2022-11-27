package at.edu.c02.calculator.logic;


import static org.junit.Assert.assertEquals;
import at.edu.c02.calculator.Calculator;
import at.edu.c02.calculator.parser.Parser;
import org.junit.Test;

import java.io.File;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class EndToEndTest {

    @Test
    public void testParserTest04Xml() throws Exception{
        Calculator cal = new CalculatorImpl();

        Parser parser = new Parser(cal);
        double result = parser.parse(new File("src/test/resources/test04.xml"));

        assertEquals(5, result, 0);
    }

    @Test
    public void testParserTest05Xml() throws Exception{
        Calculator cal = new CalculatorImpl();

        Parser parser = new Parser(cal);
        double result = parser.parse(new File("src/test/resources/test05.xml"));

        assertEquals(53, result, 0);
    }

    @Test
    public void testParserTest08Xml() throws Exception{
        Calculator cal = new CalculatorImpl();

        Parser parser = new Parser(cal);
        double result = parser.parse(new File("src/test/resources/test08.xml"));

        assertEquals(266, result, 0);
    }
}
