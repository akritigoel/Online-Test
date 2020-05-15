package org.com.onlinetest.service;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;
import org.com.onlinetest.dao.AdminDao;
import org.com.onlinetest.exception.RecordNotFoundException;
import org.com.onlinetest.model.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class AdminService {
	@Autowired
	
	AdminDao dao;

	
	//add Admin
	public Admin addAdmin(Admin admin) {
		return dao.save(admin);
	
	}
	
	//show Admin
	public List<Admin> getAllAdmin() {
		return dao.findAll();
	}
	
	 
	 
	//Update Admin	
		 public String updateAdmin( BigInteger adminId,  Admin adminDetails)
		    		throws RecordNotFoundException  {
		    	Admin admin = dao.findById(adminId).
		    	orElseThrow(() -> new RecordNotFoundException("Admin not found for the give id " +adminId));
		             dao.save(adminDetails);
		    	return "Admin Updated Successfully...";
		    }
	
		 
// get admin By Id
	public ResponseEntity<Admin> getAdminById( BigInteger adminId) throws RecordNotFoundException {
	Admin admin=dao.findById(adminId).
		   orElseThrow(() -> new RecordNotFoundException("Admin not found for the given id" +adminId));
		    return ResponseEntity.ok().body(admin);
		 }
	
		
	
	
	//login
	public BigInteger checkAdminLogin(String loginName,String password) 
	{
	Optional<BigInteger> findById=dao.checkAdminLogin(loginName,password);
	if(findById.isPresent()) 
	{
		BigInteger id=findById.get();
			return id;
	}
	else 
		return null;
	}
		 
		 
	//delete admin
	public String deleteAdmin(BigInteger adminId) {
		
	Optional<Admin> findById = dao.findById(adminId);
	if (findById.isPresent())
	{
		dao.deleteById(adminId);
			return "deleted";
	}
	else
	{
		return "!!   Id Is Invalid   !!";
	}
		    
	}

}
