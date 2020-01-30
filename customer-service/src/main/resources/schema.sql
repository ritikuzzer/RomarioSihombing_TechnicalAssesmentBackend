CREATE TABLE `containeraccount` (
  `containerAccount` varchar(100) NOT NULL,
  `balance` decimal(65,0) DEFAULT NULL,
  `cif` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`containerAccount`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


CREATE TABLE `customer` (
  `cif` varchar(100) NOT NULL,
  `firstname` varchar(100) DEFAULT NULL,
  `lastname` varchar(100) DEFAULT NULL,
  `address` varchar(100) DEFAULT NULL,
  `birth_date` date DEFAULT NULL,
  `birth_place` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`cif`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

