package kr.ac.kumoh.s20200081.location.repository;

import kr.ac.kumoh.s20200081.location.model.Store;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StoreRepository extends JpaRepository<Store, Long> {

    @Query(value = "SELECT * FROM store s " +
            "WHERE (6371 * acos(cos(radians(?1)) * cos(radians(s.latitude)) * " +
            "cos(radians(s.longitude) - radians(?2)) + sin(radians(?1)) * sin(radians(s.latitude)))) < ?3",
            nativeQuery = true)
    List<Store> findNearbyStores(double userLat, double userLng, double distanceKm);
}
