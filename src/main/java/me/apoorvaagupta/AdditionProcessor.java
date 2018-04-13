package me.apoorvaagupta;
import org.springframework.stereotype.Component;


@Component
public class AdditionProcessor <T> implements Processor<T> {

    public <T> T process(T ... v) {

        T sum;

        if(v[0].getClass() == String.class)
            sum = (T) "";
        else
            sum = (T) new Integer(0);

        for (T i: v) {
            if (v[0].getClass() == Integer.class) {
                sum = (T) new Integer((Integer) sum + (Integer) i);
            } else {
                sum = (T) ((String) sum + (String) i);
            }
        }

        return sum;
    }
}
