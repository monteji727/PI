package org.example.pi;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.event.ActionEvent;  // Certifique-se de que está usando javafx.event.ActionEvent

import java.awt.*;
import java.io.IOException;
import java.net.URI;

public class HelloController {

    public Button BotaoEntrar;
    public Button BotaoCadastrar;
    @FXML
    private TextField UsuarioTXT;

    @FXML
    private PasswordField SenhaTXT;

    @FXML
    public void onEntrarClicked() {
        String usuario = UsuarioTXT.getText();
        String senha = SenhaTXT.getText();

        if (usuario.equals(UsuarioTXT) && senha.equals(SenhaTXT)) {
            showAlert("Login bem-sucedido", "Bem-vindo, " + usuario + "!");
        } else {
            showAlert("Falha no login", "Nome de usuário ou senha incorretos.");
        }
    }

    private void showAlert(String titulo, String mensagem) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensagem);
        alert.showAndWait();
    }

    @FXML
    public void omCadastroClicked(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("paginaCadastro.fxml"));
            Parent root = fxmlLoader.load();

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root, 640, 400);

            stage.setTitle("Empréstimo VK - Cadastro");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void voltarTelaLogin(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("paginaLogin.fxml"));
            Parent root = fxmlLoader.load();

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root, 640, 400);

            stage.setTitle("Empréstimo VK - Cadastro");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    public void gotoLink(ActionEvent actionEvent) {
        // URL aqui para abrir:
        String url = "https://docs.google.com/document/d/1r3z3w2721rs7Jqg07W7eNpVwm8qyVrQ9KSICxcLpeag/edit?tab=t.0";
        try {
            Desktop desktop = Desktop.isDesktopSupported() ? Desktop.getDesktop() : null;
            if (desktop != null && desktop.isSupported(Desktop.Action.BROWSE)) {
                desktop.browse(new URI(url));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}