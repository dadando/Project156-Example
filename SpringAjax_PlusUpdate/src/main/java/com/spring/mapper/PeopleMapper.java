package com.spring.mapper;

import java.util.List;

import com.spring.springajax.PeopleVO;

public interface PeopleMapper {
	List<PeopleVO> getPeopleList();
	int insertPeople(PeopleVO vo);
	void deletePeople(String id);
	void updatePeople(PeopleVO vo);
	PeopleVO selectPeople(String id);
}
