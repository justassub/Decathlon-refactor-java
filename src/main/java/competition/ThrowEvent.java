package competition;

public abstract class ThrowEvent extends FieldEvent {

    int calculatePoint(Double result) {
        return (int) (get_A_Parameter() * Math.pow((result - get_B_Parameter()), get_C_Parameter()));
    }
}
