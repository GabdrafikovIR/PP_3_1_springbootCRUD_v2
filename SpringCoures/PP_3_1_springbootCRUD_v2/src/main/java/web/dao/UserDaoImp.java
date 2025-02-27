package web.dao;


import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;
import web.model.User;

import java.util.List;

@Repository
public class UserDaoImp implements UsersDao {

   @PersistenceContext
   private EntityManager entityManager;

   @Override
   public void save(User user) {
      entityManager.persist(user);
   }

   @Override
   public List<User> index() {
      TypedQuery<User> users = entityManager.createQuery("from User", User.class);
      return users.getResultList();
   }

   @Override
   public void update(int id, User user) {
      entityManager.merge(user);
   }

   @Override
   public void delete(int id) {
      User user = entityManager.find(User.class, id);
      if (user != null) {
         entityManager.remove(user);
      }
   }

   @Override
   public User show(int id) {
      return entityManager.find(User.class, id);
   }
}
