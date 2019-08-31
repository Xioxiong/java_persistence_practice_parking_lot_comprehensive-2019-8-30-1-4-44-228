/*CREATE TABLE employee (
  id VARCHAR(64)PRIMARY KEY,
  name VARCHAR(64) NOT NULL,
  age   int(4) NOT NULL
);*/
CREATE TABLE parkinglot (
  parkingLotID INTEGER PRIMARY KEY,
  capacity INTEGER NOT NULL,
  employeeId VARCHAR(64)
);
