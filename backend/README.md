
# Getting Started

## Docker για την βάση (Postgres)

### Dockerfile

* Εγκατασταση Docker

Στο directory  backend όπυ βρίσκεται το Dockerfile, τρέχω τα παρακάτω:

*  docker build -t  crowdcritic-db-img .
*  docker run -d -p 5432:5432 --name crowdcritic-db crowdcritic-db-img

Μπορεί μπροστά από τις δύο εντολές να χρειαστεί η εντολή sudo σε linux αν δεν
έχει ρυθμιστει κατάλληλα το docker

Με το configuration του docker και του application.properties αρχείου η βάση διαγράφεται και χτίζεται από την αρχή σε κάθε restart είτε του application είτε του docker container.Αφήνεται σε επόμενη υλοποίσηση η χρηση docker compose έτσι ώστε να συντηρούνται τα δεδομένα της βάσης.

