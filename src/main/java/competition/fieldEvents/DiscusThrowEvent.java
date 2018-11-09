package competition.fieldEvents;

import competition.ThrowEvent;

public class DiscusThrowEvent extends ThrowEvent {
    private static final double A_PARAMETER = 12.91;
    private static final double B_PARAMETER = 4;
    private static final double C_PARAMETER = 1.1;

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