package com.doctorappointment;

import java.sql.Connection;
import java.sql.SQLException;

public interface readTab {
    public void readTable(Connection conn, String table_name, String IIN);
}