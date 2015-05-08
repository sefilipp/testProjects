package spring.bl;

import java.util.List;
import spring.model.Users;

/**
 *
 * @author sefilipp
 */
public interface UsersBl 
{  
    public Users createUser(Users user);
    
    public void deleteUser(Users user);
    
    public Users getUserById(int id);
    
    public Users getUserByName(String name);
    
    public void modifyUser(int id, String name, boolean active);
    
    public List<Users> getActiveUsers();
    
}
