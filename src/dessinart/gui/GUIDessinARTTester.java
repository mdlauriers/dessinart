package DessinART.gui;

public class GUIDessinARTTester {

	public static void main(String[] args) {
		// Créer notre canvas
		Dessin monDessinArt = new Dessin(500, 500, 0, 0, 5);
		
		//monDessinArt.drawAbs(100, 100);
		//monDessinArt.drawRel(25, 0);
		//monDessinArt.drawRel(-25, 25);
		
		// Dessiner dedans
		monDessinArt.bougerCrayonRel(0, 250);
		monDessinArt.drawRel(250, 0);
		monDessinArt.setPenColor(0, 255, 0);
		monDessinArt.drawAbs(250, 0);
		monDessinArt.bougerCrayonAbs(250, 250);
		monDessinArt.setPenColor(0, 0, 255);
		monDessinArt.drawAbs(250, 500);
		monDessinArt.bougerCrayonAbs(250, 250); 
		monDessinArt.setPenColor(255, 0, 0); // ?????
		monDessinArt.setPenWidth(50);
		monDessinArt.drawRel(250, 0);

		// l'afficher
		monDessinArt.montrer();
	}

}
