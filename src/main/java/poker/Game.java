package poker;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BooleanSupplier;

public class Game {

	private List<String> baraja;
	private List<String> cartasBlanco;
	private List<String> cartasNegro;
	
	public Game() {
		this.baraja = new ArrayList<String>();
		baraja.add("2C");
		baraja.add("3C");
		baraja.add("4C");
		baraja.add("5C");
		baraja.add("6C");
		baraja.add("7C");
		baraja.add("8C");
		baraja.add("9C");
		baraja.add("TC");
		baraja.add("JC");
		baraja.add("QC");
		baraja.add("KC");
		baraja.add("AC");
		baraja.add("2D");
		baraja.add("3D");
		baraja.add("4D");
		baraja.add("5D");
		baraja.add("6D");
		baraja.add("7D");
		baraja.add("8D");
		baraja.add("9D");
		baraja.add("TD");
		baraja.add("JD");
		baraja.add("QD");
		baraja.add("KD");
		baraja.add("AD");
		baraja.add("2H");
		baraja.add("3H");
		baraja.add("4H");
		baraja.add("5H");
		baraja.add("6H");
		baraja.add("7H");
		baraja.add("8H");
		baraja.add("9H");
		baraja.add("TH");
		baraja.add("JH");
		baraja.add("QH");
		baraja.add("KH");
		baraja.add("AH");
		baraja.add("2S");
		baraja.add("3S");
		baraja.add("4S");
		baraja.add("5S");
		baraja.add("6S");
		baraja.add("7S");
		baraja.add("8S");
		baraja.add("9S");
		baraja.add("TS");
		baraja.add("JS");
		baraja.add("QS");
		baraja.add("KS");
		baraja.add("AS");
	}

	public void repartirCartas(List<String> cartasBlanco, List<String> cartasNegro) {
		this.cartasBlanco = cartasBlanco;
		this.cartasNegro = cartasNegro;
	}

	public int cantidadCartasJugadorBlanco() {
		return cartasBlanco.size();
	}

	public int cantidadCartasJugadorNegro() {
		return cartasNegro.size();
	}

	public boolean jugadorBlancoGana() {	
		if(cartasBlanco.contains("QH")) {
			return true;
		}
		return false;
	}

	public boolean jugadorNegroGana() {
		return !jugadorBlancoGana();
	}

	public int cartaMayorJugadorBlanco() {
		int cartaMayor = 0;
		for (String carta : cartasBlanco) {
			String numeroCarta = carta.substring(0,1);
			cartaMayor = convertirCartaANumero(numeroCarta);
		}
		
		return cartaMayor;
	}

	public int convertirCartaANumero(String numeroCarta) {
		int carta;
		if(numeroCarta.equals("A")) {
			carta = 14;
		}else if(numeroCarta.equals("K")) {
			carta = 13;
		}else if(numeroCarta.equals("Q")) {
			carta = 12;
		}else if(numeroCarta.equals("J")) {
			carta = 11;
		}else if(numeroCarta.equals("T")) {
			carta = 10;
		}else {
			carta = Integer.parseInt(numeroCarta);
		}
		return carta;
	}
	
	

}
