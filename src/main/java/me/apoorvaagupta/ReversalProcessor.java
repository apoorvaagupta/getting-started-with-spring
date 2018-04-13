package me.apoorvaagupta;

import org.springframework.stereotype.Component;

@Component
public class ReversalProcessor<T> implements Processor<T> {

    public <T> T process(T... v) {

        T output;

        if(v[0].getClass() == String.class) {

            StringBuilder sb = new StringBuilder();
            sb.append(v[0]);
            sb = sb.reverse();
            output = (T) sb.toString();
        }
        else{
            Integer reverse = 0, n =  (Integer) v[0];
            while(n != 0)
            {
                reverse = reverse * 10;
                reverse = reverse + n%10;
                n = n/10;
            }
            output = (T) new Integer(reverse);
        }

        return output;
    }
}