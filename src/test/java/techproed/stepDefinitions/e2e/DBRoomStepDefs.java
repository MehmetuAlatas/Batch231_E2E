package techproed.stepDefinitions.e2e;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.sql.*;

import static org.junit.Assert.assertEquals;

public class DBRoomStepDefs {
    Connection connection;
    Statement statement;
    ResultSet resultSet;

    @Given("Admin connect to the DataBase")
    public void adminConnectToTheDataBase() throws SQLException {
      connection = DriverManager.getConnection("jdbc:postgresql://medunna.com:5432/medunna_db_v2","select_user","Medunna_pass_@6");
    }

    @When("send query for created room")
    public void sendQueryForCreatedRoom() throws SQLException {
        statement = connection.createStatement();
        resultSet = statement.executeQuery("select * from room where room_number ="+UIMedunnaStepdefs.roomNumber);
    }


    @Then("validates created room from resultset")
    public void validatesCreatedRoomFromResultset() throws SQLException {
        resultSet.next();

        assertEquals(UIMedunnaStepdefs.roomNumber,resultSet.getInt("room_number"));
        assertEquals("SUITE" ,resultSet.getString("room_type"));
        assertEquals( UIMedunnaStepdefs.expectedDescription ,resultSet.getString("description"));


    }


}
