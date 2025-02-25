package com.spring.bank.repository;

import com.spring.bank.model.Card;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class H2Storage implements CardRepository{
    private static final String JDBC_URL = "jdbc:h2:mem:bank;DB_CLOSE_DELAY=-1";
    private static final String USER = "sa";
    private static final String PASSWORD = "";

    public H2Storage() {
        try (Connection connection = DriverManager.getConnection(JDBC_URL, USER, PASSWORD);
             Statement statement = connection.createStatement()) {
            statement.execute("CREATE TABLE IF NOT EXISTS cards (cardNumber VARCHAR PRIMARY KEY, pin INT, balance DOUBLE)");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void saveCard(Card card) {
        try (Connection connection = DriverManager.getConnection(JDBC_URL, USER, PASSWORD);
             PreparedStatement ps = connection.prepareStatement("INSERT INTO cards (cardNumber, pin, balance) VALUES (?, ?, ?)")) {
            ps.setString(1, card.getCardNumber());
            ps.setInt(2, card.getPin());
            ps.setDouble(3, card.getBalance());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @Override
    public Card findCardByNumber(String cardNumber) {
        try (Connection connection = DriverManager.getConnection(JDBC_URL, USER, PASSWORD);
             PreparedStatement ps = connection.prepareStatement("SELECT * FROM cards WHERE cardNumber = ?")) {
            ps.setString(1, cardNumber);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Card(rs.getString("cardNumber"), rs.getInt("pin"), rs.getDouble("balance"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
