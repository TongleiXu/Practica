package es.ucm.tp1.logic.gameobject;

public class CoinList {
	
	private Coin[] coins;
	private static int coinCount;
	public CoinList(int size) {
		coins = new Coin[size];
		coinCount = 0;
	}
	public void add(Coin c) {
		if(!llena()) {
			coins[coinCount] = c;
			coinCount++;
		}
	}
	public Coin getObjectInPosition(int x, int y) {
		int i = 0;
		while(i < coinCount && !coins[i].isInPosition(x, y)) 
				i++;
		return coins[i];
	}
	public boolean isPositionEmpty(int x, int y) {
		/*System.out.println("test");
		if(coins[0] == null)
			System.out.println("true");*/
		return getObjectInPosition(x, y) == null;
	}
	public void removeDead() {
		boolean enc = false;
		int i = 0;
		while(!enc && i < coinCount) {
			// posicion i del lista hay muerto
			if(!coins[i].isAlive()) {
				//mueve hacia dalant,al final posicion de contador = null
				for(int j = i; j < coinCount; j++) { 
					coins[j] = coins[j + 1];
				}
				coinCount--;
				enc = true;
			}
			else
				i++;
		}
	}
	
	
	//aux
	public boolean llena() {
		return coinCount == coins.length;
	}

	public int getCoinCount() {
		return coinCount;
	}
}
