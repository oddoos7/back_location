-- 기존 테이블이 있을 경우 삭제
DROP TABLE IF EXISTS store;

-- store 테이블 생성
CREATE TABLE store (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    address VARCHAR(500) NOT NULL,
    phone VARCHAR(20),
    latitude DOUBLE NOT NULL,
    longitude DOUBLE NOT NULL
);

-- 예시 데이터 삽입
INSERT INTO store (name, address, phone, latitude, longitude) VALUES
    ('김밥천국', '서울특별시 강남구 테헤란로 123', '010-1234-5678', 37.501274, 127.039585),
    ('맘스터치', '서울특별시 서초구 반포대로 222', '010-2345-6789', 37.503036, 127.004928),
    ('버거킹', '서울특별시 종로구 종로 100', '010-3456-7890', 37.570377, 126.982828),
    ('이삭토스트', '부산광역시 해운대구 센텀중앙로 45', '010-4567-8901', 35.170874, 129.130426),
    ('한솥도시락', '대구광역시 수성구 달구벌대로 2485', '010-5678-9012', 35.857554, 128.628208);

-- 확인용
SELECT * FROM store;
