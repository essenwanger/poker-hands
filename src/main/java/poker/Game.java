package poker;

public class Game {

	private String[] cartasBlanco;
	private String[] cartasNegro;


	public Game(String[] cartasBlanco, String[] cartasNegro) {
		this.cartasBlanco = cartasBlanco;
		this.cartasNegro = cartasNegro;
	}

	public String cartaMayorJugadorBlanco() {
		return cartaMayor(cartasBlanco);
	}

	public String cartaMayorJugadorNegro() {
		return cartaMayor(cartasNegro);
	}
	
	private String cartaMayor(String[] cartas) {
		int numeroMayor = 0;
		String cartaMayor = "";
		for (String carta : cartas) {
			int numero = convertirCartaANumero(carta);
			if(numeroMayor<numero) {
				numeroMayor = numero;
				cartaMayor = carta;
			}
		}
		return cartaMayor;
	}
	
	private int convertirCartaANumero(String carta) {
		String numeroCarta = carta.substring(0,1);
		int numero;
		if(numeroCarta.equals("A")) {
			numero = 14;
		}else if(numeroCarta.equals("K")) {
			numero = 13;
		}else if(numeroCarta.equals("Q")) {
			numero = 12;
		}else if(numeroCarta.equals("J")) {
			numero = 11;
		}else if(numeroCarta.equals("T")) {
			numero = 10;
		}else {
			numero = Integer.parseInt(numeroCarta);
		}
		return numero;
	}

	public String ganador() {
		String cartaMayorBlanco = cartaMayorJugadorBlanco();
		String cartaMayorNegro = cartaMayorJugadorNegro();
		int numeroMayorBlanco = convertirCartaANumero(cartaMayorBlanco);
		int numeroMayorNegro = convertirCartaANumero(cartaMayorNegro);
		if(numeroMayorBlanco < numeroMayorNegro) {
			return "Black wins. - with high card: " + tipoCarta(cartaMayorNegro);
		}else if(numeroMayorBlanco > numeroMayorNegro) {
			return "White wins. - with high card: " + tipoCarta(cartaMayorBlanco);
		}else {
			return "Tie.";
		}
	}
	
	private String tipoCarta(String carta) {
		String numeroCarta = carta.substring(0,1);
		String tipoCarta = numeroCarta;
		if(numeroCarta.equals("A")) {
			tipoCarta = "Ace";
		}else if(numeroCarta.equals("K")) {
			tipoCarta = "King";
		}else if(numeroCarta.equals("Q")) {
			tipoCarta = "Queen";
		}else if(numeroCarta.equals("J")) {
			tipoCarta = "Jack";
		}else if(numeroCarta.equals("T")) {
			tipoCarta = "10";
		}
		return tipoCarta;
	}

}
