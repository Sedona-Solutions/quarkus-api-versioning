INSERT INTO CREATOR(ID, LAST_NAME, FIRST_NAME)
VALUES (1, 'Lamotte', 'Edouard');
INSERT INTO CREATOR(ID, LAST_NAME, FIRST_NAME)
VALUES (2, 'Cucchietti', 'Thomas');
INSERT INTO CREATOR(ID, LAST_NAME, FIRST_NAME)
VALUES (3, 'Pilato', 'David');
INSERT INTO CREATOR(ID, LAST_NAME, FIRST_NAME)
VALUES (4, 'Lamottee', 'Edouardd');

INSERT INTO BREWERY(NAME, TYPE, COUNTRY)
VALUES ('Kronenbourg', 'INDUSTRIAL', 'France');
INSERT INTO BREWERY(NAME, TYPE, COUNTRY)
VALUES ('La Bière de la Rade', 'CRAFT', 'France');
INSERT INTO BREWERY(NAME, TYPE, COUNTRY)
VALUES ('Brasserie Castelain', 'INDUSTRIAL', 'France');
INSERT INTO BREWERY(NAME, TYPE, COUNTRY)
VALUES ('Carlsberg', 'INDUSTRIAL', 'Danemark');
INSERT INTO BREWERY(NAME, TYPE, COUNTRY)
VALUES ('Sainte-Cru', 'CRAFT', 'France');

INSERT INTO BEER(NAME, BREWERY_ID, ALCOHOL_LEVEL, CREATOR_ID)
VALUES ('1664', 1, 5.5, 1);
INSERT INTO BEER(NAME, BREWERY_ID, ALCOHOL_LEVEL, CREATOR_ID)
VALUES ('Censurée', 2, 5.8, 2);
INSERT INTO BEER(NAME, BREWERY_ID, ALCOHOL_LEVEL, CREATOR_ID)
VALUES ('Ch''ti Blonde', 3, 6.4, 3);
INSERT INTO BEER(NAME, BREWERY_ID, ALCOHOL_LEVEL, CREATOR_ID)
VALUES ('Skoll', 1, 6.0, 1);
INSERT INTO BEER(NAME, BREWERY_ID, ALCOHOL_LEVEL, CREATOR_ID)
VALUES ('Tigre Bock', 1, 5.5, 1);
INSERT INTO BEER(NAME, BREWERY_ID, ALCOHOL_LEVEL, CREATOR_ID)
VALUES ('Carlsberg', 4, 5.7, 1);
INSERT INTO BEER(NAME, BREWERY_ID, ALCOHOL_LEVEL, CREATOR_ID)
VALUES ('Elephant 1959', 5, 7.2, 2);
INSERT INTO BEER(NAME, BREWERY_ID, ALCOHOL_LEVEL, CREATOR_ID)
VALUES ('Red is Dead', 5, 7.2, 2);
INSERT INTO BEER(NAME, BREWERY_ID, ALCOHOL_LEVEL, CREATOR_ID)
VALUES ('Apocalypse Now', 5, 8.0, 3);
INSERT INTO BEER(NAME, BREWERY_ID, ALCOHOL_LEVEL, CREATOR_ID)
VALUES ('Delicatessen', 5, 6.6, 3);
INSERT INTO BEER(NAME, BREWERY_ID, ALCOHOL_LEVEL, CREATOR_ID)
VALUES ('Delicatessen Bis', 5, 6.6, 4);

