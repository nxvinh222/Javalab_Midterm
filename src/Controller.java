import javafx.event.ActionEvent;
import java.io.IOException;
import java.util.Stack;
import java.util.Queue;
import java.util.LinkedList;


import javafx.animation.TranslateTransition;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.util.Duration;


public class Controller {
//    @FXML
    private Label pname;
    private Label names;
    private TextField data;
    private Button add,pop,size;
    private VBox tp;
    private Label dev_name;
    private Stack<Integer> stack;
    private Queue<Integer> queue;
    public void changeStackScreen(ActionEvent event) throws IOException {
        stack = new Stack<>();


        GridPane root = new GridPane();
        root.setTranslateY(50);
        root.setAlignment(Pos.TOP_CENTER);


        HBox hb = new HBox();
        hb.setPadding(new Insets(20));
        hb.setSpacing(15);
        hb.setStyle("-fx-background-color: #fff;");

        data = new TextField();
        data.setPromptText("Enter data eg. 10");
        data.setId("data");
        hb.getChildren().add(data);

        add = new Button("PUSH");
        add.setId("add");
        add.setCursor(Cursor.HAND);
        hb.getChildren().add(add);

        pop = new Button("POP");
        pop.setId("pop");
        pop.setCursor(Cursor.HAND);
        hb.getChildren().add(pop);


        size = new Button("Size:"+stack.size());
        size.setId("pop");
        size.setCursor(Cursor.HAND);
        hb.getChildren().add(size);

        root.add(hb, 0, 2);



        ScrollPane sp = new ScrollPane();


        pname = new Label("STACK");
        pname.setStyle("-fx-text-fill:#000;");
        pname.setFont(Font.font("Arial", FontWeight.BOLD, 19));

        HBox hb1 = new HBox();
        hb1.setId("root1");
        hb1.getChildren().add(pname);

        root.add(hb1, 0, 1);

        tp = new VBox();
        tp.setPadding(new Insets(10,10,30,10));
        tp.setSpacing(5);
        sp.setStyle("-fx-background-color: #fff;-fx-background-radius:0px 0px 4px 4px;");

        sp.setContent(tp);
        sp.setPrefWidth(500);
        sp.setPrefHeight(500);
        root.add(sp, 0, 3);


        add.setOnAction(new EventHandler<javafx.event.ActionEvent>() {

            @Override
            public void handle(javafx.event.ActionEvent event) {



                try{
                    Integer d = Integer.parseInt(data.getText().toString());


                    names = new Label(""+d);
                    names.setStyle("-fx-background-color: #fff;-fx-padding:10px 223px 10px 223px;-fx-background-radius:4px;-fx-border-color: black;-fx-border-radius:100px;-fx-background-radius:100px;");
                    names.setFont(Font.font("Arial",FontWeight.SEMI_BOLD, 17));


                    TranslateTransition translate = new TranslateTransition();
                    translate.setByY(20);
                    translate.setDuration(Duration.millis(1000));
                    translate.setCycleCount(1);
                    translate.setAutoReverse(true);
                    translate.setNode(names);
                    translate.play();


                    tp.getChildren().addAll(names);

                    stack.push(d);

                    //System.out.println(""+stack.size());
                    size.setText("Size:"+stack.size());

                }catch(NumberFormatException e){
                    System.out.println("please enter any number!");
                }

            }
        });


        pop.setOnAction(new EventHandler<javafx.event.ActionEvent>() {

            @Override
            public void handle(javafx.event.ActionEvent arg0) {

                if(stack.size() > 0){

                    tp.getChildren().remove(tp.getChildren().size()-1);



                    stack.pop();
                    size.setText("Size:"+stack.size());

                }else{
                    System.out.println("stack is empty");
                }


            }
        });


        Scene sceneStack = new Scene(root,600,600, Color.STEELBLUE);
//        root.setId("root");
//        sceneStack.getStylesheets().add("styles.css");

//        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
        Stage window = new Stage();

        window.setScene(sceneStack);
        window.show();
    }


    // Queue
    public void changeQueueScreen(ActionEvent event) throws IOException {
        queue = new LinkedList<>();

        GridPane root = new GridPane();
        root.setTranslateY(50);
        root.setAlignment(Pos.TOP_CENTER);


        HBox hb = new HBox();
        hb.setPadding(new Insets(20));
        hb.setSpacing(15);
        hb.setStyle("-fx-background-color: #fff;");

        data = new TextField();
        data.setPromptText("Enter data eg. 10");
        data.setId("data");
        hb.getChildren().add(data);

        add = new Button("Enqueue");
        add.setId("add");
        add.setCursor(Cursor.HAND);
        hb.getChildren().add(add);

        pop = new Button("Dequeue");
        pop.setId("pop");
        pop.setCursor(Cursor.HAND);
        hb.getChildren().add(pop);


        size = new Button("Size:"+queue.size());
        size.setId("pop");
        size.setCursor(Cursor.HAND);
        hb.getChildren().add(size);

        root.add(hb, 0, 2);



        ScrollPane sp = new ScrollPane();


        pname = new Label("Queue");
        pname.setStyle("-fx-text-fill:#000;");
        pname.setFont(Font.font("Arial", FontWeight.BOLD, 19));

        HBox hb1 = new HBox();
        hb1.setId("root1");
        hb1.getChildren().add(pname);

        root.add(hb1, 0, 1);

        tp = new VBox();
        tp.setPadding(new Insets(10,10,30,10));
        tp.setSpacing(5);
        sp.setStyle("-fx-background-color: #fff;-fx-background-radius:0px 0px 4px 4px;");

        sp.setContent(tp);
        sp.setPrefWidth(500);
        sp.setPrefHeight(500);
        root.add(sp, 0, 3);


        add.setOnAction(new EventHandler<javafx.event.ActionEvent>() {

            @Override
            public void handle(javafx.event.ActionEvent event) {



                try{
                    Integer d = Integer.parseInt(data.getText().toString());


                    names = new Label(""+d);
                    names.setStyle("-fx-background-color: #fff;-fx-padding:10px 223px 10px 223px;-fx-background-radius:4px;-fx-border-color: black;-fx-border-radius:100px;-fx-background-radius:100px;");
                    names.setFont(Font.font("Arial",FontWeight.SEMI_BOLD, 17));


                    TranslateTransition translate = new TranslateTransition();
                    translate.setByY(20);
                    translate.setDuration(Duration.millis(1000));
                    translate.setCycleCount(1);
                    translate.setAutoReverse(true);
                    translate.setNode(names);
                    translate.play();


                    tp.getChildren().addAll(names);

                    queue.add(d);

                    //System.out.println(""+stack.size());
                    size.setText("Size:"+queue.size());

                }catch(NumberFormatException e){
                    System.out.println("please enter any number!");
                }

            }
        });


        pop.setOnAction(new EventHandler<javafx.event.ActionEvent>() {

            @Override
            public void handle(javafx.event.ActionEvent arg0) {

                if(queue.size() > 0){

                    tp.getChildren().remove(0);


                    queue.remove();
//                    stack.pop();
                    size.setText("Size:"+queue.size());

                }else{
                    System.out.println("stack is empty");
                }


            }
        });


        Scene sceneQueue = new Scene(root,600,600, Color.STEELBLUE);
//        root.setId("root");
//        sceneStack.getStylesheets().add("styles.css");

//        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
        Stage window = new Stage();
        window.setScene(sceneQueue);
        window.show();
    }

}
