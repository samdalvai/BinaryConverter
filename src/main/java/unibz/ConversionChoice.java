package unibz;

import javafx.scene.control.ChoiceBox;

public class ConversionChoice extends ChoiceBox<String> {

    public ConversionChoice() {
        String[] function_names = new String[]{"01 - Binary to Decimal",
                "02 - Binary to Hexadecimal",
                "03 - Binary to Octal",
                "04 - Decimal to Binary",
                "05 - Decimal to Hexadecimal",
                "06 - Decimal to Octal",
                "07 - Hexadecimal to Decimal",
                "08 - Hexadecimal to Binary",
                "09 - Hexadecimal to Octal",
                "10 - Octal to Decimal",
                "11 - Octal to Binary",
                "12 - Octal to Hexadecimal",
                "13 - Float to Binary",
                "14 - Float to Hexadecimal",
                "15 - Binary to Float",
                "16 - Hexadecimal to Float"};

        this.getItems().addAll(function_names);
        this.getSelectionModel().selectFirst();
        this.setStyle("-fx-font-size: 16px");
    }

    public int getFunctionIndex() {
        return this.getSelectionModel().getSelectedIndex();
    }
}
