package unibz;

import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;

public class BinaryConverterGUI extends GridPane {

    private final TextField input;
    private final TextField output;
    private final ConversionChoice conversionchoice;

    public BinaryConverterGUI() {
        Font title_font = Font.font("Times", FontWeight.BOLD, FontPosture.ITALIC, 30.0D);

        Label title = new Label("Binary Converter");
        title.setFont(title_font);
        title.setPadding(new Insets(10.0D, 10.0D, 20.0D, 10.0D));
        title.setAlignment(Pos.CENTER);

        Label inputTitle = new Label("Input: ");
        inputTitle.setFont(new Font(18.0D));
        inputTitle.setAlignment(Pos.CENTER);

        this.input = new TextField();
        this.input.setFont(new Font(18.0D));
        this.input.setPrefHeight(40.0D);
        this.input.setMaxWidth(365.0D);
        this.input.setAlignment(Pos.CENTER_LEFT);
        this.input.setOnAction(this::conversion);

        Label outputTitle = new Label("Output: ");
        outputTitle.setFont(new Font(18.0D));
        outputTitle.setAlignment(Pos.CENTER);

        this.output = new TextField();
        this.output.setFont(new Font(18.0D));
        this.output.setPrefHeight(40.0D);
        this.output.setMaxWidth(365.0D);
        this.output.setEditable(false);
        //this.output.setMouseTransparent(true);
        this.output.setAlignment(Pos.CENTER_LEFT);

        Label functionTitle = new Label("Select the\nfunction: ");
        functionTitle.setFont(new Font(15.0D));
        functionTitle.setAlignment(Pos.CENTER);

        this.conversionchoice = new ConversionChoice();
        this.conversionchoice.setPrefWidth(250.0D);
        this.conversionchoice.setPrefHeight(40.0D);

        Button compute = new Button("COMPUTE");
        compute.setFont(new Font(18.0D));
        compute.setMaxWidth(200.0D);
        compute.setAlignment(Pos.CENTER_LEFT);
        compute.setOnAction(this::conversion);

        this.setAlignment(Pos.CENTER);
        this.setHgap(10.0D);
        this.setVgap(25.0D);
        setColumnSpan(title, 3);

        this.add(title, 0, 0);
        this.add(inputTitle, 0, 1);
        this.add(this.input, 1, 1);
        setColumnSpan(this.input, 3);

        this.add(functionTitle, 0, 2);
        this.add(this.conversionchoice, 1, 2);
        this.add(compute, 2, 2);
        this.add(outputTitle, 0, 3);
        this.add(this.output, 1, 3);
        setColumnSpan(this.output, 3);
    }

    private void conversion(ActionEvent event) {
        if (this.input.getText().isEmpty()) {
            this.output.setText("ERROR, INPUT IS EMPTY...");
        } else {
            String in = this.input.getText();

            try {
                if (this.conversionchoice.getFunctionIndex() == 0) {
                    this.output.setText(Functions.binaryToDecimal(in));
                } else if (this.conversionchoice.getFunctionIndex() == 1) {
                    this.output.setText(Functions.binaryToHexadecimal(in));
                } else if (this.conversionchoice.getFunctionIndex() == 2) {
                    this.output.setText(Functions.binaryToOctal(in));
                } else if (this.conversionchoice.getFunctionIndex() == 3) {
                    this.output.setText(Functions.decimalToBinary(in));
                } else if (this.conversionchoice.getFunctionIndex() == 4) {
                    this.output.setText(Functions.decimalToHexadecimal(in));
                } else if (this.conversionchoice.getFunctionIndex() == 5) {
                    this.output.setText(Functions.decimalToOctal(in));
                } else if (this.conversionchoice.getFunctionIndex() == 6) {
                    this.output.setText(Functions.hexadecimalToDecimal(in));
                } else if (this.conversionchoice.getFunctionIndex() == 7) {
                    this.output.setText(Functions.hexadecimalToBinary(in));
                } else if (this.conversionchoice.getFunctionIndex() == 8) {
                    this.output.setText(Functions.hexadecimalToOctal(in));
                } else if (this.conversionchoice.getFunctionIndex() == 9) {
                    this.output.setText(Functions.octalToDecimal(in));
                } else if (this.conversionchoice.getFunctionIndex() == 10) {
                    this.output.setText(Functions.octalToBinary(in));
                } else if (this.conversionchoice.getFunctionIndex() == 11) {
                    this.output.setText(Functions.octalToHexadecimal(in));
                } else if (this.conversionchoice.getFunctionIndex() == 12) {
                    this.output.setText(FloatingPoint.floatToBinary(in));
                } else if (this.conversionchoice.getFunctionIndex() == 13) {
                    this.output.setText(FloatingPoint.floatToHexadecimal(in));
                } else if (this.conversionchoice.getFunctionIndex() == 14) {
                    this.output.setText(FloatingPoint.binaryToFloat(in));
                } else {
                    if (this.conversionchoice.getFunctionIndex() != 15) {
                        throw new Exception("ERROR, INVALID FUNCTION...");
                    }

                    this.output.setText(FloatingPoint.hexadecimalToFloat(in));
                }
            } catch (NumberFormatException var4) {
                this.output.setText("ERROR, INVALID INPUT...");
            } catch (Exception var5) {
                this.output.setText("ERROR, UNKNOWN EXEPTION...");
            }
        }

    }
}