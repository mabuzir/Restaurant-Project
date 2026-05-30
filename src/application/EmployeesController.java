package application;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import project2026.Models.Barista;
import project2026.Models.Chef;
import project2026.Models.Employee;
import project2026.Models.FileManager;
import project2026.Models.Session;
import project2026.Models.Waiter;

public class EmployeesController implements Initializable {

    @FXML
    private TextField search_field;
    @FXML
    private ComboBox<?> filter_role;
    @FXML
    private VBox employees_VBox;
    @FXML
    private Button btn_dashboard;
    @FXML
    private Button btn_orders;
    @FXML
    private Button btn_menu;
    @FXML
    private Button btn_customers;
    @FXML
    private Button btn_logout;
    @FXML
    private Label lbl_role;
    @FXML
    private Button btn_add_employee;
    @FXML
    private Button btn_remove_employee;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        if (!Session.isManager()) {  
            lbl_role.setText("Staff Account");                
        }
        loadEmployees();
    }    
    
    private void loadEmployees() {       
        ArrayList<Employee> employees = FileManager.load_Employees();
        for (Employee e : employees) {
            addEmployeeRow(e);
        }
    }
    
    @FXML
    private void add_employee_handler(ActionEvent event) throws IOException {        
        Stage dialog = new Stage();        
        
        Parent root = FXMLLoader.load(getClass().getResource("/project2026/Views/AddEmployee.fxml"));
        
        Scene scene = new Scene(root);
        
        dialog.setScene(scene);
        dialog.setTitle("Add Employee");
        dialog.initModality(Modality.APPLICATION_MODAL);
        dialog.showAndWait();
        
        employees_VBox.getChildren().clear();
        loadEmployees();
    }
    
    @FXML
    private void remove_employee_handler(ActionEvent event) {        
        String input_id = JOptionPane.showInputDialog("Enter Employee ID to remove:");
        
        if (input_id == null || input_id.trim().isEmpty()){
            return;
        }
        try{
            int targetId = Integer.parseInt(input_id.trim());
            ArrayList<Employee> employees = FileManager.load_Employees();
            
            Employee to_remove = null;
            for (Employee emp : employees){
                if (emp.getEmployeeId() == targetId){
                    to_remove = emp;
                    break;
                }
            }
            if (to_remove != null){
                employees.remove(to_remove);
                FileManager.save_Employees(employees);
                removeEmployeeRow(targetId);
            }
            else{
                JOptionPane.showMessageDialog(null, "Employee ID " + targetId + " not found.");
            }                        
        }
        catch (NumberFormatException e){
            JOptionPane.showMessageDialog(null, "Please Enter a Valid ID.");
        }        
    }
    
    private void addEmployeeRow(Employee e) {
    HBox row = new HBox(10);
    row.setStyle("-fx-padding: 12 16; -fx-border-color: transparent transparent #F0E6D8 transparent; -fx-border-width: 0 0 0.5 0;");
    row.setAlignment(Pos.CENTER_LEFT);

    Label idLabel     = new Label(String.valueOf(e.getEmployeeId()));
    Label nameLabel   = new Label(e.getEmployeeName());
    Label roleLabel   = new Label(e.getClass().getSimpleName());
    Label phoneLabel  = new Label(e.getEmployeePhone());
    Label salaryLabel = new Label(String.format("%.2f", e.getEmployeeSalary()));

    idLabel.setPrefWidth(50);
    nameLabel.setPrefWidth(200);
    roleLabel.setPrefWidth(70);
    phoneLabel.setPrefWidth(120);
    salaryLabel.setPrefWidth(70);

    idLabel.setStyle("-fx-font-size: 15; -fx-text-fill: #9A6A45;");
    nameLabel.setStyle("-fx-font-size: 15; -fx-font-weight: bold; -fx-text-fill: #3E2723;");
    phoneLabel.setStyle("-fx-font-size: 15; -fx-text-fill: #9A6A45;");
    salaryLabel.setStyle("-fx-font-size: 15; -fx-text-fill: #9A6A45;");

    String roleStyle = switch (e.getClass().getSimpleName()) {
        case "Chef"    -> "-fx-background-color: #FAEEDA; -fx-text-fill: #854F0B; -fx-background-radius: 99; -fx-padding: 2 10;";
        case "Waiter"  -> "-fx-background-color: #E6F1FB; -fx-text-fill: #185FA5; -fx-background-radius: 99; -fx-padding: 2 10;";
        case "Barista" -> "-fx-background-color: #EAF3DE; -fx-text-fill: #3B6D11; -fx-background-radius: 99; -fx-padding: 2 10;";
        default        -> "";
    };
    roleLabel.setStyle(roleStyle);

    row.getChildren().addAll(idLabel, nameLabel, roleLabel, phoneLabel, salaryLabel);
    employees_VBox.getChildren().add(row);
    }
    
    private void removeEmployeeRow(int targetId){
        for (int i = 0; i < employees_VBox.getChildren().size(); i++){
            HBox row = (HBox) employees_VBox.getChildren().get(i);
            Label idLabel = (Label) row.getChildren().get(0);
            if (Integer.parseInt(idLabel.getText().trim()) == targetId){
                employees_VBox.getChildren().remove(i);
            }
        }
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
    private void btn_orders_handler(ActionEvent event) throws IOException {        
        Stage stage = (Stage) btn_orders.getScene().getWindow();
        
        Parent root = FXMLLoader.load(getClass().getResource("/project2026/Views/Orders.fxml"));
        
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
}
