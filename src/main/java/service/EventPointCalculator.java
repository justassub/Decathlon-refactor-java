package service;

@FunctionalInterface
public interface EventPointCalculator {
    int calculate(double aParam, double bParam, double cParam, double result);
}
