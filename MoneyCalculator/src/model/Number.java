package model;

public class Number {

    private long numerator;
    private long denominator;

    public Number(long numerator, long denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
        reduceNumber();
    }

    public Number(long numerator) {
        this(numerator, 1);
    }

    public Number(double n) {
        Number number = Number.valueOf(n);
        this.numerator = number.getNumerator();
        this.denominator = number.getDenominator();
        reduceNumber();
    }

    public long getNumerator() {
        return numerator;
    }

    public long getDenominator() {
        return denominator;
    }

    @Override
    public String toString() {
        return String.valueOf((double) numerator / (double) denominator);
    }

    @Override
    public boolean equals(Object object) {
        if (object == null)
            return false;
        if (object instanceof Number)
            return equals((Number) object);
        return false;
    }

    private boolean equals(Number number) {
        return (number.numerator == numerator && number.denominator == denominator);
    }

    public Number add(Number number) {
        final long numeratorA = getNumerator();
        final long numeratorB = number.getNumerator();
        final long denominatorA = getDenominator();
        final long denominatorB = number.getDenominator();

        long numeratorC;
        long denominatorC = leastCommonMultiple(denominatorA, denominatorB);

        numeratorC = (denominatorC / denominatorA) * numeratorA
                + (denominatorC / denominatorB) * numeratorB;

        return new Number(numeratorC, denominatorC);
    }

    public Number sub(Number number) {
        final long numeratorA = getNumerator();
        final long numeratorB = number.getNumerator();
        final long denominatorA = getDenominator();
        final long denominatorB = number.getDenominator();

        long numeratorC;
        long denominatorC = leastCommonMultiple(denominatorA, denominatorB);

        numeratorC = (denominatorC / denominatorA) * numeratorA
                - (denominatorC / denominatorB) * numeratorB;

        return new Number(numeratorC, denominatorC);
    }

    public Number multiply(Number number) {
        return new Number(numerator * number.getNumerator(), denominator * number.getDenominator());
    }

    public static Number valueOf(double n) {
        String textNumber = String.valueOf(n);
        long digitsDec = textNumber.length() - 1 - textNumber.indexOf('.');

        long denom = 1;
        for (long i = 0; i < digitsDec; i++) {
            n *= 10;
            denom *= 10;
        }

        long num = (long) Math.round(n);

        return new Number(num, denom);
    }

    private void reduceNumber() {
        int[] primeNumbers = new int[]{2, 3, 5, 7, 11, 13, 15, 17};

        for (Integer prime : primeNumbers)
            if (numerator % prime == 0 && denominator % prime == 0) {
                numerator /= prime;
                denominator /= prime;
            }
    }

    private static long leastCommonMultiple(long numberA, long numberB) {
        return Math.abs(numberA * (numberB / greatestCommonFactor(numberA, numberB)));
    }

    private static long greatestCommonFactor(long numberA, long numberB) {
        long temp = 0;
        while (numberB > 0) {
            temp = numberB;
            numberB = numberA % numberB;
            numberA = temp;
        }
        return numberA;
    }

}
