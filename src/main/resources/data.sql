INSERT INTO bucket_test_type(created_at, updated_at, description, phrases, test_type)
VALUES (now(), now(), '완전 현직 개발자 type', '나에게 딱 맞는\n개발자 직군을 찾아보세요', 'TYPE_COMMON_1');
INSERT INTO bucket_test_type(created_at, updated_at, description, phrases, test_type)
VALUES (now(), now(), '개발자 준비 중 취업러 type', '지금 백엔드와 프론트엔드\n갈림길에 있나요?', 'TYPE_COMMON_2');
INSERT INTO bucket_test_type(created_at, updated_at, description, phrases, test_type)
VALUES (now(), now(), '기업 성향을 알아보고 싶은 type', '나는 스타트업 성향일까\n대기업 성향일까?', 'TYPE_COMMON_3');
INSERT INTO bucket_test_type(created_at, updated_at, description, phrases, test_type)
VALUES (now(), now(), '성향 테스트를 좋아하는 사람 type', '나도 개발자가 된다면?\n코딩지식없이 테스트하기!', 'TYPE_COMMON_4');
INSERT INTO bucket_test_type(created_at, updated_at, description, phrases, test_type)
VALUES (now(), now(), '아이들은 위한 엄마들의 맘카페 type', '우리 아이의 코딩 잠재력을\n바로 확인하세요!', 'TYPE_MOM_CAFE_1');

INSERT INTO advertisement (created_at, updated_at, advertisement_end_date, advertisement_start_date, advertisement_type,
                           advertiser, image_url, title)
VALUES (now(), now(), now(), now(), 'LECTURE', '김상혁',
        'https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.yna.co.kr%2Fview%2FAKR20200117042400030&psig=AOvVaw27KKp3K51zckObAoDLKGxh&ust=1622812930819000&source=images&cd=vfe&ved=0CAIQjRxqFwoTCKj2s7fH-_ACFQAAAAAdAAAAABAD',
        '광고테스트1'),
       (now(), now(), now(), now(), 'LECTURE', '김상혁',
        'https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.yna.co.kr%2Fview%2FAKR20200117042400030&psig=AOvVaw27KKp3K51zckObAoDLKGxh&ust=1622812930819000&source=images&cd=vfe&ved=0CAIQjRxqFwoTCKj2s7fH-_ACFQAAAAAdAAAAABAD',
        '광고테스트2'),
       (now(), now(), now(), now(), 'RECRUIT', '김상혁',
        'https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.yna.co.kr%2Fview%2FAKR20200117042400030&psig=AOvVaw27KKp3K51zckObAoDLKGxh&ust=1622812930819000&source=images&cd=vfe&ved=0CAIQjRxqFwoTCKj2s7fH-_ACFQAAAAAdAAAAABAD',
        '광고테스트3'),
       (now(), now(), now(), now(), 'RECRUIT', '김상혁',
        'https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.yna.co.kr%2Fview%2FAKR20200117042400030&psig=AOvVaw27KKp3K51zckObAoDLKGxh&ust=1622812930819000&source=images&cd=vfe&ved=0CAIQjRxqFwoTCKj2s7fH-_ACFQAAAAAdAAAAABAD',
        '광고테스트4');

INSERT INTO bias(pillar, bias, en_bias, kr_bias) VALUES
('ROLE', 'V', 'Visualization', '시각화'),
('ROLE', 'A', 'Architecture', '설계'),
('SCALE', 'S', 'Startup', '스타트업'),
('SCALE', 'C', 'Corporation', '대기업'),
('INTEREST', 'P', 'Product', '상품'),
('INTEREST', 'T', 'Technology', '기술'),
('PRIORITY', 'W', 'Work', '업무'),
('PRIORITY', 'L', 'Life', '개인시간'),
('REFERENCE', 'J', 'ETC', '기타'),
('REFERENCE', 'Y', 'ETC', '기타');


