package me.apoorvaagupta;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OutputHandler<T> {
    private Writer<T> writer;

    @Autowired
    public OutputHandler (Writer<T> writer) {
        this.writer = writer;
    }

    public void writeOutput(T var) {
        this.writer.output(var);
    }

}
