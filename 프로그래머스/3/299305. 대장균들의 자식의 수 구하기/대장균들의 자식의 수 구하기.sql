-- 코드를 작성해주세요

select
    ID,
    -- if null은 ()조건에 해당하는 값이 없다면 , 뒤의 값을 반환한다.
    IFNULL(
        (select
            count(*)
                from ECOLI_DATA
                group by PARENT_ID
                having
                    PARENT_ID = ID), 0
    ) as CHILD_COUNT
from ECOLI_DATA
order by id