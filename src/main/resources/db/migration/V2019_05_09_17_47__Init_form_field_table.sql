CREATE TABLE form (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(45),
    description VARCHAR(255),
    owner_user_id INT
) DEFAULT CHARSET=utf8;


CREATE TABLE form_field (
    id INT AUTO_INCREMENT PRIMARY KEY,
    form_id INT,
    name VARCHAR(45),
    description VARCHAR(255),
    type VARCHAR(30)
) DEFAULT CHARSET=utf8;


INSERT INTO form (id, name, description, owner_user_id) VALUES
(1, '51旅游意向表', '大家51想去哪里玩呀？', 1);

INSERT INTO form_field (id, form_id, name, description, type) VALUES
(1, 1, '姓名', '你的名字', 'INPUT'),
(2, 1, '意向地', '你想去哪里玩', 'RADIO_BUTTON');