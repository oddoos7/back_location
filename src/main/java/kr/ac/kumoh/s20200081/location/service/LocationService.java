package kr.ac.kumoh.s20200081.location.service;

import kr.ac.kumoh.s20200081.location.dto.StoreLocationResponse;
import kr.ac.kumoh.s20200081.location.model.Store;
import kr.ac.kumoh.s20200081.location.repository.StoreRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LocationService {

    private final StoreRepository storeRepository;

    public LocationService(StoreRepository storeRepository) {
        this.storeRepository = storeRepository;
    }

    // 현재 위치 기준 반경 내 가게 검색
    public List<StoreLocationResponse> getNearbyStores(double lat, double lng, double radiusKm) {
        return storeRepository.findNearbyStores(lat, lng, radiusKm)
                .stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }

    // 특정 가게 위치 정보 조회
    public StoreLocationResponse getStoreLocation(Long storeId) {
        Store store = storeRepository.findById(storeId)
                .orElseThrow(() -> new RuntimeException("Store not found with id: " + storeId));
        return toResponse(store);
    }

    private StoreLocationResponse toResponse(Store store) {
        return StoreLocationResponse.builder()
                .id(store.getId())
                .name(store.getName())
                .address(store.getAddress())
                .latitude(store.getLatitude())
                .longitude(store.getLongitude())
                .build();
    }
}
