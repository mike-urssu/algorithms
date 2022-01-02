package hyperConnect;

/**
 * Question 5.
 * Create a new package-private class, named Storm, and move all code duplicated in the classes RainStorm and SnowStorm to Storm:
 * · The RainStorm and SnowStorm classes should inherit from the Storm class.
 * · The Storm class should contain all duplicated code(identical fields, methods, and constructor) from the RainStorm and SnowStorm classes.
 * · The functionality of the RainStorm and SnowStorm classes should stay the same.
 */

/**
 * given
 *
 * class RainStorm {
 *     protected double eyeRadius;
 *     protected double eyePositionX;
 *     protected double eyePositionY;
 *
 *     public RainStorm(double eyeRadius, double eyePositionX, double eyePositionY) {
 *         this.eyeRadius = eyeRadius;
 *         this.eyePositionX = eyePositionX;
 *         this.eyePositionY = eyePositionY;
 *     }
 *
 *     public double getEyeRadius() {
 *         return eyeRadius;
 *     }
 *
 *     public double getEyePositionX() {
 *         return eyePositionX;
 *     }
 *
 *     public double getEyePositionY() {
 *         return eyePositionY;
 *     }
 *
 *     public boolean isInEyeOfTheStorm(double positionX, double positionY) {
 *         double distance = Math.sqrt(Math.pow(positionX - eyePositionX, 2) +
 *                 Math.pow(positionY - eyePositionY, 2));
 *         return distance < eyeRadius;
 *     }
 *
 *     public double amountOfRain() {
 *         return eyeRadius * 20;
 *     }
 * }
 *
 * class SnowStorm {
 *     protected double eyeRadius;
 *     protected double eyePositionX;
 *     protected double eyePositionY;
 *     private double amountOfSnow;
 *
 *     public SnowStorm(double eyeRadius, double eyePositionX, double eyePositionY, double amountOfSnow) {
 *         this.eyeRadius = eyeRadius;
 *         this.eyePositionX = eyePositionX;
 *         this.eyePositionY = eyePositionY;
 *         this.amountOfSnow = amountOfSnow;
 *     }
 *
 *     public double getEyeRadius() {
 *         return eyeRadius;
 *     }
 *
 *     public double getEyePositionX() {
 *         return eyePositionX;
 *     }
 *
 *     public double getEyePositionY() {
 *         return eyePositionY;
 *     }
 *
 *     public boolean isInEyeOfTheStorm(double positionX, double positionY) {
 *         double distance = Math.sqrt(Math.pow(positionX - eyePositionX, 2) +
 *                 Math.pow(positionY - eyePositionY, 2));
 *         return distance < eyeRadius;
 *     }
 *
 *     public double getAmountOfSnow() {
 *         return amountOfSnow;
 *     }
 * }
 */

// answer
abstract class Storm {
    protected double eyeRadius;
    protected double eyePositionX;
    protected double eyePositionY;

    public Storm(double eyeRadius, double eyePositionX, double eyePositionY) {
        this.eyeRadius = eyeRadius;
        this.eyePositionX = eyePositionX;
        this.eyePositionY = eyePositionY;
    }

    public double getEyeRadius() {
        return eyeRadius;
    }

    public double getEyePositionX() {
        return eyePositionX;
    }

    public double getEyePositionY() {
        return eyePositionY;
    }

    public boolean isInEyeOfTheStorm(double positionX, double positionY) {
        double distance = Math.sqrt(Math.pow(positionX - eyePositionX, 2) +
                Math.pow(positionY - eyePositionY, 2));
        return distance < eyeRadius;
    }
}

class RainStorm extends Storm {
    public RainStorm(double eyeRadius, double eyePositionX, double eyePositionY) {
        super(eyeRadius, eyePositionX, eyePositionY);
    }

    public double amountOfRain() {
        return eyeRadius * 20;
    }
}

class SnowStorm extends Storm {
    private double amountOfSnow;

    public SnowStorm(double eyeRadius, double eyePositionX, double eyePositionY, double amountOfSnow) {
        super(eyeRadius, eyePositionX, eyePositionY);
        this.amountOfSnow = amountOfSnow;
    }

    public double getAmountOfSnow() {
        return amountOfSnow;
    }
}
