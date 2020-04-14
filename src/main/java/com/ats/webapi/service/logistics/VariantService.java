package com.ats.webapi.service.logistics;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ats.webapi.model.Info;
import com.ats.webapi.model.logistics.Variant;

@Service
public interface VariantService {

	Variant postVariant(Variant variant);

	Info deleteVariant(int variantId);

	List<Variant> getAllVariantList();

	Variant getVariantById(int variantId);

	List<Variant> getVariantByMakeIdAndTypeId(int makeId, int typeId);

}
