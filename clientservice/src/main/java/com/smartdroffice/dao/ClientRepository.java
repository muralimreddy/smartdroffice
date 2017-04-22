package com.smartdroffice.dao;

import java.math.BigInteger;

import org.springframework.data.repository.CrudRepository;

import com.smartdroffice.domain.Client;

public interface ClientRepository extends CrudRepository<Client, BigInteger>{
	
	Client findClientByClientId(BigInteger clientId);
	Client save(Client client);
}
