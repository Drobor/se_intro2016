suspect(Who) :- Who=borya;Who=alex;Who=vitya.
%suspect is required to set what variables we cycle through
%e.g. '?- vityaSt(X), boryaSt(X).' is always false while
%     '?- boryaSt(X), vityaSt(X).' is true for X=vitya
% obviously, i could have just swapped order of this functions in
% blot(Who) check, but this seems to be worse solution
alexSt(Who) :- Who=borya, not(Who=vitya).
boryaSt(Who) :- Who=vitya, not(Who=alex).
vityaSt(Who) :- not(Who=borya).
vityaStHW() :- 0=1.

blot(Who) :- (suspect(Who), alexSt(Who), boryaSt(Who)).
blot(Who) :- (suspect(Who), vityaSt(Who), boryaSt(Who)).
blot(Who) :- (suspect(Who), alexSt(Who), vityaSt(Who)).








