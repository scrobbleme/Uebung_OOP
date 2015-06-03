package oop.uebung5.aufgabe1.math.tests;

import oop.uebung2.aufgabe3.ParameterNotANumberException;
import oop.uebung2.aufgabe4.math.AddMathOperation;
import oop.uebung2.aufgabe4.math.MathOperation;

import org.junit.Assert;
import org.junit.Test;

public class AddMathOperationTest {

	private final MathOperation addition = new AddMathOperation();

	@Test
	public void testeAddition() throws ParameterNotANumberException {
		// Direkter Aufruf der calculate methode
		Assert.assertEquals(-1, addition.calculate(0, -1), 0);
		Assert.assertEquals(0, addition.calculate(0, 0), 0);
		Assert.assertEquals(1, addition.calculate(0, 1), 0);

		// Aufruf mittels String-Array
		Assert.assertEquals(-1, addition.rechne("add", "0", "-1"), 0);
		Assert.assertEquals(0, addition.rechne("add", "0", "0"), 0);
		Assert.assertEquals(1, addition.rechne("add", "0", "1"), 0);

	}

	@Test
	public void testeFehlerhafteAddition() {
		try {
			Assert.assertEquals(-1, addition.rechne("add", "A", "-1"), 0);
			Assert.fail();
		} catch (ParameterNotANumberException e) {
			Assert.assertEquals(1, e.getIndex());
		}

		try {
			Assert.assertEquals(-1, addition.rechne("add", "0", "A"), 0);
			Assert.fail();
		} catch (ParameterNotANumberException e) {
			Assert.assertEquals(2, e.getIndex());
		}
	}

}