INSERT INTO question (created_at, updated_at, pillar, title, answer_type) VALUES
(now(), now(), 'ROLE', '사이드 프로젝트로 앱을 만들기로 결심했다! 내가 가장 먼저 고민하는 것은? ', 'PRESET'),
(now(), now(), 'ROLE', '조별과제를 할때 나는..', 'PRESET'),
(now(), now(), 'ROLE', '내가 가장 뿌듯함을 느끼는 순간은..', 'PRESET'),
(now(), now(), 'ROLE', '건축학과에 입학한 당신, 첫번째 과제로 ''건물설계 모형''을 만들어야 한다.', 'PRESET'),
(now(), now(), 'ROLE', '선선해진 날씨, 취미로 달리기를 하기 위해 런닝화를 사려고 한다.', 'PRESET'),
(now(), now(), 'ROLE', '늦은 밤, 내가 만든 웹사이트에 몇 가지 문제가 생긴 걸 발견했다. 어떤 문제를 먼저 고칠까?', 'PRESET'),
(now(), now(), 'ROLE', '기능은 좋은데 디자인이 맘에 안 들어 앱을 삭제할 때가 종종 있다', 'GAGE'),

(now(), now(), 'SCALE', '들어온 지 반년 정도 된 동아리에서 새로운 팀 프로젝트가 시작됐다.', 'PRESET'),
(now(), now(), 'SCALE', '나는 동아리의 신입회장. 동아리원들의 활동 비용을 일정 부분 지원해주려고 한다.', 'PRESET'),
(now(), now(), 'SCALE', '유튜브를 시작할만한 좋은 컨텐츠가 드디어 생각났다! 촬영이나 영상 편집 경험은 한 번도 없는 나는..', 'PRESET'),
(now(), now(), 'SCALE', '내 앞에 두 개의 버튼이 있다. 어떤 버튼을 누를까?', 'PRESET'),
(now(), now(), 'SCALE', '드디어 동아리 가입기간이 시작됐다! 어떤 동아리에 들어갈까?', 'PRESET'),
(now(), now(), 'SCALE', '새로운 OS(운영체제)가 나왔다고 한다. 궁금한데?', 'PRESET'),
(now(), now(), 'SCALE', '남는 돈이 생겨 주식을 해보려고 한다. 어떤 주식을 살까?', 'PRESET'),
(now(), now(), 'SCALE', '타 부서의 업무에서 오류가 발견되었다.', 'PRESET'),




(now(), now(), 'INTEREST', '남는 천으로 필통을 만들어보기로 했다. 바느질을 할 때 나는...', 'PRESET'),
(now(), now(), 'INTEREST', '시간이 부족해 찍은 시험 문제를 맞췄다.', 'PRESET'),
(now(), now(), 'INTEREST', '이케아에서 산 서랍을 모두 조립했다! 그런데.. 나사가 하나 남네?!', 'PRESET'),
(now(), now(), 'INTEREST', '나는 이런 팀에서 일하고 싶어!', 'PRESET'),
(now(), now(), 'INTEREST', '회사 사람들끼리 스터디를 하네. 나도 해볼까?', 'PRESET'),
(now(), now(), 'INTEREST', '정말 멋진 앱을 발견했을 때 나는..', 'PRESET'),
(now(), now(), 'INTEREST', '나중에 직업을 고를 수 있다면 나는..', 'PRESET'),
(now(), now(), 'INTEREST', '나에게 개발(프로그래밍)은 내가 원하는 서비스를 만들기 위한 수단이다.', 'PRESET'),



(now(), now(), 'PRIORITY', '부캐를 일로 연결시킬 수 있다면 나는..', 'PRESET'),
(now(), now(), 'PRIORITY', '나는 자아실현을', 'PRESET'),
(now(), now(), 'PRIORITY', '업무 외 시간이 생겨서 활용해보려고 한다. 무엇을 할까?', 'PRESET'),
(now(), now(), 'PRIORITY', '업무 외 시간이 생겨서 활용해보려고 한다. 무엇을 할까?', 'PRESET'),
(now(), now(), 'PRIORITY', '할 수만 있다면 평생 일 하며 살고 싶다. ', 'GAGE'),
(now(), now(), 'PRIORITY', '업무가 재밌다면 칼퇴하지 않아도 상관없다.', 'GAGE'),

