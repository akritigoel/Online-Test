package org.com.onlinetest.dao;

import java.math.BigInteger;
import java.util.Optional;

import org.com.onlinetest.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminDao extends JpaRepository<Admin,BigInteger>{

	@Query(value="select admin_id from admin where admin_name=:name and admin_password=:password",nativeQuery = true)
	public Optional<BigInteger> checkAdminLogin(String name,String password);

	
}
