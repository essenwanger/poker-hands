package poker;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GameTest {
	
	@Test
	void test1() {
		Game game = new Game();
		
		game.repartirCartas(cartasJugadorBlancoCartaAlta9(), cartasJugadorNegroCartaAltaJack());
		
		assertEquals(5, game.cantidadCartasJugadorBlanco());
		assertEquals(5, game.cantidadCartasJugadorNegro());
	}
	
	@Test
	void test5() {
		Game game = new Game();
		
		game.repartirCartas(cartasJugadorBlancoCartaAlta9(), cartasJugadorNegroCartaAltaJack());
		
		assertEquals(9, game.cartaMayorJugadorBlanco());
	}
	
	@Test
	void test2() {
		Game game = new Game();
		
		game.repartirCartas(cartasJugadorBlancoCartaAlta9(), cartasJugadorNegroCartaAltaJack());
		
		assertFalse(game.jugadorBlancoGana());
		assertTrue(game.jugadorNegroGana());
	}
	
	private List<String> cartasJugadorBlancoCartaAlta9(){
		List<String> cartasBlanco = new ArrayList<String>();
		cartasBlanco.add("3H");
		cartasBlanco.add("5S");
		cartasBlanco.add("9D");
		cartasBlanco.add("7H");
		cartasBlanco.add("4H");
		
		return cartasBlanco;
	}
	
	private List<String> cartasJugadorNegroCartaAltaJack(){
		List<String> cartasNegro = new ArrayList<String>();
		cartasNegro.add("4H");
		cartasNegro.add("6S");
		cartasNegro.add("3D");
		cartasNegro.add("JD");
		cartasNegro.add("8H");
		
		return cartasNegro;
	}
	
	@Test
	void test3() {
		Game game = new Game();
		
		game.repartirCartas(cartasJugadorBlancoCartaAltaQueen(), cartasJugadorNegroCartaAlta5());
		
		assertTrue(game.jugadorBlancoGana());
		assertFalse(game.jugadorNegroGana());
	}

	private List<String> cartasJugadorBlancoCartaAltaQueen(){
		List<String> cartasBlanco = new ArrayList<String>();
		cartasBlanco.add("3H");
		cartasBlanco.add("5S");
		cartasBlanco.add("9D");
		cartasBlanco.add("JH");
		cartasBlanco.add("QH");
		
		return cartasBlanco;
	}
	
	private List<String> cartasJugadorNegroCartaAlta5(){
		List<String> cartasNegro = new ArrayList<String>();
		cartasNegro.add("4H");
		cartasNegro.add("4S");
		cartasNegro.add("3D");
		cartasNegro.add("2D");
		cartasNegro.add("5H");
		
		return cartasNegro;
	}
	
}
