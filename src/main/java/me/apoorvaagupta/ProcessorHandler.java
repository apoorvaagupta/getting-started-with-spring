package me.apoorvaagupta;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

//@Component
public class ProcessorHandler<T> {

    @Resource(name = "additionProcessor")
    private Processor<T> processor;

    public ProcessorHandler (Processor<T> processor) {
        this.processor = processor;
    }

    public<T> T process(T ... v) {
        return processor.process(v);
    }
}
