package animation;

import bandeau.Bandeau;
import java.awt.Color;

public class EffetClignotant implements Effet {

    private final String contenu;
    private final int nbClignotements;
    private final int duree;

    public EffetClignotant(String message) {
        this(message, 5, 180);
    }

    public EffetClignotant(String message, int flashCount, int delayMillis) {
        this.contenu = message;
        this.nbClignotements = flashCount;
        this.duree = delayMillis;
    }

    @Override
    public void jouer(Bandeau b) {
        Color couleurDepart = b.getForeground();
        for (int i = 0; i < nbClignotements; i++) {
            b.setForeground(Color.BLACK);
            b.setMessage("");
            b.sleep(duree);
            b.setForeground(Color.YELLOW);
            b.setMessage(contenu);
            b.sleep(duree);
        }
        b.setForeground(couleurDepart);
    }
}
