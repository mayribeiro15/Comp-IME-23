package teste;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import app.Triangulo;

class TrianguloTest {

	private final Triangulo sobTeste = new Triangulo();
	
	@Test
	void testMain() {
		int a=10; int b=1; int c=1; String expected="nao e um triangulo";
		assertEquals(expected,sobTeste.main(a, b, c));
		
		a=1; b=10; c=1; expected="nao e um triangulo";
		assertEquals(expected,sobTeste.main(a, b, c));
		
		a=1; b=1; c=10; expected="nao e um triangulo";
		assertEquals(expected,sobTeste.main(a, b, c));
		
		a=3; b=3; c=3; expected="triangulo equilatero";
		assertEquals(expected,sobTeste.main(a, b, c));
		
		a=1; b=3; c=3; expected="triangulo isosceles";
		assertEquals(expected,sobTeste.main(a, b, c));
		
		a=3; b=1; c=3; expected="triangulo isosceles";
		assertEquals(expected,sobTeste.main(a, b, c));
		
		a=3; b=3; c=1; expected="triangulo isosceles";
		assertEquals(expected,sobTeste.main(a, b, c));
		
		a=3; b=4; c=5; expected="triangulo escaleno";
		assertEquals(expected,sobTeste.main(a, b, c));
	}

}
