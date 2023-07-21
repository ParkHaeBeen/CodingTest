-- 코드를 입력하세요
SELECT DATE_FORMAT(datetime,"%H") as HOUR, count(*) as COUNT
from ANIMAL_OUTS
where DATE_FORMAT(datetime,"%H") between 9 and 20
group by HOUR
order by HOUR