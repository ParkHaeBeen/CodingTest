-- 코드를 입력하세요
select car_id,cr.car_type,floor(daily_fee*30*(100-DISCOUNT_RATE)/100) as FEE
from   CAR_RENTAL_COMPANY_CAR cr join CAR_RENTAL_COMPANY_DISCOUNT_PLAN cdp on cr.car_type=cdp.car_type
where car_id not in (SELECT CAR_ID
                    FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
                    WHERE END_DATE >= '2022-11-01' AND START_DATE <= '2022-11-30')
     and cr.car_type in ('세단','SUV') and duration_type like '%30%'
     and floor(daily_fee*30*(100-DISCOUNT_RATE)/100) between 500000 and 2000000
order by fee desc, car_type asc, car_id desc