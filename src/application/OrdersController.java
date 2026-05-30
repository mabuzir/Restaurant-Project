package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import project2026.Models.Session;

public class OrdersController implements Initializable {

    @FXML
    private TextField search_field;
    @FXML
    private ComboBox<?> filter_status;
    @FXML
    private VBox orders_VBox;
    @FXML
    private Button btn_dashboard;
    @FXML
    private Button btn_menu;
    @FXML
    private Button btn_customers;
    @FXML
    private Button btn_employees;
    @FXML
    private Button btn_logout;
    @FXML
    private Label lbl_role;
    @FXML
    private Button btn_add_order;
    @FXML
    private Button btn_remove_order;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
         if (!Session.isManager()) {
            btn_employees.setVisible(false);
            btn_employees.setManaged(false);
            lbl_role.setText("Staff Account");                
        }
    }    

    @FXML
    private void add_order_handler(ActionEvent event) {
        
    }
    
    @FXML
    private void remove_order_handler(ActionEvent event) {
    }

    @FXML
    private void logout_handler(ActionEvent event) throws IOException {
        
        Stage stage = (Stage) btn_logout.getScene().getWindow();
        
        Parent root = FXMLLoader.load(getClass().getResource("/project2026/Views/Login.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.setTitle("Code & Coffee");
        stage.setMaximized(false);
        stage.setMaximized(true);
        stage.show();
    }   

    @FXML
    private void btn_dashboard_handler(ActionEvent event) throws IOException {
        
        Stage stage = (Stage) btn_dashboard.getScene().getWindow();
        
        Parent root = FXMLLoader.load(getClass().getResource("/project2026/Views/DashboardManager.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.setTitle("Code & Coffee");
        stage.setMaximized(false);
        stage.setMaximized(true);
        stage.show();
    }

    @FXML
    private void btn_menu_handler(ActionEvent event) throws IOException {
        
        Stage stage = (Stage) btn_menu.getScene().getWindow();
        
        Parent root = FXMLLoader.load(getClass().getResource("/project2026/Views/Menu.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.setTitle("Code & Coffee");
        stage.setMaximized(false);
        stage.setMaximized(true);
        stage.show();
    }

    @FXML
    private void btn_customers_handler(ActionEvent event) throws IOException {
        
        Stage stage = (Stage) btn_customers.getScene().getWindow();
        
        Parent root = FXMLLoader.load(getClass().getResource("/project2026/Views/Customers.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.setTitle("Code & Coffee");
        stage.setMaximized(false);
        stage.setMaximized(true);
        stage.show();
    }

    @FXML
    private void btn_employees_handler(ActionEvent event) throws IOException {
        
        Stage stage = (Stage) btn_employees.getScene().getWindow();
        
        Parent root = FXMLLoader.load(getClass().getResource("/project2026/Views/Employees.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.setTitle("Code & Coffee");
        stage.setMaximized(false);
        stage.setMaximized(true);
        stage.show();
    }       
}
