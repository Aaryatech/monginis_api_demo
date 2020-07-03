package com.ats.webapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ats.webapi.model.Department;
import com.ats.webapi.model.ErrorMessage;
import com.ats.webapi.model.GetUserType;
import com.ats.webapi.model.Info;
import com.ats.webapi.model.LoginResponse;
import com.ats.webapi.model.User;
import com.ats.webapi.repository.DepartmentRepository;
import com.ats.webapi.repository.GetUserTypeRepository;
import com.ats.webapi.repository.UserRepository;
import com.ats.webapi.util.JsonUtil;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	DepartmentRepository departmentRepository;
	
	@Autowired
	GetUserTypeRepository getUserTypeRepository;
	
	String jsonUser = "{}";
	User user = null;
	ErrorMessage errorMessage;

	@Override
	public LoginResponse findUserByUsername(String username, String password) {

		String dbUsername = null;
		String dbPassword = null;
        LoginResponse loginResponse=null;
		try {
			user = userRepository.findByUsernameAndDelStatus(username, 0);
			dbUsername = user.getUsername();
			dbPassword = user.getPassword();
		} catch (Exception e) {
			loginResponse=new LoginResponse();
            errorMessage=new ErrorMessage();
			errorMessage.setError(true);
			errorMessage.setMessage("User is not registered");
			
			loginResponse.setErrorMessage(errorMessage);
			loginResponse.setUser(user);
			
		
		}
		try {
			if (user == null || username == null||username.equalsIgnoreCase("")) {
				
				loginResponse=new LoginResponse();

				errorMessage=new ErrorMessage();
				errorMessage.setError(true);
				errorMessage.setMessage("User is not registered");
				
				loginResponse.setErrorMessage(errorMessage);
				loginResponse.setUser(user);
				
			} else if (password == null||password.equalsIgnoreCase("")) {
				
				loginResponse=new LoginResponse();
	            errorMessage=new ErrorMessage();

				errorMessage.setError(true);
				errorMessage.setMessage("Please enter Password");
				loginResponse.setErrorMessage(errorMessage);
				loginResponse.setUser(user);

			} else if (dbUsername.equals(username) && dbPassword.equals(password)) {
				
				loginResponse=new LoginResponse();
	            errorMessage=new ErrorMessage();

				errorMessage.setError(false);
				errorMessage.setMessage("User Logged in Successfully");
				loginResponse.setErrorMessage(errorMessage);
				loginResponse.setUser(user);

			} else if (dbUsername.equals(username) && dbPassword != password) {
				
				loginResponse=new LoginResponse();
	            errorMessage=new ErrorMessage();

				errorMessage.setError(true);
				errorMessage.setMessage("Invalid Password");
				loginResponse.setErrorMessage(errorMessage);
				loginResponse.setUser(user);

			}
		} catch (Exception e) {

			loginResponse=new LoginResponse();
            errorMessage=new ErrorMessage();

			errorMessage.setError(true);
			errorMessage.setMessage("User is not registered");
			loginResponse.setErrorMessage(errorMessage);
			loginResponse.setUser(user);

		}
		return loginResponse;

	}

	@Override
	public String save(User user) {
		try {
			User tempUser =null;
			try {	if (user != null||user.getUsername()==""||user.getPassword()=="") {
				tempUser = userRepository.findByUsername(user.getUsername());
			}
			else
			{
				errorMessage.setError(false);
				errorMessage.setMessage("UserForm fields are empty");
			}
		
			} catch (Exception e) {
				
				errorMessage.setError(true);
				errorMessage.setMessage("Exception occured while inserting NewUser");
				jsonUser = JsonUtil.javaToJson(errorMessage);

			}

			if (tempUser == null) {
				user = userRepository.save(user);
				errorMessage.setError(false);
				errorMessage.setMessage("Record Inserted Successfully");

				jsonUser = JsonUtil.javaToJson(errorMessage);
			} else {

				errorMessage.setError(true);
				errorMessage.setMessage("User with this username is already registered");

				jsonUser = JsonUtil.javaToJson(errorMessage);
			}
		} catch (Exception e) {
			errorMessage.setError(true);
			errorMessage.setMessage("Exception occured while inserting NewUser");
			jsonUser = JsonUtil.javaToJson(errorMessage);
			
		}
		return jsonUser;
	}

	@Override
	public Info insertUser(User user) {
		 
		Info info=new Info();
		user=userRepository.save(user);
		if(user!=null)
		{
			info.setError(false);
			info.setMessage("success");
		}
		{
			info.setError(true);
			info.setMessage("failed");
		}
		return info;
	}

	@Override
	public List<Department> getAllDept() {
		 
	return departmentRepository.getAllDept();
	}

	@Override
	public List<GetUserType> getAllUserType() {
	 
		return getUserTypeRepository.getType();
	}
	
	/********************************************************************************/
	@Override
	public User checkUniqueEmail(String email) {
		// TODO Auto-generated method stub
		return userRepository.findByEmail(email);
	}

	@Override
	public User checkUniqueContact(String contact) {
		// TODO Auto-generated method stub
		return userRepository.findByContact(contact);
	}

	@Override
	public User getUserData(String username) {
		// TODO Auto-generated method stub
		return  userRepository.findByUsernameAndDelStatus(username, 0);
	}

	@Override
	public User findByIdAndDelStatus(int userId, int j) {
		// TODO Auto-generated method stub
		return  userRepository.findByIdAndDelStatus(userId, 0);
	}

	@Override
	public User checkUniqueUser(String uname) {
		// TODO Auto-generated method stub
		return userRepository.findByUsername(uname);
	}

	@Override
	public User findByUserId(int userId) {
		// TODO Auto-generated method stub
		return userRepository.findById(userId);
	}

	@Override
	public User getUserDataByMobileNo(String mob) {
		return userRepository.findBycontact(mob);
		
	}

}
