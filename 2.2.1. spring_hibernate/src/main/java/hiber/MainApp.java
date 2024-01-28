package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);

      userService.add(new User("User1", "Lastname1", "user1@mail.ru"));
      userService.add(new User("User2", "Lastname2", "user2@mail.ru"));
      userService.add(new User("User3", "Lastname3", "user3@mail.ru"));
      userService.add(new User("User4", "Lastname4", "user4@mail.ru"));

      userService.add(new Car("BMW", 5));
      userService.add(new Car("Audi", 0));
      userService.add(new Car("Peko", 3));
      userService.add(new Car("OKA", 1));


     User ter = new User("Din", "Don", "user12@mail.ru");
     User top = new User("Kep", "Kop", "user13@mail.ru");

      Car OKA = new Car("OKA", 3);
      Car BMW = new Car("BMW", 7);

      userService.add(ter.setCar(OKA).setUser(ter));
      userService.add(top.setCar(BMW).setUser(top));

      for (User user : userService.listUsers()) {
         System.out.println(user + " " + user.getCar());
      }
     System.out.println(userService.getUserByCarModelAndSeries("OKA", 3));
      context.close();
   }
}
