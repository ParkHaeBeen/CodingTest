-- 코드를 입력하세요
SELECT PRODUCT_CODE, amount*price as SALES
from(SELECT PRODUCT_ID, SUM(SALES_AMOUNT) as amount
    from OFFLINE_SALE
    group by PRODUCT_ID) AA join PRODUCT p on AA.product_id=p.product_id
order by sales desc, product_code asc