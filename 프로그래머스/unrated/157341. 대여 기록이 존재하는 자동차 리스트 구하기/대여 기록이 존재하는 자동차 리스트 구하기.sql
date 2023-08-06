-- 코드를 입력하세요
SELECT cc.car_id
from CAR_RENTAL_COMPANY_CAR cc join 
   (select car_id,start_date from CAR_RENTAL_COMPANY_RENTAL_HISTORY) rh on cc.car_id=rh.car_id
where car_type='세단' and start_date like "2022-10%"
group by cc.car_id
order by car_id desc