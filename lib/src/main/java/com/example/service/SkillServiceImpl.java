package com.example.service;

import java.util.List;

import com.example.bean.Skill;
import com.example.repository.ISkillRepository;
import com.example.repository.SkillRepositoryImpl;

public class SkillServiceImpl implements ISkillService {
	ISkillRepository skillRepo = new SkillRepositoryImpl();

	@Override
	public Skill addSkill(Skill skill) {
		return skillRepo.addSkill(skill);
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
		return skillRepo.getSkillById(skillId);
	}

	@Override
	public List<Skill> getAllSkills() {
		// TODO Auto-generated method stub
		return null;
	}

}