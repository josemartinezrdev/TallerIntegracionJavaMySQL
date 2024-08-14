package com.tallerjavamysql.customer.infrastructure;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import com.tallerjavamysql.customer.domain.entity.Customer;
import com.tallerjavamysql.customer.domain.service.CustomerService;

public class CustomerRepository implements CustomerService {

    private Connection connection;

    public CustomerRepository() {
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
    public void createCustomer(Customer customer) {
        try {
            String query = """
                    INSERT INTO customer (
                        idcustomer, namecustomer, lastnamecustomer, emailcustomer,
                        birthdate, longitud, latitud, codecitycustomer)
                        VALUES (?, ?, ?, ?, ?, ?, ?, ?)
                    """;
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, customer.getIdcustomer());
            ps.setString(2, customer.getNamecustomer());
            ps.setString(3, customer.getLasnamecustomer());
            ps.setString(4, customer.getEmailcustomer());
            ps.setString(5, customer.getBirthdate());
            ps.setFloat(6, customer.getLongitud());
            ps.setFloat(7, customer.getLatitud());
            ps.setString(8, customer.getCodecitycustomer());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateCustomer(Customer customer, String idcustomer) {
        try {
            String query = """
                    UPDATE customer SET idcustomer = ?, namecustomer = ?, lastnamecustomer = ?,
                    emailcustomer = ?, birthdate = ?, longitud = ?, latitud = ?, codecitycustomer = ? WHERE
                    idcustomer = ?
                    """;
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, customer.getIdcustomer());
            ps.setString(2, customer.getNamecustomer());
            ps.setString(3, customer.getLasnamecustomer());
            ps.setString(4, customer.getEmailcustomer());
            ps.setString(5, customer.getBirthdate());
            ps.setFloat(6, customer.getLongitud());
            ps.setFloat(7, customer.getLatitud());
            ps.setString(8, customer.getCodecitycustomer());

            ps.setString(9, idcustomer);
            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteCustomer(String idcustomer) {
        try {
            String query = "DELETE FROM customer WHERE idcustomer = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, idcustomer);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Customer> findAllCustomers() {
        List<Customer> customers = new ArrayList<>();
        try {
            String query = """
                    SELECT idcustomer, namecustomer, lastnamecustomer, emailcustomer,
                    birthdate, longitud, latitud, codecitycustomer FROM customer
                    """;
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                Customer customer = new Customer(
                        rs.getString("idcustomer"),
                        rs.getString("namecustomer"),
                        rs.getString("lastnamecustomer"),
                        rs.getString("emailcustomer"),
                        rs.getString("birthdate"),
                        rs.getFloat("longitud"),
                        rs.getFloat("latitud"),
                        rs.getString("codecitycustomer"));
                customers.add(customer);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return customers;
    }

    @Override
    public Customer findByIdCustomer(String idcustomer) {
        Customer customer = new Customer();
        try {
            String query = """
                    SELECT idcustomer, namecustomer, lastnamecustomer, emailcustomer,
                    birthdate, longitud, latitud, codecitycustomer FROM customer WHERE idcustomer = ?
                    """;
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, idcustomer);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                customer.setIdcustomer(rs.getString("idcustomer"));
                customer.setNamecustomer(rs.getString("namecustomer"));
                customer.setLasnamecustomer(rs.getString("lastnamecustomer"));
                customer.setEmailcustomer(rs.getString("emailcustomer"));
                customer.setBirthdate(rs.getString("birthdate"));
                customer.setLatitud(rs.getFloat("longitud"));
                customer.setLongitud(rs.getFloat("latitud"));
                customer.setCodecitycustomer(rs.getString("codecitycustomer"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return customer;
    }

}
