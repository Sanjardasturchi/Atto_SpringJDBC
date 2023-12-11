package org.example.repository;

import org.example.db.DatabaseUtil;
import org.example.dto.ProfileDTO;
import org.example.enums.ProfileRole;
import org.example.enums.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;
@Repository
public class ProfileRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public ProfileDTO login(ProfileDTO profileDTO) {
        String sql = "select * from profile where phone=? and password=?";
        List<ProfileDTO> profiles = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(ProfileDTO.class),profileDTO.getPhone(),profileDTO.getPassword());
        return profiles.get(0);
//        try {
//            Connection connection = DatabaseUtil.getConnection();
//            String sql = "select * from profile where phone=? and password=?";
//
//            PreparedStatement preparedStatement = connection.prepareStatement(sql);
//
//            preparedStatement.setString(1, profileDTO.getPhone());
//            preparedStatement.setString(2, profileDTO.getPassword());
//            ResultSet resultSet = preparedStatement.executeQuery();
//            if (resultSet.next()) {
//                ProfileDTO profile = new ProfileDTO();
//                profile.setName(resultSet.getString("name"));
//                profile.setSurname(resultSet.getString("surname"));
//                profile.setPhone(resultSet.getString("phone"));
//                profile.setPassword(resultSet.getString("password"));
//                profile.setCreated_date(resultSet.getTimestamp("created_date").toLocalDateTime());
//                profile.setStatus(Status.valueOf(resultSet.getString("status")));
//                profile.setProfileRole(ProfileRole.valueOf(resultSet.getString("profile_role")));
//                connection.close();
//                return profile;
//            }
//
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//        return null;
    }

    public boolean registration(ProfileDTO profile) {
        String sql = "insert into profile(name,surname,phone,password,profile_role) values (?,?,?,?,?)";
        int res = jdbcTemplate.update(sql, profile.getName(), profile.getSurname(), profile.getPhone(), profile.getPassword(), profile.getProfileRole().toString());
//        int res = 0;
//        try {
//            Connection connection = DatabaseUtil.getConnection();
//            String sql = "insert into profile(name,surname,phone,password,profile_role) values (?,?,?,?,?)";
//
//            PreparedStatement preparedStatement = connection.prepareStatement(sql);
//
//            preparedStatement.setString(1, profile.getName());
//            preparedStatement.setString(2, profile.getSurname());
//            preparedStatement.setString(3, profile.getPhone());
//            preparedStatement.setString(4, profile.getPassword());
//            preparedStatement.setString(5, profile.getProfileRole().toString());
//            res = preparedStatement.executeUpdate();
//            connection.close();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
        return res != 0;

    }

    public List<ProfileDTO> getProfileList() {
        return jdbcTemplate.query("select * from profile",new BeanPropertyRowMapper<>(ProfileDTO.class));
//        List<ProfileDTO> profiles = new LinkedList<>();
//        try {
//            Connection connection = DatabaseUtil.getConnection();
//            Statement statement = connection.createStatement();
//            ResultSet resultSet = statement.executeQuery("select * from profile");
//            while (resultSet.next()) {
//                ProfileDTO profile = new ProfileDTO();
//                profile.setName(resultSet.getString("name"));
//                profile.setSurname(resultSet.getString("surname"));
//                profile.setPhone(resultSet.getString("phone"));
//                profile.setPassword(resultSet.getString("password"));
//                profile.setCreated_date(resultSet.getTimestamp("created_date").toLocalDateTime());
//                profile.setStatus(Status.valueOf(resultSet.getString("status")));
//                profile.setProfileRole(ProfileRole.valueOf(resultSet.getString("profile_role")));
//                profiles.add(profile);
//            }
//            connection.close();
//
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//        return profiles;
    }
}
