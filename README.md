# Τέχνημα Τεχνολογίες Υγείας 2021-2022

Ένα από τα βασικότερα προβλήματα των εφαρμογών της τεχνητής νοημοσύνης στην Ιατρική είναι η έλλειψη εμπιστοσύνης του Ιατρικου Προσωπικού στην ορθότητα και την εγκυρότητα των αποτελεσμάτων που αυτές παράγουν. Ο λόγος είναι τόσο η έλλειψη σχετικών τεχνικών γνώσεων από την πλευρά των Ιατρών όσο και η δυσκολία που προκύπτει στην εξήγηση της διαδικασίσας με την οποία εξάγονται τα αποτελέσματα αφού πολλες φορές τα συστήματα αυτά λειτουργούν σαν "μαύρα κουτιά". Στη προσπάθεια λοιπόν να αντιμετωπίσουμε το πρόβλημα αυτό, η σημασία του οποιού εχει καθοριστικό ρόλο στην εξέλιξη και τη χρησιμοποίηση εφαρμογών τεχνητης νοημοσύνης, σχεδιάσαμε ενα παιχνίδι. Το παιχνίδι αυτό παρουσιάζει με τυχαίο τρόπο εικόνες υπερηχογραφημάτων με καλοήθεις και κακοήθεις όγκους, τόσο αληθινές όσο και συνθετικές, που έχουν δημιουργηθει από τα δίκτυα που εκπαιδεύσαμε. Σκοπός λοιπόν είναι να μαντέψει ο παίκτης κατα πόσο πρόκειται για πραγματική η όχι εξέταση. Έτσι λοιπόν σε περίπτωση που τα αποτελέσματα μας είναι επαρκώς καλά και οι Ιατροί δεν μπορούν να ξεχωρίσουν τις συνθετικές εικόνες εκτιμάμαι ότι θα δείξουν μεγαλύτερη εμπιστοσύνη στην εφαρμογή της τεχνητης νοημοσυνης που υλοποιήσαμε.


## Για compile και τρέξιμο:
### Από το root directory:
1. export PATH_TO_FX=/home/antokarant/javafx-sdk-17.0.2/lib
2. javac --module-path $PATH_TO_FX --add-modules javafx.controls,javafx.fxml -cp .:../  src/*.java -d bin
### Από το φάκελο bin:
1. java --module-path $PATH_TO_FX --add-modules javafx.controls,javafx.fxml -cp .:../src:../images:../images/fake:../images/real  src.Main
