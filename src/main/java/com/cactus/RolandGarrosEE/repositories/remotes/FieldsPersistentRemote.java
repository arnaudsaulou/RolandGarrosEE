package com.cactus.RolandGarrosEE.repositories.remotes;

import com.cactus.RolandGarrosEE.entities.Fields;

import javax.ejb.Remote;
import java.util.List;

@Remote
public interface FieldsPersistentRemote {
    void saveFields(Fields fields);
    void deleteFields(Fields fields);
    Fields findFieldsById(int fieldsId);
    List<Fields> allFields();
}
