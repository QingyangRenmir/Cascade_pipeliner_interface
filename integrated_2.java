package application;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

// if handle event, must implement EventHandler here
public class hello extends Application {

    Button cnode;
    Button mnode;
    Button dnode;
    double sceneX, sceneY, layoutX, layoutY;

    @Override
    public void start(Stage primaryStage) {
        try {

            // buttons cnode, mnode, dnode in root, set text, set action
            cnode= new Button("Collection Node");
            cnode.setText("C");
            double r= 25;
            cnode.setShape(new Circle(r));
            cnode.setMinSize(2 * r, 2 * r);
            cnode.setMaxSize(2 * r, 2 * r);

            mnode= new Button("Model Node");
            mnode.setText("M");
            mnode.setShape(new Rectangle(100, 100));

            dnode= new Button("Data I/O Node");
            dnode.setText("D");
            double width= 50;
            double height= 50;
            dnode.setShape(new Polygon(width / 2, 0, width, height, 0, height));

            // functions in root2
            final Text fun1= new Text(50, 100, "Function 1");
            fun1.setScaleX(2.0);
            fun1.setScaleY(2.0);

            final Text fun2= new Text(50, 100, "Function 2");
            fun2.setScaleX(2.0);
            fun2.setScaleY(2.0);

            final Text target= new Text(250, 100, " Workspace");
            target.setScaleX(1.5);
            target.setScaleY(1.5);

            // create pane & add button onto pane
            // types of pane: Border and Stack; StackPane can add button; VBox/HBox can spread out
            // multiple nodes

            // root: left VBox with node buttons
            VBox root= new VBox();
            root.getChildren().add(cnode);
            root.getChildren().add(mnode);
            root.getChildren().add(dnode);
            cnode.setStyle("-fx-font-size: 1.5em; ");
            mnode.setStyle("-fx-font-size: 1.5em; ");
            dnode.setStyle("-fx-font-size: 1.5em; ");
            // set borderline; size; alignment; spacing for VBox
            root.setStyle("-fx-border-color: black");
            root.prefWidthProperty().bind(primaryStage.widthProperty().multiply(0.25));
            root.setAlignment(Pos.CENTER);
            root.setSpacing(30);

            // root2: right VBox with functions
            VBox root2= new VBox();
            root2.getChildren().add(fun1);
            root2.getChildren().add(fun2);
            root2.setStyle("-fx-border-color: black");
            root2.prefWidthProperty().bind(primaryStage.widthProperty().multiply(0.25));
            root2.setAlignment(Pos.CENTER);
            root2.setSpacing(30);

            // root3: mid VBox workspace
            Pane root3= new Pane();
//            root3.getChildren().addAll(getBox("green"), getBox("red"), getBox("yellow"));
            root3.getChildren().add(target);
//            root3.setSpacing(30);
            root3.setStyle("-fx-border-color: black");
            root3.prefWidthProperty().bind(primaryStage.widthProperty().multiply(0.5));
//            root3.setAlignment(Pos.CENTER);
            // set font size for label in VBox
            DoubleProperty fontSize3= new SimpleDoubleProperty(18); // font size in pt
            root3.styleProperty().bind(Bindings.format("-fx-font-size: %.2fpt;", fontSize3));

            // drag and drop functions
            // to be dragged(source): cnode, mnode, dnode, fun1, fun2
            cnode.setOnDragDetected(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    /* drag was detected, start drag-and-drop gesture*/
                    System.out.println("onDragDetected");

                    /* allow any transfer mode */
                    Dragboard db= cnode.startDragAndDrop(TransferMode.ANY);

                    /* put a string on dragboard */
                    ClipboardContent content= new ClipboardContent();
                    content.putString(cnode.getText());
                    db.setContent(content);

                    event.consume();
                }
            });

