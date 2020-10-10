INSERT INTO game(start_time, end_time, team1_id, team2_id, team1_score, team2_score, round_end_time)
VALUES
    (current_timestamp + (interval '1' minute), current_timestamp + (interval '10' minute),
    1,2,3,0, current_timestamp + (interval '80' second))