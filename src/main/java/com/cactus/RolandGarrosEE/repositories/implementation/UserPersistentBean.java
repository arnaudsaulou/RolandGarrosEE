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

    @Override
    public void saveUser(User user) {
        try {
            entityManager.persist(user);
        } catch (Exception ignored) {
        }
    }

    @Override
    public void deleteUser(User user) {
        try {
            entityManager.remove(user);
        } catch (Exception ignored) {
        }
    }

    @Override
    public User findUserById(int userId) {
        User user = null;
        try {
            user = entityManager.find(User.class, userId);
        } catch (NoResultException ignored) {
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
        } catch (NoResultException ignored) {
        }
        return user;
    }

    public List<User> allUser() {
        List<User> users = null;
        try {
            users = entityManager.createQuery("from User ", User.class)
                    .getResultList();
        } catch (NoResultException ignored) {
        }
        return users;
    }

    public List<String> allMails() {
        List<String> mails = null;
        try{
            mails = entityManager.createQuery("SELECT u.mail FROM User u ", String.class)
                    .getResultList();
        } catch (NoResultException ignored) {
    }
        return mails;
    }
}
