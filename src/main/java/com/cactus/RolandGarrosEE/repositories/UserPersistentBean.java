package com.cactus.RolandGarrosEE.repositories;

import com.cactus.RolandGarrosEE.entities.User;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class UserPersistentBean implements UserPeristentRemote {

    @PersistenceContext(unitName = "PersistentUnitPU")
    EntityManager entityManager;

    public void AddUser(User user) {
        entityManager.persist(user);
    }
}
