INSERT INTO CREATOR(ID, LAST_NAME, FIRST_NAME)
VALUES (1, 'Lamotte', 'Edouard');
INSERT INTO CREATOR(ID, LAST_NAME, FIRST_NAME)
VALUES (2, 'Cucchietti', 'Thomas');
INSERT INTO CREATOR(ID, LAST_NAME, FIRST_NAME)
VALUES (3, 'Pilato', 'David');
INSERT INTO CREATOR(ID, LAST_NAME, FIRST_NAME)
VALUES (4, 'Lamottee', 'Edouardd');

INSERT INTO BREWERY(ID, NAME, TYPE, COUNTRY)
VALUES (1, 'Kronenbourg', 'INDUSTRIAL', 'France');
INSERT INTO BREWERY(ID, NAME, TYPE, COUNTRY)
VALUES (2, 'La Bière de la Rade', 'CRAFT', 'France');
INSERT INTO BREWERY(ID, NAME, TYPE, COUNTRY)
VALUES (3, 'Brasserie Castelain', 'INDUSTRIAL', 'France');
INSERT INTO BREWERY(ID, NAME, TYPE, COUNTRY)
VALUES (4, 'Carlsberg', 'INDUSTRIAL', 'Danemark');
INSERT INTO BREWERY(ID, NAME, TYPE, COUNTRY)
VALUES (5, 'Sainte-Cru', 'CRAFT', 'France');

INSERT INTO BEER(ID, NAME, BREWERY_ID, ALCOHOL_LEVEL, CREATOR_ID)
VALUES (1, '1664', 1, 5.5, 1);
INSERT INTO BEER(ID, NAME, BREWERY_ID, ALCOHOL_LEVEL, CREATOR_ID)
VALUES (2, 'Censurée', 2, 5.8, 2);
INSERT INTO BEER(ID, NAME, BREWERY_ID, ALCOHOL_LEVEL, CREATOR_ID)
VALUES (3, 'Ch''ti Blonde', 3, 6.4, 3);
INSERT INTO BEER(ID, NAME, BREWERY_ID, ALCOHOL_LEVEL, CREATOR_ID)
VALUES (4, 'Skoll', 1, 6.0, 1);
INSERT INTO BEER(ID, NAME, BREWERY_ID, ALCOHOL_LEVEL, CREATOR_ID)
VALUES (5, 'Tigre Bock', 1, 5.5, 1);
INSERT INTO BEER(ID, NAME, BREWERY_ID, ALCOHOL_LEVEL, CREATOR_ID)
VALUES (6, 'Carlsberg', 4, 5.7, 1);
INSERT INTO BEER(ID, NAME, BREWERY_ID, ALCOHOL_LEVEL, CREATOR_ID)
VALUES (7, 'Elephant 1959', 5, 7.2, 2);
INSERT INTO BEER(ID, NAME, BREWERY_ID, ALCOHOL_LEVEL, CREATOR_ID)
VALUES (8, 'Red is Dead', 5, 7.2, 2);
INSERT INTO BEER(ID, NAME, BREWERY_ID, ALCOHOL_LEVEL, CREATOR_ID)
VALUES (9, 'Apocalypse Now', 5, 8.0, 3);
INSERT INTO BEER(ID, NAME, BREWERY_ID, ALCOHOL_LEVEL, CREATOR_ID)
VALUES (10, 'Delicatessen', 5, 6.6, 3);
INSERT INTO BEER(ID, NAME, BREWERY_ID, ALCOHOL_LEVEL, CREATOR_ID)
VALUES (11, 'Delicatessen Bis', 5, 6.6, 4);
