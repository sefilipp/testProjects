package spring.main;

import spring.bl.UsersBl;
import spring.model.Users;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main
{ 
    
    public static void main(String[] args) 
    {
       ApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"springContext.xml"});

        UsersBl usersBl = (UsersBl) context.getBean("usersBl");
        
        usersBl.createUser(new Users( "User1", true));
        usersBl.createUser(new Users( "User2", false));
        usersBl.createUser(new Users( "User3", true));
        usersBl.createUser(new Users( "User4", false));
        usersBl.createUser(new Users( "User5", true));
        usersBl.createUser(new Users( "User6", true));
           
        usersBl.deleteUser(usersBl.getUserById(3));
        usersBl.deleteUser(usersBl.getUserByName("User6"));
        
        System.out.println(usersBl.getActiveUsers());
       
        
    }

}
