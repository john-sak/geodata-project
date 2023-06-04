


## Docker για την βάση (Postgres)



Αρχικά εγκαθιστώ το  Docker στο μηχάνημα μου.


  Την πρώτη φορά που το τρέχουμε, εκτελούμε τις παρακάτω εντολές, στο directory  **backend** όπoυ βρίσκεται το **Dockerfile**:

Δημιουργία **image**:
 ```docker 
  docker build -t  crowdcritic-db-img .
```
Δημιουργία **container**:
```docker
docker run -d -p 5432:5432 --name crowdcritic-db crowdcritic-db-img
```

Οταν θέλουμε να σταματήσουμε το container:

```docker 
docker stop  crowdcritic-db
```

Oποτε θέλω να ξαναχρησιμοποιήσω το container:
```docker
docker start  crowdcritic-db
```


Μπορεί μπροστά από τις δύο εντολές να χρειαστεί η εντολή `sudo` σε linux αν δεν
έχει ρυθμιστει κατάλληλα το docker

Με το configuration του docker και του application.properties αρχείου η βάση διαγράφεται και χτίζεται 
από την αρχή σε κάθε restart είτε του application είτε του docker container.Αφήνεται σε επόμενη υλοποίσηση η χρηση 
docker compose έτσι ώστε να συντηρούνται τα δεδομένα της βάσης.

## Docker Compose 

Εβαλα στο root directory ένα ```docker-compose.yml``` στο οποίο περιγράφεται
το πώς χτίζεται το image της βάσης και πώς στην συνέχεια σηκώνεται το container.
Στο image περιλαμβάνεται το αρχείο ```init.sql``` το οποίο περιέχει το σχήμα της βάσης.
Επιπλέον χρησιμοποιείται το ```Dockerfile``` που βρίσκεται και αυτό στο root dirrectory.


### Bήματα 

Αρχικά χτίζεται το image και αρχικοποιεί την βάση , στην συνέχεια σηκώνεται το service απο το compose
και γίνεται attach το volume.Το volume χρησιμεύει στο να κρατιουνται τα δεδομενα 
κατα τις επανακινήσεις του container. 

```bash
#Build και εκκίνηση του container την πρώτη φορά  
#Θα αργήσει επειδή εκτος απο το build, κάνει και το insert στην βάση όλων των εγγραφών.
# χωρίς -d βγάζει τα logs και φαίνονται errors κτλ.
docker-compose up  --build -d

#Τις επόμενες  φορές αντίστοιχα Stop και start 
docker-compose stop
 
docker-compose start

#Αν θέλω να το σταματήσω και να διαγράψω service και container αντίστοιχα
docker-compose down -v
```

## UPDATE 04/06/2023

Έκανα κάποιες αλλαγές στο σχήμα της βάσης και άλλαξα το init.sql αρχείο έτσι ώστε να εισάγονται τα δεδομένα.
Για να ξανατρέξετε όσοι έχετε  τρέξει έστω μια φορά απο την στιγμή που βάλαμε τα volumes πρέπει να κάνετε τα παρακάτω.

Για να σταματήσει το service και να διαγράψει το container.
```bash
docker-compose down  
```

Για να διαγραφεί το volume.

```bash
docker  volume  rm backend_db_data
```

Για να διαγραφεί το image που περιέχει το προηγούμενο image.
```bash
docker rmi crowdcritic-db-img
```

Στην συνέχεια επαναλαμβάνουμε τις προηγούμενες οδηγίες για να ξεκινήσει 
ξανά το service με το καινούργιο σχήμα.
