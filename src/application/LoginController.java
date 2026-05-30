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
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import project2026.Models.FileManager;
import project2026.Models.Session;

public class LoginController implements Initializable {

    @FXML
    private TextField txt_user;
    @FXML
    private PasswordField txt_pass;
    @FXML
    private Button btn_login;

    @Override
    public void initialize(URL url, ResourceBundle rb) {                
        btn_login.setDefaultButton(true);
    }    

    @FXML
    private void btn_login_handler(ActionEvent event) throws IOException {
        
        String input_user = txt_user.getText().trim();
        String input_pass = txt_pass.getText().trim();
        
        String role = FileManager.check_Credentials(input_user, input_pass);
                                
        if (role != null){
            
            Session.setRole(role);
            
            Stage stage = (Stage) btn_login.getScene().getWindow();                        
            
            Parent root = FXMLLoader.load(getClass().getResource("/project2026/Views/DashboardManager.fxml"));           
            Scene scene = new Scene(root);
            
            stage.setScene(scene);
            stage.setTitle("Code & Coffee");
            stage.setMaximized(false);
            stage.setMaximized(true);
            stage.show();                              
            
        }                
    }
    
}
