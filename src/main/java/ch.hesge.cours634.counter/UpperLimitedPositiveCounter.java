package ch.hesge.cours634.counter;

public class UpperLimitedPositiveCounter extends Counter {
    private int max = 10;

    public UpperLimitedPositiveCounter() { super(); }

    public UpperLimitedPositiveCounter(int max) {
        super();
        try {
            if (max <= 0) { throw new CounterException("\tLa limite doit être plus grande que 0\n\tLa limite par défaut de " + this.max + " a été initialisée"); }
            this.max = max;

        } catch(CounterException ignored) { }
    }

    public UpperLimitedPositiveCounter(int max, int value) {
        super(value);
        try {
            String erreurs = "";
            if (value <= 0) {
                erreurs += "\tLe compteur doit être plus grand que 0\n";
                super.value = 1;
            }
            if (max <= 0) { erreurs += "\tLa limite doit être plus grande que 0\n"; }
            if (value > max && erreurs.length() == 0) { erreurs += "\tLe compteur doit être plus petit ou égal à la limite\n"; }
            if (erreurs.length() > 0) { throw new CounterException(erreurs + "\tLes valeurs ont été initialisées comme ceci (value = " + super.value + ", max = " + this.max + ")"); }
            this.max = max;

        } catch(CounterException ignored) { }

    }

    public void inc() {
        try {
            if (super.value == this.max) { throw new CounterException("\tLa compteur à atteint la valeur limite de " + this.max); }

        } catch(CounterException ignored) { return; }
        super.value++;
    }

    public void add(int step) {
        try {
            if (step <= 0) { throw new CounterException("\tL'augmentation doit être plus grande que 0\n\tLe compteur retourne à sa valeur d'origine de "+ super.value); }
            if (super.value + step > this.max) { throw new CounterException("\tL'augmentation du compteur dépasse la valeur max de " + this.max + ".\n\tLe compteur retourne à sa valeur d'origine de "+ super.value); }
            super.value += step;

        } catch(CounterException ignored) { }

    }

    public int getValue(){ return super.value; }

    public int getLimit() { return this.max; }

    public void setLimit(int max) {
        try {
            if (max <= 0) { throw new CounterException("\tLa limite doit être plus grande que 0"); }
            if (super.value > max) { throw new CounterException("\tLe compteur doit être plus petit ou égal à la limite"); }
            this.max = max;

        } catch(CounterException ignored) { }
    }
}
