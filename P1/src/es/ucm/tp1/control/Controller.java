package es.ucm.tp1.control;

import java.util.Scanner;

import es.ucm.tp1.logic.Game;

public class Controller {

	private static final String PROMPT = "Command > ";

	private static final String UNKNOWN_COMMAND_MSG = "Unknown command";

	/* @formatter:off */
	private static final String[] HELP = new String[] {
		"Available commands:",
		"[h]elp: show this help",
		"[i]nfo: prints gameobjet info",
		"[n]one | []: update",
		"[q]: go up",
		"[a]: go down",
		"[e]xit: exit game",
		"[r]eset: reset game",
		"[t]est: enables test mode",	
	};
	/* @formatter:off */

	private Game game;

	private Scanner scanner;

	public Controller(Game game, Scanner scanner) {
		this.game = game;
		this.scanner = scanner;
	}

	public void printGame() {
		System.out.println(game);
	}

	public void run() {
		// TODO fill your code
		boolean refrescarTablero = true;
		boolean terminado = false;
		while( !terminado ) {
			if(refrescarTablero)
			{
				printGame();
			}
			System.out.println(PROMPT);
			String line=scanner.nextLine();
			String[] words=line.toLowerCase().trim().split(" ");
			System.out.println("Debug Executing " + line);
			if(words.length==0)
			{ 
				System.out.println(String.format("ERROR &s, " + UNKNOWN_COMMAND_MSG));
			}
			else
			{
				{
					switch (words[0])
					{
					case "i":
					case "info":
						System.out.println(game.getInfo());
					case "q":
						game.goUp();
					case "a":
						game.goDown();
					case "return":
						game.reiniciar();
					case "exit":
						terminado=true;
					case "help":
						for(int i =0;i<HELP.length;i++) {
							System.out.println(HELP[i]);
						}
						
					}
					
				}
			}
			
		}
		System.out.println("GAME OVER");
	}

}
