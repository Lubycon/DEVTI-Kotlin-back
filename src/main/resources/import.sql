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
(now(), now(), 'ROLE', 'Visualization vs Architecture', 'PRESET'),
(now(), now(), 'ROLE', 'Visualization vs Architecture', 'PRESET'),
(now(), now(), 'ROLE', 'Visualization vs Architecture', 'PRESET'),
(now(), now(), 'ROLE', 'Visualization vs Architecture', 'PRESET'),
(now(), now(), 'ROLE', 'Visualization vs Architecture', 'PRESET'),
(now(), now(), 'SCALE', 'Startup vs Corporation', 'PRESET'),
(now(), now(), 'SCALE', 'Startup vs Corporation', 'PRESET'),
(now(), now(), 'SCALE', 'Startup vs Corporation', 'PRESET'),
(now(), now(), 'SCALE', 'Startup vs Corporation', 'PRESET'),
(now(), now(), 'SCALE', 'Startup vs Corporation', 'PRESET'),
(now(), now(), 'INTEREST', 'Product vs Technology', 'PRESET'),
(now(), now(), 'INTEREST', 'Product vs Technology', 'PRESET'),
(now(), now(), 'INTEREST', 'Product vs Technology', 'PRESET'),
(now(), now(), 'INTEREST', 'Product vs Technology', 'PRESET'),
(now(), now(), 'INTEREST', 'Product vs Technology', 'PRESET'),
(now(), now(), 'PRIORITY', 'Work vs Life', 'PRESET'),
(now(), now(), 'PRIORITY', 'Work vs Life', 'PRESET'),
(now(), now(), 'PRIORITY', 'Work vs Life', 'PRESET'),
(now(), now(), 'PRIORITY', 'Work vs Life', 'PRESET'),
(now(), now(), 'PRIORITY', 'Work vs Life', 'PRESET'),
(now(), now(), 'ROLE', 'Visualization vs Architecture', 'GAGE'),
(now(), now(), 'ROLE', 'Visualization vs Architecture', 'GAGE'),
(now(), now(), 'ROLE', 'Visualization vs Architecture', 'GAGE'),
(now(), now(), 'ROLE', 'Visualization vs Architecture', 'GAGE'),
(now(), now(), 'ROLE', 'Visualization vs Architecture', 'GAGE'),
(now(), now(), 'SCALE', 'Startup vs Corporation', 'GAGE'),
(now(), now(), 'SCALE', 'Startup vs Corporation', 'GAGE'),
(now(), now(), 'SCALE', 'Startup vs Corporation', 'GAGE'),
(now(), now(), 'SCALE', 'Startup vs Corporation', 'GAGE'),
(now(), now(), 'SCALE', 'Startup vs Corporation', 'GAGE'),
(now(), now(), 'INTEREST', 'Product vs Technology', 'GAGE'),
(now(), now(), 'INTEREST', 'Product vs Technology', 'GAGE'),
(now(), now(), 'INTEREST', 'Product vs Technology', 'GAGE'),
(now(), now(), 'INTEREST', 'Product vs Technology', 'GAGE'),
(now(), now(), 'INTEREST', 'Product vs Technology', 'GAGE'),
(now(), now(), 'PRIORITY', 'Work vs Life', 'GAGE'),
(now(), now(), 'PRIORITY', 'Work vs Life', 'GAGE'),
(now(), now(), 'PRIORITY', 'Work vs Life', 'GAGE'),
(now(), now(), 'PRIORITY', 'Work vs Life', 'GAGE'),
(now(), now(), 'PRIORITY', 'Work vs Life', 'GAGE'),
(now(), now(), 'REFERENCE', '현재 해당 직무에서 근무하신 기간이 어떻게 되나요?', 'INFO'),
(now(), now(), 'REFERENCE', '향후 희망하는 직무가 무엇이에요?', 'INFO');

