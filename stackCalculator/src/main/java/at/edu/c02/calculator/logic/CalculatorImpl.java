package at.edu.c02.calculator.logic;

import java.util.Stack;
import java.util.ArrayList;
import java.util.List;

import at.edu.c02.calculator.Calculator;
import at.edu.c02.calculator.CalculatorException;


public class CalculatorImpl implements Calculator {

	private Stack<Double> stack_ = new Stack<Double>();

	@Override
	public double perform(Operation op) throws CalculatorException {

		double b = pop();
		double a = 0.0;
		if(!stack_.isEmpty())
			 a = pop();

		switch (op) {
		case add:
			return a + b;
		case sub:
			return a - b;
		case div:
			double c = a / b;
			if (Double.isInfinite(c))
				throw new CalculatorException("Division by zero");
			return c;
		case mul:
			return a * b;
		case mod:
			double d = a / b;
			if (Double.isInfinite(d))
				throw new CalculatorException("Division by zero");
			d = a % b;
			return d;
		case sin:
			return Math.sin(b);
		case cos:
			return Math.cos(b);
	    case dotproduct:
			int result = 0;
			if(b <= 0)
				throw new CalculatorException("Amount elements per vector must be >= 1");
			List<Integer> listB = new ArrayList<Integer>();
			List<Integer> listA = new ArrayList<Integer>();

			//listB
			listB.add((int)a);
			for (int i = 1; i < b; i++) {
				a = pop();
				listB.add((int)a);
			}
			//listA
			for (int i = 0; i < b; i++) {
				a = pop();
				listA.add((int)a);
			}
			//dotproduct
			for (int i = 0; i < b; i++) {
				result += listA.get(i) * listB.get(i);
			}
			return result;
		}
		return 0;
	}

	@Override
	public double pop() throws CalculatorException {
		if (stack_.isEmpty())
			throw new CalculatorException();
		return stack_.pop();
	}

	@Override
	public void push(double v) {
		stack_.push(v);
	}

	@Override
	public void clear() {
		stack_.clear();
	}

}
