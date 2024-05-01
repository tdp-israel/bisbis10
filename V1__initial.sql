--
-- PostgreSQL database dump
--

-- Dumped from database version 16.2 (Debian 16.2-1.pgdg120+2)
-- Dumped by pg_dump version 16.2 (Debian 16.2-1.pgdg120+2)

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- Name: dish; Type: TABLE; Schema: public; Owner: bisbis10
--

CREATE TABLE public.dish (
    id integer NOT NULL,
    description character varying(300),
    name character varying(60),
    price real,
    restaurant_id integer
);


ALTER TABLE public.dish OWNER TO bisbis10;

--
-- Name: dish_id_seq; Type: SEQUENCE; Schema: public; Owner: bisbis10
--

CREATE SEQUENCE public.dish_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.dish_id_seq OWNER TO bisbis10;

--
-- Name: dish_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: bisbis10
--

ALTER SEQUENCE public.dish_id_seq OWNED BY public.dish.id;


--
-- Name: order_item; Type: TABLE; Schema: public; Owner: bisbis10
--

CREATE TABLE public.order_item (
    id integer NOT NULL,
    amount integer,
    dish_id integer,
    order_id uuid
);


ALTER TABLE public.order_item OWNER TO bisbis10;

--
-- Name: order_item_id_seq; Type: SEQUENCE; Schema: public; Owner: bisbis10
--

CREATE SEQUENCE public.order_item_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.order_item_id_seq OWNER TO bisbis10;

--
-- Name: order_item_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: bisbis10
--

ALTER SEQUENCE public.order_item_id_seq OWNED BY public.order_item.id;


--
-- Name: restaurant; Type: TABLE; Schema: public; Owner: bisbis10
--

CREATE TABLE public.restaurant (
    id integer NOT NULL,
    is_kosher boolean,
    name character varying(60)
);


ALTER TABLE public.restaurant OWNER TO bisbis10;

--
-- Name: restaurant_cuisines; Type: TABLE; Schema: public; Owner: bisbis10
--

CREATE TABLE public.restaurant_cuisines (
    restaurant_id integer NOT NULL,
    cuisines character varying(255)
);


ALTER TABLE public.restaurant_cuisines OWNER TO bisbis10;

--
-- Name: restaurant_id_seq; Type: SEQUENCE; Schema: public; Owner: bisbis10
--

CREATE SEQUENCE public.restaurant_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.restaurant_id_seq OWNER TO bisbis10;

--
-- Name: restaurant_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: bisbis10
--

ALTER SEQUENCE public.restaurant_id_seq OWNED BY public.restaurant.id;


--
-- Name: restaurant_order; Type: TABLE; Schema: public; Owner: bisbis10
--

CREATE TABLE public.restaurant_order (
    id uuid NOT NULL,
    restaurant_id integer
);


ALTER TABLE public.restaurant_order OWNER TO bisbis10;

--
-- Name: restaurant_rating; Type: TABLE; Schema: public; Owner: bisbis10
--

CREATE TABLE public.restaurant_rating (
    id integer NOT NULL,
    rating real,
    restaurant_id integer
);


ALTER TABLE public.restaurant_rating OWNER TO bisbis10;

--
-- Name: restaurant_rating_id_seq; Type: SEQUENCE; Schema: public; Owner: bisbis10
--

CREATE SEQUENCE public.restaurant_rating_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.restaurant_rating_id_seq OWNER TO bisbis10;

--
-- Name: restaurant_rating_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: bisbis10
--

ALTER SEQUENCE public.restaurant_rating_id_seq OWNED BY public.restaurant_rating.id;


--
-- Name: task; Type: TABLE; Schema: public; Owner: bisbis10
--

CREATE TABLE public.task (
    description character varying(64) NOT NULL,
    completed character varying(30) NOT NULL
);


ALTER TABLE public.task OWNER TO bisbis10;

--
-- Name: dish id; Type: DEFAULT; Schema: public; Owner: bisbis10
--

ALTER TABLE ONLY public.dish ALTER COLUMN id SET DEFAULT nextval('public.dish_id_seq'::regclass);


--
-- Name: order_item id; Type: DEFAULT; Schema: public; Owner: bisbis10
--

ALTER TABLE ONLY public.order_item ALTER COLUMN id SET DEFAULT nextval('public.order_item_id_seq'::regclass);


