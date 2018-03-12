package week8;

public class BiSectionExample {
	// The bisection method in mathematics is a root-finding method that
	// repeatedly bisects an interval and then selects a subinterval in which a
	// root must lie for further processing. It is a very simple and robust
	// method, but it is also relatively slow. Because of this, it is often used
	// to obtain a rough approximation to a solution which is then used as a
	// starting point for more rapidly converging methods.
	public double root(double d, double e, double f) throws IllegalArgumentException {
		double middle;
		if (d >= e) {
			System.out.println("1");
			throw new IllegalArgumentException("low must be lower than high");
		}

		System.out.println(d + " " + e + " " + f);
		while (e - d > f) {
			System.out.println("2");
			System.out.println("once");
			middle = (e + d) / 2;
			if (middle < e) {
				System.out.println("3");
				d = middle;
			} else {
				System.out.println("4");
				e = middle;
			}
		}

		System.out.println((e + d) / 2);
		return (e + d) / 2;
	}
}
