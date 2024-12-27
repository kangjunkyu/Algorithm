-- 코드를 작성해주세요
select 
    case
        when month(differentiation_date) IN ('1', '2', '3') then '1Q'
        when month(differentiation_date) IN ('4', '5', '6') then '2Q'
        when month(differentiation_date) IN ('7', '8', '9') then '3Q'
        when month(differentiation_date) IN ('10', '11', '12') then '4Q'
    end
    as QUARTER,
    count(id) as ECOLI_COUNT
        from ecoli_data
        group by QUARTER
        order by QUARTER;