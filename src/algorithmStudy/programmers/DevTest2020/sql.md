문제 설명
CHARACTERS 테이블은 XX런게임에서 살 수 있는 캐릭터의 정보를 담고 있는 테이블입니다. CHARACTERS 테이블 구조는 다음과 같으며, NAME, SPEED, BOOST_SPEED, BOOST_TIME, PRICE는 각각 캐릭터의 이름, 속도, 부스트 속도, 부스트 지속 시간, 가격을 나타냅니다.

NAME    TYPE
NAME    VARCHAR
SPEED   INT
BOOST_SPEED INT
BOOST_TIME  INT
PRICE   INT
PURCHASES 테이블은 XX런 게임의 유료 캐릭터 구매내역을 담고 있는 테이블입니다. PURCHASES 테이블의 구조는 다음과 같으며, ID, USER_ID, PURCHASE_DATE, ITEM은 각각 ID, 유저의 ID, 구매 날짜, 산 캐릭터의 이름을 나타냅니다.

NAME    TYPE
ID  INT
USER_ID VARCHAR
PURCHASE_DATE   DATETIME
ITEM    VARCHAR
CHARACTERS 테이블에 있는 모든 캐릭터에 대해, 캐릭터의 이름과 해당 캐릭터가 구입된 횟수를 조회하는 쿼리를 작성해주세요. 결과는 캐릭터의 이름 순으로 조회되어야 하며, 한 번도 구입되지 않은 캐릭터가 구입된 횟수는 0으로 나와야 합니다.

예시
예를 들어, CHARACTERS 테이블, PURCHASES 테이블이 다음과 같다면

CHARACTERS

NAME    SPEED   BOOST_SPEED BOOST_TIME  PRICE
Albatross   198 447 12  1000
Bee 201 472 7   3000
PURCHASES

ID  USER_ID PURCHASE_DATE   ITEM
1   user2   2016-12-11 10:30:05 Bee
2   user1   2016-11-16 23:23:32 Bee
Albatross 는 한 번도 구입된 적이 없습니다.
Bee는 두 번 구입되었습니다.

따라서 이때는 SQL을 실행하면 다음과 같이 출력되어야 합니다.

NAME    CNT
Albatross   0
Bee 2