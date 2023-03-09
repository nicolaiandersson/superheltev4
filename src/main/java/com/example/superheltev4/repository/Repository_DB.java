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
        List<HeroDTO> heroes = new ArrayList<>();
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


    public List<HeroDTO> getSuperhero(String heroSearch) {
        List<HeroDTO> results = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(db_url,uid,pwd)) {
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
                results.add(hero);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return results;
    }
}
