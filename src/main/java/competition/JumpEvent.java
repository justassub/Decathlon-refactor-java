package competition;

public abstract class JumpEvent extends FieldEvent {

    int calculatePoint(Double result) {
        double centimeters = result * 100;
        return (int) (get_A_Parameter() * Math.pow((centimeters - get_B_Parameter()), get_C_Parameter()));
    }
}
