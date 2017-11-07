package com.domain.location;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CoordinateHistoryMapper implements RowMapper<CoordinateHistory> {

    @Override
    public CoordinateHistory mapRow(ResultSet rs, int rowNum) throws SQLException {
        CoordinateHistory coordinate = new CoordinateHistory();

        coordinate.setLat(rs.getDouble("lat"));
        coordinate.setLng(rs.getDouble("lng"));
        coordinate.setAccountingTiming(rs.getDouble("accountingTiming"));

        return coordinate;
    }
}
