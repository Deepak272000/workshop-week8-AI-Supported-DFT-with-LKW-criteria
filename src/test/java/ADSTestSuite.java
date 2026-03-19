import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class ADSTestSuite {

    @Nested
    @DisplayName("Program P: System-Level Integration")
    class SystemTest {
        @Test
        void testObstacleDetected() {
            AdaptiveCruiseController acc = new AdaptiveCruiseController(50.0, 60.0, true);
            assertEquals(0.0, acc.getTargetVelocity());
        }

        @Test
        void testRadarDistLessThanV2xSpeedLimit() {
            AdaptiveCruiseController acc = new AdaptiveCruiseController(40.0, 60.0, false);
            assertEquals(40.0, acc.getTargetVelocity());
        }

        @Test
        void testRadarDistGreaterThanV2xSpeedLimit() {
            AdaptiveCruiseController acc = new AdaptiveCruiseController(70.0, 60.0, false);
            assertEquals(60.0, acc.getTargetVelocity());
        }

        @Test
        void testRadarDistEqualsV2xSpeedLimit() {
            AdaptiveCruiseController acc = new AdaptiveCruiseController(60.0, 60.0, false);
            assertEquals(60.0, acc.getTargetVelocity());
        }
        
    }

    @Nested
    @DisplayName("Component Q: Isolated Data Integrity")
    class ComponentTest {
        @Test
        void testComponentAdequacy() {
            SensorParser parser = new SensorParser();
            assertAll("LKW Inadequacy Checks",
                () -> assertNotNull(parser.parse("-1.0"), "Missing parity handling"),
                () -> assertTrue(parser.getLastValue() >= 0, "Non-physical velocity"),
                () -> assertNull(parser.parse("bad_data"), "Malformed string handling")
            );
        }
    }
}
