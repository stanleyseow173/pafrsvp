package sg.edu.nus.iss.pafrsvp.repository;

public class Queries {
    public static final String SQL_INSERT_RSVP="""
        INSERT INTO rsvp (name, email, phone, confirmation_date, comments, food_type) VALUES (?,?,?,?,?,?)
        """
        ;
}
