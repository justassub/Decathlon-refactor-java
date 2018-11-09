package competition.fieldEvents;

import competition.JumpEvent;

public class LongJumpEvent extends JumpEvent {
    private static final double A_PARAMETER = 0.14354;
    private static final double B_PARAMETER = 220;
    private static final double C_PARAMETER = 1.4;

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
