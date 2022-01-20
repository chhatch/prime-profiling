// Compiled by ClojureScript 1.10.758 {:target :nodejs}
goog.provide('get_primes.core');
goog.require('cljs.core');
get_primes.core.debug = (function get_primes$core$debug(msg){
return (function (x){
cljs.core.println.call(null,msg,x);

return x;
});
});
get_primes.core.isPrime = (function get_primes$core$isPrime(n){
get_primes.core.debug.call(null,"isPrime Outer").call(null,n);

return cljs.core.reduce.call(null,(function (bool,m){
if(cljs.core._EQ_.call(null,cljs.core.mod.call(null,n,m),(0))){
return false;
} else {
return true;
}
}),false,cljs.core.range.call(null,(0),Math.sqrt(n)));
});
get_primes.core.getPrimes = (function get_primes$core$getPrimes(start,end){
return cljs.core.reduce.call(null,(function (primeList,n){
return cljs.core.reverse.call(null,(function (p1__528_SHARP_){
if(cljs.core.truth_(p1__528_SHARP_)){
return cljs.core.conj.call(null,primeList,n);
} else {
return primeList;
}
}).call(null,get_primes.core.isPrime.call(null,get_primes.core.debug.call(null,"main").call(null,n))));
}),cljs.core.List.EMPTY,cljs.core.range.call(null,start,end));
});
cljs.core.println.call(null,get_primes.core.getPrimes.call(null,(0),(10)));

//# sourceMappingURL=core.js.map
