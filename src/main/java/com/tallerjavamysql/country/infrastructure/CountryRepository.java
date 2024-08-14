package com.tallerjavamysql.country.infrastructure;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.tallerjavamysql.country.domain.entity.Country;
import com.tallerjavamysql.country.domain.service.CountryService;

public class CountryRepository implements CountryService {

    private Connection connection;

    public CountryRepository() {
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
    public void createCountry(Country country) {
        try {
            String query = "INSERT INTO country (codecountry, namecountry) VALUES (?, ?)";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, country.getCodecountry());
            ps.setString(2, country.getNamecountry());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateCountry(Country country, String codecountry) {
        try {
            String query = "UPDATE country SET codecountry = ?, namecountry = ? WHERE codecountry = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, country.getCodecountry());
            ps.setString(2, country.getNamecountry());
            ps.setString(3, codecountry);
            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteCountry(String codecountry) {
        try {
            String query = "DELETE FROM country WHERE codecountry = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, codecountry);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Country> findAllCountries() {
        List<Country> countries = new ArrayList<>();
        try {
            String query = "SELECT codecountry, namecountry FROM country";
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                Country country = new Country(rs.getString("codecountry"), rs.getString("namecountry"));
                countries.add(country);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return countries;
    }

    @Override
    public Country findByIdCountry(String codecountry) {
        Country country = new Country();
        try {
            String query = "SELECT codecountry, namecountry FROM country WHERE codecountry = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, codecountry);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                country.setCodecountry(rs.getString("codecountry"));
                country.setNamecountry(rs.getString("namecountry"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return country;
    }

}