--
-- Name: restaurant id; Type: DEFAULT; Schema: public; Owner: bisbis10
--

ALTER TABLE ONLY public.restaurant ALTER COLUMN id SET DEFAULT nextval('public.restaurant_id_seq'::regclass);


--
-- Name: restaurant_rating id; Type: DEFAULT; Schema: public; Owner: bisbis10
--

ALTER TABLE ONLY public.restaurant_rating ALTER COLUMN id SET DEFAULT nextval('public.restaurant_rating_id_seq'::regclass);


--
-- Data for Name: dish; Type: TABLE DATA; Schema: public; Owner: bisbis10
--

COPY public.dish (id, description, name, price, restaurant_id) FROM stdin;
\.


--
-- Data for Name: order_item; Type: TABLE DATA; Schema: public; Owner: bisbis10
--

COPY public.order_item (id, amount, dish_id, order_id) FROM stdin;
\.


--
-- Data for Name: restaurant; Type: TABLE DATA; Schema: public; Owner: bisbis10
--

COPY public.restaurant (id, is_kosher, name) FROM stdin;
1       t       Aromatic Restaurant
2       t       Tender Restaurant
3       f       Tasty Restaurant
4       t       Delicious Restaurant
5       t       Sizzling Restaurant
6       t       Flavorful Restaurant
7       t       Tasty Restaurant
8       t       Zesty Restaurant
9       f       Yummy Restaurant
10      f       Tasty Restaurant
11      t       Flavorful Restaurant
12      t       Tender Restaurant
13      f       Zesty Restaurant
14      t       Satisfying Restaurant
15      t       Mouthwatering Restaurant
16      f       Tangy Restaurant
17      f       Savory Restaurant
18      t       Aromatic Restaurant
19      t       Yummy Restaurant
20      t       Aromatic Restaurant
21      t       Succulent Restaurant
22      f       Flavorful Restaurant
23      f       Tasty Restaurant
24      f       Zesty Restaurant
25      t       Tangy Restaurant
26      f       Tasty Restaurant
27      t       Juicy Restaurant
28      t       Delicious Restaurant
29      t       Yummy Restaurant
30      t       Tangy Restaurant
31      t       Sizzling Restaurant
32      t       Tender Restaurant
33      t       Aromatic Restaurant
34      f       Flavorful Restaurant
35      f       Succulent Restaurant
36      f       Tangy Restaurant
37      t       Delicious Restaurant
38      t       Tangy Restaurant
39      f       Sizzling Restaurant
40      f       Sizzling Restaurant
41      t       Sizzling Restaurant
42      f       Juicy Restaurant
43      t       Juicy Restaurant
44      f       Sizzling Restaurant
45      t       Tender Restaurant
46      f       Aromatic Restaurant
47      t       Satisfying Restaurant
48      t       Hearty Restaurant
49      f       Aromatic Restaurant
50      t       Hearty Restaurant
51      f       Tender Restaurant
52      f       Flavorful Restaurant
53      t       Succulent Restaurant
54      f       Crispy Restaurant
55      f       Crispy Restaurant
56      t       Succulent Restaurant
57      t       Flavorful Restaurant
58      t       Aromatic Restaurant
59      f       Tasty Restaurant
60      t       Tasty Restaurant
61      t       Tangy Restaurant
62      t       Spicy Restaurant
63      f       Spicy Restaurant
64      t       Gourmet Restaurant
65      t       Sizzling Restaurant
66      f       Succulent Restaurant
67      f       Mouthwatering Restaurant
68      t       Delicious Restaurant
69      t       Tangy Restaurant
70      f       Tasty Restaurant
71      f       Tender Restaurant
72      f       Flavorful Restaurant
73      f       Tasty Restaurant
74      f       Zesty Restaurant
75      f       Tender Restaurant
76      f       Sizzling Restaurant
77      f       Aromatic Restaurant
78      t       Succulent Restaurant
79      f       Mouthwatering Restaurant
80      t       Tasty Restaurant
81      t       Yummy Restaurant
82      f       Yummy Restaurant
83      f       Gourmet Restaurant
84      f       Tender Restaurant
85      f       Delicious Restaurant
86      f       Savory Restaurant
87      t       Crispy Restaurant
88      f       Tasty Restaurant
89      f       Tender Restaurant
90      t       Sizzling Restaurant
91      t       Satisfying Restaurant
92      f       Delicious Restaurant
93      t       Flavorful Restaurant
94      f       Tasty Restaurant
95      f       Hearty Restaurant
96      t       Yummy Restaurant
97      t       Hearty Restaurant
98      f       Juicy Restaurant
99      t       Tasty Restaurant
100     t       Yummy Restaurant
\.


