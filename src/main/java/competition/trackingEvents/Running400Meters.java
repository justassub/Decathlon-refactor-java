package competition.trackingEvents;

import competition.TrackEvent;

public class Running400Meters extends TrackEvent {
    private static final double A_PARAMETER = 1.53775;
    private static final double B_PARAMETER = 82;
    private static final double C_PARAMETER = 1.81;


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
