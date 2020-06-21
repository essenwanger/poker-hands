package poker;

import java.util.Arrays;

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
		String resultadoGanador;
		if(algunJugadorTienePar()) {
			resultadoGanador = mostrarGanadorPar();
		}else {
			resultadoGanador = mostrarCartaAlta();
		}
		return resultadoGanador;
	}

	private String mostrarCartaAlta() {
		int numeroJugadorBlanco = convertirCartaANumero(cartaMayorJugadorBlanco());
		int numeroJugadorNegro = convertirCartaANumero(cartaMayorJugadorNegro());

		String tipoCartaJugadorNegro = tipoCarta(cartaMayorJugadorNegro());
		String tipoCartaJugadorBlanco = tipoCarta(cartaMayorJugadorBlanco());
		
		if(numeroJugadorBlanco < numeroJugadorNegro) {
			return "Black wins. - with high card: " + tipoCartaJugadorNegro;
		}else if(numeroJugadorBlanco > numeroJugadorNegro) {
			return "White wins. - with high card: " + tipoCartaJugadorBlanco;
		}else {
			return "Tie.";
		}
	}

	private String mostrarGanadorPar() {
		int parJugadorBlanco = parJugadorBlanco();
		int parJugadorNegro = parJugadorNegro();
		if(parJugadorBlanco > parJugadorNegro){
			return "White wins. - with Pair: " + numeroACarta(parJugadorBlanco);
		}else{
			return "Black wins. - with Pair: " + numeroACarta(parJugadorNegro);
		}
	}

	private boolean algunJugadorTienePar() {
		int parJugadorBlanco = parJugadorBlanco();
		int parJugadorNegro = parJugadorNegro();
		
		return (parJugadorBlanco !=0 || parJugadorNegro !=0) && parJugadorBlanco != parJugadorNegro;
	}
	
	
	
	
	
//	public String ganador() {
//		String cartaMayorBlanco = cartaMayorJugadorBlanco();
//		String cartaMayorNegro = cartaMayorJugadorNegro();
//		int parJugadorBlanco = parJugadorBlanco();
//		int parJugadorNegro = parJugadorNegro();
//
//		
//		int numeroMayorBlanco = convertirCartaANumero(cartaMayorBlanco);
//		int numeroMayorNegro = convertirCartaANumero(cartaMayorNegro);
//		
//		if(parJugadorBlanco == parJugadorNegro){
//			if(numeroMayorBlanco == numeroMayorNegro){
//				return "Tie.";
//			}else{
//				return ganadorXCartaAlta(numeroMayorBlanco,numeroMayorNegro);
//			}
//			
//		}else{
//			return ganadorXPares(parJugadorBlanco, parJugadorNegro);
//		}
//		
//	}
//	private String ganadorXPares(int parJugadorBlanco, int parJugadorNegro) {
//		
//		if(parJugadorBlanco > parJugadorNegro){
//			return "White wins. - with Pair: " + numeroACarta(parJugadorBlanco);
//		}else if(parJugadorNegro > parJugadorBlanco){
//			return "Black wins. - with Pair: " + numeroACarta(parJugadorNegro);
//		}
//		return null;
//	}
//
//	private String ganadorXCartaAlta(int numeroMayorBlanco, int numeroMayorNegro) {
//		
//		if(numeroMayorBlanco < numeroMayorNegro) {
//			return "Black wins. - with high card: " + tipoCarta(cartaMayorJugadorNegro());
//		}else if(numeroMayorBlanco > numeroMayorNegro) {
//			return "White wins. - with high card: " + tipoCarta(cartaMayorJugadorBlanco());
//		}
//		return null;
//	}

	
	private String numeroACarta(int numero){
		String carta;
		if(numero == (14)) {
			carta = "Ace";
		}else if(numero == (13)) {
			carta = "King";
		}else if(numero == (12)) {
			carta = "Queen";
		}else if(numero == (11)) {
			carta = "Jack";
		}else {
			carta = String.valueOf(numero);
		}
		return carta;
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

	public int parJugadorBlanco() {
		
		return parJugador(cartasBlanco);
	}

	public int parJugadorNegro() {
		
		return parJugador(cartasNegro);
	}
	
	private int parJugador(String [] cartas){
		
		int numero;
		int [] cartasNumeros =  new int[5];
		for (int i = 0; i < cartas.length; i++) {
			
			numero = convertirCartaANumero(cartas[i]);
			cartasNumeros[i] = numero;
		}
		
		Arrays.sort(cartasNumeros);
		
		for (int i = cartasNumeros.length -1; i > 0; i--) {
			
			if(cartasNumeros[i] == cartasNumeros[i-1])
				return cartasNumeros[i];
		}
		return 0;
	}
	

}