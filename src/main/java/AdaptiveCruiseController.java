public class AdaptiveCruiseController {
    // Inputs
    private double radarDist;
    private double v2xSpeedLimit;
    private boolean isObstacleDetected;

    // Output
    private double targetVelocity;

    public AdaptiveCruiseController(double radarDist, double v2xSpeedLimit, boolean isObstacleDetected) {
        this.radarDist = radarDist;
        this.v2xSpeedLimit = v2xSpeedLimit;
        this.isObstacleDetected = isObstacleDetected;
        calculateVelocity();
    }

    private void calculateVelocity() {
        if (isObstacleDetected) {
            targetVelocity = 0.0;
        } else {
            // Assume radarDist is current speed
            targetVelocity = Math.min(radarDist, v2xSpeedLimit);
        }
    }

    public double getTargetVelocity() {
        return targetVelocity;
    }
}
