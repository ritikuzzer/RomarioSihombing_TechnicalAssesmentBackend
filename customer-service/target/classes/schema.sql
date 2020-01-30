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


CREATE TABLE `loan` (
  `loanNumber` int(100) NOT NULL,
  `loanTypeCode` varchar(100) DEFAULT NULL,
  `ammount` decimal(65,0) DEFAULT NULL,
  `balance` decimal(65,0) DEFAULT NULL,
  `openDate` date DEFAULT NULL,
  `dueDate` date DEFAULT NULL,
  `tenor` int(100) DEFAULT NULL,
  `cif` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`loanNumber`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;



CREATE TABLE `loantype` (
  `loanTypeCode` varchar(100) NOT NULL,
  `loanTypeDesc` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`loanTypeCode`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
