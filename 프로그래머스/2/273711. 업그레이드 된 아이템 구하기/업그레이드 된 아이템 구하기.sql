-- 코드를 작성해주세요

select ii.item_id, ii.item_name, ii.rarity from item_info ii inner join item_tree it on ii.item_id = it.item_id where it.parent_item_id In (select ii2.item_id from item_info ii2 where ii2.rarity='RARE') order by ii.item_id DESC;
