-- 코드를 입력하세요
SELECT ai.Animal_id,ai.name
from Animal_ins ai join Animal_outs ao on ai.animal_id=ao.animal_id
where ai.datetime > ao.datetime
order by ai.datetime asc