package kata5.application;

import kata5.model.Histogram;
import kata5.model.Person;
import kata5.view.process.HistogramBuilder;
import kata5.view.ui.Displayable;
import org.sqlite.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import static java.util.Arrays.stream;

public class Application {

    public static void main(String[] args) throws SQLException {
        List<Person> people = new DatabasePersonLoader(createConnection("src/main/resources/people.db")).load();
        HistogramBuilder<Person> builder = new HistogramBuilder<>(people);

        Histogram<String> domainHistogram = builder.build(person -> person.getMail().getDomain());
        Histogram<Integer> phoneNumberHistogram = builder.build(Person::getPhoneNumber);

        displayHistograms(new HistogramDisplay<>(domainHistogram, "Domains"),
                          new HistogramDisplay<>(phoneNumberHistogram, "Phone Numbers"));
    }

    private static void displayHistograms(Displayable... displays) {
        stream(displays).forEach(Displayable::display);
    }

    private static Connection createConnection(String dbPath) throws SQLException {
        DriverManager.registerDriver(new JDBC());
        return DriverManager.getConnection("jdbc:sqlite:" + dbPath);
    }

}
