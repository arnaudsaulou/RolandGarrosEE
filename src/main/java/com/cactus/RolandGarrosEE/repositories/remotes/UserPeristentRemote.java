package com.cactus.RolandGarrosEE.repositories.remotes;

import com.cactus.RolandGarrosEE.entities.User;

import javax.ejb.Remote;
import java.util.List;

@Remote
public interface UserPeristentRemote {
   void saveUser(User user);
   void deleteUser(User user);
   User findUserById(int userId);
   User findUserByMail(String mail);
   List<User> allUser();
}
