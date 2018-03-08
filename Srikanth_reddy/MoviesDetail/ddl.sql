create database MovieStore;
use MovieStore;

create table users_details(
            userId bigint auto_increment not null,
			username varchar(20),
            age int,
            primary key(userId)
            );
            
        
create table movie_details(
				movieId bigint auto_increment,
                title varchar(20),
                 genre varchar(20),
                rating float,
                addedBy bigint,
                primary key(movieId),
                foreign key(addedBy) references users_details(userId)
                );
CREATE TABLE hibernate_sequence (
  next_val bigint(20) DEFAULT NULL
);
                

        
        

	    mid int NOT NULL auto_increment,
            title varchar(20),
            genre varchar(20),
            primary key(mid));
            
