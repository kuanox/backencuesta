CREATE TABLE style (
    id INTEGER NOT NULL AUTO_INCREMENT,
    style VARCHAR(128) NOT NULL,
    PRIMARY KEY (id)
);
CREATE TABLE survey (
   id INTEGER NOT NULL AUTO_INCREMENT,
   email VARCHAR(128) NOT NULL,
   style INTEGER,
   PRIMARY KEY (id)
);