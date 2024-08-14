package com.tallerjavamysql.city.infrastructure;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.tallerjavamysql.city.domain.entity.City;
import com.tallerjavamysql.city.domain.service.CityService;

public class CityRepository implements CityService {

    private Connection connection;

    public CityRepository() {
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
    public void createCity(City city) {
        try {
            String query = "INSERT INTO city (codecity, namecity, codereg) VALUES (?, ?, ?)";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, city.getCodecity());
            ps.setString(2, city.getNamecity());
            ps.setString(3, city.getCodereg());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateCity(City city, String codecity) {
        try {
            String query = "UPDATE city SET codecity = ?, namecity = ?, codereg = ? WHERE codecity = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, city.getCodecity());
            ps.setString(2, city.getNamecity());
            ps.setString(3, city.getCodereg());

            ps.setString(4, codecity);
            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteCity(String codecity) {
        try {
            String query = "DELETE FROM city WHERE codecity = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, codecity);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<City> findAllCities() {
        List<City> cities = new ArrayList<>();
        try {
            String query = "SELECT codecity, namecity, codereg FROM city";
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                City city = new City(rs.getString("codecity"), rs.getString("namecity"),
                        rs.getString("codereg"));
                cities.add(city);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cities;
    }

    @Override
    public City findByIdCity(String codecity) {
        City city = new City();
        try {
            String query = "SELECT codecity, namecity, codereg FROM city WHERE codecity = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, codecity);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                city.setCodecity(rs.getString("codecity"));
                city.setNamecity(rs.getString("namecity"));
                city.setCodereg(rs.getString("codereg"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return city;
    }

}
