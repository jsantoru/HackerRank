-- https://www.hackerrank.com/challenges/what-type-of-triangle
/*
Enter your query here.
Please append a semicolon ";" at the end of the query and enter your query in a single line to avoid error.
*/

select
  case
  when A = B and B = C then 'Equilateral'
  when (A + B <= C) or (A + C <= B) or (B + C <= A) then 'Not A Triangle'
  when (A = B and B < C) or (B = C and B < A) or (A = C and C < B) then 'Isosceles'
  when A != B and B != C then 'Scalene'
  end
from triangles;
