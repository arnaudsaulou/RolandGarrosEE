package com.cactus.RolandGarrosEE.repositories.implementation;

import com.cactus.RolandGarrosEE.entities.Court;
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
    public void saveFields(Court court) {
        try {
            entityManager.persist(court);
        } catch (Exception ignored) {
        }
    }

    @Override
    public void deleteFields(Court court) {
        try {
            entityManager.remove(court);
        } catch (Exception ignored) {
        }
    }

    @Override
    public Court findFieldsById(int fieldsId) {
        Court court = null;
        try {
            court = entityManager.find(Court.class, fieldsId);
        } catch (NoResultException ignored) {
        }
        return court;
    }

    @Override
    public List<Court> allFields() {
        List<Court> courtList = null;
        try {
            courtList = entityManager.createQuery("from Court", Court.class)
                    .getResultList();
        } catch (NoResultException ignored) {
        }
        return courtList;
    }
}
