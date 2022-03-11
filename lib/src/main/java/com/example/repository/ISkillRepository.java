package com.example.repository;

import java.util.List;

import com.example.bean.Skill;

public interface ISkillRepository {
	Skill addSkill(Skill skill);
	Skill deleteSkill(int skillId);
	Skill updateSkill(Skill skill);
	Skill getSkillById(int skillId);
	List<Skill> getAllSkills();
}