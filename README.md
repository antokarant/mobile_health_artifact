Texnhma texnologies ugeias 2021-2022

gia compile kai treksimo:
apo fakelo texnhma:
1. export PATH_TO_FX=/home/antokarant/javafx-sdk-17.0.2/lib
2. javac --module-path $PATH_TO_FX --add-modules javafx.controls,javafx.fxml -cp .:../  src/*.java -d bin
apo fakelo bin:
1. java --module-path $PATH_TO_FX --add-modules javafx.controls,javafx.fxml -cp .:../src:../images:../images/fake:../images/real  src.Main