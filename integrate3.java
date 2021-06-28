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
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.stage.Modality;
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
//            final Text fun1= new Text(50, 100, "Function 1");
//            fun1.setScaleX(2.0);
//            fun1.setScaleY(2.0);
//
//            final Text fun2= new Text(50, 100, "Function 2");
//            fun2.setScaleX(2.0);
//            fun2.setScaleY(2.0);
//
//            final Text target= new Text(150, 100, " Workspace");
//            target.setScaleX(1.5);
//            target.setScaleY(1.5);

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
//            root2.getChildren().add(fun1);
//            root2.getChildren().add(fun2);
            root2.setStyle("-fx-border-color: black");
            root2.prefWidthProperty().bind(primaryStage.widthProperty().multiply(0.25));
            root2.setAlignment(Pos.CENTER);
            root2.setSpacing(30);

            // root3: mid VBox workspace
            Pane root3= new Pane();
//            root3.getChildren().addAll(getBox("green"), getBox("red"), getBox("yellow"));
//            root3.getChildren().add(target);
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

//            fun1.setOnDragDetected(new EventHandler<MouseEvent>() {
//                @Override
//                public void handle(MouseEvent event) {
//                    /* drag was detected, start drag-and-drop gesture*/
//                    System.out.println("onDragDetected");
//
//                    /* allow any transfer mode */
//                    Dragboard db= fun1.startDragAndDrop(TransferMode.ANY);
//
//                    /* put a string on dragboard */
//                    ClipboardContent content= new ClipboardContent();
//                    content.putString(fun1.getText());
//                    db.setContent(content);
//                    event.consume();
//                }
//            });
//
//            fun2.setOnDragDetected(new EventHandler<MouseEvent>() {
//                @Override
//                public void handle(MouseEvent event) {
//                    /* drag was detected, start drag-and-drop gesture*/
//                    System.out.println("onDragDetected");
//
//                    /* allow any transfer mode */
//                    Dragboard db= fun2.startDragAndDrop(TransferMode.ANY);
//
//                    /* put a string on dragboard */
//                    ClipboardContent content= new ClipboardContent();
//                    content.putString(fun2.getText());
//                    db.setContent(content);
//                    event.consume();
//                }
//            });

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
                        // !!! set initial position for added node
                        cnod.setLayoutX(150);
                        cnod.setLayoutY(150);
                        cnod.setText("C");
                        double r= 25;
                        cnod.setShape(new Circle(r));
                        cnod.setMinSize(2 * r, 2 * r);
                        cnod.setMaxSize(2 * r, 2 * r);

                        // drag cnod around
                        // set right click for delete cnod tgt with clbl
                        cnod.setOnMousePressed(e -> {
                            if (e.getButton() == MouseButton.SECONDARY) {
                                System.out.println("Want to delete?");

                            }
                            if (e.getButton() == MouseButton.PRIMARY) {
                                sceneX= e.getSceneX();
                                sceneY= e.getSceneY();
                                System.out.println(sceneX);
                                System.out.println(sceneY);

                                layoutX= cnod.getLayoutX();
                                layoutY= cnod.getLayoutY();
                                System.out.println(
                                    cnod.getText() + " Box onStart :: layoutX ::" + layoutX +
                                        ", layoutY::" + layoutY);
                            }
                        });
                        cnod.setOnMouseDragged(e -> {
                            System.out.println(sceneX);
                            System.out.println(sceneY);
                            double offsetX= e.getSceneX() - sceneX;
                            double offsetY= e.getSceneY() - sceneY;
                            cnod.setTranslateX(offsetX);
                            cnod.setTranslateY(offsetY);
                        });

                        cnod.setOnMouseReleased(e -> {
                            if (e.getButton() == MouseButton.PRIMARY) {
                                // Updating the new layout positions
                                cnod.setLayoutX(layoutX + cnod.getTranslateX());
                                cnod.setLayoutY(layoutY + cnod.getTranslateY());
//                                clbl.setLayoutX(layoutX + cnod.getTranslateX());
//                                clbl.setLayoutY(layoutY + cnod.getTranslateY());

                                // Resetting the translate positions
                                cnod.setTranslateX(0);
                                cnod.setTranslateY(0);
                            }
                            if (e.getButton() == MouseButton.SECONDARY) {
                                // popup window
                                final Stage pop= new Stage();
                                pop.initModality(Modality.APPLICATION_MODAL);
                                pop.initOwner(primaryStage);
                                Pane popbox= new Pane();
//                                VBox popbox= new VBox(20);
                                Label msg= new Label("Want to delete?");
                                msg.setScaleX(1.7);
                                msg.setScaleY(1.7);
                                msg.setLayoutX(110);
                                msg.setLayoutY(60);

                                Button yes= new Button("Yes");
                                yes.setPrefSize(60, 30);
                                yes.setLayoutX(70);
                                yes.setLayoutY(120);
                                yes.setOnAction(e1 -> {
                                    pop.close();
                                    cnod.setVisible(false);
                                    cnod.managedProperty().bind(cnod.visibleProperty());
//                                    clbl.setVisible(false);
//                                    clbl.managedProperty().bind(cnod.visibleProperty());
                                });
                                Button no= new Button("No");
                                no.setPrefSize(60, 30);
                                no.setLayoutX(180);
                                no.setLayoutY(120);
                                no.setOnAction(e2 -> {
                                    pop.close();
                                });
                                popbox.getChildren().addAll(msg, yes, no);
                                Scene popScene= new Scene(popbox, 300, 200);
                                pop.setScene(popScene);
                                pop.show();

                            }
                        });

                        // drag and drop functions into clbl
