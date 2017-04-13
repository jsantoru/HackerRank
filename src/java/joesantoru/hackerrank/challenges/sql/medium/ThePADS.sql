-- https://www.hackerrank.com/challenges/the-pads
/*
Enter your query here.
Please append a semicolon ";" at the end of the query and enter your query in a single line to avoid error.
*/
with names as (
    select name || '(' || substr(occupation,1,1) || ')' from occupations
),
    counts as (
      select occupation, count(*) as the_count from occupations group by occupation
)
select * from names
union
select 'There are total ' || the_count || ' ' || lower(occupation) || 's.' from counts;