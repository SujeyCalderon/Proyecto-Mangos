package com.sujey.mangos.controllers;

import com.sujey.mangos.Login;
import com.sujey.mangos.models.Actividad;
import com.sujey.mangos.models.Administracion;
import com.sujey.mangos.models.Combustible;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class CombustibleMostrarController {

    @FXML
    private Button Agregar;


    @FXML
    private Button Eliminar;
    @FXML
    private Button Modificar;

    @FXML
    private ListView<String> Lista3;

    @FXML
    private Button Mostrar;

    @FXML
    private Button Ver;

    @FXML
    private Button offWindow;

    @FXML
    void MouseClickAgregar(MouseEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(Login.class.getResource("combustibleAgregar-view-fxml.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage callAgregar = new Stage();
            callAgregar.setTitle("Agregar combustibles");
            callAgregar.setScene(scene);
            callAgregar.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }



    @FXML
    void MouseClickEliminar(MouseEvent event) {
        int indiceSeleccionado = Lista3.getSelectionModel().getSelectedIndex();

        if (indiceSeleccionado != -1) {
            Administracion admi = Login.getAdmin();
            admi.getListActividad().remove(indiceSeleccionado);
            Lista3.getItems().remove(indiceSeleccionado);
            mostrarMensajeEliminar();
        }
    }
    private void mostrarMensajeEliminar() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("ELIMINADO");
        alert.setHeaderText(null);
        alert.setContentText("LA ACTIVIDAD SE HA ELIMINADO CORRECTAMENTE.");
        alert.showAndWait();
    }


    @FXML
    void MouseClickModificar(MouseEvent event) {
        int indiceSeleccionado = Lista3.getSelectionModel().getSelectedIndex();

        if (indiceSeleccionado != -1) {
            Administracion admi = Login.getAdmin();
            ArrayList<Combustible> listCombustible = admi.getListCombustible();
            Combustible combustibleSeleccionada = listCombustible.get(indiceSeleccionado);

            try {
                FXMLLoader fxmlLoader = new FXMLLoader(Login.class.getResource("combustibleAgregar-view-fxml.fxml"));
                Scene scene = new Scene(fxmlLoader.load());
                Stage modificarStage = new Stage();
                modificarStage.setTitle("Modificar Combustible");
                modificarStage.setScene(scene);

                CombustibleAgregarController controller = fxmlLoader.getController();

                controller.Texto.setText(combustibleSeleccionada.getNombre());
                controller.Texto2.setText(combustibleSeleccionada.getFecha());
                controller.Texto3.setText(combustibleSeleccionada.getDescripcion());
                controller.Texto4.setText(String.valueOf (combustibleSeleccionada.getCosto()));
                controller.Texto41.setText(combustibleSeleccionada.getMaquinaria());

                admi.getListCombustible().remove(indiceSeleccionado);
                Lista3.getItems().remove(indiceSeleccionado);

                modificarStage.showAndWait();

                combustibleSeleccionada.setNombre(controller.Texto.getText());
                combustibleSeleccionada.setFecha(controller.Texto2.getText());
                combustibleSeleccionada.setDescripcion(controller.Texto3.getText());
                combustibleSeleccionada.setCosto(Double.parseDouble(controller.Texto4.getText()));
                combustibleSeleccionada.setMaquinaria(controller.Texto41.getText());


                listCombustible.set(indiceSeleccionado, combustibleSeleccionada);

                Lista3.getItems().add(indiceSeleccionado, combustibleSeleccionada.toString());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @FXML
    void MouseClickMostrar(MouseEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(Login.class.getResource("combustibleMostrar-view-fxml.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage callAgregar = new Stage();
            callAgregar.setTitle("Mostrar combustibles");
            callAgregar.setScene(scene);
            callAgregar.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void MouseClickVer(MouseEvent event) {
        Administracion admi = Login.getAdmin();
        ArrayList<Combustible> listCombustible = admi.getListCombustible();

        Lista3.getItems().clear();

        Set<Integer> indicesModificados = new HashSet<>();

        for (Combustible combustible : listCombustible) {
            int indice = listCombustible.indexOf(combustible);
            if (!admi.esEliminado(indice) && !indicesModificados.contains(indice)) {
                Lista3.getItems().add(combustible.toString());
            }
        }
    }

    @FXML
    void MouseClickoffWindow(MouseEvent event) {
        Stage stage = (Stage) offWindow.getScene().getWindow();
        stage.close();
    }

}
