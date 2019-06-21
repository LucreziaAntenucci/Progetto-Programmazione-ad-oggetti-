# Progetto-Programmazione-ad-oggetti-
# Descrizione progetto 
Il progetto si basa sulla creazione di una api rest.
In questo particolare software si prenderà in considerazione una collezione di dati presa dalla raccolta dati pubblica del governo italiano
("https://www.dati.gov.it/api/3/action/package_show?id=b28ae475-54f7-4c46-bea4-172387613dc4")contenente tutte le piccole imprese pugliesi 
con le loro statistiche(titolo progetto,costo complessivo,durata del progetto,contributo spese richiesto,...),
che poi verranno analizzate e rese disponibili sottoforma di file JSON.
Il software inoltre da la possibilità di eseguire dei filtri sulla risposta da ricevere; 
per utilizzare questa funzione basta semplicemente usare il metodo GET del protocollo HTTP.

# Funzionamento dell'applicazione-test
Una volta avviata l'applicazione, per verificare il funzionamento del programma si possono testare i seguenti link:
- http://localhost:8080/data      :restituisce tutti i dati
- http://localhost:8080/Metadata  :restituisce i metadati
- http://localhost:8080/occprov   :restituisce il numero delle imprese in provincia di Bari
- http://localhost:8080/alfa      :restituisce le imprese in ordine alfabetico
- http://localhost:8080/Avvio     :restituisce le imprese nate dopo una determinata data
- http://localhost:8080/Spese     :restituisce il contributo delle spese superiore ad un certo valore dato
- http://localhost:8080/Durata    :restituisce la durata del progetto

NOTA: per una visione migliore si consiglia di utilizzare un programma che simula richieste HTTP come POSTMAN

# Diagrammi
Diagramma dei casi d'uso
![Model Use Case diagram](https://user-images.githubusercontent.com/50574947/59927936-e2c52e80-943d-11e9-9d05-f33aa281be13.png)

Diagramma delle sequenze
![Interaction Sequence diagram](https://user-images.githubusercontent.com/50574947/59928142-60893a00-943e-11e9-8d52-f2d3ea47aa3c.png)