INSERT INTO BEER_INGREDIENTS(BEER_ID, INGREDIENTS)
VALUES (1, 'Eau');
INSERT INTO BEER_INGREDIENTS(BEER_ID, INGREDIENTS)
VALUES (1, 'Malt d''orge');
INSERT INTO BEER_INGREDIENTS(BEER_ID, INGREDIENTS)
VALUES (1, 'Sirop de glucose');
INSERT INTO BEER_INGREDIENTS(BEER_ID, INGREDIENTS)
VALUES (1, 'Blé');
INSERT INTO BEER_INGREDIENTS(BEER_ID, INGREDIENTS)
VALUES (1, 'Malt de blé');
INSERT INTO BEER_INGREDIENTS(BEER_ID, INGREDIENTS)
VALUES (1, 'Extrait de houblon');
INSERT INTO BEER_INGREDIENTS(BEER_ID, INGREDIENTS)
VALUES (1, 'Sulfates');
INSERT INTO BEER_INGREDIENTS(BEER_ID, INGREDIENTS)
VALUES (3, 'Eau');
INSERT INTO BEER_INGREDIENTS(BEER_ID, INGREDIENTS)
VALUES (3, 'Malts d''orge');
INSERT INTO BEER_INGREDIENTS(BEER_ID, INGREDIENTS)
VALUES (3, 'Sucre');
INSERT INTO BEER_INGREDIENTS(BEER_ID, INGREDIENTS)
VALUES (3, 'Malts de blé');
INSERT INTO BEER_INGREDIENTS(BEER_ID, INGREDIENTS)
VALUES (3, 'Houblon');
INSERT INTO BEER_INGREDIENTS(BEER_ID, INGREDIENTS)
VALUES (4, 'Eau');
INSERT INTO BEER_INGREDIENTS(BEER_ID, INGREDIENTS)
VALUES (4, 'Sucre');
INSERT INTO BEER_INGREDIENTS(BEER_ID, INGREDIENTS)
VALUES (4, 'Arôme');
INSERT INTO BEER_INGREDIENTS(BEER_ID, INGREDIENTS)
VALUES (4, 'Acide citrique (E330)');
INSERT INTO BEER_INGREDIENTS(BEER_ID, INGREDIENTS)
VALUES (4, 'Ecorce d''orange douce');
INSERT INTO BEER_INGREDIENTS(BEER_ID, INGREDIENTS)
VALUES (4, 'Coriandre');
INSERT INTO BEER_INGREDIENTS(BEER_ID, INGREDIENTS)
VALUES (4, 'Malt d''orge');
INSERT INTO BEER_INGREDIENTS(BEER_ID, INGREDIENTS)
VALUES (4, 'Sirop de glucose');
INSERT INTO BEER_INGREDIENTS(BEER_ID, INGREDIENTS)
VALUES (4, 'Extrait de houblon');
INSERT INTO BEER_INGREDIENTS(BEER_ID, INGREDIENTS)
VALUES (5, 'Malt d''orge');
INSERT INTO BEER_INGREDIENTS(BEER_ID, INGREDIENTS)
VALUES (5, 'Sulfites');
INSERT INTO BEER_INGREDIENTS(BEER_ID, INGREDIENTS)
VALUES (6, 'Eau');
INSERT INTO BEER_INGREDIENTS(BEER_ID, INGREDIENTS)
VALUES (6, 'Malt d''orge');
INSERT INTO BEER_INGREDIENTS(BEER_ID, INGREDIENTS)
VALUES (6, 'Extrait de houblon');
INSERT INTO BEER_INGREDIENTS(BEER_ID, INGREDIENTS)
VALUES (7, 'Eau');
INSERT INTO BEER_INGREDIENTS(BEER_ID, INGREDIENTS)
VALUES (7, 'Malt d''orge');
INSERT INTO BEER_INGREDIENTS(BEER_ID, INGREDIENTS)
VALUES (7, 'Extrait de houblon');
INSERT INTO BEER_INGREDIENTS(BEER_ID, INGREDIENTS)
VALUES (7, 'Sulfites');
INSERT INTO BEER_INGREDIENTS(BEER_ID, INGREDIENTS)
VALUES (8, 'Eau');
INSERT INTO BEER_INGREDIENTS(BEER_ID, INGREDIENTS)
VALUES (8, 'Malt d''orge');
INSERT INTO BEER_INGREDIENTS(BEER_ID, INGREDIENTS)
VALUES (8, 'Malt de blé');
INSERT INTO BEER_INGREDIENTS(BEER_ID, INGREDIENTS)
VALUES (8, 'Houblons');
INSERT INTO BEER_INGREDIENTS(BEER_ID, INGREDIENTS)
VALUES (9, 'Eau');
INSERT INTO BEER_INGREDIENTS(BEER_ID, INGREDIENTS)
VALUES (9, 'Malt d''orge');
INSERT INTO BEER_INGREDIENTS(BEER_ID, INGREDIENTS)
VALUES (9, 'Malt de blé');
INSERT INTO BEER_INGREDIENTS(BEER_ID, INGREDIENTS)
VALUES (9, 'Houblons');
INSERT INTO BEER_INGREDIENTS(BEER_ID, INGREDIENTS)
VALUES (10, 'Eau');
INSERT INTO BEER_INGREDIENTS(BEER_ID, INGREDIENTS)
VALUES (10, 'Malt d''orge');
INSERT INTO BEER_INGREDIENTS(BEER_ID, INGREDIENTS)
VALUES (10, 'Malt de blé');
INSERT INTO BEER_INGREDIENTS(BEER_ID, INGREDIENTS)
VALUES (10, 'Houblons');
