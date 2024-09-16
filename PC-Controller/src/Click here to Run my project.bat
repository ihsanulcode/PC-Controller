set PATH_TO_FX=".\javafx-sdk-15.0.1\lib"
javac --module-path %PATH_TO_FX% --add-modules javafx.controls Main.java
javac --module-path %PATH_TO_FX% --add-modules javafx.controls,javafx.fxml Main.java
java --module-path %PATH_TO_FX% --add-modules javafx.controls Main