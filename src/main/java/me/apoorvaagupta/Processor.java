package me.apoorvaagupta;

public interface Processor<T> {

    public <T> T process(T ... v);
}
