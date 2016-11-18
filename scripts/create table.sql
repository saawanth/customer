-- Table: public."user"

-- DROP TABLE public."user";

CREATE TABLE public."user"
(
  id integer NOT NULL,
  user_firstname character varying,
  user_lastname character varying,
  user_dob date,
  CONSTRAINT "user-id_pk" PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE public."user"
  OWNER TO postgres;

-- Table: public.movies

-- DROP TABLE public.movies;

CREATE TABLE public.movies
(
  id integer NOT NULL,
  movie_name character varying,
  movie_genre character varying,
  CONSTRAINT movie_id_pk PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE public.movies
  OWNER TO postgres;

-- Table: public.user_ratings

-- DROP TABLE public.user_ratings;

CREATE TABLE public.user_ratings
(
  user_id integer NOT NULL,
  movie_id integer NOT NULL,
  rating double precision,
  CONSTRAINT user_movie_id_pk PRIMARY KEY (user_id, movie_id),
  CONSTRAINT movie_id_fk FOREIGN KEY (movie_id)
      REFERENCES public.movies (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT user_id_fk FOREIGN KEY (user_id)
      REFERENCES public."user" (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);
ALTER TABLE public.user_ratings
  OWNER TO postgres;