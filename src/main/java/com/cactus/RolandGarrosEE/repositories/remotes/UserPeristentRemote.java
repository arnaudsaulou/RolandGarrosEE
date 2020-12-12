package com.cactus.RolandGarrosEE.repositories.remotes;

import com.cactus.RolandGarrosEE.entities.User;

import javax.ejb.Remote;
import java.util.List;
import java.util.Optional;

@Remote
public interface UserPeristentRemote {
   void saveUser(User user);
   void deleteUser(User user);
   Optional<User> findUserById(long userId);
   List<User> allUser();
}
