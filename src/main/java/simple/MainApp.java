package simple;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import simple.service.HelloWorldService;

/**
 * Starting point for spring application
 * 
 * @author Nanor
 */

@SpringBootApplication
public class MainApp implements CommandLineRunner{
	
	// Simple example shows how a command line spring application can execute an
	// injected bean service. Also demonstrates how you can use @Value to inject
	// command line args ('--name=whatever') or application properties
	
	
	@Autowired
	private HelloWorldService helloWorldService;
	
	//Runs on start up
	@Override
	public void run(String... args) {
		System.out.println(this.helloWorldService.getHelloMessage());
		if (args.length > 0 && args[0].equals("exitcode")) {
			throw new ExitException();
		}
	}
	
	
	/*Classes that can be used to bootstrap and launch a Spring application from a Java main method. By default class will perform the following steps to bootstrap your application:
	Create an appropriate ApplicationContext instance (depending on your classpath)
	Register a CommandLinePropertySource to expose command line arguments as Spring properties
	Refresh the application context, loading all singleton beans
	Trigger any CommandLineRunner beans
	In most circumstances the static run(Object, String[]) method can be called directly from your main method to bootstrap your application:*/
	
	public static void main(String[] args) {
			SpringApplication.run(MainApp.class, args);
	}
	
	//CommandLineRunner Bean runs on application start up.
    @Bean
    public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
        return args -> {

            System.out.println("Let's inspect the beans provided by Spring Boot:");

            String[] beanNames = ctx.getBeanDefinitionNames();
            Arrays.sort(beanNames);
            for (String beanName : beanNames) {
                //System.out.println(beanName);
            }

        };
    }
}
