package com.admin.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.admin.controller.ifs.CrudInterface;
import com.admin.model.entity.Item;
import com.admin.model.network.Header;
import com.admin.model.network.request.ItemApiRequest;
import com.admin.model.network.response.ItemApiResponse;
import com.admin.repository.ItemRepository;
import com.admin.repository.PartnerRepository;

@Service
public class ItemApiService implements CrudInterface<ItemApiRequest, ItemApiResponse>{

	@Autowired
	private PartnerRepository partnerRepository;
	
	@Autowired
	private ItemRepository itemRepository;
	
	@Override
	public Header<ItemApiResponse> create(Header<ItemApiRequest> request) {
		ItemApiRequest body = request.getData();
		
        Item item = Item.builder()
        		    	 .status(body.getStatus())
        		    	 .name(body.getName())
        		    	 .title(body.getTitle())
        		    	 .content(body.getContent())
        		    	 .price(body.getPrice())
        		    	 .brandName(body.getBrandName())
        		    	 .registeredAt(LocalDateTime.now())
        		    	 .partner(partnerRepository.getOne( body.getPartnerId() ))
        		    	 .build();
        
        Item newItem = itemRepository.save(item);
        
		return response(newItem);
	}

	@Override
	public Header<ItemApiResponse> read(Long id) {
		return itemRepository.findById(id)
				  .map(item -> response(item))
				  .orElseGet(() -> Header.ERROR("데이터 없음"));
		
	}

	@Override
	public Header<ItemApiResponse> update(Header<ItemApiRequest> request) {
		ItemApiRequest body = request.getData();

        itemRepository.findById(body.getId())
        					.map(entityItem -> {
        								entityItem
        											.setStatus(body.getStatus())
        											.setName(body.getName())
        											.setTitle(body.getTitle())
        											.setContent(body.getContent())
        											.setPrice(body.getPrice())
        											.setBrandName(body.getBrandName())
        											.setRegisteredAt(body.getRegisteredAt())
        											.setUnregisteredAt(body.getUnregisteredAt());

                    return entityItem;
                    
               })
                .map(newEntityItem -> itemRepository.save(newEntityItem)) // 람다식
                .map(item -> response(item))
                .orElseGet( () -> Header.ERROR("테이터 없음") );
        
        return null;
        
	}

	@Override
	public Header delete(Long id) {
		return itemRepository.findById(id)
				  .map( item -> {
					  		itemRepository.delete(item);
					  		return Header.OK();
                })
                .orElseGet( () -> Header.ERROR("테이터 없음") );
		
	}
	
	 // 공통메서드
   private Header<ItemApiResponse> response(Item item) {
	   ItemApiResponse body = ItemApiResponse.builder()
							               .id(item.getId())
							               .status(item.getStatus())
							               .name(item.getName())
							               .title(item.getTitle())
							               .content(item.getContent())
							               .price(item.getPrice())
							               .brandName(item.getBrandName())
							               .registeredAt(item.getRegisteredAt())
							               .unregisteredAt(item.getUnregisteredAt())
							               .partnerId(item.getPartner().getId())
							               .build();
        
	   return Header.OK(body);
	   
    }

}
