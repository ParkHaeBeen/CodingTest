-- 코드를 입력하세요
SELECT car_id,ROUND(AVG(DATEDIFF(DATE_FORMAT(end_date,'%Y-%m-%d'),DATE_FORMAT(start_date,'%Y-%m-%d'))+1),1) as AVERAGE_DURATION
from CAR_RENTAL_COMPANY_RENTAL_HISTORY
group by car_id
having AVERAGE_DURATION>=7
order by AVERAGE_DURATION desc, car_id desc