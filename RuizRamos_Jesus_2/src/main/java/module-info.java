module ruizramos_jesus_2_group.ruizramos_jesus_2 {
    requires javafx.controls;

    requires org.controlsfx.controls;

    opens ruizramos_jesus_2_group.ruizramos_jesus_2 to javafx.fxml;
    exports ruizramos_jesus_2_group.ruizramos_jesus_2;
}