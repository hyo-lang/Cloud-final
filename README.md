# 🛍️ JJangtrio Cloud Shopping Mall

AWS 기반 3-Tier 구조로 설계된 쇼핑몰 시스템입니다.  
Docker, ECS/EKS, MariaDB를 활용하여 클라우드 환경에서 안정적으로 배포 및 운영됩니다.

---

## 📦 기술 스택

| 영역       | 기술 |
|------------|------|
| Frontend   | React, Tailwind CSS |
| Backend    | Spring Boot, MyBatis |
| Database   | MariaDB (RDS) |
| CI/CD      | GitHub Actions, ECR |
| Infra      | AWS VPC, ALB, EC2, ECS/EKS, Route53, S3 |
| Container  | Docker |
| 보안       | IAM, SG, HTTPS (ACM 인증서) |

---

## 🧱 아키텍처 개요

- **3-Tier 구조**
  - **Frontend (Web Tier)**: React 기반 SPA, S3 + CloudFront 정적 호스팅 또는 ALB를 통한 ECS/EKS 배포
  - **Backend (App Tier)**: Spring Boot 애플리케이션 컨테이너로 구성, ECS(Fargate)/EKS로 오케스트레이션
  - **Database (Data Tier)**: AWS RDS(MariaDB) 사용, Multi-AZ 구성으로 가용성 확보

- **보안**: IAM Role, Security Group, Subnet 분리 (Public / Private), HTTPS 인증서 적용

---

## 🚀 주요 기능

- 회원가입 및 로그인 (JWT 기반 인증)
- 상품 목록 조회 및 상세 페이지
- 장바구니 기능
- 주문 처리 및 결제
- 관리자 페이지 (상품 및 회원 관리)
- 마이페이지 (주문 내역, 포인트, 알림 설정 등)

---

## 🔧 배포 방식

### 1. Docker 이미지 빌드 및 푸시
```bash
docker build -t jjangtrio-backend .
docker tag jjangtrio-backend:latest <ECR_URI>:latest
docker push <ECR_URI>:latest
