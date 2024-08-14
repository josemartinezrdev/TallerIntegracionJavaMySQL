package com.tallerjavamysql.unitmeasure.infrastructure;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import com.tallerjavamysql.unitmeasure.domain.entity.Unit;
import com.tallerjavamysql.unitmeasure.domain.service.UnitService;

public class UnitRepository implements UnitService {
    private Connection connection;

    public UnitRepository() {
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
    public void createUnit(Unit unit) {
        try {
            String query = "INSERT INTO unitmeasurement (nameum) VALUES (?)";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, unit.getNameum());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateUnit(Unit unit) {
        try {
            String query = "UPDATE unitmeasurement SET nameum = ? WHERE idum = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, unit.getNameum());
            ps.setInt(2, unit.getIdum());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteUnit(int idum) {
        try {
            String query = "DELETE FROM unitmeasurement WHERE idum = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, idum);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Unit> findAllUnits() {
        List<Unit> units = new ArrayList<>();
        try {
            String query = "SELECT idum, nameum FROM unitmeasurement ORDER BY idum ASC";
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                Unit unit = new Unit(rs.getInt("idum"), rs.getString("nameum"));
                units.add(unit);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return units;
    }

    @Override
    public Unit findByIdUnit(int idum) {
        Unit unit = new Unit();
        try {
            String query = "SELECT idum, nameum FROM unitmeasurement WHERE idum = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, idum);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                unit.setIdum(rs.getInt("idum"));
                unit.setNameum(rs.getString("nameum"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return unit;
    }

}
