package me.apoorvaagupta;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class InputHandler<T> {

    private Reader<T> reader;

    @Autowired
    public InputHandler (Reader<T> reader) {
        this.reader = reader;
    }

    public <T> T takeInput() {
        return (T)(this.reader.input());
    }
}
