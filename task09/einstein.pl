right(X,State,(X,B,C,D,E)):-State=B.
right(X,State,(A,X,C,D,E)):-State=C.
right(X,State,(A,B,X,D,E)):-State=D.
right(X,State,(A,B,C,X,E)):-State=E.

left(X,State,(A,X,C,D,E)):-State=A.
left(X,State,(A,B,X,D,E)):-State=B.
left(X,State,(A,B,C,X,E)):-State=C.
left(X,State,(A,B,C,D,X)):-State=D.

third(X,(A,B,X,C,D)).
first(X,(X,B,C,D,E)).

neighbour(X,State,States) :- right(X,State,States);left(X,State,States).
houseIs((Cig1,Nation1,Clr1,Drink1,Pet1),(Cig2,Nation2,Clr2,Drink2,Pet2)):-Cig1=Cig2,Nation1=Nation2,Clr1=Clr2,Drink1=Drink2,Pet1=Pet2.
contains((Cig,Nation,Clr,Drink,Pet),(H1,H2,H3,H4,H5)):-
	houseIs((Cig,Nation,Clr,Drink,Pet),H1);
	houseIs((Cig,Nation,Clr,Drink,Pet),H2);
	houseIs((Cig,Nation,Clr,Drink,Pet),H3);
	houseIs((Cig,Nation,Clr,Drink,Pet),H4);
	houseIs((Cig,Nation,Clr,Drink,Pet),H5).
answer(ZebraNation,WaterNation):-
contains((eng,T1,T2,T3,red),Houses),
contains((esp,dog,T4,T5,T6),Houses),
contains((T7,T8,T9,coffee,grn),Houses),
contains((ukr,T10,T11,tea,T12),Houses),
left((T13,T14,T15,T16,grn),(T17,T18,T19,T20,white),Houses),
contains((T21,snail,old,T22,T23),Houses),
contains((T24,T25,kool,T26,yel),Houses),
third((T27,T28,T29,milk,T30),Houses),
first((nor,T31,T32,T33,T34),Houses),
neighbour((T35,T36,chester,T37,T38),(T39,fox,T40,T41,T42),Houses),
neighbour((T43,T44,kool,T45,T46),(T47,horse,T48,T49,T50),Houses),
contains((T51,T52,lucky,juice,T53),Houses),
contains((jap,T54,parliament,T55,T56),Houses),
neighbour((nor,T57,T58,T59,T60),(T61,T62,T63,T64,blue),Houses),
contains((WaterNation,T65,T66,water,T67),Houses),
contains((ZebraNation,zebra,T68,T69,T70),Houses).













