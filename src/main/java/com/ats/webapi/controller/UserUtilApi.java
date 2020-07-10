package com.ats.webapi.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ats.webapi.commons.Common;
import com.ats.webapi.commons.EmailUtility;
import com.ats.webapi.model.Franchisee;
import com.ats.webapi.model.Info;
import com.ats.webapi.model.OTPVerification;
import com.ats.webapi.model.User;
import com.ats.webapi.model.pettycash.FrEmpMaster;
import com.ats.webapi.repo.FrEmpMasterRepo;
import com.ats.webapi.repository.FranchiseSupRepository;
import com.ats.webapi.repository.FranchiseeRepository;
import com.ats.webapi.repository.UserRepository;
import com.ats.webapi.service.FranchiseeService;
import com.ats.webapi.service.UserService;

@RestController
public class UserUtilApi {
	@Autowired
	private UserService userService;

	@Autowired
	UserRepository updateUserRepo;

	@Autowired
	private FranchiseeService franchiseeService;

	@Autowired
	FranchiseeRepository franchiseeRepository;

	@Autowired
	FranchiseSupRepository franchiseSupRepository;

	@Autowired
	FrEmpMasterRepo frEmpRepo;

	// public static String senderEmail ="madhvierp@gmail.com";
	// public static String senderPassword ="madhvi@#2020";

	 public static String senderEmail ="atsinfosoft@gmail.com";
	 public static String senderPassword ="atsinfosoft@123";

	static String mailsubject = "";
	String otp1 = null;

	@RequestMapping(value = { "/getUserInfoByMobileNo" }, method = RequestMethod.POST)
	public @ResponseBody User getUserInfoByMobileNo(@RequestParam String mob) {

		OTPVerification.setConNumber(null);
		OTPVerification.setEmailId(null);
		OTPVerification.setOtp(null);
		OTPVerification.setPass(null);
		Info info = new Info();

		User res = new User();
		res = userService.getUserDataByMobileNo(mob);
		System.err.println("User Res----------" + res);

		if (res != null) {
			OTPVerification.setUserId(res.getId());

			String emailId = res.getEmail();
			String conNumber = res.getContact();
			System.err.println("User conNumber----------" + conNumber);
			char[] otp = Common.OTP(6);
			otp1 = String.valueOf(otp);
			System.err.println("User otp is : " + otp1);

			Info inf = EmailUtility.sendOtp1(otp1, conNumber);

			mailsubject = " OTP  Verification ";
			String text = "\n OTP for change your Password: ";
			Info emailRes = EmailUtility.sendEmail(senderEmail, senderPassword, emailId, mailsubject, text, otp1);

			OTPVerification.setConNumber(conNumber);
			OTPVerification.setEmailId(emailId);
			OTPVerification.setOtp(otp1);
			OTPVerification.setPass(res.getPassword());
		} else {
			System.err.println("In Else ");

			info.setError(true);
			info.setMessage("not Matched");
			System.err.println(" not Matched ");
		}
		return res;
	}

	/******************************************************************************/

	@RequestMapping(value = { "/getFranchiseeByMob" }, method = RequestMethod.POST)
	@ResponseBody
	public FrEmpMaster getFranchiseeByMob(@RequestParam("mob") String mob, @RequestParam("empId") int empId) {

		OTPVerification.setConNumber(null);
		OTPVerification.setEmailId(null);
		OTPVerification.setOtp(null);
		OTPVerification.setPass(null);
		Info info = new Info();
		FrEmpMaster frEmp = new FrEmpMaster();
		try {
			frEmp = frEmpRepo.findByfrEmpContactAndFrEmpId(mob, empId);
			System.out.println("JsonString" + frEmp);
			if (frEmp != null) {
				OTPVerification.setUserId(frEmp.getFrEmpId());

				String conNumber = frEmp.getFrEmpContact();

				char[] otp = Common.OTP(6);
				otp1 = String.valueOf(otp);
				System.err.println("User otp is" + otp1);

				Info inf = EmailUtility.sendOtp1(otp1, conNumber);

				mailsubject = " OTP  Verification ";
				String text = "We welcome You to Madhvi!\n" + "Your OTP to change your password is (" + otp1 + ").";
				String msgText = "";
				// Info emailRes = EmailUtility.sendEmail(senderEmail, senderPassword,emailId,
				// mailsubject,
				// text, msgText);

				OTPVerification.setConNumber(conNumber);
				OTPVerification.setOtp(otp1);
				OTPVerification.setPass(frEmp.getPassword());
			} else {
				System.err.println("In Else ");

				info.setError(true);
				info.setMessage("not Matched");
				System.err.println(" not Matched ");
			}
		} catch (Exception e) {
			System.err.println("Ex in getFranchiseeByMob : " + e.getMessage());
		}
		return frEmp;

	}

	@RequestMapping(value = { "/validateOTP" }, method = RequestMethod.POST)
	public @ResponseBody FrEmpMaster validateOTP(@RequestParam String otp) {
		Info info = new Info();

		Object object = new Object();
		HashMap<Integer, FrEmpMaster> hashMap = new HashMap<>();

		FrEmpMaster user = new FrEmpMaster();

		try {
			// System.err.println("OTP Found------------------"+OTPVerification.getOtp()+"
			// "+OTPVerification.getUserId());
			if (otp.equals(OTPVerification.getOtp()) == true) {
				info.setError(false);
				info.setMessage("success");

				user = frEmpRepo.findByFrEmpIdAndDelStatus(OTPVerification.getUserId(), 0);
				hashMap.put(1, user);

			} else {
				info.setError(true);
				info.setMessage("failed");
			}

		} catch (Exception e) {

			System.err.println("Exce in getAllInstitutes Institute " + e.getMessage());
			e.printStackTrace();
			info.setError(true);
			info.setMessage("excep");
		}

		return user;

	}

	@RequestMapping(value = { "/updateEmpNewPassword" }, method = RequestMethod.POST)
	public @ResponseBody Info updateEmpNewPassword(@RequestParam int empId, @RequestParam String pass) {

		Info res = new Info();

		int a = frEmpRepo.updateEmpPass(empId, pass);
		if (a > 0) {

//			FrEmpMaster empFr=frEmpRepo.findByFrEmpId(OTPVerification.getUserId());
//				if(empFr!=null) {
//						
//					//Info emailRes = EmailUtility.sendOtp(OTP, phoneNo)
//				}
//			res.setError(false);
//			res.setMessage("success");

		} else {
			res.setError(true);
			res.setMessage("fail");
		}

		return res;
	}
}
