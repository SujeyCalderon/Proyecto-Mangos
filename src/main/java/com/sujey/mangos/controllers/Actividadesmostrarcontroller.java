package com.sujey.mangos.controllers;

import com.sujey.mangos.Login;
import com.sujey.mangos.models.Actividad;
import com.sujey.mangos.models.Administracion;
import com.sujey.mangos.models.Venta;
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

public class Actividadesmostrarcontroller {

    @FXML
    private Button Agregar;

    @FXML
    private Button Eliminar;

    @FXML
    private ListView<String> List;

    @FXML
    private Button Mostrar;
    @FXML
    private Button Modificar;

    @FXML
    private Button Ver;

    @FXML
    private Button offWindow;

    @FXML
    void MouseClickAgregar(MouseEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(Login.class.getResource("actividades-view-fxml.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage callAgregar = new Stage();
            callAgregar.setTitle("Agregar actividades");
            callAgregar.setScene(scene);
            callAgregar.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }



    @FXML
    void MouseClickMostrar(MouseEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(Login.class.getResource("actividadesMostrar-view-fxml.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage callAgregar = new Stage();
            callAgregar.setTitle("Mostrar actividades");
            callAgregar.setScene(scene);
            callAgregar.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void MouseClickEliminar(MouseEvent event) {
        int indiceSeleccionado = List.getSelectionModel().getSelectedIndex();

        if (indiceSeleccionado != -1) {
            Administracion admi = Login.getAdmin();
            admi.getListActividad().remove(indiceSeleccionado);
            List.getItems().remove(indiceSeleccionado);
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
        int indiceSeleccionado = List.getSelectionModel().getSelectedIndex();

        if (indiceSeleccionado != -1) {
            Administracion admi = Login.getAdmin();
            ArrayList<Actividad> listActividad = admi.getListActividad();
            Actividad ActividadSeleccionada = listActividad.get(indiceSeleccionado);

            try {
                FXMLLoader fxmlLoader = new FXMLLoader(Login.class.getResource("actividades-view-fxml.fxml"));
                Scene scene = new Scene(fxmlLoader.load());
                Stage modificarStage = new Stage();
                modificarStage.setTitle("Modificar Actividad");
                modificarStage.setScene(scene);

                ActividadesController controller = fxmlLoader.getController();

                controller.tex1.setText(ActividadSeleccionada.getFecha());
                controller.tex2.setText(ActividadSeleccionada.getNombre());
                controller.tex3.setText(String.valueOf(ActividadSeleccionada.getCosto()));
                controller.tex4.setText(ActividadSeleccionada.getCantidadHec());

                admi.getListActividad().remove(indiceSeleccionado);
                List.getItems().remove(indiceSeleccionado);

                modificarStage.showAndWait();

                ActividadSeleccionada.setFecha(controller.tex1.getText());
                ActividadSeleccionada.setFecha(controller.tex2.getText());
                ActividadSeleccionada.setCosto(Double.parseDouble(controller.tex3.getText()));
                ActividadSeleccionada.setCantidadHec(controller.tex4.getText());


                listActividad.set(indiceSeleccionado, ActividadSeleccionada);

                List.getItems().add(indiceSeleccionado, ActividadSeleccionada.toString());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
    @FXML
    void MouseClickVer(MouseEvent event) {
        Administracion admi = Login.getAdmin();
        ArrayList<Actividad> listActividad = admi.getListActividad();

        List.getItems().clear();

        Set<Integer> indicesModificados = new HashSet<>();

        for (Actividad actividad : listActividad) {
            int indice = listActividad.indexOf(actividad);
            if (!admi.esEliminado(indice) && !indicesModificados.contains(indice)) {
                List.getItems().add(actividad.toString());
            }
        }
    }

    @FXML
    void MouseClickoffWindow(MouseEvent event) {
        Stage stage = (Stage) offWindow.getScene().getWindow();
        stage.close();
    }

}
