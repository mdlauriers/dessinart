package dessinart.value;

import dessinart.exceptions.SemanticException;
import dessinart.syntax.node.AReturnInstr;

import java.awt.Color;
import java.util.*;

public class ColorValue extends Value {

	private int red = 0;
	private int green = 0;
	private int blue = 0;

	private Color couleur;

	public ColorValue(int red, int green, int blue) {

		this.couleur = new Color(red, green, blue);
		this.red = red;
		this.green = green;
		this.blue = blue;

	}

	public ColorValue(Color coul) {
		this.couleur = coul;
		this.red = coul.getRed();
		this.green = coul.getGreen();
		this.blue = coul.getBlue();
	}

	@Override
	public String toString() {

		return couleur.toString(); //???
	}

	@Override
	public boolean equals(Object o) {

		if (this == o){
			return true;
		}

		if(o == null || getClass() != o.getClass()){
			return false;
		}

		return (this.getRed() == ((ColorValue) o).getRed() && this.getGreen() == ((ColorValue) o).getGreen() && this.getBlue() == ((ColorValue) o).getBlue()
				&& this.couleur.equals(((ColorValue) o).getValue()));
	}


	@Override
	public int hashCode() {

		return this.couleur.hashCode();
	}

	public Color getValue() {
		return this.couleur;
	}

	public List<Integer> getValueInts() {

		List<Integer> couleurs = new ArrayList<>();
		couleurs.add(red);
		couleurs.add(green);
		couleurs.add(blue);
		return couleurs;
	}

	public void setCouleur(int r, int g, int b) {
		this.couleur = new Color(r, g, b);
		this.red = r;
		this.green = g;
		this.blue = b;
	}

	public void setRed(int r) {
		this.couleur = new Color (r, this.green, this.blue);
		this.red = r;
	}

	public void setGreen(int g) {
		this.couleur = new Color (this.red, g, this.blue);
		this.green = g;
	}


	public void setBlue(int b) {
		this.couleur = new Color (this.red, this.green, b);
		this.blue = b;
	}

	public int getRed(){
		return this.green;
	}

	public int getGreen() {
		return this.green;
	}

	public int getBlue() {
		return this.blue;
	}


}
