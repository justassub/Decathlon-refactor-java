package competition;

public class Running100Meters extends RunningEvent {
    private static final double A_PARAMETER = 25.4347;
    private static final double B_PARAMETER = 18;
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
