CREATE TABLE my_users
(
  username character varying(150) NOT NULL,
  first_name character varying(30),
  last_name character varying(30),
  password character varying(150),
  email character varying(50),
  user_status character varying(30),
  user_type character varying(30),
  cell_phone_number bigint,
  home_phone_number bigint,
  work_phone_number bigint,
  date_of_birth date,
  CONSTRAINT my_users_pkey PRIMARY KEY (username)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE users
  OWNER TO postgres;


CREATE TABLE my_user_address
(
  id serial NOT NULL,
  addr_username character varying(30) NOT NULL,
  address1 character varying(255),
  address2 character varying(255),
  city character varying(30),
  country character varying(30),
  state character varying(50),
  zip integer,
  CONSTRAINT my_user_address_pkey PRIMARY KEY (id),
  CONSTRAINT fk_my_user_address FOREIGN KEY (addr_username)
      REFERENCES my_users (username) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);
ALTER TABLE user_address
  OWNER TO postgres;