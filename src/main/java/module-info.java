module ng.plan.nationalgalleryplanner {
    requires javafx.controls;
    requires javafx.fxml;


    opens ng.plan.nationalgalleryplanner to javafx.fxml;
    exports ng.plan.nationalgalleryplanner;
}