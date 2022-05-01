package dessinart.gui;

public class GUIDessinARTTester {

	public static void main(String[] args) {
		// Créer notre canvas
		Dessin monDessinArt = new Dessin(500, 500, 0, 0, 5);

		/*monDessinArt.drawAbs(100, 100);
		monDessinArt.drawRel(25, 0);
		monDessinArt.drawRel(-25, 25);*/

		monDessinArt.bougerCrayonAbs(250, 250);
		monDessinArt.setPenWidth(50);
		monDessinArt.drawRel(0, 0);

		// Dessiner dedans
		/*monDessinArt.bougerCrayonRel(0, 250);
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
		monDessinArt.bougerCrayonAbs(375, 250);
		monDessinArt.setPenWidth(10);
		monDessinArt.setPenColor(50, 100, 200);
		monDessinArt.drawAbs(250, 125);
		monDessinArt.drawAbs(125, 250);
		monDessinArt.drawAbs(250, 375);
		monDessinArt.drawAbs(375, 250);*/


		// l'afficher
		monDessinArt.montrer();
	}

}