//                        clbl.setOnDragDropped(new EventHandler<DragEvent>() {
//                            @Override
//                            public void handle(DragEvent event) {
//                                if (db.getString().equals("Function 1")) {
//                                    Label clbl= new Label("C: Function 1");
//                                    root3.getChildren().add(clbl);
//                                }
//                                if (db.getString().equals("Function 2")) {
//                                    Label clbl= new Label("C: Function 2");
//                                    root3.getChildren().add(clbl);
//                                }
//                            }
//                        });
                    }

                    // mnode
                    if (db.getString().equals("M")) {
                        Button mnod= new Button("M");
                        mnod.setText("M");
                        mnod.setShape(new Rectangle(100, 100));
                        root3.getChildren().add(mnod);
                        mnod.setLayoutX(225);
                        mnod.setLayoutY(150);
                        mnod.setOnMousePressed(e1 -> {

                            sceneX= e1.getSceneX();
                            sceneY= e1.getSceneY();
                            layoutX= mnod.getLayoutX();
                            layoutY= mnod.getLayoutY();
                            System.out
                                .println(mnod.getText() + " Box onStart :: layoutX ::" + layoutX +
                                    ", layoutY::" + layoutY);
                        });

                        mnod.setOnMouseDragged(e1 -> {
                            double offsetX= e1.getSceneX() - sceneX;
                            double offsetY= e1.getSceneY() - sceneY;
                            mnod.setTranslateX(offsetX);
                            mnod.setTranslateY(offsetY);
                        });

                        mnod.setOnMouseReleased(e -> {
                            if (e.getButton() == MouseButton.PRIMARY) {
                                // Updating the new layout positions
                                mnod.setLayoutX(layoutX + mnod.getTranslateX());
                                mnod.setLayoutY(layoutY + mnod.getTranslateY());
//                                clbl.setLayoutX(layoutX + cnod.getTranslateX());
//                                clbl.setLayoutY(layoutY + cnod.getTranslateY());

                                // Resetting the translate positions
                                mnod.setTranslateX(0);
                                mnod.setTranslateY(0);
                            }
                            if (e.getButton() == MouseButton.SECONDARY) {
                                // popup window
                                final Stage pop= new Stage();
                                pop.initModality(Modality.APPLICATION_MODAL);
                                pop.initOwner(primaryStage);
                                Pane popbox= new Pane();
//                                VBox popbox= new VBox(20);
                                Label msg= new Label("Want to delete?");
                                msg.setScaleX(1.7);
                                msg.setScaleY(1.7);
                                msg.setLayoutX(110);
                                msg.setLayoutY(60);

                                Button yes= new Button("Yes");
                                yes.setPrefSize(60, 30);
                                yes.setLayoutX(70);
                                yes.setLayoutY(120);
                                yes.setOnAction(e1 -> {
                                    pop.close();
                                    mnod.setVisible(false);
                                    mnod.managedProperty().bind(mnod.visibleProperty());
//                                    clbl.setVisible(false);
//                                    clbl.managedProperty().bind(cnod.visibleProperty());
                                });
                                Button no= new Button("No");
                                no.setPrefSize(60, 30);
                                no.setLayoutX(180);
                                no.setLayoutY(120);
                                no.setOnAction(e2 -> {
                                    pop.close();
                                });
                                popbox.getChildren().addAll(msg, yes, no);
                                Scene popScene= new Scene(popbox, 300, 200);
                                pop.setScene(popScene);
                                pop.show();

                            }
                        });

                    }

                    // dnode
                    if (db.getString().equals("D")) {
                        Button dnod= new Button("D");
                        dnod.setText("D");
                        double width= 50;
                        double height= 50;
                        dnod.setShape(new Polygon(width / 2, 0, width, height, 0, height));
                        root3.getChildren().add(dnod);
                        // !!! set initial position of added dnod
                        dnod.setLayoutX(300);
                        dnod.setLayoutY(150);
                        dnod.setOnMousePressed(e1 -> {

                            sceneX= e1.getSceneX();
                            sceneY= e1.getSceneY();
                            layoutX= dnod.getLayoutX();
                            layoutY= dnod.getLayoutY();
                            System.out
                                .println(dnod.getText() + " Box onStart :: layoutX ::" + layoutX +
                                    ", layoutY::" + layoutY);
                        });

                        dnod.setOnMouseDragged(e1 -> {
                            double offsetX= e1.getSceneX() - sceneX;
                            double offsetY= e1.getSceneY() - sceneY;
                            dnod.setTranslateX(offsetX);
                            dnod.setTranslateY(offsetY);
                        });

                        dnod.setOnMouseReleased(e -> {
                            if (e.getButton() == MouseButton.PRIMARY) {
                                // Updating the new layout positions
                                dnod.setLayoutX(layoutX + dnod.getTranslateX());
                                dnod.setLayoutY(layoutY + dnod.getTranslateY());
//                                clbl.setLayoutX(layoutX + cnod.getTranslateX());
//                                clbl.setLayoutY(layoutY + cnod.getTranslateY());

                                // Resetting the translate positions
                                dnod.setTranslateX(0);
                                dnod.setTranslateY(0);
                            }
                            if (e.getButton() == MouseButton.SECONDARY) {
                                // popup window
                                final Stage pop= new Stage();
                                pop.initModality(Modality.APPLICATION_MODAL);
                                pop.initOwner(primaryStage);
                                Pane popbox= new Pane();
//                                VBox popbox= new VBox(20);
                                Label msg= new Label("Want to delete?");
                                msg.setScaleX(1.7);
                                msg.setScaleY(1.7);
                                msg.setLayoutX(110);
                                msg.setLayoutY(60);

                                Button yes= new Button("Yes");
                                yes.setPrefSize(60, 30);
                                yes.setLayoutX(70);
                                yes.setLayoutY(120);
                                yes.setOnAction(e1 -> {
                                    pop.close();
                                    dnod.setVisible(false);
                                    dnod.managedProperty().bind(dnod.visibleProperty());
//                                    clbl.setVisible(false);
//                                    clbl.managedProperty().bind(cnod.visibleProperty());
                                });
                                Button no= new Button("No");
                                no.setPrefSize(60, 30);
                                no.setLayoutX(180);
                                no.setLayoutY(120);
                                no.setOnAction(e2 -> {
                                    pop.close();
                                });
                                popbox.getChildren().addAll(msg, yes, no);
                                Scene popScene= new Scene(popbox, 300, 200);
                                pop.setScene(popScene);
                                pop.show();

                            }
                        });

                    }

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

