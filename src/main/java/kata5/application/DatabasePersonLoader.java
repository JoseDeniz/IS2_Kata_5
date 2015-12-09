package kata5.application;

import kata5.model.Mail;
import kata5.model.Person;
import kata5.view.process.Loader;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static java.util.Collections.EMPTY_LIST;

public class DatabasePersonLoader implements Loader {

    private final Connection connection;

    public DatabasePersonLoader(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<Person> load(){
        try {
            return processPeople(connection.createStatement().executeQuery("SELECT * FROM people"));
        } catch (SQLException ex) {
            ex.printStackTrace();
            return EMPTY_LIST;
        }

    }

    private List<Person> processPeople(ResultSet resultSet) throws SQLException {
        List<Person> people = new ArrayList<>();
        while(resultSet.next())
            people.add(processPerson(resultSet));
        return people;
    }

    private Person processPerson(ResultSet resultSet) throws SQLException {
        return new Person(resultSet.getString("first_name"),
                          new Mail(resultSet.getString("email")),
                          resultSet.getInt("phone1"));
    }

}
