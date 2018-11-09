package competition.trackingEvents;

import competition.TrackEvent;

public class Running110Hurdles extends TrackEvent {
    private static final double A_PARAMETER = 5.74352;
    private static final double B_PARAMETER = 28.5;
    private static final double C_PARAMETER = 1.92;

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
