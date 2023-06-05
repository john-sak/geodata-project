## TODO

### BUGS
*  κάθε χρήστης δικό του token  
* τα getByname και getById δεν λειτουργουν παντού σωστά

### IMPL
* πρέπει να γίνει validation σε όλα τα model που παίρνουμε από έξω
* πρέπει να ολοκληρωθεί το exceptionhandling έτσι ώστε να στέλνουμε σωστό response 
στο frontend
* refresh token
* αναζήτηση (ολοκλήρωση του search request)
* import το csv



## Docker για την βάση (Postgres) 


Εβαλα στο root directory ένα ```docker-compose.yml``` στο οποίο περιγράφεται
το πώς χτίζεται το image της βάσης και πώς στην συνέχεια σηκώνεται το container.
Στο image περιλαμβάνεται το αρχείο ```init.sql``` το οποίο περιέχει το σχήμα της βάσης καθώς και τα δεδομένα.
Επιπλέον χρησιμοποιείται το ```Dockerfile``` που βρίσκεται και αυτό στο root directory.


### Bήματα 

Αρχικά χτίζεται το image της βάσης, στην συνέχεια σηκώνεται το service απο το compose
και γίνεται attach το volume.Το volume χρησιμεύει στο να κρατιούνται τα δεδομένα 
κατα τις επανεκινήσεις του container. 

```bash
#Build και εκκίνηση του container την πρώτη φορά  
#Θα αργήσει επειδή εκτος απο το build, κάνει και το insert στην βάση όλων των εγγραφών.
# χωρίς -d βγάζει τα logs και φαίνονται errors κτλ.
docker-compose up  --build -d

#Τις επόμενες  φορές αντίστοιχα Stop και start εναλλάξ
docker-compose stop
 
docker-compose start

#Αν θέλω να το σταματήσω και να διαγράψω service και container αντίστοιχα
docker-compose down -v
```

## UPDATE 04/06/2023

Έκανα κάποιες αλλαγές στο σχήμα της βάσης και άλλαξα το init.sql αρχείο έτσι ώστε να εισάγονται τα δεδομένα.
Για να ξανατρέξετε όσοι έχετε τρέξει έστω μια φορά απο την στιγμή που βάλαμε τα volumes πρέπει να κάνετε τα παρακάτω.

Για να σταματήσει το service και να διαγράψει το container.
```bash
docker-compose down  
```

Για να διαγραφεί το volume.

```bash
docker  volume  rm backend_db_data
```

Για να διαγραφεί το προηγούμενο image.
```bash
docker rmi crowdcritic-db-img
```

Στην συνέχεια επαναλαμβάνουμε τα βήματα  οδηγίες για να ξεκινήσει 
ξανά το service με το καινούργιο σχήμα.
