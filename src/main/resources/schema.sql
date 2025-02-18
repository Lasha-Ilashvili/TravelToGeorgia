CREATE TABLE LOCATION
(
    ID          INTEGER PRIMARY KEY,
    NAME        VARCHAR(100) NOT NULL,
    DESCRIPTION TEXT,
    IMAGE_URL   VARCHAR(255),
    SEASON_ID   INTEGER,
    REGION_ID   INTEGER
);

CREATE TABLE "USER"
(
    ID       INTEGER PRIMARY KEY,
    USERNAME VARCHAR(50)  NOT NULL UNIQUE,
    EMAIL    VARCHAR(100) NOT NULL UNIQUE,
    PASSWORD VARCHAR(100) NOT NULL,
    ROLE     INTEGER NOT NULL
);

COMMIT;