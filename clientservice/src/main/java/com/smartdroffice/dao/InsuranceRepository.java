package com.smartdroffice.dao;

import java.math.BigInteger;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.smartdroffice.domain.Insurance;

public interface InsuranceRepository extends CrudRepository<Insurance, BigInteger>{
	List<Insurance> findByClientId(BigInteger clientId);
	Insurance save(Insurance insurance);
}
