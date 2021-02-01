create table T_IBAN_RESPONSE (
    ID integer identity primary key, 
    COUNTRY_CODE varchar(2),
    CHECKSUM varchar(2),
    BANK_IDENTIFICATION varchar(8),
    ACCOUNT_NUMBER varchar(10),
    IBAN varchar(22),
    VALID integer
);
