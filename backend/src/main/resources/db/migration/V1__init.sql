create sequence public.hibernate_sequence;

CREATE TABLE team
(
    id   BIGSERIAL   NOT NULL PRIMARY KEY,
    name VARCHAR(45) NOT NULL UNIQUE
);

CREATE TABLE player
(
    id       BIGSERIAL   NOT NULL PRIMARY KEY,
    username VARCHAR(45) NOT NULL UNIQUE,
    team_id  BIGINT,
    uid      VARCHAR(100), /* format of uid? */
    CONSTRAINT fk_team FOREIGN KEY (team_id) REFERENCES team (id)
);

CREATE TABLE game
(
    id             BIGSERIAL NOT NULL PRIMARY KEY,
    start_time     TIMESTAMP,
    end_time       TIMESTAMP,
    team1_id       BIGINT,
    team2_id       BIGINT,
    team1_score    INT,
    team2_score    INT,
    round_end_time TIMESTAMP,
    CONSTRAINT fk_team1 FOREIGN KEY (team1_id) REFERENCES team (id),
    CONSTRAINT fk_team2 FOREIGN KEY (team2_id) REFERENCES team (id)
);

CREATE TABLE option
(
    id          BIGSERIAL NOT NULL PRIMARY KEY,
    name        VARCHAR(45),
    possession  BOOLEAN,
    zone        INT,
    category    VARCHAR(45),
    duel        INT,
    pass        INT,
    shoot       INT,
    duel_def    INT,
    pass_def    INT,
    shoot_def   INT,
    risk        INT,
    win         VARCHAR(45), /*enum?*/
    win_chance  INT,
    loss        VARCHAR(45), /*enum?*/
    loss_chance INT,
    card_risk   INT
);

CREATE TABLE round
(
    id              BIGSERIAL NOT NULL PRIMARY KEY,
    game_id         BIGINT,
    round_number    INT,
    team1_option_id BIGINT,
    team2_option_id BIGINT,
    CONSTRAINT fk_game FOREIGN KEY (game_id) REFERENCES game (id),
    CONSTRAINT fk_team1_option FOREIGN KEY (team1_option_id) REFERENCES option (id),
    CONSTRAINT fk_team2_option FOREIGN KEY (team2_option_id) REFERENCES option (id)
);

CREATE TABLE counter_option
(
    id                BIGSERIAL NOT NULL PRIMARY KEY,
    option_id         BIGINT,
    counter_option_id BIGINT,
    CONSTRAINT fk_option FOREIGN KEY (option_id) REFERENCES option (id),
    CONSTRAINT fk_counter_option FOREIGN KEY (counter_option_id) REFERENCES option (id)
);