(now(), now(), 'REFERENCE', '향후 희망하는 직무가 무엇이에요?', 'INFO'),
(now(), now(), 'REFERENCE', '현재 해당 직무에서 근무하신 기간이 어떻게 되나요?', 'INFO');





INSERT INTO preset (created_at, updated_at, question_id, sequence, label, bias, weight) VALUES
(now(), now(), 1, 0, '아이디어를 한눈에 잘 보여줄 수 있는 방법이 뭘까?', 'V', 1),
(now(), now(), 1, 1, '아이디어를 구현하기에 가장 적절한 기술이 뭘까?', 'A', 1),

(now(), now(), 2, 0, '전달받은 내용으로 발표자료를 만든다.', 'V', 1),
(now(), now(), 2, 1, '자료 조사한 내용을 잘 정리해서 전달한다.', 'A', 1),

(now(), now(), 3, 0, '감각적이고 완성도 높은 결과물을 모두에게 보여줄 때', 'V', 1),
(now(), now(), 3, 1, '골치아팠던 문제를 논리정연하게 풀어냈을 때', 'A', 1),

(now(), now(), 4, 0, '모형은 모형일 뿐이다. 머릿속으로 구상한 형태를 아름답게 표현하는 것이 1순위다.', 'V', 1),
(now(), now(), 4, 1, '실제 건물을 짓듯 안정적인 기반과 구조 설계가 1순위다.', 'A', 1),

(now(), now(), 5, 0, '기능 면에서는 살짝 부족해도 예쁜 디자인이 내 맘에 쏙 드는 B 런닝화', 'V', 1),
(now(), now(), 5, 1, '디자인이 아쉽지만 최고의 기능을 갖춘 A 런닝화', 'A', 1),

(now(), now(), 6, 0, '웹사이트의 모든 글꼴이 바탕체로 나오고 있다니.. 글꼴 설정부터 해결한다.', 'V', 1),
(now(), now(), 6, 1, '웹사이트에 들어갈 때마다 로그인을 새로 해야 한다니.. 로그인 문제부터 해결한다.', 'A', 1),

(now(), now(), 7, 0, '전혀 그렇지 않다', 'V', 1),
(now(), now(), 7, 1, '그렇지 않다.', 'V', 0.5),
(now(), now(), 7, 2, '보통이다', 'V', 0),
(now(), now(), 7, 3, '그렇다', 'A', 0.5),
(now(), now(), 7, 4, '매우 그렇다', 'A', 1),



(now(), now(), 8, 0, '난 이 프로젝트에서 이런 일을 하고싶어! 내가 하고싶은 역할을 말한다.', 'S', 1),
(now(), now(), 8, 1, '내가 뭘 하면 좋을까? 어떤 역할을 하면 좋을지, 선배한테 물어본다.', 'C', 1),

(now(), now(), 9, 0, '동아리 활동에 사용했다는 것만 확인되면 OK. 영수증과 사용 금액만 올려달라고 한다.', 'S', 1),
(now(), now(), 9, 1, '이전 기수에서 해왔던 방식을 참고해 사용처∙목적∙영수증 이미지가 담긴 파일을 제출해달라고 한다.', 'C', 1),

(now(), now(), 10, 0, '경험은 없지만 이번 기회에 도전! 지금 있는 핸드폰으로 촬영하고, 퀄리티는 조금 낮더라도 직접 편집해보면서 익힌다.', 'S', 1),
(now(), now(), 10, 1, '이왕 한다면 제대로 해보고 싶다! 기본적인 장비를 마련하고, 편집 강의를 보며 일단 실력을 키운다.', 'C', 1),

