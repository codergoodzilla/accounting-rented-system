package com.domain.accounting;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

public class AccountingHistoryMapper implements RowMapper<AccountingHistory> {

    @Override
    public AccountingHistory mapRow(ResultSet rs, int rowNum) throws SQLException {
        AccountingHistory accounting = new AccountingHistory();

        accounting.setCategoryName(rs.getString("categoryName"));
        accounting.setMarkName(rs.getString("markName"));
        accounting.setRenterFullName(rs.getString("renterFullName"));
        accounting.setLicensePlate(rs.getString("licensePlate"));

        accounting.setRentalStartDate(
                new SimpleDateFormat("MM/dd/yyyy HH:mm:ss").format(rs.getTimestamp("rentalStartDate")));
        accounting.setRentalEndDate(
                new SimpleDateFormat("MM/dd/yyyy HH:mm:ss").format(rs.getTimestamp("rentalEndDate")));

        return accounting;
    }
}
