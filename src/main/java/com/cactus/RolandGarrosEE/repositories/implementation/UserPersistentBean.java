package com.cactus.RolandGarrosEE.repositories.implementation;

import com.cactus.RolandGarrosEE.entities.User;
import com.cactus.RolandGarrosEE.repositories.remotes.UserPeristentRemote;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;

@Stateless
public class UserPersistentBean implements UserPeristentRemote {
    @PersistenceContext(unitName = "PersistentUnitPU")
    EntityManager entityManager;

    public void saveUser(User user) {
    }

    public void deleteUser(User user) {
    }

    public Optional<User> findUserById(long userId) {
        return Optional.empty();
    }

    public List<User> allUser() {
        return null;
    }
}
