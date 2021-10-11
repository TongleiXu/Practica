package es.ucm.tp1.logic.gameobject;

public class ObstacleList {
	
	private Obstacle[] obstacles;
	private static int obstacleCount;
	
	public ObstacleList(int size) {
		obstacles = new Obstacle[size];
		obstacleCount = 0;
	}
	
	
	public void add(Obstacle o) {
		if(!llena()) {
			obstacles[obstacleCount] = o;
			obstacleCount++;
		}
	}
	public boolean isPositionEmpty(int x, int y) {
		return getObjectInPosition(x, y) == null;
	}
	
	public void removeDead() {
		//crea otra lsita auxiliar, copia solo las monedas que est¨¢n vivas
	}
	public Obstacle getObjectInPosition(int x, int y) {
		int i = 0;
		while(i < obstacleCount  && !obstacles[i].isInPosition(x, y)) 
			i++;
		return obstacles[i];
	}
	public int getObstaclesCount() {
		return obstacleCount;
	}
	//aux
	public boolean llena() {
		return obstacleCount == obstacles.length;
	}
}
