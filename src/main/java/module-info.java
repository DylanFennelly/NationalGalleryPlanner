module ng.plan.nationalgalleryplanner {
    requires javafx.controls;
    requires javafx.fxml;
    requires xstream;


    opens ng.plan.nationalgalleryplanner to javafx.fxml, xstream;
    opens ng.plan.nationalgalleryplanner.ADTs to javafx.fxml, xstream;


    exports ng.plan.nationalgalleryplanner.ADTs;
    exports ng.plan.nationalgalleryplanner;
}