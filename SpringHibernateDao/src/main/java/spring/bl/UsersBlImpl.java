package spring.bl;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.stereotype.Repository;
import spring.dao.UsersDao;
import spring.model.Users;

/**
 *
 * @author sefilipp
 */
@Repository
public class UsersBlImpl implements UsersBl
{
    UsersDao usersDao;
    
    @Transactional
    public void setUsersDao(UsersDao usersDao)
    {
        this.usersDao = usersDao;
    }

    @Transactional
    public Users createUser(Users user) 
    {
        int id = usersDao.createUser(user);
        System.out.println("User " + id + " : " + user.getName() + " created");
        return user;
    }

    @Transactional
    public void deleteUser(Users user) 
    {
        usersDao.deleteUser(user);
        System.out.println("User " + user.getId() + " : " + user.getName() + " deleted");
    }
    
    @Transactional
    public Users getUserById(int id) 
    {
        return usersDao.getUserById(id);
    }

    @Transactional
    public Users getUserByName(String name)
    {
        return usersDao.getUserByName(name);
    }

    @Transactional
    public void modifyUser(int id, String name, boolean active)
    {        
        usersDao.modifyUser(id, name, active);        
    }

    @Transactional
    public List<Users> getActiveUsers() 
    {
        return usersDao.getActiveUsers();
    }
    
}
