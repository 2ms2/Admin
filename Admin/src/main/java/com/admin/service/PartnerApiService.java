package com.admin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.admin.controller.ifs.CrudInterface;
import com.admin.model.entity.Partner;
import com.admin.model.network.Header;
import com.admin.model.network.request.PartnerApiRequest;
import com.admin.model.network.response.PartnerApiResponse;
import com.admin.repository.PartnerRepository;

@Service
public class PartnerApiService implements CrudInterface<PartnerApiRequest, PartnerApiResponse> {
	
	@Autowired
	private PartnerRepository partnerRepository;
	
	@Override
	public Header<PartnerApiResponse> create(Header<PartnerApiRequest> request) {
		return null;
		
	}

	@Override
	public Header<PartnerApiResponse> read(Long id) {
		return partnerRepository.findById(id)
                .map(partner -> response(partner))
                .orElseGet(() -> Header.ERROR("데이터 없음"));
		
	}

	@Override
	public Header<PartnerApiResponse> update(Header<PartnerApiRequest> request) {
		return null;
		
	}

	@Override
	public Header delete(Long id) {
		return null;
		
	}
	
	 private Header<PartnerApiResponse> response(Partner partner) {
	        PartnerApiResponse body = PartnerApiResponse.builder()
									               .id(partner.getId())
									               .name(partner.getName())
									               .status(partner.getStatus())
									               .address(partner.getAddress())
									               .callCenter(partner.getCallCenter())
									               .partnerNumber(partner.getPartnerNumber())
									               .businessNumber(partner.getBusinessNumber())
									               .ceoName(partner.getCeoName())
									               .registeredAt(partner.getRegisteredAt())
									               .unregisteredAt(partner.getUnregisteredAt())
									               .categoryId(partner.getCategory().getId())
									               .build();
	        
	        return Header.OK(body);
	        
	    }

}
