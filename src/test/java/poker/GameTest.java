package poker;


import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class GameTest {
	
	@Test
	public void jugadorBlancoSuCartaMayorEs9C() {
		String[] cartasBlanco=new String[]{"2H","3D","5S","9C","4D"};
		String[] cartasNegro=new String[]{"2C","3H","4S","8C","AH"};
		
		Game game = new Game(cartasBlanco, cartasNegro);
		assertEquals("9C", game.cartaMayorJugadorBlanco());
	}
	
	@Test
	public void jugadorNegroSuCartaMayorEsAH() {
		String[] cartasBlanco=new String[]{"2H","3D","5S","9C","4D"};
		String[] cartasNegro=new String[]{"2C","3H","4S","8C","AH"};
		
		Game game = new Game(cartasBlanco, cartasNegro);
		assertEquals("AH", game.cartaMayorJugadorNegro());
	}
	
	@Test
	public void jugadorNegroGanaCartaMayorAH() {
		String[] cartasBlanco=new String[]{"2H","3D","5S","9C","4D"};
		String[] cartasNegro=new String[]{"2C","3H","4S","8C","AH"};
		
		Game game = new Game(cartasBlanco, cartasNegro);
		assertEquals("Black wins. - with high card: Ace", game.ganador());
	}
	
	@Test
	public void jugadorBlancoGanaCartaMayorKC() {
		String[] cartasBlanco=new String[]{"2H","3D","5S","KC","4D"};
		String[] cartasNegro=new String[]{"2C","3H","4S","8C","7H"};
		
		Game game = new Game(cartasBlanco, cartasNegro);
		assertEquals("White wins. - with high card: King", game.ganador());
	}
	
	@Test
	public void empateCartaMayor() {
		String[] cartasBlanco=new String[]{"2H","3D","5S","KC","4D"};
		String[] cartasNegro=new String[]{"2C","3H","4S","8C","KH"};
		
		Game game = new Game(cartasBlanco, cartasNegro);
		assertEquals("Tie.", game.ganador());
	}
	
	
}
