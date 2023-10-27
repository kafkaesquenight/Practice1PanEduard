INSERT INTO player (player_id, player_nickname, first_name, last_name, player_team_id)
VALUES
    (1, 's1mple', 'Oleksandr', 'Kostyliev', 1),
    (1, 'electronic', 'Denis', 'Sharipov', 1),
    (1, 'Boombl4', 'Egor', 'Vasilyev', 1),
    (1, 'flamie', 'Egor', 'Vasilev', 1),
    (1, 'B1T', 'Egor', 'Vasilev', 1);
INSERT INTO team (team_id, team_name)
VALUES
    (1, 'Astralis'),
    (2, 'Natus Vincere'),
    (3, 'Vitality'),
    (4, 'G2 Esports'),
    (5, 'Team Liquid');
INSERT INTO event (event_id, event_name, event_date)
VALUES
    (1, 'ELEAGUE Major: Atlanta 2017', '2017-01-22'),
    (2, 'PGL Major Kraków 2017', '2017-07-16'),
    (3, 'ELEAGUE Major: Boston 2018', '2018-01-12'),
    (4, 'FACEIT Major: London 2018', '2018-09-05'),
    (5, 'IEM Katowice 2019', '2019-02-14');
INSERT INTO event_place (event_place_id, name, country, city)
VALUES
    (1, 'Fox Theatre', 'United States', 'Atlanta'),
    (2, 'TAURON Arena Kraków', 'Poland', 'Kraków'),
    (3, 'Agganis Arena', 'United States', 'Boston'),
    (4, 'Wembley Arena', 'United Kingdom', 'London'),
    (5, 'Spodek Arena', 'Poland', 'Katowice');
