SELECT IFNULL(
    (SELECT MAX(salary)
     FROM Employee
     WHERE salary < (SELECT MAX(salary) FROM Employee)),
    NULL) AS SecondHighestSalary;


