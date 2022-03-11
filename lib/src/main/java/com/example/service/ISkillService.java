package com.example.service;

import java.util.List;

import com.example.bean.Skill;

public interface ISkillService {
	Skill addSkill(Skill skill);
	Skill deleteSkill(int skillId);
	Skill updateSkill(Skill skill);
	Skill getSkillById(int skillId);
	List<Skill> getAllSkills();
}