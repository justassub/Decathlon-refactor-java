package competition.fieldEvents;

import competition.JumpEvent;

public class HighJumpEvent extends JumpEvent {
    private static final double A_PARAMETER = 0.8465;
    private static final double B_PARAMETER = 75;
    private static final double C_PARAMETER = 1.42;

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

