package in.ashokit.runner;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;

@Component
public class MyApplicationRunner implements ApplicationRunner {

    @Override
    public void run(ApplicationArguments args) throws Exception {
        List<String> nonOption=args.getNonOptionArgs();
        System.out.println("Non option argument :");
        nonOption.forEach(System.out::println);

        System.out.println("==============================");
        System.out.println("Option arguments provided are: ");
        // Accessing the option args
        Set<String> optionNames = args.getOptionNames();
        optionNames.forEach(key -> {
            System.out.println("key : " + key);
            List<String> values = args.getOptionValues(key);
            System.out.println("values :" + values);
        });

    }
}
