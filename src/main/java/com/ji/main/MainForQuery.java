package com.ji.main;

import java.util.List;

import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order;

import com.ji.domain.Employee;
import com.ji.domain.EmployeeRepository;
import com.ji.domain.Option;
import com.ji.domain.Team;
import com.ji.domain.TeamRepository;

public class MainForQuery {

	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("classpath:/springconf.xml");

		TeamRepository teamRepo = ctx.getBean(TeamRepository.class);
		for (Team team : teamRepo.findAll()) {
			System.out.println(team.getName());
		}

		EmployeeRepository empRepo = ctx.getBean(EmployeeRepository.class);
		useBasicFindByQueryMethod(empRepo);
		
		useBasicCountQueryMethod(empRepo);
		
		useSortOrPageableQueryMethod(ctx, empRepo);
		
		useQueryAnnotationMethod(empRepo);

		List<Team> teams = teamRepo.findByNameLike("S");
		printTeams("findByNameLike(S)", teams);
		printTeam("findByNameLike(SW��)", teamRepo.findByName("SW��"));
		
		useCustomImpl(empRepo);
		useCustomImpl(teamRepo);
		ctx.close();

	}



	private static void useCustomImpl(EmployeeRepository empRepo) {
		printOptionResult("Option<Employee> getOptionEmployee(1L)", empRepo.getOptionEmployee(1L));
		printOptionResult("Option<Employee> getOption(1L)", empRepo.getOption(1L));
		printOptionResult("Option<Employee> getOption(2L)", empRepo.getOption(100L));
	}
	
	private static void useCustomImpl(TeamRepository teamRepo) {
		printOptionResult("Option<Team> getOption(1L)", teamRepo.getOption(1L));
		printOptionResult("Option<Team> getOption(1L)", teamRepo.getOption(10L));
	}

	private static void printOptionResult(String string, Option<?> option) {
		printTitle(string);
		System.out.println(option.hasValue() ? option.get() : "�� ����");
	}


	private static void useQueryAnnotationMethod(EmployeeRepository empRepo) {
		Employee employee = empRepo.findByEmployeeNumberOrNameLike("1234567910", "��");
		printTitle("1234567910 ��� �Ǵ� �̸��� '��'�� ���� =" + (employee == null ? "����" : "����"));

		printEmployees("List<Employee> findEmployeeBornBefore(1980)", empRepo.findEmployeeBornBefore(1980));
		printEmployees("List<Employee> findEmployeeBornBefore(1980, sort)",
				empRepo.findEmployeeBornBefore(1980, new Sort("name")));
		printEmployees("List<Employee> findEmployeeBornBefore(1980, sort)",
				empRepo.findEmployeeBornBefore(1980, new PageRequest(1, 2, new Sort("name"))));
	}

	private static void useSortOrPageableQueryMethod(GenericXmlApplicationContext ctx, EmployeeRepository empRepo) {
		Sort sort = new Sort(
					new Order(Direction.DESC, "team.id"),
					new Order(Direction.ASC, "name")
				);
		
		printEmployees("findAll(Sort by team.id desc, name)", empRepo.findAll(sort));
		
		sort = new Sort("team.id", "birthYear");
		printEmployees("findAll(Sort by team.id, birthYear)", empRepo.findAll(sort));
		
		Team team = ctx.getBean(TeamRepository.class).findOne(1L);
		sort = new Sort("team.id", "id");
		printEmployees("findByTeam(team, Sort by team.id, id)", empRepo.findByTeam(team, sort));
		
		Pageable pageable = new PageRequest(2,2, new Sort("birthYear")); 
		
		printEmployees("findByBirthYearLessThan", empRepo.findByBirthYearLessThan(2000, pageable));
		
		pageable = new PageRequest(1, 4, new Sort("birthYear")); //page, rows
		printEmployees("List<Employee> findByTeamdId", empRepo.findByTeamId(1L, pageable));
		
		Page<Employee> empPage = empRepo.findByTeam(team, pageable);
		printPageEmployees("Page<Employee> findByTeam(team, pageable)", empPage);
		
		printEmployees("List<Employee> findByTeamdIdOrderByNameDesc(teamId, sort)",
				empRepo.findByTeamIdOrderByNameDesc(1L, new Sort("birthYear")));

	}

	private static void useBasicCountQueryMethod(EmployeeRepository empRepo) {
		printTitle("long count() = " + empRepo.count());
		printTitle("long countByTeamId(1L) = " + empRepo.countByTeamId(2L));
	}

	private static void useBasicFindByQueryMethod(EmployeeRepository empRepo) {
		printEmployees("findByBirthYear", empRepo.findByBirthYear(1977));
		printEmployees("findByNameLike", empRepo.findByNameLike("%��%"));
		printEmployees("findByNameStartingWith", empRepo.findByNameStartingWith("����"));
		printEmployees("findByNameContaining", empRepo.findByNameContaining("��"));
		printEmployees("findByNameStaringWithOrderByNameAsc", empRepo.findByNameStartingWithOrderByNameAsc("���ӽ�"));
		printEmployees("findByTeamIdOrderByIdDesc", empRepo.findByTeamIdOrderByIdDesc(1L));
		printEmployees("findByBirthYearOrderByTeamNameAscNameAsc",
				empRepo.findByBirthYearOrderByTeamNameAscNameAsc(1977));

		printTitle("Employee findByEmployeeNumberOrNameLike(\"1234567890\", \"��\")");
		printEmployee("Employee findByEmployeeNumberOrNameLike(\"1234567890\", \"��\")",
				empRepo.findByEmployeeNumberOrNameLike("1234567890", "��"));
		printEmployee("Employee findByName(\"�ֹ���\")", empRepo.findByName("�ֹ���"));

	}

	private static void printEmployee(String title, Employee employee) {
		printTitle(title);
		System.out.println(employee);

	}

	private static void printTitle(String title) {
		System.out.println("============= " + title);

	}
	
	private static void printTeam(String title, Team team) {
		printTitle(title);
		System.out.println(team);
	}

	private static void printTeams(String title, List<Team> teams) {
		printTitle(title);
		for (Team t : teams)
			System.out.println(t);
	}
	private static void printPageEmployees(String title, Page<Employee> empPage) {
		printTitle(title);
		System.out.printf("���� ������/��ü ������ = %d/%d\n", empPage.getNumber(), empPage.getTotalPages());
		System.out.printf("���� ������ ������Ʈ ����/��ü ����/������ ũ�� = %d/%d/%d\n",
				empPage.getNumberOfElements(), empPage.getTotalElements(), empPage.getSize());
		System.out.printf("isFirst() = %s, isLast() = %s, hasNext() = %s, hasPrevious() = %s\n",
				empPage.isFirst(), empPage.isLast(), empPage.hasNext(), empPage.hasPrevious());
		for (Employee emp : empPage) {
			System.out.println(emp.toString());
		}
	}

	private static void printEmployees(String title, Iterable<Employee> employees) {
		printTitle(title);
		for (Employee emp : employees) {
			System.out.println(emp.toString());
		}
	}

}
