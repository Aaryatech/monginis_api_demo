package com.ats.webapi.service.tally;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ats.webapi.model.ErrorMessage;
import com.ats.webapi.model.tally.SalesVoucherList;

@Service
public interface SalesVoucherService {

	SalesVoucherList getAllSalesVoucher();

	ErrorMessage updateSalesVouchers(int billNoList, int isTallySync);


}
