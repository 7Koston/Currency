package by.st.currency.main.table.data;

import java.util.Comparator;

public final class Comparators {

    private Comparators() {
        //no instance
    }

    public static Comparator<Currency> getCharCodeComparator() {
        return new CharCodeComparator();
    }

    public static Comparator<Currency> getRateComparator() {
        return new RateComparator();
    }

    public static Comparator<Currency> getNameComparator() {
        return new NameComparator();
    }

    public static Comparator<Currency> getScaleComparator() {
        return new ScaleComparator();
    }


    private static class CharCodeComparator implements Comparator<Currency> {

        @Override
        public int compare(final Currency o1, final Currency o2) {
            return o1.getCharCode().compareTo(o2.getCharCode());
        }
    }

    private static class ScaleComparator implements Comparator<Currency> {

        @Override
        public int compare(final Currency o1, final Currency o2) {
            return Double.compare(o1.getScale(), o2.getScale());
        }
    }

    private static class NameComparator implements Comparator<Currency> {

        @Override
        public int compare(final Currency o1, final Currency o2) {
            return o1.getName().compareTo(o2.getName());
        }
    }

    private static class RateComparator implements Comparator<Currency> {

        @Override
        public int compare(final Currency o1, final Currency o2) {
            return Double.compare(o1.getRate(), o2.getRate());
        }
    }
}
