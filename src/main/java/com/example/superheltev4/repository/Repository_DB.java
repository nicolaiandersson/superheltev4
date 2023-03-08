package com.example.superheltev4.repository;
import com.example.superheltev4.dto.HeroDTO;
import com.example.superheltev4.model.Superhero;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class Repository_DB{

    @Value("${spring.datasource.url}")
    private String db_url;

    @Value("${spring.datasource.username}")
    private String uid;

    @Value("${spring.datasource.password}")
    private String pwd;

    public List<Superhero> getHeroes() {
        List<Superhero> heroes = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(db_url,uid,pwd)) {
            String sql = "SELECT * FROM superhero";
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                int ID = rs.getInt("SUPERHERO_ID");
                String heroName = rs.getString("HERO_NAME");
                String realName = rs.getString("REAL_NAME");
                int creationYear = rs.getInt("CREATION_YEAR");
                int superpowerID = rs.getInt("SUPERPOWER_ID");
                String cityID = rs.getString("CITY_ID");
                Superhero hero = new Superhero(ID, heroName, realName, creationYear, superpowerID, cityID);
                heroes.add(hero);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return heroes;
    }


    public List<Superhero> getSuperhero(String heroName) {
        List<Superhero> heroes = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(db_url,uid,pwd)) {
            String sql = "SELECT * FROM superhero WHERE HERO_NAME = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, heroName);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                int ID = rs.getInt("SUPERHERO_ID");
                String name = rs.getString("HERO_NAME");
                String realName = rs.getString("REAL_NAME");
                int creationYear = rs.getInt("CREATION_YEAR");
                int superpowerID = rs.getInt("SUPERPOWER_ID");
                String cityID = rs.getString("CITY_ID");
                Superhero hero = new Superhero(ID, name, realName, creationYear, superpowerID, cityID);
                heroes.add(hero);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return heroes;
    }
}
