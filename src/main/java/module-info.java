module ng.plan.nationalgalleryplanner {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires xstream;
    requires java.desktop;


    opens ng.plan.nationalgalleryplanner to javafx.fxml, xstream;
    opens ng.plan.nationalgalleryplanner.ADTs to javafx.fxml, xstream;


    exports ng.plan.nationalgalleryplanner.ADTs;
    exports ng.plan.nationalgalleryplanner;
}