package com.tallerjavamysql.modeadmin.infrastructure;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.tallerjavamysql.modeadmin.domain.entity.ModeAdmin;
import com.tallerjavamysql.modeadmin.domain.service.ModeAdminService;

public class ModeAdminRepository implements ModeAdminService {

    private Connection connection;

    public ModeAdminRepository() {
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
    public void createModeAdmin(ModeAdmin modeAdmin) {
        try {
            String query = "INSERT INTO modeadministration (descriptionmode) VALUES (?)";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, modeAdmin.getDescriptionmode());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateModeAdmin(ModeAdmin modeAdmin) {
        try {
            String query = "UPDATE modeadministration SET descriptionmode = ? WHERE id = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, modeAdmin.getDescriptionmode());
            ps.setInt(2, modeAdmin.getId());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteModeAdmin(int id) {
        try {
            String query = "DELETE FROM modeadministration WHERE id = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<ModeAdmin> findAllModesAdmin() {
        List<ModeAdmin> modesAdmin = new ArrayList<>();
        try {
            String query = "SELECT id, descriptionmode FROM modeadministration ORDER BY id ASC";
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                ModeAdmin modeAdmin = new ModeAdmin(rs.getInt("id"), rs.getString("descriptionmode"));
                modesAdmin.add(modeAdmin);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return modesAdmin;
    }

    @Override
    public ModeAdmin findByIdModeAdmin(int id) {
        ModeAdmin modeAdmin = new ModeAdmin();
        try {
            String query = "SELECT id, descriptionmode FROM modeadministration WHERE id = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                modeAdmin.setId(rs.getInt("id"));
                modeAdmin.setDescriptionmode(rs.getString("descriptionmode"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return modeAdmin;
    }
}
