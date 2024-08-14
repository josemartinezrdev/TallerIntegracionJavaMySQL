package com.tallerjavamysql.laboratory.infrastructure;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.tallerjavamysql.laboratory.domain.entity.Laboratory;
import com.tallerjavamysql.laboratory.domain.service.LaboratoryService;

public class LaboratoryRepository implements LaboratoryService {

    private Connection connection;

    public LaboratoryRepository() {
        try {
            Properties props = new Properties();
            props.load(getClass().getClassLoader().getResourceAsStream("db.properties"));
            String url = props.getProperty("url");
            String user = props.getProperty("user");
            String password = props.getProperty("password");

            connection = DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void createLaboratory(Laboratory laboratory) {
        try {
            String query = "INSERT INTO laboratory (namelab, codecityreg) VALUES (?, ?)";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, laboratory.getNamelab());
            ps.setString(2, laboratory.getCodecityreg());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateLaboratory(Laboratory laboratory) {
        try {
            String query = "UPDATE laboratory SET namelab = ?, codecityreg = ? WHERE id = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, laboratory.getNamelab());
            ps.setString(2, laboratory.getCodecityreg());
            ps.setInt(3, laboratory.getId());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteLaboratory(int id) {
        try {
            String query = "DELETE FROM laboratory WHERE id = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Laboratory> findAllLaboratories() {
        List<Laboratory> laboratories = new ArrayList<>();
        try {
            String query = "SELECT id, namelab, codecityreg FROM laboratory ORDER BY id ASC";
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                Laboratory laboratory = new Laboratory(rs.getInt("id"),
                        rs.getString("namelab"), rs.getString("codecityreg"));
                laboratories.add(laboratory);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return laboratories;
    }

    @Override
    public Laboratory findByIdLaboratory(int id) {
        Laboratory laboratory = new Laboratory();
        try {
            String query = "SELECT id, namelab, codecityreg FROM laboratory WHERE id = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                laboratory.setId(rs.getInt("id"));
                laboratory.setNamelab(rs.getString("namelab"));
                laboratory.setCodecityreg(rs.getString("codecityreg"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return laboratory;
    }

}
