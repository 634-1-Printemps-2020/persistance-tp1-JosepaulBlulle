package ch.hesge.cours634.counter;

public class Main {

    public static void main(String[] args) {
        ////////////////////////////////////////
        // Test de Counter
        System.out.println("Counter ............................................................................................\n");

        Counter cpt_normal = new Counter();
        System.out.println("Compteur initialisé sans paramètre getValue() : " + cpt_normal.getValue());

        cpt_normal = new Counter(5);
        System.out.println("Compteur initialisé à 5 getValue() : " + cpt_normal.getValue());

        cpt_normal.inc();
        System.out.println("Compteur inc() : " + cpt_normal.getValue());

        cpt_normal.add(-10);
        System.out.println("Compteur add(-10) pas de contrainte : " + cpt_normal.getValue());

        ////////////////////////////////////////
        // Test de UpperLimitedPositiveCounter
        System.out.println("\nUpperLimitedPositiveCounter .........................................................................");
        int[] tab_value = {1, -1, 3, 5};
        int[] tab_max = {0, -4, 1, 10};

        // Test du constructeur (sans paramètre, avec max et avec max + value)
        System.out.println("\n---- ---- TEST CONSTRUCTEUR");
        System.out.println("\n---- SANS PARAMETRE");
        UpperLimitedPositiveCounter cpt_avance = new UpperLimitedPositiveCounter();
        System.out.println("value = " + cpt_avance.getValue() + ", max = "+ cpt_avance.getLimit());

        System.out.println("\n---- MAX EN PARAMETRE");
        for (int max: tab_max) {
            System.out.println("value = " + cpt_avance.getValue() + ", max = "+ max);
            cpt_avance = new UpperLimitedPositiveCounter(max);
        }

        System.out.println("\n---- MAX + VALUE EN PARAMETRE");
        for (int i=0; tab_value.length > i; i++) {
            System.out.println("value = " + tab_value[i] + ", max = "+ tab_max[i]);
            cpt_avance = new UpperLimitedPositiveCounter(tab_max[i], tab_value[i]);
        }

        // Test de l'augmentation du compteur
        System.out.println("\n---- ---- TEST AUGMENTATION COMPTEUR");
        System.out.println("\n---- inc()");
        cpt_avance.inc();
        System.out.println("value = " + cpt_avance.getValue() + ", max = "+ cpt_avance.getLimit());

        System.out.println("\n---- add(x)");
        for (int value: tab_value) {
            System.out.println("add(" + value + ") value = " + (cpt_avance.getValue() + value) + ", max = "+ cpt_avance.getLimit());
            cpt_avance.add(value);
        }

        // Test du changement de la valeur max
        System.out.println("\n---- ---- TEST CHANGEMENT MAX");
        System.out.println("\n---- setLimit(x)");
        for (int max: tab_max) {
            System.out.println("setLimit(" + (max+3) + ") value = " + cpt_avance.getValue() + ", max = "+ (max+3));
            cpt_avance.setLimit(max+3);
        }
    }
}
