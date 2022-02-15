# Corso ITT Fermi

## Aggiungere i launcher
Cliccare su _Run_ -> _Edit configurations_: dovreste già trovare la voce _Maven_ con due elementi:

* `launch backend only`: lancia solamente lo strato di backend (REST, DB, ecc.), pubblicato su `http://localhost:8080/progetto-fermi/api` (provate sul browser `http://localhost:8080/progetto-fermi/api/core/ping`)
* `launch full`: lancia l'applicazione completa (backend + frontend) pubblicato su `http://localhost:8080/progetto-fermi`

## Lavorare sul frontend
La compilazione _full_ è onerosa in termini di tempo, soprattutto per la parte di frontend.
Inoltre, ogni modifica alla parte di frontend implicherebbe il dover ricompilare tutta l'applicazione ogni volta.

Per questo si consiglia di:

1. lanciare la compilazione del solo backend (`launch backend only`)
2. aprire un _Prompt dei comandi_, spostarsi sulla cartella `/progetto-fermi/progetto-fermi-webapp`
3. **la prima volta** lanciare il comando `npm install` per scaricare e installare tutte le dipendenze
4. lanciare il comando `npm run serve`

Al termine della compilazione, l'applicazione di frontend sarà pubblicata su `http://localhost:3001/progetto-fermi`.
Fintanto che npm è _running_, ogni modifica apportata al codice di frontend verrà automaticamente recepita e applicata (ricaricando la pagina).