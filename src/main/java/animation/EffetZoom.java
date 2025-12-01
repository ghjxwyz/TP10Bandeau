package animation;

import bandeau.Bandeau;
import java.awt.Font;

public class EffetZoom implements Effet {

    private final String contenuTexte;
    private final int tailleMin;
    private final int tailleMax;
    private final int increment;
    private final int delai;

    public EffetZoom(String message) {
        this(message, 8, 55, 3, 45);
    }

    public EffetZoom(String message, int minSize, int maxSize, int step, int delayMillis) {
        this.contenuTexte = message;
        this.tailleMin = minSize;
        this.tailleMax = maxSize;
        this.increment = step;
        this.delai = delayMillis;
    }

    @Override
    public void jouer(Bandeau b) {
        Font policeOriginale = b.getFont();
        b.setMessage(contenuTexte);
        for (int taille = tailleMin; taille <= tailleMax; taille += increment) {
            b.setFont(new Font(policeOriginale.getName(), policeOriginale.getStyle(), taille));
            b.sleep(delai);
        }
        for (int taille = tailleMax; taille >= tailleMin; taille -= increment) {
            b.setFont(new Font(policeOriginale.getName(), policeOriginale.getStyle(), taille));
            b.sleep(delai);
        }
        b.setFont(policeOriginale);
    }
}
