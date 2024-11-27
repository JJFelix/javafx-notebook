package com.example.lesalonproject;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProcessorDAO{
    public static ObservableList<Processor> getProcessors() throws SQLException {
        ObservableList<Processor> processors = FXCollections.observableArrayList();
        String query = "SELECT * FROM Processor";

        try (Connection conn = DatabaseHelper.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                processors.add(new Processor(
                        rs.getInt("id"),
                        rs.getString("manufacturer"),
                        rs.getString("type")
                ));
            }
        }

        return processors;
    }
}
