package animation;

import bandeau.Bandeau;

public class EffetRotation implements Effet {

    private final String texteAffiche;
    private final int nombrePas;
    private final int pause;

    public EffetRotation(String message) {
        this(message, 30, 40);
    }

    public EffetRotation(String message, int steps, int delayMillis) {
        this.texteAffiche = message;
        this.nombrePas = steps;
        this.pause = delayMillis;
    }

    @Override
    public void jouer(Bandeau b) {
        b.setMessage(texteAffiche);
        for (int i = 0; i < nombrePas; i++) {
            double angleRotation = (2.0 * Math.PI * i) / nombrePas;
            b.setRotation(angleRotation);
            b.sleep(pause);
        }
        b.setRotation(0.0);
    }
}
