module by.ustsinovich.kmeansclusteranalysis {
    requires javafx.controls;
    requires javafx.fxml;


    opens by.ustsinovich.kmeansclusteranalysis to javafx.fxml;
    exports by.ustsinovich.kmeansclusteranalysis;
    exports by.ustsinovich.kmeansclusteranalysis.controller;
    opens by.ustsinovich.kmeansclusteranalysis.controller to javafx.fxml;
}