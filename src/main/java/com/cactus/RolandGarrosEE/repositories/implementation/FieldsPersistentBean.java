package com.cactus.RolandGarrosEE.repositories.implementation;

import com.cactus.RolandGarrosEE.entities.Fields;
import com.cactus.RolandGarrosEE.repositories.remotes.FieldsPersistentRemote;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class FieldsPersistentBean implements FieldsPersistentRemote {
    @PersistenceContext(name = "PersistentUnitPU")
    EntityManager entityManager;

    @Override
    public void saveFields(Fields fields) {
        try {
            entityManager.persist(fields);
        } catch (Exception ignored) {
        }
    }

    @Override
    public void deleteFields(Fields fields) {
        try {
            entityManager.remove(fields);
        } catch (Exception ignored) {
        }
    }

    @Override
    public Fields findFieldsById(int fieldsId) {
        Fields fields = null;
        try {
            fields = entityManager.find(Fields.class, fieldsId);
        } catch (NoResultException ignored) {
        }
        return fields;
    }

    @Override
    public List<Fields> allFields() {
        List<Fields> fieldsList = null;
        try {
            fieldsList = entityManager.createQuery("from Fields", Fields.class)
                    .getResultList();
        } catch (NoResultException ignored) {
        }
        return fieldsList;
    }
}
