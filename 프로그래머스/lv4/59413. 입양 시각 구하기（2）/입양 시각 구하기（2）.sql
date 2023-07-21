-- 코드를 입력하세요
with recursive  hour as(
    select 0 as rnum
    union all
    select rnum+1 from hour
    where rnum<=22
)
select rnum as HOUR, IFNULL(count,0) as COUNT from hour h left outer join 
(SELECT HOUR(A.DATETIME) as hour,count(distinct animal_id) as count
from animal_outs A
group by hour) A on h.rnum=A.hour

