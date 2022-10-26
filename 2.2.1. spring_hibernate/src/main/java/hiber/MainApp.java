package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);

      Car car1 = new Car("model1", 1);
      User user1 = new User("User1", "Lastname1", "user1@mail.ru", car1);
      car1.setUser(user1);
      userService.add(user1);

      Car car2 = new Car("model2", 2);
      User user2 = new User("User2", "Lastname2", "user2@mail.ru", car2);
      car2.setUser(user2);
      userService.add(user2);

      Car car3 = new Car("model3", 3);
      User user3 = new User("User3", "Lastname3", "user3@mail.ru", car3);
      car3.setUser(user3);
      userService.add(user3);


      Car car4 = new Car("model4", 4);
      User user4 = new User("User4", "Lastname4", "user4@mail.ru", car4);
      car3.setUser(user4);
      userService.add(user4);

      userService.listUsers().stream().map(User::toString).forEach(System.out::println);

      User user = userService.userToCar("model1", 1);
      System.out.println(user.toString());
      context.close();
   }
}
