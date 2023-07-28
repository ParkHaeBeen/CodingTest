-- 코드를 입력하세요
SELECT AI.ANIMAL_ID, AI.ANIMAL_TYPE, AI.NAME
FROM ANIMAL_INS AI join ANIMAL_OUTS AO on AI.ANIMAL_ID=AO.ANIMAL_ID
where SEX_UPON_INTAKE like "Intact%" 
and SEX_UPON_OUTCOME in ("Neutered Male","Spayed Female")
order by AI.animal_id