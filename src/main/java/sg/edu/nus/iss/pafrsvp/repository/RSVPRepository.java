package sg.edu.nus.iss.pafrsvp.repository;

import java.math.BigInteger;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import sg.edu.nus.iss.pafrsvp.model.RSVP;
import static sg.edu.nus.iss.pafrsvp.repository.Queries.*;

@Repository
public class RSVPRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private MongoTemplate mongoTemplate;

    public RSVP insertRSVP(final RSVP rsvp){
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(conn -> {
            PreparedStatement ps = conn.prepareStatement(SQL_INSERT_RSVP, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, rsvp.getName());
            ps.setString(2, rsvp.getEmail());
            ps.setString(3, rsvp.getPhone());
            ps.setTimestamp(4, new Timestamp(rsvp.getConfirmationDate().toDateTime().getMillis()));
            ps.setString(5, rsvp.getComments());
            ps.setString(6, rsvp.getFoodType());
            return ps;
        }, keyHolder);


        BigInteger primaryKeyVal = (BigInteger) keyHolder.getKey();
        rsvp.setId(primaryKeyVal.intValue());
        if(rsvp.getId()>0){
            rsvp.setConfirmationDate(null);
            mongoTemplate.insert(rsvp, "rsvp");
        }

        return rsvp;
    }

}
