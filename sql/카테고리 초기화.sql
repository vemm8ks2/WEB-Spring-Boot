INSERT INTO category(id, level, name, parent_category_id) VALUES('1', 0, '신발', null);
INSERT INTO category(id, level, name, parent_category_id) VALUES('2', 0, '아우터', null);
INSERT INTO category(id, level, name, parent_category_id) VALUES('3', 0, '상의', null);
INSERT INTO category(id, level, name, parent_category_id) VALUES('4', 0, '하의', null);

INSERT INTO category(id, level, name, parent_category_id) VALUES('1-1', 1, '스니커즈', '1');
INSERT INTO category(id, level, name, parent_category_id) VALUES('1-2', 1, '구두', '1');
INSERT INTO category(id, level, name, parent_category_id) VALUES('1-3', 1, '부츠/워커', '1');

INSERT INTO category(id, level, name, parent_category_id) VALUES('2-1', 1, '후드 집업', '2');
INSERT INTO category(id, level, name, parent_category_id) VALUES('2-2', 1, '블루종/MA-1', '2');
INSERT INTO category(id, level, name, parent_category_id) VALUES('2-3', 1, '무스탕/퍼', '2');
INSERT INTO category(id, level, name, parent_category_id) VALUES('2-4', 1, '숏패딩/헤비 아우터', '2');

INSERT INTO category(id, level, name, parent_category_id) VALUES('3-1', 1, '맨투맨/스웨트', '3');
INSERT INTO category(id, level, name, parent_category_id) VALUES('3-2', 1, '후드 티셔츠', '3');
INSERT INTO category(id, level, name, parent_category_id) VALUES('3-3', 1, '니트/스웨터', '3');

INSERT INTO category(id, level, name, parent_category_id) VALUES('4-1', 1, '데님 팬츠', '4');
INSERT INTO category(id, level, name, parent_category_id) VALUES('4-2', 1, '슈트 팬츠/슬랙스', '4');
INSERT INTO category(id, level, name, parent_category_id) VALUES('4-3', 1, '트레이닝/조거 팬츠', '4');
INSERT INTO category(id, level, name, parent_category_id) VALUES('4-4', 1, '레깅스', '4');

INSERT INTO category(id, level, name, parent_category_id) VALUES('1-1-1', 2, '캔버스/단화', '1-1');
INSERT INTO category(id, level, name, parent_category_id) VALUES('1-1-2', 2, '슬립온', '1-1');
INSERT INTO category(id, level, name, parent_category_id) VALUES('1-1-3', 2, '기타 스니커즈', '1-1');

INSERT INTO category(id, level, name, parent_category_id) VALUES('1-2-1', 2, '모카신', '1-2');
INSERT INTO category(id, level, name, parent_category_id) VALUES('1-2-2', 2, '로퍼', '1-2');

INSERT INTO category(id, level, name, parent_category_id) VALUES('1-3-1', 2, '롱 부츠', '1-3');
INSERT INTO category(id, level, name, parent_category_id) VALUES('1-3-2', 2, '워커', '1-3');