-- 코드를 입력하세요
SELECT NAME, DATETIME from ANIMAL_INS where animal_id NOT IN (select animal_id from animal_outs) order by datetime limit 3;