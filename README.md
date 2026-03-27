# CMS REST API
안녕하십니까 지원자 서준범입니다.

본 과제는 Spring Boot 기반으로 구현한 CMS REST API 과제입니다.
Controller - Service - Mapper 계층 구조로 설계하였으며,
MyBatis를 활용하여 SQL 중심의 데이터 처리 로직을 구현했습니다.

데이터베이스는 Oracle DB를 사용하여 게시판 및 사용자 관리 기능을 구현하였고,
REST API와 AJAX 비동기 통신을 활용하여 개발했습니다.

---

# 기술 스택 (Tech Stack)

Backend  
- Spring Boot
- MyBatis

Database  
- Oracle DB

Frontend  
- Thymeleaf
- JavaScript
- AJAX (XMLHttpRequest / Fetch API)

---

# 구현 기능

### 사용자 기능
- 회원가입
- 로그인 / 로그아웃 (Session 기반 인증)
- 사용자 권한 구분 (USER / ADMIN)

### 게시판 기능
- 게시글 작성
- 게시글 목록 조회
- 게시글 상세 조회
- 게시글 수정
- 게시글 삭제
- 게시글 페이징 처리

### 권한 처리
- 작성자 본인만 게시글 수정 및 삭제 가능
- 관리자(ADMIN)는 모든 콘텐츠 수정 및 삭제가 가능
- 비로그인 사용자 접근 제한

### 추가 기능
- 조회수 증가 처리
- 중복 조회 방지 (Session 기반)
- AJAX 처리 방식 - > XMLHttpRequest / Fetch API 방식 구현

---
# 프로젝트 실행 방법
- 서버 가동 후 localhost:9091로 접속

---
# Oracle DB 테이블 생성문
아래 SQL을 실행하면 데이터베이스 테이블이 생성됩니다.

```sql
-- 사용자 테이블
CREATE TABLE cms_user (
    user_idx NUMBER(5) PRIMARY KEY,
    id VARCHAR2(100) NOT NULL UNIQUE,
    username VARCHAR2(50) NOT NULL,
    password VARCHAR2(100) NOT NULL,
    role VARCHAR2(20) NOT NULL
);

-- 사용자 테이블 시퀀스
CREATE SEQUENCE user_idx_seq

-- 게시글 테이블
CREATE TABLE cms_board(
    board_idx number(5) PRIMARY KEY,
    title varchar2(100) NOT NULL,
    content varchar2(3000),
    writer varchar2(50),
    writedate date,
    modifier varchar2(50),
    modifierdate date,
    readnum number,
    user_idx number(5)
)
-- 게시글 테이블 시퀀스
CREATE SEQUENCE board_idx_seq
