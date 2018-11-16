package com.ocs.gts.service.impl;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ocs.dynamo.dao.BaseDao;
import com.ocs.dynamo.service.impl.BaseServiceImpl;
import com.ocs.gts.domain.Person;
import com.ocs.gts.domain.dao.PersonDao;
import com.ocs.gts.service.PersonService;

@Service("personService")
public class PersonServiceImpl extends BaseServiceImpl<Integer, Person> implements PersonService {

	@Inject
	private PersonDao dao;

	@Override
	protected BaseDao<Integer, Person> getDao() {
		return dao;
	}

	@Override
	@Transactional
	public Person save(Person t) {
		System.out.println("To save: " + t.getLuckyNumbers());
		return super.save(t);
	}
}
