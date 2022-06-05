# Τέχνημα Τεχνολογίες Υγείας 2021-2022

## Για compile και τρέξιμο:
### Από το root directory:
1. export PATH_TO_FX=/home/antokarant/javafx-sdk-17.0.2/lib
2. javac --module-path $PATH_TO_FX --add-modules javafx.controls,javafx.fxml -cp .:../  src/*.java -d bin
### Από το φάκελο bin:
1. java --module-path $PATH_TO_FX --add-modules javafx.controls,javafx.fxml -cp .:../src:../images:../images/fake:../images/real  src.Main
