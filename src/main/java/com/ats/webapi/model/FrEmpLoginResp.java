package com.ats.webapi.model;

import com.ats.webapi.model.pettycash.FrEmpMaster;

public class FrEmpLoginResp {
	 	private LoginInfo loginInfo;
	    private FrEmpMaster frEmp;
	    private Franchisee franchisee;
	    
		public LoginInfo getLoginInfo() {
			return loginInfo;
		}
		public void setLoginInfo(LoginInfo loginInfo) {
			this.loginInfo = loginInfo;
		}
		
		public FrEmpMaster getFrEmp() {
			return frEmp;
		}
		public void setFrEmp(FrEmpMaster frEmp) {
			this.frEmp = frEmp;
		}
		
		public Franchisee getFranchisee() {
			return franchisee;
		}
		public void setFranchisee(Franchisee franchisee) {
			this.franchisee = franchisee;
		}
		@Override
		public String toString() {
			return "FrEmpLoginResp [loginInfo=" + loginInfo + ", frEmp=" + frEmp + ", franchisee=" + franchisee + "]";
		}
		
				
	    
}
