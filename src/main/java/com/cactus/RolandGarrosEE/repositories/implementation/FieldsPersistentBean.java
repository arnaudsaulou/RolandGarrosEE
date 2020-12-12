package com.cactus.RolandGarrosEE.repositories.implementation;

import com.cactus.RolandGarrosEE.entities.Fields;
import com.cactus.RolandGarrosEE.repositories.remotes.FieldsPersistentRemote;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;

@Stateless
public class FieldsPersistentBean implements FieldsPersistentRemote {
    @PersistenceContext(name = "PersistentUnitPU")
    EntityManager entityManager;

    public void saveFields(Fields fields) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(fields);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            e.printStackTrace();
        }
    }

    public void deleteFields(Fields fields) {
        try {
            entityManager.getTransaction().begin();
            entityManager.remove(fields);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            e.printStackTrace();
        }
    }

    public Fields findFieldsById(int fieldsId) {
        Fields fields = null;
        try {
           entityManager.getTransaction().begin();
           fields = entityManager.find(Fields.class, fieldsId);
           entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            e.printStackTrace();
        }
        return fields;
    }

    public List<Fields> allFields() {
        List<Fields> fieldsList = null;
        try {
            entityManager.getTransaction().begin();
            fieldsList = entityManager.createQuery("from Fields", Fields.class).getResultList();
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            e.printStackTrace();
        }
        return fieldsList;
    }
}
