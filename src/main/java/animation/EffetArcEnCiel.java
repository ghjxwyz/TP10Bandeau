package animation;

import bandeau.Bandeau;
import java.awt.Color;

public class EffetArcEnCiel implements Effet {

    private final String texte;
    private final int nombreEtapes;
    private final int pauseMs;

    public EffetArcEnCiel(String message) {
        this(message, 40, 70);
    }

    public EffetArcEnCiel(String message, int steps, int delayMillis) {
        this.texte = message;
        this.nombreEtapes = steps;
        this.pauseMs = delayMillis;
    }

    @Override
    public void jouer(Bandeau b) {
        b.setMessage(texte);
        Color couleurOriginale = b.getForeground();
        for (int i = 0; i < nombreEtapes; i++) {
            float teinte = (float) i / nombreEtapes;
            Color nouvelleCouleur = Color.getHSBColor(teinte, 0.9f, 0.9f);
            b.setForeground(nouvelleCouleur);
            b.sleep(pauseMs);
        }
        b.setForeground(couleurOriginale);
    }
}
