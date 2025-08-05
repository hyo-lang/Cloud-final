# 🛍️ AWS 기반 3-Tier 아키텍처 쇼핑몰 웹사이트

## 📖 1. 프로젝트 개요
본 프로젝트는 **AWS 클라우드 환경**을 기반으로 3-Tier 아키텍처(웹·애플리케이션·데이터베이스 계층 분리)를 적용한 **쇼핑몰 웹사이트** 구축을 목표로 진행되었습니다.  
EKS 기반의 Kubernetes 클러스터 위에 **NGINX(Web)**, **Tomcat(WAS)**, **MariaDB(DB)** 를 배포하고, Docker 컨테이너화 및 자동 스케일링 환경을 구현하여 **고가용성**과 **확장성**을 확보했습니다.  
Rolling Update 방식을 적용해 무중단 배포를 구현하고, **JMeter 기반 부하 테스트**를 통해 트래픽 분산과 성능 최적화를 검증했습니다.

---

## 🛠️ 2. 기술 스택

### ☁️ 인프라 & 배포
- **AWS**: EKS, ECR, RDS, Route 53, ACM  
- **Container**: Docker  
- **Orchestration**: Kubernetes  
- **Architecture**: 3-Tier 구조 (Web–App–DB)  

### 💻 백엔드 개발
- Java 17, Spring Boot, JSP/Servlet  
- MyBatis, MariaDB  

### 🎨 프론트엔드
- JSP, HTML, CSS, JavaScript  

### 🤝 협업 & 관리
- GitHub, Slack, Google Sheet  

---

## 🏗️ 3. 아키텍처
👤 사용자 요청
↓
🌐 [Route 53] → [ALB / Ingress Controller] → 🌎 [NGINX Pod(Web)]
↓
🖥️ [Tomcat Pod(WAS)]
↓
🗄️ [MariaDB RDS]

- **Web Layer**: 🌎 NGINX Reverse Proxy, 정적 자원 처리  
- **Application Layer**: 🖥️ Tomcat WAS, Spring Boot 기반 동적 페이지 처리  
- **Database Layer**: 🗄️ Amazon RDS(MariaDB) 기반 데이터 저장 및 관리  
- **Auto Scaling**: 📈 Cluster Autoscaler + HPA를 이용한 CPU/메모리 기반 확장  
- **CI/CD**: 📦 Docker 이미지 빌드 및 ECR 연동 배포  

---

## 🚀 4. 실행 방법

1️⃣ **클론**
```bash
git clone https://github.com/hyo-lang/cloudshop.git
cd cloudshop
```
2️⃣ Docker 이미지 빌드 & 푸시
```
docker build -t <ECR_REPOSITORY_URI>:<TAG> .
docker push <ECR_REPOSITORY_URI>:<TAG>
```
3️⃣ 쿠버네티스 배포
```
kubectl apply -f yaml/Nginx/FrontNginx.yaml
kubectl apply -f yaml/Tomcat/BackTomcat.yaml
kubectl apply -f yaml/cluster-autoscaler-autodiscover.yaml
```

4️⃣ 접속

🌐 Route 53에 연결된 도메인 또는 ALB 주소로 접속

## 🌟 5. 주요 기능
👥 회원 관리: 회원가입, 로그인, 사용자 정보 조회

🛒 상품 관리: 상품 목록, 상세 보기, 장바구니

🛠️ 관리자 페이지: 상품 등록/수정/삭제, 회원 관리

🔄 무중단 배포: Rolling Update 기반 서비스 운영

📈 자동 확장: 부하 발생 시 노드/파드 자동 증설

📊 성능 모니터링: Metrics Server, CloudWatch를 통한 실시간 모니터링

🧪 부하 테스트: JMeter 기반 시나리오 테스트로 최대 6,000명 동시 접속 환경 검증
