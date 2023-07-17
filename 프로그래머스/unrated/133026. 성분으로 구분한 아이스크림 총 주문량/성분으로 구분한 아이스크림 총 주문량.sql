-- 코드를 입력하세요
SELECT INGREDIENT_TYPE,sum(TOTAL_ORDER) as TOTAL_ORDER
from first_half f join icecream_info i on f.flavor=i.flavor
group by INGREDIENT_TYPE
order by total_order asc