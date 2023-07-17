select AA.author_id,author_name,AA.category,AA.total_sales
from(select sum(price*sales) as total_sales ,category, author_id
    from book b join book_sales s on b.book_id=s.book_id
    where sales_date like "2022-01%"
    group by author_id, category) AA join author a on AA.author_id=a.author_id
order by AA.author_id asc, category desc
