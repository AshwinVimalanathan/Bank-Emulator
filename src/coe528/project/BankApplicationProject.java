/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package coe528.project;

import java.io.File;
import java.lang.Object;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.awt.image.BufferedImage;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.effect.BoxBlur;
import javafx.scene.effect.ImageInput;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.BoxBlurBuilder;
import javafx.scene.effect.DropShadowBuilder;
import javafx.scene.effect.Effect;
import javafx.scene.effect.ImageInputBuilder;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.application.Application; 
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Group; 
import javafx.scene.Scene; 
import javafx.scene.effect.ImageInput; 
import javafx.scene.image.Image; 
import javafx.scene.shape.Rectangle; 
import javafx.stage.Stage;
/**
 *
 * @author a2vimala
 */
public class BankApplicationProject extends Application{

String user;
String pass;

String u;
String p;

Manager m;
Customer c;
    
    @Override
    public void start(Stage primaryStage){
       
        Manager manager = new Manager();
        Customer customer = new Customer();
       
        primaryStage.setTitle("Bank Application");
        primaryStage.show();
       
        final Scene[] scene = new Scene[16];
        
        startWelcomePg(manager, customer, scene, primaryStage, user, pass);
        primaryStage.setScene(scene[0]);
      
    }
    
    private void startWelcomePg( Manager manager, Customer customer, final Scene[] scene, final Stage primaryStage, String user, String pass){
   
       u = user;
       p = pass;
       m = manager;
       c = customer;
        
       Button btn1 = new Button("Login as Manager");
       Button btn2 = new Button("Login as Customer");
        
       GridPane pane = new GridPane();
       pane.setAlignment(Pos.CENTER);
       pane.setHgap(10);//horizontal gap in pixels => that's what you are asking for
       pane.setVgap(10);//vertical gap in pixels
       pane.setPadding(new Insets(25,25,25,25));//margins around the whole grid
                                                //(top/right/bottom/left)
       btn1.setStyle("-fx-background-color: CHOCOLATE;");
       btn2.setStyle("-fx-background-color: CHOCOLATE;");
       scene[0] = new Scene(pane, 600,550, Color.WHEAT);
       
       Text title = new Text("Welcome to the Bank");
       title.setFont(Font.font("Tahoma", FontWeight.MEDIUM, 24));
       title.setFill(Color.CHOCOLATE);
       pane.add(title, 0, 0, 1, 1);
       
       VBox vbox = new VBox(10);
       vbox.setSpacing(15);
       vbox.setPrefWidth(150);// set preferred left/right insets plus the largest of the chidren's pref widths
       
       btn1.setMinWidth(vbox.getPrefWidth());// set left/right insets plus the largest of the children's pref widths
       btn2.setMinWidth(vbox.getPrefWidth());
       
       vbox.getChildren().addAll(btn1,btn2);
       pane.add(vbox,1,4);
        
       primaryStage.setScene(scene[0]);
      
        btn1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                startManagerLoginPg(m, c, scene, primaryStage, u, p);   
            }
        });
        
        btn2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                startCustomerLoginPg(m, c, scene, primaryStage, u, p);   
            }
        });
        
    }
    
    private void startManagerLoginPg( Manager manager, Customer customer,final Scene[] scene, final Stage primaryStage, String user, String pass){
       
       u = user;
       p = pass;
       m = manager;
       c = customer;
        
        Button btn1 = new Button("Back");
       Button btn2 = new Button("Sign in");
       
       GridPane pane = new GridPane();
       pane.setAlignment(Pos.CENTER);
       pane.setHgap(10);
       pane.setVgap(10);
       pane.setPadding(new Insets(25,25,25,25));
       pane.add(btn2, 1, 4);    
       
       scene[1] = new Scene(pane, 600,550, Color.WHEAT);
       
       /*VBox vbox = new VBox(10);
       vbox.setSpacing(15);
       vbox.setPrefWidth(150);// set preferred left/right insets plus the largest of the chidren's pref widths
       
       btn1.setMinWidth(vbox.getPrefWidth());// set left/right insets plus the largest of the children's pref widths
       
       vbox.getChildren().addAll(btn1);
       pane.add(vbox,1,6);
       */
       
       Text title = new Text("Authenatication Required");
       title.setFont(Font.font("Tahoma", FontWeight.MEDIUM, 24));
       title.setFill(Color.CHOCOLATE);
       pane.add(title, 0, 0, 1, 1);
   
       Label label1 = new Label("Username: ");
       pane.add(label1, 0, 1);
       label1.setTextFill(Color.CHOCOLATE);
       
       final TextField username = new TextField();
       pane.add(username, 1, 1);
       username.setStyle("-fx-highlight-text-fill: CHOCOLATE");
       username.setStyle("-fx-text-inner-color: CHOCOLATE;");
       //dropshadow();
       
       Label label2 = new Label("Password: ");
       pane.add(label2, 0, 2);
       label2.setTextFill(Color.CHOCOLATE);
       
       final PasswordField password = new PasswordField();
       pane.add(password, 1, 2);
       
       final Text actiontarget = new Text();
       pane.add(actiontarget, 0, 6);
       
       HBox hbox = new HBox(10);
       hbox.setAlignment(Pos.BOTTOM_RIGHT);
       hbox.getChildren().add(btn1);
       hbox.getChildren().add(btn2);
       pane.add(hbox, 1, 4);
       
       primaryStage.setScene(scene[1]);
             
       btn1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                startWelcomePg(m, c, scene, primaryStage, u, p);
            }
        });
     
      btn2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if(m.login(username.getText()+"", password.getText()+"")){
                    startManagerOptionPg(m, c, scene, primaryStage, u, p);
                }
                else
                {
                    //display error
                    actiontarget.setFill(Color.FIREBRICK);
                    actiontarget.setText("Authentication Error:  No matching account found");
                }   
            }
        });
      
    }
    
    private void startManagerOptionPg(Manager manager,  Customer customer, final Scene [] scene, final Stage primaryStage,  String user,  String pass){
        
       u = user;
       p = pass;
       m = manager;
       c = customer;
       
       Button btn1 = new Button("Add a cutomer");
       Button btn2 = new Button("Delete a customer");
       Button btn3 = new Button("Logout");
       
       GridPane pane = new GridPane();
       pane.setAlignment(Pos.CENTER);
       pane.setHgap(10);
       pane.setVgap(10);
       pane.setPadding(new Insets(25,25,25,25));
       
       scene[2] = new Scene(pane, 600,550, Color.WHEAT);
       
       
       Text title = new Text("Welcome Manager:");
       title.setFont(Font.font("Tahoma", FontWeight.MEDIUM, 24));
       title.setFill(Color.CHOCOLATE);
       pane.add(title, 0, 0, 1, 1);
       VBox vbox = new VBox(10);
       vbox.setSpacing(15);
       vbox.setPrefWidth(150);
       
       btn1.setMinWidth(vbox.getPrefWidth());
       btn2.setMinWidth(vbox.getPrefWidth());
       //btn3.setMinWidth(vbox.getPrefWidth());
       
       vbox.getChildren().addAll(btn1,btn2);
       pane.add(vbox,1,4);
       
       HBox hbox = new HBox(10);
       hbox.setAlignment(Pos.BOTTOM_RIGHT);
       hbox.getChildren().add(btn3);
       pane.add(hbox, 1, 6);
       
       primaryStage.setScene(scene[2]);
       
        btn1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                startAddCustomer(m, c, scene, primaryStage, u, p);   
            }
        });
        
        btn2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                startDeleteCustomer(m, c, scene, primaryStage, u, p);   
            }
        });
        final Text actiontarget = new Text();
       pane.add(actiontarget, 0, 6);
        btn3.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                startWelcomePg(m, c, scene, primaryStage, u, p);   
            }
        });        
    }
    
    private void startAddCustomer(Manager manager,  Customer customer, final Scene [] scene, final Stage primaryStage,  String user,  String pass){
       u = user;
       p = pass;
       m = manager;
       c = customer;
       
       Button btn1 = new Button("Create");
       Button btn2 = new Button("Back");
       Button btn3 = new Button("Logout");
       GridPane pane = new GridPane();
       pane.setAlignment(Pos.CENTER);
       pane.setHgap(10);
       pane.setVgap(10);
       pane.setPadding(new Insets(25,25,25,25));
       
       scene[3] = new Scene(pane, 600,550, Color.WHEAT);
       
       Text title = new Text("Create new client:");
       title.setFont(Font.font("Tahoma", FontWeight.MEDIUM, 24));
       title.setFill(Color.CHOCOLATE);
       pane.add(title, 0, 0, 1, 1);
       
       VBox vbox = new VBox(10);
       vbox.setSpacing(15);
       vbox.setPrefWidth(150);
       
       btn1.setMinWidth(vbox.getPrefWidth());
       
       vbox.getChildren().addAll(btn1);
       pane.add(vbox,1,4);
       
       HBox hbox = new HBox(10);
       hbox.setAlignment(Pos.BOTTOM_RIGHT);
       hbox.getChildren().add(btn2);
       hbox.getChildren().add(btn3);
       pane.add(hbox, 1, 6);
   
       Label label1 = new Label("Username: ");
       pane.add(label1, 0, 1);
       label1.setTextFill(Color.CHOCOLATE);
       
       final TextField username = new TextField();
       pane.add(username, 1, 1);
       username.setStyle("-fx-highlight-text-fill: CHOCOLATE");
       username.setStyle("-fx-text-inner-color: CHOCOLATE;");
       //dropshadow();
       
       Label label2 = new Label("Password: ");
       pane.add(label2, 0, 2);
       label2.setTextFill(Color.CHOCOLATE);
       
       final PasswordField password = new PasswordField();
       pane.add(password, 1, 2);
       
       final Text actiontarget = new Text();
       pane.add(actiontarget, 0, 6);
       
       primaryStage.setScene(scene[3]);
    
      btn1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if(!(m.customerExists(username.getText()))){
                        m.addCustomer(username.getText(), password.getText());
                confirmCreateCustomer(m, c, scene, primaryStage, u, p);
            }
            }
        });
       
        btn2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                startManagerOptionPg(m, c, scene, primaryStage, u, p);
            }
        });
        
        btn3.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                startWelcomePg(m, c, scene, primaryStage, u, p);
            }
        });
    }
    
    private void confirmCreateCustomer( Manager manager,  Customer customer, final Scene [] scene, final Stage primaryStage,  String user,  String pass){
       u = user;
       p = pass;
       m = manager;
       c = customer;
       
       Button btn1 = new Button("Continue");
       Button btn2 = new Button("Logout");
      
       GridPane pane = new GridPane();
       pane.setAlignment(Pos.CENTER);
       pane.setHgap(10);
       pane.setVgap(10);
       pane.setPadding(new Insets(25,25,25,25));
       
       scene[4] = new Scene(pane, 600,550, Color.WHEAT);
       
       Text title = new Text("New Client Account Created.");
       title.setFont(Font.font("Tahoma", FontWeight.MEDIUM, 24));
       title.setFill(Color.CHOCOLATE);
       pane.add(title, 0, 0, 1, 1);
       
       /*VBox vbox = new VBox(10);
       vbox.setSpacing(15);
       vbox.setPrefWidth(150);
       
       btn1.setMinWidth(vbox.getPrefWidth());
       
       vbox.getChildren().addAll(btn1);
       pane.add(vbox,1,4);
       */
       HBox hbox = new HBox(10);
       hbox.setAlignment(Pos.BOTTOM_RIGHT);
       hbox.getChildren().add(btn1);
       hbox.getChildren().add(btn2);
       pane.add(hbox, 1, 6);
       
       primaryStage.setScene(scene[4]);
       
       btn1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                startManagerOptionPg(m, c, scene, primaryStage, u, p);
            }
        });
       
       btn2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                startWelcomePg(m, c, scene, primaryStage, u, p);
            }
        });
    }
    
    private void startDeleteCustomer(Manager manager,  Customer customer, final Scene [] scene, final Stage primaryStage,  String user,  String pass){
       u = user;
       p = pass;
       m = manager;
       c = customer;
       
       Button btn1 = new Button("Delete");
       Button btn2 = new Button("Back");
       Button btn3 = new Button("Logout");
       
       GridPane pane = new GridPane();
       pane.setAlignment(Pos.CENTER);
       pane.setHgap(10);
       pane.setVgap(10);
       pane.setPadding(new Insets(25,25,25,25));
       
       scene[5] = new Scene(pane, 600,550, Color.WHEAT);
       
       Text title = new Text("Delete existing client:");
       title.setFont(Font.font("Tahoma", FontWeight.MEDIUM, 24));
       title.setFill(Color.CHOCOLATE);
       pane.add(title, 0, 0, 1, 1);
       
       VBox vbox = new VBox(10);
       vbox.setSpacing(15);
       vbox.setPrefWidth(150);
       
       btn1.setMinWidth(vbox.getPrefWidth());
       
       vbox.getChildren().addAll(btn1);
       pane.add(vbox,1,3);
       
       HBox hbox = new HBox(10);
       hbox.setAlignment(Pos.BOTTOM_RIGHT);
       hbox.getChildren().add(btn2);
       hbox.getChildren().add(btn3);
       pane.add(hbox, 1, 6);
   
       Label label1 = new Label("Username: ");
       pane.add(label1, 0, 1);
       label1.setTextFill(Color.CHOCOLATE);
       
       final TextField username = new TextField();
       pane.add(username, 1, 1);
       username.setStyle("-fx-highlight-text-fill: CHOCOLATE");
       username.setStyle("-fx-text-inner-color: CHOCOLATE;");
       
       
       final Text actiontarget = new Text();
       pane.add(actiontarget, 0, 6);
       
       primaryStage.setScene(scene[5]);
       
             btn1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

            if(m.deleteCustomer(username.getText()) == true){  
                confirmDeleteCustomer(m, c, scene, primaryStage, u, p);
            }else{
                actiontarget.setFill(Color.FIREBRICK);
                actiontarget.setText("Error:  No matching account found");           
            }
            }
        });
       
        btn2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                startManagerOptionPg(m, c, scene, primaryStage, u, p);
            }
        });
        
        btn3.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                startWelcomePg(m, c, scene, primaryStage, u, p);
            }
        });
       
    }
    
    private void confirmDeleteCustomer( Manager manager,  Customer customer, final Scene [] scene,final Stage primaryStage,  String user,  String pass){
       
       u = user;
       p = pass;
       m = manager;
       c = customer;
       
       Button btn1 = new Button("Continue");
       Button btn2 = new Button("Logout");
      
       GridPane pane = new GridPane();
       pane.setAlignment(Pos.CENTER);
       pane.setHgap(10);
       pane.setVgap(10);
       pane.setPadding(new Insets(25,25,25,25));
       
       scene[6] = new Scene(pane, 600,550, Color.WHEAT);
       
       Text title = new Text("Deleted Existing Account.");
       title.setFont(Font.font("Tahoma", FontWeight.MEDIUM, 24));
       title.setFill(Color.CHOCOLATE);
       pane.add(title, 0, 0, 1, 1);

       HBox hbox = new HBox(10);
       hbox.setAlignment(Pos.BOTTOM_RIGHT);
       hbox.getChildren().add(btn1);
       hbox.getChildren().add(btn2);
       pane.add(hbox, 1, 6);
       
       primaryStage.setScene(scene[6]);
       
       btn1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                startManagerOptionPg(m, c, scene, primaryStage, u, p);
            }
        });
       
       btn2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                startWelcomePg(m, c, scene, primaryStage, u, p);
            }
        });
    }
    
     private void startCustomerLoginPg( Manager manager,  Customer customer, final Scene[] scene, final Stage primaryStage, String user,String pass){
       
         
       u = user;
       p = pass;
       m = manager;
       c = customer;
       
       Button btn1 = new Button("Back");
       Button btn2 = new Button("Sign in");
       
       GridPane pane = new GridPane();
       pane.setAlignment(Pos.CENTER);
       pane.setHgap(10);
       pane.setVgap(10);
       pane.setPadding(new Insets(25,25,25,25));
       pane.add(btn2, 1, 4);    
       
       scene[7] = new Scene(pane, 600,550, Color.WHEAT);
       
       Text title = new Text("Authenatication Required");
       title.setFont(Font.font("Tahoma", FontWeight.MEDIUM, 24));
       title.setFill(Color.CHOCOLATE);
       pane.add(title, 0, 0, 1, 1);
   
       Label label1 = new Label("Username: ");
       pane.add(label1, 0, 1);
       label1.setTextFill(Color.CHOCOLATE);
       
       final TextField username = new TextField();
       pane.add(username, 1, 1);
       username.setStyle("-fx-highlight-text-fill: CHOCOLATE");
       username.setStyle("-fx-text-inner-color: CHOCOLATE;");
       //dropshadow();
       
       Label label2 = new Label("Password: ");
       pane.add(label2, 0, 2);
       label2.setTextFill(Color.CHOCOLATE);
       
       final PasswordField password = new PasswordField();
       pane.add(password, 1, 2);
       
       final Text actiontarget = new Text();
       pane.add(actiontarget, 0, 6);
       
       HBox hbox = new HBox(10);
       hbox.setAlignment(Pos.BOTTOM_RIGHT);
       hbox.getChildren().add(btn1);
       hbox.getChildren().add(btn2);
       pane.add(hbox, 1, 4);
       
       primaryStage.setScene(scene[7]);
             
       btn1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                startWelcomePg(m, c, scene, primaryStage, u, p);
            }
        });
     
      btn2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if(Manager.verifyCustomer(username.getText()+"", password.getText()+"") == true){
                    startCustomerOptionPg(m, c, scene, primaryStage, username.getText(), password.getText());
                }else{
                    actiontarget.setFill(Color.FIREBRICK);
                    actiontarget.setText("Authentication Error:  No matching account found");
                
                }
                    
            }
        });  
    }
     
    private void startCustomerOptionPg( Manager manager, Customer customer, final Scene[] scene, final Stage primaryStage,  String user,  String pass){ 
       
       u = user;
       p = pass;
       m = manager;
       c = customer;
       
       Button btn1 = new Button("Deposit");
       Button btn2 = new Button("Withdraw");
       Button btn3 = new Button("Balance");
       Button btn4 = new Button("Onine Purchase");
       Button btn5 = new Button("Logout");
       
       GridPane pane = new GridPane();
       pane.setAlignment(Pos.CENTER);
       pane.setHgap(10);
       pane.setVgap(10);
       pane.setPadding(new Insets(25,25,25,25));
       
       scene[8] = new Scene(pane, 600,550, Color.WHEAT);
       
       
       Text title = new Text("Welcome Customer:");
       title.setFont(Font.font("Tahoma", FontWeight.MEDIUM, 24));
       title.setFill(Color.CHOCOLATE);
       pane.add(title, 0, 0, 1, 1);
       VBox vbox = new VBox(10);
       vbox.setSpacing(15);
       vbox.setPrefWidth(150);
       
       btn1.setMinWidth(vbox.getPrefWidth());
       btn2.setMinWidth(vbox.getPrefWidth());
       btn3.setMinWidth(vbox.getPrefWidth());
       btn4.setMinWidth(vbox.getPrefWidth());
       
       vbox.getChildren().addAll(btn1,btn2,btn3, btn4);
       pane.add(vbox,1,4);
       
       HBox hbox = new HBox(10);
       hbox.setAlignment(Pos.BOTTOM_RIGHT);
       hbox.getChildren().add(btn5);
       pane.add(hbox, 1, 6);
       
       primaryStage.setScene(scene[8]);
       
        btn1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                startDepositPg(m, c, scene, primaryStage, u, p);   
            }
        });
        
        btn2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                startWithdrawPg(m, c, scene, primaryStage, u, p);   
            }
        });
        final Text actiontarget = new Text();
       pane.add(actiontarget, 0, 6);
       
       btn3.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                startBalancePg(m, c, scene, primaryStage, u, p);   
            }
        });
       
        btn4.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                startOnlinePurchasePg(m, c, scene, primaryStage, u, p);   
            }
        });
        
        btn5.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                startWelcomePg(m, c, scene, primaryStage, u, p);  
            }
        });
    }
    private void startDepositPg( Manager manager, Customer customer, final Scene [] scene,final Stage primaryStage, String user, String pass){
       
       u = user;
       p = pass;
       m = manager;
       c = customer;
        
        Button btn1 = new Button("Back");
        Button btn2 = new Button("Logout");
        Button btn3 = new Button("Deposit");
        
        GridPane pane = new GridPane();
        pane.setAlignment(Pos.CENTER);
        pane.setHgap(10);
        pane.setVgap(10);
        pane.setPadding(new Insets(25, 25, 25, 25));
        
        scene[9] = new Scene(pane, 600, 550, Color.WHEAT);
        
       Text title = new Text("Deposit");
       title.setFont(Font.font("Tahoma", FontWeight.MEDIUM, 18));
       title.setFill(Color.CHOCOLATE);
       pane.add(title, 0, 0, 1, 1);
       
       
       final TextField input = new TextField();
       pane.add(input, 1, 2);
       input.setStyle("-fx-highlight-text-fill: CHOCOLATE");
       input.setStyle("-fx-text-inner-color: CHOCOLATE;");
       
       Label label1 = new Label("Deposit Amount: $");
       pane.add(label1, 0, 2);
       label1.setTextFill(Color.CHOCOLATE);
       
       VBox vbox = new VBox(10);
       vbox.setSpacing(15);
       vbox.setPrefWidth(150);
       
       btn3.setMinWidth(vbox.getPrefWidth());
       
       vbox.getChildren().addAll(btn3);
       pane.add(vbox,1,4);
       
       HBox hbox = new HBox(10);
       hbox.setAlignment(Pos.BOTTOM_RIGHT);
       hbox.getChildren().add(btn1);
       hbox.getChildren().add(btn2); 
       pane.add(hbox, 1, 6);
       
       final Text actiontarget = new Text();
       pane.add(actiontarget, 0, 6);
       
       primaryStage.setScene(scene[9]);
       
       
       btn1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                startCustomerOptionPg(m, c, scene, primaryStage, u, p);
            }
        });
        
        btn2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                startWelcomePg(m, c, scene, primaryStage, u, p);
            }
        });
        btn3.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if(isNumber(input.getText()) && Double.parseDouble(input.getText())>0){
                    c.depositMoney(u, p, Double.parseDouble(input.getText()));
                    c.updateLevel();
                    confirmDepositPg(m, c, scene,primaryStage, u, p);
                }
                else{
                    actiontarget.setFill(Color.FIREBRICK);
                    actiontarget.setText("Authentication Error:  Invalid Amount");    
                }
            }   
        }); 
    }
    private void confirmDepositPg( Manager manager,  Customer customer, final Scene [] scene, final Stage primaryStage,  String user,  String pass){
       
       u = user;
       p = pass;
       m = manager;
       c = customer;
       
       Button btn1 = new Button("Continue");
       Button btn2 = new Button("Logout");
      
       GridPane pane = new GridPane();
       pane.setAlignment(Pos.CENTER);
       pane.setHgap(10);
       pane.setVgap(10);
       pane.setPadding(new Insets(25,25,25,25));
       
       scene[10] = new Scene(pane, 600,550, Color.WHEAT);
       
       Text title = new Text("Amount has been deposited.");
       title.setFont(Font.font("Tahoma", FontWeight.MEDIUM, 24));
       title.setFill(Color.CHOCOLATE);
       pane.add(title, 0, 0, 1, 1);

       HBox hbox = new HBox(10);
       hbox.setAlignment(Pos.BOTTOM_RIGHT);
       hbox.getChildren().add(btn1);
       hbox.getChildren().add(btn2);
       pane.add(hbox, 1, 6);
       
       primaryStage.setScene(scene[10]);
       
       btn1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                startCustomerOptionPg(m, c, scene, primaryStage, u, p);
            }
        });
       
       btn2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                startWelcomePg(m, c, scene, primaryStage, u, p);
            }
        });
    }    
    private void startWithdrawPg( Manager manager, Customer customer, final Scene [] scene,final Stage primaryStage,  String user,  String pass){
        u = user;
        p = pass;
        m = manager;
        c = customer;
        
        Button btn1 = new Button("Back");
        Button btn2 = new Button("Logout");
        Button btn3 = new Button("Withdraw");
        
        GridPane pane = new GridPane();
        pane.setAlignment(Pos.CENTER);
        pane.setHgap(10);
        pane.setVgap(10);
        pane.setPadding(new Insets(25, 25, 25, 25));
        
        scene[11] = new Scene(pane, 600, 550, Color.WHEAT);
        
       Text title = new Text("Withdraw");
       title.setFont(Font.font("Tahoma", FontWeight.MEDIUM, 18));
       title.setFill(Color.CHOCOLATE);
       pane.add(title, 0, 0, 1, 1);
       
       
       final TextField input = new TextField();
       pane.add(input, 1, 2);
       input.setStyle("-fx-highlight-text-fill: CHOCOLATE");
       input.setStyle("-fx-text-inner-color: CHOCOLATE;");
       
       Label label1 = new Label("Withdraw Amount: $");
       pane.add(label1, 0, 2);
       label1.setTextFill(Color.CHOCOLATE);
       
       VBox vbox = new VBox(10);
       vbox.setSpacing(15);
       vbox.setPrefWidth(150);
       
       btn3.setMinWidth(vbox.getPrefWidth());
       
       vbox.getChildren().addAll(btn3);
       pane.add(vbox,1,4);
       
       HBox hbox = new HBox(10);
       hbox.setAlignment(Pos.BOTTOM_RIGHT);
       hbox.getChildren().add(btn1);
       hbox.getChildren().add(btn2); 
       pane.add(hbox, 1, 6);
       
       final Text actiontarget = new Text();
       pane.add(actiontarget, 0, 6);
      
       primaryStage.setScene(scene[11]);
       
       
       btn1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                startCustomerOptionPg(m, c, scene, primaryStage, u, p);
            }
        });
        
        btn2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                startWelcomePg(m, c, scene, primaryStage, u, p);
            }
        });
        btn3.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if(isNumber(input.getText()) && Double.parseDouble(input.getText())<=c.getBalance() && Double.parseDouble(input.getText())>0){
                    c.withdrawMoney(u, p, Double.parseDouble(input.getText()));
                    c.updateLevel();
                    confirmWithdrawPg(m, c, scene,primaryStage, u, p);
                }
                else{
                    actiontarget.setFill(Color.FIREBRICK);
                    actiontarget.setText("Authentication Error: Invalid Amount");    
                }
            }   
        }); 
    }
    private void confirmWithdrawPg( Manager manager,  Customer customer, final Scene [] scene, final Stage primaryStage,  String user,  String pass){
       
       u = user;
       p = pass;
       m = manager;
       c = customer;
       
       Button btn1 = new Button("Continue");
       Button btn2 = new Button("Logout");
      
       GridPane pane = new GridPane();
       pane.setAlignment(Pos.CENTER);
       pane.setHgap(10);
       pane.setVgap(10);
       pane.setPadding(new Insets(25,25,25,25));
       
       scene[12] = new Scene(pane, 600,550, Color.WHEAT);
       
       Text title = new Text("Amount has been withdrawn.");
       title.setFont(Font.font("Tahoma", FontWeight.MEDIUM, 24));
       title.setFill(Color.CHOCOLATE);
       pane.add(title, 0, 0, 1, 1);

       HBox hbox = new HBox(10);
       hbox.setAlignment(Pos.BOTTOM_RIGHT);
       hbox.getChildren().add(btn1);
       hbox.getChildren().add(btn2);
       pane.add(hbox, 1, 6);
       
       primaryStage.setScene(scene[12]);
       
       btn1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                startCustomerOptionPg(m, c, scene, primaryStage, u, p);
            }
        });
       
       btn2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                startWelcomePg(m, c, scene, primaryStage, u, p);
            }
        });
    }   
    private void startBalancePg( Manager manager, Customer customer, final Scene [] scene,final Stage primaryStage,  String user,  String pass){
        
        u = user;
        p = pass;
        m = manager;
        c = customer;
       
        Button btn1 = new Button("Back");
        Button btn2 = new Button("Logout");
        
        GridPane pane = new GridPane();
        pane.setAlignment(Pos.CENTER);
        pane.setHgap(10);
        pane.setVgap(10);
        pane.setPadding(new Insets(25, 25, 25, 25));
        
        scene[13] = new Scene(pane, 600, 550, Color.WHEAT);
        
      Text title = new Text("Balance:");
       title.setFont(Font.font("Tahoma", FontWeight.MEDIUM, 18));
       title.setFill(Color.CHOCOLATE);
       pane.add(title, 0, 0, 1, 1);
        
       Label label1 = new Label("Balance Amount: $" + c.getBalance(u, p));
       pane.add(label1, 0, 1);
       label1.setTextFill(Color.CHOCOLATE);
       
       Label label2 = new Label("Current Membership Status: " + c.getLevel().getState());
       pane.add(label2, 0, 2);
       label2.setTextFill(Color.CHOCOLATE);
       
       HBox hbox = new HBox(10);
       hbox.setAlignment(Pos.BOTTOM_RIGHT);
       hbox.getChildren().add(btn1);
       hbox.getChildren().add(btn2); 
       pane.add(hbox, 1, 6);
       
       
       primaryStage.setScene(scene[13]);
       
       
       btn1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                startCustomerOptionPg(m, c, scene, primaryStage, u, p);
            }
        });
        
        btn2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                startWelcomePg(m, c, scene, primaryStage, u, p);
            }
        });
    }
    
    private void startOnlinePurchasePg( Manager manager, Customer customer,final Scene [] scene,final Stage primaryStage,  String user,  String pass){
        u = user;
        p = pass;
        m = manager;
        c = customer;
        
        Button btn1 = new Button("Purchase");
        Button btn2 = new Button("Back");
        Button btn3 = new Button("Logout");
        
        GridPane pane = new GridPane();
        pane.setAlignment(Pos.CENTER);
        pane.setHgap(10);
        pane.setVgap(10);
        pane.setPadding(new Insets(25, 25, 25, 25));
        
       scene[14] = new Scene(pane, 600, 550, Color.WHEAT);
       
       VBox vbox = new VBox(10);
       vbox.setSpacing(15);
       vbox.setPrefWidth(150);
       
       btn1.setMinWidth(vbox.getPrefWidth());
       
       vbox.getChildren().addAll(btn1);
       pane.add(vbox,1,4);
       
       Text title = new Text("Online Purchase: ");
       title.setFont(Font.font("Tahoma", FontWeight.MEDIUM, 18));
       title.setFill(Color.CHOCOLATE);
       pane.add(title, 0, 0, 1, 1);
        
       
       Label label1 = new Label("Purchasing Amount: $" );
       pane.add(label1, 0, 2);
       label1.setTextFill(Color.CHOCOLATE);
       
       final TextField input = new TextField();
       pane.add(input, 1,2);
       input.setStyle("-fx-highlight-text-fill: CHOCOLATE");
       input.setStyle("-fx-text-inner-color: CHOCOLATE;");
       
       HBox hbox = new HBox(10);
       hbox.setAlignment(Pos.BOTTOM_RIGHT);
       hbox.getChildren().add(btn2);
       hbox.getChildren().add(btn3); 
       pane.add(hbox, 1, 6);
       
       final Text actiontarget = new Text();
       pane.add(actiontarget, 0, 6);
       
       primaryStage.setScene(scene[14]);
       
        btn1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                 if(isNumber(input.getText()) && Double.parseDouble(input.getText())>=50 && ((Double.parseDouble(input.getText()))<(c.getBalance()+c.getLevel().getOnlinePurchaseFee()))){
                    c.onlinePurchase(u, p, Double.parseDouble(input.getText()));
                    confirmOnlinePurchasePg(m, c, scene,primaryStage, u, p);
                }else{
                    actiontarget.setFill(Color.FIREBRICK);
                    actiontarget.setText("Authentication Error: Unable to purchase online");                     
                 }
            }
        });
        
        btn2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                startCustomerOptionPg(m, c, scene, primaryStage, u, p);
            }
        });
        
        btn3.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                startWelcomePg(m, c, scene, primaryStage, u, p);
            }
        });
       
    }
    private void confirmOnlinePurchasePg( Manager manager,  Customer customer, final Scene [] scene, final Stage primaryStage,  String user,  String pass){
       
       u = user;
       p = pass;
       m = manager;
       c = customer;
       
       Button btn1 = new Button("Continue");
       Button btn2 = new Button("Logout");
      
       GridPane pane = new GridPane();
       pane.setAlignment(Pos.CENTER);
       pane.setHgap(10);
       pane.setVgap(10);
       pane.setPadding(new Insets(25,25,25,25));
       
       scene[15] = new Scene(pane, 600,550, Color.WHEAT);
       
       Text title = new Text("Online Payment is Successful.");
       title.setFont(Font.font("Tahoma", FontWeight.MEDIUM, 24));
       title.setFill(Color.CHOCOLATE);
       pane.add(title, 0, 0, 1, 1);

       HBox hbox = new HBox(10);
       hbox.setAlignment(Pos.BOTTOM_RIGHT);
       hbox.getChildren().add(btn1);
       hbox.getChildren().add(btn2);
       pane.add(hbox, 1, 6);
       
       primaryStage.setScene(scene[15]);
       
       btn1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                startCustomerOptionPg(m, c, scene, primaryStage, u, p);
            }
        });
       
       btn2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                startWelcomePg(m, c, scene, primaryStage, u, p);
            }
        });
    }   
      
    private static boolean isNumber(String string){
        try{
            double temp = Double.parseDouble(string);
        }
        catch(NumberFormatException exception){
            return false;
        }
        return true;
    }
    /**
     * The main() method is ignored in correctly deployed JavaFX application.
     * main() serves only as fallback in case the application can not be
     * launched through deployment artifacts, e.g., in IDEs with limited FX
     * support. NetBeans ignores main().
     *
     * @param args the command line arguments
     */

    public static void main(String[] args) {
        launch(args);
    }
  
}