            mnode.setOnDragDetected(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    /* drag was detected, start drag-and-drop gesture*/
                    System.out.println("onDragDetected");

                    /* allow any transfer mode */
                    Dragboard db= mnode.startDragAndDrop(TransferMode.ANY);

                    /* put a string on dragboard */
                    ClipboardContent content= new ClipboardContent();
                    content.putString(mnode.getText());
                    db.setContent(content);

                    event.consume();
                }
            });

            dnode.setOnDragDetected(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    /* drag was detected, start drag-and-drop gesture*/
                    System.out.println("onDragDetected");

                    /* allow any transfer mode */
                    Dragboard db= mnode.startDragAndDrop(TransferMode.ANY);

                    /* put a string on dragboard */
                    ClipboardContent content= new ClipboardContent();
                    content.putString(dnode.getText());
                    db.setContent(content);

                    event.consume();
                }
            });

            fun1.setOnDragDetected(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    /* drag was detected, start drag-and-drop gesture*/
                    System.out.println("onDragDetected");

                    /* allow any transfer mode */
                    Dragboard db= fun1.startDragAndDrop(TransferMode.ANY);

                    /* put a string on dragboard */
                    ClipboardContent content= new ClipboardContent();
                    content.putString(fun1.getText());
                    db.setContent(content);
                    event.consume();
                }
            });

            fun2.setOnDragDetected(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    /* drag was detected, start drag-and-drop gesture*/
                    System.out.println("onDragDetected");

                    /* allow any transfer mode */
                    Dragboard db= fun2.startDragAndDrop(TransferMode.ANY);

                    /* put a string on dragboard */
                    ClipboardContent content= new ClipboardContent();
                    content.putString(fun2.getText());
                    db.setContent(content);
                    event.consume();
                }
            });

            // to be dropped(target): root3(workspace)in general, C/M/D labels
            root3.setOnDragOver(new EventHandler<DragEvent>() {
                @Override
                public void handle(DragEvent event) {
                    /* data is dragged over the target */
                    System.out.println("onDragOver");

                    /* accept it only if it is  not dragged from the same node
                     * and if it has a string data */
                    if (event.getGestureSource() != root3 &&
                        event.getDragboard().hasString()) {
                        /* allow for both copying and moving, whatever user chooses */
                        event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
                    }

                    event.consume();
                }
            });

            root3.setOnDragDropped(new EventHandler<DragEvent>() {
                @Override
                public void handle(DragEvent event) {
                    /* data dropped */
                    System.out.println("onDragDropped");
                    /* if there is a string data on dragboard, read it and use it */
                    Dragboard db= event.getDragboard();
                    System.out.println(db.getString());

                    boolean success= false;

                    if (db.getString().equals("C")) {
                        Button cnod= new Button("Collection Node");
                        root3.getChildren().add(cnod);
                        cnod.setText("C");
                        double r= 25;
                        cnod.setShape(new Circle(r));
                        cnod.setMinSize(2 * r, 2 * r);
                        cnod.setMaxSize(2 * r, 2 * r);
                        cnod.setOnMousePressed(e -> {
                            sceneX= e.getSceneX();
                            sceneY= e.getSceneY();
                            layoutX= cnod.getLayoutX();
                            layoutY= cnod.getLayoutY();
                            System.out
                                .println(cnod.getText() + " Box onStart :: layoutX ::" + layoutX +
                                    ", layoutY::" + layoutY);
                        });

                        // drag around
                        cnod.setOnMouseDragged(e -> {
                            double offsetX= e.getSceneX() - sceneX;
                            double offsetY= e.getSceneY() - sceneY;
                            cnod.setTranslateX(offsetX);
                            cnod.setTranslateY(offsetY);
                        });
                        cnod.setOnMouseReleased(e -> {
                            // Updating the new layout positions
                            cnod.setLayoutX(layoutX + cnod.getTranslateX());
                            cnod.setLayoutY(layoutY + cnod.getTranslateY());

                            // Resetting the translate positions
                            cnod.setTranslateX(0);
                            cnod.setTranslateY(0);
                        });

                        cnod.setOnAction(e -> {
                            System.out
                                .println("Button pressed " + ((Button) e.getSource()).getText());
                        });
                        Label clbl= new Label("Add to C");
                        root3.getChildren().add(clbl);
                        clbl.setOnDragOver(new EventHandler<DragEvent>() {
                            @Override
                            public void handle(DragEvent event) {
                                /* data is dragged over the target */
                                System.out.println("onDragOver");

                                /* accept it only if it is  not dragged from the same node
                                 * and if it has a string data */
                                if (event.getGestureSource() != clbl &&
                                    event.getDragboard().hasString()) {
                                    /* allow for both copying and moving, whatever user chooses */
                                    event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
                                }
                                event.consume();
                            }
                        });
                        clbl.setOnDragDropped(new EventHandler<DragEvent>() {
                            @Override
                            public void handle(DragEvent event) {
                                if (db.getString().equals("Function 1")) {
                                    Label clbl= new Label("C: Function 1");
                                    root3.getChildren().add(clbl);
                                }
                                if (db.getString().equals("Function 2")) {
                                    Label clbl= new Label("C: Function 2");
                                    root3.getChildren().add(clbl);
                                }
                            }
                        });

                    }
                    if (db.getString().equals("M")) {
                        Button mnod= new Button("M");
                        mnod.setText("M");
                        mnod.setShape(new Rectangle(100, 100));
                        root3.getChildren().add(mnod);
                        Label mlbl= new Label("Add to M");
                        root3.getChildren().add(mlbl);
                        mlbl.setOnDragOver(new EventHandler<DragEvent>() {
                            @Override
                            public void handle(DragEvent event) {
                                /* data is dragged over the target */
                                System.out.println("onDragOver");

                                /* accept it only if it is  not dragged from the same node
                                 * and if it has a string data */
                                if (event.getGestureSource() != mlbl &&
                                    event.getDragboard().hasString()) {
                                    /* allow for both copying and moving, whatever user chooses */
                                    event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
                                }
                                event.consume();
                            }
                        });
                        mlbl.setOnDragDropped(new EventHandler<DragEvent>() {
                            @Override
                            public void handle(DragEvent event) {
                                if (db.getString().equals("Function 1")) {
                                    Label mlbl= new Label("M: Function 1");
                                    root3.getChildren().add(mlbl);
                                }
                                if (db.getString().equals("Function 2")) {
                                    Label mlbl= new Label("M: Function 2");
                                    root3.getChildren().add(mlbl);
                                }
                            }
                        });
                    }

                    if (db.getString().equals("D")) {
                        Button dnod= new Button("D");
                        dnod.setText("D");
                        double width= 50;
                        double height= 50;
                        dnod.setShape(new Polygon(width / 2, 0, width, height, 0, height));
                        root3.getChildren().add(dnod);
                        Label dlbl= new Label("Add to D");
                        root3.getChildren().add(dlbl);
                        dlbl.setOnDragOver(new EventHandler<DragEvent>() {
                            @Override
                            public void handle(DragEvent event) {
                                /* data is dragged over the target */
                                System.out.println("onDragOver");

                                /* accept it only if it is  not dragged from the same node
                                 * and if it has a string data */
                                if (event.getGestureSource() != dlbl &&
                                    event.getDragboard().hasString()) {
                                    /* allow for both copying and moving, whatever user chooses */
                                    event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
                                }
                                event.consume();
                            }
                        });
                        dlbl.setOnDragDropped(new EventHandler<DragEvent>() {
                            @Override
                            public void handle(DragEvent event) {
                                if (db.getString().equals("Function 1")) {
                                    Label dlbl= new Label("D: Function 1");
                                    root3.getChildren().add(dlbl);
                                }
                                if (db.getString().equals("Function 2")) {
                                    Label dlbl= new Label("D: Function 2");
                                    root3.getChildren().add(dlbl);
                                }
                            }
                        });
                    }
//                    if (db.hasString()) {
//
//                        target.setText(db.getString());
//                        success= true;
//                    }

                    /* let the source know whether the string was successfully
                     * transferred and used */
                    event.setDropCompleted(success);

                    event.consume();
                }
            });

            cnode.setOnDragDone(new EventHandler<DragEvent>() {
                @Override
                public void handle(DragEvent event) {
                    /* the drag-and-drop gesture ended */
                    System.out.println("onDragDone");
                    /* if the data was successfully moved, clear it */
                    if (event.getTransferMode() == TransferMode.MOVE) {
                        cnode.setText("");
                    }

                    event.consume();
                }
            });

            mnode.setOnDragDone(new EventHandler<DragEvent>() {
                @Override
                public void handle(DragEvent event) {
                    /* the drag-and-drop gesture ended */
                    System.out.println("onDragDone");
                    /* if the data was successfully moved, clear it */
                    if (event.getTransferMode() == TransferMode.MOVE) {
                        mnode.setText("");
                    }

                    event.consume();
                }
            });

            dnode.setOnDragDone(new EventHandler<DragEvent>() {
                @Override
                public void handle(DragEvent event) {
                    /* the drag-and-drop gesture ended */
                    System.out.println("onDragDone");
                    /* if the data was successfully moved, clear it */
                    if (event.getTransferMode() == TransferMode.MOVE) {
                        dnode.setText("");
                    }

                    event.consume();
                }
            });

            // HBox
            // / | \
            // root root3 root2
            HBox hbox= new HBox();
            hbox.getChildren().addAll(root, root3, root2);

            // create & set scene
            Scene scene= new Scene(hbox, 900, 600);
            scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
            primaryStage.setScene(scene);

            // set title
            primaryStage.setTitle("Hello");
            primaryStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private StackPane getBox(String color) {
        StackPane box= new StackPane();
        box.getChildren().add(new Label("Drag me !!"));
        box.setStyle(
            "-fx-background-color:" + color + ";-fx-border-width:2px;-fx-border-color:black;");
        box.setPrefSize(150, 150);
        box.setMaxSize(150, 150);
        box.setMinSize(150, 150);
        box.setOnMousePressed(e -> {
            sceneX= e.getSceneX();
            sceneY= e.getSceneY();
            layoutX= box.getLayoutX();
            layoutY= box.getLayoutY();
            System.out.println(color.toUpperCase() + " Box onStart :: layoutX ::" + layoutX +
                ", layoutY::" + layoutY);
        });
        box.setOnMouseDragged(e -> {
            double offsetX= e.getSceneX() - sceneX;
            double offsetY= e.getSceneY() - sceneY;
            box.setTranslateX(offsetX);
            box.setTranslateY(offsetY);
        });
        box.setOnMouseReleased(e -> {
            // Updating the new layout positions
            box.setLayoutX(layoutX + box.getTranslateX());
            box.setLayoutY(layoutY + box.getTranslateY());

            // Resetting the translate positions
            box.setTranslateX(0);
            box.setTranslateY(0);
        });
        return box;
    }

    public static void main(String[] args) {
        launch(args);
    }

}

