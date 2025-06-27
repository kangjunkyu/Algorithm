SELECT MCDP_CD as "진료과코드", count(PT_NO) as "5월예약건수" from APPOINTMENT where YEAR(APNT_YMD) = '2022' and MONTH(APNT_YMD) = '5' group by MCDP_CD order by count(PT_NO), MCDP_CD;
