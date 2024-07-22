# Write your MySQL query statement below


SELECT  Product.product_name, Sales.year, Sales.price 
FROM Product ,Sales
WHERE Sales.product_id=Product.product_id;
