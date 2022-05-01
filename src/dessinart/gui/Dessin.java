package dessinart.gui;

import java.awt.*;
import java.util.ArrayList;

import javax.swing.*;

public class Dessin extends JFrame{

	///////////////////////////////////////////////////////////////
	// TODO: gestion d'erreur
	///////////////////////////////////////////////////////////////

	private Position crayon;
	private int trait; // width du crayon
	// couleur actuelle
	private Color lineColor = new Color(0, 0, 0);
	// private Color backGroungColor = new Color(255, 255, 255); // si on veut!
	private ArrayList<Ligne> lignes;

	/*public Dessin(){}*/

	public Dessin(int x, int y, int penX, int penY, int lineWidth) {
		this.crayon = new Position(penX, penY);
		this.trait = lineWidth;
		this.lignes = new ArrayList<>();
		setTitle("DessinART");
		try {
			ImageIcon img = new ImageIcon(this.getClass().getResource("./dessinartbasetransp.png"));
			this.setIconImage(img.getImage());
		} catch (Exception e) {
			System.out.println("Erreur: Logo introuvable!"); // !
		}

		setSize(x, y);
	}

	public void montrer() { // afficher notre canvas (JFrame)
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE); //?
		setVisible(true);
	}

	public void paint(Graphics g) { // dessiner dans le canvas(JFrame) - appelé automatiquement
		try {
			Graphics2D graph = (Graphics2D) g; // faire gestion d'erreur
			for (Ligne maLigne : lignes) {
				graph.setStroke(new BasicStroke(maLigne.getLargeur()));
				graph.setColor(maLigne.getCouleur());
				graph.drawLine(maLigne.getDebut().getX(), maLigne.getDebut().getY(), maLigne.getFin().getX(), maLigne.getFin().getY());
			}
		} catch (Exception e) {
			System.out.println("Erreur Inconnue"); // TODO
		}

	}

	// Fcts sur le crayon

	public void bougerCrayonRel(int depX, int depY) { // déplacement du crayon selon sa pos initiale (move)
		int newX = this.crayon.getX() + depX;
		int newY = this.crayon.getY() + depY;
		this.crayon = new Position(newX, newY);
	}

	public void bougerCrayonAbs(int _X, int _Y) { // déplacement absolu du crayon (teleport)
		this.crayon = new Position(_X, _Y);
	}

	public void drawRel(int depX, int depY) { //draw selon la position de départ (draw)
		int finX = crayon.getX() + depX;
		int finY = crayon.getY() + depY;
		Ligne maLigne = new Ligne(this.crayon, finX, finY, this.trait, this.lineColor);
		this.lignes.add(maLigne);
		bougerCrayonRel(depX, depY);
	}

	public void drawAbs(int xFin, int yFin) { // drawTo/drawAbs
		//Color maCouleur = new Color(this.lineColor.getRed(), this.lineColor.getGreen(), this.lineColor.getBlue());
		Ligne maLigne = new Ligne(this.crayon, xFin, yFin, this.trait, this.lineColor);
		this.lignes.add(maLigne);
		bougerCrayonAbs(xFin, yFin);
	}

	public void setPenWidth(int width) { // setWidth
		this.trait = width;
	}

	public void setPenColor(int r, int g, int b) { // setColor (gestion d'erreur ici?)
		this.lineColor = new Color(r, g, b);
	}

	public void setPenColor(Color couleur) { // setColor (gestion d'erreur ici?)
		this.lineColor = new Color(couleur.getRed(), couleur.getGreen(), couleur.getBlue());
	}

	public void setDimensions(int width, int height){
		setSize(width, height);
	}
}
