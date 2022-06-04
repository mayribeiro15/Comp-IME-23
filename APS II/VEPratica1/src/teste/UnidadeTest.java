package teste;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import app.Unidade;

import java.util.Scanner;

class UnidadeTest {

	private final Unidade sobTeste = new Unidade();
	
	@Test
	void testMain() {
		Scanner sc = new Scanner("71/-1"); sc.useDelimiter("/"); float expected=63.9f;
		assertEquals(expected,sobTeste.main(sc));
	}

}
