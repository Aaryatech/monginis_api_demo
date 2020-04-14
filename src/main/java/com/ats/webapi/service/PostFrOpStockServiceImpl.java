package com.ats.webapi.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ats.webapi.model.FrStockBetweenMonth;
import com.ats.webapi.model.GetCurrentStockDetails;
import com.ats.webapi.model.PostFrItemStockDetail;
import com.ats.webapi.model.PostFrItemStockHeader;
import com.ats.webapi.repository.FrStockBetweenMonthRepository;
import com.ats.webapi.repository.PostFrOpStockDetailRepository;
import com.ats.webapi.repository.PostFrOpStockHeaderRepository;

@Service
public class PostFrOpStockServiceImpl implements PostFrOpStockService {

	@Autowired
	PostFrOpStockHeaderRepository postFrOpStockHeaderRepository;

	@Autowired
	PostFrOpStockDetailRepository postFrOpStockDetailRepository;

	@Autowired
	FrStockBetweenMonthRepository stockBetweenMonthRepository;

	@Override
	public List<PostFrItemStockHeader> saveFrOpStockHeader(PostFrItemStockHeader postFrItemStockHeader) {

		PostFrItemStockHeader postFrItemStockHeaders = new PostFrItemStockHeader();
		List<PostFrItemStockHeader> postFrItemStockHeaderList = new ArrayList<PostFrItemStockHeader>();

		postFrItemStockHeaders = postFrOpStockHeaderRepository.save(postFrItemStockHeader);
		postFrItemStockHeaderList.add(postFrItemStockHeaders);
		int headerId = postFrItemStockHeader.getOpeningStockHeaderId();

		List<PostFrItemStockDetail> PostFrItemStockDetailList = postFrItemStockHeader.getPostFrItemStockDetailList();

		for (int j = 0; j < PostFrItemStockDetailList.size(); j++) {

			PostFrItemStockDetail postFrItemStockDetail = PostFrItemStockDetailList.get(j);

			postFrItemStockDetail.setOpeningStockHeaderId(headerId);

			postFrOpStockDetailRepository.save(postFrItemStockDetail);

		}

		return postFrItemStockHeaderList;
	}

	@Override
	public int updateEndMonth(PostFrItemStockHeader postFrItemStockHeader) {

		int updateResult = 0;
		try {
			// update existing entry
			List<PostFrItemStockDetail> PostFrItemStockDetailList = postFrItemStockHeader
					.getPostFrItemStockDetailList();

			for (int j = 0; j < PostFrItemStockDetailList.size(); j++) {

				PostFrItemStockDetail postFrItemStockDetail = PostFrItemStockDetailList.get(j);

				postFrOpStockDetailRepository.save(postFrItemStockDetail);

			}
			int headerId = postFrItemStockHeader.getOpeningStockHeaderId();

			updateResult = postFrOpStockHeaderRepository.endMonth(headerId);

			// new opening month entry
			PostFrItemStockHeader newHeader = new PostFrItemStockHeader();
			if (postFrItemStockHeader.getMonth() == 12) {
				newHeader.setYear(postFrItemStockHeader.getYear() + 1);
				newHeader.setMonth(1);

			} else {
				newHeader.setMonth(postFrItemStockHeader.getMonth() + 1);
				newHeader.setYear(postFrItemStockHeader.getYear());

			}

			newHeader.setFrId(postFrItemStockHeader.getFrId());
			newHeader.setCatId(postFrItemStockHeader.getCatId());

			newHeader.setIsMonthClosed(0);

			PostFrItemStockHeader postFrItemStockHeaders = new PostFrItemStockHeader();

			postFrItemStockHeaders = postFrOpStockHeaderRepository.save(newHeader);

			for (int j = 0; j < PostFrItemStockDetailList.size(); j++) {

				PostFrItemStockDetail oldStockDetail = PostFrItemStockDetailList.get(j);

				PostFrItemStockDetail newStockDetail = new PostFrItemStockDetail();
				newStockDetail.setOpeningStockHeaderId(postFrItemStockHeaders.getOpeningStockHeaderId());
				newStockDetail.setItemId(oldStockDetail.getItemId());
				newStockDetail.setItemName(oldStockDetail.getItemName());
				newStockDetail.setRegOpeningStock(oldStockDetail.getPhysicalStock());
				newStockDetail.setSpOpeningStock(oldStockDetail.getSpOpeningStock());
				newStockDetail.setPhysicalStock(0);
				newStockDetail.setRemark("");
				newStockDetail.setStockDifference(0);
				newStockDetail.setRegTotalGrnGvn(0);
				newStockDetail.setRegTotalPurchase(0);
				newStockDetail.setSpTotalPurchase(0);
				newStockDetail.setRegTotalSell(0);
				newStockDetail.setSpTotalSell(0);

				postFrOpStockDetailRepository.save(newStockDetail);

			}
			
		} catch (Exception e) {

			e.printStackTrace();
			updateResult = 0;
		}
		return updateResult;
	}

	@Override
	public PostFrItemStockHeader getFrOpStockHeader(int frId, int month, int year) {

		PostFrItemStockHeader postFrItemStockHeader = postFrOpStockHeaderRepository.getFrHeader(frId, month, year);
		int headerId = postFrItemStockHeader.getOpeningStockHeaderId();

		List<PostFrItemStockDetail> postFrItemStockDetail = postFrOpStockDetailRepository.getFrDetail(headerId);
		postFrItemStockHeader.setPostFrItemStockDetailList(postFrItemStockDetail);

		return postFrItemStockHeader;
	}

	@Override
	public PostFrItemStockHeader getRunningMonth(int frId) {

		PostFrItemStockHeader frItemStockHeader = postFrOpStockHeaderRepository.getRunningMonth(frId);

		return frItemStockHeader;
	}

	@Override
	public List<GetCurrentStockDetails> getStockBetweenMonth(int frId, int fromMonth, int toMonth,
			List<Integer> itemIdList) {

		List<GetCurrentStockDetails> stockBetweenMonth = stockBetweenMonthRepository.getStockBetweenMonths(frId,
				fromMonth, toMonth, itemIdList);

		return stockBetweenMonth;
	}

}
