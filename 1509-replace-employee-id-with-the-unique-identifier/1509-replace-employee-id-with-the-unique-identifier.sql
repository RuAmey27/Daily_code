# Write your MySQL query statement below
SELECT name,unique_id 
FROM Employees 
left JOIN EmployeeUNI ON Employees.id = EmployeeUNI.id;
