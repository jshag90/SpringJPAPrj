package com.ji.application;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;

import com.ji.domain.Team;
import com.ji.domain.TeamRepository;

public class UpdateTeamServiceImpl implements UpdateTeamService {

	@Autowired
	private TeamRepository teamRepository;

	@Transactional
	@Override
	public void updateName(Long teamId, String newName) {
		Team team = teamRepository.findOne(teamId);
		if (team == null)
			throw new TeamNotFoundException("No Team for Id[" + teamId + "]");
		
		System.out.println("���� �� : " + team.getName());
		
		int updated = teamRepository.updateName(teamId, newName);
		System.out.println("���� ���� : " + updated);
		System.out.println("���� �� : " + team.getName());
	}

}
