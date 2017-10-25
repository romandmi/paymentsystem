-- REMEMBER SUBSTRING(MD5(RAND()) FROM 1 FOR 12)

DELIMITER $$
DROP PROCEDURE IF EXISTS `fill_db1`$$
CREATE PROCEDURE fill_db1()
BEGIN
	DECLARE i INT;
	DECLARE j INT;
	DECLARE cards_counter INT;
	DECLARE bug_fixer INT; 		-- FIX ME

	DECLARE mylog VARCHAR(6);
	DECLARE mypass VARCHAR(6);

	DECLARE first_n VARCHAR(10);
	DECLARE last_n VARCHAR(12);
	DECLARE sur_n VARCHAR(14);

	DECLARE my_balance INT;

	SET i = 1;
	SET bug_fixer = i;
	SET cards_counter = 0;
	WHILE i < 5 DO

		SET mylog = SUBSTRING(MD5(RAND()) FROM 1 FOR 6);
		SET mypass = SUBSTRING(MD5(RAND()) FROM 1 FOR 6);
		INSERT INTO users
			(id, is_admin, login, password)	
		VALUES
			( i, FLOOR(RAND()*2), mylog, mypass );


		SET first_n = SUBSTRING(MD5(RAND()) FROM 1 FOR 10);
		SET last_n = SUBSTRING(MD5(RAND()) FROM 1 FOR 12);
		SET sur_n = SUBSTRING(MD5(RAND()) FROM 1 FOR 14);
		INSERT INTO clients
			(id, first_name, last_name, surname, user_id)
		VALUES
			(i, first_n, last_n, sur_n, i);
		
		
		SET j = 3 + FLOOR(RAND()*5);
		WHILE cards_counter < j DO
			SET my_balance = FLOOR(RAND()*100);
			INSERT INTO bank_account
				(id, balance, is_blocked)
			VALUES
				(bug_fixer+cards_counter, my_balance, FLOOR(RAND()*2));
			

			INSERT INTO cards
				(id, card_number, account_id, client_id)
			VALUES
				(bug_fixer+cards_counter, CONCAT(CONCAT(i,'000'), SUBSTRING(MD5(RAND()) FROM 1 FOR 12)), 
				bug_fixer+cards_counter, i);

			SET cards_counter = cards_counter + 1;
		END WHILE;	

		SET cards_counter = 0;
		SET i = i + 1;
		SET bug_fixer = bug_fixer + j;

	END WHILE;
END$$
DELIMITER ;

CALL fill_db1();