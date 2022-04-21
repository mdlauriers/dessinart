package dessinart.gui;
import java.awt.Color;

public class Ligne {

	private Position debut;
	private Position fin;
	private int largeur;
	// couleur
	private Color couleur;

	public Ligne(Position debut, Position fin, int larg, Color coul) {
		this.debut = debut;
		this.fin = fin;
		this.largeur = larg;
		this.couleur = coul;
	}

	public Ligne(Position debut, int xFin, int yFin, int larg, Color coul) {
		this.debut = debut;
		this.fin = new Position(xFin, yFin);
		this.largeur = larg;
		this.couleur= coul;
	}

	public Position getDebut() {
		final Position deb = this.debut;
		return deb;
	}

	public Position getFin() {
		final Position fina = this.fin;
		return fina;
	}

	public int getLargeur() {
		return this.largeur;
	}

	public Color getCouleur() {
		Color maC = new Color(this.couleur.getRed(), this.couleur.getGreen(), this.couleur.getBlue());
		return maC;
	}

}
