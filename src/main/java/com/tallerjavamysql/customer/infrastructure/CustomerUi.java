package com.tallerjavamysql.customer.infrastructure;

import java.awt.Dimension;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.tallerjavamysql.customer.domain.entity.Customer;
import com.tallerjavamysql.customer.application.CreateCustomerUseCase;
import com.tallerjavamysql.customer.application.DeleteCustomerUseCase;
import com.tallerjavamysql.customer.application.FindAllCustomerUseCase;
import com.tallerjavamysql.customer.application.FindByIdCustomerUseCase;
import com.tallerjavamysql.customer.application.UpdateCustomerUseCase;
import com.tallerjavamysql.customer.domain.service.CustomerService;

public class CustomerUi {
    private CustomerService customerService;

    private CreateCustomerUseCase createCustomerUseCase;
    private UpdateCustomerUseCase updateCustomerUseCase;
    private DeleteCustomerUseCase deleteCustomerUseCase;
    private FindAllCustomerUseCase findAllCustomerUseCase;
    private FindByIdCustomerUseCase findByIdCustomerUseCase;

    public CustomerUi() {
        this.customerService = new CustomerRepository();
        this.createCustomerUseCase = new CreateCustomerUseCase(customerService);
        this.updateCustomerUseCase = new UpdateCustomerUseCase(customerService);
        this.deleteCustomerUseCase = new DeleteCustomerUseCase(customerService);
        this.findAllCustomerUseCase = new FindAllCustomerUseCase(customerService);
        this.findByIdCustomerUseCase = new FindByIdCustomerUseCase(customerService);
    }

    public void menuCustomer() {
        String opts = "1. Add Customer\n2. Update Customer\n3. Delete Customer\n4. Search Customer\n5. Search Customeres\n6. Return";
        int opt = 0;
        do {
            try {
                opt = Integer.parseInt(JOptionPane.showInputDialog(null, opts));
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error en el dato ingresado");
                continue;
            }
            switch (opt) {
                case 1:
                    createCustomer();
                    break;
                case 2:
                    updateCustomer();
                    break;
                case 3:
                    deleteCustomer();
                    break;
                case 4:
                    findByIdCustomer();
                    break;
                case 5:
                    findAllCustomeres();
                    break;
                case 6:
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Error en la opcion elegida");
                    break;
            }
        } while (opt != 6);
    }

    public void createCustomer() {
        Customer customer = new Customer();
        customer.setIdcustomer(JOptionPane.showInputDialog(null, "Ingrese el ID del customer"));
        customer.setNamecustomer(JOptionPane.showInputDialog(null, "Ingrese el nombre del customer"));
        customer.setLasnamecustomer(JOptionPane.showInputDialog(null, "Ingrese el apellido del customer"));
        customer.setEmailcustomer(JOptionPane.showInputDialog(null, "Ingrese el email del customer"));
        customer.setBirthdate(
                JOptionPane.showInputDialog(null, "Ingrese la fecha de nacimiento del customer (yyyy-mm-dd)"));
        customer.setLongitud(Float.parseFloat(JOptionPane.showInputDialog(null, "Ingrese la longitud del customer")));
        customer.setLatitud(Float.parseFloat(JOptionPane.showInputDialog(null, "Ingrese la latitud del customer")));
        customer.setCodecitycustomer(JOptionPane.showInputDialog(null, "Ingrese el codigo de la ciudad del customer"));
        createCustomerUseCase.execute(customer);
    }

    public void showByIdCustomer(Customer customer) {
        String[] columns = { "ID", "Nombre", "Apellido", "Email", "Nacimiento", "Long", "Lati", "Código City" };
        DefaultTableModel model = new DefaultTableModel(columns, 0);
        Object[] row = {
                customer.getIdcustomer(),
                customer.getNamecustomer(),
                customer.getLasnamecustomer(),
                customer.getEmailcustomer(),
                customer.getBirthdate(),
                customer.getLongitud(),
                customer.getLatitud(),
                customer.getCodecitycustomer() };
        model.addRow(row);

        JTable table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        JPanel panel = new JPanel();
        panel.add(scrollPane);

        table.setPreferredSize(new Dimension(800, 400));
        scrollPane.setPreferredSize(new Dimension(800, 400));
        panel.setPreferredSize(new Dimension(800, 400));

        JOptionPane.showMessageDialog(null, panel, "Customer By Id", JOptionPane.PLAIN_MESSAGE);
    }

    public Object[] findByIdCustomer() {
        String idcustomer = JOptionPane.showInputDialog(null, "Ingresa el ID del customer");
        Customer customer = findByIdCustomerUseCase.execute(idcustomer);
        showByIdCustomer(customer);
        return new Object[] { customer, idcustomer };
    }

    public void updateCustomer() {
        Object[] result = findByIdCustomer();
        Customer customer = (Customer) result[0];
        String idcustomer = (String) result[1];

        customer.setIdcustomer(JOptionPane.showInputDialog(null, "Ingrese el ID del customer"));
        customer.setNamecustomer(JOptionPane.showInputDialog(null, "Ingrese el nombre del customer"));
        customer.setLasnamecustomer(JOptionPane.showInputDialog(null, "Ingrese el apellido del customer"));
        customer.setEmailcustomer(JOptionPane.showInputDialog(null, "Ingrese el email del customer"));
        customer.setBirthdate(
                JOptionPane.showInputDialog(null, "Ingrese la fecha de nacimiento del customer (yyyy-mm-dd)"));
        customer.setLongitud(Float.parseFloat(JOptionPane.showInputDialog(null, "Ingrese la longitud del customer")));
        customer.setLatitud(Float.parseFloat(JOptionPane.showInputDialog(null, "Ingrese la latitud del customer")));
        customer.setCodecitycustomer(JOptionPane.showInputDialog(null, "Ingrese el codigo de la ciudad del customer"));

        updateCustomerUseCase.execute(customer, idcustomer);
    }

    public void deleteCustomer() {
        Object[] result = findByIdCustomer();
        Customer customer = (Customer) result[0];
        deleteCustomerUseCase.execute(customer.getIdcustomer());
    }

    public void showAllCustomers(List<Customer> customers) {
        String[] columns = { "ID", "Nombre", "Apellido", "Email", "Nacimiento", "Long", "Lati", "Código City" };

        DefaultTableModel model = new DefaultTableModel(columns, 0);

        customers.forEach(customer -> {
            Object[] row = {
                    customer.getIdcustomer(),
                    customer.getNamecustomer(),
                    customer.getLasnamecustomer(),
                    customer.getEmailcustomer(),
                    customer.getBirthdate(),
                    customer.getLongitud(),
                    customer.getLatitud(),
                    customer.getCodecitycustomer() };
            model.addRow(row);
        });

        JTable table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        JPanel panel = new JPanel();
        panel.add(scrollPane);

        table.setPreferredSize(new Dimension(800, 400));
        scrollPane.setPreferredSize(new Dimension(800, 400));
        panel.setPreferredSize(new Dimension(800, 400));

        JOptionPane.showMessageDialog(null, panel, "Customers List", JOptionPane.PLAIN_MESSAGE);
    }

    public void findAllCustomeres() {
        List<Customer> customers = findAllCustomerUseCase.execute();
        showAllCustomers(customers);
    }
}
