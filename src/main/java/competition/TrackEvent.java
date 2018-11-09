package competition;

import java.time.Duration;

public abstract class TrackEvent implements Event {

    @Override
    public int calculatePoints(Object o) {
        return calculatePoint((Duration) o);
    }

    private int calculatePoint(Duration time) {
        double seconds = (double) time.toMillis() / 1000;
        return (int) (get_A_Parameter() * Math.pow((get_B_Parameter() - seconds), get_C_Parameter()));

    }
}
