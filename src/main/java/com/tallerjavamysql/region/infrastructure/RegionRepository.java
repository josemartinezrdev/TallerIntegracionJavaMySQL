package com.tallerjavamysql.region.infrastructure;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import com.tallerjavamysql.region.domain.entity.Region;
import com.tallerjavamysql.region.domain.service.RegionService;

public class RegionRepository implements RegionService {

    private Connection connection;

    public RegionRepository() {
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
    public void createRegion(Region region) {
        try {
            String query = "INSERT INTO region (codereg, namereg, codecountry) VALUES (?, ?, ?)";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, region.getCodereg());
            ps.setString(2, region.getNamereg());
            ps.setString(3, region.getCodecountry());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateRegion(Region region, String codereg) {
        try {
            String query = "UPDATE region SET codereg = ?, namereg = ?, codecountry = ? WHERE codereg = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, region.getCodereg());
            ps.setString(2, region.getNamereg());
            ps.setString(3, region.getCodecountry());

            ps.setString(4, codereg);
            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteRegion(String codereg) {
        try {
            String query = "DELETE FROM region WHERE codereg = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, codereg);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Region> findAllRegions() {
        List<Region> regions = new ArrayList<>();
        try {
            String query = "SELECT codereg, namereg, codecountry FROM region";
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                Region region = new Region(rs.getString("codereg"), rs.getString("namereg"),
                        rs.getString("codecountry"));
                regions.add(region);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return regions;
    }

    @Override
    public Region findByIdRegion(String codereg) {
        Region region = new Region();
        try {
            String query = "SELECT codereg, namereg, codecountry FROM region WHERE codereg = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, codereg);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                region.setCodereg(rs.getString("codereg"));
                region.setNamereg(rs.getString("namereg"));
                region.setCodecountry(rs.getString("codecountry"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return region;
    }

}
