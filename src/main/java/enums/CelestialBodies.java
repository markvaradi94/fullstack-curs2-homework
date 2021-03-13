package enums;

import java.text.DecimalFormat;

public enum CelestialBodies {
    MERCURY(0.3),
    VENUS(0.9),
    MOON(0.1),
    MARS(0.3),
    JUPITER(2.5),
    SATURN(1),
    URANUS(0.8),
    NEPTUNE(1.1),
    PLUTO(0),
    IO(0.18),
    EUROPA(0.13),
    GANYMEDE(0.14),
    CALLISTO(0.12),
    SUN(27),
    WHITE_DWARF(1_300_000);

    private double gravityRatioComparedToEarth;

    CelestialBodies(double gravityRatio) {
        this.gravityRatioComparedToEarth = gravityRatio;
    }

    public double weightEquivalentOnEarth(double weight) {
        DecimalFormat format = new DecimalFormat("#.#");
        double equivalentWeight = weight * gravityRatioComparedToEarth;
        return Double.parseDouble(format.format(equivalentWeight));
    }

    public double getGravityRatioComparedToEarth() {
        return gravityRatioComparedToEarth;
    }

    @Override
    public String toString() {
        return this.name() + ", ratio = " + gravityRatioComparedToEarth;
    }
}
