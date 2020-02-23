SELECT
    chars.NAME NAME,
    COUNT(pur.ITEM) CNT
FROM CHARACTERS chars LEFT OUTER JOIN 
PURCHASES pur ON chars.NAME = pur.ITEM
GROUP BY chars.NAME;