package application;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import project2026.Models.Barista;
import project2026.Models.Chef;
import project2026.Models.Employee;
import project2026.Models.FileManager;
import project2026.Models.Waiter;

public class AddEmployeeController implements Initializable {

    @FXML
    private TextField txt_name;
    @FXML
    private TextField txt_age;
    @FXML
    private TextField txt_phone;
    @FXML
    private TextField txt_address;
    @FXML
    private TextField text_exp;
    @FXML
    private TextField txt_salary;
    @FXML
    private ComboBox<String> role_box;
    @FXML
    private Button btn_ok;
    @FXML
    private Button btn_cancel;
   
    @Override
    public void initialize(URL url, ResourceBundle rb) {        
        role_box.getItems().addAll("Chef", "Waiter", "Barista");            
    }    

    @FXML
    private void btn_ok_handler(ActionEvent event) {
        
        try {
            String name = txt_name.getText().trim();
            String role = role_box.getValue();
            String age = txt_age.getText().trim();
            String phone = txt_phone.getText().trim();
            String address = txt_address.getText().trim();
            String exp = text_exp.getText().trim();
            double salary = Double.parseDouble(txt_salary.getText().trim());

            if (name.isEmpty() || role == null) {
                JOptionPane.showMessageDialog(null, "Please fill all fields.");        
                return;
            }

            arra
            int newId = FileManager.load_Employees().size() + 1;

            Employee emp = switch (role) {
                case "Chef"    -> new Chef(newId, name, age, phone, address, exp, salary);
                case "Waiter"  -> new Waiter(newId, name, age, phone, address, exp, salary);
                default        -> new Barista(newId, name, age, phone, address, exp, salary);
            };

            FileManager.save_Employees(emp);

            Stage stage = (Stage) btn_ok.getScene().getWindow();
            stage.close();

        } 
        catch (NumberFormatException e) {
            System.out.println("Invalid input: " + e.getMessage());
        }               
    }

    @FXML
    private void btn_cancel_handler(ActionEvent event) {        
        Stage stage = (Stage) btn_cancel.getScene().getWindow();
        stage.close();
    }
    
}
