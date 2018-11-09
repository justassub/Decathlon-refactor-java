package competition;

public abstract class FieldEvent implements Event {
    @Override
    public int calculatePoints(Object o) {
        return calculatePoint((Double) o);
    }

    abstract int calculatePoint(Double o);
}
