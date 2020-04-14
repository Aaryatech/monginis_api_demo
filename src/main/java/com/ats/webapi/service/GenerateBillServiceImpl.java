package com.ats.webapi.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ats.webapi.model.GenerateBill;
import com.ats.webapi.model.GenerateBillList;
import com.ats.webapi.model.GenerateRegSpBill;
import com.ats.webapi.model.GenerateSpBill;
import com.ats.webapi.model.Info;
import com.ats.webapi.repository.GenerateBillRepository;
import com.ats.webapi.repository.GenerateRegSpBillRepository;
import com.ats.webapi.repository.GenerateSpBillRepository;

@Service
public class GenerateBillServiceImpl implements GenerateBillService {

	@Autowired
	GenerateBillRepository billRepository;

	@Autowired
	GenerateSpBillRepository generateSpBillRepository;

	@Autowired
	GenerateRegSpBillRepository regSpBillRepository;

	@Override
	public GenerateBillList generateBillService(List<String> frId, List<String> menuId, String delDate) {

		GenerateBillList generateBillList = new GenerateBillList();

		List<GenerateBill> generateBills = billRepository.generateBill(frId, menuId, delDate);

		List<GenerateSpBill> generateSpBills = generateSpBillRepository.generateSpBill(frId, menuId, delDate);

		List<GenerateRegSpBill> generateRegSpBills = regSpBillRepository.generateRegSpBill(frId,menuId, delDate);
		
		System.out.println("Regular Sp Cake Orders "+generateRegSpBills.toString());

		generateBills = convertSpCakeToItem(generateSpBills, generateBills);

		generateBills = convertRegSpCakeToItem(generateRegSpBills, generateBills);
		
		Info info = new Info();

		if (generateBills != null) {

			generateBillList.setGenerateBills(generateBills);

			info.setError(false);
			info.setMessage("Success in bill generation for selected Franchisees");

			generateBillList.setInfo(info);

		} else {

			info.setError(true);
			info.setMessage("failed to generate bill");

			generateBillList.setInfo(info);
		}

		return generateBillList;
	}

	@Override
	public GenerateBillList generateBillServiceForAllFr(List<String> menuId, String delDate) {

		GenerateBillList generateBillList = new GenerateBillList();

		List<GenerateBill> generateBills = billRepository.generateBillForAllFr(menuId, delDate);

		List<GenerateSpBill> generateSpBills = generateSpBillRepository.generateSpBillForAllFr(menuId, delDate);
		
		List<GenerateRegSpBill> generateRegSpBills = regSpBillRepository.generateRegSpBillForAllFr(menuId, delDate);
		System.out.println("Regular Sp Cake Orders "+generateRegSpBills.toString());


		generateBills = convertSpCakeToItem(generateSpBills, generateBills);

		generateBills = convertRegSpCakeToItem(generateRegSpBills, generateBills);

		
		Info info = new Info();

		if (generateBills != null) {

			generateBillList.setGenerateBills(generateBills);

			info.setError(false);
			info.setMessage("Success in bill generation for All Fr");

			generateBillList.setInfo(info);

		} else {

			info.setError(true);
			info.setMessage("failed to generate bill");

			generateBillList.setInfo(info);
		}

		return generateBillList;
	}

