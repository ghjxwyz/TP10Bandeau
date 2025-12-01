import bandeau.Bandeau;
import java.awt.Color;
import java.awt.Font;
import animation.Scenario;
import animation.EffetApparition;
import animation.EffetTeletype;
import animation.EffetPendu;
import animation.EffetArcEnCiel;
import animation.EffetMarquee;
import animation.EffetClignotant;
import animation.EffetRotation;
import animation.EffetZoom;

public class Monanimation {

    public static void main(String[] args) {
        Bandeau monBandeau = new Bandeau();

        Font policeInitiale = monBandeau.getFont();
        Color fondInitial = monBandeau.getBackground();
        Color couleurInitiale = monBandeau.getForeground();

        Scenario monScenario = new Scenario();

        monScenario.ajouterEffet(new EffetTeletype("Démonstration du Bandeau"), 1);
        monScenario.ajouterEffet(new EffetZoom("Effet de zoom"), 2);
        monScenario.ajouterEffet(new EffetRotation("Rotation complète"), 1);
        monScenario.ajouterEffet(new EffetClignotant("Flash lumineux"), 2);
        monScenario.ajouterEffet(new EffetArcEnCiel("Couleurs variées"), 1);
        monScenario.ajouterEffet(new EffetPendu("Révélation progressive"), 1);
        monScenario.ajouterEffet(new EffetMarquee("*** Texte défilant de gauche à droite ***"), 2);
        monScenario.ajouterEffet(new EffetApparition("Fin du spectacle"), 1);

        monScenario.jouer(monBandeau);

        monBandeau.setFont(policeInitiale);
        monBandeau.setBackground(fondInitial);
        monBandeau.setForeground(couleurInitiale);
        monBandeau.sleep(1000);
        monBandeau.close();
    }
}
