package com.spring.springajax;

import java.util.List;

public interface PeopleService {
	List<PeopleVO> getPeoplejson();
	void insertPeople(PeopleVO vo);
	void deletePeople(String id);
	void updatePeople(PeopleVO vo);
	PeopleVO selectPeople(String id);
}
