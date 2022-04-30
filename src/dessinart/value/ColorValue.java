package DessinART.value;

import java.awt.Color;
import java.util.*;

public class ColorValue extends Value {
	
	private int red = 0;
	private int green = 0;
	private int blue = 0;
	
	private Color couleur;

	public ColorValue(int red, int green, int blue) {
		try {
			this.couleur = new Color(red, green, blue);
			this.red = red;
			this.green = green;
			this.blue = blue;
			
		} catch (IllegalArgumentException e) {
			// erreur de sémantique?
			// TODO
		}
		
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
	public boolean equals(Object obj) {
		
		//TODO
		
		return true;
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
		try {
			this.couleur = new Color(r, g, b);
			this.red = r;
			this.green = g;
			this.blue = b;
		} catch (IllegalArgumentException e) {
			 // TODO
		}
	}
	
	public void setRed(int r) {
		try {
			this.couleur = new Color (r, this.green, this.blue);
			this.red = r;
		} catch (IllegalArgumentException e){
			// TODO
		}
	}
	
	public void setGreen(int g) {
		try {
			this.couleur = new Color (this.red, g, this.blue);
			this.green = g;
		} catch (IllegalArgumentException e){
			// TODO
		}
	}

	
	public void setBlue(int b) {
		try {
			this.couleur = new Color (this.red, this.green, b);
			this.blue = b;
		} catch (IllegalArgumentException e){
			// TODO
		}
	}


}
