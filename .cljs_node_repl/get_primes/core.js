// Compiled by ClojureScript 1.10.758 {:target :nodejs}
goog.provide('get_primes.core');
goog.require('cljs.core');
get_primes.core.isPrime = (function get_primes$core$isPrime(n){
var n__$1 = n;
var m = (2);
var max = Math.sqrt(n__$1);
while(true){
if(cljs.core._EQ_.call(null,cljs.core.mod.call(null,n__$1,m),(0))){
return false;
} else {
if((m > max)){
return true;
} else {
var G__528 = n__$1;
var G__529 = (m + (1));
var G__530 = max;
n__$1 = G__528;
m = G__529;
max = G__530;
continue;
}
}
break;
}
});
get_primes.core.getPrimes = (function get_primes$core$getPrimes(start,end){
return cljs.core.reduce.call(null,(function (primeList,n){
return cljs.core.reverse.call(null,(function (p1__531_SHARP_){
if(cljs.core.truth_(p1__531_SHARP_)){
return cljs.core.conj.call(null,primeList,n);
} else {
return primeList;
}
}).call(null,get_primes.core.isPrime.call(null,n)));
}),cljs.core.List.EMPTY,cljs.core.range.call(null,start,end));
});
var start__4626__auto___532 = cljs.core.system_time.call(null);
var ret__4627__auto___533 = cljs.core.println.call(null,cljs.core.count.call(null,get_primes.core.getPrimes.call(null,(2),(100000))),"primes found");
cljs.core.prn.call(null,["Elapsed time: ",cljs.core.str.cljs$core$IFn$_invoke$arity$1((cljs.core.system_time.call(null) - start__4626__auto___532).toFixed((6)))," msecs"].join(''));


//# sourceMappingURL=core.js.map
