-- 코드를 입력하세요
select AA.category, AA.max_price, BB.product_name
from(select category,max(price) as max_price
from food_product
where category in('과자','국','김치','식용유')
group by category) AA join food_product BB on AA.max_price=BB.price and AA.category=BB.category
order by AA.max_price desc