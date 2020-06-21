package poker;


import static org.junit.Assert.*;

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
	
	@Test 
	public void jugadorBlancoTieneParde9(){
		String[] cartasBlanco= new String[]{"4H","9D","3S","9C","2D"};
		String[] cartasNegro=new String[]{"2C","3H","4S","8C","5H"};
		
		Game game = new Game(cartasBlanco, cartasNegro);
		assertEquals(9, game.parJugadorBlanco());
	}
	
	@Test 
	public void jugadorBlancoTienePardeK(){
		String[] cartasBlanco= new String[]{"KH","9D","3S","9C","KD"};
		String[] cartasNegro=new String[]{"2C","3H","4S","8C","5H"};
		
		Game game = new Game(cartasBlanco, cartasNegro);
		assertEquals(13, game.parJugadorBlanco());
	}
	
	@Test 
	public void jugadorBlancoTieneParde2(){
		String[] cartasBlanco= new String[]{"2H","9D","3S","7C","2D"};
		String[] cartasNegro=new String[]{"2C","3H","4S","8C","5H"};
		
		Game game = new Game(cartasBlanco, cartasNegro);
		assertEquals(2, game.parJugadorBlanco());
	}
	
	@Test 
	public void jugadorBlancoNoTienePar(){
		String[] cartasBlanco= new String[]{"2H","9D","3S","7C","5D"};
		String[] cartasNegro=new String[]{"2C","3H","4S","8C","5H"};
		
		Game game = new Game(cartasBlanco, cartasNegro);
		assertEquals(0, game.parJugadorBlanco());
	}
	
	@Test 
	public void jugadorNegroTieneParde5(){
		String[] cartasBlanco= new String[]{"4H","9D","3S","9C","2D"};
		String[] cartasNegro=new String[]{"5C","3H","4S","8C","5H"};
		
		Game game = new Game(cartasBlanco, cartasNegro);
		assertEquals(5, game.parJugadorNegro());
	}
	
	
	@Test 
	public void jugadorBlancoParde9JugadorNegroCartaAlta8_ganaBlanco(){
		String[] cartasBlanco= new String[]{"2H","3D","9S","9C","4D"};
		String[] cartasNegro=new String[]{"2C","3H","4S","8C","5H"};
		
		Game game = new Game(cartasBlanco, cartasNegro);
		
		assertEquals(9, game.parJugadorBlanco());
		assertEquals("8C", game.cartaMayorJugadorNegro());
		assertEquals(0, game.parJugadorNegro());
		assertEquals("White wins. - with Pair: 9", game.ganador());
		
		
	}
	
	@Test 
	public void jugadorNegroPardeKJugadorBlancoCartaAlta9_GanaNegro(){
		String[] cartasBlanco= new String[]{"2H","7D","9S","3C","4D"};
		String[] cartasNegro=new String[]{"KC","3H","4S","KC","5H"};
		
		Game game = new Game(cartasBlanco, cartasNegro);
		assertEquals(13, game.parJugadorNegro());
		assertEquals("9S", game.cartaMayorJugadorBlanco());
		assertEquals(0, game.parJugadorBlanco());
		assertEquals("Black wins. - with Pair: King", game.ganador());
	}
	
	@Test 
	public void jugadorBlancoParde5JugadorNegroParde5_Empate(){
		String[] cartasBlanco= new String[]{"2H","3D","5S","JC","5D"};
		String[] cartasNegro=new String[]{"2C","5H","4S","JS","5H"};
		
		Game game = new Game(cartasBlanco, cartasNegro);
		assertEquals(5, game.parJugadorBlanco());
		assertEquals(5, game.parJugadorNegro());
		assertEquals("JC", game.cartaMayorJugadorBlanco());
		assertEquals("JS", game.cartaMayorJugadorNegro());
		assertEquals("Tie.", game.ganador());
	}
	
}