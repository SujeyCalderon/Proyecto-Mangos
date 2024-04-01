package com.sujey.mangos.controllers;

import com.sujey.mangos.Login;
import com.sujey.mangos.models.Administracion;
import com.sujey.mangos.models.Venta;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.cell.TextFieldListCell;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class VentaMostrarController {

    @FXML
    private Button Agregar;
    @FXML
    private Button Modificar;

    @FXML
    private Button Eliminar;
    @FXML
    private Button Actualizar;

    @FXML
    private ListView<String> List4;

    @FXML
    private Button Mostrar;

    @FXML
    private Button Ver;

    @FXML
    private Button offWindow;

    @FXML
    void MouseClickAgregar(MouseEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(Login.class.getResource("VentaAgregar-view-fxml.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage callAgregar = new Stage();
            callAgregar.setTitle("Agregar ventas");
            callAgregar.setScene(scene);
            callAgregar.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }



    @FXML
    void MouseClickMostrar(MouseEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(Login.class.getResource("ventaMostrar-view-fxml.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage callAgregar = new Stage();
            callAgregar.setTitle("Mostar ventas");
            callAgregar.setScene(scene);
            callAgregar.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void MouseClickVer(MouseEvent event) {
        Administracion admi = Login.getAdmin();
        ArrayList<Venta> listVenta = admi.getListVenta();

        List4.getItems().clear();

        for (Venta venta : listVenta) {
            if (!admi.esEliminado(listVenta.indexOf(venta))) {
                List4.getItems().add(venta.toString());
            }
        }

    }

    @FXML
    void MouseClickModificar(MouseEvent event) {
        int indiceSeleccionado = List4.getSelectionModel().getSelectedIndex();


        if (indiceSeleccionado != -1) {

            String ventaSeleccionada = List4.getItems().get(indiceSeleccionado);

            System.out.println("Venta seleccionada para modificar: " + ventaSeleccionada);
        }
    }

    @FXML
    void MouseClickEliminar(MouseEvent event) {
        int indiceSeleccionado = List4.getSelectionModel().getSelectedIndex();

        if (indiceSeleccionado != -1) {
            Administracion admi = Login.getAdmin();
            admi.getListVenta().remove(indiceSeleccionado);
            List4.getItems().remove(indiceSeleccionado);
            mostrarMensajeEliminar();
        }
    }

    private void mostrarMensajeEliminar() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("ELIMINADO");
        alert.setHeaderText(null);
        alert.setContentText("LA VENTA SE HA ELIMINADO CORRECTAMENTE.");
        alert.showAndWait();
    }




    @FXML
    void MouseClickoffWindow(MouseEvent event) {
        Stage stage = (Stage) offWindow.getScene().getWindow();
        stage.close();
    }


}
