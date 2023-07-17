-- 코드를 입력하세요
select user_id,nickname,total_sales
from(SELECT writer_ID	, sum(price) as	TOTAL_SALES
from used_goods_board
where status='DONE'
group by writer_id
having sum(price)>=700000) AA join used_goods_user BB on AA.writer_id=BB.user_id
order by total_sales asc