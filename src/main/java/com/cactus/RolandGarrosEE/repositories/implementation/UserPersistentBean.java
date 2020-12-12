package com.cactus.RolandGarrosEE.repositories.implementation;

import com.cactus.RolandGarrosEE.entities.User;
import com.cactus.RolandGarrosEE.repositories.remotes.UserPeristentRemote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class UserPersistentBean implements UserPeristentRemote {

    @PersistenceContext(unitName = "PersistentUnitPU")
    EntityManager entityManager;

    public void saveUser(User user) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(user);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            e.printStackTrace();
        }
    }

    public void deleteUser(User user) {
        try {
            entityManager.getTransaction().begin();
            entityManager.remove(user);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            e.printStackTrace();
        }
    }

    public User findUserById(int userId) {
        User user = null;
        try {
            entityManager.getTransaction().begin();
            user = entityManager.find(User.class, userId);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public User findUserByMail(String mail) {
        User user = null;

        try {
            user = entityManager.createQuery("SELECT u FROM User u WHERE u.mail = :mail", User.class)
                    .setParameter("mail", mail)
                    .getSingleResult();
        } catch (NoResultException ignored){}

        return user;
    }

    public List<User> allUser() {
        List<User> users = null;
        try {
            entityManager.getTransaction().begin();
            users = entityManager.createQuery("from User ", User.class).getResultList();
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            e.printStackTrace();
        }
        return users;
    }
}
