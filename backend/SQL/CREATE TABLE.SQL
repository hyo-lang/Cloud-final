-- 회원 관리 테이블
CREATE TABLE `USER` (
    userNum INT PRIMARY KEY AUTO_INCREMENT, 	-- 사용자 고유번호 (PK)
    userName VARCHAR(50) NOT NULL, 			-- 사용자 이름
    userPwd VARCHAR(100) NOT NULL, 			-- 사용자 비밀번호
    userEmail VARCHAR(100) NOT NULL UNIQUE, 	-- 사용자 이메일 (고유값)
    -- userBirth DATE NOT NULL, 				-- 관리자 생년월일
    userGender ENUM('여성', '남성', 'Other') NOT NULL, 	-- 사용자 성별 (0: 여성, 1: 남성, 2: 기타)
    userSignupDate TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- 관리자 테이블
CREATE TABLE ADMINS (
    admindNum INT PRIMARY KEY AUTO_INCREMENT, -- 관리자 고유번호 (PK)
    admindName VARCHAR(100) NOT NULL, 			-- 관리자 이름
    admindPwd VARCHAR(100) NOT NULL, 			-- 관리자 비밀번호 (암호화 필요)
    admindEmail VARCHAR(100) NOT NULL UNIQUE, 	-- 관리자 이메일 (고유값)
    -- adminsBirth DATE NOT NULL, 				-- 관리자 생년월일
    admindGender ENUM('여성', '남성', 'Other') NOT NULL, 	-- 사용자 성별 (0: 여성, 1: 남성, 2: 기타)
    admindSignupDate TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);