INSERT INTO preset (created_at, updated_at, question_id, sequence, label, bias, weight) VALUES
(now(), now(), 1, 0, 'VVVVVV', 'V', 1),
(now(), now(), 1, 1, 'AAAAAA', 'A', 1),
(now(), now(), 2, 0, 'VVVVVV', 'V', 1),
(now(), now(), 2, 1, 'AAAAAA', 'A', 1),
(now(), now(), 3, 0, 'VVVVVV', 'V', 1),
(now(), now(), 3, 1, 'AAAAAA', 'A', 1),
(now(), now(), 4, 0, 'VVVVVV', 'V', 1),
(now(), now(), 4, 1, 'AAAAAA', 'A', 1),
(now(), now(), 5, 0, 'VVVVVV', 'V', 1),
(now(), now(), 5, 1, 'AAAAAA', 'A', 1),
(now(), now(), 6, 0, 'SSSSSS', 'S', 1),
(now(), now(), 6, 1, 'CCCCCC', 'C', 1),
(now(), now(), 7, 0, 'SSSSSS', 'S', 1),
(now(), now(), 7, 1, 'CCCCCC', 'C', 1),
(now(), now(), 8, 0, 'SSSSSS', 'S', 1),
(now(), now(), 8, 1, 'CCCCCC', 'C', 1),
(now(), now(), 9, 0, 'SSSSSS', 'S', 1),
(now(), now(), 9, 1, 'CCCCCC', 'C', 1),
(now(), now(), 10, 0, 'SSSSSS', 'S', 1),
(now(), now(), 10, 1, 'CCCCCC', 'C', 1),
(now(), now(), 11, 0, 'PPPPPP', 'P', 1),
(now(), now(), 11, 1, 'TTTTTT', 'T', 1),
(now(), now(), 12, 0, 'PPPPPP', 'P', 1),
(now(), now(), 12, 1, 'TTTTTT', 'T', 1),
(now(), now(), 13, 0, 'PPPPPP', 'P', 1),
(now(), now(), 13, 1, 'TTTTTT', 'T', 1),
(now(), now(), 14, 0, 'PPPPPP', 'P', 1),
(now(), now(), 14, 1, 'TTTTTT', 'T', 1),
(now(), now(), 15, 0, 'PPPPPP', 'P', 1),
(now(), now(), 15, 1, 'TTTTTT', 'T', 1),
(now(), now(), 16, 0, 'WWWWWW', 'W', 1),
(now(), now(), 16, 1, 'LLLLLL', 'L', 1),
(now(), now(), 17, 0, 'WWWWWW', 'W', 1),
(now(), now(), 17, 1, 'LLLLLL', 'L', 1),
(now(), now(), 18, 0, 'WWWWWW', 'W', 1),
(now(), now(), 18, 1, 'LLLLLL', 'L', 1),
(now(), now(), 19, 0, 'WWWWWW', 'W', 1),
(now(), now(), 19, 1, 'LLLLLL', 'L', 1),
(now(), now(), 20, 0, 'WWWWWW', 'W', 1),
(now(), now(), 20, 1, 'LLLLLL', 'L', 1),
(now(), now(), 21, 0, '', 'V', 1),
(now(), now(), 21, 1, '', 'V', 0.5),
(now(), now(), 21, 2, '', 'V', 0),
(now(), now(), 21, 3, '', 'A', 0.5),
(now(), now(), 21, 4, '', 'A', 1),
(now(), now(), 22, 0, '', 'V', 1),
(now(), now(), 22, 1, '', 'V', 0.5),
(now(), now(), 22, 2, '', 'A', 0),
(now(), now(), 22, 3, '', 'A', 0.5),
(now(), now(), 22, 4, '', 'A', 1),
(now(), now(), 23, 0, '', 'V', 1),
(now(), now(), 23, 1, '', 'V', 0.5),
(now(), now(), 23, 2, '', 'V', 0),
(now(), now(), 23, 3, '', 'A', 0.5),
(now(), now(), 23, 4, '', 'A', 1),
(now(), now(), 24, 0, '', 'V', 1),
(now(), now(), 24, 1, '', 'V', 0.5),
(now(), now(), 24, 2, '', 'V', 0),
(now(), now(), 24, 3, '', 'A', 0.5),
(now(), now(), 24, 4, '', 'A', 1),
(now(), now(), 25, 0, '', 'V', 1),
(now(), now(), 25, 1, '', 'V', 0.5),
(now(), now(), 25, 2, '', 'V', 0),
(now(), now(), 25, 3, '', 'A', 0.5),
(now(), now(), 25, 4, '', 'A', 1),
(now(), now(), 26, 0, '', 'S', 1),
(now(), now(), 26, 1, '', 'S', 0.5),
(now(), now(), 26, 2, '', 'C', 0),
(now(), now(), 26, 3, '', 'C', 0.5),
(now(), now(), 26, 4, '', 'C', 1),
(now(), now(), 27, 0, '', 'S', 1),
(now(), now(), 27, 1, '', 'S', 0.5),
(now(), now(), 27, 2, '', 'S', 0),
(now(), now(), 27, 3, '', 'C', 0.5),
(now(), now(), 27, 4, '', 'C', 1),
(now(), now(), 28, 0, '', 'S', 1),
(now(), now(), 28, 1, '', 'S', 0.5),
(now(), now(), 28, 2, '', 'S', 0),
(now(), now(), 28, 3, '', 'C', 0),
(now(), now(), 28, 4, '', 'C', 0.5),
(now(), now(), 28, 5, '', 'C', 1),
(now(), now(), 29, 0, '', 'S', 1),
(now(), now(), 29, 1, '', 'S', 0.5),
(now(), now(), 29, 2, '', 'S', 0),
(now(), now(), 29, 3, '', 'C', 0.5),
(now(), now(), 29, 4, '', 'C', 1),
(now(), now(), 30, 0, '', 'S', 1),
(now(), now(), 30, 1, '', 'S', 0.5),
(now(), now(), 30, 2, '', 'S', 0),
(now(), now(), 30, 3, '', 'C', 0.5),
(now(), now(), 30, 4, '', 'C', 1),
(now(), now(), 31, 0, '', 'P', 1),
(now(), now(), 31, 1, '', 'P', 0.5),
(now(), now(), 31, 2, '', 'P', 0),
(now(), now(), 31, 3, '', 'T', 0.5),
(now(), now(), 31, 4, '', 'T', 1),
(now(), now(), 32, 0, '', 'P', 1),
(now(), now(), 32, 1, '', 'P', 0.5),
(now(), now(), 32, 2, '', 'P', 0),
(now(), now(), 32, 3, '', 'T', 0.5),
(now(), now(), 32, 4, '', 'T', 1),
(now(), now(), 33, 0, '', 'P', 1),
(now(), now(), 33, 1, '', 'P', 0.5),
(now(), now(), 33, 2, '', 'P', 0),
(now(), now(), 33, 3, '', 'T', 0.5),
(now(), now(), 33, 4, '', 'T', 1),
(now(), now(), 34, 0, '', 'P', 1),
(now(), now(), 34, 1, '', 'P', 0.5),
(now(), now(), 34, 2, '', 'P', 0),
(now(), now(), 34, 3, '', 'T', 0.5),
(now(), now(), 34, 4, '', 'T', 1),
(now(), now(), 35, 0, '', 'P', 1),
(now(), now(), 35, 1, '', 'P', 0.5),
(now(), now(), 35, 2, '', 'P', 0),
(now(), now(), 35, 3, '', 'T', 0.5),
(now(), now(), 35, 4, '', 'T', 1),
(now(), now(), 36, 0, '', 'W', 1),
(now(), now(), 36, 1, '', 'W', 0.5),
(now(), now(), 36, 2, '', 'W', 0),
(now(), now(), 36, 3, '', 'L', 0.5),
(now(), now(), 36, 4, '', 'L', 1),
(now(), now(), 37, 0, '', 'W', 1),
(now(), now(), 37, 1, '', 'W', 0.5),
(now(), now(), 37, 2, '', 'W', 0),
(now(), now(), 37, 3, '', 'L', 0.5),
(now(), now(), 37, 4, '', 'L', 1),
(now(), now(), 38, 0, '', 'W', 1),
(now(), now(), 38, 1, '', 'W', 0.5),
(now(), now(), 38, 2, '', 'W', 0),
(now(), now(), 38, 3, '', 'L', 0.5),
(now(), now(), 38, 4, '', 'L', 1),
(now(), now(), 39, 0, '', 'W', 1),
(now(), now(), 39, 1, '', 'W', 0.5),
(now(), now(), 39, 2, '', 'W', 0),
(now(), now(), 39, 3, '', 'L', 0.5),
(now(), now(), 39, 4, '', 'L', 1),
(now(), now(), 40, 0, '', 'W', 1),
(now(), now(), 40, 1, '', 'W', 0.5),
(now(), now(), 40, 2, '', 'W', 0),
(now(), now(), 40, 3, '', 'L', 0.5),
(now(), now(), 40, 4, '', 'L', 1),
(now(), now(), 41, 0, '프론트엔드', 'J', 0),
(now(), now(), 41, 1, '백엔드', 'J', 0),
(now(), now(), 42, 0, '0 ~ 1년', 'Y', 0),
(now(), now(), 42, 1, '1 ~ 3년', 'Y', 0),
(now(), now(), 42, 2, '4년 이상', 'Y', 0);

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

