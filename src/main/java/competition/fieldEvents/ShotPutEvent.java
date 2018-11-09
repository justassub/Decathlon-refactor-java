package competition.fieldEvents;

import competition.ThrowEvent;

public class ShotPutEvent extends ThrowEvent {
    private static final double A_PARAMETER = 51.39;
    private static final double B_PARAMETER = 1.5;
    private static final double C_PARAMETER = 1.05;

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

