package de.hsw.iban.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.hsw.iban.beans.IbanResponse;
import de.hsw.iban.repositories.IbanRepository;
import de.hsw.iban.utils.IbanUtil;

@Service
public class IbanService {
    private IbanRepository repository;

    @Autowired
    public IbanService(IbanRepository repository) {
        this.repository = repository;
    }

    /**
     * Ergebnis in der Datenbank speichern
     * @param request
     * @return
     */
    private IbanResponse saveResponse(IbanResponse request) {
        return repository.save(request);
    }

    /**
     * IBAN prüfen
     * @param iban
     * @return
     */
    public IbanResponse checkIban(String iban) {
        IbanResponse response = new IbanResponse();
        response.setIban(iban);
        response.setValid(IbanUtil.validate(iban));

        saveResponse(response);
        return response;
    }

    /**
     * IBAN anhand der Komponenten erstellen, validieren und zurückgeben
     * 
     * @param countryCode Ländercode
     * @param accountNumber Kontonummer
     * @param bankIdentification BLZ
     * @return
     */
    public IbanResponse createIban(String countryCode, String accountNumber, String bankIdentification) {
        IbanResponse response = new IbanResponse();
        response.setCountryCode(countryCode);
        response.setAccountNumber(accountNumber);
        response.setBankIdentification(bankIdentification);

        String iban = IbanUtil.create(countryCode, accountNumber, bankIdentification);

        response.setIban(iban);
        response.setValid(true);

        saveResponse(response);
        return response;
    }

    /**
     * Alle Responses ausgeben - als Beispiel für eine Auswertungsfunktion
     * @return
     */
    public List<IbanResponse> getAllResponses() {
        List<IbanResponse> responses = new ArrayList<>();

        repository.findAll().forEach(r -> responses.add(r));

        return responses;
    }

    /**
     * Alle validen IBANs ausgeben - als Beispiel für eine Auswertungsfunktion
     * @return
     */
    public List<String> getAllValidIbans() {
        List<String> responses = new ArrayList<>();

        repository.findAll().forEach(r -> {
            if (r.isValid()) {
                responses.add(r.getIban());
            }
        });

        return responses;
    }
}
