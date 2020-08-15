->는 method임
Class : 바카라 게임, 대사 출력. 카드댁 만들기, 카드VO?, 손님들, 딜러원맨쇼, HistoryBoard
Interface : 딜러대사, 시스템대사










1.[바카라 게임]
->게임 시작
	[손님들] .설정받기
	[게임].진행
	[출력].결과출력 <- DTO <-[게임].결과
	[HBoard].결과받기<-DTO<-[게임].결과
	[손님들].승패받기 <-DTO <- [게임].결과
	
	상황
	1. 경기수 or 1명을 제외한 파산 
	2. 경기수 남아있음 and 파산없음

	a.이어하기
	b.끝내기
	c.처음부터하기



	1 -> 이어하기 못함
	2 -> 전부 가능

	b,c -> [손님].게임결과출력
	c -> 모든 진행상황 초기화 후 재시작

-> init()
	모든 진행상황 초기화




===============================================


/*
*Static Class로 출력가능하게 할것
*dealerSay와 systemSay는 각각 String값을 받아 출력해주는 역할만함
*대사는 interface에서 받아오고, %d %s와 같은 값은 게임에서 받아온다.
*/

2.[대사출력] implements [딜러대사], [시스템대사]
->print상황()
->print상황(특정 값...) 등등

//ex) 딜러 : Player draw... 7
->dealerSay_OpenCard(String who, int cardSum)	who -> Player, cardSum -> 7
	String str=[딜러대사].OPEN_CARD		//"%s draw... %d\n"
	String str2=String.format(str, who, cardSum)	//"Player draw... 7"

	dealerSay(str2);


->dealerSay(String str)
	//"딜러 :" + str  형태로 출력 하거나, 길이를 받아서 위아래 태두리 쳐주고 꾸며서 출력하거나
	//출력형태를 정할수있음



3.딜러
->원맨쇼
	댁셔플
	P와 B 각각 2뽑
	[국룰].set댁(p댁, b댁)
	[국룰].PneedToDraw() 가 true면 P 1뽑
	[국룰].BneedToDraw() 가 true면 b도 1뽑	//P와 B의 객체를 던져줌으로써 P가 1뽑하면 B의 뽑기 여부를 쉽게 판단할수있음



