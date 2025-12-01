package animation;

import java.util.ArrayList;
import java.util.List;

public class Scenario {

    private static class ElementScenario {
        final Effet effet;
        final int nbRepetitions;

        ElementScenario(Effet effet, int repetitions) {
            this.effet = effet;
            this.nbRepetitions = repetitions;
        }
    }

    private final List<ElementScenario> listeEffets = new ArrayList<>();

    public void ajouterEffet(Effet e, int repetitions) {
        if (repetitions < 1)
            throw new IllegalArgumentException("Le nombre de répétitions doit être supérieur ou égal à 1");
        listeEffets.add(new ElementScenario(e, repetitions));
    }

    public void jouer(bandeau.Bandeau b) {
        for (ElementScenario element : listeEffets) {
            for (int compteur = 0; compteur < element.nbRepetitions; compteur++) {
                element.effet.jouer(b);
            }
        }
    }
}
