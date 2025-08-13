# gRPC 예제 코드 및 성능 측정
- 버전 : Java 21, Springboot 3.5.5
- 성능 측정 & 데이터 수집 & 시각화 도구 : Grafana, Prometheus, k6

> 관련 내용을 정리한 글은 [여기](https://velog.io/@2iedo/Spring-Boot-4-gRPC%EC%97%90-%EA%B4%80%ED%95%98%EC%97%AC-%EC%84%B1%EB%8A%A5-%EC%B8%A1%EC%A0%95%EC%9D%84-%EA%B3%81%EB%93%A4%EC%9D%B8)서 확인하실 수 있습니다.

# 성능 측정 결과
1. VUS 100명, Durtion 30초
- gRPC
<img width="1122" height="457" alt="gRPC_k6" src="https://github.com/user-attachments/assets/5e041812-0b03-4973-8eaf-3dc40d6ae233" />
<img width="1572" height="552" alt="gRPC_grafana" src="https://github.com/user-attachments/assets/85e8fd35-2a96-4b42-bcb5-289fc7c97e00" />

- REST
<img width="1398" height="511" alt="REST_k6" src="https://github.com/user-attachments/assets/d5e707b6-2370-45d5-ac11-c68e1299ae89" />
<img width="1571" height="567" alt="REST_grafana" src="https://github.com/user-attachments/assets/26cba792-d5c6-410f-a5f7-a7e69edb45c0" />

2. VUS 200명, Duration 30초
- gRPC
<img width="1122" height="452" alt="gRPC200_k6" src="https://github.com/user-attachments/assets/a6ea673d-5302-4cf2-a8f6-6e8bdfab5573" />
<img width="1580" height="552" alt="gRPC200_grafana" src="https://github.com/user-attachments/assets/af09deca-89bd-4da5-872c-2f7480e34738" />

- REST
<img width="1367" height="500" alt="REST200_k6" src="https://github.com/user-attachments/assets/90033516-876a-4ca3-948c-4a57d25121f7" />
<img width="1572" height="552" alt="REST200_grafana" src="https://github.com/user-attachments/assets/add13d36-c585-45e7-8d5d-22c7d1e34ad7" />