--
-- Data for Name: restaurant_cuisines; Type: TABLE DATA; Schema: public; Owner: bisbis10
--

COPY public.restaurant_cuisines (restaurant_id, cuisines) FROM stdin;
1       Chinese
2       Mexican
3       Italian
3       Chinese
4       Chinese
5       Mexican
6       Chinese
6       Indian
6       Japanese
7       Mexican
7       Chinese
7       Thai
8       Chinese
8       Japanese
9       Mexican
9       Italian
9       Japanese
10      Thai
10      Japanese
11      Italian
12      Italian
12      Indian
12      Thai
13      Italian
13      Chinese
13      Japanese
14      Japanese
15      Indian
16      Mexican
16      Chinese
16      Indian
17      Chinese
18      Mexican
19      Thai
20      Indian
21      Indian
22      Italian
23      Mexican
23      Thai
24      Indian
25      Thai
26      Chinese
26      Thai
26      Japanese
27      Mexican
27      Indian
27      Thai
28      Japanese
29      Italian
30      Mexican
30      Thai
31      Italian
31      Chinese
31      Thai
32      Thai
32      Japanese
33      Japanese
34      Indian
34      Thai
35      Italian
36      Chinese
37      Indian
37      Thai
38      Japanese
39      Mexican
39      Italian
39      Chinese
40      Italian
40      Mexican
41      Mexican
42      Chinese
42      Thai
43      Italian
44      Japanese
45      Italian
45      Chinese
45      Japanese
46      Indian
47      Mexican
48      Mexican
49      Indian
50      Japanese
51      Italian
51      Japanese
52      Italian
52      Thai
52      Japanese
53      Thai
53      Japanese
54      Mexican
54      Chinese
54      Thai
55      Mexican
55      Thai
56      Thai
57      Thai
58      Indian
58      Japanese
59      Mexican
59      Chinese
60      Chinese
61      Japanese
62      Indian
62      Thai
63      Chinese
64      Mexican
64      Japanese
65      Indian
65      Japanese
66      Chinese
67      Thai
67      Japanese
68      Indian
69      Chinese
70      Italian
70      Thai
70      Japanese
71      Italian
71      Japanese
72      Mexican
72      Indian
73      Mexican
73      Indian
74      Italian
74      Chinese
74      Thai
75      Indian
75      Chinese
76      Indian
76      Japanese
77      Italian
78      Indian
79      Japanese
80      Japanese
81      Italian
81      Thai
81      Japanese
82      Mexican
82      Japanese
83      Italian
83      Thai
84      Indian
85      Mexican
85      Chinese
86      Italian
86      Mexican
86      Chinese
87      Mexican
87      Indian
87      Thai
88      Mexican
88      Chinese
89      Italian
89      Indian
90      Italian
91      Chinese
91      Japanese
92      Italian
93      Italian
94      Japanese
95      Mexican
96      Indian
96      Chinese
97      Japanese
98      Italian
98      Chinese
99      Indian
99      Chinese
100     Italian
\.


--
-- Data for Name: restaurant_order; Type: TABLE DATA; Schema: public; Owner: bisbis10
--

COPY public.restaurant_order (id, restaurant_id) FROM stdin;
\.


--
-- Data for Name: restaurant_rating; Type: TABLE DATA; Schema: public; Owner: bisbis10
--

COPY public.restaurant_rating (id, rating, restaurant_id) FROM stdin;
\.


--
-- Data for Name: task; Type: TABLE DATA; Schema: public; Owner: bisbis10
--

COPY public.task (description, completed) FROM stdin;
description1    completed
description2    completed
\.


--
-- Name: dish_id_seq; Type: SEQUENCE SET; Schema: public; Owner: bisbis10
--

SELECT pg_catalog.setval('public.dish_id_seq', 1, false);


