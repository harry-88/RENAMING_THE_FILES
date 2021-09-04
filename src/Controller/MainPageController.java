package Controller;

import ModelClasses.files;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.fxml.FXML;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.*;
import java.net.URL;
import java.util.ResourceBundle;

public class MainPageController implements Initializable {



    @FXML
    private TableView<files> filenotfoundTable;


    @FXML
    private TableColumn<files, String> col;

    @FXML
    private TextField extField;

    @FXML
    private Label label;

    @FXML
    private TextField location;

    @FXML
    private TextField renameFileLocation;

    @FXML
    private TableView<files> renameTableview1;

    @FXML
    private TableColumn<files, String> renamefrom;

    @FXML
    private TableColumn<files, String> renameto;



    @FXML
    void convert(ActionEvent event) {

        String folderName = "";
        String backSlash = "/";
        String txtFileLocation = "";
        for (int i = 0;i<location.getText().length();i++)
        {
            if (location.getText().charAt(i) == backSlash.charAt(0))
                folderName += backSlash ;
            else
                folderName += location.getText().charAt(i);
        }

        folderName += backSlash ;

        for (int i = 0;i<renameFileLocation.getText().length();i++)
        {
            if (renameFileLocation.getText().charAt(i) == backSlash.charAt(0))
                txtFileLocation += backSlash ;
            else
                txtFileLocation += renameFileLocation.getText().charAt(i);
        }
        System.out.println(txtFileLocation);
        int i = 0;

        try {
            FileReader fileReader = new FileReader(txtFileLocation);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = null;
            String[] token = null;

            while ((line = bufferedReader.readLine()) != null)
            {

                System.out.println(line);
                token = line.split(",");
                File file = new File(folderName+token[0]+"."+extField.getText());
                if (file != null) {
                    if (file.renameTo(new File(folderName + token[1] + "." + extField.getText()))) {
                        filenotfoundTable.getItems().add(new files(token[0], token[1]));
                        i++;

                        renamefrom.setCellValueFactory(new PropertyValueFactory<files, String>("previousName"));
                        renameto.setCellValueFactory(new PropertyValueFactory<files, String>("newName"));

                    }
                }
                else{
                    renameTableview1.getItems().add(new files(token[0],token[1]));
                    col.setCellValueFactory(new PropertyValueFactory<files,String>("previousName"));
                }

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }



    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        label.setVisible(false);

    }
}
