suspect(Who) :- Who=borya;Who=alex;Who=vitya.
%suspect is required to set what variables we cycle through
%e.g. '?- vityaStBlot(X), boryaStBlot(X).' is always false while
%     '?- boryaStBlot(X), vityaStBlot(X).' is true for X=vitya
% obviously, i could have just swapped order of this functions in
% blot(Who) check, but it seems to be worse solution
alexStBlot(Who) :- Who=borya, not(Who=vitya).
boryaStBlot(Who) :- Who=vitya, not(Who=alex).
vityaStBlot(Who) :- not(Who=borya).
vityaStHW(Who) :- not(Who=vitya).

blot(Who) :- (suspect(Who), alexStBlot(Who), boryaStBlot(Who)).
blot(Who) :- (suspect(Who), vityaStBlot(Who), boryaStBlot(Who)).
blot(Who) :- (suspect(Who), alexStBlot(Who), vityaStBlot(Who)).








