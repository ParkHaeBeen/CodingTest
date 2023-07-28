-- 코드를 입력하세요
SELECT DATE_FORMAT(SALES_DATE,"%Y") as YEAR, DATE_FORMAT(SALES_DATE,"%m") as MONTH
,count(distinct user_id) as PUCHASED_USERS,ROUND(count( distinct user_id)/allcount,1) as PUCHASED_RATIO
FROM ONLINE_SALE os join (select count(user_id) as allcount from user_info where joined like "2021%") AA
where user_id in (SELECT user_id
                  from user_info
                   where joined like "2021%")
GROUP BY DATE_FORMAT(SALES_DATE,"%Y"),DATE_FORMAT(SALES_DATE,"%m")
order by YEAR asc,MONTH asc

