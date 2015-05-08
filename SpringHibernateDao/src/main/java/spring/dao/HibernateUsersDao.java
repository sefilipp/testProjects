package spring.dao;

import java.util.List;
import spring.model.Users;
import javax.transaction.Transactional;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author sefilipp
 */

public class HibernateUsersDao implements UsersDao
{
    
    @Autowired
    SessionFactory sFactory;

    public int createUser(Users user) 
    {
        Integer u = (Integer) sFactory.getCurrentSession().save(user);
        return u;
    }
    
    public void deleteUser(Users user) 
    {
        sFactory.getCurrentSession().delete(user);
    }
   
    public Users getUserById(int id) 
    {
        // тут может быть null
        Users user = (Users) sFactory.getCurrentSession().get(Users.class, id);
        return user;        
    }
    
    public Users getUserByName(String name) 
    {
        Query query = sFactory.getCurrentSession().createQuery("from Users u where u.name = ?");
        query.setParameter(0, name);
        return (Users) query.uniqueResult();
    }

    public void modifyUser(int id, String name, boolean active) 
    {
        Users user = (Users) sFactory.getCurrentSession().get(Users.class, id);
        
        user.setName(name);
        user.setActive(active);
        
        sFactory.getCurrentSession().update(user);
    }
    
    public List<Users> getActiveUsers() 
    {
        Criteria cr = sFactory.getCurrentSession().createCriteria(Users.class);        
        cr.add(Restrictions.eq("active", true));
        
        List<Users> users = cr.list();
        
        return users;
    }     
    
}
