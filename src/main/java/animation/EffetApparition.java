package animation;

import bandeau.Bandeau;

public class EffetApparition implements Effet {

    private final String texte;
    private final int delai;

    public EffetApparition(String message) {
        this(message, 100);
    }

    public EffetApparition(String message, int delayMillis) {
        this.texte = message;
        this.delai = delayMillis;
    }

    @Override
    public void jouer(Bandeau b) {
        StringBuilder resultat = new StringBuilder();
        for (int i = 0; i < texte.length(); i++) {
            resultat.append(texte.charAt(i));
            b.setMessage(resultat.toString());
            b.sleep(delai);
        }
    }
}
