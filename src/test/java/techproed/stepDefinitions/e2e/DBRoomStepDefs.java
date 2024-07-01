package techproed.stepDefinitions.e2e;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.sql.*;

public class DBRoomStepDefs {
    Connection connection;

    @Given("Admin Connect to the Database")
    public void adminConnectToTheDatabase() throws SQLException {
      connection = DriverManager.getConnection("jdbc:postgresql://medunna.com:5432/medunna_db_v2","select_user","Medunna_pass_@6");
    }

    @When("send query for created room")
    public void sendQueryForCreatedRoom() throws SQLException {

      Statement statement = connection.createStatement();
      ResultSet resultSet = statement.executeQuery("select * from room where room_number = 111115114");
        resultSet.next();
    }

    @Then("validates created room from resultset")
    public void validatesCreatedRoomFromResultset() {

    }
}
