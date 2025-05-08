package kr.ac.kumoh.s20200081.location.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StoreLocationResponse {
    private Long id;
    private String name;
    private String address;
    private double latitude;
    private double longitude;
}
