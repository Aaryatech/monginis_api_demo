package com.ats.webapi.model;

import java.util.List;

public class PostProductionPlanList {
	
	private List<PostProdPlanHeader> PostProductionPlanListlist;
	private ErrorMessage errorMessage;
	
	public List<PostProdPlanHeader> getPostProductionPlanListlist() {
		return PostProductionPlanListlist;
	}
	public void setPostProductionPlanListlist(List<PostProdPlanHeader> postProductionPlanListlist) {
		PostProductionPlanListlist = postProductionPlanListlist;
	}
	public ErrorMessage getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(ErrorMessage errorMessage) {
		this.errorMessage = errorMessage;
	}
	@Override
	public String toString() {
		return "PostProductionPlanList [PostProductionPlanListlist=" + PostProductionPlanListlist + ", errorMessage="
				+ errorMessage + "]";
	}
	
	
	

}
