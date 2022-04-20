package DessinART.gui;

public class Position {
	
	private int x = 0;
	private int y = 0;
	
	public Position(int _x, int _y) {
		this.x = _x;
		this.y = _y;
	}
	
	public int getX() {
		return this.x;
	}
	
	public int getY() {
		return this.y;
	}
	
	public void setPos(int _x, int _y) { // modifie la position de manière absolue
		this.x = _x;
		this.y = _y;
	}
	
	public void move(int depX, int depY) { // modifie la position selon l'ancienne
		this.x += depX;
		this.y += depY;
	}

}
