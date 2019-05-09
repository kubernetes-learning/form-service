CREATE TABLE record (
    id INT AUTO_INCREMENT PRIMARY KEY,
    form_id INT,
    submit_date DATETIME,
    submit_user_id INT
) DEFAULT CHARSET=utf8;


CREATE TABLE record_value (
    id INT AUTO_INCREMENT PRIMARY KEY,
    record_id INT,
    field_id INT,
    value VARCHAR(45)
) DEFAULT CHARSET=utf8;