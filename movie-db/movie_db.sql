create table users(
			username varchar(20),
            age int,
            primary key(username));
            
            
insert into users(username,age)
values	('Rohan','23'),
		('Rahul','24'),
		('Sam','35'),
        ('Wendy','43'),
        ('Max','30');
        
create table rating(
				rid int auto_increment,
				username varchar(20),
                mid int,
                rating float,
                primary key(rid));
                
insert into rating(username,mid,rating)
values	('Rohan','1','3.5'),
		('Rahul','1','4.0'),
        ('Sam','4','2.5'),
        ('Wendy','2','3.0'),
        ('Max','4','5.0'),
        ('Rohan','2','2.0'),
        ('Sam','5','4.0'),
        ('Max','3','4.2'),
        ('Sam','2','3.2'),
        ('Rohan','3','3.0'),
        ('Rahul','3','3.0');
        
        
create table movies(
			mid int NOT NULL auto_increment,
            title varchar(20),
            genre varchar(20),
            primary key(mid));
            
insert into movies(mid,title,genre)
values	('1','furious','action'),
		('2','conjuring','horror'),
        ('3','up','comedy'),
        ('4','frozen','animation'),
        ('5','trolls','comedy');