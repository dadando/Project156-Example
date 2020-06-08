package com.spring.springajax;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.mapper.PeopleMapper;

@Service
public class PeopleServiceImpl implements PeopleService {

	@Autowired 
	SqlSession sqlSession;
	
	@Override
	public List<PeopleVO> getPeoplejson() {
		List<PeopleVO> peoplelist = null;
		PeopleMapper peoplemapper = sqlSession.getMapper(PeopleMapper.class);
		peoplelist = peoplemapper.getPeopleList();
		System.out.println("PeopleList="+peoplelist);
		System.out.println("peopleList.size()="+peoplelist.size());
		
		return peoplelist;
	}

	@Override
	public void insertPeople(PeopleVO vo) {
		PeopleMapper peoplemapper = sqlSession.getMapper(PeopleMapper.class);
		peoplemapper.insertPeople(vo);
		
		return;
	}
	
	@Override
	public void deletePeople(String id) {
		PeopleMapper peoplemapper = sqlSession.getMapper(PeopleMapper.class);
		peoplemapper.deletePeople(id);
		
		return;
	}

}