//cnod.setOnMouseReleased(e -> {
//// Updating the new layout positions
//cnod.setLayoutX(layoutX + cnod.getTranslateX());
//cnod.setLayoutY(layoutY + cnod.getTranslateY());
////clbl.setLayoutX(layoutX + cnod.getTranslateX());
////clbl.setLayoutY(layoutY + cnod.getTranslateY());
//
//// Resetting the translate positions
//cnod.setTranslateX(0);
//cnod.setTranslateY(0);
////clbl.setTranslateX(0);
////clbl.setTranslateY(0);
//});
//cnod.setOnAction(e -> {
//System.out
//  .println("Button pressed " + ((Button) e.getSource()).getText());
//});

////////
//clbl.setOnMousePressed(e2 -> {
//double sceneXlbl= e2.getSceneX();
//double sceneYlbl= e2.getSceneY();
//
//double layoutXlbl= clbl.getLayoutX();
//double layoutYlbl= clbl.getLayoutY();
//System.out
//  .println(
//      clbl.getText() + " Box onStart :: layoutXlbl ::" + layoutXlbl +
//          ", layoutYlbl::" + layoutYlbl);
//});
//
//// drag clbl around
//clbl.setOnMouseDragged(e2 -> {
//double offsetX= e2.getSceneX() - sceneX;
//double offsetY= e2.getSceneY() - sceneY;
//clbl.setTranslateX(offsetX);
//clbl.setTranslateY(offsetY);
//});
//clbl.setOnMouseReleased(e2 -> {
//// Updating the new layout positions
//clbl.setLayoutX(layoutX + clbl.getTranslateX());
//clbl.setLayoutY(layoutY + clbl.getTranslateY());
//
//// Resetting the translate positions
//clbl.setTranslateX(0);
//clbl.setTranslateY(0);
//});

//clbl.setOnDragOver(new EventHandler<DragEvent>() {
//@Override
//public void handle(DragEvent event) {
//  /* data is dragged over the target */
//  System.out.println("onDragOver");
//
//  /* accept it only if it is  not dragged from the same node
//   * and if it has a string data */
//  if (event.getGestureSource() != clbl &&
//      event.getDragboard().hasString()) {
//      /* allow for both copying and moving, whatever user chooses */
//      event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
//  }
//  event.consume();
//}
//});

// !!! set right click for delete cnod tgt with clbl
//cnod.setOnMousePressed(e -> {
//if (e.getButton() == MouseButton.SECONDARY) {
//  System.out.println("Want to delete?");
//
//}
//if (e.getButton() == MouseButton.PRIMARY) {
//  double sceneXlbl= e.getSceneX();
//  double sceneYlbl= e.getSceneY();
//
////  double layoutXlbl= clbl.getLayoutX();
////  double layoutYlbl= clbl.getLayoutY();
////  System.out.println(
////      clbl.getText() + " Box onStart :: layoutXlbl ::" + layoutXlbl +
////          ", layoutYlbl::" + layoutYlbl);
//}
//});
