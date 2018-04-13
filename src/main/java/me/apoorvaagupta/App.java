package me.apoorvaagupta;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.Scanner;

@Configuration
@ComponentScan("me.apoorvaagupta")

public class App {


    @Bean
    Reader<String> ConsoleStringReader() {
        return new Reader<String>() {

            Scanner scn = new Scanner(System.in);

            @Override
            public <T> T input() {

                return (T) this.scn.next();

            }
        };
    }

    @Bean
    Writer<String> ConsoleWriter() {
        return new Writer<String>() {

            @Override
            public void output(String var) {
                System.out.println(var);
            }
        };
    }




    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext(App.class);

        InputHandler r = context.getBean(InputHandler.class);
        OutputHandler w = context.getBean(OutputHandler.class);
        Processor p;
        p = context.getBean(AdditionProcessor.class);

        String s1 =  (String) r.takeInput();
        String s2 =  (String) r.takeInput();

        s1 = (String) p.process(s1,s2);


        w.writeOutput(s1);

        p = context.getBean(ReversalProcessor.class);

        s1 = (String) p.process(s1);

        w.writeOutput(s1);





    }
}
