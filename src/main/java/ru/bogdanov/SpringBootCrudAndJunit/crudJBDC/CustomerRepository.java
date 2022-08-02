package ru.bogdanov.SpringBootCrudAndJunit.crudJBDC;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class CustomerRepository {
    private final NamedParameterJdbcTemplate template;
//    private final JdbcTemplate jdbcTemplate;

    public CustomerRepository(NamedParameterJdbcTemplate template, JdbcTemplate jdbcTemplate) {
        this.template = template;
//        this.jdbcTemplate = jdbcTemplate;
    }

    public Long createCustomer(Customer customer) {
        String sql = "INSERT INTO customer (fio, phone, address, created) VALUES (:fio, :phone, :address, :created) RETURNING ID";
        MapSqlParameterSource map = new MapSqlParameterSource()
                .addValue("fio", customer.getFio())
                .addValue("phone", customer.getPhone())
                .addValue("address", customer.getAddress())
                .addValue("created", customer.getCreated());
        return template.queryForObject(sql, map, Long.class);
    }

//    public Long createCustomer2(Customer customer) {
//        String sql = "INSERT INTO customer (fio, phone, address, created) VALUES (?, ?, ?, ?) RETURNING ID";
//        return jdbcTemplate.queryForObject(sql, Long.class, customer.getFio(), customer.getPhone(), customer.getAddress(), customer.getCreated());
//    }

    public Customer getCustomerById(long id) {
        String sql = "SELECT * FROM customer WHERE customer.id = :id";
        SqlParameterSource parameterSource = new MapSqlParameterSource("id", id);
        return template.queryForObject(sql, parameterSource, new CustomerRowMapper());
    }

    public void editCustomer(Customer customer) {
        String sql = "UPDATE customer SET fio = :fio, address = :address, phone = :phone WHERE id = :id";
        SqlParameterSource parameterSource = new MapSqlParameterSource()
                .addValue("id", customer.getId())
                .addValue("fio", customer.getFio())
                .addValue("phone", customer.getPhone())
                .addValue("address", customer.getAddress());
        template.update(sql, parameterSource);
    }

    public void deleteCustomer(long id) {
        String sql = "DELETE FROM customer WHERE id = :id";
        SqlParameterSource parameterSource = new MapSqlParameterSource("id", id);
        template.update(sql, parameterSource);
    }
}
