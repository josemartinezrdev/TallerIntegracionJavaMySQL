package com.tallerjavamysql.actprinciple.infrastructure;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.tallerjavamysql.actprinciple.domain.entity.ActPrinciple;
import com.tallerjavamysql.actprinciple.domain.service.ActPrincipleService;

public class ActPrincipleRepository implements ActPrincipleService {

    private Connection connection;

    public ActPrincipleRepository() {
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
    public void createActPrinciple(ActPrinciple actPrinciple) {
        try {
            String query = "INSERT INTO activeprinciple (nameap) VALUES (?)";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, actPrinciple.getNameap());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateActPrinciple(ActPrinciple actPrinciple) {
        try {
            String query = "UPDATE activeprinciple SET nameap = ? WHERE idap = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, actPrinciple.getNameap());
            ps.setInt(2, actPrinciple.getIdap());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteActPrinciple(int idap) {
        try {
            String query = "DELETE FROM activeprinciple WHERE idap = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, idap);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<ActPrinciple> findAllActPrinciples() {
        List<ActPrinciple> actPrinciples = new ArrayList<>();
        try {
            String query = "SELECT idap, nameap FROM activeprinciple ORDER BY idap ASC";
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                ActPrinciple actPrinciple = new ActPrinciple(rs.getInt("idap"), rs.getString("nameap"));
                actPrinciples.add(actPrinciple);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return actPrinciples;
    }

    @Override
    public ActPrinciple findByIdActPrinciple(int idap) {
        ActPrinciple actPrinciple = new ActPrinciple();
        try {
            String query = "SELECT idap, nameap FROM activeprinciple WHERE idap = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, idap);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                actPrinciple.setIdap(rs.getInt("idap"));
                actPrinciple.setNameap(rs.getString("nameap"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return actPrinciple;
    }

}
