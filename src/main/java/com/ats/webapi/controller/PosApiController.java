package com.ats.webapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ats.webapi.model.SellBillDetailForPos;
import com.ats.webapi.model.SellBillHeaderAndDetail;
import com.ats.webapi.model.TaxLabListForPos;
import com.ats.webapi.repository.SellBillDetailForPosRepository;
import com.ats.webapi.repository.SellBillHeaderRepositoryPos;
import com.ats.webapi.repository.TaxLabListForPosPosRepository;

@RestController
public class PosApiController {

	@Autowired
	SellBillHeaderRepositoryPos sellBillHeaderRepositoryPos;

	@Autowired
	SellBillDetailForPosRepository sellBillDetailForPosRepository;

	@Autowired
	TaxLabListForPosPosRepository taxLabListForPosPosRepository;

	@RequestMapping(value = { "/getSellBillHeaderAndDetailForPos" }, method = RequestMethod.POST)
	public @ResponseBody SellBillHeaderAndDetail getSellBillHeaderAndDetailForPos(@RequestParam("billId") int billId,
			@RequestParam("flag") int flag) {

		SellBillHeaderAndDetail sellBillHeaderAndDetail = new SellBillHeaderAndDetail();

		try {

			sellBillHeaderAndDetail = sellBillHeaderRepositoryPos.getSellBillHeaderAndDetailForPos(billId);
			List<SellBillDetailForPos> list = sellBillDetailForPosRepository.getSellBillDetailForPos(billId);
			sellBillHeaderAndDetail.setList(list);
			//System.out.println(flag);
			if (flag == 1) {
				List<TaxLabListForPos> taxLabListForPosList = taxLabListForPosPosRepository
						.taxLabListForPosList(billId);
				sellBillHeaderAndDetail.setTaxlabList(taxLabListForPosList);
			}

			

		} catch (Exception e) {
			e.printStackTrace();
		}

		return sellBillHeaderAndDetail;

	}
	@RequestMapping(value = { "/getSellBillHeaderAndDetailForPosDetail" }, method = RequestMethod.POST)
	public @ResponseBody SellBillHeaderAndDetail getSellBillHeaderAndDetailForPosDetail(@RequestParam("billId") int billId,@RequestParam("billDetailNoList") List<Integer> billDetailNoList,
			@RequestParam("flag") int flag) {

		SellBillHeaderAndDetail sellBillHeaderAndDetail = new SellBillHeaderAndDetail();

		try {

			sellBillHeaderAndDetail = sellBillHeaderRepositoryPos.getSellBillHeaderAndDetailForPos(billId);
			List<SellBillDetailForPos> list = sellBillDetailForPosRepository.getSellBillDetailForPosDetail(billDetailNoList);
			sellBillHeaderAndDetail.setList(list);                           
			//System.out.println(flag);
			if (flag == 1) {
				List<TaxLabListForPos> taxLabListForPosList = taxLabListForPosPosRepository
						.taxLabDetailsListForPosList(billDetailNoList);
				sellBillHeaderAndDetail.setTaxlabList(taxLabListForPosList);
			}

			

		} catch (Exception e) {
			e.printStackTrace();
		}

		return sellBillHeaderAndDetail;

	}
}