	@Override
	public GenerateBillList generateBillForAllFrAllMenu(String delDate) {

		GenerateBillList generateBillList = new GenerateBillList();

		List<GenerateBill> generateBills = billRepository.generateBillForAllFrAllMenu(delDate);

		List<GenerateSpBill> generateSpBills = generateSpBillRepository.generateSpBillForAllFrAllMenu(delDate);

		List<GenerateRegSpBill> generateRegSpBills = regSpBillRepository.generateRegSpBillForAllFrAllMenu( delDate);

		System.out.println("Regular Sp Cake Orders "+generateRegSpBills.toString());

		generateBills = convertSpCakeToItem(generateSpBills, generateBills);
		
		try {
		generateBills = convertRegSpCakeToItem(generateRegSpBills, generateBills);
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		Info info = new Info();

		if (generateBills != null) {

			generateBillList.setGenerateBills(generateBills);

			info.setError(false);
			info.setMessage("Success in bill generation for All Fr All Menu");

			generateBillList.setInfo(info);

		} else {

			info.setError(true);
			info.setMessage("failed to generate bill");

			generateBillList.setInfo(info);
		}

		return generateBillList;

	}

	@Override
	public GenerateBillList generateBillForAllMenu(List<String> frId, String delDate) {

		GenerateBillList generateBillList = new GenerateBillList();

		List<GenerateBill> generateBills = billRepository.generateBillForAllMenu(frId, delDate);
		List<GenerateSpBill> generateSpBills = generateSpBillRepository.generateSpBillForAllMenu(frId, delDate);

		List<GenerateRegSpBill> generateRegSpBills = regSpBillRepository.generateRegSpBillForAllMenu(frId, delDate);

		//System.out.println("sp cake orders " + generateSpBills.toString());

		System.out.println("Regular Sp Cake Orders "+generateRegSpBills.toString());

		generateBills = convertSpCakeToItem(generateSpBills, generateBills);

		generateBills = convertRegSpCakeToItem(generateRegSpBills, generateBills);

		Info info = new Info();

		if (generateBills != null) {

			generateBillList.setGenerateBills(generateBills);

			info.setError(false);
			info.setMessage("Success in bill generation for All Fr All Menu and selected Franchisee");

			generateBillList.setInfo(info);

		} else {

			info.setError(true);
			info.setMessage("failed to generate bill");

			generateBillList.setInfo(info);
		}

		return generateBillList;

	}

	private List<GenerateBill> convertRegSpCakeToItem(List<GenerateRegSpBill> generateRegSpBills,
			List<GenerateBill> generateBillList) {
		
		
		for(int i=0;i<generateRegSpBills.size();i++) {
			
			GenerateRegSpBill regSpBill=generateRegSpBills.get(i);
			
			GenerateBill generateBill = new GenerateBill();

			generateBill.setCatId(regSpBill.getItemGrp1());
			generateBill.setDeliveryDate(regSpBill.getRspDeliveryDt());
			generateBill.setFrCode(regSpBill.getFrCode());
			generateBill.setFrId(regSpBill.getFrId());
			generateBill.setFrName(regSpBill.getFrName());
			generateBill.setGrnType(3);
			generateBill.setItemId(regSpBill.getItemId());
			generateBill.setItemName(regSpBill.getItemName());
			generateBill.setItemShelfLife(regSpBill.getItem_shelf_life());
			generateBill.setItemTax1(regSpBill.getItemTax1());
			generateBill.setItemTax2(regSpBill.getItemTax2());
			generateBill.setItemTax3(regSpBill.getItemTax3());
			generateBill.setMenuId(regSpBill.getMenuId());
			generateBill.setMenuTitle(regSpBill.getMenuTitle());
			generateBill.setOrderId(regSpBill.getRspId());
			generateBill.setOrderMrp(regSpBill.getMrp());
			generateBill.setOrderQty(regSpBill.getQty());
			generateBill.setOrderRate(regSpBill.getRate());
			generateBill.setRateType(regSpBill.getRateCat());
			generateBill.setSubCatId(regSpBill.getItemGrp2());
			generateBill.setIsSameState(regSpBill.getIsSameState());
			generateBill.setPartyName(regSpBill.getPartyName());
			generateBill.setPartyAddress(regSpBill.getPartyAddress());
			generateBill.setPartyGstin(regSpBill.getPartyGstin());
			generateBill.setHsnCode(regSpBill.getHsnCode());//new
			generateBillList.add(generateBill);
			
			System.out.println("converted Bill : "+generateBillList.toString());
			
			
		}
			

		return generateBillList;
	}

	private List<GenerateBill> convertSpCakeToItem(List<GenerateSpBill> generateSpBills,
			List<GenerateBill> generateBillList) {

		for (int i = 0; i < generateSpBills.size(); i++) {
			GenerateSpBill spBill = generateSpBills.get(i);

			GenerateBill generateBill = new GenerateBill();

			generateBill.setCatId(spBill.getCatId());
			generateBill.setIsPositive(spBill.getDisc());
			generateBill.setDeliveryDate(spBill.getSpDeliveryDate());
			generateBill.setFrCode(spBill.getFrCode());
			generateBill.setFrId(spBill.getFrId());
			generateBill.setFrName(spBill.getFrName());
			generateBill.setGrnType(3);
			generateBill.setItemId(spBill.getSpId());
			generateBill.setItemName(spBill.getSpName());
			generateBill.setItemShelfLife(1);
			generateBill.setItemTax1(spBill.getSpTax1());
			generateBill.setItemTax2(spBill.getSpTax2());
			generateBill.setItemTax3(spBill.getSpTax3());
			generateBill.setMenuId(spBill.getMenuId());
			generateBill.setMenuTitle(spBill.getMenuTitle());
			generateBill.setOrderId(spBill.getSpOrderNo());
			generateBill.setOrderMrp(spBill.getSpGrandTotal());
			generateBill.setOrderQty(1);
			generateBill.setOrderRate(spBill.getSpBackendRate());
			generateBill.setRateType(spBill.getRateType());
			generateBill.setSubCatId(spBill.getSubCatId());
			generateBill.setIsSameState(spBill.getIsSameState());
            generateBill.setPartyName(spBill.getPartyName());
            generateBill.setPartyAddress(spBill.getPartyAddress());
            generateBill.setPartyGstin(spBill.getPartyGstin());
            generateBill.setHsnCode(spBill.getHsnCode());//new
			generateBillList.add(generateBill);
		}

		return generateBillList;

	}

}
