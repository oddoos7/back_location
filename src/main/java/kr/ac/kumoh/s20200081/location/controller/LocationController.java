package kr.ac.kumoh.s20200081.location.controller;

import kr.ac.kumoh.s20200081.location.dto.StoreLocationResponse;
import kr.ac.kumoh.s20200081.location.service.LocationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/location")
public class LocationController {

    private final LocationService locationService;

    public LocationController(LocationService locationService) {
        this.locationService = locationService;
    }

    // 현재 위치 기반 가게 검색
    @GetMapping("/nearby")
    public List<StoreLocationResponse> getNearbyStores(
            @RequestParam double lat,
            @RequestParam double lng,
            @RequestParam(defaultValue = "3.0") double radiusKm
    ) {
        return locationService.getNearbyStores(lat, lng, radiusKm);
    }

    // 특정 가게의 위치 정보 제공
    @GetMapping("/store/{storeId}")
    public StoreLocationResponse getStoreLocation(@PathVariable Long storeId) {
        return locationService.getStoreLocation(storeId);
    }
}
