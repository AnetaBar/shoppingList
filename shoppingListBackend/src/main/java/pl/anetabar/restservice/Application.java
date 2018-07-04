package pl.anetabar.restservice;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import pl.anetabar.restservice.domain.ListItem;
import pl.anetabar.restservice.repository.ShoppingListRepository;

/**
 * Created by Aneta on 08.06.2018.
 */
@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    CommandLineRunner init(final ShoppingListRepository shoppingListService) {
        return new CommandLineRunner() {
            @Override
            public void run(String... strings) throws Exception {
                ListItem item1 = ListItem.builder().productName("Pomidor").productQuantity(1L).build();
                ListItem item2 = ListItem.builder().productName("Mozzarella").productQuantity(2L).build();

                shoppingListService.save(item1);
                shoppingListService.save(item2);
            }
        };
    }
}
