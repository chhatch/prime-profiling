(ns get-primes.core ; ClojureScript namespace
  (:require [taoensso.tufte :as tufte :refer-macros (defnp p profiled profile)]))

;; We'll request to send `profile` stats to `println`:
(tufte/add-basic-println-handler! {})

(defn isPrime [n] (p ::isP
 (let [rootN  (p ::isP_calc-root (Math/floor (Math/sqrt n)))]
    (p ::isP_reduce (reduce (fn [bool, m]
      (p ::isP_reduce_fn (if (p ::isP_reduce_fn_check-mod-0 (= (mod n m) 0)) (p ::isP_reduce_fn_mod-0 (reduced false)) (p ::isP_reduce_fn_not-mod-0 true))))
      true (p ::isP_reduce_create-range (range 2 rootN)))))))

(defn getPrimes [start end]
  (p ::getPrimes
    (reduce (fn [primeList, n]
        (-> n isPrime (#(if % (conj primeList n) primeList))))
    () (range start end))))

(time (println (count (profile {} (getPrimes 2 1e7))) "primes found"))