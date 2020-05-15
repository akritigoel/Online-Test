package org.com.onlinetest.controller;


import java.math.BigInteger;
import java.util.List;

import org.com.onlinetest.exception.RecordNotFoundException;
import org.com.onlinetest.model.Admin;
import org.com.onlinetest.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("http://localhost:4300")
@RequestMapping("/Admin")
public class AdminController {

	@Autowired
	private AdminService adminService;
	

	// add new admin
	@PostMapping("/addAdmin")
	public Admin addAdmin(@RequestBody Admin admin) {

		return adminService.addAdmin(admin);

	}
 
	// update admin
		@PutMapping("/updateAdmin/{id}")
		public String updateAdmin(@PathVariable(value = "id") BigInteger adminId, @RequestBody Admin adminDetails)
				throws RecordNotFoundException {

			return adminService.updateAdmin(adminId, adminDetails);
		}

	// delete admin
	@DeleteMapping("/deleteAdmin/{id}")
	public String deleteAdmin(@PathVariable(value = "id") BigInteger adminId) throws RecordNotFoundException {

		return adminService.deleteAdmin(adminId);
	}

	// get admin By Id
	@GetMapping("/findAdminById/{id}")
	public ResponseEntity<Admin> getAdminById(@PathVariable(value = "id") BigInteger adminId)
			throws RecordNotFoundException {

		return adminService.getAdminById(adminId);
	}

	// Get All admin
	@GetMapping("/AllAdmin")
	public List<Admin> getAllAdmin() {

		return adminService.getAllAdmin();

	}
	//login
	@GetMapping("/login/{loginName}/{password}")
	public BigInteger validStudentLogin(@PathVariable("loginName") String loginName,@PathVariable("password") String password) {
		return adminService.checkAdminLogin(loginName,password);
	}

	
}
