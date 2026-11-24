/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class ImcController {

    @FXML
    private TextField txtPeso;

    @FXML
    private TextField txtAltura;

    @FXML
    private Label lblResultado;

    @FXML
    private void calcularImc() {

        try {
            double peso = Double.parseDouble(txtPeso.getText());
            double altura = Double.parseDouble(txtAltura.getText());

            if (peso <= 0 || altura <= 0) {
                lblResultado.setText("El peso y la altura deben ser mayores a 0");
                return;
            }

            double imc = peso / (altura * altura);

            String categoria;

            if (imc < 18.5) {
                categoria = "Bajo peso";
            } else if (imc < 25) {
                categoria = "Normal";
            } else if (imc < 30) {
                categoria = "Sobrepeso";
            } else {
                categoria = "Obesidad";
            }

            double imcRedondeado = Math.round(imc * 100) / 100.0;

            lblResultado.setText("IMC: " + imcRedondeado + " - " + categoria);

        } catch (NumberFormatException e) {
            lblResultado.setText("Ingrese valores numericos validos");
        }
    }
}