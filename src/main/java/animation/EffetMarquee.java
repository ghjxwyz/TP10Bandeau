package animation;

import bandeau.Bandeau;

public class EffetMarquee implements Effet {

    private final String texteComplet;
    private final int tailleFenetre;
    private final int tempo;
    private final int nbRepetitions;

    public EffetMarquee(String message) {
        this(message, 25, 50, 1);
    }

    public EffetMarquee(String message, int windowSize, int delayMillis, int repetitions) {
        this.texteComplet = message;
        this.tailleFenetre = windowSize;
        this.tempo = delayMillis;
        this.nbRepetitions = repetitions;
    }

    @Override
    public void jouer(Bandeau b) {
        String espacement = "";
        for (int i = 0; i < tailleFenetre; i++)
            espacement += ' ';
        String texteAvecEspaces = espacement + texteComplet + espacement;

        for (int iteration = 0; iteration < nbRepetitions; iteration++) {
            for (int debut = 0; debut + tailleFenetre <= texteAvecEspaces.length(); debut++) {
                String segment = texteAvecEspaces.substring(debut, Math.min(debut + tailleFenetre, texteAvecEspaces.length()));
                b.setMessage(segment);
                b.sleep(tempo);
            }
        }
    }
}
