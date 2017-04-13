-- https://www.hackerrank.com/challenges/interviews

/*
Enter your query here.
Please append a semicolon ";" at the end of the query and enter your query in a single line to avoid error.
*/
/*contest_id, hacker_id, name, and the sums of total_submissions, total_accepted_submissions, total_views, and total_unique_views*/

with
    submission_totals as (
      select challenge_id, sum(total_submissions) as total_submissions, sum(total_accepted_submissions) as total_accepted_submissions
      from submission_stats
      group by challenge_id
  ),
    view_totals as (
      select challenge_id, sum(total_views) as total_views, sum(total_unique_views) as total_unique_views
      from view_stats
      group by challenge_id
  )
select
  ct.contest_id,
  ct.hacker_id,
  ct.name,
  sum(st.total_submissions),
  sum(st.total_accepted_submissions),
  sum(vt.total_views),
  sum(vt.total_unique_views)
from contests ct, colleges cl, challenges ch, submission_totals st, view_totals vt
where ct.contest_id = cl.contest_id
      and cl.college_id = ch.college_id
      and ch.challenge_id = st.challenge_id(+)
      and ch.challenge_id = vt.challenge_id(+)
group by ct.contest_id, ct.hacker_id, ct.name
order by ct.contest_id;
