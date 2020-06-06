package poker;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GameTest {
	
	@Test
	void jugadorBlancoSuCartaMayorEs9C() {
		String[] cartasBlanco=new String[]{"2H","3D","5S","9C","4D"};
		String[] cartasNegro=new String[]{"2C","3H","4S","8C","AH"};
		
		Game game = new Game(cartasBlanco, cartasNegro);
		assertEquals("9C", game.cartaMayorJugadorBlanco());
	}
	
	@Test
	void jugadorNegroSuCartaMayorEsAH() {
		String[] cartasBlanco=new String[]{"2H","3D","5S","9C","4D"};
		String[] cartasNegro=new String[]{"2C","3H","4S","8C","AH"};
		
		Game game = new Game(cartasBlanco, cartasNegro);
		assertEquals("AH", game.cartaMayorJugadorNegro());
	}
	
	@Test
	void jugadorNegroGanaCartaMayorAH() {
		String[] cartasBlanco=new String[]{"2H","3D","5S","9C","4D"};
		String[] cartasNegro=new String[]{"2C","3H","4S","8C","AH"};
		
		Game game = new Game(cartasBlanco, cartasNegro);
		assertEquals("Black wins. - with high card: Ace", game.ganador());
	}
	
	@Test
	void jugadorBlancoGanaCartaMayorKC() {
		String[] cartasBlanco=new String[]{"2H","3D","5S","KC","4D"};
		String[] cartasNegro=new String[]{"2C","3H","4S","8C","7H"};
		
		Game game = new Game(cartasBlanco, cartasNegro);
		assertEquals("White wins. - with high card: King", game.ganador());
	}
	
	@Test
	void empateCartaMayor() {
		String[] cartasBlanco=new String[]{"2H","3D","5S","KC","4D"};
		String[] cartasNegro=new String[]{"2C","3H","4S","8C","KH"};
		
		Game game = new Game(cartasBlanco, cartasNegro);
		assertEquals("Tie.", game.ganador());
	}
	
	
}
