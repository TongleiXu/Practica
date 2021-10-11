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
		boolean refreshDisplay = true;
		boolean terminado = false;
		
		while(!game.isFinished()) {
			if(refreshDisplay) printGame();	
				
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
					case "h":
					case "help":
						for(int i =0;i<HELP.length;i++) 
							System.out.println(HELP[i]);
						refreshDisplay = false;
						break;
						
					case "i":
					case "info":
						System.out.println(game.getInfo());
						 refreshDisplay = false;
						 break;
						 
					case "":
					case "n":
					case "none":
						game.update();
						refreshDisplay = true;
						break;
						
					case "q":					
						game.goUp();
						refreshDisplay = true;
						break;
						 
					case "a":
						game.goDown();
						refreshDisplay = true;
						break;
					case "e":	
					case "exit":
						terminado=true;
						refreshDisplay = false;
						break;
					case "r":
					case "reset":
						game.reset();
						refreshDisplay = true;
						break;
					case "t":
					case "test":
						game.setTestMode();
						refreshDisplay = false;
						break;
					default:
    					System.out.println("[ERROR]" + UNKNOWN_COMMAND_MSG);
					}
					
				}
			}
			
		}
		System.out.println("[GAME OVER] " + game.getEndGameMessage());
	}

}
