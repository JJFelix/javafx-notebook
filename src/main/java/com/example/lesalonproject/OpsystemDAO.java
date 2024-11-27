package com.example.lesalonproject;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OpsystemDAO{
    public static ObservableList<Opsystem> getOpsystems() throws SQLException {
        ObservableList<Opsystem> opsystems = FXCollections.observableArrayList();
        String query = "SELECT * FROM Opsystem";

        try (Connection conn = DatabaseHelper.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                opsystems.add(new Opsystem(
                        rs.getInt("id"),
                        rs.getString("osname")
                ));
            }
        }

        return opsystems;
    }
}