(now(), now(), 11, 0, '100% 1000만원 + 15% 확률로 10억을 주는 버튼', 'S', 1),
(now(), now(), 11, 1, '100% 1억을 주는 버튼', 'C', 1),

(now(), now(), 12, 0, '음.. 마음에 쏙 드는 동아리가 없다. 맘 맞는 친구들과 동아리를 새로 만들어서 재밌는 일을 벌인다.', 'S', 1),
(now(), now(), 12, 1, '오래된 전통, 멋진 졸업생들이 많은 동아리가 눈에 들어온다. 동아리 주제 자체는 그저 그렇지만, 선후배 관계가 탄탄히 구축되어 있고 뭔가 얻을 수 있는 게 많아 보인다.', 'C', 1),

(now(), now(), 13, 0, '어떤 기능이 추가되고, 강화되었을까? 고민없이 업데이트 한다.', 'S', 1),
(now(), now(), 13, 1, '그래도 무작정 업데이트는 왠지 불안하다.. 업데이트를 보류하고, 새로운 OS 정보와 후기를 찾아본다.
', 'C', 1),

(now(), now(), 14, 0, '규모는 작은 편이지만 앞으로 대박이 날 것 같은 회사의 주식(테마주)', 'S', 1),
(now(), now(), 14, 1, '시가총액 규모가 크고 투자가 안정적인 회사의 주식(우량주)', 'C', 1),

(now(), now(), 15, 0, '직접 찾아가 함께 논의하여 해결한다.', 'S', 1),
(now(), now(), 15, 1, '내 업무와 관련 없으니 팀장님을 통해 전달한다.', 'C', 1),

(now(), now(), 16, 0, '겉보기에 멀쩡하고 수납만 잘 되면 괜찮다. 눈에 안 보이는 부분은 적당히 바느질한다.', 'P', 1),
(now(), now(), 16, 1, '삐뚤빼뚤한 바느질 땀은 참을 수 없다. 안 보이는 부분이더라도 한 땀 한 땀 꼼꼼히 바느질한다.', 'T', 1),

(now(), now(), 17, 0, '야호~ 기분이 좋아진 채 다른 할 일을 한다.', 'P', 1),
(now(), now(), 17, 1, '아무래도 찝찝하다. 문제를 분석하고 다시 풀어본다.', 'T', 1),

(now(), now(), 18, 0, '여닫는데도 문제없고, 멀쩡한데? 다 조립했으니 이대로 사용한다.', 'P', 1),
(now(), now(), 18, 1, '용납할 수 없다. 서랍을 분해하고 조립 방법이 적힌 가이드를 다시 살핀다.', 'T', 1),

(now(), now(), 19, 0, '사용자가 엄청나게 많은 서비스를 만드는 팀', 'P', 1),
(now(), now(), 19, 1, '사용자는 적지만 기술적으로 도전할 수 있는 팀', 'T', 1),

(now(), now(), 20, 0, '내 직무에 대해서는 혼자서도 공부할 수 있다. 평소에 관심 있었던 다른 분야의 스터디를 한다.', 'P', 1),
(now(), now(), 20, 1, '직무 전문성을 더 키워야지! 직무와 연관된 스터디를 한다.', 'T', 1),

(now(), now(), 21, 0, '어떻게 이런 서비스를 만든거지? 저 팀에는 어떤 사람들이 일하고 있을까?', 'P', 1),
(now(), now(), 21, 1, '어떤 기술을 사용해서 만든거지? 나도 한 번 만들어보고 싶다!', 'T', 1),

(now(), now(), 22, 0, 'CEO(기업 대표)가 되어서 회사의 비즈니스와 관련한 의사결정들을 해보고 싶다.', 'P', 1),
(now(), now(), 22, 1, 'CTO(최고 기술 책임자)가 되어서 회사의 기술적인 문제를 해결하고 싶다.', 'T', 1),

(now(), now(), 23, 0, '그렇다', 'W', 1),
(now(), now(), 23, 1, '아니다.', 'L', 1),


(now(), now(), 24, 0, '부캐를 통해 세컨잡을 찾고 싶다.', 'W', 1),
(now(), now(), 24, 1, '부캐는 철저하게 일 바깥 영역이고 싶다.', 'L', 1),

(now(), now(), 25, 0, '내 커리어의 발전을 통해 한다.', 'W', 1),
(now(), now(), 25, 1, '일 바깥에서 한다.', 'L', 1),


(now(), now(), 26, 0, '커리어를 살릴 수 있는 사이드 프로젝트를 한다.', 'W', 1),
(now(), now(), 26, 1, '커리어와 상관없이 하고 싶었던 취미생활을 즐긴다.', 'L', 1),


(now(), now(), 27, 0, '그래도 내 커리어는 계속 이어 나가야지.', 'W', 1),
(now(), now(), 27, 1, '모두 그만두고 남은 여생을 하고 싶은 것만 하며 즐길 것이다.', 'L', 1),

(now(), now(), 28, 0, '전혀 그렇지 않다', 'W', 1),
(now(), now(), 28, 1, '그렇지 않다.', 'W', 0.5),
(now(), now(), 28, 2, '보통이다', 'W', 0),
(now(), now(), 28, 3, '그렇다', 'L', 0.5),
(now(), now(), 28, 4, '매우 그렇다', 'L', 1),

(now(), now(), 29, 0, '전혀 그렇지 않다', 'W', 1),
(now(), now(), 29, 1, '그렇지 않다.', 'W', 0.5),
(now(), now(), 29, 2, '보통이다', 'W', 0),
(now(), now(), 29, 3, '그렇다', 'L', 0.5),
(now(), now(), 29, 4, '매우 그렇다', 'L', 1),

(now(), now(), 30, 0, '프론트엔드', 'J', 0),
(now(), now(), 30, 1, '백엔드', 'J', 0),
(now(), now(), 31, 0, '0 ~ 1년', 'Y', 0),
(now(), now(), 31, 1, '1 ~ 3년', 'Y', 0),
(now(), now(), 31, 2, '4년 이상', 'Y', 0);

INSERT INTO review (review_type, headline, title, contents) VALUES
('VSPL', '열정적인 꿈을 가진 당신은 야망가 VSPL', '당신은 VSPL', '열정적인 꿈을 가진 당신은 VSPL'),
('VSPW', '열정적인 꿈을 가진 당신은 야망가 VSPW', '당신은 VSPW', '열정적인 꿈을 가진 당신은 VSPW'),
('VSTL', '열정적인 꿈을 가진 당신은 야망가 VSTL', '당신은 VSTL', '열정적인 꿈을 가진 당신은 VSTL'),
('VSTW', '열정적인 꿈을 가진 당신은 야망가 VSTW', '당신은 VSTW', '열정적인 꿈을 가진 당신은 VSTW'),
('VCPL', '열정적인 꿈을 가진 당신은 야망가 VCPL', '당신은 VCPL', '열정적인 꿈을 가진 당신은 VCPL'),
('VCPW', '열정적인 꿈을 가진 당신은 야망가 VCPW', '당신은 VCPW', '열정적인 꿈을 가진 당신은 VCPW'),
('VCTL', '열정적인 꿈을 가진 당신은 야망가 VCTL', '당신은 VCTL', '열정적인 꿈을 가진 당신은 VCTL'),
('VCTW', '열정적인 꿈을 가진 당신은 야망가 VCTW', '당신은 VCTW', '열정적인 꿈을 가진 당신은 VCTW'),
('ASPL', '열정적인 꿈을 가진 당신은 야망가 ASPL', '당신은 ASPL', '열정적인 꿈을 가진 당신은 ASPL'),
('ASPW', '열정적인 꿈을 가진 당신은 야망가 ASPW', '당신은 ASPW', '열정적인 꿈을 가진 당신은 ASPW'),
('ASTL', '열정적인 꿈을 가진 당신은 야망가 ASTL', '당신은 ASTL', '열정적인 꿈을 가진 당신은 ASTL'),
('ASTW', '열정적인 꿈을 가진 당신은 야망가 ASTW', '당신은 ASTW', '열정적인 꿈을 가진 당신은 ASTW'),
('ACPL', '열정적인 꿈을 가진 당신은 야망가 ACPL', '당신은 ACPL', '열정적인 꿈을 가진 당신은 ACPL'),
('ACPW', '열정적인 꿈을 가진 당신은 야망가 ACPW', '당신은 ACPW', '열정적인 꿈을 가진 당신은 ACPW'),
('ACTL', '열정적인 꿈을 가진 당신은 야망가 ACTL', '당신은 ACTL', '열정적인 꿈을 가진 당신은 ACTL'),
('ACTW', '열정적인 꿈을 가진 당신은 야망가 ACTW', '당신은 ACTW', '열정적인 꿈을 가진 당신은 ACTW'),
('VF', '', '시각화 성향의 프론트 개발자', '비쥬얼뿜뿜! 프론트 개발자 중에서도 시각화 능력이 강하시네요.'),
('VB', '', '시각화 성향의 백엔드 개발자', '내부 로직이 중요한 백엔드 개발자면서도 시각화에 강점이 있어요. 대단하신데요?'),
('AF', '', '설계 성향의 프론트 개발자', '유저와 맞닿은 UI/UX를 중요시 여기면서 내부 설계에도 강점이 있어요. 대단하신데요?'),
('AB', '', '설계 성향의 백엔드 개발자', '로지컬 띵킹을 잘하는 그대... 백엔드 개발자 중에서도 더 딥다이브하실 능력이 충만하십니다.'),
('S1', '', '신생 스타트업 스타일', '자유로운 영혼이면서도 리드하며 개발하는걸 즐기는 그대. 갓 창업해서 기여할 게 수두룩한 스타트업이 어울려요. 어쩌면 창업도..?'),
('S2', '', '중견 스타트업 스타일', '갓 창업한 스타트업보다는 조금씩 성장해나가는 50~200명규모 스타트업이 어울려요. '),
('C1', '', '유니콘 스타트업 스타일', '어느정도 체계가 잡힌걸 선호하지만, 그래도 너무 딱딱한 회사에 가고 싶지 않아요.'),
('C2', '', 'IT 대기업 스타일', '개발을 사랑하더라도 체계가 잡힌걸 선호하는 당신에겐 탄탄한 IT대기업이 어울려요(N사, K사, G사 등).'),
('P', '', '개발은 내가 만들고 싶은걸 만드는 수단!', '개발 그 자체도 좋아하지만, 이를 사용해서 무언가를 만들어낼 때 더 희열을 느낍니다. 비즈니스나 디자인 관점에서 이야기하는것도 즐깁니다. 나중에 창업을 하셔도 잘 하실거예요.'),
('T', '', '개발 is my life!', '서비스도 서비스지만, 개발 그 자체에 매력을 많이 느낍니다. 기술을 깊이 팔 수 있는 집중력과 열정이 있으며, 추후에 개발 구루가 될 조짐이 보이시는군요.'),
('W', '', '개발 말고도 인생엔 소중한게 많아!', '인생에서 자신을 더 많이 사랑하는 당신! 일 할땐 일 하고 쉴땐 후회없이 푹 쉬고 싶어합니다. 쉬는 시간엔 업무 관련된 모든일은 OFF합니다. 그래야 다음 스케줄을 효과적으로 소화할 수 있습니다!'),
('L', '', '일 할때 행복해요', '일을 사랑하는 당신, 주어진 업무에 매사 최선을 다하고 싶어합니다. 목표설정에 따른 행동이 주체적인 사람입니다. 계획에 따라 성과가 최대치 일때 일에 대한 만족감을 얻고 능률이 오릅니다.');

