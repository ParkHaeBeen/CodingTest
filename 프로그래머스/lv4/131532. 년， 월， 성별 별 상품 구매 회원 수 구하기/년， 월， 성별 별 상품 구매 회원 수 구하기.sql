-- 코드를 입력하세요
SELECT YEAR(sales_date) as YEAR,MONTH(sales_date) as MONTH, gender, count(distinct A.user_id) as users
from Online_sale A join user_info u on A.user_id=u.user_id
where gender between 0 and 1
group by YEAR(sales_date),MONTH(sales_date),gender
order by YEAR(sales_date),MONTH(sales_date),gender