--
-- Name: order_item_id_seq; Type: SEQUENCE SET; Schema: public; Owner: bisbis10
--

SELECT pg_catalog.setval('public.order_item_id_seq', 1, false);


--
-- Name: restaurant_id_seq; Type: SEQUENCE SET; Schema: public; Owner: bisbis10
--

SELECT pg_catalog.setval('public.restaurant_id_seq', 100, true);


--
-- Name: restaurant_rating_id_seq; Type: SEQUENCE SET; Schema: public; Owner: bisbis10
--

SELECT pg_catalog.setval('public.restaurant_rating_id_seq', 1, false);


--
-- Name: dish dish_pkey; Type: CONSTRAINT; Schema: public; Owner: bisbis10
--

ALTER TABLE ONLY public.dish
    ADD CONSTRAINT dish_pkey PRIMARY KEY (id);


--
-- Name: order_item order_item_pkey; Type: CONSTRAINT; Schema: public; Owner: bisbis10
--

ALTER TABLE ONLY public.order_item
    ADD CONSTRAINT order_item_pkey PRIMARY KEY (id);


--
-- Name: restaurant_order restaurant_order_pkey; Type: CONSTRAINT; Schema: public; Owner: bisbis10
--

ALTER TABLE ONLY public.restaurant_order
    ADD CONSTRAINT restaurant_order_pkey PRIMARY KEY (id);


--
-- Name: restaurant restaurant_pkey; Type: CONSTRAINT; Schema: public; Owner: bisbis10
--

ALTER TABLE ONLY public.restaurant
    ADD CONSTRAINT restaurant_pkey PRIMARY KEY (id);


--
-- Name: restaurant_rating restaurant_rating_pkey; Type: CONSTRAINT; Schema: public; Owner: bisbis10
--

ALTER TABLE ONLY public.restaurant_rating
    ADD CONSTRAINT restaurant_rating_pkey PRIMARY KEY (id);


--
-- Name: restaurant_order fk4a4c6bxp0ww8rtp8dj6cq92i5; Type: FK CONSTRAINT; Schema: public; Owner: bisbis10
--

ALTER TABLE ONLY public.restaurant_order
    ADD CONSTRAINT fk4a4c6bxp0ww8rtp8dj6cq92i5 FOREIGN KEY (restaurant_id) REFERENCES public.restaurant(id);


--
-- Name: order_item fk4w9ve61aad2ywl66a33nu6kq6; Type: FK CONSTRAINT; Schema: public; Owner: bisbis10
--

ALTER TABLE ONLY public.order_item
    ADD CONSTRAINT fk4w9ve61aad2ywl66a33nu6kq6 FOREIGN KEY (order_id) REFERENCES public.restaurant_order(id);


--
-- Name: restaurant_cuisines fk55s0vkme4gxmkeumpwcnba2tc; Type: FK CONSTRAINT; Schema: public; Owner: bisbis10
--

ALTER TABLE ONLY public.restaurant_cuisines
    ADD CONSTRAINT fk55s0vkme4gxmkeumpwcnba2tc FOREIGN KEY (restaurant_id) REFERENCES public.restaurant(id);


--
-- Name: restaurant_rating fk6hw0v7qen03qghm3xpvoimgid; Type: FK CONSTRAINT; Schema: public; Owner: bisbis10
--

ALTER TABLE ONLY public.restaurant_rating
    ADD CONSTRAINT fk6hw0v7qen03qghm3xpvoimgid FOREIGN KEY (restaurant_id) REFERENCES public.restaurant(id);


--
-- Name: order_item fks7aplknkrukmckr29wijlvcy1; Type: FK CONSTRAINT; Schema: public; Owner: bisbis10
--

ALTER TABLE ONLY public.order_item
    ADD CONSTRAINT fks7aplknkrukmckr29wijlvcy1 FOREIGN KEY (dish_id) REFERENCES public.dish(id);


--
-- Name: dish fkt13glsbe9ivpka00hbeg539cv; Type: FK CONSTRAINT; Schema: public; Owner: bisbis10
--

ALTER TABLE ONLY public.dish
    ADD CONSTRAINT fkt13glsbe9ivpka00hbeg539cv FOREIGN KEY (restaurant_id) REFERENCES public.restaurant(id);


--
-- PostgreSQL database dump complete
--