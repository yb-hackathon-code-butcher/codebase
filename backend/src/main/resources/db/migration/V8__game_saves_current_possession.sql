ALTER TABLE game
    ADD COLUMN possession_team_id BIGINT,
    ADD CONSTRAINT fk_team3 FOREIGN KEY (possession_team_id) REFERENCES team (id);