//Comments area
//EventHandler<ActionEvent> buttonEventHandler(){
//return event -> {
//  Button numberButton = (Button) event.getTarget();
//  calculatorOperations.push(Double.valueOf(numberButton.getText()));
//};
//}

//cnode.setOnAction(new EventHandler<ActionEvent>() {
//@Override
//public void handle(ActionEvent event) {
//if (event.getSource() == cnode) {
//System.out.println("You clicked button.");
//}
//}
//});

// use lambda inner function to set action for button2
//button2.setOnAction(e -> System.out.println("drink bubble tea"));

// create labels
//Label label1= new Label(" Workspace ");
//Label label2= new Label(" Function 1");
//Label label3= new Label(" Function 2");

// manually set buttons instead of using VBox
//label1.setLayoutX(700);
//label1.setLayoutY(40);
//label2.setLayoutX(200);
//label2.setLayoutY(40);

//target.setOnDragEntered(new EventHandler<DragEvent>() {
//@Override
//public void handle(DragEvent event) {
//  /* the drag-and-drop gesture entered the target */
//  System.out.println("onDragEntered");
//  /* show to the user that it is an actual gesture target */
//  if (event.getGestureSource() != target &&
//      event.getDragboard().hasString()) {
//      root3.getChildren().add(label2);
//  }
//
//  event.consume();
//}
//});

//target.setOnDragExited(new EventHandler<DragEvent>() {
//@Override
//public void handle(DragEvent event) {
//  /* mouse moved away, remove the graphical cues */
//  target.setFill(Color.BLACK);
//
//  event.consume();
//}
//});