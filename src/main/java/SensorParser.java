public class SensorParser {
    private double lastValue = 0.0;

    public Double parse(String sensorData) {
        try {
            double value = Double.parseDouble(sensorData);
            // Handle non-physical values (e.g., negative velocity)
            if (value < 0) {
                lastValue = 0.0;
                return lastValue;
            }
            lastValue = value;
            return lastValue;
        } catch (NumberFormatException e) {
            // Handle malformed strings
            lastValue = 0.0;
            return null;
        }
    }

    public double getLastValue() {
        return lastValue;
    }
}
