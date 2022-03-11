package com.example.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.example.bean.Skill;

public class SkillRepositoryImpl implements ISkillRepository {

	@Override
	public Skill addSkill(Skill skill) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("PU");
		EntityManager em= emf.createEntityManager();
		
		em.getTransaction().begin();
		
		em.persist(skill);
		
		em.getTransaction().commit();
		
		em.close();
		emf.close();
		
		return skill;
		
	}

	@Override
	public Skill deleteSkill(int skillId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Skill updateSkill(Skill skill) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Skill getSkillById(int skillId) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("PU");
		EntityManager em= emf.createEntityManager();
		
		Skill skill = em.find(Skill.class, skillId);
		
		em.close();
		emf.close();
		
		return skill;
	}

	@Override
	public List<Skill> getAllSkills() {
		// TODO Auto-generated method stub
		return null;
	}

}