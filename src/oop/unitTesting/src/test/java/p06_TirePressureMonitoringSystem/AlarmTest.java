package oop.unitTesting.src.test.java.p06_TirePressureMonitoringSystem;

import oop.unitTesting.src.main.java.p06_TirePressureMonitoringSystem.Alarm;
import oop.unitTesting.src.main.java.p06_TirePressureMonitoringSystem.Sensor;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

public class AlarmTest {

    private Sensor sensor;
    private Alarm alarm;

    @Before
    public void setUp() {
        this.sensor = Mockito.mock(Sensor.class);
        this.alarm = new Alarm(sensor);
    }

    @Test
    public void test_Alarm_LowPressure() {
        when(sensor.popNextPressurePsiValue()).thenReturn(10.00);

        alarm.check();

        assertTrue(alarm.getAlarmOn());
    }

    @Test
    public void test_Alarm_HighPressure() {
        when(sensor.popNextPressurePsiValue()).thenReturn(25.00);

        alarm.check();

        assertTrue(alarm.getAlarmOn());
    }

    @Test
    public void test_Alarm_NormalPressure() {
        when(sensor.popNextPressurePsiValue()).thenReturn(19.00);

        alarm.check();

        assertFalse(alarm.getAlarmOn());
    }
}