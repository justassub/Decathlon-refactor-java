package competition.trackingEvents;

import competition.TrackEvent;

public class Running1500Meters extends TrackEvent {
    private static final double A_PARAMETER = 0.03768;
    private static final double B_PARAMETER = 480;
    private static final double C_PARAMETER = 1.85;

    @Override
    public double get_A_Parameter() {
        return A_PARAMETER;
    }

    @Override
    public double get_B_Parameter() {
        return B_PARAMETER;
    }

    @Override
    public double get_C_Parameter() {
        return C_PARAMETER;
    }
}
