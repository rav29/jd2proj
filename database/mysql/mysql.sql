CREATE DATABASE project;
USE project;

CREATE TABLE users (id INT AUTO_INCREMENT, name VARCHAR(60) UNIQUE NOT NULL, password VARCHAR(20) NOT NULL, 
					email VARCHAR(40) UNIQUE NOT NULL, PRIMARY KEY(id));
                    
                    
CREATE TABLE groups (id INT AUTO_INCREMENT, name VARCHAR(60) UNIQUE NOT NULL, mentor_id INT NOT NULL, group_status VARCHAR(40) NOT NULL, max_members INT NOT NULL,
					number_of_tasks INT NOT NULL, current_task INT NOT NULL, PRIMARY KEY(id),
                    FOREIGN KEY (mentor_id) REFERENCES users(id));


CREATE TABLE groups_users (group_id INT, user_id INT, PRIMARY KEY(group_id, user_id),
								FOREIGN KEY (group_id) REFERENCES groups(id),
                                FOREIGN KEY (user_id) REFERENCES users(id));



CREATE TABLE diaries (id INT AUTO_INCREMENT, user_id INT NOT NULL, group_id INT NOT NULL, tasks_passed INT NOT NULL, tasks_to_finish INT NOT NULL, PRIMARY KEY(id),
						FOREIGN KEY (user_id) REFERENCES users(id),
            FOREIGN KEY (group_id) REFERENCES groups(id));
                    
                    
                    
CREATE TABLE group_walls (id INT AUTO_INCREMENT, group_id  INT UNIQUE NOT NULL, mentor_id INT NOT NULL, PRIMARY KEY(id),
							FOREIGN KEY(mentor_id) REFERENCES users(id));
                            
       
CREATE TABLE messages (id INT AUTO_INCREMENT, message VARCHAR(120) NOT NULL, user_id INT NOT NULL, date TIMESTAMP NOT NULL, PRIMARY KEY(id),
						FOREIGN KEY(user_id) REFERENCES users(id));
                        
CREATE TABLE fb_messages (message_id INT NOT NULL, mark INT NOT NULL, FOREIGN KEY (message_id) REFERENCES messages(id));

CREATE TABLE group_messages(message_id INT NOT NULL, group_id INT NOT NULL, FOREIGN KEY(message_id) REFERENCES messages(id),
							FOREIGN KEY (group_id) REFERENCES groups(id));
						
                    
                    
CREATE TABLE tasks (id INT AUTO_INCREMENT, group_id INT NOT NULL, mentor_id INT NOT NULL, begin_date TIMESTAMP NOT NULL, end_date TIMESTAMP NOT NULL, task VARCHAR(120) NOT NULL, PRIMARY KEY(id),
					FOREIGN KEY(mentor_id) REFERENCES users(id));
                    
			
 
 CREATE TABLE user_walls (id INT AUTO_INCREMENT, user_id INT UNIQUE NOT NULL, PRIMARY KEY(id),
							FOREIGN KEY (user_id) REFERENCES users(id));
 
                    
                    
CREATE TABLE achievements (id INT AUTO_INCREMENT, name VARCHAR(60) UNIQUE NOT NULL, 
			user_id INT NOT NULL, mentor_id INT NOT NULL, group_id INT NOT NULL, 
			PRIMARY KEY(id), FOREIGN KEY (user_id) REFERENCES users(id),
				FOREIGN KEY (mentor_id) REFERENCES users(id), 
				FOREIGN KEY (group_id) REFERENCES groups(id));
                    
				