DROP DATABASE IF EXISTS online_traffic_system;

CREATE DATABASE IF NOT EXISTS online_traffic_system;

USE online_traffic_system;


CREATE TABLE officer (
                         officer_id INT NOT NULL AUTO_INCREMENT,
                         officer_name VARCHAR(255) NOT NULL,
                         branch VARCHAR(255) NOT NULL,
                         username VARCHAR(255) NOT NULL,
                         password VARCHAR(255) NOT NULL,
                         PRIMARY KEY (officer_id)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4;


CREATE TABLE route (
                       route_id INT NOT NULL AUTO_INCREMENT,
                       route_name VARCHAR(255) NOT NULL,
                       location VARCHAR(255) NOT NULL,
                       PRIMARY KEY (route_id)
);

CREATE TABLE vehicle (
                         vehicle_id varchar(255) NOT NULL,
                         make varchar(255) NOT NULL,
                         model varchar(255) NOT NULL,
                         year int NOT NULL,
                         owner_name varchar(255) NOT NULL,
                         PRIMARY KEY (vehicle_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;



CREATE TABLE `incident` (
                            `incident_id` int(11) NOT NULL AUTO_INCREMENT,
                            `incident_date` varchar(255) NOT NULL,
                            `route_id` int(11) NOT NULL,
                            `vehicle_id` varchar(255) NOT NULL,
                            `description` varchar(255) NOT NULL,
                            `officer_id` int(11) NOT NULL,
                            PRIMARY KEY (`incident_id`),
                            KEY `FK_Route` (`route_id`),
                            KEY `FK_Vehicle` (`vehicle_id`),
                            KEY `FK_Officer` (`officer_id`),
                            CONSTRAINT `FK_Officer` FOREIGN KEY (`officer_id`) REFERENCES `officer` (`officer_id`),
                            CONSTRAINT `FK_Route` FOREIGN KEY (`route_id`) REFERENCES `route` (`route_id`),
                            CONSTRAINT `FK_Vehicle` FOREIGN KEY (`vehicle_id`) REFERENCES `vehicle` (`vehicle_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4;