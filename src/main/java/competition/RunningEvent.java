package competition;

import java.time.Duration;

public abstract class RunningEvent implements Event {

    @Override
    public double calculatePoints(Object o) {
        return calculatePoint((Duration) o);
    }

    int calculatePoint(Duration time) {
        double seconds = (double) time.toMillis() / 1000;
        return (int) (get_A_Parameter() * Math.pow((get_B_Parameter() - seconds), get_C_Parameter()));

    }
}
