suspect(Who) :- Who=borya;Who=alex;Who=vitya.
%suspect is required to set what variables we cycle through
%e.g. '?- vityaStBlot(X), boryaStBlot(X).' is always false while
%     '?- boryaStBlot(X), vityaStBlot(X).' is true for X=vitya
% obviously, i could have just swapped order of this functions in
% blot(Who) check, but it seems to be worse solution

statement(vitya,blot,first,Who):- not(Who=borya).
statement(vitya,hw,second,Who):- not(Who=vitya).
statement(alex,blot,first,Who):- not(Who=vitya).
statement(alex,blot,second,Who):- Who=borya.
statement(borya,blot,first,Who):- Who=vitya.
statement(borya,blot,second,Who):- not(Who=alex).

exist(X,Y,Z):-suspect(Temp),statement(X,Y,Z,Temp).
skip(X,Y,Z):-not(exist(X,Y,Z)).

chk(Author,Topic,Who) :-(statement(Author,Topic,first,Who);skip(Author,Topic,first)),(statement(Author,Topic,second,Who);skip(Author,Topic,second)).

blot(Who) :- (suspect(Who), chk(alex,blot,Who), chk(borya,blot,Who), not(chk(vitya,blot,Who))).
blot(Who) :- (suspect(Who), chk(vitya,blot,Who), chk(borya,blot,Who), not(chk(alex,blot,Who))).
blot(Who) :- (suspect(Who), chk(alex,blot,Who), chk(vitya,blot,Who), not(chk(borya,blot,Who))).








