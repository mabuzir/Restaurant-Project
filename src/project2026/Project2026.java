package project2026;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import project2026.Models.Barista;
import project2026.Models.Chef;
import project2026.Models.Customer;
import project2026.Models.Employee;
import project2026.Models.ItemType;
import project2026.Models.Menu;
import project2026.Models.MenuItem;
import project2026.Models.Order;
import project2026.Models.OrderItem;
import project2026.Models.Restaurant;
import project2026.Models.Status;
import project2026.Models.Waiter;

public class Project2026 extends Application {
   
    public static void main(String[] args) {
       
        launch(args);                
       
    }

    @Override
    public void start(Stage stage) throws Exception {                
        
        Parent root  = new FXMLLoader().load(getClass().getResource("Views/Login.fxml"));

        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.setTitle("Code & Coffee");                
        stage.setMaximized(false);
        stage.setMaximized(true);
        stage.show();
    }
    
}
