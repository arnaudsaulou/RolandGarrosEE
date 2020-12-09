package com.cactus.RolandGarrosEE.repositories;

import com.cactus.RolandGarrosEE.entities.User;

import javax.ejb.Remote;

@Remote
public interface UserPeristentRemote {
   void AddUser(User user);
}
