# 지우기 전에 꼭!!! 같은 WHERE SELECT 해보기
use w3schools;
SELECT *
FROM Employees
ORDER BY EmployeeID DESC;

DELETE
FROM Employees
WHERE Photo = 'null';