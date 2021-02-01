package de.hsw.iban.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="T_IBAN_RESPONSE")
public class IbanResponse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private String countryCode;

    @Column
    private String checksum;

    @Column
    private String bankIdentification;

    @Column
    private String accountNumber;

    @Column
    private String iban;

    @Column
    private boolean valid;

    public IbanResponse() {}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getChecksum() {
        return checksum;
    }

    public void setChecksum(String checksum) {
        this.checksum = checksum;
    }

    public String getBankIdentification() {
        return bankIdentification;
    }

    public void setBankIdentification(String bankIdentification) {
        this.bankIdentification = bankIdentification;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public boolean isValid() {
        return valid;
    }

    public void setValid(boolean valid) {
        this.valid = valid;
    }

    @Override
    public String toString() {
        return "IbanResponse [accountNumber=" + accountNumber + ", bankIdentification=" + bankIdentification
                + ", checksum=" + checksum + ", countryCode=" + countryCode + ", iban=" + iban + ", id=" + id
                + ", valid=" + valid + "]";
    }
}
