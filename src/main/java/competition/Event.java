package competition;

public interface Event {
    //CLASS MUST OVERRIDE !
    int  calculatePoints(Object o);

    double get_A_Parameter();

    double get_B_Parameter();

    double get_C_Parameter();
}
