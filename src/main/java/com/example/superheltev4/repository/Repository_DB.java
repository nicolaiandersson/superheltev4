package com.example.superheltev4.repository;

import com.example.superheltev4.dto.HeroCityDTO;
import com.example.superheltev4.dto.HeroDTO;
import com.example.superheltev4.dto.HeroPowerCountDTO;
import com.example.superheltev4.dto.HeroSuperPowerDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository("superhelt_DB")
public class Repository_DB implements IRepository {

    List<HeroDTO> heroes = new ArrayList<>();
    List<HeroDTO> heroResults = new ArrayList<>();
    List<HeroPowerCountDTO> powerCountResults = new ArrayList<>();
    List<HeroSuperPowerDTO> heroPowers = new ArrayList<>();
    List<HeroCityDTO> heroCityList = new ArrayList<>();

    private final String db_url;
    private final String uid;
    private final String pwd;

    public Repository_DB(@Value("${spring.datasource.url}") String db_url,
                         @Value("${spring.datasource.username}") String uid,
                         @Value("${spring.datasource.password}") String pwd) {
        this.db_url = db_url;
        this.uid = uid;
        this.pwd = pwd;
    }


    public List<HeroDTO> getHeroes() {

        try (Connection conn = DriverManager.getConnection(db_url, uid, pwd)) {
            String SQL = "SELECT * FROM superhero";
            PreparedStatement st = conn.prepareStatement(SQL);
            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                HeroDTO hero = new HeroDTO(
                        rs.getInt("SUPERHERO_ID"),
                        rs.getString("HERO_NAME"),
                        rs.getString("REAL_NAME"),
                        rs.getInt("CREATION_YEAR")
                );
                heroes.add(hero);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return heroes;
    }


    public List<HeroDTO> getSuperHero(String heroSearch) {

        try (Connection conn = DriverManager.getConnection(db_url, uid, pwd)) {
            String SQL = "SELECT * FROM superhero WHERE lower(HERO_NAME) LIKE ?";
            PreparedStatement st = conn.prepareStatement(SQL);
            st.setString(1, "%" + heroSearch.toLowerCase() + "%");
            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                HeroDTO hero = new HeroDTO(
                        rs.getInt("SUPERHERO_ID"),
                        rs.getString("HERO_NAME"),
                        rs.getString("REAL_NAME"),
                        rs.getInt("CREATION_YEAR")
                );
                heroResults.add(hero);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return heroResults;
    }

    public List<HeroPowerCountDTO> countHeroPowers(String heroSearch) {
        try (Connection conn = DriverManager.getConnection(db_url, uid, pwd)) {
            String SQL = "SELECT HERO_NAME, REAL_NAME, COUNT(SUPERHERO_ID) AS POWER_COUNT " +
                    "FROM superhero " +
                    "JOIN superpower ON SUPERPOWER_ID = SUPERPOWER_ID " +
                    "WHERE HERO_NAME LIKE CONCAT('%', ?, '%') " +
                    "GROUP BY HERO_NAME";

            PreparedStatement st = conn.prepareStatement(SQL);
            st.setString(1, heroSearch.toLowerCase());
            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                HeroPowerCountDTO hero = new HeroPowerCountDTO(
                        rs.getString("HERO_NAME"),
                        rs.getString("REAL_NAME"),
                        rs.getInt("POWER_COUNT")
                );
                powerCountResults.add(hero);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return powerCountResults;
    }

    public List<HeroSuperPowerDTO> getHeroPowers(String heroSearch) {
        try (Connection conn = DriverManager.getConnection(db_url, uid, pwd)) {
            String SQL = "SELECT HERO_NAME, REAL_NAME, GROUP_CONCAT(SUPERPOWER SEPARATOR ', ') AS SUPERPOWERS FROM SUPERHEROES INNER JOIN SUPERHEROPOWER USING (SUERHERO_ID)\n" +
                    "INNER JOIN SUPERPOWER USING (SUPERPOWER_ID) WHERE HERO_NAME = ? GROUP BY HERO_NAME, REAL_NAME;";

            PreparedStatement st = conn.prepareStatement(SQL);
            st.setString(1, heroSearch.toLowerCase());
            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                HeroSuperPowerDTO hero = new HeroSuperPowerDTO(
                        rs.getString("HERO_NAME"),
                        rs.getString("REAL_NAME"),
                        rs.getString("SUPERPOWER")
                );
                heroPowers.add(hero);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return heroPowers;
    }

    public List<HeroCityDTO> getHeroesCities() {
            try (Connection conn = DriverManager.getConnection(db_url, uid, pwd)) {
                String SQL = "SELECT CITY_NAME, HERO_NAME FROM SUPERHEROES INNER JOIN CITY USING(CITY_ID) WHERE CITY_NAME = ? ORDER BY CITY_NAME;";
                PreparedStatement st = conn.prepareStatement(SQL);
                ResultSet rs = st.executeQuery();

                while (rs.next()) {
                    HeroCityDTO hero = new HeroCityDTO(
                            rs.getString("HERO_NAME"),
                            rs.getString("CITY_NAME")
                    );
                    heroCityList.add(hero);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return heroCityList;
        }

}
