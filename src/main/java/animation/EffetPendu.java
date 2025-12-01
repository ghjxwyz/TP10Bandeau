package animation;

import bandeau.Bandeau;

public class EffetPendu implements Effet {

    private final String phraseSecrete;
    private final int intervalleMs;
    private final boolean revelationAleatoire;

    public EffetPendu(String message) {
        this(message, 130, false);
    }

    public EffetPendu(String message, int delayMillis, boolean randomReveal) {
        this.phraseSecrete = message;
        this.intervalleMs = delayMillis;
        this.revelationAleatoire = randomReveal;
    }

    @Override
    public void jouer(Bandeau b) {
        b.setMessage(formatterAvecTirets());
        b.sleep(intervalleMs);

        int longueur = phraseSecrete.length();
        int[] ordre = new int[longueur];
        for (int i = 0; i < longueur; i++)
            ordre[i] = i;

        if (revelationAleatoire) {
            // mélanger l'ordre
            for (int i = longueur - 1; i > 0; i--) {
                int j = (int) (Math.random() * (i + 1));
                int temporaire = ordre[i];
                ordre[i] = ordre[j];
                ordre[j] = temporaire;
            }
        }

        StringBuilder affichage = new StringBuilder(formatterAvecTirets());
        for (int position : ordre) {
            char caractere = phraseSecrete.charAt(position);
            if (caractere == ' ') {
                // garder les espaces
                affichage.setCharAt(position, ' ');
            } else {
                affichage.setCharAt(position, caractere);
            }
            b.setMessage(affichage.toString());
            b.sleep(intervalleMs);
        }
    }

    private String formatterAvecTirets() {
        StringBuilder resultat = new StringBuilder();
        for (char c : phraseSecrete.toCharArray()) {
            if (Character.isWhitespace(c))
                resultat.append(' ');
            else
                resultat.append('_');
        }
        return resultat.toString();
    }
}
