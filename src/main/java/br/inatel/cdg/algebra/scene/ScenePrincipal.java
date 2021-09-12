package br.inatel.cdg.algebra.scene;

import br.inatel.cdg.algebra.reta.Ponto;
import br.inatel.cdg.algebra.reta.Reta;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ScenePrincipal {

    private Button btnCalcularCA, btnCalcularCL;

    private Label labelP1X, labelP1Y, labelP2X, labelP2Y;

    private TextField txtP1X,txtP1Y,txtP2X,txtP2Y, txtCoefAngular, txtCoefLinear;

    public void criaScenePrincipal(Stage stage){


        labelP1X = new Label("Ponto P1.X");
        txtP1X = new TextField();

        labelP1Y = new Label("Ponto P1.Y");
        txtP1Y = new TextField();

        labelP2X = new Label("Ponto P2.X");
        txtP2X = new TextField();

        labelP2Y = new Label("Ponto P2.Y");
        txtP2Y = new TextField();

        HBox hboxP1X = new HBox(labelP1X, txtP1X);
        HBox hboxP1Y = new HBox(labelP1Y, txtP1Y);
        HBox hboxP2X = new HBox(labelP2X, txtP2X);
        HBox hboxP2Y = new HBox(labelP2Y, txtP2Y);

        VBox vboxEntradaCoord = new VBox(hboxP1X,hboxP1Y,hboxP2X,hboxP2Y);

        txtCoefAngular = new TextField();
        txtCoefAngular.setEditable(false);
        txtCoefAngular.setText("Coef Angular: ");

        txtCoefLinear = new TextField();
        txtCoefLinear.setEditable(false);
        txtCoefLinear.setText("Coef Linear: ");


        HBox hboxRespostas = new HBox(txtCoefAngular,txtCoefLinear);


        btnCalcularCA = new Button("Calcula Coeficiente Angular");

        btnCalcularCA.setOnAction(evento -> {
            Reta reta = construirReta();
            txtCoefAngular.setText("Coef Angular: " + reta.calcCoeficienteAngular());
        });

        btnCalcularCL = new Button("Calcula Coeficiente Linear");
        btnCalcularCL.setOnAction(evento -> {
            Reta reta = construirReta();
            txtCoefLinear.setText("Coef Linear: " + reta.calcCoeficienteLinear());
        });

        HBox hBoxBotoes = new HBox(btnCalcularCA,btnCalcularCL);

        VBox layoutFinal = new VBox(vboxEntradaCoord,hboxRespostas, hBoxBotoes);

        Scene scene = new Scene(layoutFinal, 300 , 200);

        stage.setTitle("Software Para Calculos de Álgebra Linear");
        stage.setScene(scene);
        stage.show();
    }

    private Reta construirReta(){
        Ponto p1 = new Ponto(Double.parseDouble(txtP1X.getText()),
                Double.parseDouble(txtP1Y.getText()));

        Ponto p2 = new Ponto(Double.parseDouble(txtP2X.getText()),
                Double.parseDouble(txtP2Y.getText()));

        Reta reta = new Reta(p1,p2);
        return reta;
    }

}
