package com.cactus.RolandGarrosEE.repositories.remotes;

import com.cactus.RolandGarrosEE.entities.Court;

import javax.ejb.Remote;
import java.util.List;

@Remote
public interface FieldsPersistentRemote {
    void saveFields(Court court);
    void deleteFields(Court court);
    Court findFieldsById(int fieldsId);
    List<Court> allFields();
}
