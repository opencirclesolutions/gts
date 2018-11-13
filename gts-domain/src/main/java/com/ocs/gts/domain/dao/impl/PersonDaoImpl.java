package com.ocs.gts.domain.dao.impl;

import org.springframework.stereotype.Repository;

import com.ocs.dynamo.dao.FetchJoinInformation;
import com.ocs.dynamo.dao.impl.BaseDaoImpl;
import com.ocs.gts.domain.Person;
import com.ocs.gts.domain.QPerson;
import com.ocs.gts.domain.dao.PersonDao;
import com.querydsl.core.types.dsl.EntityPathBase;

@Repository("personDao")
public class PersonDaoImpl extends BaseDaoImpl<Integer, Person> implements PersonDao {

	@Override
	public Class<Person> getEntityClass() {
		return Person.class;
	}

	@Override
	protected EntityPathBase<Person> getDslRoot() {
		return QPerson.person;
	}

	@Override
	protected FetchJoinInformation[] getFetchJoins() {
		return new FetchJoinInformation[] { new FetchJoinInformation("organization"), new FetchJoinInformation("role"),
				new FetchJoinInformation("domains"), new FetchJoinInformation("luckyNumbers") };
	}
}
