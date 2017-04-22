package com.smartdroffice.dao;

import java.math.BigInteger;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.smartdroffice.domain.ClientBilling;

public interface ClientBillingRepository extends CrudRepository<ClientBilling, BigInteger>{
	List<ClientBilling> findClientBillingByClientId(BigInteger clientId);
	ClientBilling save(ClientBilling clientBilling);
}
