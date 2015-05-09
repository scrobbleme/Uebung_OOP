package de.badresden.oop.uebung2.aufgabe3;

public enum MathOperations {
	ADD {
		public float calculate(float left, float right) {
			return left + right;
		}

	},
	SUB {
		public float calculate(float left, float right) {
			return left - right;
		}

	},
	MULT {
		public float calculate(float left, float right) {
			return left * right;
		}

	},
	DIV {
		public float calculate(float left, float right) {
			if (right == 0) {
				throw new RuntimeException("Division durch 0 ist nicht erlaubt.");
			}
			return left / right;
		}

	};

	public float calculate(String... args) throws ParameterNotANumberException {
		int i = 1;
		try {
			float result = Float.parseFloat(args[i++]);
			for (; i < args.length; i++) {
				result = calculate(result, Float.parseFloat(args[i]));
			}
			return result;
		} catch (NumberFormatException e) {
			throw new ParameterNotANumberException(i);
		}
	}

	public abstract float calculate(float left, float right);
}
