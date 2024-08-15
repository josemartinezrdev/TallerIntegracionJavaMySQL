package com.tallerjavamysql.farmacy.infrastructure;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.tallerjavamysql.farmacy.domain.entity.Farmacy;
import com.tallerjavamysql.farmacy.domain.service.FarmacyService;

public class FarmacyRepository implements FarmacyService {

    private Connection connection;

    public FarmacyRepository() {
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
    public void createFarmacy(Farmacy farmacy) {
        try {
            String query = """
                    INSERT INTO farmacy (namefarmacy, addresfarmacy, longitud, latitud,
                    logofarmacy, codecityfarmacy) VALUES (?, ?, ?, ?, ?, ?)
                    """;
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, farmacy.getNamefarmacy());
            ps.setString(2, farmacy.getAddresfarmacy());
            ps.setFloat(3, farmacy.getLongitud());
            ps.setFloat(4, farmacy.getLatitud());
            ps.setString(5, farmacy.getLogofarmacy());
            ps.setString(6, farmacy.getCodecityfarmacy());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateFarmacy(Farmacy farmacy) {
        try {
            String query = """
                    UPDATE farmacy SET namefarmacy = ?, addresfarmacy = ?, longitud = ?, latitud = ?,
                    logofarmacy = ?, codecityfarmacy = ?
                    """;
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, farmacy.getNamefarmacy());
            ps.setString(2, farmacy.getAddresfarmacy());
            ps.setFloat(3, farmacy.getLongitud());
            ps.setFloat(4, farmacy.getLatitud());
            ps.setString(5, farmacy.getLogofarmacy());
            ps.setString(5, farmacy.getCodecityfarmacy());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteFarmacy(int idfarmacy) {
        try {
            String query = "DELETE FROM farmacy WHERE idfarmacy = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, idfarmacy);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Farmacy> findAllFarmacies() {
        List<Farmacy> pharmacies = new ArrayList<>();
        try {
            String query = """
                    SELECT idfarmacy, namefarmacy, addresfarmacy, longitud, latitud,
                    logofarmacy, codecityfarmacy FROM farmacy ORDER BY idfarmacy ASC
                    """;
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                Farmacy farmacy = new Farmacy(
                        rs.getInt("idfarmacy"),
                        rs.getString("namefarmacy"),
                        rs.getString("addresfarmacy"),
                        rs.getFloat("longitud"),
                        rs.getFloat("latitud"),
                        rs.getString("logofarmacy"),
                        rs.getString("codecityfarmacy"));
                pharmacies.add(farmacy);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return pharmacies;
    }

    @Override
    public Farmacy findByIdFarmacy(int idfarmacy) {
        Farmacy farmacy = new Farmacy();
        try {
            String query = """
                    SELECT idfarmacy, namefarmacy, addresfarmacy, longitud, latitud, logofarmacy, codecityfarmacy
                    FROM farmacy WHERE idfarmacy = ? ORDER BY idfarmacy ASC
                    """;
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, idfarmacy);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                farmacy.setIdfarmacy(rs.getInt("idfarmacy"));
                farmacy.setNamefarmacy(rs.getString("namefarmacy"));
                farmacy.setAddresfarmacy(rs.getString("addresfarmacy"));
                farmacy.setLongitud(rs.getFloat("longitud"));
                farmacy.setLatitud(rs.getFloat("latitud"));
                farmacy.setLogofarmacy(rs.getString("logofarmacy"));
                farmacy.setCodecityfarmacy(rs.getString("codecityfarmacy"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return farmacy;
    }
}
